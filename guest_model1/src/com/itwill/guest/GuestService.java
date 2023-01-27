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
}
