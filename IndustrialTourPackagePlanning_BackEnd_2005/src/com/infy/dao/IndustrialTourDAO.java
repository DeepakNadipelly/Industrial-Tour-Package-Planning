package com.infy.dao;

import java.util.List;

import com.infy.model.CostCalculator;
import com.infy.model.ForgotPassword;
import com.infy.model.ForgotPasswordAdmin;
import com.infy.model.Payment;
import com.infy.model.User;
import com.infy.model.Package;
import com.infy.model.Feedback;
import com.infy.model.Admin;
import com.infy.model.Booking;
	
public interface IndustrialTourDAO {
	
	public Double calculateCost(CostCalculator cc);
	
	public User getUserDetails(User user) throws Exception;
	
	public List<Package> displayPackageDetails();
	
	public User collectUserDetails(User user) throws Exception;
	
	public User forgotPassword(ForgotPassword fpuser);
	
	public User updateUserDetails(User user) throws Exception;
	
	public List<Booking> bookingHistory(String emailId) throws Exception;
	
	public Booking makePayment(Payment payment);
	
	public Feedback getFeedback(Feedback feedback);
	
	public Admin adminRegistration(Admin admin);
	
	public Admin adminLogin(Admin admin);
	
	public List<Booking> adminDisplayBookingDetails();
	
	public List<User> adminDisplayUserDetails();
	
	public List<Feedback> adminDisplayFeedback();
	
	public Package adminAddOrUpdatePackage(Package pkg);
	
	public Booking latestBookingOfUser();
	public Admin forgotPasswordAdmin(ForgotPasswordAdmin fpadmin);
	
	
	//public Booking sendMail();
	
}
