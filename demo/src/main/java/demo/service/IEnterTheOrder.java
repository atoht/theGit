package demo.service;

import java.util.List;

import demo.dto.FormDto;
import demo.entity.Commodity;
import demo.entity.Orders;

public interface IEnterTheOrder {

	public void enterOrder(FormDto formDto, List<Commodity> commodityList, Orders orders);

}