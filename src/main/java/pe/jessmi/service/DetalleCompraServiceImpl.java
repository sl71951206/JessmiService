package pe.jessmi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.DetalleCompra;
import pe.jessmi.repository.DetalleCompraRepository;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

	@Autowired
	private DetalleCompraRepository repository;

	@Override
	@Transactional
	public void insert(DetalleCompra detalleCompra) {
		repository.save(detalleCompra);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<DetalleCompra> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public DetalleCompra findById(Integer id_detalle_compra) {
		return repository.findById(id_detalle_compra).orElse(null);
	}

	@Override
	public Collection<DetalleCompra> findByCodCompra(Integer cod_compra) {
		return repository.findByCodCompra(cod_compra);
	}

}
