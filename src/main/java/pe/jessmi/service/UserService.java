package pe.jessmi.service;

import java.util.Collection;

import pe.jessmi.entity.UserEntity;

public interface UserService {
	
	public abstract void insert(UserEntity user);
	public abstract UserEntity findById(Integer userId);
	public abstract Collection<UserEntity> findAll();
	public abstract void update(UserEntity user);
	public abstract void delete(Integer userId);
	
	//
	
	public abstract UserEntity findByUsername(String username);

}
