package edu.unah.lenguajes.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.lenguajes.examen.entities.Cuentas;

public interface CuentasRepository extends JpaRepository<Cuentas, String> {
  
}
