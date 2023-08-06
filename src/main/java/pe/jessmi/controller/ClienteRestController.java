package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ClienteRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente) {
		String contrasenaEncriptada = passwordEncoder.encode(cliente.getContrasena());
		cliente.setContrasena(contrasenaEncriptada);
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
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idCliente) {
		Cliente cliente = service.findById(idCliente);
	    if (cliente == null) {
	    	return new ResponseEntity<>("¡No existe el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{idCliente}")
	public ResponseEntity<?> editar_PUT(@RequestBody Cliente cliente, @PathVariable Integer idCliente) {
		Cliente clienteBD = service.findById(idCliente);
		if (clienteBD != null) {
			clienteBD.setApellidos(cliente.getApellidos());
			String contrasenaEncriptada = passwordEncoder.encode(cliente.getContrasena());
			clienteBD.setContrasena(contrasenaEncriptada);
			clienteBD.setCorreo(cliente.getCorreo());
			clienteBD.setNombres(cliente.getNombres());
			service.update(clienteBD);
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
	
	//
	
	@GetMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo_GET(@PathVariable String correo) {
		Cliente cliente = service.findByCorreo(correo);
	    if (cliente == null) {
	    	return new ResponseEntity<>("¡No existe el cliente con correo " + correo + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo_POST(@PathVariable String correo, @RequestBody String contrasena) {
		Cliente cliente = service.findByCorreo(correo);
		if (cliente != null && passwordEncoder.matches(contrasena, cliente.getContrasena())) {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Credenciales incorrectas!", HttpStatus.NOT_FOUND);
	}
	
}
