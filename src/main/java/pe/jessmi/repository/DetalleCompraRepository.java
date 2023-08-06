package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {

	@Query(value="SELECT * FROM detalle_compra WHERE cod_compra = :cod_compra", nativeQuery=true)
	public abstract Collection<DetalleCompra> findByCodCompra(@Param("cod_compra") Integer cod_compra);

}
