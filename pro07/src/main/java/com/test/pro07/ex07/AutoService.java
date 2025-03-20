package com.test.pro07.ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.pro07.ex03.MemberDTO;

@Service
public class AutoService {
	@Autowired
	AutoDAO dao;
	
	public MemberDTO selectMember() {
		return dao.selectMember();
	}
}