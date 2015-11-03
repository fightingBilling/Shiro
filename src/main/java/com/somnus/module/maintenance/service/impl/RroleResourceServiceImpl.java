package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.module.maintenance.dao.RroleResourceDao;
import com.somnus.module.maintenance.dao.SetResourceRoleDao;
import com.somnus.module.maintenance.dao.SetRroleResourceDao;
import com.somnus.module.maintenance.model.RroleResource;
import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRroleResource;
import com.somnus.module.maintenance.service.RroleResourceService;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;


@Transactional(readOnly=true)
@Service
public class RroleResourceServiceImpl implements RroleResourceService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, String> params) {
		// 参数设置
		Map<String, Object> sqlParams = new HashMap<String, Object>();
		sqlParams.put("page", pageable);
		sqlParams.putAll(params);
		// 分页结果集
		List<RroleResource> list = roleResourceDao.queryPaged(sqlParams);
		// 符合条件的记录总数
		int totalCount = roleResourceDao.queryTotalCount(sqlParams);
		return new PageResponse(list, totalCount);
	}

	@Transactional(readOnly=false)
	@Override
	public void create(SetResourceRole role, List<SetRroleResource> list) {
		setResourceRoleDao.insert(role);
		for(SetRroleResource roleResource : list){
			setRroleResourceDao.insert(roleResource);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void update(SetResourceRole role, List<SetRroleResource> list) {
		setResourceRoleDao.updateByPrimaryKeySelective(role);
		BigDecimal roleId = list.get(0).getResourceRoleId();
		setRroleResourceDao.deleteByRoleId(roleId);
		for(SetRroleResource roleResource : list){
			setRroleResourceDao.insert(roleResource);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void delete(BigDecimal roleId) {
		setResourceRoleDao.deleteByPrimaryKey(roleId);
		setRroleResourceDao.deleteByRoleId(roleId);
	}

	@Override
	public String queryRoleSeq() {
		return setResourceRoleDao.getSequences();
	}
	
	@Autowired
	private RroleResourceDao roleResourceDao;
	@Autowired
	private SetResourceRoleDao setResourceRoleDao;
	@Autowired
	private SetRroleResourceDao setRroleResourceDao;

}
