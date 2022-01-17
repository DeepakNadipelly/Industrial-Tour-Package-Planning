package com.infy.model;

public class Package {
	private int packageId;
	private String placesIncluded;
	private String location;
	private String packageName;
	private int numberOfDays;
	private double pricePerHead;
	private String message;
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPlacesIncluded() {
		return placesIncluded;
	}
	public void setPlacesIncluded(String placesIncluded) {
		this.placesIncluded = placesIncluded;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public double getPricePerHead() {
		return pricePerHead;
	}
	public void setPricePerHead(double pricePerHead) {
		this.pricePerHead = pricePerHead;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
