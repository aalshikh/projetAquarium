import { Component, OnInit } from '@angular/core';
import { SecteurService } from "./secteur.service";
import { Secteur } from "./secteur";

@Component({
  selector: 'app-secteur',
  templateUrl: './secteur.component.html',
  styleUrls: ['./secteur.component.css']
})
export class SecteurComponent implements OnInit {

  private secteurs:Array<Secteur>;

  constructor(private secteurService: SecteurService) { }

  ngOnInit() {
    this.recupAllSecteurs();
  }

  recupAllSecteurs(){
    this.secteurService.getAllSecteurs().subscribe(data => {
      this.secteurs = data;
      console.log(this.secteurs);
    })
    
  }

}
