import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BookingService } from './booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  successMessage:string;
  errorMessage:string;
  bookingForm:FormGroup;
  payFullForm:FormGroup;
  success:string;
  cost:Number;
  payForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private bookService:BookingService,private router:Router) { }
  flag=true;

  pay()
  {
    this.flag=true;
    this.successMessage = null;
    this.errorMessage = null;

    this.payFullForm=this.formBuilder.group(
      {
        emailId:[this.bookingForm.controls.emailId.value,""],
        packageId:[this.bookingForm.controls.packageId.value,""],
        contactNumber:[this.bookingForm.controls.contactNumber.value,""],
        startDate:[this.bookingForm.controls.startDate.value,""],
        endDate:[this.bookingForm.controls.endDate.value,""],
        numberOfPeople:[this.bookingForm.controls.numberOfPeople.value,""],
        nameOnCard:[this.payForm.controls.nameOnCard.value,""],
        cardNumber:[this.payForm.controls.cardNumber.value,""],
        cvv:[this.payForm.controls.cvv.value,""],
        expiryMonth:[this.payForm.controls.expiryMonth.value,""],
        expiryYear:[this.payForm.controls.expiryYear.value,""]
      })
    this.bookService.pay(this.payFullForm.value)
      .then(response => {
        this.successMessage = response.message;
        // alert(this.successMessage);
        this.router.navigate(["/paymentsuccess"])
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }

  calculateCost(){
    this.success=null;
     this.errorMessage = null;
     this.bookService.calculateCost(this.bookingForm.value)
      .then(response => {
       this.success = response.message;this.cost=response.calculatedCost;
     })
     .catch(error => {        
       this.errorMessage = error.message;
    })
    
  }
  download(){
    return xepOnline.Formatter.Format('content',{render:'download'})
  }

  book()
  {
    this.flag=false;
  }

  name=sessionStorage.getItem("name");

  logout()
  {
    sessionStorage.clear();
    this.router.navigate(["/home"]);
  }


  ngOnInit() {

    this.bookingForm =this.formBuilder.group({ 
      emailId:[sessionStorage.getItem("emailId"),[Validators.required,Validators.pattern('\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+')]],
      packageId:["",[Validators.required]],
      contactNumber:["",[Validators.required,Validators.pattern('[1-9][0-9]{9}'),Validators.maxLength(10)]],
      startDate:["",Validators.required],
      endDate:["",Validators.required],
      numberOfPeople:["",Validators.required]
    });
   this.payForm=this.formBuilder.group(
     {
      nameOnCard:["",""],
      cardNumber:["",""],
      cvv:["",""],
      expiryMonth:["",""],
      expiryYear:["",""]
     })
    


  }
}
