import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UpdateService } from './update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  

  successMessage:string;
  errorMessage:string;
  updateForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private updateService:UpdateService) { }

  update()
  {
    
    this.successMessage = null;
    this.errorMessage = null;
    this.updateService.update(this.updateForm.value)
      .then(response => {
        this.successMessage = response.message;
      })
      .catch(error => {        
        this.errorMessage = error.message;alert("Cannot update");
      })
  }

  ngOnInit() {
    this.updateForm =this.formBuilder.group({ 
      emailId:[sessionStorage.getItem("emailId"),[Validators.required,Validators.pattern('\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+')]],
      userName:[sessionStorage.getItem("name"),[Validators.required]],
      contactNumber:["",[Validators.required,Validators.pattern('[1-9][0-9]{9}'),Validators.maxLength(10)]],
      dateOfBirth:["",[Validators.required]],
      password:["",[Validators.required,Validators.pattern('[A-Za-z0-9@$*]+'),Validators.minLength(8)]]
    });
  }


}



