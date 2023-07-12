package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	
	@Query(value = "SELECT * FROM cliente " +
	        "WHERE correo = :correo AND contrasena = :contrasena ", nativeQuery = true)
	public abstract Collection<Cliente> findByCredenciales(@Param("correo") String correo, @Param("contrasena") String contrasena);

}
