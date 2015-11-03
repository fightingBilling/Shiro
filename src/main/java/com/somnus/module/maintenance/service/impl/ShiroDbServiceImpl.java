package com.somnus.module.maintenance.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.module.maintenance.dao.ShiroDbDao;
import com.somnus.module.maintenance.model.SFilter;
import com.somnus.module.maintenance.model.SetResource;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.service.ShiroDbService;

@Transactional(readOnly = true)
public class ShiroDbServiceImpl implements ShiroDbService {

	private transient Logger log = LoggerFactory.getLogger(ShiroDbServiceImpl.class);
	
	@Autowired
	private ShiroDbDao shiroDbDao;

	@Override
	public SetUser findByUserName(String userName) {
		return shiroDbDao.findByUserName(userName);
	}

	@Override
	public List<SetResource> findResourceRolesByUserName(String userName) {
		return shiroDbDao.findResourceRolesByUserName(userName);
	}

	@Override
	public List<SFilter> findAllFilters() {
		return shiroDbDao.findAllFilters();
	}	
}
