package com.somnus.support.web.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;

import com.somnus.support.exception.SysRuntimeException;
import com.somnus.support.web.controller.pagination.CustomPaginatedList;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;

/**
 * @Description 控制器基类
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public abstract class BaseController extends MultiActionController{
	
	protected void toSuccess(HttpServletResponse response) throws IOException{
		response.getWriter().write("{success:true}");
	}

	/**
	 * @Description 创建ModelAndView实例
	 * @return
	 * @author Somnus
	 */
	protected ModelAndView createMAV() {
		return new ModelAndView();
	}

	/**
	 * @Description 创建带有试图名称的ModelAndView实例
	 * @param viewName
	 * @return
	 * @author Somnus
	 */
	protected ModelAndView createMAV(String viewName) {
		return new ModelAndView(viewName);
	}
	
	

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		
		//扩展日期绑定
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
		    public void setAsText(String value) {
		        try {		        	
		            setValue(DateUtils.parseDate(value, candidateDatePatterns));
		        } catch(ParseException e) {
		        	log.error(e.getMessage());
		            setValue(null);
		        }
		    }

		    public String getAsText() {
		        return String.valueOf(getValue());
		    }        

		});
	}

	/**
	 * @Description  通过请求参数绑定Model
	 * @param request
	 * @param clazz 绑定类
	 * @return
	 * @throws Exception
	 * @author Somnus
	 */
	protected <T> T bindModel(HttpServletRequest request, Class<T> clazz)
			throws Exception {
		T object = (T) newCommandObject(clazz);
		bind(request, object);
		return object;
	}


	/**
	 * @Description 获取分页信息
	 * @param request
	 * @return
	 * @author Somnus
	 */
	protected Pageable findPage(HttpServletRequest request){		
		return findPage(request, PAGE_PARAM_START, PAGE_PARAM_LIMIT);
	}

	/**
	 * @Description 获取分页信息
	 * @param request
	 * @param pageFieldName 起始页字段名称
	 * @param pageSizeFieldName 单页总量字段名称
	 * @return
	 * @author Somnus
	 */
	protected Pageable findPage(HttpServletRequest request, String pageFieldName, String pageSizeFieldName){
		Validate.notBlank(pageFieldName, "page field name required");
		Validate.notBlank(pageSizeFieldName, "pageSize field name required");
		Integer start = findIntegerParameterValue(request, pageFieldName);
		Integer limit = findIntegerParameterValue(request, pageSizeFieldName);
		if(limit == null){
			throw new SysRuntimeException("pageSize is required");
		}
		//限制pageSize <= 100
		if(limit > 100){
			log.warn("pageSize must be less than 100");
			limit = 100;
		};
		return new PageRequest(
				start == null ? 1 : start,
				limit	
		);
	}
	
	/**
	 * @Description 执行分页处理
	 * @param pageable 分页结果
	 * @param start
	 * @param limit
	 * @return
	 * @author Somnus
	 */
	protected PaginatedList doPaging(Pageable pageable, int start, int limit){
		  // 分页获取记录  
	    int pageNumber = start;
	      
	    CustomPaginatedList pageList = new CustomPaginatedList();  

	    // 设置当前页数  
	    pageList.setPageNumber(pageNumber);  
	    // 设置当前页列表  
	    pageList.setList(pageable.getResult(List.class));  
	    // 设置page size  
	    pageList.setObjectsPerPage(limit);  
	    // 设置总页数  
	    pageList.setFullListSize(pageable.getCount());  

	    return pageList;
	}
	
	/**
	 * @Description 执行分页处理
	 * @param request
	 * @param pageable 分页结果
	 * @return 
	 * @author Somnus
	 */
	protected PaginatedList doPaging(HttpServletRequest request, Pageable pageable){
	    // 分页获取记录  
	    int pageNumber;  
	    if (StringUtils.isNotBlank(request.getParameter(PAGE_PARAM_START))) {  
	        pageNumber = findIntegerParameterValue(request, PAGE_PARAM_START);
	    } else {  
	        pageNumber = 1;  
	    }  
	      
	    CustomPaginatedList pageList = new CustomPaginatedList();  

	    // 设置当前页数  
	    pageList.setPageNumber(pageNumber);  
	    // 设置当前页列表  
	    pageList.setList(pageable.getResult(List.class));  
	    // 设置page size  
	    pageList.setObjectsPerPage(this.findIntegerParameterValue(request, PAGE_PARAM_LIMIT));  
	    // 设置总页数  
	    pageList.setFullListSize(pageable.getCount());  
	   
	    return pageList;
	}

	/**
	 * @Description 从请求中获取Integer类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author Somnus
	 */
	protected Integer findIntegerParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : Integer.parseInt(pv);
	}

	/**
	 * @Description 从请求中获取Long类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author Somnus
	 */
	protected Long findLongParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : Long.parseLong(pv);
	}
	
	/**
	 * @Description 从请求中获取BigDecimal类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author Somnus
	 */
	protected BigDecimal findBigDecimalParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : new BigDecimal(pv);
	}

	/**
	 * @Description 从请求中获取String类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author Somnus
	 */
	protected String findStringParameterValue(HttpServletRequest request,
			String name) {
		return WebUtils.findParameterValue(request, name);
	}

	/**
	 * @Description 从请求中获取Boolean类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author Somnus
	 */
	protected Boolean findBooleanParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : Boolean.parseBoolean(pv);
	}

	/**
	 * @Description 从请求中获取Date类型参数
	 * @param request
	 * @param name 参数名称
	 * @param datePattern 日期模式
	 * @return
	 * @throws ParseException
	 * @author Somnus
	 */
	protected Date findDateParameterValue(HttpServletRequest request,
			String name, String datePattern) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : dateFormat.parse(WebUtils.findParameterValue(request, name));
	}

	
	/**
	 * 分页请求起始参数
	 */
	protected final String PAGE_PARAM_START = "page";
	
	/**
	 * 每页显示数量
	 */
	protected final String PAGE_PARAM_LIMIT = "pageSize";

	/**
	 * 候选日期模式
	 */
	private String[] candidateDatePatterns;
	
	/**
	 * 消息资源访问器
	 * */
	protected MessageSourceAccessor msa;
	
	public void setMsa(MessageSourceAccessor msa) {
		this.msa = msa;
	}

	public void setCandidateDatePatterns(String[] candidateDatePatterns) {
		this.candidateDatePatterns = candidateDatePatterns;
	}

	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
}
