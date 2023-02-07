package com.itwill.shop.delivery;

public class DeliveryService {
		
		private DeliveryDao deliveryDao;
		public DeliveryService() throws Exception {
			deliveryDao = new DeliveryDao();
		}
		//배송정보 입력
		public int insertDelivery(String d_address,String d_phone,String d_name,String user_id) throws Exception {
			return deliveryDao.insertDelivery(d_address, d_phone, d_name, user_id);
		}
		//배송정보 정보가져오기
		public Delivery selectDelivery(String user_id) throws Exception {
			return deliveryDao.selectDeliveryByuserId(user_id);
		}

		//배송정보 삭제
		public int deleteDelivery(String user_id) throws Exception {
			return deliveryDao.deleteDelivery(user_id);
		}
		
		
}
