package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.Cliente;
import pe.jessmi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins="*")
public class ClienteRestController {

	@Autowired
	private ClienteService service;

	public ClienteRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente) {
		service.insert(cliente);		
		return new ResponseEntity<>("¡Cliente registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Cliente> clientes = service.findAll();
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/buscarid/{idCliente}")
	public ResponseEntity<?> buscarPorId_GET(@PathVariable Integer idCliente) {
		Cliente cliente = service.findById(idCliente);
	    if (cliente == null) {
	    	return new ResponseEntity<>("¡No existe el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{correo}/{contrasena}")
	public ResponseEntity<?> buscar(@PathVariable String correo, @PathVariable String contrasena) {
		Cliente cliente = service.findByCorreoWithContrasena(correo, contrasena);
	    if (cliente == null) {
	    	return new ResponseEntity<>("¡Credenciales incorrectas!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{idCliente}")
	public ResponseEntity<?> editar_PUT(@RequestBody Cliente cliente, @PathVariable Integer idCliente) {
		Cliente clienteBD = service.findById(idCliente);
		if (clienteBD != null) {
			cliente.setId_cliente(clienteBD.getId_cliente());
			service.update(cliente);
			return new ResponseEntity<>("¡Cliente editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idCliente}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idCliente) {
		Cliente clienteBD = service.findById(idCliente);
		if (clienteBD != null) {		
			service.delete(idCliente);
			return new ResponseEntity<>("¡Cliente borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
	}
	
}
