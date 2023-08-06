package pe.jessmi.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.jessmi.entity.RoleEntity;
import pe.jessmi.entity.UserEntity;
import pe.jessmi.entity.UserRole;
import pe.jessmi.service.RoleService;
import pe.jessmi.service.UserRoleService;
import pe.jessmi.service.UserService;

@RestController
@RequestMapping("/user_role")
public class UserRoleRestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService service;
	
	public UserRoleRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody UserRole user_role) {
		Integer userId = user_role.getUserId();
		UserEntity user = userService.findById(userId);
		Integer roleId = user_role.getRoleId();
		RoleEntity role = roleService.findById(roleId);
		if (user == null) {
			return new ResponseEntity<>("¡User ID " + userId + " no existe!", HttpStatus.NOT_FOUND);
		} else if (role == null) {
			return new ResponseEntity<>("¡Role ID " + roleId + " no existe!", HttpStatus.NOT_FOUND);
		} else {
			user.addRole(role);
			userService.update(user);
			return new ResponseEntity<>("¡Conexión usuario-rol CREADA!", HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Map<String, Object>> objetos = service.findAllUserRoles();
		if(objetos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(objetos, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorUserId/{userId}")
	public ResponseEntity<?> buscarPorUserId_GET(@PathVariable Integer userId) {
		Collection<Map<String, Object>> objetos = service.findByUserId(userId);
	    if (objetos.isEmpty()) {
	    	return new ResponseEntity<>("¡No existe el usuario " + userId + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(objetos, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorRoleId/{roleId}")
	public ResponseEntity<?> buscarPorRoleId_GET(@PathVariable Integer roleId) {
		Collection<Map<String, Object>> objetos = service.findByRoleId(roleId);
	    if (objetos.isEmpty()) {
	    	return new ResponseEntity<>("¡No existe el rol " + roleId + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(objetos, HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar")
	public ResponseEntity<?> borrar_DELETE(@RequestParam Integer userId, @RequestParam Integer roleId) {
		Collection<Map<String, Object>> usuarios = service.findByUserId(userId);
		Collection<Map<String, Object>> roles = service.findByRoleId(roleId);
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>("¡No existe el usuario " + userId + "!", HttpStatus.NOT_FOUND);
		} else if (roles.isEmpty()) {
			return new ResponseEntity<>("¡No existe el rol " + roleId + "!", HttpStatus.NOT_FOUND);
		} else {
			service.delete(userId, roleId);
			return new ResponseEntity<>("¡Conexión usuario-rol borrada!", HttpStatus.OK);
		}
		
	}

}
