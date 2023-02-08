package com.itwill.shop.delivery.test;

import com.itwill.shop.delivery.Delivery;
import com.itwill.shop.delivery.DeliveryService;

public class DeliveryServiceTestMain {
	
	public static void main(String[] args) throws Exception {
		DeliveryService deliveryService = new DeliveryService();
		
		//배송정보입력
		System.out.println(deliveryService.insertDelivery("서울", "010-000", "홍길동", "cream1"));
		
		
		//배송정보가져오기
		System.out.println(deliveryService.selectDelivery("cream2"));
		
		//배송정보삭제
		System.out.println(deliveryService.deleteDelivery("cream1")+"개의 배송정보 삭제");
		
		//배송정보 1개 가져오기
		System.out.println(deliveryService.select("cream2_office"));
		
	}

}
