package pe.jessmi.service;

import java.util.Collection;
import java.util.Map;

public interface UserRoleService {

	public abstract Collection<Map<String, Object>> findAllUserRoles();
	public abstract Collection<Map<String, Object>> findByUserId(Integer userId);
	public abstract Collection<Map<String, Object>> findByRoleId(Integer roleId);
	public abstract void delete(Integer userId, Integer roleId);

}
