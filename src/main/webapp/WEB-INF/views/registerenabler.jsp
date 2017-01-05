<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/images/style.css" />
<link rel="stylesheet" type="text/css" href="resources/css1/reset.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css1/structure.css" />
<title>Virtusa V-Learn</title>
<script>
	function disableBackButton() {
		window.history.forward()
	}
	disableBackButton();
	window.onload = disableBackButton();
	window.onpageshow = function(evt) {
		if (evt.persisted)
			disableBackButton()
	}
	window.onunload = function() {
		void (0)
	}

	function validateForm() {

		var x = document.forms["myForm"]["name"].value;

		if (x == null || x == "") {
			alert("Name must be filled");

			return false;
		}

		var x = document.forms["myForm"]["city"].value;

		if (x == null || x == "") {
			alert("City must be filled");

			return false;
		}

		var phone = document.forms["myForm"]["phone"].value;

		var regex = /^[0-9]{10}$/;

		if (!regex.test(phone)) {
			alert("Enter 10 digit mobile number");

			return false;
		}

		var email = document.forms["myForm"]["email"].value;

		var regex = /^([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)@([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)[\\.]([a-zA-Z]{2,9})$/;

		if (!regex.test(email)) {
			alert("Enter a valid email");

			return false;
		}

		var password = document.forms["myForm"]["password"].value;

		var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;

		if (!regex.test(password)) {
			alert("Enter a valid password of length 6-16 characters with atleast an alphabet, a digit and a special character");

			return false;
		}

		var x = document.forms["myForm"]["phone"].value;

		if (x == null || x == "") {
			alert("Phone number must be filled");

			return false;
		}

		var x = document.forms["myForm"]["email"].value;

		if (x == null || x == "") {
			alert("Email must be filled");

			return false;
		}

		var x = document.forms["myForm"]["username"].value;

		if (x == null || x == "") {
			alert("Username must be filled");

			return false;
		}

		var x = document.forms["myForm"]["password"].value;

		if (x == null || x == "") {
			alert("Password must be filled");

			return false;
		}

	}

	function AllowAlphabet() {

		if (!myForm.name.value.match(/^[a-zA-Z ]*$/) && myForm.name.value != "") {
			myForm.name.value = "";
			myForm.name.focus();
			alert("Please Enter only alphabets in text");
		}
	}

	function AllowAlphabet1() {

		if (!myForm.city.value.match(/^[a-zA-Z ]*$/) && myForm.city.value != "") {
			myForm.city.value = "";
			myForm.city.focus();
			alert("Please Enter only alphabets in text");
		}
	}

	function AllowAlphabet2() {

		if (!myForm.username.value.match(/^[a-zA-Z0-9]+$/)
				&& myForm.username.value != "") {
			myForm.username.value = "";
			myForm.username.focus();
			alert("Space or Special characters not allowed in username");
		}
	}
</script>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">

			<div id="toplinks"></div>

			<div id="zaglavlje">

				<div id="title">
					<p style="color: #fff; padding-left: 0px; padding-top: 55px;">Virtusa
						V-Learn</p>
				</div>
			</div>
			<div id="dropnav">
				<ul>

					<li id="main"><a href="home.html">Home</a></li>

					<li id="main"><a href="#">Login</a>
						<ul id="subnav">
							<li><a href="loginpageadmin.html">As Admin</a></li>
							<li><a href="loginpagelearner.html">As Learner</a></li>
							<li><a href="loginpageenabler.html">As Enabler</a></li>

						</ul></li>

					<li id="main"><a href="#">Register</a>
						<ul id="subnav">
							<li><a href="registerpagelearner.html">As Learner</a></li>
							<li><a href="registerpageenabler.html">As Enabler</a></li>
						</ul></li>

					<li id="main"><a href="contactpagehome">Contact Us</a></li>

				</ul>
				<h1 id="hz">
					<br>${message}
				</h1>
			</div>

			<div id="navigacija">

				<div class="lijevo">
					<br></br> <a href="http://www.virtusa.com" target="_blank"><img
						src="resources/images/pic.jpg" width="110" height="165"
						align="middle" /></a><br />
					<p>Virtusa named as world's top outsourcing service provider in
						2015 IAOP's Global Outsourcing</p>
					<p style="padding-left: 10px;">
						<a href="http://www.virtusa.com" target="_blank"><p
								style="color: #FFFFFF; text-decoration: inherit; padding-left: 50px;">More
								Details..</p></a>
					</p>
					<br />
				</div>
			</div>



			<div id="">


				<form action=addenabler.html method="post" class="box register"
					name="myForm" onsubmit="return validateForm();">
					<fieldset class="boxBody">

						<table>
							<tr>
								<td><h1 id="ha">
										<br>Enabler Registration
									</h1></td>
							</tr>
							<tr>
								<td><label>Name</label> <input type="text" name="name"
									tabindex="1" maxlength="30" onkeyup="AllowAlphabet()" /></td>
								<td><label>City</label> <input type="text" name="city"
									tabindex="2" maxlength="20" onkeyup="AllowAlphabet1()" /></td>
							</tr>
							<tr>
								<td><label>Email</label> <input type="text" name="email"
									tabindex="3" maxlength="40" /></td>
								<td><label>Mobile number</label> <input type="text"
									name="phone" tabindex="4" maxlength="10"/></td>
							</tr>
							<tr>
								<td><label>User name</label> <input type="text"
									name="username" tabindex="5" maxlength="20"
									onkeyup="AllowAlphabet2()" /></td>
								<td><label>Password</label> <input type="password"
									name="password" tabindex="6" maxlength="16"/></td>
							</tr>

						</table>
					</fieldset>
					<footer> <input type="submit" class="btnRegister"
						value="Register" tabindex="4"></footer>

				</form>

			</div>
		</div>
	</div>
</body>
</html>