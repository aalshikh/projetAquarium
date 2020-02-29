import { Component, OnInit } from '@angular/core';
import { AnimalService } from "./animal.service";
import { Animal } from "./animal";
import { Bassin } from "../bassin/bassin";

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {

  private nomEspece:string;
  private animaux:Array<Animal>;
  private especeAnimalPresente:Array<string>;
  private especeAnimalPresenteTmp:Array<string>;
  constructor(private animalService: AnimalService) { 
    this.especeAnimalPresenteTmp = [];
  }

  ngOnInit() {
    this.recupAllAnimals();
  }

  supprimerAnimal(id:number){
    this.animalService.deleteAnimal(id);
  }

  recupAllAnimals(){
    this.animalService.getAllAnimaux().subscribe(data => {
      this.animaux = data;
      this.recupEspecePresent();
      console.log(this.animaux);
    })
    
  }

  recupEspecePresent(){
     if (this.animaux){
      for (let animal of this.animaux) {
          this.especeAnimalPresenteTmp.push(animal.espece);
      }
      this.especeAnimalPresente = this.removeDuplicates(this.especeAnimalPresenteTmp);
     }
  }

  removeDuplicates(array) {
    let unique = {};
    array.forEach(function(i) {
      if(!unique[i]) {
        unique[i] = true;
      }
    });
    return Object.keys(unique);
  }

  retourneAnimal(){
    return this.animaux;
  }

  changeEspeceChoisi(a){
    //alert(a);
    this.nomEspece=a;
    //alert(this.nomEspece);
  }

  retourneEspece(){
    return this.nomEspece;
  }

}
