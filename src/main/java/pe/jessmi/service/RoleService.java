package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.RoleEntity;

public interface RoleService {
	
	public abstract void insert(RoleEntity role);
	public abstract RoleEntity findById(Integer roleId);
	public abstract Collection<RoleEntity> findAll();
	public abstract void update(RoleEntity role);
	public abstract void delete(Integer roleId);
	
	//
	
	public abstract RoleEntity findByType(String type);

}
