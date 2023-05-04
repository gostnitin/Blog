package nitin.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import nitin.tech.binding.LoginForm;
import nitin.tech.binding.RegistrationForm;
import nitin.tech.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public RegistrationForm registrationForm()
	{
		return new RegistrationForm();
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@PostMapping("/registration")
	public String RegistrationAccount(@ModelAttribute("user") RegistrationForm registrationForm)
	{
		userService.save(registrationForm);
		return "redirect:/registration?success";
		
	}
	
	@GetMapping("/login")
	public String loginPage(Model model)
	{
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model)
	{
		String status = userService.login(loginForm);
		if(status.contains("success"))
		{
			
			return "redirect:/login";
		}
		
		model.addAttribute("errorMsg", status);
		return "login";
	}

}
