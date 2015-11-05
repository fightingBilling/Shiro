package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetFroleFmenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetFroleFmenuDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 角色菜单数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:08:45 
 * @version V1.0
 */
@MyBatisRepository
public interface SetFroleFmenuDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRoleMenu
	 */
	void insert(SetFroleFmenu setRoleMenu);
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param roleId
	 * @return
	 */
	void deleteByRoleId(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param setRoleMenu
	 */
	void updateByPrimaryKeySelective(SetFroleFmenu setRoleMenu);

}
