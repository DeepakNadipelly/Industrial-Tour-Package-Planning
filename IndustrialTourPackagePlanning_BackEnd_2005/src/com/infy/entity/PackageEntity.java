package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Package")


public class PackageEntity {
	
	@Id
	private int packageId;
	private String placesIncluded;
	private String location;
	private String packageName;
	private int numberOfDays;
	private double pricePerHead;
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
	
	
	
}
