package com.estsoft.blogjpa.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.estsoft.blogjpa.domain.Account;

public class AccountTest {
	Account account;
	@BeforeEach
	void setUp(){
		account = new Account(10000);
	}
	@DisplayName("계좌 생성 테스트")
	@Test
	void 계좌_생성()throws Exception{
		Assertions.assertEquals(account.getMoney(),10000);
	}
	@DisplayName("송금 테스트")
	@Test
	void 계좌_입금()throws Exception{
		account.deposit(1000);
		Assertions.assertEquals(account.getMoney(),11000);
	}

	@DisplayName("출금 테스트")
	@Test
	void 계좌_출금()throws Exception{
		account.withdraw(1000);
		Assertions.assertEquals(account.getMoney(),9000);
	}


}
