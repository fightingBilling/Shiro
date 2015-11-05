package com.somnus.support.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somnus.support.util.CSVGenerator;
import com.somnus.support.util.JsonUtils;

/**
 * @Description csv导出
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class CsvExportController extends BaseController {

	/**
	 * @Description csv当页导出(下载)
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author Somnus
	 */
	public void csvExport(HttpServletRequest request,
		HttpServletResponse response) throws Exception{
		//获取参数
		String charset = this.findStringParameterValue(request, "charset");
		String csvdata = this.findStringParameterValue(request, "csvdata");
		List<Object> datalist = JsonUtils.jsonString2Object(csvdata, ArrayList.class);	
		//输出csv到response
		CSVGenerator.generateCsvFile(response, charset, CSVGenerator.list2StringArray(datalist), ',');		
	}
}
