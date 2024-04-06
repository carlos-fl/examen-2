package edu.unah.lenguajes.examen.services.servicesImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.lenguajes.examen.dto.MovimientoDto;
import edu.unah.lenguajes.examen.entities.Cuentas;
import edu.unah.lenguajes.examen.entities.Movimientos;
import edu.unah.lenguajes.examen.repositories.CuentasRepository;
import edu.unah.lenguajes.examen.repositories.MovimientosRepository;
import edu.unah.lenguajes.examen.services.MovimientosService;

@Service
public class MovimientosServiceImpl implements MovimientosService {

  @Autowired
  private MovimientosRepository movimientosRepo;

  @Autowired
  private CuentasRepository cuentasRepo;

  @Override
  public Movimientos createMovimiento(MovimientoDto movimiento) {
    if (!this.cuentasRepo.existsById(movimiento.getNumeroCuenta()))
      return null;

    if (this.cuentasRepo.findById(movimiento.getNumeroCuenta()).get().isEstado() == false)
      return null;
      
    Cuentas cuenta = this.cuentasRepo.findById(movimiento.getNumeroCuenta()).get();
    if (this.cuentasRepo.findById(movimiento.getNumeroCuenta()).get().isEstado()) {
      if (movimiento.getTipoMovimiento() == 'C') {
        cuenta.setSaldo(cuenta.getSaldo() + movimiento.getMonto());
        this.cuentasRepo.save(cuenta);
      }
      if (movimiento.getTipoMovimiento() == 'D') {
        if (cuenta.getSaldo() > 0 || (cuenta.getSaldo() < 0 && cuenta.isSobregiro() == true)) {
          cuenta.setSaldo(cuenta.getSaldo() - movimiento.getMonto());
          this.cuentasRepo.save(cuenta);
        }
      }

      
    }
    
    Movimientos nuevoMovimiento = new Movimientos();
    nuevoMovimiento.setCuenta(cuenta);
    if (movimiento.getTipoMovimiento() == 'C' || movimiento.getTipoMovimiento() == 'D')
      nuevoMovimiento.setTipoMovimiento(movimiento.getTipoMovimiento());

    nuevoMovimiento.setMonto(movimiento.getMonto());
    nuevoMovimiento.setFechaMovimiento(LocalDate.now());

    return this.movimientosRepo.save(nuevoMovimiento);

  }

  @Override
  public List<Movimientos> getMovimientosPorCuenta(String numeroCuenta) {
    if (!this.cuentasRepo.existsById(numeroCuenta))
      return null;

    Cuentas cuenta = this.cuentasRepo.findById(numeroCuenta).get();
    return cuenta.getMovimientos();
  }
  
}
