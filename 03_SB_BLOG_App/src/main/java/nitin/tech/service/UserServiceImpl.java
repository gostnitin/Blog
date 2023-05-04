package nitin.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nitin.tech.binding.LoginForm;
import nitin.tech.binding.RegistrationForm;
import nitin.tech.entity.User;
import nitin.tech.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(RegistrationForm registrationForm) {
		
		User user = new User(registrationForm.getUserId(), registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getEmail(), registrationForm.getPassword());
		return userRepository.save(user);
	}



	@Override
	public String login(LoginForm loginForm) {
		User user = userRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		if(user == null)
		{
			return "invalid credential";
		}
		return "success";
	}


	}

