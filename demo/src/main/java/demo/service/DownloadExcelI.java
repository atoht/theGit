package demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import demo.dto.FormDto;
import demo.entity.Commodity;

public interface DownloadExcelI {

	public void createExcel (FormDto formDto, List<Commodity> commodityList, HttpServletResponse resp);
}