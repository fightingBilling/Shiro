package com.somnus.module.maintenance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.octo.captcha.service.CaptchaService;
import com.somnus.module.maintenance.model.EShiroUserStatus;
import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.service.DefaultService;
import com.somnus.module.maintenance.service.ShiroDbService;
import com.somnus.module.maintenance.web.token.CaptchaUsernamePasswordToken;
import com.somnus.support.util.MenuUtils;

public class ShiroDbRealm extends AuthorizingRealm {
	
	protected PasswordService passwordService;

	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		
		if(!captchaIgnore){
			boolean bCaptchaCorrect = captchaService.validateResponseForID(
				(String)SecurityUtils.getSubject().getSession().getId(), token.getCaptcha());		
		
			if(!bCaptchaCorrect){
				throw new AuthenticationException(String.format("验证码不匹配[%s]", token.getCaptcha()));
			}
		}else{//忽略验证码，供测试使用
			log.warn("ignore captcha for testing.");
		}
		
		SetUser user = shiroDbService.findByUserName(token.getUsername());
		if (user != null) {
			String menuInfo = null;
			if (EShiroUserStatus.NORMAL.getCode().equals(user.getStatus())) {
				//List<SetFuncMenu> menus = defaultService.findAllMenu();
				List<SetFuncMenu> menus = defaultService.findMenuByUserName(user.getUsername());
				SetFuncMenu root = new SetFuncMenu();
				root.setMenuId(new BigDecimal(-1));
				menuInfo = MenuUtils.generateStaticMenu(menus, root);
				log.trace("authenticated menu with user[{}] : {}", new Object[]{user.getUsername(), menuInfo});
			}else if(EShiroUserStatus.FORBIDDEN.getCode().equals(user.getStatus())){
				throw new DisabledAccountException(String.format("帐号[%s]已禁用", user.getUsername()));
			}
			SecurityUtils.getSubject().logout();
			return new SimpleAuthenticationInfo(new ShiroUser(user.getUsername(), menuInfo), user.getPassword(), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行授权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
		List<SetResource> lstRoles = shiroDbService.findResourceRolesByUserName(shiroUser.getUserName());
		if (lstRoles != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (SetResource role : lstRoles) {
				//基于Role的权限信息
				info.addRole(String.valueOf(role.getResourceId()));
			}
			return info;
		} else {
			return null;
		}
	}


	private ShiroDbService shiroDbService;
	
	private CaptchaService captchaService;
	
	private boolean captchaIgnore;

	public void setCaptchaService(CaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	public void setCaptchaIgnore(boolean captchaIgnore) {
		this.captchaIgnore = captchaIgnore;
	}

	public void setShiroDbService(ShiroDbService shiroDbService) {
		this.shiroDbService = shiroDbService;
	}

	public static class HashPassword {
		public String salt;
		public String password;

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
	}
	
	private DefaultService defaultService;

	/**
	 * @param defaultService the defaultService to set
	 */
	public void setDefaultService(DefaultService defaultService) {
		this.defaultService = defaultService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = 6572019817165264564L;
		
		private String userName;
		
		private String menuInfo;

		public ShiroUser(String userName, String menuInfo) {
			this.userName = userName;
			this.menuInfo = menuInfo;
		}
	
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		

		/**
		 * @return the menuInfo
		 */
		public String getMenuInfo() {
			return menuInfo;
		}

		/**
		 * @param menuInfo the menuInfo to set
		 */
		public void setMenuInfo(String menuInfo) {
			this.menuInfo = menuInfo;
		}

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
	}

}
