package com.somnus.module.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @Description 首页控制器
 * @author caobin
 * @date 2013-2-25
 * @version 1.0
 */
public class LoginController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        // 页面存放Key
		return new ModelAndView(getViewName(),RequestContextUtils.getInputFlashMap(request));
	}
	
}
