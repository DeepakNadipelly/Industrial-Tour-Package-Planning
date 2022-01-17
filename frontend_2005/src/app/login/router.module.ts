import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';
import { SignUpComponent } from '../sign-up/sign-up.component';
import { HomeComponent } from '../home/home.component';
import { PackagesComponent } from '../packages/packages.component';
import { BookinghistoryComponent } from '../bookinghistory/bookinghistory.component';
import { BookingComponent } from '../booking/booking.component';
import { ContactComponent } from '../contact/contact.component';
import { FpComponent } from '../fp/fp.component';
import { UpdateComponent } from '../update/update.component';
import { FeedbackComponent } from '../feedback/feedback.component'
import { AuthguardGuard } from '../authguard.guard';
import { AdminloginComponent } from '../adminlogin/adminlogin.component';
import { AdminhomeComponent } from '../adminhome/adminhome.component';
import { UserdetailsComponent } from '../userdetails/userdetails.component';
import { FeedbackinfoComponent } from '../feedbackinfo/feedbackinfo.component';
import { PackagedetailsComponent } from '../packagedetails/packagedetails.component';
import { PaymentsuccessComponent } from '../paymentsuccess/paymentsuccess.component';
import { UpdatepackagedetailsComponent } from '../updatepackagedetails/updatepackagedetails.component';
import { FpadminComponent } from '../fpadmin/fpadmin.component';





const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path:'login', component:LoginComponent },
    { path:'sign-up', component:SignUpComponent },
    {path:'home',component:HomeComponent},
    {
      path:'packages',canActivate:[AuthguardGuard],component:PackagesComponent
    },
    {
      path:'history',canActivate:[AuthguardGuard],component:BookinghistoryComponent
    },
    { path:'booking',canActivate:[AuthguardGuard],component:BookingComponent},
    { path:'contact',canActivate:[AuthguardGuard],component:ContactComponent},
    { path:'forgot',component:FpComponent},
    { path:'update',canActivate:[AuthguardGuard],component:UpdateComponent},
    {
      path:'feedback',canActivate:[AuthguardGuard],component:FeedbackComponent
    },
    { path:'adminlogin', component:AdminloginComponent },
    { path:'adminhome',canActivate:[AuthguardGuard], component:AdminhomeComponent },
    { path:'userdetails',canActivate:[AuthguardGuard], component:UserdetailsComponent },
    { path:'feedbackinfo',canActivate:[AuthguardGuard], component:FeedbackinfoComponent },
    { path:'paymentsuccess', canActivate:[AuthguardGuard],component:PaymentsuccessComponent },
    { path:'updatepackagedetails', canActivate:[AuthguardGuard],component:UpdatepackagedetailsComponent},
    { path:'packagedetails',canActivate:[AuthguardGuard], component:PackagedetailsComponent },
    { path:'forgotpassword',component:FpadminComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
