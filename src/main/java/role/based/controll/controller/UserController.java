package role.based.controll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import role.based.controll.entity.Role;
import role.based.controll.entity.User;
import role.based.controll.services.RolesServices;
import role.based.controll.services.UserServices;

@Controller
public class UserController {

	
	@Autowired
	private RolesServices roleServices;
	
	@Autowired
	private UserServices userServices;
	
	
	@RequestMapping("/userlist")
	   public String listAllUser(Model model) {
	      List<User> listuser = userServices.findAll();   
	      model.addAttribute("listuser", listuser);
	      return "user/userlist";
	   }
	
	 @RequestMapping(value="/user/add", method=RequestMethod.GET)
	   public String addUser(User user, Model model) {
	      model.addAttribute("action", "user/add");
	      return "user/entry";
	   }
	 @RequestMapping(value="/saveuser",method=RequestMethod.POST)
	   public String saveNewUser(@Valid User user, BindingResult bindingResult, Model model) {
	      if (bindingResult.hasErrors()) {
	         model.addAttribute("action", "users/add");
	         return "user/entry";
	      }
	           
	     userServices.saveUser(user);
	      return "redirect:";
	   }
	 
	  @RequestMapping("/edituser/{user_id}")
	  public ModelAndView showEditUser(@PathVariable(name = "user_id") Long user_id) {
	      ModelAndView mav = new ModelAndView("user/edit_user");
	      User user = userServices.findByroleId(user_id);
	      mav.addObject("user", user);
	       
	      return mav;
	  }
	  @RequestMapping("/deleteuser/{user_id}")
	  public String deleteUser(@PathVariable(name = "user_id") Long user_id) {
		  userServices.deleteUser(user_id);
	      return "redirect:/";       
	  }
	
}
