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
  <div class="content">
  <center><div style="color:red">${errorMessage}</div></center> <!-- error when user enters a false username and passwort combination-->
    <form id="input_login" action="LoginController" method="post" name="login">
   	  <center><input id="userinput" name="username" type="text" maxlength="50" placeholder="Nutzername"/></center>
      <center><input id="userinput" name="password" type="password" maxlength="50" placeholder="Passwort"/></center>
      <center><input id="button" name="submit" type="submit" value="Anmelden" /></center>
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>