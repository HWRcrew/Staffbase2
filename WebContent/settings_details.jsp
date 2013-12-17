<%@page import="de.hwr.staffbase2.model.Employee"%>
<%@page import="de.hwr.staffbase2.model.EmployeeFactory"%>
<%@page import="de.hwr.staffbase2.model.EmployeeDAOFactory"%>
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
 	
  <div class="content">
  <%
  	String change = request.getParameter("change");
  	System.out.println(change);
	EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
	Employee employee = EmployeeFactory.getInstance().getEmployee();
  	long changelong = Long.parseLong(change);
	employee = employeeDAO.find(changelong);
	
  %>
  
  <center>
    <form id="input_login" action="EmployeeController?edit=1" method="post" name="login">
		<label>ID </label>
		<input type="text" id="readonly" name="id" readonly onfocus="this.blur();" value="<%=employee.getId()%>"/><br>
		<label>Name </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50" onfocus="this.blur();"  value="<%=employee.getSurname()%>"/><br>
		<label>Vorname </label>
		<input id="userinputvalues" name="prename" type="text" maxlength="50" onfocus="this.blur();" value="<%=employee.getPrename()%>"/><br>
		<label>Straße </label>
		<input id="userinputvalues" name="street" type="text" maxlength="50" onfocus="this.blur();" value="<%=employee.getStreet()%>"/><br>
		<label>Postleitzahl </label>
		<input id="userinputvalues" name="zipcode" type="text" maxlength="50" onfocus="this.blur();" value="<%=employee.getZipcode()%>"/><br>
		<label>Ort </label>
		<input id="userinputvalues" name="city" type="text" maxlength="50" onfocus="this.blur();" value="<%=employee.getCity()%>"/><br> 
			<!-- show only: wages, department, place -->
			
			<div class="showonly">
			
			<label>Gehalt </label>
			<input type="text" id="showonlyvalues" name="_salary" readonly onfocus="this.blur();" value="<%=employee.getSalary() %>"/><br>
			<label>Abteilung </label>
			<% if(employee.getDepartment() != null){ %>
			<input type="text" id="showonlyvalues" name="_department" readonly onfocus="this.blur();" value="<%=employee.getDepartment().getName() %>"/><br>
			<% }else{ %>
			<input type="text" id="showonlyvalues" name="_department" readonly onfocus="this.blur();" value=""/><br>
			<% } %>
			<label>Stelle </label>
			<% if(employee.getJob() != null){ %>
			<input type="text" id="showonlyvalues" name="_job" readonly onfocus="this.blur();" value="<%=employee.getJob().getName() %>"/><br>
			<% }else{ %>
			<input type="text" id="showonlyvalues" name="_job" readonly onfocus="this.blur();" value=""/><br>
			<% } %>
			<!-- end .showonly --></div>
		
		<input id="button_large" name="edit" type="submit" value="Konto bearbeiten" />
    </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>