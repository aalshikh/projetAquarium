import { Component, OnInit } from '@angular/core';
import * as $ from "jquery";

@Component({
  selector: 'app-fondanime',
  templateUrl: './fondanime.component.html',
  styleUrls: ['./fondanime.component.css']
})
export class FondanimeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    //   $(function(){
    //     setInterval(function(){
    //       $(".slideshow ul").animate({marginLeft:-350},800,function(){
    //           $(this).css({marginLeft:0}).find("li:last").after($(this).find("li:first"));
    //       })
    //     }, 3500);
    // });
    
  }

  

}
