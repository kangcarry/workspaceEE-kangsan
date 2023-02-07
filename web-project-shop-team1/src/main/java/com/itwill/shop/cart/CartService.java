package com.itwill.shop.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception{
		cartDao = new CartDao();
	}
	
	/*
	 * insert, update
	 */
	public int addCart(Cart cart) throws Exception{
		if(cartDao.countByProductNo(cart.getUser_Id(), cart.getProduct().getP_no()) > 0) {
			return cartDao.updateByProductNo(cart);
		}else {
			return cartDao.insertCart(cart);
		}
	}
	
	/*
	 * update
	 */
	public int updateCart(Cart cart) throws Exception{
		return cartDao.updateByCartNo(cart);
	}

	
	/*
	 * delete
	 */
	//전체 삭제
	public int deleteCartItemByUserId(String sUserId) throws Exception{
		return cartDao.deleteByUserId(sUserId);
	}

	//일부 상품 삭제
	public int deleteCartItemByCartNo(int cart_no) throws Exception{
		return cartDao.deleteByCartNo(cart_no);
	}
	
	
	/*
	 * view
	 */
	//전체 출력
	public List<Cart> viewCartByUserId(String sUserId) throws Exception{
		return cartDao.findByUserId(sUserId);
	}
	
	//카트 번호로 출력
		public Cart viewCartByCartNo(int cart_no) throws Exception{
			return cartDao.findByCartNo(cart_no);
	}
	

}
