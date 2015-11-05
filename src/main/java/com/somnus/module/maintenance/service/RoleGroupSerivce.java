package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRgroupFrole;
import com.somnus.module.maintenance.model.SetRgroupRrole;
import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * @Description 角色组管理Service层接口
 * @author Somnus
 * @date 2013-03-01
 * @version 1.0
 */
public interface RoleGroupSerivce {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, Object> params);
	
	/**
	 * @Description 新增角色组以及角色组关系
	 * @param roleGroup 组对象
	 * @param frList 功能角色组关系集合
	 * @param rrList 资源角色组关系集合
	 * @return
	 */
	public void create(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList);
	
	/**
	 * @Description 编辑角色组以及角色组关系
	 * @param roleGroup 组对象
	 * @param frList 功能角色组关系集合
	 * @param rrList 资源角色组关系集合
	 * @param rgroupId 角色组主键
	 * @return
	 */
	public void update(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList, BigDecimal rgroupId);
	
	/**
	 * @Description 删除角色组以及角色组关系
	 * @param rgroupId 角色组主键
	 * @return
	 */
	public void delete(BigDecimal rgroupId);
	
	/**
	 * @Description 得到角色主键
	 * @return
	 */
	public String queryGroupSeq();

	/**
	 * @Description 查询所有功能角色
	 * @return
	 */
	List<SetFuncRole> queryFrAll();
	
	/**
	 * @Description 查询所有资源角色
	 * @return
	 */
	List<SetResourceRole> queryRrAll();
	
	/**
	 * @Description 通过角色组ID查询候选功能角色
	 * @param rgroupId
	 * @return
	 */
	public List<SetFuncRole> queryFCandidateResource(BigDecimal rgroupId);
	/**
	 * @Description 通过角色组ID查询已选功能角色
	 * @param rgroupId
	 * @return
	 */
	public List<SetFuncRole> queryFSelectedResource(BigDecimal rgroupId);
	
	/**
	 * @Description 通过角色组ID查询候选资源角色
	 * @param rgroupId
	 * @return
	 */
	public List<SetResourceRole> queryRCandidateResource(BigDecimal rgroupId);
	/**
	 * @Description 通过角色组ID查询已选资源角色
	 * @param rgroupId
	 * @return
	 */
	public List<SetResourceRole> queryRSelectedResource(BigDecimal rgroupId);

}
