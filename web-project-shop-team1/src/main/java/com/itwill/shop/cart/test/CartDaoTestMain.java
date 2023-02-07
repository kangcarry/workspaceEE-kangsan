package com.itwill.shop.cart.test;
import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.ProductDao;
public class CartDaoTestMain {
	public static void main(String[] args) throws Exception{
		CartDao cartDao = new CartDao();
		ProductDao productDao = new ProductDao();
		
		System.out.println("1. countByProductNo");
		System.out.println(cartDao.countByProductNo("cream1", 1));
		
		System.out.println("2. insertCart");
		Cart insertCart = new Cart(0, "cream2", 1, productDao.selectByNo(3));
		System.out.println(cartDao.insertCart(insertCart));
		
		System.out.println("3. deleteByUserId");
		System.out.println(cartDao.deleteByUserId("cream2"));
		
		System.out.println("4. deleteByCartNo-");
		System.out.println(cartDao.deleteByCartNo(32));
		
		System.out.println("5.updateByProductNo+UserId");
		Cart updateCartByProductNo = new Cart(0, "cream1", 4, productDao.selectByNo(1));
		System.out.println(cartDao.updateByProductNo(updateCartByProductNo));
		
		System.out.println("6. updateByCartNo");
		System.out.println(cartDao.updateByCartNo(new Cart(34, null, 5, null)));
		
		System.out.println("7. findByUserId");
		System.out.println(cartDao.findByUserId("cream1"));
		
		System.out.println("8. findByCartNo");
		System.out.println(cartDao.findByCartNo(8));
		
		
		
	
	}
	
	

}
