package role.based.controll.services;

import java.util.List;

import role.based.controll.entity.Role;

public interface RolesServices {
	
	Role saveRole(Role role);
	
	void deleteRole(Long role_id);
	
	List<Role> findAll();
	
	Role findByroleId(Long role_id);
	
	Role findByName(String name);
	

}
