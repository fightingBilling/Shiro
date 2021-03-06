package com.somnus.module.maintenance.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.somnus.support.web.controller.BaseController;

/**
 * @Description 未授权跳转
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class UnauthorizedController extends BaseController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return createMAV("errors/403");
	}
}
