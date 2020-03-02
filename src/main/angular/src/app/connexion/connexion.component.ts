import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { EmployeService } from "../employe/employe.service";
import { Employe } from "../employe/employe";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  pseudoValeur="";
  mdpValeur ="";
  private employes:Array<Employe>;

  connexionEtablie;


  constructor(private employeService: EmployeService) { }

  ngOnInit() {
    this.recupAllEmployes();
    this.connexionEtablie = JSON.parse(localStorage.getItem('pseudo'));
  }

  recupAllEmployes(){
    this.employeService.getAllEmployes().subscribe(data => {
      this.employes = data;
      console.log(this.employes);
    })
  }

  button(){
    if(this.verifPseudoMdp()!=''){
    localStorage.setItem('pseudo', JSON.stringify(true));
    window.location.reload();
    alert("TRUE");
    } else {
      localStorage.setItem('pseudo', JSON.stringify(false));
    }
  }

  pseudo($event){
    this.pseudoValeur = $event.target.value;

  }

  password($event){
    this.mdpValeur = $event.target.value;
  }

  verifPseudoMdp(){
    for(var i =0; i < this.employes.length; i++){
      if(this.employes[i].pseudo == this.pseudoValeur && this.employes[i].mdp == this.mdpValeur){
        return this.pseudoValeur;
      }
    }
    return '';
  }

  deconnexion(){
    localStorage.setItem('pseudo', JSON.stringify(false));
    window.location.reload();

  }

}
