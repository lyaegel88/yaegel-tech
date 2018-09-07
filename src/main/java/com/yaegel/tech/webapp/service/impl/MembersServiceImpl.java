package com.yaegel.tech.webapp.service.impl;

import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.domain.repository.MembersRepository;
import com.yaegel.tech.webapp.service.MembersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl implements MembersService{

	@Autowired
	private MembersRepository membersRepository;

	@Override
	public List<Members> getAllMembers(int start, int stop) {
		return membersRepository.getAllMembers(start, stop);
	}

	@Override
	public Members getMemberById(String memberID) {
		return membersRepository.getMemberById(memberID);
	}

	@Override
	public void addMember(Members member) {
		membersRepository.addMember(member);
		
	}

	@Override
	public void deleteMember(String memberID) {
		membersRepository.deleteMember(memberID);
		
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return membersRepository.getMemberCount();
	}
	
	
}