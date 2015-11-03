package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetRgroupRrole;
import com.somnus.module.maintenance.model.SetRgroupRroleKey;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 资源角色组关系数据访问接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface SetRgroupRroleDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRgroupRrole
	 * @author zhangbo
	 */
	void insert(SetRgroupRrole setRgroupRrole);
	
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param rgroupId
	 * @return
	 * @author zhangbo
	 */
	void deleteByGroupId(BigDecimal rgroupId);
	
	/**
	 * @Description 更新记录
	 * @param setRgroupRroleKey
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetRgroupRroleKey setRgroupRroleKey);
	
	

}
