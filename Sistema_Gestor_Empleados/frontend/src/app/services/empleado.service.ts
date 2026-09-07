import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleado } from '../models/empleado.model';
import { environment } from '../environments/environment';

@Injectable({ providedIn: 'root' })
export class EmpleadoService {
  private readonly apiUrl = `${environment.apiUrl}/empleados`;

  constructor(private http: HttpClient) {}

  listarEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.apiUrl);
  }

  registrarEmpleado(empleado: Empleado): Observable<Empleado> {
    return this.http.post<Empleado>(this.apiUrl, empleado);
  }

  cambiarEstado(id: number): Observable<Empleado> {
    return this.http.put<Empleado>(`${this.apiUrl}/${id}/asistencia`, {});
  }
}
