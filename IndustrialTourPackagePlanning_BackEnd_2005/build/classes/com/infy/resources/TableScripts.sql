
drop table Booking;
drop table Users;
drop table Package;
drop table Admin;
drop table Feedback;
drop table Card;

CREATE TABLE Users(
emailId varchar2(20) PRIMARY KEY,
userName varchar2(20) NOT NULL,
contactNumber number(10) NOT NULL ,
dateOfBirth date not null,
password varchar2(15) NOT NULL,
constraint table_name_number_nn UNIQUE(contactNumber)
);

INSERT INTO USERS VALUES('john@gmail.com','John Kell',9879879873,'13-FEB-1994','123@John');
INSERT INTO USERS VALUES('john1@gmail.com','John Hell',9849831964,'26-MAR-1992','JohnnyEnglish');

create table Admin(
adminName varchar2(20) PRIMARY key,
adminPassword varchar2(15) not null
);

insert into Admin values('Sanjana','1234');


create table Package(
packageId number(4)PRIMARY KEY,
packageName varchar2(50) not null,
location varchar2(70) not null,
	placesIncluded varchar2(150)not null,
	numberOfDays number(2) not null,
	pricePerHead number(6)not null
);

INSERT INTO Package values(1,'Hyderabad Industrial Visit','Hyderabad','Google,Microsoft',3,4000);
INSERT INTO Package values(2,'Manali Industrial Visit','Manali','Malana Power Project,Indian Agricultural Research Institute',3,3000);
INSERT INTO Package values(3,'Shimla Industrial Visit','Shimla','TVS Motors,Hindustan Unilever Ltd,Procter & Gamble',4,3500);
INSERT INTO Package values(4,'Udaipur Industrial visit','Udaipur','Udaipur Phosphates and Fertilizers,Secure Meters,Hindustan Zinc Limited,Rajasthan Petro Synthetics',5,6500);
INSERT INTO Package values(5,'Goa Industrial Visit','Goa','Goa Shipyard limited,United Beverages Ltd,Impala Distillery & Brewery Ltd,Goa State Co-operative Milk Producers Union Ltd',3,6000);
INSERT INTO Package values(6,'Kolkata Industrial Visit','Kolkata','Dabur India Ltd,Berger Lewis India,United Spirits Limited,Braithwaite & Co. Ltd',4,5500);
INSERT INTO Package values(7,'MYSORE Industrial Visit','Mysore','Infosys Mysore,Falcon Tyres Ltd.,Government Silk Weaving Factory,Government Sandalwood Oil Factory',4,3700);

create table Booking(
	bookingId number(4) PRIMARY key,
	packageId number(4),  
	startDate date not null,
	endDate date not null,
	emailId varchar2(20),
	numberOfPeople number(3) not null,
	contactNumber number(10) NOT NULL,
	totalCost number(7) not null);
	
insert into Booking values(2000,1,'12-MAY-2019','15-MAY-2019','john@gmail.com',2,9849831963,5000);
insert into Booking values(2001,2,'12-MAY-2019','15-MAY-2019','john1@gmail.com',2,9849831963,5000);
insert into Booking values(2002,3,'12-MAY-2019','15-MAY-2019','john@gmail.com',2,9849831963,5000);
insert into Booking values(2003,4,'12-MAY-2019','15-MAY-2019','john1@gmail.com',2,9849831963,5000);

create table Feedback(
	feedbackId number(4)  PRIMARY key,
	emailId varchar2(20),
	bookingId number(4),  
	userName varchar2(20) not null,
	subject varchar2(30) not null,
	description varchar2(250) not null);
	
--insert into Feedback values(1,'john@gmail.com',1,'John Kell','Review','Very much satisfied with the trip!');
	
create table Card(
	nameOnCard varchar2(40) not null,
	cardNumber number(16) PRIMARY KEY,
	cvv number(3) not null,
	expiryMonth number(2) not null,
	expiryYear number(4) not null);
	
insert into Card values('ABC',1234567890123456,123,04,2023);
insert into Card values('DEF',9087654321098765,321,12,2026);
insert into Card values('GHI',2345678901234567,456,09,2025);
insert into Card values('JKL',8907654321098765,789,03,2027); 

select * from Users;

select * from Package;

select * from Booking;

select * from Feedback;

select * from Card;

select * from Admin;