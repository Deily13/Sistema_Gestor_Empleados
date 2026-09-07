package com.example.Sistema_Gestor_Empleados.Controllers;

import com.example.Sistema_Gestor_Empleados.Model.Empleado;
import com.example.Sistema_Gestor_Empleados.Service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

  import java.util.List;
@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

  private final EmpleadoService EmpleadoService;

  @GetMapping
  public ResponseEntity<List<Empleado>> listarEmpleados() {
    return ResponseEntity.ok(EmpleadoService.listarEmpleados());
  }

  @PostMapping
  public ResponseEntity<Empleado> registrarEmpleado(@Valid @RequestBody Empleado empleado) {
    Empleado nuevo = EmpleadoService.registrarEmpleado(empleado);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
  }

  @PutMapping("/{id}/asistencia")
  public ResponseEntity<Empleado> cambiarEstado(@PathVariable Long id) {
    return ResponseEntity.ok(EmpleadoService.cambiarEstadoAsistencia(id));
  }
}
