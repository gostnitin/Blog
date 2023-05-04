package nitin.tech.service;

import nitin.tech.binding.LoginForm;
import nitin.tech.binding.RegistrationForm;
import nitin.tech.entity.User;

public interface UserService {
	
	public User save(RegistrationForm registrationForm);

	public String login(LoginForm loginForm);

}
