package rg.businessManagement.controller;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rg.businessManagement.util.ExcelHelper;
import rg.businessManagement.domain.BankStatementEntry;
import rg.businessManagement.repository.BankStatementRepository;

@RestController
public class BankStatementController {
	
	private static final Logger logger = LoggerFactory.getLogger(BankStatementController.class);
	
	@Autowired
	BankStatementRepository bankStatementRepository;
	
	@PostMapping(value = "/uploadBankStatement")
	public ResponseEntity<List<BankStatementEntry>> uploadBankStatement(@RequestParam("file") MultipartFile file){
		
		List<BankStatementEntry> entries = new ArrayList<>();
		
		logger.info("Excel conversion started at: {}", ZonedDateTime.now().toString());
		
		if (true) {
			try {
				entries = ExcelHelper.convertExcelToListOfEntries(file.getInputStream());
				bankStatementRepository.saveBankEntries(entries);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		logger.info(entries.toString());
		logger.info("Excel conversion ended at: {}", ZonedDateTime.now().toString());
		
		return ResponseEntity.ok(entries);
		//try catch?
	}
}
