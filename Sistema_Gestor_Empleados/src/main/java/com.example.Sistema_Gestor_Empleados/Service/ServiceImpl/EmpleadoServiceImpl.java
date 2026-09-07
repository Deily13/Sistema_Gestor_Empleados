package com.example.Sistema_Gestor_Empleados.Service.ServiceImpl;

import com.example.Sistema_Gestor_Empleados.Model.Empleado;
import com.example.Sistema_Gestor_Empleados.Model.Empleado.EstadoAsistencia;
import com.example.Sistema_Gestor_Empleados.Repository.EmpleadoRepository;
import com.example.Sistema_Gestor_Empleados.Service.EmpleadoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

  private final EmpleadoRepository EmpleadoRepository;

  @Override
  public List<Empleado> listarEmpleados() {
    return EmpleadoRepository.findAll();
  }

  @Override
  public Empleado registrarEmpleado(Empleado empleado) {
    empleado.setEstado(EstadoAsistencia.AUSENTE);
    return EmpleadoRepository.save(empleado);
  }

  @Override
  public Empleado cambiarEstadoAsistencia(Long id) {
    Empleado empleado = EmpleadoRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con id: " + id));

    EstadoAsistencia nuevoEstado = empleado.getEstado() == EstadoAsistencia.PRESENTE
      ? EstadoAsistencia.AUSENTE
      : EstadoAsistencia.PRESENTE;

    empleado.setEstado(nuevoEstado);
    return EmpleadoRepository.save(empleado);
  }
}
