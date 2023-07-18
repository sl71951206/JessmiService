package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.ActividadCliente;
import pe.jessmi.service.ActividadClienteService;

@RestController
@RequestMapping("/actividad_cliente")
@CrossOrigin(origins="*")
public class ActividadClienteRestController {

	@Autowired
	private ActividadClienteService service;

	public ActividadClienteRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody ActividadCliente actividadCliente) {
		service.insert(actividadCliente);		
		return new ResponseEntity<>("¡Actividad del cliente registrada!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<ActividadCliente> actividadClientes = service.findAll();
		if (actividadClientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(actividadClientes, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idActividadCliente}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idActividadCliente) {
		ActividadCliente actividadCliente = service.findById(idActividadCliente);
	    if (actividadCliente == null) {
	    	return new ResponseEntity<>("¡No existe la actividad del cliente " + idActividadCliente + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(actividadCliente, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorIdCliente/{idCliente}")
	public ResponseEntity<?> buscarPorIdCliente_GET(@PathVariable Integer idCliente) {
		Collection<ActividadCliente> actividadClientes = service.findByIdCliente(idCliente);
	    if (actividadClientes.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(actividadClientes, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo(@PathVariable String correo) {
		Collection<ActividadCliente> actividadClientes = service.findByCorreo(correo);
	    if (actividadClientes.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(actividadClientes, HttpStatus.OK);
	}
	
}
