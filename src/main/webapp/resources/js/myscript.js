function formValidation() {
	var name = document.registration.name.value;
	var city = document.registration.city.value;
	var email = document.registration.email.value;
	var phone = document.registration.phone.value;
	var username = document.registration.username.value;
	var password = document.registration.password.value;

	var name_len = name.value.length;
	var city_len = city.value.length;
	var phone_len = phone.value.length;
	var password_len = fpassword.value.length;

	var mailformat = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	var numbers = /^[0-9]+$/;
	var letters = /^[A-Za-z]+$/;
	
	
	if(true){return false;}
	if (!name.match(letters) && name_len <= 20) {
		document.registration.name.focus();
		alert("name");
		return false;
	}

	if (!city.value.match(letters) && city_len <= 30) {
		alert("city");
		document.registration.city.focus();
		return false;
	}

	if (!email.value.match(mailformat)) {
		alert("email");
		document.registration.email.focus();
		return false;
	}

	if (phone_len == 0 || phone_len != mx || !phone.value.match(numbers)) {
		alert("phone number should be 10 digits only");
		document.registration.phone.focus();
		return false;
	}

	if (!username.value.match(letters)) {
		alert("username");
		document.registration.username.focus();
		return false;
	}

	if (password_len < min || password_len > max) {
		alert(" password length should be atleast 8 characters and not more than 15 charecters");
		document.registration.password.focus();
		return false;
	}
	
	return true;

}
