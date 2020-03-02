import { Component, OnInit } from '@angular/core';
import { BassinService } from "./bassin.service";
import { Bassin } from "./bassin";

@Component({
  selector: 'app-bassin',
  templateUrl: './bassin.component.html',
  styleUrls: ['./bassin.component.css']
})
export class BassinComponent implements OnInit {

  private bassins:Array<Bassin>;

  constructor(private bassinService: BassinService) { }

  ngOnInit() {
    this.recupAllBassins();
  }

  recupAllBassins(){
    this.bassinService.getAllBassins().subscribe(data => {
      this.bassins = data;
      console.log(this.bassins);
    })
    
  }

}
