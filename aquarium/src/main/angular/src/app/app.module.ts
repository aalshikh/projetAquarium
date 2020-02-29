import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HeaderComponent } from './header/header.component';
import { FondanimeComponent } from './fondanime/fondanime.component';
import { BandebiodiversiteComponent } from './bandebiodiversite/bandebiodiversite.component';
import { AnimalComponent } from './animal/animal.component';
import { HttpClientModule } from '@angular/common/http';
import { AnimalespeceComponent } from './animalespece/animalespece.component';
import { BassinComponent } from './bassin/bassin.component';
import { SecteurComponent } from './secteur/secteur.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    FondanimeComponent,
    BandebiodiversiteComponent,
    AnimalComponent,
    AnimalespeceComponent,
    BassinComponent,
    SecteurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
