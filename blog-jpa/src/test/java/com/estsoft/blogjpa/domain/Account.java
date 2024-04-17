package com.estsoft.blogjpa.domain;

public class Account {
	private int money;

	public Account(int i) {
		money=i;
	}


	public int getMoney(){
		return this.money;
	}
	public void deposit(int money){
		this.money+=money;
	}
	public void withdraw(int money){
		this.money-=money;
	}
}
