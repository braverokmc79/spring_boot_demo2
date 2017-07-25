package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/loginForm")
	public String loginForm(){
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session){
		User user =userRepository.findByUserId(userId);
		if(user==null){
			log.info("login -  user.null");
			return "redirect:/users/loginForm";
		}
		if(!password.equals(user.getPassword())){
			log.info("login -  !password");
			return "redirect:/users/loginForm";
		}
		
		log.info("login -  success");
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	
	
	@GetMapping("/form")
	public String form(){	
		return "/user/form";
	}
		
	
	@PostMapping("")
	public String create(User user){
		log.info("create   : {}", user.toString()); 
		// jpa h2 로 자동으로 인클로드 된다.
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String list(Model model){
		// userRepository.findAll() 목록 가져오기
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model){
		log.info("update form {} ", id);
		User user =userRepository.findOne(id);
		model.addAttribute("user",user);
		return "/user/updateform";
	}
	
	
	@PutMapping("/update")
	public String update(User updateUser){
		//save() 는 기존의 아이디값이 있으면 업데이트 없으면 인서트 한다.
		userRepository.save(updateUser);
		return "redirect:/users";
	}
	
	
	
}




