<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
 <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %> 
   <html:html>

   <head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title><bean:message key="add.Phone"/></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
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
  
   <div class="panel-heading" > <h1><bean:message key="Enter.info"/></h1>
 
   </div>
   <h1></h1>
    <%  int cd = (int)request.getAttribute("num"); %>
    <html:form action="/AddPhoneToContact" styleClass="form-horizontal" >
    
      <label for="inputEmail3" class="col-sm-1 control-label" >
           
        </label>
      <div class="form-group" >
         <label for="inputEmail3" class="col-sm-2 control-label" >
          <bean:message key="Phone.Kind"/>  
        </label>
        <div class="col-sm-6" >
           <html:text  styleClass="form-control" property="phoneKind"  errorStyleClass="error" />
           <html:errors property="phoneKind" />
          
          </div>
     </div>
     <input type="hidden" value="<%out.print(cd);%>" name="idc" />
      <label for="inputEmail3" class="col-sm-1 control-label" >
           
        </label>
      <div class="form-group">
         <label for="inputEmail3" class="col-sm-2 control-label">
              
               <bean:message key="Phone.Number"/>  
        </label>
        <div class="col-sm-6">
          <html:text  styleClass="form-control" property="phonenumber" errorStyleClass="error" />
           <html:errors property="phonenumber" />
          </div>
     </div>
          
           
    
         <div class="form-group">
    <div class="col-sm-offset-2 col-sm-6">
     
      <html:submit styleClass="btn btn-success"><bean:message key="Add"/> </html:submit>
    </div>
    
    
     </div>
        </html:form> 
     
    
      
  </div> 
   </div> 
   </div>
 
  
 
   </body>
   </html:html>






