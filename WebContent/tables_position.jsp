
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
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824;"  />
    <input id="navigationbutton" name="employee" type="button" value="Mitarbeiter" />
	<input id="navigationbutton" name="department" type="button" value="Abteilung" />
	<input id="navigationbutton" name="employee" type="button" value="Stellen" style="color: #AC58FA"/>
  <!-- end .navigationbar --></div>
  <div class="content">
  <center>
     <table border="0">
	 <th>ID</th>
	 <th>Name</th>
	 <th>Monatsgehalt</th>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
  </table>
	</center>
    <bottom>
    <input id="button" name="new_position" type="button" value="Neue Stelle"/>
    </bottom>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>