package com.somnus.module.maintenance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.module.maintenance.dao.DefaultDao;
import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.module.maintenance.service.DefaultService;

@Transactional(readOnly = true)
public class DefaultServiceImpl implements DefaultService {

	@Autowired
	private DefaultDao defaultDao;

	@Override
	public List<SetFuncMenu> findAllMenu() {
		return defaultDao.findAllMenu();
	}

	@Override
	public List<SetFuncMenu> findMenuByUserName(String username) {
		return defaultDao.findMenuByUserName(username);
	}
}
