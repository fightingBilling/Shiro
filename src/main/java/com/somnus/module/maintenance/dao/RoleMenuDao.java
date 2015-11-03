package com.somnus.module.maintenance.dao;

import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.RoleMenu;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 功能角色管理数据查询接口
 * @author zhangbo
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface RoleMenuDao {
	
	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 * @author zhangbo
	 */
	List<RoleMenu> queryPaged(Map<String, Object> params);
	
	
	/**
	 * @Description 查询记录总数
	 * @param params
	 * @return
	 * @author zhangbo
	 */
	int queryTotalCount(Map<String, Object> params);

}
