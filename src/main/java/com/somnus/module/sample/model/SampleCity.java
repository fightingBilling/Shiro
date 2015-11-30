package com.somnus.module.sample.model;

import java.io.Serializable;

public class SampleCity implements Serializable {

	private static final long serialVersionUID = -2860008520848073135L;
	
	private long id;
	private String cityName;
	private long parentCity;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the parentCity
	 */
	public long getParentCity() {
		return parentCity;
	}
	/**
	 * @param parentCity the parentCity to set
	 */
	public void setParentCity(long parentCity) {
		this.parentCity = parentCity;
	}
	
}
