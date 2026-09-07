import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Empleado } from '../../models/empleado.model';

@Component({
  selector: 'app-empleado-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './empleado-list.component.html',
  styleUrl: './empleado-list.component.css'
})
export class EmpleadoListComponent {
  @Input() empleados: Empleado[] = [];
  @Output() cambiarEstado = new EventEmitter<number>();

  onCambiarEstado(id: number | undefined): void {
    if (id !== undefined) this.cambiarEstado.emit(id);
  }
}
