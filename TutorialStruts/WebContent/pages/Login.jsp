<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
 
  

 <head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
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
<body>
<div class="">
        <div class="row">
            
        </div>
    <div class="col-md-4 col-md-offset-4">
 <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                  
 <html:form action="/Login" >
 <fieldset>
                                <div class="form-group">
                                      <html:text styleClass="form-control" property="id" errorStyleClass="error"/>
                                <html:errors property="id" />
                                </div>
                              
                                <div class="form-group" >
                                    <html:password styleClass="form-control" property="ps" value="password"  
        errorStyleClass="error" />
                                    <html:errors property="ps" />
                                     
                                </div>
                                 
                                
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" value="Remember Me" type="checkbox">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                               <html:submit  >Save</html:submit>
                            </fieldset>
                        </html:form>
 
                        <script>
$(document).ready(function() {
    $('#/Login').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        row: {
            valid: 'field-success',
            invalid: 'field-error'
        },
        fields: {
            id: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            pd: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            }
        }
    });
});
</script>
                    </div>
                </div>
           </div></div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>

 
 
 