import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { EmployeService } from "../employe/employe.service";
import { Employe } from "../employe/employe";
import { ReactiveFormsModule, FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  private employe:Employe;
  formGroupAjout: FormGroup;
  constructor(private formBuilder : FormBuilder, private employeService: EmployeService) { }

  @Output()
  create = new EventEmitter<Employe>();

  ngOnInit() {
    this.formGroupAjout = this.formBuilder.group({
      pseudo : new FormControl(''),
      mdp : new FormControl('')
    })
  }


  inscription(){
    this.employe = this.formGroupAjout.value;
    this.employeService.createEmploye(this.employe).subscribe(data => {
      this.employe = data;
      this.create.emit(this.employe);
    })
  }

}
