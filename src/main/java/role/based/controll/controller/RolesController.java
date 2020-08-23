package role.based.controll.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import role.based.controll.conveter.RolesConvertRequest;
import role.based.controll.entity.Role;
import role.based.controll.services.RolesServices;

@Controller
public class RolesController {
	
	@Autowired
	private RolesServices roleServices;
	


	@RequestMapping("/list")
	   public String listAll(Model model) {
	      List<Role> listroles = roleServices.findAll();   
	      model.addAttribute("listroles", listroles);
	      return "roles/list";
	   }
	  
	  @RequestMapping(value="/role/add", method=RequestMethod.GET)
	   public String addRole(Role role, Model model) {
	      model.addAttribute("action", "role/add");
	      return "roles/entry";
	   }
	  
	  @RequestMapping(value="/save",method=RequestMethod.POST)
	   public String saveNewRole(@Valid Role role, BindingResult bindingResult, Model model) {
	      if (bindingResult.hasErrors()) {
	         model.addAttribute("action", "roles/add");
	         return "roles/entry";
	      }
	           
	      //Role role = modelMapper.map(itemDto, Role.class);
	      roleServices.saveRole(role);
	      return "redirect:";
	   }
	  
	  @RequestMapping("/edit/{role_id}")
	  public ModelAndView showEditRole(@PathVariable(name = "role_id") Long role_id) {
	      ModelAndView mav = new ModelAndView("roles/edit_role");
	      Role role = roleServices.findByroleId(role_id);
	      mav.addObject("role", role);
	       
	      return mav;
	  }
	  @RequestMapping("/delete/{role_id}")
	  public String deleteProduct(@PathVariable(name = "role_id") Long role_id) {
		  roleServices.deleteRole(role_id);
	      return "redirect:/";       
	  }
}
