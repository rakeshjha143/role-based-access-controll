package role.based.controll.conveter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolesConvertRequest {
	
	private Long id;
	   
	   private String title;
	   
	   private String slug;
	   
	   private String description;
	   
	   private Boolean active;

}
