import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserdetailsService } from './userdetails.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

  constructor(private bookingDetails:UserdetailsService,private router:Router) 
  { 
    //  this.adminName=sessionStorage.getItem("adminName");
    this.userDetails();

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

  userDetails()
  {
    this.success=null;
    this.errorMessage = null;
    this.bookingDetails.userDetails()
     .then(response => {
      this.success = response;
     
    })
    .catch(error => {        
      this.errorMessage = "hi";
   })
}
}

