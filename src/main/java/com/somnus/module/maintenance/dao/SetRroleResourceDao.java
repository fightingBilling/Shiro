package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 角色资源数据访问接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface SetRroleResourceDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRroleResource
	 * @author zhangbo
	 */
	void insert(SetRroleResource setRroleResource);
	
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param roleId
	 * @return
	 * @author zhangbo
	 */
	void deleteByRoleId(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param setRroleResource
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetRroleResource setRroleResource);

}
