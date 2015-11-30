package com.somnus.module.sample.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.sample.model.SampleCity;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

@MyBatisRepository
public interface SampleDao {

	/**
	 * @Description 查询所有城市
	 * @return
	 */
	List<SampleCity> queryAllCities();
	
	/**
	 * @Description 分页查询所有城市
	 * @param params
	 * @return
	 */
	PageList<SampleCity> queryAllCitiesPaged(Map<String, Object> params,PageBounds pageBounds);
	
	
	/**
	 * @Description 通过主键查询一级市
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
