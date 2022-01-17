import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PackagedetailssService } from './packagedetails.service';

@Component({
  selector: 'app-packagedetails',
  templateUrl: './packagedetails.component.html',
  styleUrls: ['./packagedetails.component.css']
})
export class PackagedetailsComponent implements OnInit {

  constructor(private packageDetails:PackagedetailssService,private router:Router) {this.showPackages() }
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
  
  showPackages()
   {
     this.success=null;
     this.errorMessage = null;
     this.packageDetails.showPackages()
      .then(response => {
       this.success = response;
     })
     .catch(error => {        
       this.errorMessage = error.message;
    })
   }
}



