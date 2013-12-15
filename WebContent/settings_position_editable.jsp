<%@page import="de.hwr.staffbase2.model.JobFactory"%>
<%@page import="de.hwr.staffbase2.model.Job"%>
<%@page import="de.hwr.staffbase2.model.JobDAOFactory"%>
<%@page import="de.hwr.staffbase2.model.JobDAO"%>
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
  <center>
  	<center><div style="color:red">${errorMessage}</div></center>
  
  <%
  String change = request.getParameter("change");
  if(change.length()>0 && change != null){
  long changelong = Long.parseLong(change);
  JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
  Job job = jobDAO.find(changelong);
  
  %>
		<form id="input_login" action="JobController?update=1" method="post" name="login" target="_self">
		<label>ID </label>
		<input type="text" id="readonly" name="_id" readonly onfocus="this.blur();" value="<%=job.getId()%>"/><br>
		<label>Name* </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50" value="<%=job.getName()%>"/><br>
		<label>Gehalt* </label>
		<input id="userinputvalues" name="salary" type="text" maxlength="50" value="<%=job.getSalary()%>"/><br>
		<label>Beschreibung* </label>
		<textarea id="userinputvalues_rich" name="description" cols="25" rows="5" ><%=job.getDescription()%></textarea><br>
	<%
  }else{
	  
	%>
		<form id="input_login" action="JobController?insert=1" method="post" name="login" target="_self">
		<label>ID </label>
		<input type="text" id="readonly" name="_id" readonly onfocus="this.blur();"/><br>
		<label>Name* </label>
		<input id="userinputvalues" name="name" type="text" maxlength="50" value='${name}'/><br>
		<label>Gehalt* </label>
		<input id="userinputvalues" name="salary" type="text" maxlength="50" value='${salary}'/><br>
		<label>Beschreibung* </label>
		<textarea id="userinputvalues_rich" name="description" cols="25" rows="5" >${description}</textarea><br>
	<%
  }
	%>	
		<input id="button_large" name="submit" type="submit" value="Speichern" /><br>
    </form>
	</center>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>