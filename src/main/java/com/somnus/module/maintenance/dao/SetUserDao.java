package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;

import com.somnus.module.maintenance.model.SetUser;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetUserDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 用户数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:25 
 * @version V1.0
 */
@MyBatisRepository
public interface SetUserDao {
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param user
	 */
	void insert(SetUser user);
	
	/**
	 * @Description 根据主键删除记录
	 * @param userId
	 * @return
	 */
	void deleteByPrimaryKey(BigDecimal userId);
	
	/**
	 * @Description 更新记录
	 * @param user
	 */
    int updateByPrimaryKeySelective(SetUser user);
	
	/**
	 * @Description 根据主键查询记录
	 * @param userId
	 */
	SetUser selectByPrimaryKey(BigDecimal userId);

    /**
     * @Description 根据用户名查询记录
     * @param username
     */
    SetUser selectByUsername(String username);

}
