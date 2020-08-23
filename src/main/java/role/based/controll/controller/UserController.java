package role.based.controll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	
}
