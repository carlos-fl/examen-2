package edu.unah.lenguajes.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.lenguajes.examen.dto.MovimientoDto;
import edu.unah.lenguajes.examen.entities.Movimientos;
import edu.unah.lenguajes.examen.services.servicesImpl.MovimientosServiceImpl;

@RestController
@RequestMapping("/api")
public class MovimientosController {

  @Autowired
  private MovimientosServiceImpl movimientosService;

  @PostMapping("/movimientos/crear")
  private Movimientos crearMovimientos(MovimientoDto movimiento) {
    return this.movimientosService.createMovimiento(movimiento);
  }
}
