package pe.jessmi.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.jessmi.entity.UserEntity;

public interface UserRoleRepository extends JpaRepository<UserEntity, Integer> {

	@Query(value="SELECT U.user_id, U.username, R.role_id, R.type"
			+ " FROM user_role UR"
			+ " INNER JOIN user U on UR.user_id = U.user_id"
			+ " INNER JOIN role R on UR.role_id = R.role_id",
			nativeQuery=true)
	public abstract Collection<Map<String, Object>> findAllUserRoles();
	
	@Query(value="SELECT U.user_id, U.username, R.role_id, R.type"
			+ " FROM user_role UR"
			+ " INNER JOIN user U on UR.user_id = U.user_id"
			+ " INNER JOIN role R on UR.role_id = R.role_id"
			+ " WHERE U.user_id = :userId",
			nativeQuery=true)
	public abstract Collection<Map<String, Object>> findByUserId(@Param("userId") Integer userId);
	
	@Query(value="SELECT U.user_id, U.username, R.role_id, R.type"
			+ " FROM user_role UR"
			+ " INNER JOIN user U on UR.user_id = U.user_id"
			+ " INNER JOIN role R on UR.role_id = R.role_id"
			+ " WHERE R.role_id = :roleId",
			nativeQuery=true)
	public abstract Collection<Map<String, Object>> findByRoleId(@Param("roleId") Integer roleId);
	
	@Modifying
	@Query(value="DELETE FROM user_role WHERE user_id = :userId AND role_id = :roleId", nativeQuery=true)
	public abstract void delete(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

}
