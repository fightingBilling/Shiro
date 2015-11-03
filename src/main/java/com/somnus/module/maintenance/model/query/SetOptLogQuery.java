package com.somnus.module.maintenance.model.query;

import com.somnus.module.maintenance.model.SetOptLog;

public class SetOptLogQuery extends SetOptLog {
	// 起始页
	private Integer pageStart;
	// 单页总量
	private Integer pageLimit;
	// 登录开始日期
	private String dateBegin;
	// 登录结束日期
	private String dateEnd;
	public Integer getPageStart() {
		return pageStart;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	public Integer getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	public String getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
}
