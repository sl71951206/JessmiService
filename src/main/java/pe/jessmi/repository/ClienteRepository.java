package pe.jessmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value="SELECT * FROM cliente WHERE correo = :correo", nativeQuery=true)
	public abstract Cliente findByCorreo(@Param("correo") String correo); 

}
