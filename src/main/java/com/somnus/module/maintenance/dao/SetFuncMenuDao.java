package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 菜单数据访问接口
 * @author zhangbo
 * @date 2013-02-28
 * @version 1.0
 */
@MyBatisRepository
public interface SetFuncMenuDao {
	
	/**
	 * @Description 插入新记录
	 * @param menu
	 * @author zhangbo
	 */
	void insert(SetFuncMenu menu);
	
	/**
	 * @Description 更新记录
	 * @param menu
	 * @author zhangbo
	 */
	void updateByPrimaryKeySelective(SetFuncMenu menu);
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 * @author zhangbo
	 */
	String getSequences();
	
	

	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 * @author zhangbo
	 */
	List<SetFuncMenu> queryPaged(Map<String, Object> params);
	
	
	/**
	 * @Description 查询记录总数
	 * @param params
	 * @return
	 * @author zhangbo
	 */
	int queryTotalCount(Map<String, Object> params);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncMenu> queryAll();
	
	/**
	 * @Description 根据主键查询记录
	 * @param menuId
	 * @return
	 * @author zhangbo
	 */
	SetFuncMenu selectByPrimaryKey(BigDecimal menuId);
	
	/**
	 * @Description 根据主键删除记录
	 * @param menuId
	 * @return
	 * @author zhangbo
	 */
	void deleteByPrimaryKey(BigDecimal menuId);
	
	/**
	 * @Description 根据菜单代码删除记录
	 * @param params
	 * @return
	 * @author zhangbo
	 */
	void deleteByMenuCode(Map<String, String> params);
	
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param funcRoleId
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncMenu> queryCandidateResource(BigDecimal funcRoleId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param funcRoleId
	 * @return
	 * @author zhangbo
	 */
	List<SetFuncMenu> querySelectedResource(BigDecimal funcRoleId);

}
