package demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dto.FormDto;
import demo.entity.Commodity;

@Service
public class DownloadExcelImpl implements DownloadExcelI {
	
	@Autowired
	HttpSession session;

	public void createExcel (FormDto formDto, List<Commodity> commodityList) {
		 OutputStream out = null;
		
//		 Workbook wwb1 = new XSSFWorkbook();//创建excel工作簿   excel2003以及之前版本请使用HSSFWorkbook
		 Workbook wwb = new SXSSFWorkbook(100);//100代表每当有100条数据时就将内存中的数据写入到指定的excel中
		 Sheet sheet = wwb.createSheet("订单明细");// 创建sheet  若有多页sheet页面可创建多个
		 //设置样式
		 CellStyle cellStyle =wwb.createCellStyle();
		 cellStyle.setFillForegroundColor((short) 13);
		 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		 cellStyle.setFillForegroundColor((short) 13);// 设置背景色  
//		 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		 //创建商品标题
		 Row row0 = sheet.createRow(0);
		 row0.createCell(0).setCellValue("商品名称");//创建单元格并赋值 0代表当前行的第一个单元格}}}
		 row0.createCell(1).setCellValue("商品型号");
		 row0.createCell(2).setCellValue("数量");
		 row0.createCell(3).setCellValue("单价");
		 row0.createCell(4).setCellValue("金额");
		 int count = 1;
		 for (int i=0 ; i<commodityList.size(); i++) {
			 if (formDto.selectFlag[i]) {
				 Row row = sheet.createRow(count);//创建行 0代表第一行
				 row.createCell(0).setCellValue(commodityList.get(i).getName());//创建单元格并赋值 0代表当前行的第一个单元格}}}
				 row.createCell(1).setCellValue(commodityList.get(i).getModel());
				 row.createCell(2).setCellValue(formDto.quantity[i]);
				 row.createCell(3).setCellValue(commodityList.get(i).getUnitprice().toString());
				 row.createCell(4).setCellValue(commodityList.get(i).getAmount().toString());
				 count++;
			 }
		 }
		 String path = "D:/javaTemp/" + session.getId();
		 File myPath = new File(path);
		   if ( !myPath.exists()){//若此目录不存在，则创建之// 这个东西只能简历一级文件夹，两级是无法建立的。。。。。
		           myPath.mkdir();
		}
		   path = path + "/writeExcel.xlsx";
	     // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
        try {
			out =  new FileOutputStream(path);
			wwb.write(out);
			wwb.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
           try {
               if(out != null){
                   out.flush();
                   out.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
		}
	}
}
