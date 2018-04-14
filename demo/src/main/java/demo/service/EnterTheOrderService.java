package demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.CommodityMapper;
import demo.dao.OrdersMapper;
import demo.dto.FormDto;
import demo.entity.Commodity;
import demo.entity.Orders;

@Service
public class EnterTheOrderService implements IEnterTheOrder {
	
	@Autowired
	CommodityMapper commodityMapper;
	@Autowired
	OrdersMapper ordersMapper;
	
	@Override
	public void enterOrder (FormDto formDto, List<Commodity> commodityLis) {
		
		Orders orders = new Orders();
		int count = 0;
		for (Commodity temp : commodityLis) {
			if (!StringUtils.isEmpty(formDto.getSelectFlag1()) && count != 1) {
				if (formDto.getSelectFlag1().equals(temp.getId().toString())) {
					BigDecimal bigDecimal = new BigDecimal(formDto.getQuantity1());
					//乘法
					BigDecimal quantity = bigDecimal.multiply(temp.getUnitprice());
					orders.setName1(temp.getName());
					orders.setModel1(temp.getModel());
					orders.setQuantity1(formDto.getQuantity1());
					orders.setAmount1(quantity);
					orders.setTotalamount(orders.getAmount1());
					count = 1;
				}
			}
			if (!StringUtils.isEmpty(formDto.getSelectFlag2()) && count != 2) {
				if (formDto.getSelectFlag2().equals(temp.getId().toString())) {
					BigDecimal bigDecimal = new BigDecimal(formDto.getQuantity2());
					//乘法
					BigDecimal quantity = bigDecimal.multiply(temp.getUnitprice());
					orders.setName2(temp.getName());
					orders.setModel2(temp.getModel());
					orders.setQuantity2(formDto.getQuantity2());
					orders.setAmount2(quantity);
					if (orders.getTotalamount() != null) {
						orders.setTotalamount(orders.getTotalamount().add(orders.getAmount2()));
					}else {
						orders.setTotalamount(orders.getAmount2());
					} 
					count = 2;
				}
			}
			if (!StringUtils.isEmpty(formDto.getSelectFlag3()) && count != 3) {
				if (formDto.getSelectFlag3().equals(temp.getId().toString())) {
					BigDecimal bigDecimal = new BigDecimal(formDto.getQuantity3());
					//乘法
					BigDecimal quantity = bigDecimal.multiply(temp.getUnitprice());
					orders.setName3(temp.getName());
					orders.setModel3(temp.getModel());
					orders.setQuantity3(formDto.getQuantity3());
					orders.setAmount3(quantity);
					if (orders.getTotalamount() != null) {
						orders.setTotalamount(orders.getTotalamount().add(orders.getAmount3()));
					}else {
						orders.setTotalamount(orders.getAmount3());
					} 
					count = 3;
				}
			}
			if (!StringUtils.isEmpty(formDto.getSelectFlag4()) && count != 4) {
				if (formDto.getSelectFlag4().equals(temp.getId().toString())) {
					BigDecimal bigDecimal = new BigDecimal(formDto.getQuantity4());
					//乘法
					BigDecimal quantity = bigDecimal.multiply(temp.getUnitprice());
					orders.setName4(temp.getName());
					orders.setModel4(temp.getModel());
					orders.setQuantity4(formDto.getQuantity4());
					orders.setAmount4(quantity);
					if (orders.getTotalamount() != null) {
						orders.setTotalamount(orders.getTotalamount().add(orders.getAmount4()));
					}else {
						orders.setTotalamount(orders.getAmount4());
					} 
					count = 4;
				}
			}
			if (!StringUtils.isEmpty(formDto.getSelectFlag5()) && count != 5) {
				if (formDto.getSelectFlag5().equals(temp.getId().toString())) {
					BigDecimal bigDecimal = new BigDecimal(formDto.getQuantity5());
					//乘法
					BigDecimal quantity = bigDecimal.multiply(temp.getUnitprice());
					orders.setName5(temp.getName());
					orders.setModel5(temp.getModel());
					orders.setQuantity5(formDto.getQuantity5());
					orders.setAmount5(quantity);
					if (orders.getTotalamount() != null) {
						orders.setTotalamount(orders.getTotalamount().add(orders.getAmount5()));
					}else {
						orders.setTotalamount(orders.getAmount5());
					} 
					count = 5;
				}
			}
		}
		ordersMapper.insert(orders);
	}
}
