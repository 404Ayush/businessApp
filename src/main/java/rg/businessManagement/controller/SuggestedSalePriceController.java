package rg.businessManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rg.businessManagement.service.SuggestedSalePriceService;

@RestController
public class SuggestedSalePriceController {

	@Autowired
	SuggestedSalePriceService suggestedSalePriceService;
	
	@GetMapping(value = "/fetchSuggestedSalePrice")
	@CrossOrigin("*")
	public ResponseEntity<List<Double>> fetchEntityList(){
		List<Double> response = suggestedSalePriceService.calculateSuggestedSalePrice();
		return ResponseEntity.ok(response);
	}
}
