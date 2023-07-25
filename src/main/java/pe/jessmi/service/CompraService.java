package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.Compra;

public interface CompraService {

	public abstract void insert(Compra compra);
	public abstract Collection<Compra> findAll();
	public abstract Compra findById(Integer cod_compra);
	public abstract Collection<Compra> findByIdCliente(Integer id_cliente);
	public abstract Collection<Compra> findByCorreo(String correo);
	
	public abstract Compra findByIdClienteLimit1(Integer id_cliente);
	public abstract void insertByProductos(Integer idCliente, Integer idMetodoPago);
	
}
