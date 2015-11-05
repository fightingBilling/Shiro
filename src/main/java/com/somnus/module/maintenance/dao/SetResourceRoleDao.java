package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetResourceRoleDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 资源角色数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:09:32 
 * @version V1.0
 */
@MyBatisRepository
public interface SetResourceRoleDao {
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param role
	 */
	void insert(SetResourceRole role);
	
	/**
	 * @Description 根据主键删除记录
	 * @param roleId
	 * @return
	 */
	void deleteByPrimaryKey(BigDecimal roleId);
	
	/**
	 * @Description 更新记录
	 * @param role
	 */
	void updateByPrimaryKeySelective(SetResourceRole role);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 */
	List<SetResourceRole> queryAll();
	
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param rgroupId
	 * @return
	 */
	List<SetResourceRole> queryCandidateResource(BigDecimal rgroupId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param rgroupId
	 * @return
	 */
	List<SetResourceRole> querySelectedResource(BigDecimal rgroupId);

}
