package rg.businessManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

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
		StopWatch timer = new StopWatch();
		timer.start();
		List<EntityDetail> entityList = purchaseInvoiceRepository.fetchEntityList();
		timer.stop();
		System.out.println(timer.getTotalTimeMillis());
		return entityList;
	}

}
