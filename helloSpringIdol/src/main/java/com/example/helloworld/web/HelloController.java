package com.example.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.domain.PerformReq;
import com.example.helloworld.service.HelloService;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;

	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}

	@RequestMapping("/hello1.do") // request handler method for /hello1.do
	public ModelAndView helloAndPerform1(@RequestParam(value="name", required=false) String name) {
		String greeting = helloService.getGreeting();
		if (name != null) greeting = greeting + " " + name;

		String performanceResult = helloService.getPerformer("someId");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performanceResult", performanceResult);
		return mav;
	}

	@RequestMapping("/hello2/{name}") // request handler method for /hello2/{name}
	public ModelAndView helloAndPerform2(@PathVariable("name") String name) {
		return helloAndPerform1(name);
	}

	@RequestMapping(value = "/helloSpringIdol/performUsingComm", method = RequestMethod.POST)
	public ModelAndView helloAndPerformUsingCommand(@ModelAttribute("request") PerformReq request) {
		// 요청 파라미터를 사용하여 공연을 실행하고 결과를 반환하는 코드
		String greeting = helloService.getGreeting();
		String performanceResult = helloService.getPerformer(request.getPerformerId());

		// 요청자 이름과 공연 결과를 뷰로 전달
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("requesterName", request.getRequesterName());
		mav.addObject("performanceResult", performanceResult);
		return mav;
	}
}
