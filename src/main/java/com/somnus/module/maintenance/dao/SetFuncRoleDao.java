package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 功能角色数据访问接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface SetFuncRoleDao {
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 * @author zhangbo
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param role
	 * @author zhangbo
	 */
	void insert(SetFuncRole role);
	
	/**
	 * @Description 根据主键删除记录
	 * @param roleId
	 * @return
	 * @author zhangbo
	 */
	void deleteByPrimaryKey(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param role
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetFuncRole role);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncRole> queryAll();
	
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param rgroupId
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncRole> queryCandidateResource(BigDecimal rgroupId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param rgroupId
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncRole> querySelectedResource(BigDecimal rgroupId);

}
