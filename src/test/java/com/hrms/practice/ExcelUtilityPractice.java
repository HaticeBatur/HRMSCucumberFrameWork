package com.hrms.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityPractice {
	
	private static Workbook wbook;
	private static Sheet sheet;
	public static void openExcell(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			wbook = new XSSFWorkbook(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void loadSheet(String sheetName) {
		sheet = wbook.getSheet(sheetName);
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}
	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	}
	
	public static List<Map<String, String>> excellIntiListOfMaps(String filePath, String sheetName){
		openExcell(filePath);
		loadSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		
		
		return list;
	}
}
