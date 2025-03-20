package in.main.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class AuthController {
	@PostMapping("/login")
	public String login() {
		return "Login Executed";
	}
	@PostMapping("/logout")
	public String logout() {
		return "Logout Executed";
	}
	@PostMapping("/welcome")
	public String welcome(@RequestBody String name) {
		return "welcome "+name;
	}
	

}
