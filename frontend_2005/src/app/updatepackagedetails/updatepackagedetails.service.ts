import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UpdatepackagedetailsService {

  constructor(private http: Http) { }

  update(data) :Promise<any>{
    
    return this.http.post('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/adminAddOrUpdatePackage', data)
      .toPromise()
      .then(response => response.json())
      .catch(error => Promise.reject(error.json() || error));
  }

}
