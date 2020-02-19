package com.bund.north.bund.gateway.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/message")
	public String test() {
		return "Hello Spring Cloud gateway";
	}
}
