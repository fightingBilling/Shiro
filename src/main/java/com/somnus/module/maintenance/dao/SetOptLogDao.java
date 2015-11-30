package com.somnus.module.maintenance.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.module.maintenance.model.SetOptLog;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

@MyBatisRepository
public interface SetOptLogDao {
    /**
     * 插入操作日志
     *
     * @param optLog
     */
    void insert(SetOptLog optLog);


    
    /**
     * @param 
     * @return 登录日志查询分页记录
     */
    PageList<SetOptLog> queryPaged(Map<String, Object> params,PageBounds pageBounds);
    
    
    /**
	 * @param setOptLogQuery
	 * @return 登录日志csv数据查询
	 */
    List<SetOptLog> queryLogByCondition(Map<String, Object> params);
}
