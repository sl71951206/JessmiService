package pe.jessmi.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.CategoriaProductos;
import pe.jessmi.repository.CategoriaProductosRepository;

@Service
public class CategoriaProductosServiceImpl implements CategoriaProductosService {

	@Autowired
	private CategoriaProductosRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<CategoriaProductos> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public CategoriaProductos findById(Integer id_categoria_productos) {
		return repository.findById(id_categoria_productos).orElse(null);
	}
	
	//

	@Override
	@Transactional
	public void load() {
		if (repository.findAll().isEmpty()) {
			List<String> lista = Arrays.asList("Iluminación", "Cerraduras", "Pinturas", "Pisos y revestimientos",
					"Electricidad", "Tuberías y fontanería", "Gasfitería", "Techos y aislantes", "Maderas y tableros",
					"Clavos, tornillos y adhesivos", "Materiales de construcción", "Medición y trazado", "Herramientas manuales",
					"Herramientas de construcción", "Herramientas eléctricas e inalámbricas");
			for (int i = 0; i < lista.size(); i++) {
				repository.save(new CategoriaProductos(i+1, lista.get(i)));
			}
		}
	}

}
