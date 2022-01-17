import { Component, OnInit } from '@angular/core';
import { FeedbackinfoService } from './feedbackinfo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedbackinfo',
  templateUrl: './feedbackinfo.component.html',
  styleUrls: ['./feedbackinfo.component.css']
})
export class FeedbackinfoComponent implements OnInit {

  constructor(private bookingDetails:FeedbackinfoService,private router:Router) 
  { 
    //  this.adminName=sessionStorage.getItem("adminName");
    this.showFeedback();

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

  showFeedback()
  {
    this.success=null;
    this.errorMessage = null;
    this.bookingDetails.showFeedback()
     .then(response => {
      this.success = response;
      console.log(response);
    })
    .catch(error => {        
      this.errorMessage = "hi";
   })
}
}



