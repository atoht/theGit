package demo.service;

import java.util.List;

import demo.dto.FormDto;
import demo.entity.Commodity;

public interface IEnterTheOrder {

	public void enterOrder(FormDto formDto, List<Commodity> commodityList);

}