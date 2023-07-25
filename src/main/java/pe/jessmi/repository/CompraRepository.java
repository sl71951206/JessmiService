package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
	
	@Query(value="SELECT * FROM compra WHERE id_cliente = :id_cliente", nativeQuery=true)
	public abstract Collection<Compra> findByIdCliente(@Param("id_cliente") Integer id_cliente);
	
	@Query(value="SELECT * FROM compra WHERE id_cliente = "
			+ "(SELECT id_cliente FROM cliente WHERE correo = :correo)", nativeQuery=true)
	public abstract Collection<Compra> findByCorreo(@Param("correo") String correo);
	
	//
	
	@Query(value="SELECT * FROM compra WHERE id_cliente = :id_cliente ORDER BY fecha_compra DESC LIMIT 1", nativeQuery=true)
	public abstract Compra findByIdClienteLimit1(@Param("id_cliente") Integer id_cliente);
	
	@Modifying
	@Query(value="INSERT INTO compra(id_cliente, id_metodo_pago) VALUES (:idCliente, :idMetodoPago)", nativeQuery=true)
	public abstract void saveByProductos(@Param("idCliente") Integer idCliente, @Param("idMetodoPago") Integer idMetodoPago);

}
