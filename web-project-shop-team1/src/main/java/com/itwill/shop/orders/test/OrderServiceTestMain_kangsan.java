package com.itwill.shop.orders.test;



import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.order.OrderDao_kangsan;
import com.itwill.shop.order.OrderItem_kangsan;
import com.itwill.shop.order.OrderService_kangsan;
import com.itwill.shop.order.Orders_kangsan;
import com.itwill.shop.product.Product;


public class OrderServiceTestMain_kangsan {

	public static void main(String[] args) throws Exception {
		OrderService_kangsan orderService = new OrderService_kangsan();
		
		
		//상품리스트에서 직접 주문(테스트성공)
		System.out.println(orderService.createOrderByProductList("cream1", 1, 3)+"번 주문성공");
		
		//카트에서 전체주문(테스트성공)
//		System.out.println(orderService.createOrderByCartAll("cream1"));
		
		
		//카트에서 선택주문
		System.out.println(orderService.createOrderByCart(5));
		
		//주문목록보기
		System.out.println(orderService.selectAll("cream1"));
		
		//주문목록보기 + 상품상세보기
		System.out.println(orderService.selectAllDetail("cream3"));
		
		
		//주문상세보기
		System.out.println(orderService.selectOrdersDetail(3));
		
		//주문1개삭제
		System.out.println(orderService.orderDelete(5)+"개주문 삭제");
		
		//주문전체삭제
		String idStr = "cream3";
		System.out.println(orderService.orderDeleteAll(idStr)+ "번 주문 전체 삭제");
		
		}
		
	}		
