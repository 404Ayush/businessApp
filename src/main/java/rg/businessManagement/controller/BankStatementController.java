package rg.businessManagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
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
		StopWatch timer = new StopWatch();
		
		if (ExcelHelper.checkExcelFormat(file)) {
			try {
				timer.start();
				entries = ExcelHelper.convertExcelToListOfEntries(file.getInputStream());
				timer.stop();
				logger.info("Time for completion of Excel conversion in ms: {}", timer.getTotalTimeMillis());
				
				timer = new StopWatch();
				timer.start();
				bankStatementRepository.saveBankEntries(entries);
				timer.stop();
				logger.info("Time for completion of Insertion in DB in ms: {}", timer.getTotalTimeMillis());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok(entries);
	}
}
