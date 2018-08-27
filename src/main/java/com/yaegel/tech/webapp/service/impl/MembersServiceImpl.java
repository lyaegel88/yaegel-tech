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
	public List<Members> getAllMembers() {
		return membersRepository.getAllMembers();
	}

	@Override
	public Members getMemberById(String memberID) {
		// TODO Auto-generated method stub
		return membersRepository.getMemberById(memberID);
	}
	
	
}
