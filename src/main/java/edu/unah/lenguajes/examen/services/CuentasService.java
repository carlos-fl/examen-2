package edu.unah.lenguajes.examen.services;

import edu.unah.lenguajes.examen.entities.Cuentas;

public interface CuentasService {
  public Cuentas createCuenta(Cuentas cuenta);
  
  public String asociarCuentaACliente(String dni, String numeroDeCuenta);
}
