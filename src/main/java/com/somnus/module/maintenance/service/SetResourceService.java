package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetResource;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * 资源Service层接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public interface SetResourceService {
	
	/**
	 * @Description 按条件分页查询资源
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, Object> params);
	
	
	/**
	 * @Description 创建资源
	 * @param resource 
	 */
	void create(SetResource resource);
	
	/**
	 * @Description 更新资源
	 * @param resource 
	 */
	void update(SetResource resource);
	
	/**
	 * @Description 查询Sequences
	 */
	String querySeq();
	

	/**
	 * @Description 查询所有资源记录
	 */
    List<SetResource> queryAll(String urlPattern);
	
	/**
	 * @Description 根据主键查询资源记录
	 * @param resourceId 
	 */
	SetResource queryById(BigDecimal resourceId);
	
	/**
	 * @Description 根据主键删除资源记录
	 * @param menuId 
	 */
	void deleteMenu(BigDecimal resourceId);
	

	/**
	 * @Description 通过资源角色ID查询候选资源
	 * @param resourceRoleId
	 * @return
	 */
    List<SetResource> queryCandidateResource(Map<String, Object> params);
	
	/**
	 * @Description 通过资源角色ID查询已选资源
	 * @param resourceRoleId
	 * @return
	 */
	List<SetResource> querySelectedResource(BigDecimal resourceRoleId);

}
