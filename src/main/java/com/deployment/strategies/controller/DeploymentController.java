package com.deployment.strategies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeploymentController {

	@GetMapping("/sample")
	public String getSample() {

		return "java-app-v.2.0 deployed !.";
	}

}
