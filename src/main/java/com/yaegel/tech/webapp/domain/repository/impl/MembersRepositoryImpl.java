package com.yaegel.tech.webapp.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.domain.repository.MembersRepository;
import com.yaegel.tech.webapp.exception.SpringException;

@Repository
public class MembersRepositoryImpl implements MembersRepository{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Members> getAllMembers(int start, int stop) {
		String SQL = "SELECT * FROM customer LIMIT :start, :stop";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("stop", stop);
		List<Members> result = jdbcTemplate.query(SQL, params, new MembersMapper());
		
		return result;
	}
	
	@Override
	public int getMemberCount() {
		String SQL = "SELECT COUNT(*) from customer";
		Map<String, Object> params = new HashMap<String, Object>();
		Integer result = jdbcTemplate.queryForObject(SQL, params, Integer.class);
		
		return result;
	}
	
	@Override
	public Members getMemberById(String memberID) {
		String SQL = "SELECT * FROM customer WHERE CustomerID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", memberID);
		
		return jdbcTemplate.queryForObject(SQL, params, new MembersMapper());
	}
	
	@Override
	public void deleteMember(String memberID) {
		String SQL = "DELETE FROM customer WHERE CustomerID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", memberID);
		
		jdbcTemplate.update(SQL, params);
	}
	
	@Override
	public void addMember(Members member) {
		String SQL = "INSERT INTO customer (CustomerID, "
				+ "CustomerFN,"
				+ "CustomerLN,"
				+ "CustomerAddress1,"
				+ "CustomerAddress2,"
				+ "CustomerCity,"
				+ "CustomerState,"
				+ "CustomerZip,"
				+ "CustomerPhone,"
				+ "CustomerImageUrl,"
				+ "CustomerPassword,"
				+ "CustomerRole)"
				+ "VALUES (:id, :firstName, :lastName, :address1, :address2, :city, :state, :zip, :phone, :url, :password, :role)";
		Map<String, Object> params = new HashMap<>();
		params.put("id", member.getCustomerId());
		params.put("firstName", member.getCustomerFn());
		params.put("lastName", member.getCustomerLn());
		params.put("address1", member.getCustomerAddress1());
		params.put("address2", member.getCustomerAddress2());
		params.put("city", member.getCustomerCity());
		params.put("state", member.getCustomerState());
		params.put("zip", member.getCustomerZip());
		params.put("phone", member.getCustomerPhone());
		params.put("url", member.getCustomerImageUrl());
		params.put("password", member.getCustomerPassword());
		params.put("role", member.getCustomerRole());
		
		try {
			jdbcTemplate.update(SQL, params);
			
		}catch (DataAccessException dae) {
			
			throw new SpringException(dae.getRootCause().toString());
		}
			
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
			member.setCustomerImageUrl(rs.getString("CustomerImageUrl"));
			
			return member;
		}

	}

	@Override
	public List<Members> getMemberExists(String memberID) {
		String SQL = "SELECT * FROM customer WHERE CustomerID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", memberID);
		List<Members> result = jdbcTemplate.query(SQL, params, new MembersMapper());
		
		return result;
	}

	@Override
	public List<Members> getEveryMember() {
		String SQL = "SELECT * FROM customer";
		List<Members> result = jdbcTemplate.query(SQL, new MembersMapper());
		
		return result;
	}


	
	
	
}
