package demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {
	
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;

	@ResponseBody
	@RequestMapping(value="/firstIndex", method=RequestMethod.POST)
	public Map<String, String> firstIndex() {
		Map<String, String> indexMap = getCookie();
		String userID = indexMap.get("SAVE_USERID");
		String password = indexMap.get("SAVE_PASSWORD");
		session.setAttribute("userID", userID);
		session.setAttribute("password", password);
		return indexMap;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginIndex(String userID, String password) {
		setCookie("SAVE_USERID", userID);
		setCookie("SAVE_PASSWORD", password);
//		Map<String, String> indexMap = getCookie();
//		String userID1 = indexMap.get("SAVE_USERID");
//		String password1 = indexMap.get("SAVE_PASSWORD");
//		session.setAttribute("userID", userID1);
//		session.setAttribute("password", password1);
		return "menu";
	}
	@RequestMapping(value="/loginOut", method=RequestMethod.POST)
	public String loginOut() {
		return "forward:";
//		ModelAndView modelAndView = new ModelAndView("/index.jsp");
//		return modelAndView;
	}
	
	
	private void setCookie(String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");
		resp.addCookie(cookie);
	}
	
	private Map<String, String> getCookie() {
		Map<String, String> map = new HashMap<String, String>();
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if("SAVE_USERID".equals(cookie.getName())) map.put("SAVE_USERID", cookie.getValue());
			if("SAVE_PASSWORD".equals(cookie.getName())) map.put("SAVE_PASSWORD", cookie.getValue());
		}
		return map;
	}
	
}
