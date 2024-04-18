package com.estsoft.blogjpa.domain;

import java.util.ArrayList;
import java.util.List;

import com.estsoft.blogjpa.tdd.Icoupon;

public class User1 {
	private List<Icoupon> icouponList;
	public User1(String id,String pw){
		icouponList=new ArrayList<>();
	}
	public int getTotalCouponCount() {
		return icouponList.size();
	}
	public void addCoupon(Icoupon icoupon){
		if(icoupon.isValid()){
			icouponList.add(icoupon);
		}
	}

}
