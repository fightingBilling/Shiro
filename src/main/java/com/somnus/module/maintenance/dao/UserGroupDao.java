package com.somnus.module.maintenance.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.UserGroup;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 
 * @Title: UserGroupDao.java 
 * @Package com.somnus.module.maintenance.dao 
 * @Description: 用户角色组查询数据查询接口
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version V1.0
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
