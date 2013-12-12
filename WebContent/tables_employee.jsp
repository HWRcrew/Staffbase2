
<%@page import="java.util.List"%>
<%@page import="de.hwr.staffbase2.model.EmployeeDAOFactory"%>
<%@page import="de.hwr.staffbase2.model.EmployeeDAO"%>
<%@page import="de.hwr.staffbase2.model.EmployeeFactory"%>
<%@page import="de.hwr.staffbase2.model.Employee"%>
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
	<input id="navigationbutton" name="sign-out" type="button" value="Abmelden" style="float:right"  onclick="location.href='<%=request.getContextPath()%>/LogoutController'" /> <!-- onclick="window.location.href='login.html'" -->
	<input id="navigationbutton" name="account" type="button" value="Konto" style="float:right; background-color: #47C824;"  />
    <input id="navigationbutton" name="employee" type="button" value="Mitarbeiter" style="color: #AC58FA"/>
	<input id="navigationbutton" name="department" type="button" value="Abteilung" onclick="location.href='<%=request.getContextPath()%>/DepartmentController'"/>
	<input id="navigationbutton" name="employee" type="button" value="Stellen" onclick="location.href='<%=request.getContextPath()%>/JobController'"/>
  <!-- end .navigationbar --></div>
  <div class="content">
  <center>
     <table border="0">
	 <th>ID</th>
	 <th>Name</th>
     <th>Vorname</th>
	 <th>Monatsgehalt</th>
	 <%
	 EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
	 Employee employee = EmployeeFactory.getInstance().getEmployee();
	 
	 List<Employee> emp = employeeDAO.find();
	 
	 for(Employee e : emp){
	 
	 
	 %>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=e.getId()%>"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=e.getSurname()%>"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=e.getPrename()%>"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=e.getSalary()%>"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten"  onclick="location.href='<%=request.getContextPath()%>/EmployeeController?change=<%=e.getId()%>'"/></td>
	  </tr>
	 <%
	 }
	 %>
  </table>
	</center>
    <bottom>
    <input id="button" name="new_employsee" type="button" value="Neuer Mitarbeiter" onclick="location.href='<%=request.getContextPath()%>/EmployeeController?insert=1'"/>
    </bottom>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>