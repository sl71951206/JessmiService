package pe.jessmi.service;
import java.util.Collection;

import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.Cliente;

public interface ClienteService {

	public abstract void insert(Cliente cliente);
	public abstract Collection<Cliente> findByCredenciales(@Param("correo") String correo, @Param("contrasena") String contrasena);
}
