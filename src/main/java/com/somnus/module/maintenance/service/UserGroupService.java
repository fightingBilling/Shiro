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
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public interface UserGroupService {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param pageable 分页对象
	 * @param menu 查询条件
	 * @return
	 */
	public Pageable queryPaged(Pageable pageable,  Map<String, Object> params);
	
	/**
	 * @Description 新增用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 */
	public void create(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 编辑用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 */
	public void update(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 删除用户以及用户组关系
	 * @param userId 用户主键
	 * @return
	 */
	public void delete(BigDecimal userId);
	
	/**
	 * @Description 得到用户主键
	 * @return
	 */
	public String queryUserSeq();

	/**
	 * @Description 查询所有组
	 * @return
	 */
	List<SetRoleGroup> queryAll();
	
	/**
	 * @Description 通过角色ID查询候选角色组
	 * @param rgroupId
	 * @return
	 */
	public List<SetRoleGroup> queryCandidateResource(BigDecimal userId);
	/**
	 * @Description 通过角色ID查询已选角色组
	 * @param rgroupId
	 * @return
	 */
	public List<SetRoleGroup> querySelectedResource(BigDecimal userId);
	
	/**
	 * @Description 根据主键查询用户
	 * @param userId
	 * @return
	 */
	public SetUser queryById(BigDecimal userId);
	
    /**
     * @Description 根据用户名查询记录
     * @param username
     */
    SetUser selectByUsername(String username);

    /**
     * @Description 根据用户名查询记录
     * @param username
     */
    int updatePwd(SetUser user);
}
