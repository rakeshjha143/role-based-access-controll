package role.based.controll.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import role.based.controll.entity.Role;
import role.based.controll.repository.RoleRepository;
import role.based.controll.services.RolesServices;

@Service("RolesServices")
public class RoleServicesImpl implements RolesServices{
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
		
	}

	@Override
	public void deleteRole(Long role_id) {
		roleRepository.deleteById(role_id);
		
	}

	@Override
	public List<Role> findAll() {
	
		return roleRepository.findAll();
	}

	@Override
	public Role findByroleId(Long role_id) {
	
		return roleRepository.findByRoleId(role_id);
	}

	@Override
	public Role findByName(String name) {
	
		return roleRepository.findByName(name);
	}

}
