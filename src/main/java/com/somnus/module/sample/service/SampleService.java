package com.somnus.module.sample.service;

import java.util.List;
import java.util.Map;

import com.somnus.module.sample.model.SampleCity;
import com.somnus.support.web.controller.pagination.Pageable;
import com.somnus.support.web.controller.pagination.impl.PageResponse;

public interface SampleService {
	
	/**
	 * @Description 查询所有城市
	 * @return
	 */
	List<SampleCity> queryAllCities();

	/**
	 * @Description 分页查询所有城市
	 * @param pageable
	 * @param params
	 * @return
	 */
	PageResponse queryAllCitiesPaged(Pageable pageable, Map<String, Object> params);
	
	/**
	 * @Description 查询一级市
	 * @return
	 */
	List<SampleCity> queryLv1City();
	
	/**
	 * @Description 通过主键查询二级市
	 * @param id
	 * @return
	 */
	List<SampleCity> queryLv2City(long id);
	
	/**
	 * @Description 通过主键查询城市名称
	 * @param id
	 * @return
	 */
	SampleCity queryCityById(long id);
}
