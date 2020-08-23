package role.based.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import role.based.controll.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 User save(User user);
		
	    
		void deleteById(Long user_id);
		
		List<User> findAll();
		
	    @Query("select u from User u where u.user_id = ?1")
		User findByRoleId(Long user_id);
		
	    @Query("select u from User u where u.first_Name = ?1")
		User findByName(String first_Name);
}
