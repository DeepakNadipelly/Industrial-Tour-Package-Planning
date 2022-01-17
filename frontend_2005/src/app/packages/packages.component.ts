import { Component, OnInit } from '@angular/core';
import { PackageDetailsService } from './packages.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-packages',
  templateUrl: './packages.component.html',
  styleUrls: ['./packages.component.css']
})
export class PackagesComponent implements OnInit {

  constructor(private packageDetails:PackageDetailsService,private router:Router) {this.showPackages() }
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
