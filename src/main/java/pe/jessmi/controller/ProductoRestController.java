package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.jessmi.entity.Producto;
import pe.jessmi.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoRestController {
	
	@Autowired
	private ProductoService productoService;
	
	public ProductoRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() 
	{
		Collection<Producto> list=productoService.findAll();
		
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
