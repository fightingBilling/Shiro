package com.somnus.module.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.somnus.support.web.controller.BaseController;

/**
 * 
 * @Title: DefaultController.java 
 * @Package com.somnus.module.defaults.web 
 * @Description: 首页控制器
 * @author Somnus
 * @date 2015年11月5日 下午10:06:44 
 * @version V1.0
 */
public class DefaultController extends BaseController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return createMAV("default");
	}
	
}
