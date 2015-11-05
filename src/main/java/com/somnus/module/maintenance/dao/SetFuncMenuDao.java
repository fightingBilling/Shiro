package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: SetFuncMenuDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 菜单数据访问接口
 * @author Somnus
 * @date 2015年11月5日 下午10:08:56 
 * @version V1.0
 */
@MyBatisRepository
public interface SetFuncMenuDao {
	
	/**
	 * @Description 插入新记录
	 * @param menu
	 */
	void insert(SetFuncMenu menu);
	
	/**
	 * @Description 更新记录
	 * @param menu
	 */
	void updateByPrimaryKeySelective(SetFuncMenu menu);
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 */
	String getSequences();
	
	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 */
	PageList<SetFuncMenu> queryPaged(Map<String, Object> params,PageBounds pageBounds);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 */
	List<SetFuncMenu> queryAll();
	
	/**
	 * @Description 根据主键查询记录
	 * @param menuId
	 * @return
	 */
	SetFuncMenu selectByPrimaryKey(BigDecimal menuId);
	
	/**
	 * @Description 根据主键删除记录
	 * @param menuId
	 * @return
	 */
	void deleteByPrimaryKey(BigDecimal menuId);
	
	/**
	 * @Description 根据菜单代码删除记录
	 * @param params
	 * @return
	 */
	void deleteByMenuCode(Map<String, String> params);
	
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param funcRoleId
	 * @return
	 */
	List<SetFuncMenu> queryCandidateResource(BigDecimal funcRoleId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param funcRoleId
	 * @return
	 */
	List<SetFuncMenu> querySelectedResource(BigDecimal funcRoleId);

}
