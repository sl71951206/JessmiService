package pe.jessmi.service;

import java.util.Collection;
import pe.jessmi.entity.Producto;

public interface ProductoService {
	public abstract Collection<Producto> findAll();
}
