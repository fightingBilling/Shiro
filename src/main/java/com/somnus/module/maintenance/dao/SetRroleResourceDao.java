package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetRroleResourceDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 角色资源数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:15 
 * @version V1.0
 */
@MyBatisRepository
public interface SetRroleResourceDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRroleResource
	 */
	void insert(SetRroleResource setRroleResource);
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param roleId
	 * @return
	 */
	void deleteByRoleId(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param setRroleResource
	 */
	void updateByPrimaryKeySelective(SetRroleResource setRroleResource);

}
