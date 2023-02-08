package com.itwill.shop.orders.test;

import com.itwill.shop.order.*;

public class OrderServiceTestMain {

	public static void main(String[] args) throws Exception {
		OrderService orderService = new OrderService();
		
		System.out.println("---------- 1. cart order(all) ------------");
		System.out.println(orderService.cartOrder("cream3"));
		
		System.out.println("---------- 2. cart order(select) ------------");
		String[] cart_item_array = {"1", "2"};
		System.out.println(orderService.cartSelectOrder("cream1", cart_item_array));
		
		System.out.println("---------  3. direct order -------------");
		System.out.println(orderService.directOrder("cream2", 1, 1));

		System.out.println("------------ 4. find by userId -----------");
		System.out.println(orderService.findByUserId("cream2"));
		
		System.out.println("------ 5. find with order item by userId -------");
		System.out.println(orderService.findWithOrderItemByUserId("cream2"));
		
		System.out.println("------ 6. find with order item by order no -------");
		System.out.println(orderService.findWithOrderItemByOrderNo(2));
		
		System.out.println("------ 7. delete by order no -------");
		System.out.println(orderService.deleteByOrderNo(1));
		
		System.out.println("------ 8. delete by userId -------");
		System.out.println(orderService.deleteByUserId("cream3"));
	}

}
