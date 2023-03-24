import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CajaComponent } from './componentes/caja/caja.component';
import { CargaComponent } from './componentes/carga/carga.component';

const routes: Routes = [
  {path:'', component: CajaComponent},
  {path:'carga', component: CargaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
