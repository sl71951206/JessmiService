package pe.jessmi.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.TipoActividad;
import pe.jessmi.repository.TipoActividadRepository;

@Service
public class TipoActividadServiceImpl implements TipoActividadService {

	@Autowired
	private TipoActividadRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Collection<TipoActividad> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoActividad findById(Integer id_tipo_actividad) {
		return repository.findById(id_tipo_actividad).orElse(null);
	}
	
	@Override
	@Transactional
	public void load() {
		if (repository.findAll().isEmpty()) {
			List<String> lista = Arrays.asList("CREAR CUENTA", "INICIAR SESIÓN", "CERRAR SESIÓN", "ELIMINAR CUENTA");
			for (int i = 0; i < lista.size(); i++) {
				repository.save(new TipoActividad(i+1, lista.get(i)));
			}
		}
	}

}
