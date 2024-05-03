import { Component, Output ,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-core',
  standalone: true,
  imports: [],
  templateUrl: './core.component.html',
  styleUrl: './core.component.css'
})
export class CoreComponent {
   @Output() onSubmitLoginEven = new EventEmitter();
   email: string = "";
   password: string = "";

   onSubmitLogin(): void{
    this.onSubmitLoginEven.emit({"email":this.email,"password":this.password});
   }
}
