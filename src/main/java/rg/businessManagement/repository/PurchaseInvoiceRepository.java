package rg.businessManagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import rg.businessManagement.domain.EntityDetail;
import rg.businessManagement.domain.ItemDetail;
import rg.businessManagement.domain.PurchaseInvoice;

@Repository
public class PurchaseInvoiceRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private String SQL_INSERT_PURCHASE_HEADER = "INSERT INTO PURCHASE_HEADER("
			+ "ENTITY_NAME, INVOICE_NO, TOTAL_AMOUNT, GST_NUMBER, INVOICE_DATE, PAID_STATUS) "
			+ "VALUES (:ENTITY_NAME, :INVOICE_NO, :TOTAL_AMOUNT, :GST_NUMBER, :INVOICE_DATE::date, FALSE)";
	
	private String SQL_INSERT_PURCHASE_DETAILS = "INSERT INTO PURCHASE_DETAILS("
			+ "ITEM_NAME, QUANTITY, RATE, DISCOUNT_L1, DISCOUNT_L2, GST_RATE, HSN, INVOICE_NO) "
			+ "VALUES (:ITEM_NAME, :QUANTITY, :RATE, :DISCOUNT_L1, :DISCOUNT_L2, :GST_RATE, :HSN, :INVOICE_NO)";
	
	private String SQL_SELECT_ENTITY_DETAILS = "SELECT DISTINCT ENTITY_NAME, GST_NUMBER FROM PURCHASE_HEADER";
	
	public void savePurchaseHeader(PurchaseInvoice request) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource
		.addValue("ENTITY_NAME", request.getEntityName())
		.addValue("INVOICE_NO", request.getInvoiceNo())
		.addValue("TOTAL_AMOUNT", request.getTotalAmt())
		.addValue("INVOICE_DATE", request.getInvoiceDate())
		.addValue("GST_NUMBER", request.getGstNo());
		
		jdbcTemplate.update(SQL_INSERT_PURCHASE_HEADER, parameterSource);
	}
	
	public void savePurchaseDetails(List<ItemDetail> items, String invoiceNo) {
		
		List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();
		
		for(ItemDetail item : items) {
			
			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource
			.addValue("ITEM_NAME", item.getItemName())
			.addValue("QUANTITY", item.getQty())
			.addValue("RATE", item.getRate())
			.addValue("DISCOUNT_L1", item.getDiscountL1())
			.addValue("DISCOUNT_L2", item.getDiscountL2())
			.addValue("GST_RATE", item.getGstRate())
			.addValue("HSN", item.getHsn())
			.addValue("INVOICE_NO", invoiceNo);
			
			params.add(parameterSource);
		}
		
		jdbcTemplate.batchUpdate(SQL_INSERT_PURCHASE_DETAILS, params.toArray(MapSqlParameterSource[]::new));
	}

	public List<EntityDetail> fetchEntityList() {
		
		List<EntityDetail> entityList = new ArrayList<>();
		
		jdbcTemplate.query(SQL_SELECT_ENTITY_DETAILS, rs -> {
			
			EntityDetail entityDetail = new EntityDetail();
			entityDetail.setEntityName(rs.getString("ENTITY_NAME"));
			entityDetail.setGstNumber(rs.getString("GST_NUMBER"));
			entityList.add(entityDetail);
		});
		
		return entityList;
	}
}
