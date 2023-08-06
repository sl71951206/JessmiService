package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.TipoActividad;

public interface TipoActividadService {

	public abstract Collection<TipoActividad> findAll();
	public abstract TipoActividad findById(Integer id_tipo_actividad);
	
	//
	
	public abstract void load();
	
}
