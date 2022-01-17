import { Component, OnInit } from '@angular/core';
import { SignUpService } from './sign-up.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateValidator } from './date.validator';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  successMessage:string;
  errorMessage:string;
  signUpForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private signUpService:SignUpService) { }

  signup()
  {
    
    this.successMessage = null;
    this.errorMessage = null;
    this.signUpService.signup(this.signUpForm.value)
      .then(response => {
        this.successMessage = response.message;
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }

  ngOnInit() {
    this.signUpForm =this.formBuilder.group({ 
      emailId:["",[Validators.required,Validators.pattern('\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+')]],
      userName:["",[Validators.required]],
      contactNumber:["",[Validators.required,Validators.pattern('[1-9][0-9]{9}'),Validators.maxLength(10)]],
      dateOfBirth:["",[Validators.required, DateValidator.checkDate]],
      password:["",[Validators.required,Validators.pattern('[A-Za-z0-9@$*]+'),Validators.minLength(8)]]
    });
  }


}
