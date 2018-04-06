package demo.service;

import demo.dto.UserDto;
import demo.entity.User;

public interface UserI {
	
	public UserDto getUser(int id);
	
	public void setUser(User record);
}
