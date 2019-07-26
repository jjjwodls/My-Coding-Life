package StringTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class poiTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		
		cell.setCellValue("테스트 데이터 내림");
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/fileTest");
			workbook.write(fos);
			workbook.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
