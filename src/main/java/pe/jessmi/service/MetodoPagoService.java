package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.MetodoPago;

public interface MetodoPagoService {
	
	public abstract Collection<MetodoPago> findAll();
	public abstract MetodoPago findById(Integer id_metodo_pago);
	
	//
	
	public abstract void load();
	
}
