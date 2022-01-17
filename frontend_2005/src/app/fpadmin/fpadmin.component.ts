import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { FpAdminService } from './fpadmin.service';


@Component({
  selector: 'app-fpadmin',
  templateUrl: './fpadmin.component.html',
  styleUrls: ['./fpadmin.component.css']
})
export class FpadminComponent implements OnInit {
  successMessage:string;
  errorMessage:string;
  fpForm:FormGroup;
  returnUrl:string;
  constructor(private formBuilder:FormBuilder,private fpService:FpAdminService,private router:Router) { }

  ngOnInit() {
    this.fpForm =this.formBuilder.group({ 
      adminName:["",[Validators.required,Validators.email]],
      adminNewPassword:["",[Validators.required,Validators.minLength(8)]],
      cpassword:["",[Validators.required,Validators.minLength(8)]]
    });
  }
  change()
  {
    
    this.successMessage = null;
    this.errorMessage = null;
    this.fpService.change(this.fpForm.value)
      .then(response => {
        this.successMessage = response.message;
        this.router.navigate(["/adminlogin"]);
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }



}
