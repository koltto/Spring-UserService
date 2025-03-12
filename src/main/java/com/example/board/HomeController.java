package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@GetMapping
	public String home(@RequestParam(name="message" , defaultValue="tuna") String message
			           ,Model model) {
		
		log.info("message: {}" + message);
		model.addAttribute("message", message);
		return "index";
	}
}
