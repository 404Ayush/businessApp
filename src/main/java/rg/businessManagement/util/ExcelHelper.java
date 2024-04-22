package rg.businessManagement.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import rg.businessManagement.domain.BankStatementEntry;


public class ExcelHelper {
	
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<BankStatementEntry> convertExcelToListOfEntries(InputStream is) {
		List<BankStatementEntry> list = new ArrayList<>();

		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowNumber = 19;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				
				Row row = iterator.next();
				
				if (row.getRowNum() < rowNumber) {
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();

				BankStatementEntry entry = new BankStatementEntry();

				while (cells.hasNext()) {
					Cell cell = cells.next();
					
					switch (cell.getColumnIndex()) {
					case 0:
						if(cell.getCellType().equals(CellType.NUMERIC)) {
							entry.setTxnDate(cell.getDateCellValue());
						}
						break;
					case 2:
						if(cell.getCellType().equals(CellType.STRING)) {
							entry.setDesc(cell.getStringCellValue());
						}
						break;
					case 3:
						if(cell.getCellType().equals(CellType.STRING)) {
							entry.setRefNo(cell.getStringCellValue());
						}
						break;
					case 5:
						if(cell.getCellType().equals(CellType.NUMERIC)) {
							entry.setDebitAmt(cell.getNumericCellValue());
						}
						break;
					case 6:
						if(cell.getCellType().equals(CellType.NUMERIC)) {
							entry.setCreditAmt(cell.getNumericCellValue());
						}
						break;
					case 7:
						if(cell.getCellType().equals(CellType.STRING)) {
							entry.setBalance(Double.valueOf(cell.getStringCellValue().replaceAll(",", "")));
						}
						break;
					default:
						break;
					}
				}
				
				list.add(entry);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
