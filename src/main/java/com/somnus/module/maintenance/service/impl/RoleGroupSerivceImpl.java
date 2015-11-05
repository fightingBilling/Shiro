package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.dao.RoleGroupDao;
import com.somnus.module.maintenance.dao.SetFuncRoleDao;
import com.somnus.module.maintenance.dao.SetResourceRoleDao;
import com.somnus.module.maintenance.dao.SetRgroupFroleDao;
import com.somnus.module.maintenance.dao.SetRgroupRroleDao;
import com.somnus.module.maintenance.dao.SetRoleGroupDao;
import com.somnus.module.maintenance.model.RoleGroup;
import com.somnus.module.maintenance.model.SetFuncRole;
import com.somnus.module.maintenance.model.SetResourceRole;
import com.somnus.module.maintenance.model.SetRgroupFrole;
import com.somnus.module.maintenance.model.SetRgroupRrole;
import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.module.maintenance.service.RoleGroupSerivce;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly=true)
@Service
public class RoleGroupSerivceImpl implements RoleGroupSerivce {

	@Override
	public String queryGroupSeq() {
		return setRoleGroupDao.getSequences();
	}
	
	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		// 分页结果集
		PageList<RoleGroup> pagelist = roleGroupDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	}

	@Transactional(readOnly=false)
	@Override
	public void create(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList) {
		setRoleGroupDao.insert(roleGroup);
		if(frList != null && !frList.isEmpty()){
			for(SetRgroupFrole rgroupf : frList){
				setRgroupFroleDao.insert(rgroupf);
			}
		}
		if(rrList != null && !rrList.isEmpty()){
			for(SetRgroupRrole rgroupr : rrList){
				setRgroupRroleDao.insert(rgroupr);
			}
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void update(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList, BigDecimal rgroupId) {
		setRoleGroupDao.updateByPrimaryKeySelective(roleGroup);
		setRgroupFroleDao.deleteByGroupId(rgroupId);
		setRgroupRroleDao.deleteByGroupId(rgroupId);
		if(frList != null && !frList.isEmpty()){
			for(SetRgroupFrole rgroupf : frList){
				setRgroupFroleDao.insert(rgroupf);
			}
		}
		if(rrList != null && !rrList.isEmpty()){
			for(SetRgroupRrole rgroupr : rrList){
				setRgroupRroleDao.insert(rgroupr);
			}
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void delete(BigDecimal rgroupId) {
		setRoleGroupDao.deleteByPrimaryKey(rgroupId);
		setRgroupFroleDao.deleteByGroupId(rgroupId);
		setRgroupRroleDao.deleteByGroupId(rgroupId);
	}

	@Override
	public List<SetFuncRole> queryFrAll() {
		return setFuncRoleDao.queryAll();
	}

	@Override
	public List<SetResourceRole> queryRrAll() {
		return setResourceRoleDao.queryAll();
	}
	
	
	@Override
	public List<SetFuncRole> queryFCandidateResource(BigDecimal rgroupId) {
		return setFuncRoleDao.queryCandidateResource(rgroupId);
	}
	@Override
	public List<SetFuncRole> queryFSelectedResource(BigDecimal rgroupId) {
		return setFuncRoleDao.querySelectedResource(rgroupId);
	}
	
	@Override
	public List<SetResourceRole> queryRCandidateResource(BigDecimal rgroupId) {
		return setResourceRoleDao.queryCandidateResource(rgroupId);
	}
	@Override
	public List<SetResourceRole> queryRSelectedResource(BigDecimal rgroupId) {
		return setResourceRoleDao.querySelectedResource(rgroupId);
	}
	
	
	@Autowired
	private RoleGroupDao roleGroupDao;
	@Autowired
	private SetRoleGroupDao setRoleGroupDao;
	@Autowired
	private SetRgroupFroleDao setRgroupFroleDao;
	@Autowired
	private SetRgroupRroleDao setRgroupRroleDao;
	@Autowired
	private SetFuncRoleDao setFuncRoleDao;
	@Autowired
	private SetResourceRoleDao setResourceRoleDao;

}
