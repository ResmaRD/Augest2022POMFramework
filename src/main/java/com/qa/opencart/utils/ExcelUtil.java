package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;


public class ExcelUtil {
	public static final String TEST_DATA_SHEET = "./src/test/resources/testdata/OpenCartRegister.xlsx";
	private static Workbook wb;
	private static Sheet st;
	public Properties prop;

	public static Object[][] getTestData(String sheet_name) {

		Object data[][] = null;

		try {

			FileInputStream file_in = new FileInputStream(TEST_DATA_SHEET);

			wb = WorkbookFactory.create(file_in);

			st = wb.getSheet(sheet_name);

			int row_no = st.getLastRowNum();
			int cell_no = st.getRow(0).getLastCellNum();

			// data = new Object[st.getLastRowNum()][st.getRow(0).getLastCellNum()];

			data = new Object[row_no][cell_no];

			for (int i = 0; i < row_no; i++) {

				for (int j = 0; j < cell_no; j++) {

					data[i][j] = st.getRow(i+1).getCell(j).toString();

				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return data;

	}

	public static void readDataFromExcel(String sheet_name) {

		try {

			FileInputStream file_in = new FileInputStream("./src\\test\\resources\\testdata\\OpenCartRegister.xlsx");

			Workbook wb = WorkbookFactory.create(file_in);
			Sheet st = wb.getSheet(sheet_name);

			// Row r = st.getRow(1);
			 //Cell c = r.getCell(0);
			// String value= c.getStringCellValue();
			// System.out.println(value);

			int row_no = st.getLastRowNum();

			for (int i = 1; i < row_no; i++) {

				Row r = st.getRow(i);

				int cell_No = r.getLastCellNum();

				for (int j = 0; j < cell_No; j++) {

					Cell c = r.getCell(j);

					String value = c.getStringCellValue();

					System.out.println(value);

				}

			}

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		readDataFromExcel("Sheet1");
	}

}



