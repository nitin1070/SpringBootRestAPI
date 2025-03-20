package in.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
	@GetMapping("/hello")
    public String hello() {
    	return  "Hello From SpringBoot REST API";
    }
}
