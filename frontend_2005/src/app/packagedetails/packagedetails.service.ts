import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class PackagedetailssService {

  constructor(private http: Http) { }

  showPackages() :Promise<any>{
    
    return this.http.get('http://localhost:8765/IndustrialTourPackagePlanning_BackEnd/IndustrialTour/packages')
      .toPromise()
      .then((response => response.json()))
      .catch(error => Promise.reject(error.json() || error));
  }
  private errorHandler(error:any):Promise<any> {
  console.error("Error occured",error);    
  return Promise.reject(error.message || error);
  }


}
