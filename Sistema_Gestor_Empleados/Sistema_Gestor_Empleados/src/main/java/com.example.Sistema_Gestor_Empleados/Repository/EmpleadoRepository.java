package com.example.Sistema_Gestor_Empleados.Repository;

import com.example.Sistema_Gestor_Empleados.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
