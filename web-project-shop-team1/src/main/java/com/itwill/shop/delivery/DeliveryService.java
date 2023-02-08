package com.itwill.shop.delivery;

import java.util.List;

public class DeliveryService {
		
		private DeliveryDao deliveryDao;
		public DeliveryService() throws Exception {
			deliveryDao = new DeliveryDao();
		}
		//배송정보 입력
		public int insertDelivery(String d_address,String d_phone,String d_name,String user_id) throws Exception {
			return deliveryDao.insertDelivery(d_address, d_phone, d_name, user_id);
		}
		//배송정보리스트 가져오기
		public List<Delivery> selectDelivery(String user_id) throws Exception {
			return deliveryDao.selectDeliveryByuserId(user_id);
		}

		//배송정보 가져오기
		public Delivery select(String d_address) throws Exception {
			return deliveryDao.selectDeliveryByAddress(d_address);
		}
		
		//배송정보 삭제
		public int deleteDelivery(String user_id) throws Exception {
			return deliveryDao.deleteDelivery(user_id);
		}
		
		
}
