import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class FeedbackService {

  constructor(private http: Http) { }

  feedback(data) :Promise<any>{
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/getFeedback', data)
      .toPromise()
      .then(response => response.json())
      .catch(error => Promise.reject(error.json() || error));
  }

  private errorHandler(error:any):Promise<any> {
    console.error("Error occured",error);    
    return Promise.reject(error.message || error);
    }




}
