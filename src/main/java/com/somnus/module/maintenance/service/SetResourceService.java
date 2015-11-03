package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetResource;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * 资源Service层接口
 * 
 * @author zhangbo 2013-02-28
 * @version 1.0
 */
public interface SetResourceService {
	
	/**
	 * @Description 按条件分页查询资源
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 * @author zhangbo
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, String> params);
	
	
	/**
	 * @Description 创建资源
	 * @param resource 
	 * @author zhangbo
	 */
	void create(SetResource resource);
	
	/**
	 * @Description 更新资源
	 * @param resource 
	 * @author zhangbo
	 */
	void update(SetResource resource);
	
	/**
	 * @Description 查询Sequences
	 * @author zhangbo
	 */
	String querySeq();
	

	/**
	 * @Description 查询所有资源记录
	 * @author zhangbo
	 */
    List<SetResource> queryAll(String urlPattern);
	
	/**
	 * @Description 根据主键查询资源记录
	 * @param resourceId 
	 * @author zhangbo
	 */
	SetResource queryById(BigDecimal resourceId);
	
	/**
	 * @Description 根据主键删除资源记录
	 * @param menuId 
	 * @author zhangbo
	 */
	void deleteMenu(BigDecimal resourceId);
	

	/**
	 * @Description 通过资源角色ID查询候选资源
	 * @param resourceRoleId
	 * @return
	 * @author Somnus
	 */
    List<SetResource> queryCandidateResource(Map<String, Object> params);
	
	/**
	 * @Description 通过资源角色ID查询已选资源
	 * @param resourceRoleId
	 * @return
	 * @author Somnus
	 */
	List<SetResource> querySelectedResource(BigDecimal resourceRoleId);

}
