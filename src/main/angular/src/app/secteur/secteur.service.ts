import { Observable } from 'rxjs';
import { Secteur } from "./secteur";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class SecteurService {

    constructor(private httpClient: HttpClient){}

    getAllSecteurs() : Observable<Array<Secteur>> {
        return this.httpClient.get<Array<Secteur>>('/Secteurs');
    }
}