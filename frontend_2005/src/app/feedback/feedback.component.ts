import { Component, OnInit } from '@angular/core';
import { FeedbackService } from './feedback.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  successMessage:string;
  errorMessage:string;
  feedbackForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private feedbackService:FeedbackService,private router:Router) { }

  ngOnInit() {
    this.feedbackForm =this.formBuilder.group({ 
      emailId:[sessionStorage.getItem("emailId"),[Validators.required,Validators.email]],
      userName:[sessionStorage.getItem("name"),[Validators.required]],
      subject:["",[Validators.required]],
      description:["",[Validators.required]],
      bookingId:["",[Validators.required]]
    });
  }
  
  feedback(){
    this.successMessage=null;
     this.errorMessage = null;
     this.feedbackService.feedback(this.feedbackForm.value)
      .then(response => {
       this.successMessage = response.message;alert(this.successMessage);
     })
     .catch(error => {        
       this.errorMessage = error.message;alert("Cannot provide feedback");
    })
}

name=sessionStorage.getItem("name");

logout()
  {
    sessionStorage.clear();
    this.router.navigate(["/home"]);
  }

}
