package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.DetalleCompra;

public interface DetalleCompraService {

	public abstract void insert(DetalleCompra detalleCompra);
	public abstract Collection<DetalleCompra> findAll();
	public abstract DetalleCompra findById(Integer id_detalle_compra);
	public abstract Collection<DetalleCompra> findByCodCompra(Integer cod_compra);
	
}
