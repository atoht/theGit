package demo.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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

	public void createExcel (FormDto formDto, List<Commodity> commodityList, HttpServletResponse resp) {
		 OutputStream out = null;
		
//		 Workbook wwb1 = new XSSFWorkbook();//创建excel工作簿   excel2003以及之前版本请使用HSSFWorkbook
		 HSSFWorkbook wwb = new HSSFWorkbook();//100代表每当有100条数据时就将内存中的数据写入到指定的excel中
		 HSSFSheet sheet = wwb.createSheet("订单明细");// 创建sheet  若有多页sheet页面可创建多个
		 
		 //设置样式
		 HSSFDataFormat format= wwb.createDataFormat();
		 CellStyle cellStyle =wwb.createCellStyle();
		 CellStyle cellStyle1 =wwb.createCellStyle();
		 CellStyle cellStyle2 =wwb.createCellStyle();
		 cellStyle2.setDataFormat(format.getFormat("#,##0.000"));
		 cellStyle1.setBorderBottom(BorderStyle.THIN); //下边框  
		 cellStyle1.setBorderLeft(BorderStyle.THIN);//左边框  
		 cellStyle1.setBorderTop(BorderStyle.THIN);//上边框  
		 cellStyle1.setBorderRight(BorderStyle.THIN);//右边框 
		 cellStyle1.setAlignment(HorizontalAlignment.LEFT);
		 cellStyle2.setAlignment(HorizontalAlignment.RIGHT);
		 cellStyle2.setBorderBottom(BorderStyle.THIN); //下边框  
		 cellStyle2.setBorderLeft(BorderStyle.THIN);//左边框  
		 cellStyle2.setBorderTop(BorderStyle.THIN);//上边框  
		 cellStyle2.setBorderRight(BorderStyle.THIN);//右边框
		 
		 //创建商品标题
		 HSSFPalette palette = wwb.getCustomPalette();  //wb HSSFWorkbook对象
		 palette.setColorAtIndex((short)11, (byte) (135), (byte) (206), (byte) (250));
		 cellStyle.setFillForegroundColor((short) 11);
		 cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		 cellStyle.setAlignment(HorizontalAlignment.CENTER);
		 cellStyle.setBorderBottom(BorderStyle.THIN); //下边框  
		 cellStyle.setBorderLeft(BorderStyle.THIN);//左边框  
		 cellStyle.setBorderTop(BorderStyle.THIN);//上边框  
		 cellStyle.setBorderRight(BorderStyle.THIN);//右边框  
		 Row row0 = sheet.createRow(0);
		 Cell c= row0.createCell(0);
		 Cell c1= row0.createCell(1);
		 Cell c2= row0.createCell(2);
		 Cell c3= row0.createCell(3);
		 Cell c4= row0.createCell(4);
		 c.setCellStyle(cellStyle);
		 c.setCellValue("商品名称");
		 c1.setCellStyle(cellStyle);
		 c1.setCellValue("商品型号");
		 c2.setCellStyle(cellStyle);
		 c2.setCellValue("数量");
		 c3.setCellStyle(cellStyle);
		 c3.setCellValue("单价");
		 c4.setCellStyle(cellStyle);
		 c4.setCellValue("金额");
		 int count = 1;
		 Date date = new Date();
		 BigDecimal totalAmount = new BigDecimal("0");
		 Row row;
		 for (int i=0 ; i<commodityList.size(); i++) {
			 if (formDto.selectFlag[i]) {
				 row = sheet.createRow(count);//创建行 0代表第一行
				 Cell cell = row.createCell(0);
				 cell.setCellStyle(cellStyle1);
				 Cell cell1 = row.createCell(1);
				 cell1.setCellStyle(cellStyle1);
				 Cell cell2 = row.createCell(2);
				 cell2.setCellStyle(cellStyle1);
				 Cell cell3 = row.createCell(3);
				 cell3.setCellStyle(cellStyle2);
				 Cell cell4 = row.createCell(4);
				 cell4.setCellStyle(cellStyle2);
				 cell.setCellValue(commodityList.get(i).getName());
				 cell1.setCellValue(commodityList.get(i).getModel());
				 cell2.setCellValue(formDto.quantity[i]);
				 cell3.setCellValue(commodityList.get(i).getUnitprice().doubleValue());
				 cell4.setCellValue(commodityList.get(i).getAmount().doubleValue());
				 if (totalAmount.equals(new BigDecimal("0"))) {
					 totalAmount = commodityList.get(i).getAmount();
				 }else {
					 totalAmount = add(totalAmount, commodityList.get(i).getAmount() );
				 }
				 count++;
			 }
		 }
//		 HSSFCell cell0 = sheet.createRow(count).createCell(5);
		 HSSFRow hRow = sheet.createRow(count);
		 HSSFCell cell0 = hRow.createCell(5);
		 cell0.setCellValue(totalAmount.doubleValue());
		 cell0.setCellStyle(cellStyle2);
		 HSSFCell cell = hRow.createCell(6);
//		 HSSFCell cell = hRow.createCell(5);
		 cellStyle.setDataFormat(format.getFormat("yyyy年m月d日"));
		 cell.setCellValue(date);
         cell.setCellStyle(cellStyle);
         
         sheet.autoSizeColumn(1, true);//列自适应宽度
		 sheet.autoSizeColumn(2, true);
		 sheet.autoSizeColumn(3, true);
		 sheet.autoSizeColumn(4, true);
		 sheet.autoSizeColumn(5, true);
		 sheet.autoSizeColumn(6, true);
		 sheet.autoSizeColumn(7, true);
		 
		 String path = "D:/javaTemp/" + session.getId();
		 File myPath = new File(path);
		   if ( !myPath.exists()){//若此目录不存在，则创建之// 这个东西只能简历一级文件夹，两级是无法建立的。。。。。
		           myPath.mkdir();
		}
		   path = path + "/writeExcel.xls";
	     // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
        try {
			out =  new FileOutputStream(path);
//			PrintWriter pw = resp.getWriter();
			OutputStream outResp = resp.getOutputStream();
			resp.setContentType("octets/stream");  
//	      response.addHeader("Content-Disposition", "attachment;filename=test.xls");  
	        String excelName = "学生信息表";  
	        //转码防止乱码  
	        resp.addHeader("Content-Disposition", "attachment;filename="+new String( excelName.getBytes("gb2312"), "ISO8859-1" )+".xls");  
//			pw.println("<script>");
//			pw.println("alert('此用户名已存在，请重新输入！');");
//	        pw.println("</script>");
//			pw.flush();
			wwb.write(out);
			wwb.write(outResp);
//			pw.close();
			outResp.close();
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
	
	public static BigDecimal add(BigDecimal v1,BigDecimal v2){  
		return v1.add(v2);  
		} 
}
