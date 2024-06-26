package com.example.springidol;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;

public class Juggler implements Performer, BeanNameAware {
	private int beanBags = 3;

	public Juggler() {
	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public String perform() throws PerformanceException {
		return "JUGGLING " + beanBags + " BEANBAGS";
	}

	private String beanName;

	@Value("juggler")
	private String name;

	public String getName() { return this.name;	}
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	@Override
	public String getBeanName() {
		return beanName;
	}
}
