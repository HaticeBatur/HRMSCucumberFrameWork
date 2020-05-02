package com.hrms.practice;

import java.util.List;
import java.util.Map;

import com.hrms.utils.APIConstants;
import com.hrms.utils.Constants;

public class Test {
	private static final double PI = 3.14159;
	
	public static void main(String[] args) {
		ConfigReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String value = ConfigReader.getProperty("url");
		System.out.println(value);
		
		boolean goodJob = ReadWriteTextFile.writeText(APIConstants.JSON_FILEPATH + "token.txt", "\nHello");

		List<String> lines = ReadWriteTextFile.readLines(APIConstants.JSON_FILEPATH + "token.txt");
		for(String line:lines) {
			System.out.println(line);
		}
		
		ConfigReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		DatabaseUtility.createConnection();
		List<Map<String, String>> maps = DatabaseUtility.readFromDb("select * from ohrm_nationality");
		System.out.println(maps);
	}
}
