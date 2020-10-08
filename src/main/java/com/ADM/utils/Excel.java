package com.ADM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	static File in;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static Row row;
	static Cell cell;
	static String[][] data;
	static DataFormatter formatter;
	static XSSFWorkbook wbwrite;
	static XSSFSheet sheet1;
	static FileOutputStream fos;

	public static boolean checkFile(String path, String name) {
		File in = new File(path);
		String[] list = in.list();
		for (String string : list) {
			if (string.equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static String[][] readExcel(String path, int index) {
		in = new File(path);
		try {
			fis = new FileInputStream(in);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(index);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			System.out.println(rowCount + "\t" + colCount);
			data = new String[rowCount][colCount];

			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					data[i][j] = getValue(i, j);
				}
			}

			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String getValue(int row, int col) {
		formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(row).getCell(col));
		return data;
	}

	public static void excelWrite(String dest, String[][] values) throws IOException {
		in = new File(dest);
			fis = new FileInputStream(in);
				wbwrite = new XSSFWorkbook(fis);
			fos = new FileOutputStream(in);
			sheet1 = wbwrite.getSheetAt(0);
			setValue(dest,values);
	}

	public static void setValue(String dest, String[][] values) throws IOException {
		for (int i = 0; i < values.length; i++) {
			row = sheet1.createRow(i);
			for (int j = 0; j < values[i].length; j++) {

				sheet1.getRow(i).createCell(j).setCellValue(values[i][j]);

				System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}
			wbwrite.write(fos);
			fos.close();
	}

}
