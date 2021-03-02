package com.htc.ReadExcelFile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	Workbook loginWorkbook=null;
	Sheet logindata=null;
	public ReadData(String excelfilePath) {
		try {
		File s = new File(excelfilePath);
		FileInputStream stream = new FileInputStream(s);
		loginWorkbook = new XSSFWorkbook(stream);
		System.out.println("excelFilepath"+excelfilePath);
		System.out.println("loginWorkbook"+loginWorkbook.getNumberOfSheets());
		}
		catch(Exception e) {
		System.out.println(e.getMessage());
		}
		}
	public String getData(int sheetnumber, int row, int column){
		logindata = loginWorkbook.getSheetAt(sheetnumber);
		String data = logindata.getRow(row).getCell(column).getStringCellValue();
		return data;
		} 
		public int getRowCount(int sheetIndex){
		int row = loginWorkbook.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
		}
}
