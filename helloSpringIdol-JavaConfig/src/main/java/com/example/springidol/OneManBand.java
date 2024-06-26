package com.example.springidol;

import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hank")
public class OneManBand implements Performer, BeanNameAware {
	@Autowired
	@Qualifier("forHank")
	private Map<String, Instrument> instruments; // Map 타입 property

	public OneManBand() {
	}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public String perform() throws PerformanceException {
		String print = "";
		for (String key : instruments.keySet()) {
			print.concat(key + ": ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}

		return print;
	}

	private String beanName;

	@Value("onemanBand")
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
