package com.somnus.module.maintenance.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * 资源数据访问接口
 * 
 * @author zhangbo 2013-02-28
 * @version 1.0
 */
@MyBatisRepository
public interface SetResourceDao {
	
	/**
	 * @Description 插入新记录
	 * @param resource
	 */
	void insert(SetResource resource);
	
	/**
	 * @Description 更新记录
	 * @param resource
	 */
	void updateByPrimaryKeySelective(SetResource resource);
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 */
	String getSequences();
	

	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 * @author zhangbo
	 */
	PageList<SetResource> queryPaged(Map<String, Object> params,PageBounds pageBounds);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 */
    List<SetResource> queryAll(@Param("urlPattern") String urlPattern);
	
	/**
	 * @Description 根据主键查询记录
	 * @param resourceId
	 * @return
	 */
	SetResource selectByPrimaryKey(BigDecimal resourceId);
	
	/**
	 * @Description 根据主键删除记录
	 * @param resourceId
	 * @return
	 */
	void deleteByPrimaryKey(BigDecimal resourceId);
	
	/**
	 * @Description 通过资源角色ID查询候选资源
	 * @param resourceRoleId
	 * @return
	 */
    List<SetResource> queryCandidateResource(Map<String, Object> params);
	
	/**
	 * @Description 通过资源角色ID查询已选资源
	 * @param resourceRoleId
	 * @return
	 */
	List<SetResource> querySelectedResource(BigDecimal resourceRoleId);

}
