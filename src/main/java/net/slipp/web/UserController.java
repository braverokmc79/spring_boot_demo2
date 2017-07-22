package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	

	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("create")
	public String create(User user){
		log.info("create   : {}", user.toString()); 
		// jpa h2 로 자동으로 인클로드 된다.
		userRepository.save(user);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model){
		// userRepository.findAll() 목록 가져오기
		model.addAttribute("users", userRepository.findAll());
		return "list";
	}
	
}




