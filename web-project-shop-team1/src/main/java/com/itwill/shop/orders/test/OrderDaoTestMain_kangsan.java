package com.itwill.shop.orders.test;



import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.order.OrderDao_kangsan;
import com.itwill.shop.order.OrderItem_kangsan;
import com.itwill.shop.order.Orders_kangsan;
import com.itwill.shop.product.Product;


public class OrderDaoTestMain_kangsan {

	public static void main(String[] args) throws Exception {
		OrderDao_kangsan orderDao = new OrderDao_kangsan();
		int rowCount = 0;
		
		/*
		 * 주문전체삭제 (회원아이디)
		 */
		rowCount = orderDao.deleteByUserId("cream2");
		System.out.println(rowCount+"개의 아이디주문 삭제");
		
		/*
		 * 주문 1건 삭제 (주문번호)
		 */
		rowCount = 4;
		System.out.println(orderDao.deleteByO_no(rowCount)+"개의 주문 삭제");
		
		/*
		 * 주문생성 (주문 1개 + 주문아이템 1개 이상) - 트랜잭션 처리 필요.
		 */
		List<OrderItem_kangsan> orderItemList = new ArrayList<OrderItem_kangsan>();
		Orders_kangsan newOrders = new Orders_kangsan(0, "shoes외6종", null, 55555, "cream1",orderItemList);
		newOrders.getOrderItemList().add(new OrderItem_kangsan(0, 2, 0,new Product(1, "네이키", 44444, null, "쌉니다",0,0)
			));
		newOrders.getOrderItemList().add(new OrderItem_kangsan(0, 3, 0,new Product(2, "나이키", 45555, null, "쌉니다",0,0)));
		rowCount = orderDao.insert(newOrders);
		System.out.println(rowCount+"개의 주문 생성");
		
		
		/*
		 * 주문 전체조회 (기본내용)
		 */
		
		System.out.println(orderDao.findOrdersByUserId("cream1"));
		
		/*
		 * 주문 전체조회 (상세내용)
		 */
		List<Orders_kangsan> findorder = orderDao.findOrderWithOrdersItemByUserId("cream3");
		for (Orders_kangsan orders : findorder) {
			System.out.println(orders);
		}
		
		/*
		 * 주문 1개 조회 (상세내용)
		 */
		System.out.println(orderDao.findByOrdersNo(3));
	}		
}