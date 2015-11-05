package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
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
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		// 分页结果集
		PageList<RroleResource> pagelist = roleResourceDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
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
