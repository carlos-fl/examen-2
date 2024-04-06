package edu.unah.lenguajes.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.lenguajes.examen.entities.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
  
}
