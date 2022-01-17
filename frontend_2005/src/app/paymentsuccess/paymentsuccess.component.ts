import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentsuccessService } from './paymentsuccess.service';
// import { Booking } from '../packages/booking';

@Component({
  selector: 'app-paymentsuccess',
  templateUrl: './paymentsuccess.component.html',
  styleUrls: ['./paymentsuccess.component.css']
})
export class PaymentsuccessComponent implements OnInit {
  success;
  errorMessage:string;
  constructor(private router:Router,private b:PaymentsuccessService) { }

  ngOnInit() {
    this.showdetails();
  }
download(){
  return xepOnline.Formatter.Format('content',{render:'download',filename:'Booking',embedLocalImages:'true',cssStyle:[{color:'#000'}]})
}
name=sessionStorage.getItem("name");

  logout()
  {
    sessionStorage.clear();
    this.router.navigate(["/home"]);
  }
  showdetails(){
    this.success=null;
    this.errorMessage = null;
    this.b.showdetails()
     .then(response => {
      this.success = response;
      console.log(this.success)
      // console.log(JSON.stringify(this.success))
      
    })
    .catch(error => {        
      this.errorMessage = "hi";
   })
  }
}
