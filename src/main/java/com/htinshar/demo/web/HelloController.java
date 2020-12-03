package com.htinshar.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {

	@RequestMapping("/basic")
	public String sayHello() {
		return "<h2>hello</h2>";
	}

	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h2>hello there,how are you?</h2>";
	}

	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"GET\">\r\n"
				+ "  <label for=\"fname\">First name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"firstName\"><br>\r\n"
				+ "  <label for=\"lname\">Last name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lastName\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n" + "</form> ";
	}

	@RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstName,@RequestParam String lastName) {
		return "hello there "+firstName+" "+lastName;
	}
	
	@RequestMapping(value = "/orders/{id}",method=RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order id"+id;
	}
}
