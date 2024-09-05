package com.swiggy.entity;

import java.util.Map;

public class Menu {
	private Integer serialNum;
	private Map<String,Double> menuData;
	private String menuType;
	
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	public Map<String, Double> getMenuData() {
		return menuData;
	}
	public void setMenuData(Map<String, Double> menuData) {
		this.menuData = menuData;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	@Override
	public String toString() {
		return "Menu [serialNum=" + serialNum + ", menu=" + menuData + ", menuType=" + menuType + "]";
	}
	
	
	
}
