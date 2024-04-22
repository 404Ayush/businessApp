package rg.businessManagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rg.businessManagement.domain.EntityDetail;
import rg.businessManagement.domain.PurchaseInvoice;
import rg.businessManagement.service.PurchaseInvoiceService;

@RestController
public class PurchaseInvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseInvoiceController.class);
	
	@Autowired
	PurchaseInvoiceService purchaseInvoiceService;
	
	@PostMapping(value = "/savePurchaseInvoice")
	public ResponseEntity<String> savePurchaseInvoice(@RequestBody PurchaseInvoice request){
		//validate something here?
		String response = purchaseInvoiceService.savePurchase(request);
		return ResponseEntity.ok(response);
		//try catch?
	}
	
	@GetMapping(value = "/fetchEntityList")
	public ResponseEntity<List<EntityDetail>> fetchEntityList(){
		List<EntityDetail> response = purchaseInvoiceService.fetchEntityList();
		return ResponseEntity.ok(response);
		
	}
}
