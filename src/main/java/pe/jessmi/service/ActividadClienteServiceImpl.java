package pe.jessmi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.ActividadCliente;
import pe.jessmi.repository.ActividadClienteRepository;

@Service
public class ActividadClienteServiceImpl implements ActividadClienteService {

	@Autowired
	private ActividadClienteRepository repository;

	@Override
	@Transactional
	public void insert(ActividadCliente actividadCliente) {
		repository.save(actividadCliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<ActividadCliente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public ActividadCliente findById(Integer id_actividad_cliente) {
		return repository.findById(id_actividad_cliente).orElse(null);
	}
	
	//

	@Override
	public Collection<ActividadCliente> findByIdCliente(Integer id_cliente) {
		return repository.findByIdCliente(id_cliente);
	}

	@Override
	public Collection<ActividadCliente> findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

}
