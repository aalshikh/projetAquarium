import { Bassin } from "../bassin/bassin";

export interface Animal {
    id:number;
    nom:string;
    espece:string;
    sexe:string;
    signeDistinctif:string;
    bilanSante:string;
    dateArr:Date;
    dateDep:Date;
    taille:number;
    age:number;
    //bassinAppartenance:number;
    bassin:Bassin;
}