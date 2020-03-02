import { Component, OnInit, Input } from '@angular/core';
import { AnimalService } from "../animal/animal.service";
import { Animal } from "../animal/animal";
import { ReactiveFormsModule, FormGroup, FormControl, FormBuilder } from '@angular/forms';



@Component({
  selector: 'app-addanimal',
  templateUrl: './addanimal.component.html',
  styleUrls: ['./addanimal.component.css']
})
export class AddanimalComponent implements OnInit {

  // @Input()
   private animal:Animal;

   formGroupAjout: FormGroup;

  // constructor(private animalService: AnimalService, private formBuilder:FormBuilder) { }
  constructor(private formBuilder : FormBuilder, private animalService: AnimalService) { }
  ngOnInit() {
    this.formGroupAjout = this.formBuilder.group({
      espece : new FormControl(''),
      nom : new FormControl(''),
      sexe : new FormControl(''),
      signeDistinctif : new FormControl(''),
      bilanSante : new FormControl(''),
      dateArr : new FormControl(''),
      dateDep : new FormControl(''),
      taille : new FormControl(''),
      age : new FormControl(''),
      bassin : new FormControl('')

  
    })
  }
  
   ajouterAnimal(){
     this.animal = this.formGroupAjout.value;
     this.animal.dateArr = null;

     this.animal.dateDep = null;
     this.animal.bassin = null;
     //this.bzssinService.getOne(id).subscribe(){
     //  data => this.animal.bassin = data;
     //}
     console.log(this.animal);
     console.log("ett");
     
     this.animalService.createAnimal(this.animal).subscribe(data => {
       this.animal = data;
       console.log(this.animal);
     })
   }
}
