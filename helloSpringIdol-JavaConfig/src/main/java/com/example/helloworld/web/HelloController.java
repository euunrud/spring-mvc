package com.example.helloworld.web;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.service.HelloService;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {

	public HelloService helloService;

	public HelloController(SpringIdol springIdol, HelloService helloService) {
		springIdol.run();
		this.helloService = helloService;
	}

	@RequestMapping("/hello.do")		// request handler method
	public ModelAndView hello(			
		@RequestParam(value="name", required=false) String name) {
		
		String greeting = helloService.getGreeting();
		if (name != null) greeting = greeting + name;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", greeting);
		return mav;
	}
}
