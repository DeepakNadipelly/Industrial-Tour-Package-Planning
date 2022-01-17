import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UpdatepackagedetailsService } from './updatepackagedetails.service';

@Component({
  selector: 'app-updatepackagedetails',
  templateUrl: './updatepackagedetails.component.html',
  styleUrls: ['./updatepackagedetails.component.css']
})
export class UpdatepackagedetailsComponent implements OnInit {
  updatePackageForm:FormGroup;
  successMessage:string;
  errorMessage:string;
  constructor(private formBuilder:FormBuilder,private router:Router,private us:UpdatepackagedetailsService) { }

  ngOnInit() {
    this.updatePackageForm =this.formBuilder.group({ 
      packageId:["",[Validators.required,]],
      packageName:["",[Validators.required]],
      location:["",[Validators.required]],
      numberOfDays:["",[Validators.required]],
      pricePerHead:["",[Validators.required]],
      placesIncluded:["",[Validators.required]],
      
     
    });
  }
  name1=sessionStorage.getItem("name");

  logout()
  {
    sessionStorage.clear();
    this.router.navigate(["/home"]);
  }

update(data)
  {
    alert(JSON.stringify(this.updatePackageForm.value))
    this.successMessage = null;
    this.errorMessage = null;
    this.us.update(this.updatePackageForm.value)
      .then(response => {
        this.successMessage = response.message;
      })
      .catch(error => {        
        this.errorMessage = error.message;
      })
  }
}