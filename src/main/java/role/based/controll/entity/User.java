package role.based.controll.entity;

import java.time.LocalDateTime;

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
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long user_id;
	   
	   private String first_Name;
	   
	   private String middle_Name;
	   
	   private String last_Name	;
	   
	   private String mobile;
	   
	   private String email;
	   	  
	   public String password;
	   
	   private LocalDateTime last_Login;
	   
	   private String user_intro;
	   
	   private String profiledetails;
}
