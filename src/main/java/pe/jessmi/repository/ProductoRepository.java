package pe.jessmi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.jessmi.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	public abstract Collection<Producto> findByMarca(String marca);

	public abstract Collection<Producto> findByNombre(String nombre);
	
	@Query(value="SELECT * FROM producto ORDER BY precio", nativeQuery=true)
	public abstract Collection<Producto> orderByPrecio();
	
	@Query(value="SELECT * FROM producto ORDER BY stock", nativeQuery=true)
	public abstract Collection<Producto> orderByStock();

}
