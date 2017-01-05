
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/images/style.css" />
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
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">

			<div id="toplinks">
				<h3>${message}</h3>

			</div>

			<div id="zaglavlje">

				<div id="title">
					<p style="color: #fff; padding-left: 0px;">Virtusa V-Learn</p>
				</div>
			</div>
			<div id="dropnav">
				<ul>

					<li id="main"><a href="enabler_home.html">Home</a></li>

					<li id="main"><a href="contactpageenabler">Contact us</a></li>
					<li id="main"><a href="logoutenabler.html">Logout</a></li>
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
				<p>
					<strong></strong> <br /> <br> <a href="gotoaddcourse.html"
						class="button">Add a course</a> <br />
					<br />
					<br />
					<br /> <a href="viewcourseenabler.html" class="button">View all
							courses</a><br />
					<br />
					<br />
					<br /> <a href="managecourseenabler.html" class="button">Manage
							Courses</a><br />
					<br />
					<br />
					<br /> <a href="resetpswdenabler.html" class="button">Reset
							Password</a><br />
					<br />
					<br /> <br />
				</p>
				<br />
				</center>
			</div>

		</div>
	</div>

</body>
</html>

