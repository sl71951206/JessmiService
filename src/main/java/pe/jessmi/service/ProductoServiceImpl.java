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

	@Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		return repository.findAll();
	}

}
