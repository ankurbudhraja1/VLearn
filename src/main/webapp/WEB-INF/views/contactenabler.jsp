
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

<style>
#map-canvas {
	width: 400px;
	height: 300px;
}
</style>
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
<script src="https://maps.googleapis.com/maps/api/js"></script>

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
				<h3></h3>
				<center>
				<table class="myTable">
					<tr>
						<th colspan="2">Contact Details</th>
					</tr>
					<tr>
						<td>Email ID</td>
						<td>admin_vlearn@gmail.com</td>
					</tr>
					<tr>
						<td>Address</td>
						<td>Virtusa Consulting Services Pvt. Ltd. <br />Survey
							No.115, Nanakramguda Village, <br />Serilingampally Mandal, <br />Ranga
							Reddy District, <br />Hyderabad 500032
						</td>
					</tr>

					<tr>
						<td colspan="2"><b>Map</b> <script type="text/javascript"
								src="http://maps.google.com/maps/api/js?sensor=false"></script>
							<div style="overflow: hidden; height: 300px; width: 400px;">
								<div id="gmap_canvas" style="height: 300px; width: 400px;"></div>
								<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
								<a class="google-map-code"
									href="http://www.embed-google-map.com" id="get-map-data">embed
									google map</a>
							</div>
							<script type="text/javascript">
								function init_map() {
									var myOptions = {
										zoom : 15,
										center : new google.maps.LatLng(
												17.42114661764218,
												78.34432559252923),
										mapTypeId : google.maps.MapTypeId.ROADMAP
									};
									map = new google.maps.Map(document
											.getElementById("gmap_canvas"),
											myOptions);
									marker = new google.maps.Marker({
										map : map,
										position : new google.maps.LatLng(
												17.42114661764218,
												78.34432559252923)
									});
									infowindow = new google.maps.InfoWindow(
											{
												content : "<b>Virtusa Consulting Services Pvt. Ltd.</b><br/>Nanakramguda, Gachibowli<br/>500032 Hyderabad"
											});
									google.maps.event.addListener(marker,
											"click", function() {
												infowindow.open(map, marker);
											});
									infowindow.open(map, marker);
								}
								google.maps.event.addDomListener(window,
										'load', init_map);
							</script>
						</td>
					</tr>
				</table>

				<p>
					<br />
					<br />
				</p>
				<br />
			</div>

		</div>
	</div>
	</center>
</body>
</html>

