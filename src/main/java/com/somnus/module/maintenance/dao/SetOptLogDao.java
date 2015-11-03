package com.somnus.module.maintenance.dao;

import java.util.List;

import com.somnus.module.maintenance.model.SetOptLog;
import com.somnus.module.maintenance.model.query.SetOptLogQuery;
import com.somnus.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * SetOptLogDao
 *
 * @author levis
 * @version 1.0 15-8-17
 */
@MyBatisRepository
public interface SetOptLogDao {
    /**
     * 插入操作日志
     *
     * @param optLog
     */
    public void insert(SetOptLog optLog);

    /**
     * 查询操作日志-分页
     * @param params
     * @return
     */
   // public List<SetOptLog> queryPaged(Map<String, Object> params);

    /**
     * 查询日志总数
     *
     * @param params
     * @return
     */
   // public int queryTotalCount(Map<String, Object> params);
    
    /**
     * @author shuwang
     * @param 
     * @param setOptLogQuery
     * @return 登录日志查询分页记录
     */
    public List<SetOptLog> getLogByCondition(SetOptLogQuery setOptLogQuery);
    
    /**
     * @author shuwang
     * @param setOptLogQuery
     * @return 获取日志记录总数
     */
    public int getLogCount(SetOptLogQuery setOptLogQuery);
    
    /**
	 * @author shuwang
	 * @param setOptLogQuery
	 * @return 登录日志csv数据查询
	 */
    public List<SetOptLog> getLogByCond(SetOptLogQuery setOptLog);
}
