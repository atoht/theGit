package demo.test;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import demo.dao.CommodityMapper;
import demo.dao.UserMapper;
import demo.dto.UserDto;
import demo.entity.Commodity;
import demo.entity.User;
import demo.service.UserI;
import demo.service.UserImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
@WebAppConfiguration
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
//	@EJB(mappedName="HelloBean")
//	Hello hello;

//	public UserI getUi() {
//		return ui;
//	}
//	@Autowired
//	public void setUi(UserI ui) {
//		this.ui = ui;
//	}
	@Test
	public void test01() {
		
		System.out.println();
	}
	
//	@Test
//	public void test01() {
//		System.out.println(System.getProperty("java.classpath"));
//		Properties properties=new Properties();  
//        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");  
//        properties.setProperty(Context.PROVIDER_URL,"t3://localhost:7001");  
//          
//        try {
//        	Context context = new InitialContext(properties);  
//			hello = (Hello) context.lookup("HelloBean#service.Hello");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//        System.out.println(hello.sayHello());
//		userDto.age = 10;
//		User uu = u.selectByPrimaryKey(5);
//		Commodity ad = cm.selectByPrimaryKey(2);
//		String[] s = {"2","3","6"};
//		List<Commodity> comList = cm.selectByArrayId(s);
//		for (Commodity temp : comList) {
//			System.out.println(temp.getName());
//		}
//		userDto = ui.getUser(1);
//		u.setId(51);
//		u.setName("的解放螺丝钉解放");
//		ui.setUser(u);
//		System.out.println(ad.getName()+" "+ ad.getAmount());
//		System.out.println(uu.getName());
//	}
}
