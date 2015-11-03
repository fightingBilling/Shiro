package com.somnus.module.maintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.model.SetUserRgroup;
import com.somnus.support.web.controller.pagination.Pageable;

/**
 * 用户组管理Service层接口
 * 
 * @author zhangbo 2013-03-01
 * @version 1.0
 */
public interface UserGroupService {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 * @author zhangbo
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, String> params);
	
	/**
	 * @Description 新增用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 * @author zhangbo
	 */
	public void create(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 编辑用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 * @author zhangbo
	 */
	public void update(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 删除用户以及用户组关系
	 * @param userId 用户主键
	 * @return
	 * @author zhangbo
	 */
	public void delete(BigDecimal userId);
	
	/**
	 * @Description 得到用户主键
	 * @return
	 * @author zhangbo
	 */
	public String queryUserSeq();

	/**
	 * @Description 查询所有组
	 * @return
	 * @author zhangbo
	 */
	List<SetRoleGroup> queryAll();
	
	/**
	 * @Description 通过角色ID查询候选角色组
	 * @param rgroupId
	 * @return
	 * @author zhangbo
	 */
	public List<SetRoleGroup> queryCandidateResource(BigDecimal userId);
	/**
	 * @Description 通过角色ID查询已选角色组
	 * @param rgroupId
	 * @return
	 * @author zhangbo
	 */
	public List<SetRoleGroup> querySelectedResource(BigDecimal userId);
	
	/**
	 * @Description 根据主键查询用户
	 * @param userId
	 * @return
	 * @author zhangbo
	 */
	public SetUser queryById(BigDecimal userId);
	
    /**
     * @Description 根据用户名查询记录
     * @param username
     * @author zhangbo
     */
    SetUser selectByUsername(String username);

    /**
     * @Description 根据用户名查询记录
     * @param username
     * @author zhangbo
     */
    int updatePwd(SetUser user);
}
