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
ul, ol, dl { /* Aufgrund von Abweichungen zwischen verschiedenen Browsern empfiehlt es sich, die Auffüllung und den Rand in Listen auf 0 einzustellen. Zu Konsistenzzwecken können Sie die gewünschten Werte entweder hier oder in den enthaltenen Listenelementen (LI, DT, DD) eingeben. Beachten Sie, dass die hier eingegebenen Werte hierarchisch auf die .nav-Liste angewendet werden, sofern Sie keinen spezifischeren Selektor festlegen. */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* Durch Verschieben des oberen Rands wird das Problem behoben, dass Ränder aus dem zugehörigen div-Tag geraten können. Der übrig gebliebene untere Rand hält ihn getrennt von allen folgenden Elementen. */
	padding-right: 15px;
	padding-left: 15px; /* Durch Hinzufügen der Auffüllung zu den Seiten der Elemente innerhalb der div-Tags anstelle der div-Tags selbst entfallen jegliche Box-Modell-Berechnungen. Alternativ kann auch ein verschachteltes div-Tag mit seitlicher Auffüllung verwendet werden. */
}
a img { /* Dieser Selektor entfernt den standardmäßigen blauen Rahmen, der in einigen Browsern um ein Bild angezeigt wird, wenn es von einem Hyperlink umschlossen ist. */
	border: none;
}
/* ~~ Die Reihenfolge der Stildefinitionen für die Hyperlinks der Site, einschließlich der Gruppe der Selektoren zum Erzeugen des Hover-Effekts, muss erhalten bleiben. ~~ */
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

/* ~~ Dieser Container mit fester Breite umschließt alle anderen Elemente. ~~ */
.container {
	width: 960px;
	background-color: #FFF; /* Der mit der Breite gekoppelte automatische Wert an den Seiten zentriert das Layout. */
	border: 2px solid #000;
	height: 1200px;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}

/* ~~ Dies sind die Layoutinformationen. ~~ 

1) Eine Auffüllung wird nur oben und/oder unten im div-Tag positioniert. Die Elemente innerhalb dieses div-Tags verfügen über eine seitliche Auffüllung. Dadurch müssen Sie keine Box-Modell-Berechnungen durchführen. Zu beachten: Wenn Sie dem div-Tag eine seitliche Auffüllung oder einen Rahmen hinzufügen, werden diese zu der festgelegten Breite addiert und ergeben die *gesamte* Breite. Sie können auch die Auffüllung für das Element im div-Tag entfernen und ein zweites div-Tag ohne Breite und mit der gewünschten Auffüllung im ersten div-Tag einfügen.

*/
.content {
	padding: 10px 0;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}

/* ~~ Verschiedene float/clear-Klassen ~~ */
.fltrt {  /* Mit dieser Klasse können Sie ein Element auf der Seite nach rechts fließen lassen. Das fließende Element muss vor dem Element stehen, neben dem es auf der Seite erscheinen soll. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* Mit dieser Klasse können Sie ein Element auf der Seite nach links fließen lassen. Das fließende Element muss vor dem Element stehen, neben dem es auf der Seite erscheinen soll. */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* Diese Klasse kann in einem <br />-Tag oder leeren div-Tag als letztes Element nach dem letzten fließenden div-Tag (im #container) platziert werden, wenn overflow:hidden im .container entfernt wird. */
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
#navigationbutton:hover { background-color: #A4A4A4;}
#button:active { background-image: url(drawable/btn_background_clicked.png);}



</style></head>

<body>

<div class="container">
  <div class="header">
    <input name="logo_staffbase" type="image" src="drawable\staffbase_logo.png" />
  <!-- end .header --></div>
  <div class="navigationbar">
	<input id="navigationbutton" name="sign-out" type="button" value="Abmelden" style="float:right"  onclick="location.href='<%=request.getContextPath()%>/LogoutController'"/> <!-- onclick="window.location.href='login.html'" -->
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824; color: #AC58FA"  />
	<input id="navigationbutton" name="employee" type="button" value="Mitarbeiter" />
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