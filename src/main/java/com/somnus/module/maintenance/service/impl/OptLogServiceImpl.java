package com.somnus.module.maintenance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.dao.SetOptLogDao;
import com.somnus.module.maintenance.model.SetOptLog;
import com.somnus.module.maintenance.service.OptLogService;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

import java.util.List;
import java.util.Map;

@Service
public class OptLogServiceImpl implements OptLogService{


    @Transactional(readOnly=false)
    @Override
    public void create(SetOptLog optLog) {
        optLogDao.insert(optLog);
    }

    @Autowired
    private SetOptLogDao optLogDao;

	@Override
	public Pageable queryPaged(Pageable pageable, Map<String, Object> params) {
		
		// 分页结果集
        PageList<SetOptLog> pagelist = optLogDao.queryPaged(params,
                new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
        return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	
	}

	@Override
	public List<SetOptLog> queryLogByCondition(Map<String, Object> params) {
		return optLogDao.queryLogByCondition(params);
	}
}
