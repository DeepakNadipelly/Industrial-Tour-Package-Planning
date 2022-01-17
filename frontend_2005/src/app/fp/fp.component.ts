import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FpService } from './fp.service';

@Component({
  selector: 'app-fp',
  templateUrl: './fp.component.html',
  styleUrls: ['./fp.component.css']
})
export class FpComponent implements OnInit {
  successMessage:string;
  errorMessage:string;
  fpForm:FormGroup;
  returnUrl:string;
  constructor(private formBuilder:FormBuilder,private fpService:FpService,private router:Router) { }

  ngOnInit() {
    this.fpForm =this.formBuilder.group({ 
      emailId:["",[Validators.required,Validators.email]],
      newPassword:["",[Validators.required,Validators.minLength(8)]],
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
        alert(this.successMessage);
        this.router.navigate(["/login"]);
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }


}
