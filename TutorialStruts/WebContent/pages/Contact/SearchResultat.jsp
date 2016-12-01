<%@page import="org.lip6.struts.domain.DAOContact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="org.lip6.struts.domain.Contact.*"%>
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
      <html:form action="/Search" >
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
 
    <div class="row" align="left">

 <div class="col-lg-4" align="left">
    <div class="input-group">
      <span class="input-group-btn">
     
        <a href="CreerContact.do" class="btn btn-info">Add new contact</a>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->


 </div>
  <div> <h1></h1>
 
   </div>
 <div class="panel panel-info">
  
   <div class="panel-heading"> <h1>Contact List :</h1>
 
   </div>


<div class="table-responsive">
<table  class="table table-striped" >

<thead>
                        
<tr><th>Edit</th><th>Add Phone</th><th>See Phones list</th><th>ID</th><th>Nom</th><th>Prenom</th><th>Email</th><th>Street</th><th>City</th><th>Zip</th><th>Country</th><th>Delete</th></tr>
 </thead>
 <tbody>
<%
ArrayList<Contact> maListe = (ArrayList<Contact>) request.getAttribute("list");
 for(Iterator<Contact> it = maListe.iterator(); it.hasNext();)
 {
     Contact c = it.next();

%>
<tr>
<html:form action="/FormwardEdit">
<th>
<button class="btn btn-warning">Edit</button>
</th>
 <input type="hidden" value="<%out.print(c.getNum());%>" name="num" />
 </html:form>
<html:form action="/FormwardAddPhone">
<th>
<button class="btn btn-success" >Add Phone</button>
</th>
 <input type="hidden" value="<%out.print(c.getNum());%>" name="num" />
 </html:form>
 
<html:form action="/SeePhone">
<th>
<button class="btn btn-info">See Phones List</button>
</th>
 <input type="hidden" value="<%out.print(c.getNum());%>" name="num" />
 </html:form>
 
<th><% out.print(c.getNum());%></th> 
<th><% out.print(c.getNom());%></th>
<td><% out.print(c.getPrenom());%></td>
<td><% out.print(c.getMail());%>
<th><% String msg = c.getAd().getStreet();
      if(msg==null)out.print("");
      else out.print(msg);%></th> 
<th><%  msg = c.getAd().getCity();
      if(msg==null)out.print("");
      else out.print(msg);%></th>
<td><% msg = c.getAd().getZip();
      if(msg==null)out.print("");
      else out.print(msg);%></td>
<td><%  msg = c.getAd().getContry();
      if(msg==null)out.print("");
      else out.print(msg);%>
</td>


 <html:form action="/DeleteContact">
   <th>
   <button  class="btn btn-danger" >Delete</button>
   </th>
   <input type="hidden" value="<%out.print(c.getNum());%>" name="num" />

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
      <p><a href="Main.do">Home</a> </p>
    </div>
    <p>&nbsp;</p>
     </div>
     </div> 
    </div>
  

   

<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>












</body>
</html>

































  	