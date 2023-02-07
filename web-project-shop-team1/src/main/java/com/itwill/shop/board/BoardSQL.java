package com.itwill.shop.board;

public class BoardSQL {
	/*
	 * 
	 * select * from board;
	 * 
	 * --insert insert into
	 * board(board_no,board_title,board_content,board_regdate,board_readcount,
	 * board_group_no,board_step,board_depth,user_id) values
	 * (board_board_no_SEQ.nextval,'게시판테스트','게시판insert를
	 * 해보자',sysdate,0,board_board_no_SEQ.currval,1,0,'cream1'); insert into
	 * board(board_no,board_title,board_content,board_regdate,board_readcount,
	 * board_group_no,board_step,board_depth,user_id) values
	 * (board_board_no_SEQ.nextval,'게시판테스트'||board_board_no_SEQ.currval,'게시판insert를
	 * 해보자'||board_board_no_SEQ.currval,sysdate,0,board_board_no_SEQ.currval,1,0,'
	 * cream1'); insert into
	 * board(board_no,board_title,board_content,board_regdate,board_readcount,
	 * board_group_no,board_step,board_depth,user_id) values
	 * (board_board_no_SEQ.nextval,'게시판테스트'||board_board_no_SEQ.currval,'게시판insert를
	 * 해보자'||board_board_no_SEQ.currval,sysdate,0,board_board_no_SEQ.currval,1,0,'
	 * cream1'); --update --답글 생성 update board set board_step=board_step+1 where
	 * board_step > 1 and board_group_no=2; insert into
	 * board(board_no,board_title,board_content,board_regdate,board_readcount,
	 * board_group_no,board_step,board_depth,user_id) values
	 * (board_board_no_SEQ.nextval,'게시판답글테스트','게시판답글insert를
	 * 해보자',sysdate,0,2,1+1,0+1,'cream1');
	 * 
	 * --수정 update board set board_title='게시판업데이트',board_content='게시판update를 해보자'
	 * where board_no=2;
	 * 
	 * --delete delete from board where board_no =4 and user_id='cream1';
	 * 
	 * 
	 * commit;
	 */
	public final static String BOARD_INSERT = "insert into board"
			+ " values (board_board_no_SEQ.nextval,?,?,sysdate,0,board_board_no_SEQ.currval,1,0,?)";

	public final static String BOARD_USERID_CHECK = "select count(*) from board where user_id=? and board_no=?";
	public final static String BOARD_UPDATE_STEP = "update set board_step = board_step+1 where board_step > ? and board_group_no = ?";
	public final static String BOARD_INSERT_REPLY = "insert into board"
			+ "values (board_board_no_SEQ.nextval,?,?,sysdate,0,?,?,?,?) ;";
	public final static String BOARD_COUNT_REPLY = "select count(*) cnt from board"
			+ "where board_group_no=? and board_depth=? and board_step=?";

	public final static String BOARD_INCREASE_READCOUNT = "UPDATE board SET board_readcount = board_readcount + 1 WHERE board_no = ?";

	public final static String BOARD_UPDATE = "update board set board_title=?,board_content=? where board_no=?";
	public final static String BOARD_DELETE_BY_BOARDNO = "delete from board where board_no=?";

	public final static String BOARD_SELECT_BY_BOARDNO = "select board_no,board_title,board_regdate,board_readcount,board_group_no,board_step,board_depth,user_id"
			+ " from board where board_no=?";
	public final static String BOARD_COUNT_SELECT = "select count(*) cnt from board";
	public final static String BOARD_SELECT_ALL_ROWNUM = "select * from (select rownum idx, s.*"
			+ " from (select board_no,board_title,board_regdate,board_readcount,board_group_no,board_step,board_depth,user_id"
			+ " from board order by board_group_no DESC, board_step asc) s ) where idx >= ? and idx<= ?";
	public final static String BOARD_SELECT_BY_USERID = "select * from (select rownum idx, s.*"
			+ " from (select board_no,board_title,board_regdate,board_readcount,board_group_no,board_step,board_depth,user_id"
			+ " from board order by board_group_no DESC, board_step asc) s ) where user_id =? and idx >= ? and idx<= ?";
}
