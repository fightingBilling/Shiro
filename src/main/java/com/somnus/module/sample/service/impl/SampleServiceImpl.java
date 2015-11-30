package com.somnus.module.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.sample.dao.SampleDao;
import com.somnus.module.sample.model.SampleCity;
import com.somnus.module.sample.service.SampleService;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

@Transactional(readOnly = true)
@Service
public class SampleServiceImpl implements SampleService {
    
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SampleDao sampleDao;

	@Override
	public List<SampleCity> queryAllCities() {
		return sampleDao.queryAllCities();
	}
	
	
	@Override
	public PageResponse queryAllCitiesPaged(Pageable pageable,
			Map<String, Object> params) {
		// 分页结果集
	    PageList<SampleCity> pagelist = sampleDao.queryAllCitiesPaged(params,
                new PageBounds(pageable.getPageStart(), pageable.getPageLimit()));
		return new PageResponse(pagelist, pagelist.getPaginator().getTotalCount());
	}


	@Override
	public List<SampleCity> queryLv1City() {
		return sampleDao.queryLv1City();
	}

	@Override
	public List<SampleCity> queryLv2City(long id) {
		return sampleDao.queryLv2City(id);
	}

	@Override
	public SampleCity queryCityById(long id){
		return sampleDao.queryCityById(id);
	}
	
}
