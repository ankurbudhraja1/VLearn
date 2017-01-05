<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/images/style.css" />
<title>Virtusa V-Learn</title>

<script>
	function validateForm() {

		var newpassword = document.forms["myForm"]["newpassword"].value;

		var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;

		if (!regex.test(newpassword)) {
			alert("Enter a valid password of length 6-16 characters with atleast an alphabet, a digit and a special character");

			return false;
		}

		var x = document.forms["myForm"]["newpassword"].value;

		if (x == null || x == "") {
			alert("New Password must be filled");

			return false;
		}

		var x = document.forms["myForm"]["confirmnewpassword"].value;

		if (x == null || x == "") {
			alert("Confirm New Password must be filled");

			return false;
		}

		
		var newpassword = document.forms["myForm"]["newpassword"].value;
		var confirmnewpassword = document.forms["myForm"]["confirmnewpassword"].value;
		
	        if (newpassword != confirmnewpassword) {
	            alert("Passwords Do not match");
	            return false;
	        }
	}
</script>

<style type="text/css">
.myTable {
	width: 400px;
	background-color: #eee;
	border-collapse: collapse;
}

.myTable th {
	background-color: #000;
	color: white;
	width: 50%;
}

.myTable td,.myTable th {
	padding: 5px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">

			<div id="toplinks">
				<h3></h3>

			</div>

			<div id="zaglavlje">

				<div id="title">
					<p style="color: #fff; padding-left: 0px;">Virtusa V-Learn</p>
				</div>
			</div>
			<div id="dropnav">
				<ul>

					<li id="main"><a href="admin_home.html">Home</a></li>


					<li id="main"><a href="logoutadmin.html">Logout</a></li>
					<li></li>
					<li></li>
					<li></li>


					<li id="main">
						<p style="margin-top: 0px; padding-left: 50px; color: #F7931E;">
							<b>Welcome..${username }</b>
						</p>
					</li>
				</ul>
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
				<center>
				<br />


				<p>
					<strong></strong> <br />
					<table class="myTable">
						<tr>
							<th colspan="2">Reset Password</th>
						</tr>
						<tr>

							<form action="resetprocessadmin.html" method="post" name="myForm"
								onsubmit="return validateForm();">
								<td>User-name:</td>
								<td><input type="text" name="a_username"
									value="${username }" readonly> <br></td>
						</tr>
						<tr>
							<td>New Password:</td>
							<td><input type="password" name="newpassword"
								id="newpassword" maxlength="16"></td>
						</tr>
						<tr>
							<td>Confirm New Password:</td>
							<td><input type="password" name="confirmnewpassword"
								id="confirmnewpassword" maxlength="16"></td>
						</tr>
						<br>
					</table>
					<br /> <input type="submit" name="submit" value="Change password">
						<input type="reset" name="reset" value="Clear">

							</form>
				</center>
				</p>
				<br />



			</div>

		</div>
	</div>

</body>
</html>

