<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="org.lip6.struts.domain.Contact.*"%>
<%@page import="org.lip6.struts.domain.*"%>  
<%@page import="java.util.ArrayList"%>
  
   <html:html>

   <head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="content-type" content="text/html; charset=windows-1252">
<meta name="keywords" content="website keywords, website keywords">
<meta name="description" content="website description">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title><bean:message key="add.contact"/></title>

   <html:base/>
<style type="text/css">
            .error {
                display: #a94442;
  width: 100%;
  height: 34px;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  color: #a94442;
  background-color: #f2dede;
  background-image: none;
  border: 1px solid #a94442;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
          box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
       -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
          transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            }
        </style>
   </head>

   <body bgcolor="white" >
    <div class="panel-heading" > <h1></h1>
 
   </div>

 <div class="container"  >
 <div class="col-sm-2"  > </div>
 <div class="col-sm-8"  > 
 <div class="panel panel-info" >
  
   <div class="panel-heading" > <h1>Please edit the Information below :</h1>
 
   </div>
   <h1></h1>

    <html:form action="/EditGroup" styleClass="form-horizontal" >
     <% Group cd = (Group)request.getAttribute("num");%>
     
     <label for="inputEmail3" class="col-sm-1 control-label" >
           
        </label>
      <div class="form-group">
         <label for="inputEmail3" class="col-sm-2 control-label">
             Group Name
        </label>
        <div class="col-sm-6">
      
     <html:text styleClass="form-control" property="groupname" value="<%=cd.getNom()%>"  errorStyleClass="error" />
          <html:errors property="groupname" />
          </div>
     </div>
        
        <input type="hidden" value="<%out.print(cd.getNom());%>" name="id" />
         <div class="form-group">
    <div class="col-sm-offset-2 col-sm-6">
     
      <html:submit styleClass="btn btn-success">Edit</html:submit>
     
    </div>
    
    
     </div>
        </html:form> 
     
    
      
  </div> 
   </div> 
   </div>
 
  
 
   </body>
   </html:html>






