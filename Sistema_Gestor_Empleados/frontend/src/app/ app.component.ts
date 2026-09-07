import { Component, OnInit } from '@angular/core';
import { EmpleadoList } from './components/empleado-list/empleado-list';
import { EmpleadoForm } from './components/empleado-form/empleado-form';
import { EmpleadoService } from './services/empleado.service';
import { Empleado } from './models/empleado.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [EmpleadoList, EmpleadoForm],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  empleados: Empleado[] = [];

  constructor(private empleadoService: EmpleadoService) {}

  ngOnInit(): void {
    this.cargarEmpleados();
  }

  cargarEmpleados(): void {
    this.empleadoService.listarEmpleados().subscribe({
      next: (data) => (this.empleados = data),
      error: (err) => console.error('Error al listar empleados', err)
    });
  }

  onRegistrar(empleado: Empleado): void {
    this.empleadoService.registrarEmpleado(empleado).subscribe({
      next: () => this.cargarEmpleados(),
      error: (err) => console.error('Error al registrar empleado', err)
    });
  }

  onCambiarEstado(id: number): void {
    this.empleadoService.cambiarEstado(id).subscribe({
      next: () => this.cargarEmpleados(),
      error: (err) => console.error('Error al cambiar estado', err)
    });
  }
}
