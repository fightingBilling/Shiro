package com.somnus.support.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.csvreader.CsvReader;

/**
 * @Description CSV生成
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class CSVGenerator {
	
	public static final char DELIMITER_COMMA_SEPERATED = ',';

	/**
	 * @Description 生成csv
	 * @param response
	 * @param charset
	 * @param list
	 * @param delimiter
	 * @throws Exception
	 * @author Somnus
	 */
	public static void generateCsvFile(HttpServletResponse response, String charset, List<String[]> list, char delimiter)
			throws Exception {
		//设置response头
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename="
				.concat(DateTime.now().toString("yyyyMMddHHmmss")).concat(".csv"));
		OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
		for (String[] strings : list) {
			int length = strings.length;
			for (int i = 0; i < length; i++) {
				writer.append("\"");
				writer.append(strings[i]);
				writer.append("\"");
				if (i < (length - 1)) {
					writer.append(delimiter);
				}
			}
			writer.append('\n');
		}
		writer.flush();
		response.flushBuffer();
		IOUtils.closeQuietly(writer);
	}
	
	/**
	 * @Description 把list转换成可以生成csv的数据格式
	 * @param list
	 * @return
	 * @author Somnus
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String[]> list2StringArray(List<Object> list){
		if(list != null && !list.isEmpty()){
			List<String[]> lstResult = new ArrayList<String[]>();
			for(Object o : list){
				List<Map> lstCells = (List)((Map)o).get("line");
				List<String> lstArray = new ArrayList<String>();
				for(Map cell : lstCells){
					lstArray.add((String)cell.get("cell"));
				}
				lstResult.add(lstArray.toArray(new String[]{}));
			}
			return lstResult;
		}	
		return null;
	}

	public static void main(String[] args) throws IOException {
		CsvReader reader = new CsvReader(new FileReader(
				new File("c:/00124.csv")));
		// reader.readHeaders();
		while (reader.readRecord()) {
			System.out.println(reader.getRawRecord());
			System.out.println(reader.get(7));
			System.out.println(reader.get(9));
			System.out.println(StringUtils.repeat('*', 20));
		}
		// reader.getValues()
		// reader.setDelimiter(',');

		// System.out.println(reader.get(0));
	}
}
