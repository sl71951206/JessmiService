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

import pe.jessmi.entity.Compra;
import pe.jessmi.service.CompraService;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins="*")
public class CompraRestController {

	@Autowired
	private CompraService service;

	public CompraRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Compra compra) {
		service.insert(compra);		
		return new ResponseEntity<>("¡Compra registrada!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Compra> compras = service.findAll();
		if (compras.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{codCompra}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer codCompra) {
		Compra compra = service.findById(codCompra);
	    if (compra == null) {
	    	return new ResponseEntity<>("¡No existe la compra " + codCompra + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(compra, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorIdCliente/{idCliente}")
	public ResponseEntity<?> buscarPorIdCliente_GET(@PathVariable Integer idCliente) {
		Collection<Compra> compras = service.findByIdCliente(idCliente);
	    if (compras.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo(@PathVariable String correo) {
		Collection<Compra> compras = service.findByCorreo(correo);
	    if (compras.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
}
