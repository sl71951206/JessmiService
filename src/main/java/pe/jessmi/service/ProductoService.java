package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.Producto;

public interface ProductoService {
	
	public abstract void insert(Producto producto);
	public abstract Collection<Producto> findAll();
	public abstract Producto findById(Integer idProducto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer idProducto);
	
	//
	
	public abstract Collection<Producto> findByMarca(String marca);
	public abstract Collection<Producto> findByNombre(String nombre);
	public abstract Collection<Producto> orderByPrecio();
	public abstract Collection<Producto> orderByStock();
	
	//
	
	public abstract Collection<Producto> find10BestSellers();
	public abstract Collection<Producto> find5Newer();
	
}
