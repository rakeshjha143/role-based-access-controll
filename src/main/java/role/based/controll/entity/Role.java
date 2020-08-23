package role.based.controll.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="role")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Auditable<String>{

	
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long role_id;
	   
	   private String title;
	   
	   private String slug;
	   
	   private String description;
	   
	   private Boolean active;
}
