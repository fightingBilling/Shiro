package com.somnus.module.maintenance.dao;

import java.util.List;

import com.somnus.module.maintenance.model.SFilter;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: ShiroDbDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: Shiro用户数据访问
 * @author Somnus
 * @date 2015年11月5日 下午10:10:48 
 * @version V1.0
 */
@MyBatisRepository
public interface ShiroDbDao {
	
	/**
	 * @Description 通过用户名称查询用户信息
	 * @param username 用户名称
	 * @return
	 */
	SetUser findByUserName(String username);
	
	/**
	 * @Description 通过用户名称查询用户资源权限
	 * @param username 用户名称
	 * @return
	 */
	List<SetResource> findResourceRolesByUserName(String username);
	
	/**
	 * @Description 查询所有过滤器
	 * @return
	 */
	List<SFilter> findAllFilters();

}
