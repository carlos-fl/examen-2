package edu.unah.lenguajes.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.lenguajes.examen.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
  
}
