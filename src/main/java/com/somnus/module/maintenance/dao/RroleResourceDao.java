package com.somnus.module.maintenance.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.RroleResource;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 资源角色管理数据查询接口
 * @author Somnus
 * @date 2013-03-01
 * @version 1.0
 */
@MyBatisRepository
public interface RroleResourceDao {
	
	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 */
	PageList<RroleResource> queryPaged(Map<String, Object> params,PageBounds pageBounds);

}
