package role.based.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import role.based.controll.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Role save(Role role);
	
    
	void deleteById(Long role_id);
	
	List<Role> findAll();
	
    @Query("select u from Role u where u.role_id = ?1")
	Role findByRoleId(Long role_id);
	
    @Query("select u from Role u where u.title = ?1")
	Role findByName(String title);
}
