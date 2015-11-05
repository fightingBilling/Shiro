package com.somnus.module.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.dao.SetRoleGroupDao;
import com.somnus.module.maintenance.dao.SetUserDao;
import com.somnus.module.maintenance.dao.SetUserRgroupDao;
import com.somnus.module.maintenance.dao.UserGroupDao;
import com.somnus.module.maintenance.model.SetRoleGroup;
import com.somnus.module.maintenance.model.SetUser;
import com.somnus.module.maintenance.model.SetUserRgroup;
import com.somnus.module.maintenance.model.UserGroup;
import com.somnus.module.maintenance.service.UserGroupService;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly=true)
@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		// 分页结果集
		PageList<UserGroup> pagelist = userGroupDao.queryPaged(params,
				new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	}

	@Transactional(readOnly=false)
	@Override
	public void create(SetUser user, List<SetUserRgroup> list) {
		setUserDao.insert(user);
		for(SetUserRgroup userRgroup : list){
			setUserRgroupDao.insert(userRgroup);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void update(SetUser user, List<SetUserRgroup> list) {
		setUserDao.updateByPrimaryKeySelective(user);
		BigDecimal userId = list.get(0).getUserId();
		setUserRgroupDao.deleteByUserId(userId);
		for(SetUserRgroup userRgroup : list){
			setUserRgroupDao.insert(userRgroup);
		}
	}
	
	@Transactional(readOnly=false)
	@Override
	public void delete(BigDecimal userId) {
		setUserDao.deleteByPrimaryKey(userId);
		setUserRgroupDao.deleteByUserId(userId);
	}

	@Override
	public String queryUserSeq() {
		return setUserDao.getSequences();
	}

	@Override
	public List<SetRoleGroup> queryAll() {
		return setRoleGroupDao.queryAll();
	}
	
	public SetUser queryById(BigDecimal userId) {
		return setUserDao.selectByPrimaryKey(userId);
	}
	
	
	@Override
	public List<SetRoleGroup> queryCandidateResource(BigDecimal userId) {
		return setRoleGroupDao.queryCandidateResource(userId);
	}
	@Override
	public List<SetRoleGroup> querySelectedResource(BigDecimal userId) {
		return setRoleGroupDao.querySelectedResource(userId);
	}
	
    @Override
    public SetUser selectByUsername(String username) {
        return setUserDao.selectByUsername(username);
    }

    @Override
    public int updatePwd(SetUser user) {
        return setUserDao.updateByPrimaryKeySelective(user);
    }

	@Autowired
	private UserGroupDao userGroupDao;
	@Autowired
	private SetUserDao setUserDao;
	@Autowired
	private SetUserRgroupDao setUserRgroupDao;
	@Autowired
	private SetRoleGroupDao setRoleGroupDao;


}
