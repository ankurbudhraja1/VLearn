
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
				<h3>${message}</h3>


			</div>

			<div id="zaglavlje">

				<div id="title">
					<p style="color: #fff; padding-left: 0px;">Virtusa V-Learn</p>
				</div>
			</div>
			<div id="dropnav">
				<ul>

					<li id="main"><a href="learner_home.html">Home</a></li>

					<li id="main"><a href="contactpagelearner">Contact us</a></li>

					<li id="main"><a href="logoutlearner.html">Logout</a></li>


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
				<br />

				<h7>Course: ${course.c_name }</h7>

				<p>
					<strong></strong>


					<table class="myTable">
						<form action="download.html" method="post">
							<tr>
								<th colspan="2">COURSE DETAILS</th>
							</tr>
							<tr>
								<td>Course ID</td>
								<td>${course.c_id }</td>
							</tr>
							<tr>
								<td>Course Name</td>
								<td>${course.c_name }</td>
							</tr>
							<tr>
								<td>Course Description</td>
								<td>${course.c_description }</td>
							</tr>
							<tr>
								<td>Course Materials and Self assessment module</td>
								<td><input type="submit" value="Download"
									onclick="alert('Downloaded Successfully in Downloads folder');" /></td>
							</tr>
							<br />
							<input type="hidden" value="${course.c_id}" name="c_id" />
						</form>
					</table>
					<br />


					<table class="myTable">
						<tr>
							<th colspan="2">EXAMINATION DETAILS</th>
						</tr>
						<tr>
							<td>Examination Date (yyyy-mm-dd)</td>
							<td>${course.c_e_date }</td>
						</tr>
						<tr>
							<td>Examination Time (hh:mm)</td>
							<td>${course.c_e_time }</td>
						</tr>
						<tr>
							<td>Examination Venue</td>
							<td>${course.c_e_venue }</td>
						</tr>
						</div>

						</div>
						</div>
</body>
</html>

