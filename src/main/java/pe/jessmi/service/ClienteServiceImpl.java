package pe.jessmi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.Cliente;
import pe.jessmi.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void insert(Cliente cliente) {
		String contrasenaEncriptada = passwordEncoder.encode(cliente.getContrasena());
		cliente.setContrasena(contrasenaEncriptada);
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
	@Transactional(readOnly=true)
	public Cliente findByCorreoWithContrasena(String correo, String contrasena) {
		Cliente cliente = repository.findByCorreo(correo);
		if (cliente == null) {
			return null;
		} else if (passwordEncoder.matches(contrasena, cliente.getContrasena())) {
			return cliente;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		String contrasenaEncriptada = passwordEncoder.encode(cliente.getContrasena());
		cliente.setContrasena(contrasenaEncriptada);
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer idCliente) {
		repository.deleteById(idCliente);
	}

}
