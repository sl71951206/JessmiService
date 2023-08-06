package pe.jessmi.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Collection<Map<String, Object>> findAllUserRoles() {
		return repository.findAllUserRoles();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Map<String, Object>> findByUserId(Integer userId) {
		return repository.findByUserId(userId);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Map<String, Object>> findByRoleId(Integer roleId) {
		return repository.findByRoleId(roleId);
	}

	@Override
	@Transactional
	public void delete(Integer userId, Integer roleId) {
		repository.delete(userId, roleId);
	}
	
}
