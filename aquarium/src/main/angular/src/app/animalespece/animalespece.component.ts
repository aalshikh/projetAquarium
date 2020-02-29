import { Component, OnInit, Input } from '@angular/core';
import { Animal } from "../animal/animal";

@Component({
  selector: 'app-animalespece',
  templateUrl: './animalespece.component.html',
  styleUrls: ['./animalespece.component.css']
})
export class AnimalespeceComponent implements OnInit {

  @Input()
  private animaux:Array<Animal>;
  
  
  private _nomEspece:string;
  @Input()
  set nomEspece(nom:string) {
    // update value
    this._nomEspece = nom;
    // update list
    this.listeAnimauxEspece = [];
    this.filtreAnimauxEspece();
  }
  get nomEspece():string {
    return this._nomEspece;
  }
  
  private listeAnimauxEspece:Array<Animal>;

  constructor() {
    this.listeAnimauxEspece = [];
  }

  ngOnInit() {
    this.filtreAnimauxEspece();
  }

  filtreAnimauxEspece(){
    if (this.animaux){
      for (let animal of this.animaux) {
        if (animal.espece == this.nomEspece){
          this.listeAnimauxEspece.push(animal);
        }
      }
    }
  }

}
