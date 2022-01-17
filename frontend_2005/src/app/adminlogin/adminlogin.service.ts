import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AdminloginService {

  constructor(private http: Http) { }
  isUserLoggedIn:string;
  
  setUserLoggedIn(){
    sessionStorage.setItem("isUserLoggedIn","true");
  
    
  }

  getUserLoggedIn(){
    this.isUserLoggedIn= sessionStorage.getItem("isUserLoggedIn");
    return this.isUserLoggedIn;
  }

  adminlogin(data) :Promise<any>{
    
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/adminLogin', data)
      .toPromise()
      .then(response => response.json())
      .catch(error => Promise.reject(error.json() || error));
  }
  private errorHandler(error:any):Promise<any> {
  console.error("Error occured",error);    
  return Promise.reject(error.message || error);
  }

} 