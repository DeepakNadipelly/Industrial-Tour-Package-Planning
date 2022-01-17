package com.infy.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dao.IndustrialTourDAOImpl;
import com.infy.model.Admin;
import com.infy.model.Booking;
import com.infy.model.CostCalculator;
import com.infy.model.Feedback;
import com.infy.model.ForgotPassword;
import com.infy.model.ForgotPasswordAdmin;
import com.infy.model.Package;
import com.infy.model.Payment;
import com.infy.model.User;
import com.infy.service.IndustrialTourService;
import com.infy.service.IndustrialTourServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="IndustrialTour")
public class IndustrialTourAPI {
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ResponseEntity<User> getUserDetails(@RequestBody User user) throws Exception{
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<User> re;
		try {
			User user1=service.getUserDetails(user);
			user1.setMessage(env.getProperty("LoginAPI.SUCCESSFUL"));
			re=new ResponseEntity<User>(user1,HttpStatus.OK);
			
		} catch (Exception e) {
			User user1=new User();
			user1.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<User>(user1,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public ResponseEntity<User> collectUserDetails(@RequestBody User user){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<User> re;
		try {
			User usr=service.collectUserDetails(user);
			usr.setMessage(env.getProperty("RegistrationAPI.SUCCESSFUL"));
			re=new ResponseEntity<User>(usr,HttpStatus.OK);
		} catch (Exception e) {
			User usr=new User();
			usr.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<User>(usr,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="packages", method=RequestMethod.GET)
	public ResponseEntity<List<Package>> displayPackageDetails(){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		ResponseEntity<List<Package>> re;
		try {
			List<Package> packageList=service.displayPackageDetails();
			re=new ResponseEntity<List<Package>>(packageList,HttpStatus.OK);
		} catch (Exception e) {
			List<Package> packageList=new ArrayList();
			re=new ResponseEntity<List<Package>>(packageList,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="calculateCost", method=RequestMethod.POST)
	public ResponseEntity<CostCalculator> calculateCost(@RequestBody CostCalculator cc){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<CostCalculator> re;
		try {
			cc.setCalculatedCost(service.calculateCost(cc));
			cc.setMessage(env.getProperty("CalculateCost.SUCCESSFUL")+" Rs."+cc.getCalculatedCost());
			re=new ResponseEntity<CostCalculator>(cc,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			cc.setMessage(env.getProperty("CalculateCost.INVALID_DETAILS"));
			re=new ResponseEntity<CostCalculator>(cc,HttpStatus.BAD_REQUEST);
		}
		return re;
		
	}
	
	@RequestMapping(value="forgotPassword", method=RequestMethod.POST)
	public ResponseEntity<User> forgotPassword(@RequestBody ForgotPassword fpuser){
	
		
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<User> re;
		try {
			User usr=service.forgotPassword(fpuser);
			usr.setMessage(env.getProperty("PasswordChanged.SUCCESSFULLY"));
			re=new ResponseEntity<User>(usr,HttpStatus.OK);
		} catch (Exception e) {
			User usr=new User();
			usr.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<User>(usr,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="updateUserDetails", method=RequestMethod.POST)
	public ResponseEntity<User> updateUserDetails(@RequestBody User user){
			IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
			Environment env=ContextFactory.getContext().getEnvironment();
			ResponseEntity<User> re;
			try {
				User usr=service.updateUserDetails(user);
				usr.setMessage(env.getProperty("User_Details_Updation.SUCCESSFUL"));
				re=new ResponseEntity<User>(usr,HttpStatus.OK);
			} catch (Exception e) {
				User usr1=new User();
				e.printStackTrace();
				usr1.setMessage(env.getProperty(e.getMessage()));
				re=new ResponseEntity<User>(usr1,HttpStatus.BAD_REQUEST);
			}
			return re;
		}
	
	@RequestMapping(value="makePayment", method=RequestMethod.POST)
	public ResponseEntity<Booking> makeBooking(@RequestBody Payment payment){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Booking> re;
		try {
			Booking bkg=service.makePayment(payment);
			System.out.println("makeBooking - "+IndustrialTourDAOImpl.counter);
			bkg.setMessage(env.getProperty("Booking.SUCCESSFUL"));
			re=new ResponseEntity<Booking>(bkg,HttpStatus.OK);
		} catch (Exception e) {
			Booking bkg=new Booking();
			e.printStackTrace();
			bkg.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Booking>(bkg,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="getBookingHistory", method=RequestMethod.POST)
	public ResponseEntity<List<Booking>> bookingHistory(@RequestBody String emailId) {
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		ResponseEntity<List<Booking>> re;
		try {
			List<Booking> bookingList=service.bookingHistory(emailId);
			re=new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
		} catch (Exception e) {
			List<Booking> bookingList=new ArrayList();
			re=new ResponseEntity<List<Booking>>(bookingList,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="getFeedback", method=RequestMethod.POST)
	public ResponseEntity<Feedback> getFeedback(@RequestBody Feedback feedback) {
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Feedback> re;
		try {
			Feedback fb=service.getFeedback(feedback);
			fb.setMessage(env.getProperty("FEEDBACK_SUCCESSFUL"));
			re=new ResponseEntity<Feedback>(fb,HttpStatus.OK);
		} catch (Exception e) {
			Feedback fb=new Feedback();
			fb.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Feedback>(fb,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminRegistration", method=RequestMethod.POST)
	public ResponseEntity<Admin> adminRegistration(@RequestBody Admin admin) throws Exception{
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Admin> re;
		try {
			Admin adm=service.adminRegistration(admin);
			adm.setMessage(env.getProperty("RegistrationAPI.SUCCESSFUL"));
			re=new ResponseEntity<Admin>(adm,HttpStatus.OK);
		} catch (Exception e) {
			Admin adm=new Admin();
			adm.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Admin>(adm,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminLogin", method=RequestMethod.POST)
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) throws Exception{
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Admin> re;
		try {
			Admin ad1=service.adminLogin(admin);
			ad1.setMessage(env.getProperty("LoginAPI.SUCCESSFUL"));
			re=new ResponseEntity<Admin>(ad1,HttpStatus.OK);
			
		} catch (Exception e) {
			Admin ad1=new Admin();
			ad1.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Admin>(ad1,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminDisplayBookingDetails", method=RequestMethod.GET)
	public ResponseEntity<List<Booking>> adminDisplayBookingDetails(){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		ResponseEntity<List<Booking>> re;
		try {
			List<Booking> bookingList=service.adminDisplayBookingDetails();
			re=new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
		} catch (Exception e) {
			List<Booking> bookingList=new ArrayList();
			re=new ResponseEntity<List<Booking>>(bookingList,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminDisplayUserDetails", method=RequestMethod.GET)
	public ResponseEntity<List<User>> adminDisplayUserDetails(){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		ResponseEntity<List<User>> re;
		try {
			List<User> userList=service.adminDisplayUserDetails();
			re=new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		} catch (Exception e) {
			List<User> userList=new ArrayList();
			re=new ResponseEntity<List<User>>(userList,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminDisplayFeedback", method=RequestMethod.GET)
	public ResponseEntity<List<Feedback>> adminDisplayFeedback(){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		ResponseEntity<List<Feedback>> re;
		try {
			List<Feedback> feedbackList=service.adminDisplayFeedback();
			re=new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.OK);
		} catch (Exception e) {
			List<Feedback> feedbackList=new ArrayList();
			re=new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
	@RequestMapping(value="adminAddOrUpdatePackage", method=RequestMethod.POST)
	public ResponseEntity<Package> adminAddOrUpdatePackage(@RequestBody Package pkg){
			IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
			Environment env=ContextFactory.getContext().getEnvironment();
			ResponseEntity<Package> re;
			try {
				Package pack=service.adminAddOrUpdatePackage(pkg);
				pack.setMessage(env.getProperty("Package_Modification.SUCCESSFUL"));
				re=new ResponseEntity<Package>(pack,HttpStatus.OK);
			} catch (Exception e) {
				Package pack=new Package();
				e.printStackTrace();
				pack.setMessage(env.getProperty(e.getMessage()));
				re=new ResponseEntity<Package>(pack,HttpStatus.BAD_REQUEST);
			}
			return re;
		}
	@RequestMapping(value="latestBookingOfUser")
	public ResponseEntity<Booking> latestBookingOfUser(){
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Booking> re;
		try {
			Booking bkg=service.latestBookingOfUser();
			System.out.println("latest booking"+IndustrialTourDAOImpl.counter);
			bkg.setMessage(env.getProperty("Fetch_details.SUCCESSFUL"));
			re=new ResponseEntity<Booking>(bkg,HttpStatus.OK);
		} catch (Exception e) {
			Booking bkg=new Booking();
			bkg.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Booking>(bkg,HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@RequestMapping(value="forgotPasswordAdmin", method=RequestMethod.POST)
	public ResponseEntity<Admin> forgotPasswordAdmin(@RequestBody ForgotPasswordAdmin fpadmin){
	
		
		IndustrialTourService service =(IndustrialTourService) ContextFactory.getContext().getBean(IndustrialTourServiceImpl.class);
		Environment env=ContextFactory.getContext().getEnvironment();
		ResponseEntity<Admin> re;
		try {
			Admin admin1=service.forgotPasswordAdmin(fpadmin);
			admin1.setMessage(env.getProperty("PasswordChanged.SUCCESSFULLY"));
			re=new ResponseEntity<Admin>(admin1,HttpStatus.OK);
		} catch (Exception e) {
			Admin admin1=new Admin();
			admin1.setMessage(env.getProperty(e.getMessage()));
			re=new ResponseEntity<Admin>(admin1,HttpStatus.BAD_REQUEST);
		}
		return re;
	}
	
}
