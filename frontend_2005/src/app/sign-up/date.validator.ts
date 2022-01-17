import { AbstractControl } from "@angular/forms";

export class DateValidator {
    static checkDate(date: AbstractControl) {
        let value = new Date(date.value);
        var d=new Date();
         if(value.getTime()-d.getTime()>0 || value.getDate()==d.getDate() ) {
            return { "checkDate": true };}
         else
            return null
        
    }

}