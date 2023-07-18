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

import pe.jessmi.entity.DetalleCompra;
import pe.jessmi.service.DetalleCompraService;

@RestController
@RequestMapping("/detalle_compra")
@CrossOrigin(origins="*")
public class DetalleCompraRestController {

	@Autowired
	private DetalleCompraService service;

	public DetalleCompraRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody DetalleCompra detalleCompra) {
		service.insert(detalleCompra);		
		return new ResponseEntity<>("¡Detalle de la compra registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<DetalleCompra> detalleCompras = service.findAll();
		if (detalleCompras.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(detalleCompras, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idDetalleCompra}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idDetalleCompra) {
		DetalleCompra detalleCompra = service.findById(idDetalleCompra);
	    if (detalleCompra == null) {
	    	return new ResponseEntity<>("¡No existe el detalle de la compra " + idDetalleCompra + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(detalleCompra, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorCodCompra/{codCompra}")
	public ResponseEntity<?> buscarPorCodCompra_GET(@PathVariable Integer codCompra) {
		Collection<DetalleCompra> detalleCompras = service.findByCodCompra(codCompra);
	    if (detalleCompras.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(detalleCompras, HttpStatus.OK);
	}
	
}
