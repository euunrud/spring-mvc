package com.example.helloworld.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springidol.Performer;

@Service
public class HelloService {
	private Map<String, Performer> performers = new HashMap<>();

	@Autowired
	public HelloService(List<Performer> performerList) {
		for (Performer performer : performerList) {
			performers.put(performer.getName(), performer);
		}
	}

	public Performer getPerformer(String id) {
		// for (Performer performer : performers) {
		// 	if(performer.getName() == id){
		// 		return performer;
		// 	}
		// }
		// return null;
		return performers.get(id);
	}
	public String getGreeting() {		// business method
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "Good morning! ";
		} else if (hour >= 12 && hour <= 15) {
			return "Did you have lunch? ";
		} else if (hour >= 18 && hour <= 24) {
			return "Good evening! ";
		}
		return "Hello! ";
	}
}
