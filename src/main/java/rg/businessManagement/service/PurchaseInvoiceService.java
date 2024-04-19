package rg.businessManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rg.businessManagement.domain.EntityDetail;
import rg.businessManagement.domain.PurchaseInvoice;
import rg.businessManagement.repository.PurchaseInvoiceRepository;

@Service
public class PurchaseInvoiceService {
	
	@Autowired
	PurchaseInvoiceRepository purchaseInvoiceRepository;

	public String savePurchase(PurchaseInvoice request) {
		purchaseInvoiceRepository.savePurchaseDetails(request.getItemList());
		purchaseInvoiceRepository.savePurchaseHeader(request);
		return new String("Purchase Invoice Saved. Please check the same.");
	}

	public List<EntityDetail> fetchEntityList() {
		List<EntityDetail> entityList = purchaseInvoiceRepository.fetchEntityList();
		return entityList;
	}

}
