import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';


import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './login/router.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginService } from './login/login.service';
import { HttpModule } from '@angular/http';
import { SignUpService } from './sign-up/sign-up.service';
import { HomeComponent } from './home/home.component';

import { PackagesComponent } from './packages/packages.component';
import { BookinghistoryComponent } from './bookinghistory/bookinghistory.component';
import { PackageDetailsService } from './packages/packages.service';
import { BookingComponent } from './booking/booking.component';
import { ContactComponent } from './contact/contact.component';
import { FpComponent } from './fp/fp.component';
import { UpdateComponent } from './update/update.component';
import { UpdateService } from './update/update.service';
import { FpService } from './fp/fp.service';
import { BookingService } from './booking/booking.service';
import { BookingHistoryService } from './bookinghistory/bookinghistory.service';
import { FeedbackComponent } from './feedback/feedback.component';
import { AuthguardGuard } from './authguard.guard';
import { FeedbackService } from './feedback/feedback.service';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { FeedbackinfoComponent } from './feedbackinfo/feedbackinfo.component';
import { AdminloginService } from './adminlogin/adminlogin.service';
import { AdminhomeService } from './adminhome/adminhome.service';
import { UserdetailsService } from './userdetails/userdetails.service';
import { FeedbackinfoService } from './feedbackinfo/feedbackinfo.service';
import { PackagedetailsComponent } from './packagedetails/packagedetails.component';
import { PackagedetailssService } from './packagedetails/packagedetails.service';
import { PaymentsuccessComponent } from './paymentsuccess/paymentsuccess.component';
import { UpdatepackagedetailsComponent } from './updatepackagedetails/updatepackagedetails.component';
import { FpadminComponent } from './fpadmin/fpadmin.component';
import { FpAdminService } from './fpadmin/fpadmin.service';
import { UpdatepackagedetailsService } from './updatepackagedetails/updatepackagedetails.service';
import { PaymentsuccessService } from './paymentsuccess/paymentsuccess.service';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    HomeComponent,
    PackagesComponent,
    BookinghistoryComponent,
    BookingComponent,
    ContactComponent,
    FpComponent,
    UpdateComponent,
    FeedbackComponent,
    AdminloginComponent,
    AdminhomeComponent,
    UserdetailsComponent,
    FeedbackinfoComponent,
    PackagedetailsComponent,
    PaymentsuccessComponent,
    UpdatepackagedetailsComponent,
    FpadminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule
    
  ],
  providers: [LoginService,SignUpService,PackageDetailsService,UpdateService,FpService,BookingService,BookingHistoryService,FeedbackService,AdminloginService,AdminhomeService,UserdetailsService,FeedbackinfoService,PackagedetailssService,FpAdminService,PaymentsuccessService,UpdatepackagedetailsService,AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
