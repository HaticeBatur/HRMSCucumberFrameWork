package com.hrms.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DbUtils;

public class CreateExcellFromDatabase extends DbUtils {
	private static Connection conn;
	private static Statement st;
		static Workbook book;
		static Sheet sheet;

		@Test
		public void getAndStoreDataEnhanced() throws SQLException  {
			ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
			System.out.println(ConfigsReader.getProperty("dbUrl")+
					ConfigsReader.getProperty("dbUsername")+ ConfigsReader.getProperty("dbPassword"));
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"), 
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
			st=conn.createStatement();
			ResultSet rset = st.executeQuery("select * from hs_hr_employees order by emp_number limit 100");
			ResultSetMetaData rsetData = rset.getMetaData();
		
			try {
				FileInputStream fis= new FileInputStream(Constants.XL_DATA_FILEPATH);
				 book=new XSSFWorkbook(fis);
				 sheet=book.getSheet("Sheet1");
			}catch(IOException e) {
				e.printStackTrace();
			}
			Row row=sheet.createRow(0);
			for(int i=1; i<=rsetData.getColumnCount();i++) {
				row.createCell(i).setCellValue(rsetData.getColumnName(i));
			}
			int count=1;
			while(rset.next()) {
				row=sheet.createRow(count);
				for(int i=1; i<=rsetData.getColumnCount(); i++) {
					String value;
					if(rset.getObject(i)!=null) {
						value=rset.getObject(i).toString();
					}else {
						value=null;
					}
					row.createCell(i).setCellValue(value);
				}
				count++;
			}
			try{
				FileOutputStream fos=new FileOutputStream(Constants.XL_DATA_FILEPATH);
				book.write(fos);
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
	}
