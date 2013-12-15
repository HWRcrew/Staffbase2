
<%@page import="de.hwr.staffbase2.model.Job"%>
<%@page import="java.util.List"%>
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
  <%
  JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
  List<Job> joblist = jobDAO.find();
  %>
     <table border="0">
	 <th>ID</th>
	 <th>Name</th>
	 <th>Monatsgehalt</th>
	 <%
	 for(Job j : joblist){
	 %>
	  <tr>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=j.getId() %>"/></td>
		<td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=j.getName() %>"/></td>
        <td><input id="readonly_small" type="text" readonly onfocus="this.blur();" value="<%=j.getSalary() %>"/></td>
		<td><input id="button_edit" type="button" value="Bearbeiten" onclick="location.href='<%=request.getContextPath()%>/JobController?change=<%=j.getId()%>'"/></td>
	  </tr>
	  <% 
	  }
	  %>
  </table>
	</center>
		<div class="align_right">
    		<input id="button" name="new_position" type="button" value="Neue Stelle" style=""  onclick="location.href='<%=request.getContextPath()%>/JobController?change='"/>
		</div>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>