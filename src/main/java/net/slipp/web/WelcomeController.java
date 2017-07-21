package net.slipp.web;

import java.util.Arrays;
import java.util.List;

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
		List<MyModel> repo =Arrays.asList(new MyModel("javajigi"),
				new MyModel("kete77"));
		
		System.out.println("name : " +name + " age : "+ age);
		model.addAttribute("repo",repo);
		model.addAttribute("name", name);
		model.addAttribute("age" , age);
		return "welcome";
	}
	
	
	
}


