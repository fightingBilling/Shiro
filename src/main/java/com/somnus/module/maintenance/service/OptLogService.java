package com.somnus.module.maintenance.service;

import java.util.List;
import java.util.Map;

import com.somnus.module.maintenance.model.SetOptLog;
import com.somnus.support.web.controller.pagination.Pageable;


/**
 * OptLogService
 *
 * @author levis
 * @version 1.0 15-8-17
 */
public interface OptLogService {


    public void create(SetOptLog OptLog) ;
    
    /**
     * 登录日志查询分页记录
	 * @param pageable
	 * @return 
	 */
    public Pageable queryPaged(Pageable pageable, Map<String, Object> params);
	
	
	 /**
	  * 登录日志csv数据查询
	  * @param params
	  * @return
	  */
	public List<SetOptLog> queryLogByCondition(Map<String, Object> params);
}
