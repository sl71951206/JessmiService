package pe.jessmi.service;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jessmi.entity.Producto;
import pe.jessmi.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional
	public void insert(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer idProducto) {
		return repository.findById(idProducto).orElse(null);
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Integer idProducto) {
		repository.deleteById(idProducto);
	}
	
	//
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findByMarca(String marca) {
		return repository.findByMarca(marca);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> orderByPrecio() {
		return repository.orderByPrecio();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> orderByStock() {
		return repository.orderByStock();
	}
	
	//
	
	@Override
	public Collection<Producto> findAllWithCondition() {
		return repository.findAllWithCondition();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findByNombreOrMarca(String x) {
		return repository.findByNombreOrMarca(x);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> find10BestSellers() {
		return repository.find10BestSellers();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> find5Newer() {
		return repository.find5Newer();
	}

}
