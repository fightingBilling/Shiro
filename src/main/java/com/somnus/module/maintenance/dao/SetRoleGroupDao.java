package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetRoleGroupDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 角色组数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:03 
 * @version V1.0
 */
@MyBatisRepository
public interface SetRoleGroupDao {
	
	/**
	 * @Description 查询所有组
	 * @return
	 */
	List<SetRoleGroup> queryAll();
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param setRoleGroup
	 */
	void insert(SetRoleGroup setRoleGroup);
	
	/**
	 * @Description 根据主键删除记录
	 * @param roleId
	 * @return
	 */
	void deleteByPrimaryKey(BigDecimal rgroupId);
	
	/**
	 * @Description 更新记录
	 * @param setRoleGroup
	 */
	void updateByPrimaryKeySelective(SetRoleGroup setRoleGroup);
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param userId
	 * @return
	 */
	List<SetRoleGroup> queryCandidateResource(BigDecimal userId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param userId
	 * @return
	 */
	List<SetRoleGroup> querySelectedResource(BigDecimal userId);

}
