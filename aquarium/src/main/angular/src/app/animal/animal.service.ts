import { Observable } from 'rxjs';
import { Animal } from "./animal";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class AnimalService {

    constructor(private httpClient: HttpClient){}

    getAllAnimaux() : Observable<Array<Animal>> {
        return this.httpClient.get<Array<Animal>>('/Animals');
    }

    deleteAnimal(id:number) : Observable<any> {
        return this.httpClient.delete('/Animals/' + id);
    }
}