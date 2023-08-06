package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.Cliente;

public interface ClienteService {

	public abstract void insert(Cliente cliente);
	public abstract Collection<Cliente> findAll();
	public abstract Cliente findById(Integer idCliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer idCliente);
	
	//
	
	public abstract Cliente findByCorreo(String correo);
	
}
