package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 컨트롤로 호츨되는 mustach sms 
templates 폴더로 적용된다.

*/

@Controller
public class WelcomeController {

	@GetMapping("/helloworld")
	public String welcome(String name, int age,  Model model) {
		System.out.println("name : " +name + " age : "+ age);
		model.addAttribute("name", name);
		model.addAttribute("age" , age);
		return "welcome";
	}
	
	
	
}




