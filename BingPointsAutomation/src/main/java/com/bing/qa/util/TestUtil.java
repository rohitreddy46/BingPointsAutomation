package com.bing.qa.util;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<String> getDataFromExcel(){
		
		ArrayList<String> myData = new ArrayList<String>();
		
		try {
			
			reader = new Xls_Reader("C:\\Users\\rohit\\git\\BingPointsAutomation\\BingPointsAutomation\\src\\main\\java\\com\\bing\\qa\\testdata\\BingPointsTestData.xlsx");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("RegTestData"); rowNum++) {
			
			
				String SearchItems = reader.getCellData("RegTestData", "SearchItems", rowNum);
				myData.add(SearchItems);

				
		}
		return myData;
		
	}

}
