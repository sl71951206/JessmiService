package pe.jessmi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.UserEntity;
import pe.jessmi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody UserEntity user) {
		String contrasenaEncriptada = passwordEncoder.encode(user.getPassword());
		user.setPassword(contrasenaEncriptada);
		service.insert(user);
		return new ResponseEntity<>("¡Usuario CREADO!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<UserEntity> collection = service.findAll();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id) {
		UserEntity db = service.findById(id);
		if(db != null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Usuario ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar_PUT(@RequestBody UserEntity nuevo, @PathVariable Integer id) {
		UserEntity db = service.findById(id);
		if (db != null) {
			String contrasenaEncriptada = passwordEncoder.encode(nuevo.getPassword());
			db.setPassword(contrasenaEncriptada);
			db.setUsername(nuevo.getUsername());
			service.update(db);
			return new ResponseEntity<>("¡Usuario editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Usuario ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id) {
		UserEntity db = service.findById(id);
		if(db != null) {			
			service.delete(id);
			return new ResponseEntity<>("¡Usuario borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Usuario ID " + id + " no existe!", HttpStatus.NOT_FOUND);
	}
	
	//
	
	@GetMapping("/buscarPorUsername/{username}")
	public ResponseEntity<?> buscarPorUsername_GET(@PathVariable String username) {
		UserEntity db = service.findByUsername(username);
		if(db != null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Username " + username + " no existe!", HttpStatus.NOT_FOUND);
	}
	
}
