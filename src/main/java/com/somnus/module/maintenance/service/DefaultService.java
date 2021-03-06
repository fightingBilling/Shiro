package com.somnus.module.maintenance.service;

import java.util.List;

import com.somnus.module.maintenance.model.SetFuncMenu;

/**
 * @Description 
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public interface DefaultService {
	/**
	 * @Description 获取所有有效菜单
	 * @return
	 */
	List<SetFuncMenu> findAllMenu();
	
	/**
	 * @Description 通过用户名称查找有效菜单
	 * @param username
	 * @return
	 */
	List<SetFuncMenu> findMenuByUserName(String username);
}
