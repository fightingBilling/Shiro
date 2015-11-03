package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.module.maintenance.dao.RoleMenuDao;
import com.somnus.module.maintenance.dao.SetFroleFmenuDao;
import com.somnus.module.maintenance.dao.SetFuncRoleDao;
import com.somnus.module.maintenance.model.RoleMenu;
import com.somnus.module.maintenance.model.SetFroleFmenu;
import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.module.maintenance.service.RoleMenuService;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly=true)
public class RoleMenuServiceImpl implements RoleMenuService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, String> params) {
		// 参数设置
		Map<String, Object> sqlParams = new HashMap<String, Object>();
		sqlParams.put("page", pageable);
		sqlParams.putAll(params);
		// 分页结果集
		List<RoleMenu> list = roleMenuDao.queryPaged(sqlParams);
		// 符合条件的记录总数
		int totalCount = roleMenuDao.queryTotalCount(sqlParams);
		return new PageResponse(list, totalCount);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void create(SetFuncRole role, List<SetFroleFmenu> list) {
		setFuncRoleDao.insert(role);
		for(SetFroleFmenu roleMenu : list){
			setFroleFmenuDao.insert(roleMenu);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void update(SetFuncRole role, List<SetFroleFmenu> list) {
		setFuncRoleDao.updateByPrimaryKeySelective(role);
		setFroleFmenuDao.deleteByRoleId(list.get(0).getFuncRoleId());
		for(SetFroleFmenu roleMenu : list){
			setFroleFmenuDao.insert(roleMenu);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void delete(BigDecimal roleId) {
		setFuncRoleDao.deleteByPrimaryKey(roleId);
		setFroleFmenuDao.deleteByRoleId(roleId);
	}
	
	@Override
	public String queryRoleSeq(){
		return setFuncRoleDao.getSequences();
	}
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
	private SetFroleFmenuDao setFroleFmenuDao;
	@Autowired
	private SetFuncRoleDao setFuncRoleDao;

}
