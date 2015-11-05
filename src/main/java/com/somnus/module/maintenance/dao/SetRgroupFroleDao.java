package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetRgroupFrole;
import com.somnus.module.maintenance.model.SetRgroupFroleKey;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetRgroupFroleDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 功能角色组关系数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:09:45 
 * @version V1.0
 */
@MyBatisRepository
public interface SetRgroupFroleDao {
	
	/**
	 * @Description 插入新记录
	 * @param setRgroupFrole
	 */
	void insert(SetRgroupFrole setRgroupFrole);
	
	/**
	 * @Description 删除当前用户对应的所有菜单记录
	 * @param rgroupId
	 * @return
	 */
	void deleteByGroupId(BigDecimal rgroupId);
	
	/**
	 * @Description 更新记录
	 * @param setRgroupFroleKey
	 */
	void updateByPrimaryKeySelective(SetRgroupFroleKey setRgroupFroleKey);
	
	

}
