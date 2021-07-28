package myspringelearningfrontend.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import elearningproject.dao.Contactdao;
import elearningproject.dao.userdao;
import elearningproject.daoimpl.ContactDAOImpl;
import elearningproject.daoimpl.UserDAOImpl;
import elearningproject.module.Contact;
import elearningproject.module.user1;


@Controller
public class UserController {
	
	 userdao Userdao=new UserDAOImpl();
	 
@GetMapping("/user-list")
public String userspage(Model model) {
	List<user1> userList=Userdao.findAll();
	model.addAttribute("list", userList);
	return "users";
}
@GetMapping("/addUser")
public String addUserForm(Model model) {
	model.addAttribute("user", new user1());
	return "add-user";
}
@PostMapping("/register")
public String addUser(@ModelAttribute("user") user1 u) {
	userdao dao=new UserDAOImpl();
	dao.addUser(u);
	return "redirect:/user-list";
}
@GetMapping("/delete-user/{user_id}")
public String deleteUser(@PathVariable("user_id") Long user_id) {
	userdao dao=new UserDAOImpl();
	dao.deleteUser(user_id);
	return "redirect:/user-list"; 
}
@GetMapping("/update-user/{user_id}")
public String updateUserForm(@PathVariable("user_id") Long user_id,Model model) {
	userdao dao=new UserDAOImpl();
	user1 user=dao.getUserById(user_id);
	model.addAttribute("user", user);
	return "update-user"; 
}
@PostMapping("/update-user")
public String updateUserForm(@ModelAttribute("user") user1 user) {
	userdao dao=new UserDAOImpl(); 
	
	dao.updateUser(user);
	
	return "redirect:/user-list"; 
}
}

