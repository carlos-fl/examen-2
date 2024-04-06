package edu.unah.lenguajes.examen.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.lenguajes.examen.entities.Cliente;
import edu.unah.lenguajes.examen.repositories.ClienteRepository;
import edu.unah.lenguajes.examen.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepo;

  @Override
  public Cliente createCliente(Cliente cliente) {
    return this.clienteRepo.save(cliente);
  }

  @Override
  public List<Cliente> getClientes() {
    return this.clienteRepo.findAll();
  }

  @Override
  public Cliente GetClientePorDni(String dni) {
    if (!this.clienteRepo.existsById(dni))
      return null;

    return this.clienteRepo.findById(dni).get();
  }
  
}
