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
import pe.jessmi.entity.Cliente;
import pe.jessmi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	
	public ClienteRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente)
	{
		clienteService.insert(cliente);		
		return new ResponseEntity<>("¡Cliente registrado!",HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{correo}/{contrasena}")
	public ResponseEntity<?> buscar_GET(@PathVariable String correo,@PathVariable String contrasena)
	{
		Collection<Cliente> resultados = clienteService.findByCredenciales(correo, contrasena);

	    if (resultados != null && !resultados.isEmpty()) {
	        return new ResponseEntity<>(resultados, HttpStatus.OK);
	    }
	    
		return new ResponseEntity<>("¡No existen Usuarios con Correo: "+correo+" y Contraseña:"+contrasena, HttpStatus.NOT_FOUND);
	}
}
