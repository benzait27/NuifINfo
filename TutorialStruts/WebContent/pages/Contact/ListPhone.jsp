<%@page import="org.lip6.struts.domain.DAOContact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="org.lip6.struts.domain.Contact.*"%>
<%@page import="org.lip6.struts.domain.Phone.*"%>
<%@page import="org.lip6.struts.actionForm.Contact.*"%>
<%@page import="java.util.Iterator"%>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib prefix="s" uri="http://struts.apache.org/tags-nested" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="content-type" content="text/html; charset=windows-1252">
<meta name="keywords" content="website keywords, website keywords">
<meta name="description" content="website description">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



    <div class="page-header">
      <div >
        <ul  class="nav nav-pills nav-justified">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li  ><a href="Group.do"><bean:message key="main.Group.link"/></a> </li>
          <li  class="active"><a href="ContactMain.do"><bean:message key="main.contact.link"/></a></li>
          <li ><a href="Phone.do"><bean:message key="main.Phone.link"/></a> </li>
          <li ><a href="contact.html">Contact Us</a></li>
        </ul>
      </div>
    </div>
<div class="container-fluid">
 <div class="row" align="left">
  <div class="col-lg-4" >
    <div class="input-group">
      </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
      <html:form action="/SearchPhone" >
 <div class="col-lg-4" align="left">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-default" >Search</button>
      </span>
      <input  class="form-control"  name="search">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->

</html:form>
 </div>
 
  <div> <h1></h1>
 
   </div>
 <div class="panel panel-info">
  
   <div class="panel-heading"> <h1>Phone's List :</h1>
 
   </div>


<div class="table-responsive">
<table  class="table table-striped" >

<thead>
                        
<tr><th>Edit</th><th>Kind</th><th>Phone number</th></tr> </thead>
 <tbody>
<%
DAOContact cs =new DAOContact();


ArrayList<Object> maListe = (ArrayList<Object>) cs.SearchPhoneList((int)request.getAttribute("num")); 

for(Iterator<Object> it = maListe.iterator(); it.hasNext();)
{   Object m =it.next();
    Object m2 = it.next();
	

%>
<tr>

<html:form action="/FormwardEditPhonee">
<th>
<button class="btn btn-warning">Edit</button>
</th>
<input type="hidden" value="<%out.print((int)request.getAttribute("num"));%>" name="idC" />
 <input type="hidden" value="<%out.print(m);%>" name="kind" />
  <input type="hidden" value="<%out.print(m2);%>" name="num" />
 </html:form>
 
<th><%  out.print(m) ;%></th> 
<th><%  out.print(m2);%></th>


  <html:form action="/DeletePhoneC">
   <th>
  <button  class="btn btn-danger" >Delete</button>
   </th>

     <input type="hidden" value="<%out.print(m);%>" name="kind" />
      <input type="hidden" value="<%out.print(m2);%>" name="num" />
      <input type="hidden" value="<%out.print((int)request.getAttribute("num"));%>" name="idC" />
   </html:form>
 <%}%>
 </tbody>         
</table>
</div>
</div>  
 
   <div> <h1></h1>
  <div class="row" >
    <div class="col-lg-4" align="left">
    <div class="input-group">
      <p><a href="ContactMain.do">Home</a> </p>
    </div>
    <p>&nbsp;</p>
     </div>
     </div> 
    </div>

<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


</body>
</html>

































  	