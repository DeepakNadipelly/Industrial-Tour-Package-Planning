package com.infy.service;

import java.util.List;

import com.infy.model.CostCalculator;
import com.infy.model.Admin;
import com.infy.model.Booking;
import com.infy.model.Feedback;
import com.infy.model.ForgotPassword;
import com.infy.model.ForgotPasswordAdmin;
import com.infy.model.Package;
import com.infy.model.Payment;
import com.infy.model.User;

public interface IndustrialTourService {

	public Double calculateCost(CostCalculator cc) throws Exception;
	
	public User getUserDetails(User user) throws Exception;
	
	public List<Package> displayPackageDetails() throws Exception;
	
	public User collectUserDetails(User user) throws Exception;

	public User forgotPassword(ForgotPassword fpuser) throws Exception;
	
	public User updateUserDetails(User user) throws Exception;
	
	public Booking makePayment(Payment payment) throws Exception;
	
	public List<Booking> bookingHistory(String emailId) throws Exception;
	
	public Feedback getFeedback(Feedback feedback) throws Exception;
	
	public Admin adminRegistration(Admin admin) throws Exception;
	
	public Admin adminLogin(Admin admin) throws Exception;
	
	public List<Booking> adminDisplayBookingDetails() throws Exception;
	
	public List<User> adminDisplayUserDetails() throws Exception;
	
	public List<Feedback> adminDisplayFeedback() throws Exception;
	
	public Package adminAddOrUpdatePackage(Package pkg) throws Exception;
	
	public Booking latestBookingOfUser() throws Exception; 
	public Admin forgotPasswordAdmin(ForgotPasswordAdmin fpadmin) throws Exception;
	
	//public Booking sendMail() throws Exception;
	
}
