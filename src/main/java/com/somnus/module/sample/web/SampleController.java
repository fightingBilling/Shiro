package com.somnus.module.sample.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.module.sample.model.SampleCity;
import com.somnus.module.sample.service.SampleService;
import com.somnus.support.constant.Constants;
import com.somnus.support.util.CSVGenerator;
import com.somnus.support.util.JsonUtils;
import com.somnus.support.web.controller.BaseController;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.PaginatedList;
import com.somnus.support.web.controller.pagination.impl.PageRequest;


/**
 * 样例Controller
 * 
 * @version 1.0
 */
public class SampleController extends BaseController {
	
	/**
	 * @Description webService调用显示页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView sampleWsDisplay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return createMAV("sample/webservice");
	}
	
	/**
	 * @Description 页面组件展示页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView sampleCompsDisplay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//同步级联数据准备
		List<SampleCity> lstCities = sampleService.queryAllCities();

		//分页数据准备
		Pageable pageable = null;	
		
		if(request.getParameter("pageSize") == null){
			Integer start = findIntegerParameterValue(request, Constants._page);
			pageable = new PageRequest(start == null ? 1 : start,Constants.DEFAULT_LIMIT);
		} else {
			pageable = this.findPage(request);
		}
		
		// 查询分页记录
		Pageable result = sampleService.queryAllCitiesPaged(pageable, null);
		
		//执行分页处理
		PaginatedList paginatedList = this.doPaging(result, pageable.getPageStart(), pageable.getPageLimit());
		
		return createMAV("sample/components")
				.addObject("lstCities", JsonUtils.list2JsonString(lstCities))
				.addObject("pageList", paginatedList);
	}

	
	/**
	 * @Description 异步级联
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public void sampleCompsCascadeAsync(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    response.setContentType("text/html;charset=utf-8");
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
		String type = this.findStringParameterValue(request, "_type");
		log.debug("get cascade parameter: {}", new Object[]{type});
		PrintWriter writer = response.getWriter();
		if("parent".equals(type)){
			List<SampleCity> lstCities = sampleService.queryLv1City();
			writer.write(JsonUtils.list2JsonString(lstCities));
		}else if("child".equals(type)){
			List<SampleCity> lstCities = sampleService.
			        queryLv2City(this.findLongParameterValue(request, "_pid"));
			writer.write(JsonUtils.list2JsonString(lstCities));
		}
		IOUtils.closeQuietly(writer);
	}
	
	
	/**
	 * @Description 异步加载Label
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author caobin
	 */
	public void sampleCompsLabelLoad(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    response.setContentType("text/html;charset=utf-8");
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
		long cityId = this.findLongParameterValue(request, "cityId");
		log.debug("get LabelLoad parameter: {}", new Object[]{cityId});
		PrintWriter writer = response.getWriter();		
		SampleCity sampleCity = sampleService.queryCityById(cityId);
		writer.write(JsonUtils.obj2JsonString(sampleCity));		
		IOUtils.closeQuietly(writer);
	}
	
	/**
	 * @Description 查询后台Csv导出
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author caobin
	 */
	public void sampleCsvExport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<String[]> list = new ArrayList<String[]>();
		//数据格式
		list.add(new String[]{"表头1","表头2","表头3","表头4"});
		list.add(new String[]{"11","22","33","44"});
		list.add(new String[]{"55","66","77","88"});
		
		CSVGenerator.generateCsvFile(response, "GBK", list, ',');
	}
	
	/**
	 * @Description 上传文件
	 * @param request
	 * @param response
	 * @param name
	 * @param file
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleFileUpload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartFile file = ((MultipartHttpServletRequest) request)
				.getFile("file");
		if (!file.isEmpty()) {

			byte[] bytes = file.getBytes();
			log.debug(">>>>>>>>>>>FILE LENGTH: {}",
					new Object[] { bytes.length });

			File tmpFile = File.createTempFile("bmps_", null);
			log.info(">>>>>>>>>>>>TEMP FILE PATH: {}",
					new Object[] { tmpFile.getAbsolutePath() });
			OutputStream os = new FileOutputStream(tmpFile);
			IOUtils.write(bytes, os);
			IOUtils.closeQuietly(os);
		} else {
			log.debug(">>>>>>>>>>>EMPTY FILE");
		}

		return createMAV("default").addObject("message",
				"文件上传成功");
	}
	
	
	
	private SampleService sampleService;
	

	/**
	 * @param sampleService the sampleService to set
	 */
	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}

}
