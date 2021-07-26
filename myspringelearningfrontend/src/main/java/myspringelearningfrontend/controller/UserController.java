package myspringelearningfrontend.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import elearningproject.dao.userdao;
import elearningproject.daoimpl.UserDAOImpl;
import elearningproject.module.user1;



@Controller
public class UserController {
	
	 userdao Userdao=new UserDAOImpl();
@GetMapping("/user-list")
public String userspage(Model model) {
	List<user1> userlist=Userdao.findAll();
	model.addAttribute("list", userlist);
	return "users";
}
}