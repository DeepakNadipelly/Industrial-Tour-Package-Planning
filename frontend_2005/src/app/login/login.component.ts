import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logincomponent',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  successMessage:string;
  errorMessage:string;
  loginForm:FormGroup;
  returnUrl:string;
  emailId:string;
  name:string;
  constructor(private formBuilder:FormBuilder,private loginService:LoginService, private router:Router)
   {
     sessionStorage.setItem("isUserLoggedIn",null);
     sessionStorage.setItem("emailId",null);
     sessionStorage.setItem("name",null)
    }
  
  login()
  {
    
    this.successMessage = null;
    this.errorMessage = null;
    this.loginService.login(this.loginForm.value)
      .then(response => {
        this.successMessage = response.message;
        sessionStorage.setItem("isUserLoggedIn","true");this.emailId=response.emailId;
        this.name=response.userName;
       sessionStorage.setItem("emailId",this.emailId);
       sessionStorage.setItem("name",this.name);
       this.router.navigate([this.returnUrl]);
      })
      .catch(error => {        
        this.errorMessage = error.message;alert("Enter valid credentials");
      })
  }

  ngOnInit() {
    this.returnUrl="/packages";
    this.loginForm =this.formBuilder.group({ 
      emailId:["",[Validators.required,Validators.email]],
      password:["",[Validators.required,Validators.minLength(8)]]
    });
  }

}
