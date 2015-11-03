package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetUserRgroup;
import com.somnus.module.maintenance.model.SetUserRgroupKey;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 用户组关系数据访问接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface SetUserRgroupDao {
	
	/**
	 * @Description 插入新记录
	 * @param setUserRgroup
	 * @author zhangbo
	 */
	void insert(SetUserRgroup setUserRgroup);
	
	
	/**
	 * @Description 删除当前用户对应的所有组记录
	 * @param userId
	 * @return
	 * @author zhangbo
	 */
	void deleteByUserId(BigDecimal userId);
	
	/**
	 * @Description 更新记录
	 * @param setRgroupRoleKey
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetUserRgroupKey setUserRgroupKey);
	
	

}
