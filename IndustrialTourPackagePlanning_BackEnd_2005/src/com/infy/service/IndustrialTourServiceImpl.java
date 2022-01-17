package com.infy.service;

import java.util.List;

import com.infy.model.Admin;
import com.infy.model.Booking;
import com.infy.model.Feedback;
import com.infy.model.ForgotPassword;
import com.infy.model.ForgotPasswordAdmin;
import com.infy.model.Package;
import com.infy.model.Payment;
import com.infy.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.model.CostCalculator;
import com.infy.dao.IndustrialTourDAO;;

@Service("IndustrialTourService")
@Transactional(readOnly = true)
public class IndustrialTourServiceImpl implements IndustrialTourService{
	
	@Autowired
	private IndustrialTourDAO dao;
	
	@Transactional(readOnly = true)
	public User getUserDetails(User user) throws Exception {
		User user1= new User();
		user1 = dao.getUserDetails(user);
		if(user1 == null) {
			throw new Exception("Service.INVALID_LOGIN");
		}
		return user1;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public User collectUserDetails(User user) throws Exception {
		User usr = dao.collectUserDetails(user);
		if(usr == null) {
			throw new Exception("Service.USER_ALREADY_EXISTS");
		}
		return usr;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<Package> displayPackageDetails()
			throws Exception {
		List<Package> packageList = dao.displayPackageDetails();
		if(packageList == null) {
			throw new Exception("Service.INVALID_PACKAGE");
		}
		return packageList;
		
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Double calculateCost(CostCalculator cc) throws Exception {
		Double totalCost=dao.calculateCost(cc);
		if(totalCost==null){
			throw new Exception("Service.INVALID_NUMBER_OF_PEOPLE");
		}
		return totalCost;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public User forgotPassword(ForgotPassword fpuser) throws Exception {
		User usr = dao.forgotPassword(fpuser);
		if(usr == null) {
			throw new Exception("Service.USER_NOT_REGISTERED");
		}
		return usr;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public User updateUserDetails(User user) throws Exception {
		User usr = dao.updateUserDetails(user);
		if(usr == null) {
			throw new Exception("Service.USER_NOT_REGISTERED");
		}
		return usr;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Booking makePayment(Payment payment) throws Exception {
		Booking bkg = dao.makePayment(payment);
		if(bkg == null) {
			throw new Exception("Service.PAYMENT_NOT_MADE");
		}
		return bkg;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<Booking> bookingHistory(String emailId) throws Exception {
		List<Booking> bookingList = dao.bookingHistory(emailId);
		if(bookingList == null) {
			throw new Exception("Service.NO_BOOKINGS_MADE");
		}
		return bookingList;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Feedback getFeedback(Feedback feedback) throws Exception {
		Feedback fb = dao.getFeedback(feedback);
		if(fb == null) {
			throw new Exception("Service.CANNOT_GIVE_FEEDBACK");
		}
		return fb;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Admin adminRegistration(Admin admin) throws Exception {
		Admin ad = dao.adminRegistration(admin);
		if(ad == null) {
			throw new Exception("Service.ADMIN_ALREADY_EXISTS");
		}
		return ad;
	}

	@Transactional(readOnly = true)
	public Admin adminLogin(Admin admin) throws Exception {
		Admin ad1= new Admin();
		ad1 = dao.adminLogin(admin);
		if(ad1 == null) {
			throw new Exception("Service.INVALID_LOGIN");
		}
		return ad1;
	}

	@Transactional(readOnly = true)
	public List<Booking> adminDisplayBookingDetails() throws Exception {
		List<Booking> bookingList = dao.adminDisplayBookingDetails();
		if(bookingList == null) {
			throw new Exception("Service.NO_DETAILS_TO_SHOW");
		}
		return bookingList;
	}

	@Transactional(readOnly = true)
	public List<User> adminDisplayUserDetails() throws Exception {
		List<User> userList = dao.adminDisplayUserDetails();
		if(userList == null) {
			throw new Exception("Service.NO_DETAILS_TO_SHOW");
		}
		return userList;
	}

	@Transactional(readOnly = true)
	public List<Feedback> adminDisplayFeedback() throws Exception {
		List<Feedback> feedbackList = dao.adminDisplayFeedback();
		if(feedbackList == null) {
			throw new Exception("Service.NO_DETAILS_TO_SHOW");
		}
		return feedbackList;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Package adminAddOrUpdatePackage(Package pkg) throws Exception {
		Package pkg1 = dao.adminAddOrUpdatePackage(pkg);
		if(pkg1 == null) {
			throw new Exception("Service.PACKAGE_ERROR");
		}
		return pkg1;
	}

	@Transactional(readOnly = true)
	public Booking latestBookingOfUser() throws Exception {
		Booking bkg= new Booking();
		bkg = dao.latestBookingOfUser();
		if(bkg == null) {
			throw new Exception("Service.CANT_FETCH");
		}
		return bkg;
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Admin forgotPasswordAdmin(ForgotPasswordAdmin fpadmin)
			throws Exception {
		Admin admin1 = dao.forgotPasswordAdmin(fpadmin);
		if(admin1 == null) {
			throw new Exception("Service.ADMIN_INVALID");
		}
		return admin1;
	}
	
}
