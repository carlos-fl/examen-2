package edu.unah.lenguajes.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.lenguajes.examen.entities.Cuentas;
import edu.unah.lenguajes.examen.services.servicesImpl.CuentasServiceImpl;

@RestController
@RequestMapping("/api")
public class CuentasController {
  @Autowired
  private CuentasServiceImpl cuentaService; 

  @PostMapping("/cuentas/crear")
  public Cuentas createCuenta(@RequestBody Cuentas cuenta) {
    return this.cuentaService.createCuenta(cuenta);
  }

  @GetMapping("/cueantas/asociar/{dni}")
  public String AsociarCuentaACliente(@PathVariable String dni, @RequestParam(name="numeroCuenta") String numeroCuenta) {
    return this.cuentaService.asociarCuentaACliente(dni, numeroCuenta);
  }


}

