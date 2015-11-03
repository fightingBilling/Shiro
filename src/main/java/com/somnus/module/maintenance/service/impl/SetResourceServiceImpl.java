package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Pageable queryPaged(Pageable pageable, Map<String, String> params) {
		// 参数设置
		Map<String, Object> sqlParams = new HashMap<String, Object>();
		sqlParams.put("page", pageable);
		sqlParams.putAll(params);
		//分页结果集
		List<SetResource> list = resourceDao.queryPaged(sqlParams);
		//符合条件的记录总数
		int totalCount = resourceDao.queryTotalCount(sqlParams);
		return new PageResponse(list, totalCount);
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
