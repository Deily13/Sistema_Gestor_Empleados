package com.example.Sistema_Gestor_Empleados.Service;

import com.example.Sistema_Gestor_Empleados.Model.Empleado;

import java.util.List;

public interface EmpleadoService {
  List<Empleado> listarEmpleados();
  Empleado registrarEmpleado(Empleado empleado);
  Empleado cambiarEstadoAsistencia(Long id);
}
