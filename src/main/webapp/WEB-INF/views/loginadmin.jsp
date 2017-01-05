<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/images/style.css" />
<link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/structure.css" />
<title>Virtusa V-Learn</title>
<script type="text/javascript" language="javascript">
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
</script>
<script>
	function validateForm() {

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
				<h1 id="h">
					<br>Admin login 
				</h1>
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


				<form name="myForm" action=loginprocessadmin.html method="post"
					class="box login" onsubmit="return validateForm()">
					<!-- <center> -->

					<fieldset class="boxBody">
						<label>Username</label> <input type="text" name="username"
							tabindex="1" maxlength="20" onkeyup="AllowAlphabet2()"> <label>Password</label>
							<input type="password" name="password" tabindex="2"
							maxlength="16">
					</fieldset>
					<footer> <input type="submit" class="btnLogin"
						value="Login" tabindex="4"></footer>
					<!-- <h4><a href="RegistrationNew.html"><font color="blue">New user? click here to register</font></a></h4>
 -->

				</form>

			</div>
		</div>
	</div>
</body>
</html>