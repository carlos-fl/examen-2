package edu.unah.lenguajes.examen.services.servicesImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.lenguajes.examen.entities.Cliente;
import edu.unah.lenguajes.examen.entities.Cuentas;
import edu.unah.lenguajes.examen.entities.Movimientos;
import edu.unah.lenguajes.examen.repositories.ClienteRepository;
import edu.unah.lenguajes.examen.repositories.CuentasRepository;
import edu.unah.lenguajes.examen.repositories.MovimientosRepository;
import edu.unah.lenguajes.examen.services.CuentasService;

@Service
public class CuentasServiceImpl implements CuentasService {

  @Autowired
  private CuentasRepository cuentasRepo;

  @Autowired
  private MovimientosRepository movimientosRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  @Override
  public Cuentas createCuenta(Cuentas cuenta) {
    if (cuenta.getSaldo() < 500) 
      return null;

    // si la cuenta ya existe entonces no se guarda y solo se retorna
    if (this.cuentasRepo.existsById(cuenta.getNumeroCuenta()))
      return null;
    
    cuenta.setFechaApertura(LocalDate.now());
    cuenta.setEstado(true);
    Cuentas cuentaCreada = this.cuentasRepo.save(cuenta);
    
    // verificar si hay movimientos
    for (Movimientos movimiento : cuenta.getMovimientos()) {
      movimiento.setCuenta(cuentaCreada);
      movimiento.setFechaMovimiento(LocalDate.now());
      this.movimientosRepo.save(movimiento);
    }
    

    return cuentaCreada;
  }

  @Override
  public String asociarCuentaACliente(String dni, String numeroDeCuenta) {
    if (!this.clienteRepo.existsById(dni))
      return "El cliente con dni: " + dni + " no existe";
    
    if (!this.cuentasRepo.existsById(numeroDeCuenta))
      return "La cuenta con ID: " + numeroDeCuenta + " No existe";
    
    if (null != this.cuentasRepo.findById(numeroDeCuenta).get().getCliente()) 
      return "La cuenta ya está asociada con un cliente";
    
    // se realiza la asociacion
    Cliente cliente = this.clienteRepo.findById(dni).get();
    this.cuentasRepo.findById(numeroDeCuenta).get().setCliente(cliente);
    return "La cuenta se ha asociado exitosamente";
  }
  
}
