package com.tyss.warehouse.boot.warehouse.dto;

import org.springframework.stereotype.Component;
@Component
public class AdminDto {
	
	private int adminId;
	private String adminName;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
}
