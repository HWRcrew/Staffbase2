<%@page import="de.hwr.staffbase2.model.EmployeeFactory"%>
<%@page import="de.hwr.staffbase2.model.EmployeeDAOFactory"%>
<%@page import="de.hwr.staffbase2.model.Employee"%>
<%@page import="de.hwr.staffbase2.model.EmployeeDAO"%>
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
	<input id="navigationbutton" name="employee" type="button" value="Stellen" />
  <!-- end .navigationbar --></div>
  <div class="content">
  
  <%
  	String change = request.getParameter("change");
	EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
	Employee employee = EmployeeFactory.getInstance().getEmployee();
  
	employee = employeeDAO.find(Long.parseLong(change));
	
  %>
  
  <center>
    <form id="input_login" action="" method="post" name="login" target="_self">
		<label>ID </label>
		<input type="text" id="readonly" name="_id" readonly onfocus="this.blur();" value="<%=employee.getId()%>"/><br>
		<label>Name </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50"  value="<%=employee.getSurname()%>"/><br>
		<label>Vorname </label>
		<input id="userinputvalues" name="prename" type="text" maxlength="50" value="<%=employee.getPrename()%>"/><br>
		<label>Straße </label>
		<input id="userinputvalues" name="street" type="text" maxlength="50" value="<%=employee.getStreet()%>"/><br>
		<label>Postleitzahl </label>
		<input id="userinputvalues" name="zipcode" type="text" maxlength="50" value="<%=employee.getZipcode()%>"/><br>
		<label>Ort </label>
		<input id="userinputvalues" name="city" type="text" maxlength="50" value="<%=employee.getCity()%>"/><br> 
			<!-- show only: wages, department, place -->
			<div class="showonly">
			<label>Gehalt </label>
			<input type="text" id="showonlyvalues" name="_salary" readonly onfocus="this.blur();" value="<%=employee.getSalary()%>"/><br>
			<label>Abteilung </label>
			<input type="text" id="showonlyvalues" name="_department" readonly onfocus="this.blur();" value="<%=employee.getDepartment()%>"/><br>
			<label>Stelle </label>
			<input type="text" id="showonlyvalues" name="_job" readonly onfocus="this.blur();" value="<%=employee.getJob()%>"/><br>
			<!-- end .showonly --></div>
		<input id="button_large" name="submit" type="button" onclick="location.href='<%=request.getContextPath()%>/EmployeeController?update=1'" value="Speichern" /><br>
		<input id="button_large" name="edit" type="button" value="Konto bearbeiten" />
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>