package com.estsoft.blogjpa.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.estsoft.blogjpa.domain.User1;

public class UserTest {

	@Test
	public void testAddCoupon(){
		User1 user = new User1("area00","pw");
		assertEquals(0,user.getTotalCouponCount());

		Icoupon coupon = Mockito.mock(Icoupon.class);
		BDDMockito.given(coupon.isValid()).willReturn(true);

		user.addCoupon(coupon);
		assertEquals(1,user.getTotalCouponCount());
	}

	@DisplayName("쿠폰 발급 실패(유효하지 않은 쿠폰일경우)")
	@Test
	public void testNoAddCoupon(){
		User1 user = new User1("area00","pw");
		Icoupon coupon = Mockito.mock(Icoupon.class);
		BDDMockito.given(coupon.isValid()).willReturn(false);

		user.addCoupon(coupon);
		assertEquals(0,user.getTotalCouponCount());
	}
}
