package edu.unah.lenguajes.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.lenguajes.examen.entities.Movimientos;

public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {
  
}
