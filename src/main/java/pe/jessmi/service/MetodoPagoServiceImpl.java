package pe.jessmi.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.MetodoPago;
import pe.jessmi.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

	@Autowired
	private MetodoPagoRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<MetodoPago> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public MetodoPago findById(Integer id_metodo_pago) {
		return repository.findById(id_metodo_pago).orElse(null);
	}
	
	//

	@Override
	@Transactional
	public void load() {
		if (repository.findAll().isEmpty()) {
			List<String> lista = Arrays.asList("Paypal", "PagoEfectivo", "Efectivo", "Yape", "Plin", "Visa", "Mastercard");
			for (int i = 0; i < lista.size(); i++) {
				repository.save(new MetodoPago(i+1, lista.get(i)));
			}
		}
	}

}
