package com.demo.SpringBootWebservice.controller;


@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from springBoot application";
	}

}
