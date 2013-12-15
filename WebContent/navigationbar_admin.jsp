<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<link href="styles/staffbase_styles.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="userlog" style="float:right; margin-right:5dp">Hallo ${username}
<!-- end .userlog --></div>
</br>
  <div class="navigationbar">
  	<form action="NavigationController" method="post" name="navigation">
  		  
		<input id="navigationbutton" name="sign-out" type="submit" value="Abmelden" style="float:right" /> <!-- onclick="window.location.href='login.html'" -->
		
	</form>
  <!-- end .navigationbar --></div>

</body>
</html>