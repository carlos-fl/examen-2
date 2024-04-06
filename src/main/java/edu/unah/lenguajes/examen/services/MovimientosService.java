package edu.unah.lenguajes.examen.services;

import java.util.List;

import edu.unah.lenguajes.examen.dto.MovimientoDto;
import edu.unah.lenguajes.examen.entities.Movimientos;

public interface MovimientosService {
  public Movimientos createMovimiento(MovimientoDto movimiento);

  public List<Movimientos> getMovimientosPorCuenta(String numeroCuenta);
  
}
