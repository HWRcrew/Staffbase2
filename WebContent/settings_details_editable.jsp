<%@page import="de.hwr.staffbase2.model.Job"%>
<%@page import="de.hwr.staffbase2.model.JobDAOFactory"%>
<%@page import="de.hwr.staffbase2.model.JobDAO"%>
<%@page import="java.util.List"%>
<%@page import="de.hwr.staffbase2.model.DepartmentFactory"%>
<%@page import="de.hwr.staffbase2.model.Department"%>
<%@page import="de.hwr.staffbase2.model.DepartmentDAO"%>
<%@page import="de.hwr.staffbase2.model.DepartmentDAOFactory"%>
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
  
  	<!-- include the navigationbar -->
  <jsp:directive.include file="navigationbar.jsp" />
  
  <div class="content">
  
  	<center><div style="color:red">${errorMessage}</div></center>
  
  <%
  	String change = request.getParameter("change");
 	String edit = request.getParameter("edit");
  	System.out.println(change);
  	
	if(change != null && change.length()>0){
  	long changelong = Long.parseLong(change);

  	EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
	Employee employee = EmployeeFactory.getInstance().getEmployee();
	employee = employeeDAO.find(changelong);
	
  %>
  
  <center>
    <form id="input_update" action="EmployeeController?update=1" method="post" name="login">
		<label>ID </label>
		<input type="text" id="readonly" name="id" readonly onfocus="this.blur();" value="<%=employee.getId()%>"/><br>
		<label>Name* </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50"  value="<%=employee.getSurname()%>"/><br>
		<label>Vorname* </label>
		<input id="userinputvalues" name="prename" type="text" maxlength="50" value="<%=employee.getPrename()%>"/><br>
		<label>Straße* </label>
		<input id="userinputvalues" name="street" type="text" maxlength="50" value="<%=employee.getStreet()%>"/><br>
		<label>Postleitzahl* </label>
		<input id="userinputvalues" name="zipcode" type="text" maxlength="50" value="<%=employee.getZipcode()%>"/><br>
		<label>Ort* </label>
		<input id="userinputvalues" name="city" type="text" maxlength="50" value="<%=employee.getCity()%>"/><br> 
		<label>Gehalt* </label>
		<input type="text" id="userinputvalues" name="salary" value="<%=employee.getSalary()%>"/><br>
		<label>Abteilung* </label>
		<% if(employee.getDepartment() != null && !"1".equalsIgnoreCase(edit)){ %>
		<input type="text" id="userinputvalues" readonly="readonly" name="department" value="<%=employee.getDepartment().getName()%>"/><br>
		<%}else{
			DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
			List<Department> department = departmentDAO.find();
		%>
		<select name="selectdeparment" id="userinputvalues">
			<%for(Department d : department){ %>
			<option value="<%=d.getId()%>"><%=d.getName() %></option>
			<%} %>
		</select></br>
		<%} %>
		<label>Stelle* </label>
		<%if(employee.getJob() != null && !"1".equalsIgnoreCase(edit)){ %>		
		<input type="text" id="userinputvalues" readonly="readonly" name="job" value="<%=employee.getJob().getName()%>"/><br>
		<%}else{ 
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		List<Job> job = jobDAO.find();
		%>
		<select name="selectjob" id="userinputvalues">
			<%for(Job j : job){ %>
			<option value="<%=j.getId()%>"><%=j.getName() %></option>
			<%} %>
		</select></br>
		<%} %>
		<input id="button_large" name="submit" type="submit" value="Speichern" /><br>
    	</form>
    	<input id="button_large" name="edit" type="button" value="Konto bearbeiten" onclick="location.href='<%=request.getContextPath()%>/EmployeeController?change=<%=employee.getId()%>&edit=1'" />
			
			<%
  	}else{
			%>
	<center>
    <form id="input_insert" action="EmployeeController?insert=1" method="post" >
		<label>ID </label>
		<input type="text" id="readonly" name="id" readonly onfocus="this.blur();"/><br>
		<label>Name* </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50" value='${name}'/><br>
		<label>Vorname* </label>
		<input id="userinputvalues" name="prename" type="text" maxlength="50" value='${prename}'/><br>
		<label>Straße* </label>
		<input id="userinputvalues" name="street" type="text" maxlength="50" value='${street}'/><br>
		<label>Postleitzahl* </label>
		<input id="userinputvalues" name="zipcode" type="text" maxlength="50" value='${zipcode}'/><br>
		<label>Ort* </label>
		<input id="userinputvalues" name="city" type="text" maxlength="50" value='${city}'/><br> 
		<label>Gehalt* </label>
		<input type="text" id="userinputvalues" name="salary" value='${salary}'/><br>
		<label>Abteilung* </label>
		<%
			DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
			List<Department> department = departmentDAO.find();
		%>
		<select name="selectdeparment" id="userinputvalues">
			<%for(Department d : department){ %>
			<option value="<%=d.getId()%>"><%=d.getName() %></option>
			<%} %>
		</select></br>
		<label>Stelle* </label>
		<%
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		List<Job> job = jobDAO.find();
		%>
		<select name="selectjob" id="userinputvalues">
			<%for(Job j : job){ %>
			<option value="<%=j.getId()%>"><%=j.getName() %></option>
			<%} %>
		</select></br>
		<input id="button_large" name="submit" type="submit" value="Speichern" /><br>
    </form>
		<%
  	}
		%>
	</center>
		
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>