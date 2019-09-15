package com.luban.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/**
 * 0首先设置表头
 *	1重写list数据写入方法
 * 2设置数据
 * 3设置路径和文件名
 * 4初始化excel
 * @author hellc
 *
 */
public class ExcelTools {
	public String[] title = null;// 表头
	// 创建工作簿
	public XSSFWorkbook workbook = null;
	// 创建工作表
	public XSSFSheet sheet = null;

	// 1设置表头
	/**
	 * 1设置表头
	 * @param title
	 */
	public void setTitle(String[] title) {
		this.title = title;
	}
	public void setTitle(String title,String dec) {
		this.title = title.split(dec);
	}

	public String[] getTitle() {
		return title;
	}

	public void setTitleInit(XSSFRow row, XSSFCell cell, String[] title) {
		// 在第一行插入单元格设置值
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
	}
	// 2设置数据
/**
 * 2设置数据
 * @param list
 */
	public void setDatas(List list) {
		// 创建工作簿
		workbook = new XSSFWorkbook();
		// 创建工作表
		sheet = workbook.createSheet();
		// 创建表中的第一行 索引为0
		XSSFRow row = sheet.createRow(0);
		// 创建单元格
		XSSFCell cell = null;
		// 在第一行插入单元格设置值
		setTitleInit(row, cell, getTitle());
		// 在后面追加数据
		// 从索引1开始 因为0上是表头名称
		if (list.size() > 0)
			for (int i = 1; i < list.size(); i++) {
				// 创建新的下一行 i为行数
				XSSFRow nextRow = sheet.createRow(i);
				// 创建下一行的单元格对象 索引是一行中的第几个单元格
				XSSFCell cell2 = nextRow.createCell(0);
				setObList( list,i, nextRow, cell2);
			}
	}
	/**重写方法
	 * i获取list(i)
	 * cell2.setCellValue("名字" );
	*	cell2 = nextRow.createCell(1);//1为偏移量
	*	cell2.setCellValue("密码" );
	*cell2 = nextRow.createCell(2);
	*	cell2.setCellValue("电话");
	 */
	public void setObList(List list,int i,XSSFRow nextRow,XSSFCell cell2) {
		cell2.setCellValue("名字" );
		cell2 = nextRow.createCell(1);
		cell2.setCellValue("密码" );
		cell2 = nextRow.createCell(2);
		cell2.setCellValue("电话");
	}
	// 3设置导出路径和文件名
	/**
	 * 3设置导出路径和文件名
	 * @param path
	 * @param name
	 */
	public void setPathAndName(String path, String name) {
		// 创建一个文件
//		File file = new File("D:\\poi_test1.xlsx");
		String fileSeperator = File.separator;
		File file = new File(path + fileSeperator + name);
//		System.out.println(file.getName());
		// 将Excel文件写入创建的file当中
		OutputStream stream = null;
		try {
			stream = new FileOutputStream(file);
			try {
				workbook.write(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 4初始化
	/**
	 * 4初始化
	 * @return
	 */
	public int InitExcel() {
		if (title.equals(null) || title.length < 1) {
			return -1;
		}
		if (workbook == null) {
			return -2;
		}
		if (sheet == null) {
			return -3;
		}
		return 1;

	}

}
