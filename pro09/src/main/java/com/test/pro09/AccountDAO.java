package com.test.pro09;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	@Autowired
	SqlSession session;
	
	public List<AccountDTO> selectAllBalance() {
		// TODO Auto-generated method stub
		return session.selectList
				("mapper.account.selectAllBalance");
	}

	public void updateBalance1() {
		// TODO Auto-generated method stub
		// DAO 메서드가 실행 될때마다 commit 완료
		session.update("mapper.account.updateBalance1");
	}
	public void updateBalance2() {
		// TODO Auto-generated method stub
		// DAO 메서드가 실행 될때마다 commit 완료
		session.update("mapper.account.updateBalance2");
	}

	public void updateBalance(int balance) {
		// TODO Auto-generated method stub
		session.update("mapper.account.updateBalance",
				balance);
	}
	
	public void  deposit(AccountDTO dto) {
		session.update("mapper.account.deposit", dto);
	}
}



