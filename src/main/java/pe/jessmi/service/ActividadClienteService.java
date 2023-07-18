package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.ActividadCliente;

public interface ActividadClienteService {

	public abstract void insert(ActividadCliente actividadCliente);
	public abstract Collection<ActividadCliente> findAll();
	public abstract ActividadCliente findById(Integer id_actividad_cliente);
	public abstract Collection<ActividadCliente> findByIdCliente(Integer id_cliente);
	public abstract Collection<ActividadCliente> findByCorreo(String correo); 
	
}
