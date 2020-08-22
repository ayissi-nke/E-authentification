<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/signup.css" rel="stylesheet" type="text/css" media="all" />
 <style><%@include file="/WEB-INF/css/signup.css"%></style>
<!-- //Custom Theme files -->
<!-- web font -->
<!--  <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet"> -->

<!-- //web font -->
<title>Insert title here</title>
</head>
<body>
<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Creative SignUp Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="#" method="post" action="SignUp" >
				     <span>${resultat}  </span> 
					<input class="text" type="text" name="name" id="nom" placeholder="username" required="">
					<span >${form.error["name"]}</span>
					
					<input class="text email" type="email" name="email" id="email"  placeholder="Email" required="" value="<c:out value="${user.email}"/>" >
					<span>${form.error["email"]}</span>
					
					<input class="text" type="password" name="password" id="password" placeholder="Password" required="" value="<c:out value="${user.password}"/>">
					
					<input class="text" type="password" name="confirmation" id="confirmation" placeholder="confirmation" required="">
					<span >${form.error["password"]}</span>
					
					<input class="text w3lpass" type="text" name="phonenumber" id="phonenumber" placeholder="phone number"  required >
					<div class="wthree-text">
						<label class="anim">
						</label>
						<div class="clear"> </div>
					</div>
					<input type="submit" value="SIGNUP">
				</form>
				<p>Don't have an Account? <a href="#"> Login Now!</a></p>
			</div>
		</div>
		<!-- copyright -->
		<div class="colorlibcopy-agile">
			<p>© 2019  Design by NELLY & AYISSI </p>
		</div>
		<!-- //copyright -->
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>  
		</ul>
	</div>
	<!-- //main -->
</body>
</html>