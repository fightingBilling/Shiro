package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * @Description 资源角色管理Service层接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public interface RroleResourceService {
	
	/**
	 * @Description 按条件分页查询结算资源
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, Object> params);
	
	/**
	 * @Description 新增角色以及用户资源关系
	 * @param role 角色对象
	 * @param list 角色资源关系集合
	 * @return
	 */
	public void create(SetResourceRole role, List<SetRroleResource> list);
	
	/**
	 * @Description 编辑角色以及用户资源关系
	 * @param role 角色对象
	 * @param list 角色资源关系集合
	 * @return
	 */
	public void update(SetResourceRole role, List<SetRroleResource> list);
	
	/**
	 * @Description 删除角色以及用户资源关系
	 * @param roleId 角色对象主键
	 * @return
	 */
	public void delete(BigDecimal roleId);
	
	/**
	 * @Description 得到角色主键
	 * @return
	 */
	public String queryRoleSeq();

}
