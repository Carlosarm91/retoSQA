package com.carlos.retoSQA.Utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Leer_Excel {
	static String Excel[];
	static 	Workbook wb;
	
	public static String[] leerExcel() {
		Excel = new String[7];
		String rutaInternaArchivo = "\\src\\test\\resources\\data\\data.xlsx";
		String rutaLocalProyecto = System.getProperty("user.dir");
		String rutaCompleta = rutaLocalProyecto + rutaInternaArchivo;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(rutaCompleta));
			for(int i=0;i<7;i++) {
				XSSFSheet sheet = wb.getSheetAt(0);
				XSSFRow row = sheet.getRow(1);
				XSSFCell cell = row.getCell(i);
				Excel[i] = cell.getStringCellValue();
			}
			wb.close();
		} catch (IOException e) {e.printStackTrace();}
		return Excel;
	}
}
