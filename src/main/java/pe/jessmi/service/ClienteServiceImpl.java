package pe.jessmi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.Cliente;
import pe.jessmi.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		repository.save(cliente);
		
	}

	@Override
	public Collection<Cliente> findByCredenciales(String correo, String contrasena) {
		return repository.findByCredenciales(correo, contrasena);
	}

}
