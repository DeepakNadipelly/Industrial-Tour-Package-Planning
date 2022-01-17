package com.infy.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;















import com.infy.entity.AdminEntity;
import com.infy.entity.BookingEntity;
import com.infy.entity.CardEntity;
import com.infy.entity.FeedbackEntity;
import com.infy.entity.PackageEntity;
import com.infy.entity.UserEntity;
import com.infy.model.Admin;
import com.infy.model.Booking;
import com.infy.model.CostCalculator;
import com.infy.model.Feedback;
import com.infy.model.ForgotPassword;
import com.infy.model.ForgotPasswordAdmin;
import com.infy.model.Package;
import com.infy.model.Payment;
import com.infy.model.User;

@Repository("dao")
public class IndustrialTourDAOImpl implements IndustrialTourDAO {
    
	public static int counter=2003;
	static int counter2=0;
	static int packageCounter=8;
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Package> displayPackageDetails(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PackageEntity> criteriaQuery = criteriaBuilder.createQuery(PackageEntity.class);
        Root<PackageEntity> root = criteriaQuery.from(PackageEntity.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<PackageEntity> packageEntities = query.getResultList();
        List<Package> packageList = new ArrayList<>();
        for (PackageEntity packageEntity : packageEntities) {
        	Package package1 = new Package();
        	package1.setPackageId(packageEntity.getPackageId());
        	package1.setPricePerHead(packageEntity.getPricePerHead());
        	package1.setPlacesIncluded(packageEntity.getPlacesIncluded());
        	package1.setPackageName(packageEntity.getPackageName());
        	package1.setLocation(packageEntity.getLocation());
        	package1.setNumberOfDays(packageEntity.getNumberOfDays());
            packageList.add(package1);
        }
        return packageList;
	}
	
	@Override
	public User getUserDetails(User user) throws Exception{
		Session session = sessionFactory.getCurrentSession();
	    UserEntity userEntity=new UserEntity();
	    userEntity=session.get(UserEntity.class,user.getEmailId());
	    if(	userEntity !=null) {
	    	if(userEntity.getPassword().equals(user.getPassword())){
	    		User user1=new User();
	    		user1.setUserName(userEntity.getUserName());
	    		user1.setContactNumber(userEntity.getContactNumber());
	    		user1.setDateOfBirth(userEntity.getDateOfBirth());
	    		user1.setEmailId(userEntity.getEmailId());
	    		user1.setPassword(userEntity.getPassword());
	    		return user1;
	    	}
	    	else{
		    	return null;
		    }
	    }
	    return null;
	}
	
	
	@Override
	public User collectUserDetails(User user){
		Session session = sessionFactory.getCurrentSession();
		UserEntity userEntity = session.get(UserEntity.class, user.getEmailId());
		if(	userEntity==null) {
			userEntity=new UserEntity();
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity.setEmailId(user.getEmailId());
			userEntity.setContactNumber(user.getContactNumber());
			userEntity.setDateOfBirth(user.getDateOfBirth());
			session.save(userEntity);
			return user;
		}
		return null;
		
	}

	@Override
	public Double calculateCost(CostCalculator cc) {
		Session session = sessionFactory.getCurrentSession();
		PackageEntity packageEntity=session.get(PackageEntity.class,cc.getPackageId());
		if(packageEntity!=null){
			Double cost= packageEntity.getPricePerHead()*cc.getNumberOfPeople();
			return cost;
		}
		return null;
	}

	@Override
	public User forgotPassword(ForgotPassword fpuser) {
		Session session = sessionFactory.getCurrentSession();
	    UserEntity userEntity=new UserEntity();
	    userEntity=session.get(UserEntity.class,fpuser.getEmailId());
	    if(	userEntity !=null) {
	    	
	    		userEntity.setPassword(fpuser.getNewPassword());
	    		session.save(userEntity);
	    		User user1=new User();
	    		user1.setUserName(userEntity.getUserName());
	    		user1.setContactNumber(userEntity.getContactNumber());
	    		user1.setDateOfBirth(userEntity.getDateOfBirth());
	    		user1.setEmailId(userEntity.getEmailId());
	    		user1.setPassword(fpuser.getNewPassword());
	    		return user1;
	    }
	    return null;
	}

	@Override
	public User updateUserDetails(User user) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		UserEntity userEntity = session.get(UserEntity.class, user.getEmailId());
		
		if(	userEntity!=null) {
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity.setEmailId(user.getEmailId());
			userEntity.setContactNumber(user.getContactNumber());
			userEntity.setDateOfBirth(user.getDateOfBirth());
			session.save(userEntity);
			User user1=new User();
    		user1.setUserName(userEntity.getUserName());
    		user1.setContactNumber(userEntity.getContactNumber());
    		user1.setDateOfBirth(userEntity.getDateOfBirth());
    		user1.setEmailId(userEntity.getEmailId());
    		user1.setPassword(userEntity.getPassword());
    		return user1;
		}
		return null;
	}

	@Override
	public List<Booking> bookingHistory(String emailId) throws Exception {
		        Session session = sessionFactory.getCurrentSession();
		        List<Booking> bookingList = new ArrayList<>();
		        CriteriaBuilder builder = session.getCriteriaBuilder();
		        CriteriaQuery<BookingEntity> criteriaQuery= builder.createQuery(BookingEntity.class);
		        Root<BookingEntity> root = criteriaQuery.from(BookingEntity.class);
		        criteriaQuery.select(root);
		       criteriaQuery.where(builder.equal(root.get("emailId"), emailId));
		        Query query = session.createQuery(criteriaQuery);
		        List<BookingEntity> bookingEntityList = query.getResultList();
		        for (BookingEntity bookingEntity : bookingEntityList) {
		            Booking booking1=new Booking();
		            booking1.setBookingId(bookingEntity.getBookingId());
		            booking1.setContactNumber(bookingEntity.getContactNumber());
		            booking1.setStartDate(bookingEntity.getStartDate());
		            booking1.setEndDate(bookingEntity.getEndDate());
		            booking1.setPackageId(bookingEntity.getPackageId());
		            booking1.setNumberOfPeople(bookingEntity.getNumberOfPeople());
		            booking1.setEmailId(bookingEntity.getEmailId());
		            booking1.setTotalCost(bookingEntity.getTotalCost());
		            bookingList.add(booking1);
		        }
		        return bookingList;
		    }

	@Override
	public Feedback getFeedback(Feedback feedback) {
		Session session = sessionFactory.getCurrentSession();
		//UserEntity userEntity = session.get(UserEntity.class, feedback.getEmailId());
		BookingEntity bookingEntity = session.get(BookingEntity.class, feedback.getBookingId());
		if(bookingEntity!=null) {
			feedback.setFeedbackId(counter2++);
			FeedbackEntity feedbackEntity=new FeedbackEntity();
			feedbackEntity.setFeedbackId(feedback.getBookingId());;
			feedbackEntity.setEmailId(feedback.getEmailId());
			feedbackEntity.setBookingId(feedback.getBookingId());
			feedbackEntity.setUserName(feedback.getUserName());
			feedbackEntity.setSubject(feedback.getSubject());
			feedbackEntity.setDescription(feedback.getDescription());
			session.save(feedbackEntity);
			return feedback;
		}
		return null;
	}

	@Override
	public Booking makePayment(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		PackageEntity packageEntity=session.get(PackageEntity.class,payment.getPackageId());
		
		if(packageEntity!=null){
			payment.setBookingId(counter++);
			Double cost= packageEntity.getPricePerHead()*payment.getNumberOfPeople();
			payment.setTotalCost(cost);
		}else{
			counter--;
			return null;//the package id user requested is not present
		}
		BookingEntity bookingEntity = session.get(BookingEntity.class, payment.getBookingId());
		CardEntity cardEntity=new CardEntity();
		System.out.println("Booking entity before if"+bookingEntity);
		if(	bookingEntity==null) {
			bookingEntity=new BookingEntity();
			Booking booking=new Booking();
			cardEntity=session.get(CardEntity.class,payment.getCardNumber());
			System.out.println("Bcardg entity before if"+cardEntity);
			if(cardEntity!=null){
				bookingEntity.setBookingId(payment.getBookingId());
				booking.setBookingId(payment.getBookingId());
				bookingEntity.setPackageId(payment.getPackageId());
				booking.setPackageId(payment.getPackageId());
				bookingEntity.setStartDate(payment.getStartDate());
				booking.setStartDate(payment.getStartDate());
				bookingEntity.setEndDate(payment.getEndDate());
				booking.setEndDate(payment.getEndDate());
				bookingEntity.setEmailId(payment.getEmailId());
				booking.setEmailId(payment.getEmailId());
				bookingEntity.setNumberOfPeople(payment.getNumberOfPeople());
				booking.setNumberOfPeople(payment.getNumberOfPeople());
				bookingEntity.setContactNumber(payment.getContactNumber());
				booking.setContactNumber(payment.getContactNumber());
				bookingEntity.setTotalCost(payment.getTotalCost());
				booking.setTotalCost(payment.getTotalCost());
				session.save(bookingEntity);
				return booking;
			}
			System.out.println("car entity after if"+cardEntity);
			return null;
		}
		System.out.println("Booking entity after if"+bookingEntity);
		return null;
	}

	@Override
	public Admin adminRegistration(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		AdminEntity adminEntity = session.get(AdminEntity.class, admin.getAdminName());
		if(	adminEntity==null) {
			adminEntity=new AdminEntity();
			adminEntity.setAdminName(admin.getAdminName());
			adminEntity.setAdminPassword(admin.getAdminPassword());
			session.save(adminEntity);
			return admin;
		}
		return null;
	}

	@Override
	public Admin adminLogin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
	    AdminEntity adminEntity=new AdminEntity();
	    adminEntity=session.get(AdminEntity.class,admin.getAdminName());
	    if(	adminEntity !=null) {
	    	if(adminEntity.getAdminPassword().equals(admin.getAdminPassword())){
	    		Admin ad1=new Admin();
	    		ad1.setAdminName(adminEntity.getAdminName());
	    		ad1.setAdminPassword(adminEntity.getAdminPassword());
	    		return ad1;
	    	}
	    	else{
		    	return null;
		    }
	    }
	    return null;
	}

	@Override
	public List<Booking> adminDisplayBookingDetails() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BookingEntity> criteriaQuery = criteriaBuilder.createQuery(BookingEntity.class);
        Root<BookingEntity> root = criteriaQuery.from(BookingEntity.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<BookingEntity> bookingEntities = query.getResultList();
        List<Booking> bookingList = new ArrayList<>();
        for (BookingEntity bookingEntity : bookingEntities) {
        	Booking booking1 = new Booking();
        	booking1.setBookingId(bookingEntity.getBookingId());
        	booking1.setPackageId(bookingEntity.getPackageId());
        	booking1.setStartDate(bookingEntity.getStartDate());
        	booking1.setEndDate(bookingEntity.getEndDate());
        	booking1.setEmailId(bookingEntity.getEmailId());
        	booking1.setNumberOfPeople(bookingEntity.getNumberOfPeople());
        	booking1.setContactNumber(bookingEntity.getContactNumber());
        	booking1.setTotalCost(bookingEntity.getTotalCost());
            bookingList.add(booking1);
        }
        return bookingList;
	}

	@Override
	public List<User> adminDisplayUserDetails() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<UserEntity> userEntities = query.getResultList();
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
        	User usr = new User();
        	usr.setUserName(userEntity.getUserName());
        	usr.setEmailId(userEntity.getEmailId());
        	usr.setContactNumber(userEntity.getContactNumber());
        	usr.setDateOfBirth(userEntity.getDateOfBirth());
        	userList.add(usr);
        }
        return userList;
	}

	@Override
	public List<Feedback> adminDisplayFeedback() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FeedbackEntity> criteriaQuery = criteriaBuilder.createQuery(FeedbackEntity.class);
        Root<FeedbackEntity> root = criteriaQuery.from(FeedbackEntity.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<FeedbackEntity> feedbackEntities = query.getResultList();
        List<Feedback> feedbackList = new ArrayList<>();
        for (FeedbackEntity feedbackEntity : feedbackEntities) {
        	Feedback feedback = new Feedback();
        	feedback.setFeedbackId(feedbackEntity.getFeedbackId());
        	feedback.setEmailId(feedbackEntity.getEmailId());
        	feedback.setBookingId(feedbackEntity.getBookingId());;
        	feedback.setUserName(feedbackEntity.getUserName());
        	feedback.setUserName(feedbackEntity.getUserName());
        	feedback.setSubject(feedbackEntity.getSubject());
        	feedback.setDescription(feedbackEntity.getDescription());
        	feedbackList.add(feedback);
        }
        return feedbackList;
	}

	@Override
	public Package adminAddOrUpdatePackage(Package pkg) {
		Session session = sessionFactory.getCurrentSession();
		
		PackageEntity packageEntity = session.get(PackageEntity.class, pkg.getPackageId());
		if(	packageEntity==null) {
			pkg.setPackageId(packageCounter++);
			//adding a new package
			packageEntity=new PackageEntity();
			packageEntity.setPackageId(pkg.getPackageId());
			packageEntity.setPlacesIncluded(pkg.getPlacesIncluded());
			packageEntity.setLocation(pkg.getLocation());
			packageEntity.setPackageName(pkg.getPackageName());
			packageEntity.setNumberOfDays(pkg.getNumberOfDays());
			packageEntity.setPricePerHead(pkg.getPricePerHead());
			session.save(packageEntity);
			return pkg;
		}
		else{
			//modifying an existing package
			//PackageEntity packageEntity = session.get(PackageEntity.class, pkg.getPackageId());
//			packageEntity.setPackageId(pkg.getPackageId());//existing package 
			//can modify any of these details
			packageEntity.setPlacesIncluded(pkg.getPlacesIncluded());
			packageEntity.setLocation(pkg.getLocation());
			packageEntity.setPackageName(pkg.getPackageName());
			packageEntity.setNumberOfDays(pkg.getNumberOfDays());
			packageEntity.setPricePerHead(pkg.getPricePerHead());
			session.save(packageEntity);
			return pkg;
		}
	}

	
	@Override
	public Admin forgotPasswordAdmin(ForgotPasswordAdmin fpadmin) {
		Session session = sessionFactory.getCurrentSession();
	    AdminEntity adminEntity=new AdminEntity();
	    adminEntity=session.get(AdminEntity.class,fpadmin.getAdminName());
	    if(	adminEntity !=null) {
	    	
	    	adminEntity.setAdminPassword(fpadmin.getAdminNewPassword());
	    		session.save(adminEntity);
	    		Admin admin1=new Admin();
	    		admin1.setAdminName(adminEntity.getAdminName());
	    		admin1.setAdminPassword(adminEntity.getAdminPassword());
	    		return admin1;
	    }
	    return null;
	}
	@Override
	public Booking latestBookingOfUser() {
		Session session = sessionFactory.getCurrentSession();
	    BookingEntity bookingEntity=new BookingEntity();
	    System.out.println(counter);
	    bookingEntity=session.get(BookingEntity.class,counter-1);
	    
	    if(	bookingEntity !=null) {
	    		Booking bkg1=new Booking();
	    		bkg1.setBookingId(bookingEntity.getBookingId());
	    		
	    		bkg1.setPackageId(bookingEntity.getPackageId());
	    		bkg1.setStartDate(bookingEntity.getStartDate());
	    		bkg1.setEndDate(bookingEntity.getEndDate());
	    		bkg1.setEmailId(bookingEntity.getEmailId());
	    		bkg1.setNumberOfPeople(bookingEntity.getNumberOfPeople());
	    		bkg1.setTotalCost(bookingEntity.getTotalCost());
//	    		bkg1.setContactNumber(bookingEntity.getContactNumber());
	    		System.out.println(bkg1);
	    		return bkg1;
		    }
	    return null;
	}
	}


