package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.dao.SetResourceDao;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.service.SetResourceService;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly=true)
@Service
public class SetResourceServiceImpl implements SetResourceService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		//分页结果集
		PageList<SetResource> pagelist = resourceDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	}

	@Transactional(readOnly=false)
	@Override
	public void create(SetResource resource) {
		resource.setSecurityFilter(Constants._securityFilter);
		resourceDao.insert(resource);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(SetResource resource) {
		resourceDao.updateByPrimaryKeySelective(resource);
	}

	@Override
	public String querySeq() {
		return resourceDao.getSequences();
	}

	@Override
    public List<SetResource> queryAll(String urlPattern) {
        return resourceDao.queryAll(urlPattern);
	}

	@Override
	public SetResource queryById(BigDecimal resourceId) {
		return resourceDao.selectByPrimaryKey(resourceId);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteMenu(BigDecimal resourceId) {
		resourceDao.deleteByPrimaryKey(resourceId);
	}

	@Override
    public List<SetResource> queryCandidateResource(Map<String, Object> params) {
        return resourceDao.queryCandidateResource(params);
	}

	@Override
	public List<SetResource> querySelectedResource(BigDecimal resourceRoleId) {
		return resourceDao.querySelectedResource(resourceRoleId);
	}

	
	
	@Autowired
	private SetResourceDao resourceDao;

}
