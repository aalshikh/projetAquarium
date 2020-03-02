import { Observable } from 'rxjs';
import { Bassin } from "./bassin";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class BassinService {

    constructor(private httpClient: HttpClient){}

    getAllBassins() : Observable<Array<Bassin>> {
        return this.httpClient.get<Array<Bassin>>('/Bassins');
    }
}