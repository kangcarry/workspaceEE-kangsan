package com.itwill.guest;

import java.util.List;

public class GuestService {
	private GuestDao guestDao;
	public GuestService() throws Exception{
		guestDao=new GuestDao();
	}
	/*
	 * 방명록 리스트
	 */
	public List<Guest> findAll()throws Exception{
		return guestDao.findAll();
	}
	public Guest selectByNo(int no) throws Exception {
		return guestDao.findByNo(no);
	}
	
	public int updateGuest(Guest guest) throws Exception {
		return guestDao.update(guest);
	}
	public int insertGuest(Guest guest) throws Exception {
		return guestDao.insert(guest);
	}
	public int removeGuest(int guest_no) throws Exception {
		return guestDao.delete(guest_no);
	}
}
