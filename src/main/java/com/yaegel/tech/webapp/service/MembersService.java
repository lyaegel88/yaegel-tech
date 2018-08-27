package com.yaegel.tech.webapp.service;

import java.util.List;
import com.yaegel.tech.webapp.domain.Members;

public interface MembersService {

	List<Members> getAllMembers();
	
	Members getMemberById(String memberID);
	
}
