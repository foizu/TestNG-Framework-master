package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import base.TestBase;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT = 20;
	
	public String path = System.getProperty("user.dir")+"/src/main/java/data/TestData.xlsx";

	public FileInputStream fis = null;

	public FileOutputStream fos = null;

   //private XSSFWorkbook workbook = null;

	//private XSSFSheet worksheet = null;

	//private XSSFRow row = null;

	//private XSSFCell cell = null;
	
	public static Date newDate;
	
	public static SimpleDateFormat newFormat;
/*
	public TestUtil(String path) {

		this.path = path;

		try {

			fis = new FileInputStream(path);

			workbook = new XSSFWorkbook(fis);

			fis.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// Retrieve total number of rows
	public int getRowCount(String sheetName) {

		worksheet = workbook.getSheet(sheetName);
		
		workbook.getSheetIndex(sheetName);

		int rowCount = worksheet.getLastRowNum();

		return rowCount;

	}

	// Retrieve total number of columns
	public int getColumnCount(String sheetName) {

		worksheet = workbook.getSheet(sheetName);

		int columnCount = worksheet.getRow(0).getLastCellNum();

		return columnCount;

	}

	// Read from files and add test data to test case parameters individually
	public String getData(String sheetName, int rowNum, int colNum) {

		try {

			worksheet = workbook.getSheet(sheetName);

			row = worksheet.getRow(rowNum);

			cell = row.getCell(colNum);

			if (cell.getCellTypeEnum() == CellType.STRING) {

				return cell.getStringCellValue();

			}

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());

				if (HSSFDateUtil.isCellDateFormatted(cell)) {

					DateFormat dt = new SimpleDateFormat("dd/MM/yy");

					Date date = cell.getDateCellValue();

					cellValue = dt.format(date);

				}

				return cellValue;

			}

			else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			}

			else

				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			
			return "No matched cell value";

		}

	}

	// Write to files result whether PASS or FAIL individually
	public boolean setCellData(String sheetName, int rowNum, int colNum, String value) {

		try {

			worksheet = workbook.getSheet(sheetName);

			row = worksheet.getRow(rowNum);

			if (row == null)
				row = worksheet.createRow(rowNum);

			cell = row.getCell(colNum);

			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(value);

			fos = new FileOutputStream(path);

			workbook.write(fos);

			fos.close();

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

		return true;
	}

	// Read excel sheet and send test data to script dynamically
	public Object[][] testData(String filePath, String sheetName) throws Exception {

		Object[][] excelData = null;

		int numberOfRows = getRowCount(sheetName);

		int numberOfColumns = getColumnCount(sheetName);

		// Object[][] excelData = new Object[numberOfRows - 1][numberOfColumns];

		excelData = new Object[numberOfRows - 1][numberOfColumns];

		for (int i = 1; i < numberOfRows; i++) {

			for (int j = 0; j < numberOfColumns; j++) {

				excelData[i - 1][j] = getData(sheetName, i, j);

			}

		}

		return excelData;

	}
	*/
	
	//retrieve current date and time
	public static String retrieveDateTime(){
		
		newDate = new Date();
		
		newFormat = new SimpleDateFormat("YYYY:MM:DD hh:mm:ss");
		
		String date = newFormat.format(newDate);
		
		return date;
	}
	
	public void getDate(){
		
		System.out.println(retrieveDateTime());
	}
	
	//take regular screenshot
	public static void captureScreenshot(String imageName, String extension) throws IOException, InterruptedException{
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String destFile = System.getProperty("user.dir") + "/Screenshots/" + imageName + "-" + System.currentTimeMillis() + extension; // .jpeg, .png

		FileUtils.copyFile(srcFile, new File(destFile));

		Thread.sleep(2000);
	}
	
	//take regular screenshot - less is more
	public void takeScreenshotAtEndOfTest(String imageName) throws IOException, InterruptedException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir = "C:\\Users\\J\\workspace\\handyman\\Screenshots\\";
		
		FileUtils.copyFile(scrFile, new File(currentDir + imageName +  "_" + System.currentTimeMillis()  +  ".png"));
		
		Thread.sleep(2000);
		
		}
	
	//take full screenshot
	public void capturePage(String imageName) throws IOException, InterruptedException{
		
		Screenshot takeShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

		ImageIO.write(takeShot.getImage(), "PNG", new File("C:\\Users\\J\\workspace\\handyman\\Screenshots\\" + imageName + "_" + System.currentTimeMillis() + ".png"));
		
		Thread.sleep(2000);
		
	}
	
	//take webelement screenshot
	public void captureElement(String elementLocator, String imageName) throws IOException, InterruptedException{
		
		WebElement element = driver.findElement(By.className(elementLocator));
		
		Screenshot takeShot = new AShot().takeScreenshot(driver, element);
		
		ImageIO.write(takeShot.getImage(), "PNG", new File("C:\\Users\\J\\workspace\\handyman\\Screenshots\\" + imageName + "_" + System.currentTimeMillis()  + ".png"));
		
		Thread.sleep(2000);
	
	}
	
}
