package com.somnus.module.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.somnus.support.web.controller.BaseController;

/**
 * @Description 首页控制器
 * @author caobin
 * @date 2013-2-25
 * @version 1.0
 */
public class DefaultController extends BaseController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return createMAV("default");
	}
	
}
