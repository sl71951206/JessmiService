package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.RoleEntity;
import pe.jessmi.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {
	
	@Autowired
	private RoleService service;
	
	public RoleRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody RoleEntity role) {
		service.insert(role);
		return new ResponseEntity<>("¡Rol CREADO!",HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<RoleEntity> collection = service.findAll();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id) {
		RoleEntity db = service.findById(id);
		if(db != null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Rol ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar_PUT(@RequestBody RoleEntity nuevo, @PathVariable Integer id) {
		RoleEntity db = service.findById(id);
		if (db != null) {
			db.setType(nuevo.getType());
			service.update(db);
			return new ResponseEntity<>("¡Rol editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Rol ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id) {
		RoleEntity db = service.findById(id);
		if(db != null) {			
			service.delete(id);
			return new ResponseEntity<>("¡Rol borrado!",HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Rol ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	//
	
	@GetMapping("/buscarPorType/{type}")
	public ResponseEntity<?> buscarPorType_GET(@PathVariable String type) {
		RoleEntity db = service.findByType(type);
		if(db != null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Type " + type + " no existe!", HttpStatus.NOT_FOUND);
	}

}
