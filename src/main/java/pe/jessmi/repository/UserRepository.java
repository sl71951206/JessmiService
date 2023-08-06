package pe.jessmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.jessmi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public abstract UserEntity findByUsername(String username);

}
