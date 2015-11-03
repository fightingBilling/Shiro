package com.somnus.support.shiro;

/**
 * @Description shiro动态资源扩展服务
 * @author Somnus
 * @date 2013-2-27
 * @version 1.0
 */
public interface ShiroService{
	
	/**
	 * @Description 动态增加身份验证/角色鉴权过滤器
	 * @param urlPattern
	 * @param roles
	 * @author Somnus
	 */
	void addSecurityFilter(String urlPattern, String[] roles);
	

	/**
	 * @Description 动态删除身份验证/角色鉴权过滤器
	 * @param urlPattern
	 * @author Somnus
	 */
	void deleteSecurityFilter(String urlPattern);
	
}
