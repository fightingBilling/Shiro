package com.somnus.module.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.somnus.support.security.MD5Util;

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
		HttpSession session = request.getSession();
		// 密码控件用到session
		String mcrypt_key = MD5Util.init32Key();
        session.setAttribute("mcrypt_key",mcrypt_key);
        // 页面存放Key
		return new ModelAndView(getViewName(), 
		        RequestContextUtils.getInputFlashMap(request)).addObject("mcrypt_key",mcrypt_key);
	}
	
}
