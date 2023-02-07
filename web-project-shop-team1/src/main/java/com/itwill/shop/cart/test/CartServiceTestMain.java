package com.itwill.shop.cart.test;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.ProductService;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception {
		CartService cartService = new CartService();
		ProductService productService = new ProductService();
		
		Cart addCart = new Cart(0, "cream3", 1, productService.productDetail(3));
		System.out.println("1-1. addCart_insertCart");
		System.out.println(cartService.addCart(addCart));
		System.out.println("1-2. addCart_updateByProductNo");
		System.out.println(cartService.addCart(addCart));
		
		System.out.println("2. updateByCartNo");
		System.out.println(cartService.updateCart(new Cart(12, null, 3, null)));
		
		System.out.println("3-1. deleteCartItem_ByUserId");
		System.out.println(cartService.deleteCartItemByUserId("cream1"));
		System.out.println("3-2. deleteCartItem_ByCartNo");
		System.out.println(cartService.deleteCartItemByCartNo(1));
		
		System.out.println("4-1. viewCartByUserId");
		System.out.println(cartService.viewCartByUserId("cream1"));
		System.out.println("4-2. viewCartByCartNo");
		System.out.println(cartService.viewCartByCartNo(14));
		
		
		
	}

}
