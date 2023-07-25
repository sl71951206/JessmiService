package pe.jessmi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.Compra;
import pe.jessmi.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository repository;

	@Override
	@Transactional
	public void insert(Compra compra) {
		repository.save(compra);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Compra> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Compra findById(Integer cod_compra) {
		return repository.findById(cod_compra).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Compra> findByIdCliente(Integer id_cliente) {
		return repository.findByIdCliente(id_cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Compra> findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	@Transactional(readOnly=true)
	public Compra findByIdClienteLimit1(Integer id_cliente) {
		return repository.findByIdClienteLimit1(id_cliente);
	}
	
	@Override
	@Transactional
	public void insertByProductos(Integer idCliente, Integer idMetodoPago) {
		repository.saveByProductos(idCliente, idMetodoPago);
	}

}
