export type EstadoAsistencia = 'PRESENTE' | 'AUSENTE';

export interface Empleado {
  id?: number;
  nombreCompleto: string;
  puesto: string;
  estado?: EstadoAsistencia;
}
