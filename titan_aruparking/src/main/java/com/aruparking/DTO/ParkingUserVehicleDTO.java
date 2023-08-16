package com.aruparking.DTO;

import java.util.Date;

import com.aruparking.model.ParkingUser;

public class ParkingUserVehicleDTO {
	private long id;
	private String vehicleNo;
	private String vehicleName;
	private boolean defaultVehicle;
	private boolean favVehicle;
	private int status;
	private Date createdOn;
	private Date lastUpdatedOn;
	private long userId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public boolean isDefaultVehicle() {
		return defaultVehicle;
	}
	public void setDefaultVehicle(boolean defaultVehicle) {
		this.defaultVehicle = defaultVehicle;
	}
	public boolean isFavVehicle() {
		return favVehicle;
	}
	public void setFavVehicle(boolean favVehicle) {
		this.favVehicle = favVehicle;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	

}
