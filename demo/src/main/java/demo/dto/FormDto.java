package demo.dto;

import java.util.List;

import demo.entity.Commodity;

public class FormDto {
	
	private String selectFlag1;
	
	private String selectFlag2;
	
	public String selectFlag3;
	
	private String selectFlag4;
	
	private String selectFlag5;
	
	public boolean[] selectFlag;
	
	private Integer quantity1;
	
	private Integer quantity2;
	
	private Integer quantity3;
	
	private Integer quantity4;
	
	private Integer quantity5;
	
	public Integer[] quantity;
	
	List<Commodity> commodityList;
	
	public String formcheckboxStr;

	public Boolean formcheckboxBoo;

	public String getSelectFlag1() {
		return selectFlag1;
	}

	public void setSelectFlag1(String selectFlag1) {
		this.selectFlag1 = selectFlag1;
	}

	public String getSelectFlag2() {
		return selectFlag2;
	}

	public void setSelectFlag2(String selectFlag2) {
		this.selectFlag2 = selectFlag2;
	}

	public String getSelectFlag3() {
		return selectFlag3;
	}

	public void setSelectFlag3(String selectFlag3) {
		this.selectFlag3 = selectFlag3;
	}

	public String getSelectFlag4() {
		return selectFlag4;
	}

	public void setSelectFlag4(String selectFlag4) {
		this.selectFlag4 = selectFlag4;
	}

	public String getSelectFlag5() {
		return selectFlag5;
	}

	public void setSelectFlag5(String selectFlag5) {
		this.selectFlag5 = selectFlag5;
	}

	public Integer getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(Integer quantity1) {
		this.quantity1 = quantity1;
	}

	public Integer getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(Integer quantity2) {
		this.quantity2 = quantity2;
	}

	public Integer getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(Integer quantity3) {
		this.quantity3 = quantity3;
	}

	public Integer getQuantity4() {
		return quantity4;
	}

	public void setQuantity4(Integer quantity4) {
		this.quantity4 = quantity4;
	}

	public Integer getQuantity5() {
		return quantity5;
	}

	public void setQuantity5(Integer quantity5) {
		this.quantity5 = quantity5;
	}

	public boolean[] getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(boolean[] selectFlag) {
		this.selectFlag = selectFlag;
	}

	public Integer[] getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public String getFormcheckboxStr() {
		return formcheckboxStr;
	}

	public void setFormcheckboxStr(String formcheckboxStr) {
		this.formcheckboxStr = formcheckboxStr;
	}

	public Boolean getFormcheckboxBoo() {
		return formcheckboxBoo;
	}

	public void setFormcheckboxBoo(Boolean formcheckboxBoo) {
		this.formcheckboxBoo = formcheckboxBoo;
	}

}
