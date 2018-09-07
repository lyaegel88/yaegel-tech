package com.yaegel.tech.webapp.service;

import java.util.List;
import com.yaegel.tech.webapp.domain.Members;

public interface MembersService {

	List<Members> getAllMembers(int start, int stop);
	
	int getMemberCount();
	
	Members getMemberById(String memberID);
	
	void addMember(Members member);
	
	void deleteMember(String memberID);
	
}
