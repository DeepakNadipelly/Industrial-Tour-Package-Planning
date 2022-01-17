import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminhomeService } from './adminhome.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
  // adminName:String;
  // emailId:string;
  constructor(private bookingDetails:AdminhomeService,private router:Router) 
  { 
    //  this.adminName=sessionStorage.getItem("adminName");
    this.showBookingHistory();

  }
  success;
  errorMessage:string;

  ngOnInit() {
  }

  name=sessionStorage.getItem("name");
  
  logout()
  {
    sessionStorage.clear();
    this.router.navigate(["/home"]);
  }

  showBookingHistory()
  {
    this.success=null;
    this.errorMessage = null;
    this.bookingDetails.showBookingHistory()
     .then(response => {
      this.success = response;
      console.log(response);
    })
    .catch(error => {        
      this.errorMessage = "hi";
   })
}
}
