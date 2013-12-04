<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="styles/staffbase_styles.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
  <div class="header">
    <input name="logo_staffbase" type="image" src="drawable/staffbase_logo.png" />
  <!-- end .header --></div>
  <div class="navigationbar">
	<input id="navigationbutton" name="sign-out" type="button" value="Abmelden" style="float:right"  onclick="location.href='<%=request.getContextPath()%>/LogoutController'"/> <!-- onclick="window.location.href='login.html'" -->
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824; color: #AC58FA"  />
	<input id="navigationbutton" name="employee" type="button" value="Mitarbeiter" onclick="location.href='<%=request.getContextPath()%>/EmployeeController'"/>
	<input id="navigationbutton" name="department" type="button" value="Abteilung" />
	<input id="navigationbutton" name="employee" type="button" value="Stellen" />
  <!-- end .navigationbar --></div>
  <div class="content">
    <form id="input_login" action="" method="post" name="login" target="_self">
   	  <center><input type="text" id="userinput" maxlength="50" placeholder="Nutzername"/></center>
      <center><input id="userinput" name="old_password" type="password" maxlength="50" placeholder="Altes Passwort"/></center>
	  <center><input id="userinput" name="new_password" type="password" maxlength="50" placeholder="Neues Passwort"/></center>
	  <center><input id="userinput" name="new_password_resume" type="password" maxlength="50" placeholder="Neues Passwort wiederholen"/></center>
      <center><input id="button" name="submit" type="button" value="Speichern" /></center>
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>