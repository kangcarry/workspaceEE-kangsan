package com.itwill.shop.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
		private OrderDao orderDao;
		
		public OrderService() throws Exception {
			orderDao = new OrderDao();
		}
	
	
		//상품리스트에서 직접 주문
		public int createOrderByCart(String user_id,int p_no,int oi_qty) {
			int rowCount = 0;
			
			
			return rowCount;
		}
		
		//카트에서 전체주문
		
		
		
		//카트에서 선택주문
		
		
		
		//주문목록보기
		public List<Orders> selectAll(String user_id) throws Exception{
			return orderDao.findOrdersByUserId(user_id);
		}
		//주문목록보기 + 상품상세보기
		public List<Orders> selectAllDetail(String user_id) throws Exception{
			return orderDao.findOrderWithOrdersItemByUserId(user_id);
		}
		//주문상세보기
		public Orders selectOrdersDetail(int o_no) throws Exception {
			return orderDao.findByOrdersNo(o_no);
		}
		//주문1개삭제
		public int orderDelete(int o_no) throws Exception {
			return orderDao.deleteByO_no(o_no);
		}
		//주문전체삭재
		public int orderDeleteAll(String user_Id) throws Exception {
			return orderDao.deleteByUserId(user_Id);
		}
		
		


}
