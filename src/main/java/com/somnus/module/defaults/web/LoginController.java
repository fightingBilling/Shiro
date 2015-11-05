package com.somnus.module.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 
 * @Title: LoginController.java 
 * @Package com.somnus.module.defaults.web 
 * @Description: 首页控制器
 * @author Somnus
 * @date 2015年11月5日 下午10:07:17 
 * @version V1.0
 */
public class LoginController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView(getViewName(),RequestContextUtils.getInputFlashMap(request));
	}
	
}
