package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	static Workbook book;
	static Sheet sheet;

	private static String TEST_DATA_PATH = "D:\\OneDrive - Infosys Limited\\Selenium_Test Data\\HubSpot_TestData.xlsx";

	/*
	 * This method is used to retrieve data from Excel sheet
	 */
	public static Object[][] getSheetData(String sheetData) {

		try {
			FileInputStream file = new FileInputStream(TEST_DATA_PATH);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetData);
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					String value = new DataFormatter().formatCellValue(sheet.getRow(i+1).getCell(j));
					data[i][j] = value;
				}
			}
			return data;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
