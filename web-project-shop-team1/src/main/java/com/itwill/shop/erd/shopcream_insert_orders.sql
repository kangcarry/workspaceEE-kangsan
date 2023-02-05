
insert into orders(o_no,o_desc,o_date,o_price,user_Id) values(orders_o_no_SEQ.nextval,'나이키 에어맥스 레드',sysdate,100000,'sy1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,ORDERS_O_NO_SEQ.nextval,PRODUCT_P_NO_SEQ.nextval);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,3,ORDERS_O_NO_SEQ.nextval,PRODUCT_P_NO_SEQ.nextval);

insert into orders(o_no,o_desc,o_date,o_price,user_Id) values(orders_o_no_SEQ.nextval,'나이키 에어맥스 블루',sysdate,100000,'sy2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,ORDERS_O_NO_SEQ.nextval,PRODUCT_P_NO_SEQ.nextval);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,3,ORDERS_O_NO_SEQ.nextval,PRODUCT_P_NO_SEQ.nextval);

