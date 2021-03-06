package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.dao.SetFuncMenuDao;
import com.somnus.module.maintenance.model.SetFuncMenu;
import com.somnus.module.maintenance.service.SetFuncMenuService;
import com.somnus.support.constant.Constants;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly=true)
@Service
public class SetFuncMenuServiceImpl implements SetFuncMenuService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		//分页结果集
		PageList<SetFuncMenu> pagelist = menuDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	}

	@Transactional(readOnly=false)
	@Override
	public void create(SetFuncMenu menu) {
		if(menu.getPmenuId().compareTo(new BigDecimal(-1)) != 0){
			SetFuncMenu pmenu = new SetFuncMenu();
			pmenu.setMenuId(menu.getPmenuId());
			pmenu.setIsLeaf(Constants.IS_NOT_LEAF);
			menuDao.updateByPrimaryKeySelective(pmenu);
		}
		menuDao.insert(menu);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(SetFuncMenu menu) {
		menuDao.updateByPrimaryKeySelective(menu);
	}

	@Override
	public String querySeq() {
		return menuDao.getSequences();
	}

	@Override
	public List<SetFuncMenu> queryAll() {
		return menuDao.queryAll();
	}

	@Override
	public SetFuncMenu queryById(BigDecimal menuId) {
		return menuDao.selectByPrimaryKey(menuId);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteMenu(Map<String, String> params) {
		menuDao.deleteByMenuCode(params);
	}
	
	@Override
	public List<SetFuncMenu> queryCandidateResource(BigDecimal roleId) {
		return menuDao.queryCandidateResource(roleId);
	}

	@Override
	public List<SetFuncMenu> querySelectedResource(BigDecimal roleId) {
		return menuDao.querySelectedResource(roleId);
	}
	
	
	@Autowired
	private SetFuncMenuDao menuDao;



}
