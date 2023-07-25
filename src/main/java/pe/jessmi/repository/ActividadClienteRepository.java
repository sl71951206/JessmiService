package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.ActividadCliente;

public interface ActividadClienteRepository extends JpaRepository<ActividadCliente, Integer> {

	@Query(value="SELECT * FROM actividad_cliente WHERE id_cliente = :id_cliente", nativeQuery=true)
	public abstract Collection<ActividadCliente> findByIdCliente(@Param("id_cliente") Integer id_cliente);
	
	@Query(value="SELECT * FROM actividad_cliente WHERE id_cliente = "
			+ "(SELECT id_cliente FROM cliente WHERE correo = :correo)", nativeQuery=true)
	public abstract Collection<ActividadCliente> findByCorreo(@Param("correo") String correo);

}
