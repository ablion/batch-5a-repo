package myspringelearningfrontend.controller;






import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController{
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("message", "Welcome to eLearning Portal");
		
		return "index";
	}
}
