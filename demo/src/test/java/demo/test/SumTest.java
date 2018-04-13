package demo.test;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class SumTest {
	
	public static void main(String[] args) {
		double d = 9.84;
		double d2 = 1.22;
		double dd = d*d2;
		//注意需要使用BigDecimal(String val)构造方法
		BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
		BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
		
		//乘法
		BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
		double multiply = bigDecimalMultiply.doubleValue();
		
		double format = 12343171.6;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMinimumFractionDigits(2);//设置数的小数部分所允许的最小位数(如果不足后面补0)
		currency.setMaximumFractionDigits(4);//设置数的小数部分所允许的最大位数(如果超过会四舍五入)
		String str = currency.format(format);//￥12,343,171.60
		System.out.println();
	}
}
