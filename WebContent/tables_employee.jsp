
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">

body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #42413C;
	margin: 0;
	padding: 0;
	color: #000;
	height: 920px;
}

/* ~~ Element-/Tag-Selektoren ~~ */
ul, ol, dl { /* Aufgrund von Abweichungen zwischen verschiedenen Browsern empfiehlt es sich, die Auff�llung und den Rand in Listen auf 0 einzustellen. Zu Konsistenzzwecken k�nnen Sie die gew�nschten Werte entweder hier oder in den enthaltenen Listenelementen (LI, DT, DD) eingeben. Beachten Sie, dass die hier eingegebenen Werte hierarchisch auf die .nav-Liste angewendet werden, sofern Sie keinen spezifischeren Selektor festlegen. */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* Durch Verschieben des oberen Rands wird das Problem behoben, dass R�nder aus dem zugeh�rigen div-Tag geraten k�nnen. Der �brig gebliebene untere Rand h�lt ihn getrennt von allen folgenden Elementen. */
	padding-right: 15px;
	padding-left: 15px; /* Durch Hinzuf�gen der Auff�llung zu den Seiten der Elemente innerhalb der div-Tags anstelle der div-Tags selbst entfallen jegliche Box-Modell-Berechnungen. Alternativ kann auch ein verschachteltes div-Tag mit seitlicher Auff�llung verwendet werden. */
}
a img { /* Dieser Selektor entfernt den standardm��igen blauen Rahmen, der in einigen Browsern um ein Bild angezeigt wird, wenn es von einem Hyperlink umschlossen ist. */
	border: none;
}
/* ~~ Die Reihenfolge der Stildefinitionen f�r die Hyperlinks der Site, einschlie�lich der Gruppe der Selektoren zum Erzeugen des Hover-Effekts, muss erhalten bleiben. ~~ */
a:link {
	color: #42413C;
	text-decoration: underline; /* Sofern Ihre Hyperlinks nicht besonders hervorgehoben werden sollen, empfiehlt es sich, zur schnellen visuellen Erkennung Unterstreichungen zu verwenden. */
}
a:visited {
	color: #6E6C64;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* Durch diese Gruppe von Selektoren wird bei Verwendung der Tastatur der gleiche Hover-Effekt wie beim Verwenden der Maus erzielt. */
	text-decoration: none;
}

/* ~~ Dieser Container mit fester Breite umschlie�t alle anderen Elemente. ~~ */
.container {
	width: 960px;
	background-color: #FFF; /* Der mit der Breite gekoppelte automatische Wert an den Seiten zentriert das Layout. */
	border: 2px solid #000;
	height: 800px;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}

/* ~~ Dies sind die Layoutinformationen. ~~ 

1) Eine Auff�llung wird nur oben und/oder unten im div-Tag positioniert. Die Elemente innerhalb dieses div-Tags verf�gen �ber eine seitliche Auff�llung. Dadurch m�ssen Sie keine Box-Modell-Berechnungen durchf�hren. Zu beachten: Wenn Sie dem div-Tag eine seitliche Auff�llung oder einen Rahmen hinzuf�gen, werden diese zu der festgelegten Breite addiert und ergeben die *gesamte* Breite. Sie k�nnen auch die Auff�llung f�r das Element im div-Tag entfernen und ein zweites div-Tag ohne Breite und mit der gew�nschten Auff�llung im ersten div-Tag einf�gen.

*/
.content {
	padding: 10px 0;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}

/* ~~ Verschiedene float/clear-Klassen ~~ */
.fltrt {  /* Mit dieser Klasse k�nnen Sie ein Element auf der Seite nach rechts flie�en lassen. Das flie�ende Element muss vor dem Element stehen, neben dem es auf der Seite erscheinen soll. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* Mit dieser Klasse k�nnen Sie ein Element auf der Seite nach links flie�en lassen. Das flie�ende Element muss vor dem Element stehen, neben dem es auf der Seite erscheinen soll. */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* Diese Klasse kann in einem <br />-Tag oder leeren div-Tag als letztes Element nach dem letzten flie�enden div-Tag (im #container) platziert werden, wenn overflow:hidden im .container entfernt wird. */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
.header {
	background-color: #FFF;
	text-align: center;
	vertical-align: top;
	display: block;
	float: none;
	height: auto;
	width: auto;
	border-top-color: #000;
	border-right-color: #000;
	border-bottom-color: #000;
	border-left-color: #000;
	border-bottom-width: 2px;
	border-bottom-style: solid;
}

.navigationbar {
	width: 960px;
	background-color: #D0D0D0;
	border-bottom: 2px solid #787878;
	height: 50px;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}

#input_login {
	vertical-align: middle;
	display: block;
	font-style: italic;
	position: static;
	height: auto;
	width: auto;
	left: auto;
	right: auto;
	margin: auto;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#userinput {
	height: 32px;
	width: 256px;
	background-image: url(drawable/input_border.png);
	font-family: "Courier New", Courier, monospace;
	font-style: italic;
	font-size: 12px;
	background-repeat: no-repeat;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 3px;
	padding-right: 5px;
	padding-bottom: 3px;
	padding-left: 5px;
	text-align: center;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#userinputvalues {
	height: 32px;
	width: 256px;
	background-image: url(drawable/input_border_grey_inside.png);
	font-family: "Courier New", Courier, monospace;
	font-style: italic;
	font-size: 12px;
	float: center;
	background-repeat: no-repeat;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 3px;
	padding-right: 5px;
	padding-bottom: 3px;
	padding-left: 5px;
	text-align: center;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#readonly {
	height: 32px;
	width: 256px;
	background-image: url(drawable/input_border_dkgrey_inside.png);
	font-family: "Courier New", Courier, monospace;
	font-style: italic;
	font-size: 12px;
	float: center;
	background-repeat: no-repeat;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 3px;
	padding-right: 5px;
	padding-bottom: 3px;
	padding-left: 5px;
	text-align: center;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#readonly_small {
	height: 32px;
	width: 128px;
	background-image: url(drawable/input_border_small.png);
	font-family: "Courier New", Courier, monospace;
	font-style: italic;
	font-size: 12px;
	float: center;
	background-repeat: no-repeat;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 3px;
	padding-right: 5px;
	padding-bottom: 3px;
	padding-left: 5px;
	text-align: center;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#button {
	font-family: Verdana, Geneva, sans-serif;
	font-style: italic;
	color: #000;
	margin: 10px;
	background-image: url(drawable/btn_background.png);
	height: 32px;
	width: 164px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#button_large {
	font-family: Verdana, Geneva, sans-serif;
	font-style: italic;
	color: #000;
	margin: 10px;
	background-image: url(drawable/btn_background_large.png);
	height: 48px;
	width: 380px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#button_edit {
	font-family: Verdana, Geneva, sans-serif;
	font-style: italic;
	color: #000;
	margin: 10px;
	background-image: url(drawable/btn_background_edit.png);
	height: 32px;
	width: 164px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
#navigationbutton {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 16px;
	color: #000;
	float: left;
	font-weight: bold;
	background-color: #D0D0D0;
	height: 50px;
	width: auto;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
label {
    display: inline-block;
    vertical-align: baseline;
    width: 100px;
	font-weight: bold;
}
bottom {
	position:absolute;
    bottom:25px;
	right: 325px;
	float:right;	
}

#navigationbutton:hover { background-color: #A4A4A4;}
#button:active { background-image: url(drawable/btn_background_clicked.png);}
#button_edit:active { background-image: url(drawable/btn_background_edit_clicked.png);}

</style></head>

<body>

<div class="container">
  <div class="header">
    <input name="logo_staffbase" type="image" src="drawable\staffbase_logo.png" />
  <!-- end .header --></div>
  <div class="navigationbar">
	<input id="navigationbutton" name="sign-out" type="button" value="Abmelden" style="float:right"  /> <!-- onclick="window.location.href='login.html'" -->
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824;"  />
    <input id="navigationbutton" name="employee" type="button" value="Mitarbeiter" style="color: #AC58FA"/>
	<input id="navigationbutton" name="department" type="button" value="Abteilung" />
	<input id="navigationbutton" name="employee" type="button" value="Stellen" />
  <!-- end .navigationbar --></div>
  <div class="content">
  <center>
     <table border="0">
	 <th>ID</th>
	 <th>Name</th>
     <th>Vorname</th>
	 <th>Monatsgehalt</th>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" /></td>
	  </tr>
  </table>
	</center>
    <bottom>
    <input id="button" name="new_employsee" type="button" value="Neuer Mitarbeiter"/>
    </bottom>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>