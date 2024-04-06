package edu.unah.lenguajes.examen.dto;

import lombok.Data;

@Data
public class MovimientoDto {
  private String numeroCuenta;
  private char tipoMovimiento;
  private double monto; 
}
