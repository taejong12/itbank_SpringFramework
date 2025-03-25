package com.test.pro09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
// 클래스 모든 메서드 적용
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	@Autowired
	AccountDAO dao;
	// 트랜잭션을 사용하기 위해서 객체 가져오기
//	@Autowired
//	private TransactionTemplate transactionTemplate;
//	
	public List<AccountDTO> selectAllBalance() {
		// TODO Auto-generated method stub
		return dao.selectAllBalance();
	}
//
//	public void sendMoney() {
//		// TODO Auto-generated method stub
//		// dao.updateBalance1();//commit
//		// dao.updateBalance2();//commit
//		
//		// 트랜잭션을 사용하기 위해 transactionTemplate 사용
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				// TODO Auto-generated method stub
//				dao.updateBalance1();
//				dao.updateBalance2();
//			}
//			
//		});
//		
//	}
//
//	public void deposit(final AccountDTO dto) {
//		// TODO Auto-generated method stub
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//			
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				// TODO Auto-generated method stub
//				dao.updateBalance(dto.getBalance());
//				dao.deposit(dto);
//			}
//		});
//	}	
	
	// 여기에 쓰면 메서드만 적용
	@Transactional(propagation=Propagation.REQUIRED)
	public void sendMoney2() {
		dao.updateBalance1();
		dao.updateBalance2();
	}
}