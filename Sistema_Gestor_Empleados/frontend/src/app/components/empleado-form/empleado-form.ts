import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Empleado } from '../../models/empleado.model';

@Component({
  selector: 'app-empleado-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './empleado-form.html',
  styleUrl: './empleado-form.css'
})
export class EmpleadoForm {
  @Output() registrar = new EventEmitter<Empleado>();

  nombreCompleto = '';
  puesto = '';

  onSubmit(): void {
    if (!this.nombreCompleto.trim() || !this.puesto.trim()) return;
    this.registrar.emit({ nombreCompleto: this.nombreCompleto, puesto: this.puesto });
    this.nombreCompleto = '';
    this.puesto = '';
  }
}
