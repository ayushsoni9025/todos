package com.ayushsoni9025.todo.myfirstwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {
	
	//"sayhello" --> 
	@RequestMapping("/todo/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! what you are learning toay?";
	}
	
	@RequestMapping("/todo/hello-html")
	@ResponseBody
	public String HelloHtml() {
		return """
				<html>
				
				<head>
				<title>hello html</title>
				</head>
				
				<body>
				<h1>No job! fuck you</h1>
				</body>
				</html>
				""";
	}
	
	
	//say hello.jsp
	@RequestMapping("/todo/say-hello-jsp")
	//@ResponseBody
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
}
