package config;

import io.qameta.allure.model.Status;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utility.Report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelReader {
	
	public static Sheet readRunConfig() {
		try {
			return ReadExcel(System.getProperty("user.dir")+"/RunManager.xlsm", "RunConfig");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to read RunManager sheet");
			return null;
		}
	}
	
	
	public static Sheet readRunManager() {
		try {
			return ReadExcel(System.getProperty("user.dir")+"/RunManager.xlsm", "TestCases");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to read RunManager sheet");
			return null;
		}
	}
	
	public static Sheet readTestData(String SheetName) {
		try {
			return ReadExcel(System.getProperty("user.dir")+"/TestData.xlsx", SheetName);
		}catch(Exception e) {
			e.printStackTrace();
			Report.log(Status.FAILED, "Unable to Read "+SheetName+" sheet");
			return null;
		}
	}
	
	public static Sheet readDeviceInfo() {
		try {
			return ReadExcel(System.getProperty("user.dir")+"/TestData.xlsx", "DeviceInfo");
		}catch(Exception e) {
			System.out.println("Unable to read DeviceInfo sheet");
			return null;
		}
	}
	
	public static Sheet readBulkUploadFile() {
		try {
			return ReadExcel(System.getProperty("user.dir")+"/src/main/resources/exceldata/BulkUpload_import_devices.xlsx", "Sheet1");
		}catch(Exception e) {
			System.out.println("Unable to read Bulk Upload File sheet");
			return null;
		}
	}
	
	public static void updateTemperature(int row, int col, String Val) {
		try {
			updateExcel(System.getProperty("user.dir")+"/TestData.xlsx", "DeviceAndSensorData", row, col, Val);
			Report.log(Status.PASSED, "Temperature Recorded");
		}catch(Exception e) {
			Report.log(Status.FAILED, "Unable to update Temperature from Lynx");
		}
	}
	
	public static int searchDeviceAndSensorData(int col, String Val) {
		try {
			return searchExcel(System.getProperty("user.dir")+"/TestData.xlsx", "DeviceAndSensorData",col, Val);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static String readIMEI() throws Exception {
		try {
			Sheet sheet  = ReadExcel(System.getProperty("user.dir")+"/TestData.xlsx", "DeviceAndSensorData");
			return sheet.getRow(1).getCell(4).getStringCellValue();
		}catch(Exception e) {
			Report.log(Status.FAILED, "Unable to read IMEI number form test data sheet");
			Report.logScreenshot(e.getMessage());
			return null;
		}
	}
	
	public static Sheet ReadExcel(String filepath, String sheetName) throws Exception {
		File excelFile =    new File(filepath);
		try {
				FileInputStream inputStream = new FileInputStream(excelFile);
				Workbook excelworkbook = null;
				String fileExtensionName = filepath.substring(filepath.indexOf("."));
				if(fileExtensionName.equals(".xlsx") || fileExtensionName.equals(".xlsm")){
					excelworkbook = new XSSFWorkbook(inputStream);
				}else if(fileExtensionName.equals(".xls")){
					excelworkbook = new HSSFWorkbook(inputStream);
				}
				Sheet sheet = excelworkbook.getSheet(sheetName);
				return sheet;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
		}
	
	public static void updateExcel(String filepath, String sheetName, int RowNo, int ColNo, String Value) throws Exception {
		File excelFile =    new File(filepath);
		try {
				FileInputStream inputStream = new FileInputStream(excelFile);
				Workbook excelworkbook = null;
				String fileExtensionName = filepath.substring(filepath.indexOf("."));
				if(fileExtensionName.equals(".xlsx")){
					excelworkbook = new XSSFWorkbook(inputStream);
				}else if(fileExtensionName.equals(".xls")){
					excelworkbook = new HSSFWorkbook(inputStream);
				}
				Sheet sheet = excelworkbook.getSheet(sheetName);
				try {
				sheet.getRow(RowNo).getCell(ColNo).setCellValue(Value);
				}catch(Exception e) {
					System.out.println("Creating new cell");
					sheet.getRow(RowNo).createCell(ColNo).setCellValue(Value);
				}
				
	            inputStream.close();
	            FileOutputStream outputStream = new FileOutputStream(excelFile);
	            excelworkbook.write(outputStream);
	            outputStream.close();
				 
			} catch (Exception e) {
				System.out.println("Unable to update Test Data file Please close the file, if open"+e.getMessage());
				Report.log(Status.FAILED, "Unable to update Test Data file Please close the file, if open");
				e.printStackTrace();
			}
		}
	
	public static void updateExcelRow(String filepath, String sheetName, int RowNo, List<String> Value) throws Exception {
		File excelFile =  new File(filepath);
		try {
				FileInputStream inputStream = new FileInputStream(excelFile);
				Workbook excelworkbook = null;
				String fileExtensionName = filepath.substring(filepath.indexOf("."));
				if(fileExtensionName.equals(".xlsx")){
					excelworkbook = new XSSFWorkbook(inputStream);
				}else if(fileExtensionName.equals(".xls")){
					excelworkbook = new HSSFWorkbook(inputStream);
				}
				Sheet sheet = excelworkbook.getSheet(sheetName);
				
				for(int i =0; i<Value.size(); i++) {
					try {
		//test
						if(i==1) {
							long imei = Long.parseLong(Value.get(i));
							sheet.getRow(RowNo).getCell(i).setCellValue(imei);
						}else {
							if(!Value.get(i).equals("")) {
								sheet.getRow(RowNo).getCell(i).setCellValue(Value.get(i));
							}
						}
						
						}catch(Exception e) {
							System.out.println("Creating new cell");
							sheet.getRow(RowNo).createCell(i).setCellValue(Value.get(i).toString());
						}
				}
				
	            inputStream.close();
	            FileOutputStream outputStream = new FileOutputStream(excelFile);
	            excelworkbook.write(outputStream);
	            outputStream.close();
				 
			} catch (Exception e) {
				System.out.println("Unable to update Test Data file Please close the file, if open"+e.getMessage());
				Report.log(Status.FAILED, "Unable to update Test Data file Please close the file, if open");
				e.printStackTrace();
			}
		}
	
	
	public static int searchExcel(String filepath, String sheetName, int col, String Value) throws Exception {
		File excelFile =    new File(filepath);
		try {
			FileInputStream inputStream = new FileInputStream(excelFile);
			Workbook excelworkbook = null;
			String fileExtensionName = filepath.substring(filepath.indexOf("."));
			if(fileExtensionName.equals(".xlsx")){
				excelworkbook = new XSSFWorkbook(inputStream);
			}else if(fileExtensionName.equals(".xls")){
				excelworkbook = new HSSFWorkbook(inputStream);
			}
			Sheet sheet = excelworkbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            for(int i =1; i<=rowCount; i++) {
            	System.out.println(sheet.getRow(i).getCell(col));
            	System.out.println(Value);
            	if(sheet.getRow(i).getCell(col).toString().equals(Value)) {
            		return i;
            	}
            }
            Report.log(Status.FAILED, "Unable to find keyword in the file");
            return 0;
		} catch (Exception e) {
				Report.log(Status.FAILED, "Unable to find keyword in the file");
				e.printStackTrace();
				return 0;
			}
		}
	
	
	public static int searchExcel(Sheet sheet, int col, String Value) throws Exception {
		try {
            int rowCount = sheet.getLastRowNum();
            for(int i =1; i<=rowCount; i++) {
            	System.out.println(sheet.getRow(i).getCell(col));
            	System.out.println(Value);
            	if(sheet.getRow(i).getCell(col).toString().equals(Value)) {
            		return i;
            	}
            }
            Report.log(Status.FAILED, "Unable to find keyword in the file");
            return 0;
		} catch (Exception e) {
				Report.log(Status.FAILED, "Unable to find keyword in the file");
				e.printStackTrace();
				return 0;
			}
		}
	
	
	public static int searchExcelColumnHeader(Sheet sheet, int row, String Value) throws Exception {
		try {
            int noOfColumns = sheet.getRow(row).getLastCellNum();
            for(int i =1; i<=noOfColumns; i++) {
            	if(sheet.getRow(row).getCell(i).toString().equals(Value)) {
            		return i;
            	}
            }
            Report.log(Status.FAILED, "Unable to find keyword in the file");
            return 0;
		} catch (Exception e) {
				Report.log(Status.FAILED, "Unable to find keyword in the file");
				e.printStackTrace();
				return 0;
			}
		}
	
	public static List<String> getColumnasList(Sheet sheet, String ColName){
		List<String> colvalues = new ArrayList<String>();
		Row headerRow = sheet.getRow(0);
		for(int i = 0; i<headerRow.getLastCellNum(); i++) {
			try {
				if(headerRow.getCell(i).toString().trim().equalsIgnoreCase(ColName.trim())) {
					try {
						int j=1;
						while(true) {
							String value = sheet.getRow(j).getCell(i).toString();
							if(value.equals("")) {
								System.out.println("End of List");
								break;
							}
							colvalues.add(value.trim());
							j++;
						}
					}catch(Exception e) {
						System.out.println("End of List");
					}
					break;
				}else {
				}
			}catch(Exception e) {
			
			}
			
		}
		return colvalues; 
	}

	
	public static void createColUsingList(String filepath, String sheetName, int ColNo, List<String> colvalues) throws Exception {
		File excelFile =    new File(filepath);
		try {
				FileInputStream inputStream = new FileInputStream(excelFile);
				Workbook excelworkbook = null;
				String fileExtensionName = filepath.substring(filepath.indexOf("."));
				if(fileExtensionName.equals(".xlsx")){
					excelworkbook = new XSSFWorkbook(inputStream);
				}else if(fileExtensionName.equals(".xls")){
					excelworkbook = new HSSFWorkbook(inputStream);
				}
				Sheet sheet = excelworkbook.getSheet(sheetName);
				int i = 0;
				for(String value : colvalues) {
					try {
						sheet.getRow(i).getCell(ColNo).setCellValue(value);
						}catch(Exception e) {
							try {

								System.out.println("Creating new cell");
								sheet.getRow(i).createCell(ColNo).setCellValue(value);
							}catch(Exception e1) {
								sheet.createRow(i).createCell(ColNo).setCellValue(value);
							}
						}
					i++;
				}
				
				
	            inputStream.close();
	            FileOutputStream outputStream = new FileOutputStream(excelFile);
	            excelworkbook.write(outputStream);
	            outputStream.close();
				 
			} catch (Exception e) {
				System.out.println("Unable to update Test Data file Please close the file, if open"+e.getMessage());
				Report.log(Status.FAILED, "Unable to update Test Data file Please close the file, if open");
				e.printStackTrace();
			}
		}

}
