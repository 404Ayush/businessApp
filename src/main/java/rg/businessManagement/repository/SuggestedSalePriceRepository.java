package rg.businessManagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SuggestedSalePriceRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private String SQL_SELECT_PURCHASE_PRICE_FROM_STOCK = "SELECT DISTINCT PURCHASE_PRICE FROM STOCK";
	
	public List<Double> getPurchasePrice() {
		List<Double> purchasePriceList = new ArrayList<>();
		jdbcTemplate.query(SQL_SELECT_PURCHASE_PRICE_FROM_STOCK, rs -> {
			purchasePriceList.add(rs.getDouble("PURCHASE_PRICE"));
		});
		return purchasePriceList;
	}

}
