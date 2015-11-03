package com.somnus.module.maintenance.model;

/**
 * @Description 用户状态
 * @author Somnus
 * @date 2013-2-5
 * @version 1.0
 */
public enum EShiroUserStatus {
	/**
	 * 正常
	 */
	NORMAL ("1"),
	/**
	 * 禁用
	 */
	FORBIDDEN ("0");
	
	EShiroUserStatus(String code){
		this.code = code;
	}
	
	private final String code;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
