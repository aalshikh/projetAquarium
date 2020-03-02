import { Observable } from 'rxjs';
import { Employe } from "./employe";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class EmployeService {

        employe;
    constructor(private httpClient: HttpClient){}

    getAllEmployes() : Observable<Array<Employe>> {
        return this.httpClient.get<Array<Employe>>('/Employes');
    }

    createEmploye(employe:Employe) : Observable<any> {
        return this.httpClient.post('/Employes', (employe));
    }

}