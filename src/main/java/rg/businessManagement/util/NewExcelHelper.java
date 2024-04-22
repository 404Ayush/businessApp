package rg.businessManagement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import rg.businessManagement.domain.BankStatementEntry;

public class NewExcelHelper {

	

	public static List<BankStatementEntry> convertExcelToListOfEntries(InputStream inputStream) {

		List<BankStatementEntry> entries = new ArrayList<>();

		try {
			Workbook workbook = Workbook.getWorkbook(inputStream);
			
			Sheet sheet = workbook.getSheet(0);
			
			int rows = sheet.getRows();
	        int columns = sheet.getColumns();
	        
			for (int i = 20; i < rows; i++) {
				BankStatementEntry entry = new BankStatementEntry();
				for (int j = 0; j < columns; j++) {
					switch (j) {
					case 1:
						//entry.setTxnDate(sheet.getCell(rows, columns).getContents());
						break;
					case 3:
						entry.setDesc(sheet.getCell(rows, columns).getContents());
						break;
					case 4:
						entry.setRefNo(sheet.getCell(rows, columns).getContents());
						break;
					case 6:
						entry.setDebitAmt(Double.valueOf(sheet.getCell(rows, columns).getContents()));
						break;
					case 7:
						entry.setCreditAmt(Double.valueOf(sheet.getCell(rows, columns).getContents()));
						break;
					case 8:
						entry.setBalance(Double.valueOf(sheet.getCell(rows, columns).getContents()));
						break;
					default:
						break;
					}

				}
				entries.add(entry);
			}

		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entries;
	}
}
