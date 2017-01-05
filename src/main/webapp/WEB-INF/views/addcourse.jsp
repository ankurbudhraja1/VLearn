<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/images/style.css" />
<link rel="stylesheet" type="text/css" href="resources/css3/reset.css">
<link rel="stylesheet" type="text/css"
	href="resources/css3/structure.css">
<title>Add a Course</title>

<script>
function
validateForm() {
 
var x = document.forms["myForm"]["name"].value;
 
if (x == null || x == "") {
alert(
"Name must be filled");
 
return false;
}
 
var x = document.forms["myForm"]["description"].value;
 
if (x == null || x == "") {
alert(
"Description must be filled");
 
return false;
}

var x = document.forms["myForm"]["date"].value;

if (x == null || x == "") {
alert(
"Exam Date must be filled");
 
return false;
}
 
var x = document.forms["myForm"]["time"].value;
 
if (x == null || x == "") {
alert(
"Exam Time must be filled");
 
return false;
}
 
var x = document.forms["myForm"]["venue"].value;
 
if (x == null || x == "") {
alert(
"Exam Venue must be filled");
 
return false;
}

var x = document.forms["myForm"]["fileUpload1"].value;
 
if (x == null || x == "") {
alert(
"Upload atleast first material");
 
return false;
}

var time = document.forms["myForm"]["time"].value;
var regex = /^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
if(!regex.test(time)){
alert(
"Enter a valid time");
return false;
}

var fileUpload1 = document.forms["myForm"]["fileUpload1"].value;
var regex = /([a-zA-Z0-9\w()\s_\\.\-:])+(.pdf)$/;
if(!regex.test(fileUpload1)){
alert(
"Upload pdf file only");
return false;
}

var fileUpload2 = document.forms["myForm"]["fileUpload2"].value;
var regex = /(^$|^([a-zA-Z0-9\w()\s_\\.\-:])+(.pdf))$/;
if(!regex.test(fileUpload2)){
alert(
"Upload2 pdf file only");
return false;
}


var fileUpload3 = document.forms["myForm"]["fileUpload3"].value;
var regex = /^$|^([a-zA-Z0-9\w()\s_\\.\-:])+(.pdf)$/;
if(!regex.test(fileUpload3)){
alert(
"Upload3 pdf file only");
return false;
}

var date= document.forms["myForm"]["date"].value;
var regex=/^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/;
if(!regex.test(date)){
alert(
"Enter a valid  date");
return false;
}

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
					<p style="color: #fff; padding-left: 0px; padding-top: 55px;">Virtusa
						V-Learn</p>
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

				<h1 id="ha">
					<br>Add a Course
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

				<form action="addcourseprocess" method="post" name="myForm"
					class="box add" enctype="multipart/form-data"
					onsubmit="return validateForm();">
					<fieldset class="boxBody">

						<label>Name</label><input type="text" name="name" tabindex="1"
							maxlength="30"> <label>Description</label> <input
							type="text" name="description" tabindex="1" maxlength="4000">

						<label>Exam Date (yyyy-mm-dd)</label> <input type="text"
							name="date" tabindex="2"> <label>Exam Time
							(hh:mm)</label> <input type="text" name="time" tabindex="3"> <label>Exam
							Venue</label> <input type="text" name="venue" tabindex="4"
							maxlength="1000"> <label>Material 1</label><input
							type="file" name="fileUpload1" tabindex="5" size="20"> <label>Material
							2</label> <input type="file" name="fileUpload2" tabindex="6" size="20">

						<label>Self-assessment material</label><input type="file"
							name="fileUpload3" tabindex="7" size="20"> <label>Enabler
							ID</label> <input type="text" name="e_id" value="${e_id }" readonly
							tabindex="8">
					</fieldset>

					<font color="#FF3300">*All Materials should be uploaded in
						pdf format only<br>*Atleast Material 1 should be uploaded
					</font>
					<footer>
						<input type="submit" class="btnAdd" value="Add" tabindex="4">

					</footer>
				</form>
			</div>
		</div>
	</div>



</body>
</html>