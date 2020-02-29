import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnimalComponent } from './animal/animal.component';
import { BassinComponent } from './bassin/bassin.component';
import { SecteurComponent } from './secteur/secteur.component'

const routes: Routes = [
  // { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'animal', component: AnimalComponent },
  { path: 'bassin', component: BassinComponent },
  { path: 'secteur', component: SecteurComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
