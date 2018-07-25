package com.yaegel.tech.webapp.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.domain.repository.MembersRepository;

@Repository
public class MembersRepositoryImpl implements MembersRepository{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Members> getAllMembers() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Members> result = jdbcTemplate.query("SELECT * FROM customer", params, new MembersMapper());
		
		return result;
	}
	
	private static final class MembersMapper implements RowMapper<Members> {
		public Members mapRow(ResultSet rs, int rowNum)
		throws SQLException {
			Members member = new Members();
			member.setCustomerId(Integer.toString(rs.getInt("CustomerID")));
			member.setCustomerFn(rs.getString("CustomerFN"));
			member.setCustomerLn(rs.getString("CustomerLN"));
			member.setCustomerAddress1(rs.getString("CustomerAddress1"));
			member.setCustomerAddress2(rs.getString("CustomerAddress2"));
			member.setCustomerCity(rs.getString("CustomerCity"));
			member.setCustomerState(rs.getString("CustomerState"));
			member.setCustomerZip(rs.getString("CustomerZip"));
			member.setCustomerPhone(rs.getString("CustomerPhone"));
			
			return member;
		}

	}
	
	
}
