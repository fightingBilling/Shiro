package com.somnus.support.web.controller.pagination;

import java.math.BigDecimal;

/**
 * @Description 分页接口 
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public interface Pageable {

	/**
	 * @Description 获取起始页索引
	 * @return
	 * @author caobin
	 */
	Integer getPageStart();

	/**
	 * @Description 获取单页显示总量
	 * @return
	 * @author caobin
	 */
	Integer getPageLimit();

	/**
	 * @Description 获取结果总数
	 * @return
	 * @author caobin
	 */
	Integer getCount();


	/**
	 * @Description 获取结果集
	 * @param resultType 结果集类型
	 * @return
	 * @author caobin
	 */
	<RESULTTYPE> RESULTTYPE getResult(Class<RESULTTYPE> resultType);

	/**
	 * 获取总金额 批次下发需要
	 * 
	 * @return
	 */
	BigDecimal getTotalAmount();
}
