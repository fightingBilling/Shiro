package com.somnus.support.web.controller.pagination.impl;

import java.math.BigDecimal;

import com.somnus.support.web.controller.pagination.Pageable;

/**
 * @Description 分页实现-响应
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class PageResponse implements Pageable {
	
	public PageResponse(Object result, Integer count){
		this.result = result;
		this.count = count;
	}

	/**
	 * 批次下发需要
	 * 
	 * @param result
	 * @param count
	 * @param totalAmount
	 */
	public PageResponse(Object result, Integer count, BigDecimal totalAmount) {
		this.result = result;
		this.count = count;
		this.totalAmount = totalAmount;
	}

	@Override
	public Integer getPageStart() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer getPageLimit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer getCount() {
		return count;
	}

	/**
	 * 获取总金额 批次下发需要
	 */
	@Override
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	@Override
	public<RESULTTYPE> RESULTTYPE getResult(Class<RESULTTYPE> resultType) {
		return resultType.cast(result);
	}
	
	//结果集
	private Object result;
	//结果集总数
	private Integer count;

	private BigDecimal totalAmount;
}
