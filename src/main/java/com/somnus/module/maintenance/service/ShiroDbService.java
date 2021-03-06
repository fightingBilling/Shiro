package com.somnus.module.maintenance.service;

import java.util.List;

import com.somnus.module.maintenance.model.SFilter;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.model.SetUser;

/**
 * @Description 
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public interface ShiroDbService {
	/**
	 * @Description 通过用户名称查询用户信息
	 * @param userName 用户名称
	 * @return
	 */
	SetUser findByUserName(String userName);
	
	/**
	 * @Description 通过用户名称查询用户资源权限
	 * @param userName 用户名称
	 * @return
	 */
	List<SetResource> findResourceRolesByUserName(String userName);
	
	/**
	 * @Description 查询所有过滤器
	 * @return
	 */
	List<SFilter> findAllFilters();
}
