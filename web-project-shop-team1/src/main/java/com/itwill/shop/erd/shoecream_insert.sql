/**********************userinfo insert************************/
insert into userinfo(user_Id,user_password,user_name,user_phone,user_email,user_address) values('cream1','1111','크림1','1111','cream1@korea.com','aaaa');
insert into userinfo(user_Id,user_password,user_name,user_phone,user_email,user_address) values('cream2','2222','크림2','2222','cream2@korea.com','bbbb');
insert into userinfo(user_Id,user_password,user_name,user_phone,user_email,user_address) values('cream3','3333','크림3','3333','cream3@korea.com','cccc');

/**********************category insert************************/
insert into category(category_no,category_name) values(1,'운동화');
insert into category(category_no,category_name) values(2,'슬리퍼');
insert into category(category_no,category_name) values(3,'부츠');

/**********************product insert************************/
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(1, 'shoes1', 100000, 'shoes1.png','기타 상세 정보 등...', 0,1);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(2, 'shoes2', 200000, 'shoes2.jpg','기타 상세 정보 등...', 0,1);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(3, 'shoes3', 300000, 'shoes3.jpg','기타 상세 정보 등...', 0,1);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(4, 'shoes4', 400000, 'shoes4.png','기타 상세 정보 등...', 0,2);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(5, 'shoes5', 500000, 'shoes5.jpg','기타 상세 정보 등...', 0,2);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(6, 'shoes6', 600000, 'shoes6.jpg','기타 상세 정보 등...', 0,2);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(7, 'shoes7', 700000, 'shoes7.jpg','기타 상세 정보 등...', 0,3);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(8, 'shoes8', 800000, 'shoes8.jpg','기타 상세 정보 등...', 0,3);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_click_count,category_no) values(9, 'shoes9', 800000, 'shoes9.jpg','기타 상세 정보 등...', 0,3);


/**********************cart insert************************/

insert into cart(cart_no,user_Id,cart_qty,p_no) values (cart_cart_no_SEQ.nextval,'cream1',1,1);
insert into cart(cart_no,user_Id,cart_qty,p_no) values (cart_cart_no_SEQ.nextval,'cream1',2,2);
insert into cart(cart_no,user_Id,cart_qty,p_no) values (cart_cart_no_SEQ.nextval,'cream2',3,3);
insert into cart(cart_no,user_Id,cart_qty,p_no) values (cart_cart_no_SEQ.nextval,'cream2',7,1);
insert into cart(cart_no,user_Id,cart_qty,p_no) values (cart_cart_no_SEQ.nextval,'cream3',5,5);

/**********************delivery insert************************/
insert into delivery(d_address,d_phone,d_name,user_Id) values ('cream1_home','1111-1111','집','cream1');
insert into delivery(d_address,d_phone,d_name,user_Id) values ('cream1_office','1111-2222','회사','cream1');
insert into delivery(d_address,d_phone,d_name,user_Id) values ('cream2_home','2222-1111','집','cream2');
insert into delivery(d_address,d_phone,d_name,user_Id) values ('cream2_office','2222-2222','회사','cream2');
insert into delivery(d_address,d_phone,d_name,user_Id) values ('cream3_home','3333-1111','집','cream3');

/**********************orders insert************************/
insert into orders(o_no,o_desc,o_date,o_price,user_Id) values (orders_o_no_SEQ.nextval,'shoes1외1종',sysdate-2,11111,'cream1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,user_Id) values (orders_o_no_SEQ.nextval,'shoes2외0종',sysdate-1,22222,'cream2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);

insert into orders(o_no,o_desc,o_date,o_price,user_Id) values (orders_o_no_SEQ.nextval,'shoes3외1종',sysdate,33333,'cream3');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,4);


/**********************product_reply insert************************/


/**********************board insert************************/


commit;
desc order_item;


