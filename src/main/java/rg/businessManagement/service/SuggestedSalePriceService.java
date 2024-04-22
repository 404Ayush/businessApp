package rg.businessManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rg.businessManagement.repository.SuggestedSalePriceRepository;

@Service
public class SuggestedSalePriceService {
	
	@Autowired
	SuggestedSalePriceRepository suggestedSalePriceRepository;
	
	public List<Double> calculateSuggestedSalePrice() {
		List<Double> purchasePriceList = suggestedSalePriceRepository.getPurchasePrice();
		System.out.println(purchasePriceList);
		return purchasePriceList;
	}
}
