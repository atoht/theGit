package demo.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		ExcelTest et = new ExcelTest();
		et.createExcel();
	}

	private void createExcel () {
		 OutputStream out = null;
		
		 Workbook wwb1 = new XSSFWorkbook();////创建excel工作簿   excel2003以及之前版本请使用HSSFWorkbook
		 Workbook wwb = new SXSSFWorkbook(100);//100代表每当有100条数据时就将内存中的数据写入到指定的excel中
		 Sheet sheet = wwb.createSheet("sheet1");// 创建sheet  若有多页sheet页面可创建多个
		 Row row = sheet.createRow(0);//创建行 0代表第一行
		 Row row1 = sheet.createRow(3);
	     row.createCell(0).setCellValue("单元格");//创建单元格并赋值 0代表当前行的第一个单元格}}}
	     row1.createCell(1).setCellValue("sdfsdfasdf");
	     
	     // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
         try {
			out =  new FileOutputStream("D:/writeExcel.xlsx");
			wwb.write(out);
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
