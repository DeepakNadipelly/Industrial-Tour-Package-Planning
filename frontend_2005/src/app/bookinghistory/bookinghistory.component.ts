import { Component, OnInit } from '@angular/core';
import { BookingHistoryService } from './bookinghistory.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookinghistory',
  templateUrl: './bookinghistory.component.html',
  styleUrls: ['./bookinghistory.component.css']
})
export class BookinghistoryComponent implements OnInit {
  emailId:string;
  constructor(private bookingDetails:BookingHistoryService,private router:Router) 
  { 
    this.emailId=sessionStorage.getItem("emailId");
    this.showBookingHistory(this.emailId);

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

  showBookingHistory(data)
  {
    this.success=null;
    this.errorMessage = null;
    this.bookingDetails.showBookingHistory(data)
     .then(response => {
      this.success = response;
    })
    .catch(error => {        
      this.errorMessage = "hi";
   })
}
}
