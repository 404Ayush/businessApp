package rg.businessManagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import rg.businessManagement.domain.BankStatementEntry;

@Repository
public class BankStatementRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private String SQL_INSERT_BANK_ENTRIES = "INSERT INTO BANK_ENTRIES("
			+ "txn_date, description, ref_no, debit_amt, credit_amt, balance, approved_status) "
			+ "VALUES (:txn_date, :description, :ref_no, :debit_amt, :credit_amt, :balance, FALSE)";
	
public void saveBankEntries(List<BankStatementEntry> entries) {
		
		List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();
		
		for(BankStatementEntry entry : entries) {
			
			if(null != entry.getTxnDate()) {
				
				MapSqlParameterSource parameterSource = new MapSqlParameterSource();
				parameterSource
				.addValue("txn_date", entry.getTxnDate())
				.addValue("description", entry.getDesc())
				.addValue("ref_no", entry.getRefNo())
				.addValue("debit_amt", entry.getDebitAmt())
				.addValue("credit_amt", entry.getCreditAmt())
				.addValue("balance", entry.getBalance());
				
				params.add(parameterSource);
			}
		}
		
		jdbcTemplate.batchUpdate(SQL_INSERT_BANK_ENTRIES, params.toArray(MapSqlParameterSource[]::new));
	}
}
