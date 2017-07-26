package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.Question;
import net.slipp.domain.QuestionRepository;
import net.slipp.domain.User;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	
	private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form(HttpSession session){
		if(!HttpSessionUtils.isLoginUser(session)){
			return "/users/loginForm";
		}
		return "/qna/form";
	}
	
	@PostMapping("")
	public String create(HttpSession session, String title, String contents){
		if(!HttpSessionUtils.isLoginUser(session)){
			return "/users/loginForm";
		}
		log.info("create(String title, String contents) {} , {} ", title, contents);
		User sessionUser =HttpSessionUtils.getUserFromSession(session);
		Question newQuestion =new Question(sessionUser.getUserId(), title, contents);
		
		questionRepository.save(newQuestion);
		
		return "redirect:/";
	}
	
	
}
