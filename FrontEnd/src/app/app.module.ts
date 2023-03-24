import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { AcercaMiComponent } from './componentes/acerca-mi/acerca-mi.component';
import { EstudiosComponent } from './componentes/estudios/estudios.component';
import { GraficosComponent } from './componentes/graficos/graficos.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { ProyectosComponent } from './componentes/proyectos/proyectos.component';
import { FinalComponent } from './componentes/final/final.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { CajaComponent } from './componentes/caja/caja.component';
import { CargaComponent } from './componentes/carga/carga.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    AcercaMiComponent,
    EstudiosComponent,
    GraficosComponent,
    ExperienciaComponent,
    ProyectosComponent,
    FinalComponent,
    CajaComponent,
    CargaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgCircleProgressModule.forRoot({}),
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
