package com.infy.model;

public class CostCalculator {

	private int packageId;
	private int numberOfPeople;
	private String message=null;
	private double calculatedCost=0.0;
	public double getCalculatedCost() {
		return calculatedCost;
	}
	public void setCalculatedCost(double calculatedCost) {
		this.calculatedCost = calculatedCost;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
}
