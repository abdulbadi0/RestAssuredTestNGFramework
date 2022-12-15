package testDataParametrization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExcelData {

	@Test
	public void setupExcelReading() throws IOException {
		System.out.println("Starting excel file reading data...");
		File file = new File("C:\\Users\\Asus\\Pictures\\testExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("FirstDataSheetR");
		System.out.println("Sheet Name is:- " + sheet.getSheetName());
		String str = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(str);
		int totalRow = sheet.getPhysicalNumberOfRows();
		System.out.println(totalRow);// 4
		System.out.println(sheet.getLastRowNum());// 3
		int totalColumns = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(totalColumns);// 3
		// Print all cell values
		for (int i = 0; i < totalRow; i++) {

			for (int j = 0; j < totalColumns; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + ",");

			}
		}

	}

	@Test
	public void setupExcelWriting() throws IOException {
		System.out.println("Starting excel file writing data...");
		File file = new File("C:\\Users\\Asus\\Pictures\\testExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("SecondDataSheetW");

		//Row row = sheet.createRow(6);
		// Cell cell = row.createCell(6);

		sheet.createRow(0).createCell(0).setCellValue("Username");
		sheet.createRow(0).createCell(1).setCellValue("Password");
		sheet.createRow(0).createCell(2).setCellValue("Correct");

		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close();

		System.out.println("End of writing data in excel...");

	}

	@Test(dataProvider = "getData")
	public void testData(String uname, String pass, String correct) {
		System.out.println(uname + " and " + pass + " and " + correct);
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		Object[][] data = new Object[3][3];

		return data;

	}

}
