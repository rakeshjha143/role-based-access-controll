package role.based.controll.services;

import java.util.List;


import role.based.controll.entity.User;

public interface UserServices {
	
	User saveUser(User user);
	
	void deleteUser(Long user_id);
	
	List<User> findAll();
	
	User findByroleId(Long user_id);
	
	User findByName(String name);

}
