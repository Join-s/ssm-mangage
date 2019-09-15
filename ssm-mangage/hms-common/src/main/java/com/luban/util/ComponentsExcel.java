package com.luban.util;

import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.luban.po.TComponent;
import com.luban.po.TSubclass;

public class ComponentsExcel extends ExcelTools {
	@Override
	public void setObList(List list, int i, XSSFRow nextRow, XSSFCell cell2) {
		TComponent s = (TComponent) list.get(i);
		cell2.setCellValue(s.getId());
		cell2 = nextRow.createCell(1);
		cell2.setCellValue(s.getSid());
		cell2 = nextRow.createCell(2);
		cell2.setCellValue(s.getName());
		cell2 = nextRow.createCell(3);
		cell2.setCellValue(s.getCreatetime());
		cell2 = nextRow.createCell(4);
		cell2.setCellValue(s.getUpdatetime());
		cell2 = nextRow.createCell(5);
		cell2.setCellValue(s.getSpecification());
		cell2 = nextRow.createCell(6);
		cell2.setCellValue(s.getVal());
		cell2 = nextRow.createCell(7);
		cell2.setCellValue(s.getImg());
		cell2 = nextRow.createCell(8);
		cell2.setCellValue(s.getIntroduce());
		cell2 = nextRow.createCell(9);
		cell2.setCellValue(s.getPrice());
		cell2 = nextRow.createCell(10);
		cell2.setCellValue(s.getMalllink());
		cell2 = nextRow.createCell(11);
		cell2.setCellValue(s.getStore());
		cell2 = nextRow.createCell(12);
		cell2.setCellValue(s.getIsstore());
		cell2 = nextRow.createCell(13);
		cell2.setCellValue(s.getPlace());
		cell2 = nextRow.createCell(14);
		cell2.setCellValue(s.getLevel());
		cell2 = nextRow.createCell(15);
		cell2.setCellValue(s.getSealing());
		cell2 = nextRow.createCell(16);
		cell2.setCellValue(s.getUpdownlink());
		cell2 = nextRow.createCell(17);
		cell2.setCellValue(s.getBrand());
		cell2 = nextRow.createCell(18);
		cell2.setCellValue(s.getVersion());
		
		cell2 = nextRow.createCell(19);
		cell2.setCellValue(s.getRemark1());
		cell2 = nextRow.createCell(20);
		cell2.setCellValue(s.getRemark2());
		cell2 = nextRow.createCell(21);
		cell2.setCellValue(s.getRemark3());
		cell2 = nextRow.createCell(22);
		cell2.setCellValue(s.gettSubclass().getId());
		cell2 = nextRow.createCell(23);
		cell2.setCellValue(s.gettSubclass().getName());
		cell2 = nextRow.createCell(24);
		cell2.setCellValue(s.gettSubclass().gettLargeclass().getId());
		cell2 = nextRow.createCell(25);
		cell2.setCellValue(s.gettSubclass().gettLargeclass().getName());
		
	}
}
