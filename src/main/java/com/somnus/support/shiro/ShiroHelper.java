package com.somnus.support.shiro;

import org.apache.shiro.SecurityUtils;

import com.somnus.module.maintenance.ShiroDbRealm.ShiroUser;


/**
 * @Description shiro框架帮助类
 * @author caobin
 * @date 2013-3-21
 * @version 1.0
 */
public class ShiroHelper {
	
	/**
	 * @Description 获取当前登录用户名称
	 * @return
	 * @author caobin
	 */
	public static String getUsername(){
		ShiroUser su = ShiroUser.class.cast(SecurityUtils.getSubject().getPrincipal());
		return su == null ? null : su.getUserName();
	}
	
	/**
	 * @Description 判断是否拥有角色
	 * @param resourceid 资源ID
	 * @return
	 */
	public static boolean hasRole(String resourceid){
		return SecurityUtils.getSubject().hasRole(resourceid);
	}
}
