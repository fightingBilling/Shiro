package com.somnus.module.maintenance.dao;

import java.util.List;

import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

@MyBatisRepository
public interface DefaultDao {
	/**
	 * @Description 查找所有有效菜单
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
