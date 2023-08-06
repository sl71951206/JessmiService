package pe.jessmi.service;

import java.util.Collection;
import java.util.Map;

import pe.jessmi.entity.Compra;

public interface CompraService {

	public abstract void insert(Compra compra);
	public abstract Collection<Compra> findAll();
	public abstract Compra findById(Integer cod_compra);
	
	//
	
	public abstract Collection<Compra> findByIdCliente(Integer id_cliente);
	public abstract Collection<Compra> findByCorreo(String correo);
	
	//
	
	public abstract Compra findLastByIdCliente(Integer id_cliente);
	public abstract void insertByComponents(Integer idCliente, Integer idMetodoPago);
	public abstract Collection<Map<String, Object>> findTotalByIdCliente(Integer id_cliente);
	
}
