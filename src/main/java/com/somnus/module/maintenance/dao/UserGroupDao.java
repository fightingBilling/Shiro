package com.somnus.module.maintenance.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.UserGroup;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 用户角色组查询数据查询接口
 * @author Somnus
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface UserGroupDao {
	
	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 */
	PageList<UserGroup> queryPaged(Map<String, Object> params,PageBounds pageBounds);

}
