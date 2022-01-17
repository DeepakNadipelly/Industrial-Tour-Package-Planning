import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class BookingService {

  constructor(private http: Http) { }

  // booking(data) :Promise<any>{
    
  //   return this.http.post("http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/makeBooking",data)
  //     .toPromise()
  //     .then(response => response.json())
  //     .catch(error => Promise.reject(error.json() || error));
  // }

  pay(data) :Promise<any>{
    
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/makePayment', data)
      .toPromise()
      .then(response => response.json())
      .catch(error => Promise.reject(error.json() || error));
  }


  calculateCost(data) :Promise<any>{
    
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/calculateCost', data)
      .toPromise()
      .then(response => response.json())
      .catch(error => Promise.reject(error.json() || error));
  }

  private errorHandler(error:any):Promise<any> {
    console.error("Error occured",error);    
    return Promise.reject(error.message || error);
    }




}
