package pe.jessmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.jessmi.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	
	public abstract RoleEntity findByType(String type);

}
