package demo.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import demo.dao.UserMapper;
import demo.dto.UserDto;
import demo.entity.User;

@Service
public class UserImpl implements UserI{
	
	@Inject
	private UserMapper um;
	@Inject
	User u;
	@Inject
	UserDto userDto;
	

	public UserDto getUser(int id) {
		u.setFirstName("firstName");
		userDto.name = "firstName";
		u = um.selectByPrimaryKey(id);
		userDto.setUser(u);
		return userDto;
	}

	public void setUser(User record) {
		um.insert(record);
	}


	
	

//	public User getUser(int id) {
//		return um.selectByPrimaryKey(id);
//	}

}
