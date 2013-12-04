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
	<input id="navigationbutton" name="sign-out" type="button" value="Abmelden" style="float:right"  /> <!-- onclick="window.location.href='login.html'" -->
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824;;"  />
  <!-- end .navigationbar --></div>
  <div class="content">
  <center>
    <form id="input_login" action="" method="post" name="login" target="_self">
		<label>ID </label>
		<input type="text" id="readonly" name="_id" readonly onfocus="this.blur();"/><br>
		<label>Name </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50" /><br>
		<label>Vorname </label>
		<input id="userinputvalues" name="prename" type="text" maxlength="50" /><br>
		<label>Straße </label>
		<input id="userinputvalues" name="street" type="text" maxlength="50" /><br>
		<label>Postleitzahl </label>
		<input id="userinputvalues" name="postal_code" type="text" maxlength="50" /><br>
		<label>Ort </label>
		<input id="userinputvalues" name="place" type="text" maxlength="50" /><br> 
			<!-- show only: wages, department, place -->
			<div class="showonly">
			<label>Gehalt </label>
			<input type="text" id="showonlyvalues" name="_wages" readonly onfocus="this.blur();"/><br>
			<label>Abteilung </label>
			<input type="text" id="showonlyvalues" name="_department" readonly onfocus="this.blur();"/><br>
			<label>Stelle </label>
			<input type="text" id="showonlyvalues" name="_place" readonly onfocus="this.blur();"/><br>
			<!-- end .showonly --></div>
		<input id="button_large" name="submit" type="button" value="Speichern" />
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>