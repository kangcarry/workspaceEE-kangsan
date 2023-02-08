package com.itwill.shop.order;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class OrderService_kangsan {
		private OrderDao_kangsan orderDao;
		private ProductDao productDao;
		private CartDao cartDao;
		public OrderService_kangsan() throws Exception {
			orderDao = new OrderDao_kangsan();
			productDao = new ProductDao();
			cartDao = new CartDao();
		}
	
	
		//상품리스트에서 직접 주문
		public int createOrderByProductList(String user_id,int p_no,int oi_qty) throws Exception {
			
			int rowCount = 0;
			Orders_kangsan orders = new Orders_kangsan();
			Product product = productDao.selectByNo(p_no);
			List<OrderItem_kangsan> itemList = new ArrayList<OrderItem_kangsan>();
			itemList.add(new OrderItem_kangsan(orders.getO_no(), oi_qty, 0, product));
			orders = new Orders_kangsan(0, product.getP_desc(), null, product.getP_price()*oi_qty, user_id,itemList);
			rowCount = orderDao.insert(orders);
			return rowCount;
		}
		
		//카트에서 전체주문
		public int createOrderByCartAll(String user_id) throws Exception {
			int rowCount = 0;
			List <Cart> cartList = cartDao.findByUserId(user_id);
			Orders_kangsan orders = new Orders_kangsan();
			List<OrderItem_kangsan> itemList = new ArrayList<OrderItem_kangsan>();
			for (Cart cart : cartList) {
				itemList.add(new OrderItem_kangsan(0, cart.getCart_qty(), 0, cart.getProduct()));
			}
			orders = new Orders_kangsan(0, "shoes외2종", null, orders.getO_price(), user_id,itemList);
			rowCount = orderDao.insert(orders);
			return rowCount;
		}
		
		
		//카트에서 선택주문
		public int createOrderByCart(int cart_no) throws Exception {
			Orders_kangsan orders = new Orders_kangsan();
			Cart cart = cartDao.findByCartNo(cart_no);
			List<OrderItem_kangsan> itemList = new ArrayList<OrderItem_kangsan>();
			itemList.add(new OrderItem_kangsan(0, cart.getCart_qty(), 0, cart.getProduct()));
			orders.setOrderItemList(itemList);
			return orderDao.insert(orders);
		}
		
		
		//주문목록보기
		public List<Orders_kangsan> selectAll(String user_id) throws Exception{
			return orderDao.findOrdersByUserId(user_id);
		}
		//주문목록보기 + 상품상세보기
		public List<Orders_kangsan> selectAllDetail(String user_id) throws Exception{
			return orderDao.findOrderWithOrdersItemByUserId(user_id);
		}
		//주문상세보기
		public Orders_kangsan selectOrdersDetail(int o_no) throws Exception {
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
