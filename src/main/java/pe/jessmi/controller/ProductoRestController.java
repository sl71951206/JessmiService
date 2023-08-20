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

import pe.jessmi.entity.Producto;
import pe.jessmi.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins="*")
public class ProductoRestController {
	
	@Autowired
	private ProductoService service;
	
	public ProductoRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Producto producto) {
		service.insert(producto);		
		return new ResponseEntity<>("¡Producto registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Producto> productos = service.findAll();
		if(productos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idProducto}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idProducto) {
		Producto producto = service.findById(idProducto);
	    if (producto == null) {
	    	return new ResponseEntity<>("¡No existe el producto " + idProducto + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{idProducto}")
	public ResponseEntity<?> editar_PUT(@RequestBody Producto producto, @PathVariable Integer idProducto) {
		Producto productoBD = service.findById(idProducto);
		if (productoBD != null) {
			if (producto.getCategoriaProductos() != null) {
				productoBD.setCategoriaProductos(producto.getCategoriaProductos());
			}
			productoBD.setFoto(producto.getFoto());
			productoBD.setMarca(producto.getMarca());
			productoBD.setNombre(producto.getNombre());
			productoBD.setPrecio(producto.getPrecio());
			productoBD.setStock(producto.getStock());
			service.update(productoBD);
			return new ResponseEntity<>("¡Producto editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el producto " + idProducto + "!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idProducto}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idProducto) {
		Producto productoBD = service.findById(idProducto);
		if (productoBD != null) {		
			service.delete(idProducto);
			return new ResponseEntity<>("¡Producto borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el producto " + idProducto + "!", HttpStatus.NOT_FOUND);
	}
	
	//
	
	@GetMapping("/buscarPorMarca/{marca}")
	public ResponseEntity<?> buscarPorMarca_GET(@PathVariable String marca) {
		Collection<Producto> productos = service.findByMarca(marca);
		if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorNombre/{nombre}")
	public ResponseEntity<?> buscarPorNombre_GET(@PathVariable String nombre) {
		Collection<Producto> productos = service.findByNombre(nombre);
		if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/ordenarPorPrecio")
	public ResponseEntity<?> ordenarPorPrecio_GET() {
		Collection<Producto> productos = service.orderByPrecio();
	    if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/ordenarPorStock")
	public ResponseEntity<?> ordenarPorStock_GET() {
		Collection<Producto> productos = service.orderByStock();
	    if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	//
	
	@GetMapping("/listarConCondicion")
	public ResponseEntity<?> listarConCondicion_GET() {
		Collection<Producto> productos = service.findAllWithCondition();
		if(productos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorNombreOMarca/{x}")
	public ResponseEntity<?> buscarPorNombreOMarca_GET(@PathVariable String x) {
		Collection<Producto> productos = service.findByNombreOrMarca(x);
	    if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/masVendidos")
	public ResponseEntity<?> masVendidos_GET() {
		Collection<Producto> productos = service.find10BestSellers();
	    if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/masNuevos")
	public ResponseEntity<?> masNuevos_GET() {
		Collection<Producto> productos = service.find5Newer();
	    if (productos.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}

}
