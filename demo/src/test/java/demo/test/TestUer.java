package demo.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.dao.CommodityMapper;
import demo.dao.UserMapper;
import demo.dto.UserDto;
import demo.entity.Commodity;
import demo.entity.User;
import demo.service.UserI;
import demo.service.UserImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestUer {
//	@Inject
//	private UserI ui;
	@Inject
	UserMapper u;
	@Inject
	User user;
	@Inject
	UserDto userDto;
	@Autowired
	CommodityMapper cm;

//	public UserI getUi() {
//		return ui;
//	}
//	@Autowired
//	public void setUi(UserI ui) {
//		this.ui = ui;
//	}
	
	@Test
	public void test01() {
//		userDto.age = 10;
		User uu = u.selectByPrimaryKey(5);
		Commodity ad = cm.selectByPrimaryKey(2);
//		userDto = ui.getUser(1);
//		u.setId(51);
//		u.setName("的解放螺丝钉解放");
//		ui.setUser(u);
		System.out.println(ad.getName()+" "+ ad.getAmount());
		System.out.println(uu.getName());
	}
}
