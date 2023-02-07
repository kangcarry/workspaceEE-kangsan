package com.itwill.shop.user;

import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.user.exception.ExistedUserException;
import com.itwill.shop.user.exception.PasswordMismatchException;
import com.itwill.shop.user.exception.UserNotFoundException;

public class UserService {
	private UserDao userDao;

	public UserService() throws Exception {
		userDao = new UserDao();
	}

	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception {
		// 1.아이디중복체크
		if (userDao.existedUser(user.getUser_id())) {
			throw new ExistedUserException(user.getUser_id() + " 는 이미존재하는 아이디입니다.");
		}
		return userDao.create(user);

	}

	/*
	 * 회원로그인
	 */
	public User login(String user_id, String user_password) throws Exception {
		// 1.아이디존재여부
		User user = userDao.findUser(user_id);
		if (user == null) {
			throw new UserNotFoundException(user_id + " 는 존재하지않는 아이디 입니다.");
		}
		// 2.패쓰워드일치여부
		if (!user.isMatchPassword(user_password)) {
			throw new PasswordMismatchException("패스워드가 일치하지않습니다.");
		}
		return user;
	}

	/*
	 * 회원전체리스트
	 */
	public ArrayList<User> findUserList() throws Exception {
		return userDao.findUserList();
	}
	/*
	 * 회원전체 아이디리스트
	 */
	public List findUserIdList() throws Exception {
		return userDao.findUserIdList();
	}
	/*
	 * 회원1명보기
	 */
	public User findUser(String user_id) throws Exception {
		User findUser = userDao.findUser(user_id);
		return findUser;
	}

	/*
	 * 회원수정
	 */
	public int update(User user) throws Exception {
		return userDao.update(user);
	}

	/*
	 * 회원탈퇴
	 */
	public int remove(String user_id) throws Exception {
		return userDao.remove(user_id);
	}

	/*
	 * 아이디중복체크
	 */
	public boolean isDuplicateId(String user_id) throws Exception {
		boolean isExist = userDao.existedUser(user_id);
		if (isExist) {
			return true;
		} else {
			return false;
		}
	}

}
