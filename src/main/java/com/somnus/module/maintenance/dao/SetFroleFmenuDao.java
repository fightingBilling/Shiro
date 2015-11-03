package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetFroleFmenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 角色菜单数据访问接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface SetFroleFmenuDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRoleMenu
	 * @author zhangbo
	 */
	void insert(SetFroleFmenu setRoleMenu);
	
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param roleId
	 * @return
	 * @author zhangbo
	 */
	void deleteByRoleId(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param setRoleMenu
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetFroleFmenu setRoleMenu);
	
	

}
