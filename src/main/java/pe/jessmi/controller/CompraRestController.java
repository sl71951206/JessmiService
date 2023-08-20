package pe.jessmi.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.Compra;
import pe.jessmi.entity.DetalleCompra;
import pe.jessmi.entity.Producto;
import pe.jessmi.mapper.ProductoMapper;
import pe.jessmi.service.ClienteService;
import pe.jessmi.service.CompraService;
import pe.jessmi.service.DetalleCompraService;
import pe.jessmi.service.MetodoPagoService;
import pe.jessmi.service.ProductoService;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins="*")
public class CompraRestController {

	@Autowired
	private CompraService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private MetodoPagoService metodoPagoService;
	@Autowired
	private DetalleCompraService detalleCompraService;
	@Autowired
	private ProductoService productoService;

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
	
	//
	
	@GetMapping("/buscarPorIdCliente/{idCliente}")
	public ResponseEntity<?> buscarPorIdCliente_GET(@PathVariable Integer idCliente) {
		Collection<Compra> compras = service.findByIdCliente(idCliente);
	    if (compras.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo_GET(@PathVariable String correo) {
		Collection<Compra> compras = service.findByCorreo(correo);
	    if (compras.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
	//
	
	@GetMapping("/buscarUltimoPorIdCliente/{idCliente}")
	public ResponseEntity<?> buscarUltimoPorIdCliente_GET(@PathVariable Integer idCliente) {
		Compra compra = service.findLastByIdCliente(idCliente);
		if (compra == null) {
	    	return new ResponseEntity<>("¡No existe ninguna compra con el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(compra, HttpStatus.OK);
	}

	@PostMapping("/registrarByComponents/{idCliente}")
	public ResponseEntity<?> registrarByComponents_POST(@PathVariable Integer idCliente, @RequestParam(required=false) Integer idMetodoPago, @RequestBody List<ProductoMapper> productos) {
		if (clienteService.findById(idCliente) == null) {
			return new ResponseEntity<>("¡No existe el cliente " + idCliente + "!", HttpStatus.NOT_FOUND);
		}
		if (idMetodoPago == null) {
			idMetodoPago = 1;
		} else if (metodoPagoService.findById(idMetodoPago) == null) {
			return new ResponseEntity<>("¡No existe el método de pago " + idMetodoPago + "!", HttpStatus.NOT_FOUND);
		}
		service.insertByComponents(idCliente, idMetodoPago);
		Compra compra = service.findLastByIdCliente(idCliente);
		for (ProductoMapper p : productos) {
			Producto producto = productoService.findById(p.getId_producto());
			DetalleCompra detalleCompra = new DetalleCompra();
			detalleCompra.setCantidad(p.getCantidad());
			detalleCompra.setCompra(compra);
			detalleCompra.setProducto(producto);
			producto.setStock(producto.getStock() - p.getCantidad());
			productoService.update(producto);
			detalleCompraService.insert(detalleCompra);
		}
		return new ResponseEntity<>("¡Compra registrada!", HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarTotalPorIdCliente/{idCliente}")
	public ResponseEntity<?> buscarTotalPorIdCliente_GET(@PathVariable Integer idCliente) {
		Collection<Map<String, Object>> compras = service.findTotalByIdCliente(idCliente);
        if (compras.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(compras, HttpStatus.OK);
        }
	}
	
}
