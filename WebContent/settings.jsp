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
  
  	<!-- include the navigationbar -->
  	<%
  		boolean isAdmin = false;
  		try{
  			isAdmin = (Boolean) request.getSession().getAttribute("admin");
  		}catch(Exception e){}
  		boolean isManager = (Boolean) request.getSession().getAttribute("manager");
  		if(isManager && !isAdmin){
  	%>
  		<jsp:directive.include file="navigationbar.jsp" />
  	<%
  		}else if(isManager && isAdmin){
  	%>
  		<jsp:directive.include file="navigationbar_admin.jsp" />
  	<%
  		}else{
  	%>
  		<jsp:directive.include file="navigationbar_acc.jsp" />
  	<% 
  		} 
  	%>
  
  <center><p>Konto bearbeiten:</p></center>
  
  <div class="content">
  
  		<center><div style="color:red">${errorMessage}</div></center>
  	
    <form id="input_login" action="AccountController?pwedit=1" method="post" name="login" target="_self">
   	  <center><input type="text" name="username" id="showonlyvalues" maxlength="50" placeholder="" value="${username}" onfocus="this.blur();"/></center>
      <center><input id="userinput" name="old_password" type="password" maxlength="50" placeholder="Altes Passwort *"/></center>
	  <center><input id="userinput" name="new_password" type="password" maxlength="50" placeholder="Neues Passwort *"/></center>
	  <center><input id="userinput" name="new_password_resume" type="password" maxlength="50" placeholder="Neues Passwort wiederholen *"/></center>
      <center><input id="button" name="submit" type="submit" value="Speichern" /></center>
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>