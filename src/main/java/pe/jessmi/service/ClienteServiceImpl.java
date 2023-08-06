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
	@Transactional(readOnly=true)
	public Collection<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Integer idCliente) {
		return repository.findById(idCliente).orElse(null);
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer idCliente) {
		repository.deleteById(idCliente);
	}
	
	//
	
	@Override
	@Transactional(readOnly=true)
	public Cliente findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

}
