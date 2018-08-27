package com.yaegel.tech.webapp.domain.repository;

import java.util.List;
import com.yaegel.tech.webapp.domain.Members;

public interface MembersRepository {
	
	List <Members> getAllMembers();
	
	Members getMemberById(String memberID);
	
	void addMember(Members member);
	
	void deleteMember(String memberID);

}
