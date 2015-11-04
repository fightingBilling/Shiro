package com.somnus.module.maintenance.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.service.UserGroupService;
import com.somnus.module.maintenance.web.token.CaptchaUsernamePasswordToken;
import com.somnus.support.util.BusinessUtil;
import com.somnus.support.web.controller.BaseController;

/**
 * 身份验证
 * 
 * @author Somnus 2013-2-5
 * @version 1.0
 */
public class AuthenticationController extends BaseController {

	/**
	 * 登录身份验证
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView authenticate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String optIp = request.getRemoteAddr();// 获取登录ip地址
		String logType = "";// 登录类型
		String logDesc = "";// 登录描述
		String strUsername = findStringParameterValue(request,
				usernameParamName);
		String sessionPwd = (String)request.getSession().getAttribute("mcrypt_key");
		String strPassword = BusinessUtil.decryByKey(request.getParameter("hidAccTranPasswd"), sessionPwd);
		String strCaptcha = findStringParameterValue(request,
				captchaParamName);	
		
		Subject objCurrentUser = SecurityUtils.getSubject();
		log.debug("user principal: {}",
				new Object[] { objCurrentUser.getPrincipal() });
		log.debug("user authenticated: {}",
				new Object[] { objCurrentUser.isAuthenticated() });

		if (!objCurrentUser.isAuthenticated()) {
			CaptchaUsernamePasswordToken objToken = new CaptchaUsernamePasswordToken(
					strUsername, strPassword, false, null, strCaptcha);
			try {
				SetUser user = new SetUser();
				user.setUsername(strUsername);
				user = userGroupService.selectByUsername(strUsername);
				if(user != null) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					Date bdate = new Date();
					Date smdate = user.getLastUpdateTime();
					smdate=sdf.parse(sdf.format(smdate));
					bdate=sdf.parse(sdf.format(bdate));
					Calendar cal = Calendar.getInstance();
					cal.setTime(smdate);
					long time1 = cal.getTimeInMillis();
					cal.setTime(bdate);
					long time2 = cal.getTimeInMillis();
					long between_days=(time2-time1)/(1000*3600*24);
					if(Integer.parseInt(String.valueOf(between_days)) > 90) {
						objCurrentUser.login(objToken);
						return createMAV("redirect:/mt/user/user_read.html?opt=updatePwdView").addObject("flag", "true");
					} else {
						objCurrentUser.login(objToken);
					}
				} else {
					objCurrentUser.login(objToken);
				}
			} catch (UnknownAccountException uae) {
				log.error("不存在用户[{}]", new Object[] { objToken.getPrincipal() });
				// 插入日志
				 logType = "27";
				 logDesc = strUsername + "用户名不存在,登录失败";
				throw new UnknownAccountException(String.format("不存在用户[%s]", objToken.getPrincipal()));
			} catch (IncorrectCredentialsException ice) {
				log.error("用户[{}]密码错误",
						new Object[] { objToken.getPrincipal() });
				 logType = "28";
				 logDesc = strUsername + "用户密码错误,登录失败";
				throw new IncorrectCredentialsException(String.format("用户[%s]密码错误", 
				        objToken.getPrincipal()));
			} catch (DisabledAccountException dae) {
				log.error(dae.getMessage(), dae);
				throw new DisabledAccountException(dae.getMessage(), dae);
			}  catch (Throwable t) {
				log.error(t.getMessage(), t);
				throw new AuthenticationException(t.getMessage());
			}

		}
		request.getSession().removeAttribute("mcrypt_key");
		// 已通过身份验证
        return createMAV("redirect:/default.html");
	}

	
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SecurityUtils.getSubject().logout();
		return createMAV("redirect:/login.html");
	}
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private String usernameParamName;
	
	private String captchaParamName;

	public void setUsernameParamName(String usernameParamName) {
		this.usernameParamName = usernameParamName;
	}

	/**
	 * @param captchaParamName the captchaParamName to set
	 */
	public void setCaptchaParamName(String captchaParamName) {
		this.captchaParamName = captchaParamName;
	}


	@Autowired
	UserGroupService userGroupService;

}
