package demo.dto;

import org.springframework.stereotype.Component;

import demo.entity.User;

@Component
public class UserDto {
	
	public String name;
	
	public int age;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
