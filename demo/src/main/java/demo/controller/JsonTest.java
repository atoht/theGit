package demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.annotation.FormToO;
import demo.dao.UserMapper;
import demo.entity.Student;
import demo.entity.User;

@Controller
public class JsonTest {
	@Inject
	UserMapper um;
	
	@ResponseBody
	@RequestMapping(value="/test000",method=RequestMethod.POST)
	public List<User> test01(@RequestBody List<User> user) {
		for (User temp : user) {
			System.out.println(temp.getName());
			um.insertSelective(temp);
		}
		return user;
	}
	@ResponseBody
	@RequestMapping(value="/testStudent",method=RequestMethod.POST)
	public Map<String, Object> testStudent(@FormToO User user, @FormToO Student student) {
//	    System.out.println(user);
	    System.out.println(student.getLastName());
	    System.out.println(user.getAge());
	    System.out.println(user.getListName());
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("user", user);
	    map.put("student", student);
	    return map;
	}
}
