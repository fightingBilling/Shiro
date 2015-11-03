package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * @Description 资源角色管理Service层接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
public interface RroleResourceService {
	
	/**
	 * @Description 按条件分页查询结算资源
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 * @author zhangbo
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, String> params);
	
	/**
	 * @Description 新增角色以及用户资源关系
	 * @param role 角色对象
	 * @param list 角色资源关系集合
	 * @return
	 * @author zhangbo
	 */
	public void create(SetResourceRole role, List<SetRroleResource> list);
	
	/**
	 * @Description 编辑角色以及用户资源关系
	 * @param role 角色对象
	 * @param list 角色资源关系集合
	 * @return
	 * @author zhangbo
	 */
	public void update(SetResourceRole role, List<SetRroleResource> list);
	
	/**
	 * @Description 删除角色以及用户资源关系
	 * @param roleId 角色对象主键
	 * @return
	 * @author zhangbo
	 */
	public void delete(BigDecimal roleId);
	
	/**
	 * @Description 得到角色主键
	 * @return
	 * @author zhangbo
	 */
	public String queryRoleSeq();

}
