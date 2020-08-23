package role.based.controll.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import role.based.controll.entity.User;
import role.based.controll.repository.UserRepository;
import role.based.controll.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepsotory;
	
	
	
	@Override
	public User saveUser(User user) {
		
		return userRepsotory.save(user);
	}

	@Override
	public void deleteUser(Long user_id) {
		userRepsotory.deleteById(user_id);
		
	}

	@Override
	public List<User> findAll() {
		
		return userRepsotory.findAll();
	}

	@Override
	public User findByroleId(Long user_id) {
		
		return userRepsotory.findByRoleId(user_id);
	}

	@Override
	public User findByName(String name) {
		
		return userRepsotory.findByName(name);
	}

}
