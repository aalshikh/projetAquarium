import { Component, OnInit, Input, Output } from '@angular/core';
import { Animal } from "../animal/animal";
import { AnimalService } from "../animal/animal.service";
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-animalespece',
  templateUrl: './animalespece.component.html',
  styleUrls: ['./animalespece.component.css']
})
export class AnimalespeceComponent implements OnInit {

@Output()
delete = new EventEmitter<Boolean>();

  @Input()
  private animaux:Array<Animal>;
  
  
  private _nomEspece:string;


  private verifConnexion=false;
  
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

  constructor(private animalService: AnimalService) {
    this.listeAnimauxEspece = [];
  }

  ngOnInit() {
    this.filtreAnimauxEspece();
    this.verifConnexion = JSON.parse(localStorage.getItem('pseudo'));
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

  supprimerAnimal(id:number){
    this.animalService.deleteAnimal(id).subscribe(data => {
      this.delete.emit(true);
      
    })
    
  }
}
