package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * @Description 菜单Service层接口
 * @author Somnus
 * @date 2013-02-28
 * @version 1.0
 */
public interface SetFuncMenuService {
	
	/**
	 * @Description 按条件分页查询菜单
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, Object> params);
	
	
	/**
	 * @Description 创建菜单
	 * @param menu 
	 */
	void create(SetFuncMenu menu);
	
	/**
	 * @Description 更新菜单
	 * @param menu 
	 */
	void update(SetFuncMenu menu);
	
	/**
	 * @Description 查询Sequences
	 */
	String querySeq();
	

	/**
	 * @Description 查询所有菜单记录
	 */
	List<SetFuncMenu> queryAll();
	
	/**
	 * @Description 根据主键查询菜单记录
	 * @param menuId 
	 */
	SetFuncMenu queryById(BigDecimal menuId);
	
	/**
	 * @Description 根据主键删除菜单记录
	 * @param params 
	 */
	void deleteMenu(Map<String, String> params);
	
	
	/**
	 * @Description 通过角色ID查询候选菜单
	 * @param roleId
	 * @return
	 */
	public List<SetFuncMenu> queryCandidateResource(BigDecimal roleId);
	/**
	 * @Description 通过角色ID查询已选菜单
	 * @param roleId
	 * @return
	 */
	public List<SetFuncMenu> querySelectedResource(BigDecimal roleId);

}
