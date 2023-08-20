package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	public abstract Collection<Producto> findByMarca(String marca);

	public abstract Collection<Producto> findByNombre(String nombre);
	
	@Query(value="SELECT * FROM producto ORDER BY precio", nativeQuery=true)
	public abstract Collection<Producto> orderByPrecio();
	
	@Query(value="SELECT * FROM producto ORDER BY stock", nativeQuery=true)
	public abstract Collection<Producto> orderByStock();
	
	//
	
	@Query(value="SELECT * FROM producto"
			+ " WHERE stock > 1", nativeQuery=true)
	public abstract Collection<Producto> findAllWithCondition();
	
	@Query(value="SELECT * FROM producto"
			+ " WHERE nombre LIKE %:x%"
			+ " OR marca LIKE %:x%", nativeQuery=true)
	public abstract Collection<Producto> findByNombreOrMarca(@Param("x") String x);
	
	@Query(value="SELECT P.* FROM producto P"
			+ " INNER JOIN detalle_compra DC ON P.id_producto = DC.id_producto"
			+ " WHERE P.stock > 10"
			+ " GROUP BY P.id_producto"
			+ " ORDER BY COUNT(*) DESC LIMIT 10", nativeQuery=true)
	public abstract Collection<Producto> find10BestSellers();
	
	@Query(value="SELECT * FROM producto P"
			+ " WHERE P.stock > 10"
			+ " ORDER BY id_producto DESC LIMIT 5", nativeQuery=true)
	public abstract Collection<Producto> find5Newer();

}
