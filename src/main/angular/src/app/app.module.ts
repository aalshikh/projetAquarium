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
import { AddanimalComponent } from './addanimal/addanimal.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ConnexionComponent } from './connexion/connexion.component';
import { FormsModule } from '@angular/forms';
import { EmployeComponent } from './employe/employe.component';
import { InscriptionComponent } from './inscription/inscription.component';


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
    SecteurComponent,
    AddanimalComponent,
    ConnexionComponent,
    EmployeComponent,
    InscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
