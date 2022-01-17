import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminloginService } from './adminlogin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  successMessage:string;
  errorMessage:string;
  adminloginForm:FormGroup;
  returnUrl:string;
  adminName:string;
  // name:string;
  constructor(private formBuilder:FormBuilder,private loginService:AdminloginService, private router:Router)
   {
     sessionStorage.setItem("isUserLoggedIn",null);
     sessionStorage.setItem("name",null);
      // sessionStorage.setItem("name",null)
    }
  
  adminlogin()
  {
    
    this.successMessage = null;
    this.errorMessage = null;
    this.loginService.adminlogin(this.adminloginForm.value)
      .then(response => {
        this.successMessage = response.message;
        sessionStorage.setItem("isUserLoggedIn","true");this.adminName=response.adminName;
        // this.adminName=response.userName;
        
      sessionStorage.setItem("name",this.adminName);
      
      //  sessionStorage.setItem("name",this.name);
       this.router.navigate([this.returnUrl]);
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }

  ngOnInit() {
    this.returnUrl="/adminhome";
    this.adminloginForm =this.formBuilder.group({ 
      adminName:["",[Validators.required,Validators.email]],
      adminPassword:["",[Validators.required,Validators.minLength(8)]]
    });
  }

}

