package demo.controller;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.CommodityMapper;
import demo.dto.FormDto;
import demo.entity.Commodity;
import demo.entity.Orders;
import demo.service.DownloadExcelI;
import demo.service.IEnterTheOrder;


@Controller
public class SearchModel {
	
	@Autowired
	CommodityMapper commodityMapper;
	@Autowired
	IEnterTheOrder iEnterTheOrder;
	@Autowired
	DownloadExcelI downloadExcelI;
	@Autowired
	HttpSession session;
//	@EJB(mappedName="HelloBean")
//	Hello hello;
	
	@RequestMapping({"/SearchModel", "/"})
	public String search(Model model, FormDto formDto) {
//		init();
		List<Commodity> list = commodityMapper.selectByALL();
		model.addAttribute("list", list);
		model.addAttribute("command", new Orders());
		session.setAttribute("list", list);
//		model.addAttribute("hello", hello.sayHello());
		new ModelAndView("orders", "command", new Orders());
		return "SearchModel";
	}

	@RequestMapping(value="showCommodity", method=RequestMethod.POST)
	public String showCommodity(Model model, FormDto formDto, HttpServletRequest req) {
		String[] checkBox =req.getParameterValues("checkBox");
		
		
		List<Commodity> commodityList = commodityMapper.selectByArrayId(checkBox);
		session.setAttribute("commodityList", commodityList);
		model.addAttribute("commodityList", commodityList);
		return "SearchModel";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="enterTheOrder", method=RequestMethod.POST)
	public String enterTheOrder(Model model, FormDto formDto, HttpServletRequest req) {
		String datepicker =req.getParameter("datepicker");
		List<Commodity> commodityList = (List<Commodity>)session.getAttribute("commodityList");
		Orders orders = new Orders();
		iEnterTheOrder.enterOrder(formDto, commodityList, orders);
		model.addAttribute("formDto", formDto);
		model.addAttribute("orders", orders);
		session.setAttribute("orders", orders);
		session.setAttribute("formDto", formDto);
		return "OrderConfirm";
	}
	
	@RequestMapping(value="downloadExcel", method=RequestMethod.POST)
	public String downloadExcel(Model model, HttpServletRequest req, HttpServletResponse resp) {
		@SuppressWarnings("unchecked")
		List<Commodity> commodityList = (List<Commodity>)session.getAttribute("commodityList");
		FormDto formDto = (FormDto)session.getAttribute("formDto");
		downloadExcelI.createExcel(formDto, commodityList, resp);
		return "OrderConfirm";
	}
	
//	public void init() {
//	  Properties properties=new Properties();  
//      properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");  
//      properties.setProperty(Context.PROVIDER_URL,"t3://localhost:7001");  
//        
//      try {
//      	Context context = new InitialContext(properties);  
//      	hello = (Hello) context.lookup("HelloBean#service.Hello");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} 
//	}
}
