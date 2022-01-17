import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class BookingHistoryService {

  constructor(private http: Http) { }

  showBookingHistory(data) :Promise<any>{
    
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/getBookingHistory',data)
      .toPromise()
      .then((response => response.json()))
      .catch(error => Promise.reject(error.json() || error));
  }
  private errorHandler(error:any):Promise<any> {
  console.error("Error occured",error);    
  return Promise.reject(error.message || error);
  }

} 