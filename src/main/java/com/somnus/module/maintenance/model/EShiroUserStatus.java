package com.somnus.module.maintenance.model;

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
