package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.CategoriaProductos;

public interface CategoriaProductosService {

	public abstract Collection<CategoriaProductos> findAll();
	public abstract CategoriaProductos findById(Integer id_categoria_productos);
	
	//
	
	public abstract void load();
	
}
