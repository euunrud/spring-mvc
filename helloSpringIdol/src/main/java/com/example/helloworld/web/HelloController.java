package com.example.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.service.HelloService;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {

	private HelloService helloService;

	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}

	@RequestMapping("/hello1.do") // request handler method for /hello1.do
	public ModelAndView helloAndPerform1(@RequestParam(value="name", required=false) String name) {
		String greeting = helloService.getGreeting();
		if (name != null) greeting = greeting + " " + name;
		String performanceResult = helloService.getPerformer("someId").perform();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performanceResult", performanceResult);
		return mav;
	}


	// @RequestMapping("/hello.do")		// request handler method
	// public ModelAndView helloAndPerform2(
	// 	@RequestParam(value="name", required=false) String name) {
	//
	// 	String greeting = helloService.getGreeting();
	// 	if (name != null) greeting = greeting + name;
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.setViewName("hello");
	// 	mav.addObject("greeting", greeting);
	// 	return mav;
	// }

	@RequestMapping("/hello2/{name}") // request handler method for /hello2/{name}
	public ModelAndView helloAndPerform2(@PathVariable("name") String name) {
		return helloAndPerform1(name);
	}
}
