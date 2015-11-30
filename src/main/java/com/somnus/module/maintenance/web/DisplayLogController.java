package com.somnus.module.maintenance.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.somnus.module.maintenance.service.OptLogService;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;

public class DisplayLogController extends BaseController {
	
	private OptLogService optLogService;
	
	public void setOptLogService(OptLogService optLogService) {
		this.optLogService = optLogService;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return 资管后台日志查询
	 */
	public ModelAndView optLogQuery(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = createMAV("log/setoptlogview");
		if (isGet(request)) {
            return view;
        }
		String optUserName = this.findStringParameterValue(request, "optUserName");
		Integer status = this.findIntegerParameterValue(request, "status");
		Integer logType = this.findIntegerParameterValue(request, "logType");
		String beginDate = this.findStringParameterValue(request, "beginDate");
		String endDate = this.findStringParameterValue(request, "endDate");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("optUserName", optUserName);
        params.put("status", status);
        params.put("logType", logType);
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        // 分页数据准备
        Pageable pageable = null;
        
        if(request.getParameter(Constants._pageSize) == null){
            Integer start = findIntegerParameterValue(request,Constants._page);
            pageable = new PageRequest(start == null ? 1: start,Constants.DEFAULT_LIMIT);
        } else {
            pageable = this.findPage(request);
        }
        // 查询分页记录
        Pageable result = optLogService.queryPaged(pageable,params);
        // 执行分页处理
        PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(),pageable.getPageLimit());
		
        return view.addObject("pageList", paginatedList);
	}
	
}
