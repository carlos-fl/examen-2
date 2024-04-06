package edu.unah.lenguajes.examen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cliente")
@Data
public class Cliente {
  @Id
  private String dni; 

  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;

}
