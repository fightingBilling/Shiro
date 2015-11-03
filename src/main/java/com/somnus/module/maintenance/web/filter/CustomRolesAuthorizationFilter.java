package com.somnus.module.maintenance.web.filter;

import java.util.Map;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

public class CustomRolesAuthorizationFilter extends RolesAuthorizationFilter {
	/**
	 * @Description 获取应用到的路径
	 * @return
	 * @author caobin
	 */
	public Map<String, Object> getAppliedPaths(){
		return this.appliedPaths;
	}
}
