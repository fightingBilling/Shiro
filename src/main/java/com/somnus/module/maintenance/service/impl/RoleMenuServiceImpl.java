package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
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
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		// 分页结果集
		PageList<RoleMenu> pagelist = roleMenuDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
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
