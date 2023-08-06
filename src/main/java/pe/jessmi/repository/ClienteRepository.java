package pe.jessmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.jessmi.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public abstract Cliente findByCorreo(String correo);

}
