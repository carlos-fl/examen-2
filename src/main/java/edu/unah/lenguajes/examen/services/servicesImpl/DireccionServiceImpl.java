package edu.unah.lenguajes.examen.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.lenguajes.examen.entities.Cliente;
import edu.unah.lenguajes.examen.entities.Direccion;
import edu.unah.lenguajes.examen.repositories.ClienteRepository;
import edu.unah.lenguajes.examen.repositories.DireccionRepository;
import edu.unah.lenguajes.examen.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

  @Autowired
  private DireccionRepository direccionRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  @Override
  public String createDireccion(Direccion direccion, String dni) {
    if (!this.clienteRepo.existsById(dni))
      return "El cliente con dni: " + dni + " no existe. No se pudo crear direccion";


    // asociacion con el dni (cliente)
    Cliente cliente = this.clienteRepo.findById(dni).get();
    direccion.setCliente(cliente);
    this.direccionRepo.save(direccion);

    return "La direccion ha sido creada";

      
  }
  
}
