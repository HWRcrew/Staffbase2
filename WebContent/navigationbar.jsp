<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<link href="styles/staffbase_styles.css" rel="stylesheet" type="text/css" />
</head>

<body>

  <div class="navigationbar">
  	<form action="NavigationController" method="post" name="navigation">
		<input id="navigationbutton" name="sign-out" type="submit" value="Abmelden" style="float:right" /> <!-- onclick="window.location.href='login.html'" -->
		<input id="navigationbutton" name="account" type="submit" value="Konto" style="float:right; background-color: #47C824; color: #AC58FA"  />
		<input id="navigationbutton" name="employee" type="submit" value="Mitarbeiter" />
		<input id="navigationbutton" name="department" type="submit" value="Abteilung" />
		<input id="navigationbutton" name="place" type="submit" value="Stellen" />
	</form>
  <!-- end .navigationbar --></div>

</body>
</html>