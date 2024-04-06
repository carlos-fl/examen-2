package edu.unah.lenguajes.examen.services;


import java.util.List;

import edu.unah.lenguajes.examen.entities.Cliente;

public interface ClienteService {
  public Cliente createCliente(Cliente cliente);
  
  public List<Cliente> getClientes();

  public Cliente GetClientePorDni(String dni);
}
