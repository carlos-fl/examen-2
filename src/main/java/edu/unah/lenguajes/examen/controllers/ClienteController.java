package edu.unah.lenguajes.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.lenguajes.examen.entities.Cliente;
import edu.unah.lenguajes.examen.services.servicesImpl.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {

  @Autowired
  private ClienteServiceImpl clienteService;

  @PostMapping("/clientes/crear")
  public Cliente crearCliente(@RequestBody Cliente cliente) {
    return this.clienteService.createCliente(cliente);
  }

  @GetMapping("/clientes")
  public List<Cliente> getClientes() {
    return this.clienteService.getClientes();
  }

  @GetMapping("/clientes/{dni}")
  public Cliente encontrarCliente(@PathVariable String dni) {
    return this.clienteService.GetClientePorDni(dni);
  }
}
