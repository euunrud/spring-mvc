package com.example.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("duke")
public class PoeticJuggler extends Juggler {
	private Poem poem;

	@Value("poeJ")
	private String name;

	public String getName() { return this.name;	}

	@Autowired(required = false)
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	@Autowired(required = false)
	public PoeticJuggler(@Value("5") int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	public String perform() throws PerformanceException {
		super.perform();
		poem.recite();
		return "While reciting...";
	}
}
