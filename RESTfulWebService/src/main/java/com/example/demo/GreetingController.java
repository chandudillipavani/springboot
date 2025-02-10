package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//the controller will ensure that the class will control how the object will be used
//it is done using two parts:
//1.get mapping
//2.request parameters

@RestController
public class GreetingController {
	// percentage is the place holder
	// s is a placeholder of run time value.
	// for example if user inputs : "abcd" result:"hello; abcd"
	private static final String template = "Hello, %s!";
	// AtomaticLong is a data type that will handle huge data
	private final AtomicLong atomicLong = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(atomicLong.incrementAndGet(), String.format(template, name));
	}

}
