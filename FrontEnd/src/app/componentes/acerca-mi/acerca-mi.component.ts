import { Component } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { personaService } from 'src/app/servicio/usuario.service';


@Component({
  selector: 'app-acerca-mi',
  templateUrl: './acerca-mi.component.html',
  styleUrls: ['./acerca-mi.component.css']
})
export class AcercaMiComponent {
   persona: persona = new persona("","","");
   
   constructor(public personaService: personaService){ }

   ngOnInit(): void{
    this.personaService.getPersona().subscribe(data => {this.persona=data})
   }
}
