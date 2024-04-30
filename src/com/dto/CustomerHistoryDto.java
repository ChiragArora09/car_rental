package com.dto;

// THIS MODEL IS USED TO DISPLAY THE COMPLETED DEAL OF THE CUSTOMERS IN THE CUSTOMER CONTROLLER
public class CustomerHistoryDto {
	private String vehicleName;
	private double finalAmount;
	private double discount;
	private String damageReported;
	
	public CustomerHistoryDto(String vehicleName, double finalAmount, double discount, String damageReported) {
		super();
		this.vehicleName = vehicleName;
		this.finalAmount = finalAmount;
		this.discount = discount;
		this.damageReported = damageReported;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDamageReported() {
		return damageReported;
	}

	public void setDamageReported(String damageReported) {
		this.damageReported = damageReported;
	}

}
