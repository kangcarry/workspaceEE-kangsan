function idDuplicateCheck(){
	
	f.action = "user_id_check_form.jsp";
	f.method = 'POST';
	f.submit();
}
function userCreate() {
	if (document.f.user_id.value == "") {
		alert("사용자 아이디를 입력하십시요.");
		f.user_id.focus();
		return false;
	}

	if (f.user_password.value == "") {
		alert("비밀번호를 입력하십시요.");
		f.user_password.focus();
		return false;
	}
	if (f.password2.value == "") {
		alert("비밀번호확인을 입력하십시요.");
		f.password2.focus();
		return false;
	}
	if (f.user_name.value == "") {
		alert("이름을 입력하십시요.");
		f.user_name.focus();
		return false;
	}
	if (f.user_phone.value == "") {
		alert("전화번호를 입력하십시요.");
		f.user_phone.focus();
		return false;
	}
	if (f.user_email.value == "") {
		alert("이메일 주소를 입력하십시요.");
		f.user_email.focus();
		return false;
	}
	if (f.user_address.value == "") {
		alert("주소를 입력하십시요.");
		f.user_address.focus();
		return false;
	}

	f.action = "user_write_action.jsp";
	f.method = 'POST';
	f.submit();
}
function pwCheck() {
	if (f.user_password.value != f.password2.value) {
		document.getElementById('pw_span').innerText = "비밀번호가 일치하지 않습니다."
		document.getElementById('pw_span').style.color = "red";
		return false;
	}else {
		document.getElementById('pw_span').innerText = "비밀번호가 일치합니다."
		document.getElementById('pw_span').style.color = "blue";
		return true;
	}
}
function openIdCheck(){
		var left = Math.ceil(( window.screen.width)/5);
		var top = Math.ceil(( window.screen.height)/5); 
		let idCheckWindow = window.open("user_id_check_form.jsp","checkForm","width=430,height=200,top="+top+",left="+left+",resizable = no,location=no, directories=no, status=no, menubar=no, scrollbars=no,copyhistory=no");
}

function main() {
	f.action = "shop_main.jsp";
	f.submit();
}

function userModifyAction() {
	if (f.user_password.value != f.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		f.user_password.focus();
		f.user_password.select();
		return false;
		}
	document.f.action = "user_modify_action.jsp";
	document.f.method='POST';
	document.f.submit();
}

function userModify() {
	document.f.action = "user_modify_form.jsp";
	document.f.method = "POST";
	document.f.submit();
}
function userRemove() {
	if (confirm("정말 삭제하시겠습니까?")) {
		document.f.action = "user_remove_action.jsp";
		document.f.method='POST';
		document.f.submit();
	}
}