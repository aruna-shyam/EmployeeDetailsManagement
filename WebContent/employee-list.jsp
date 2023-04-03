<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.techpalle.model.Employee" %>
    <%@ page import="java.util.ArrayList" %>
    <!-- jstl import statement -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<!-- cdn-content delivery network >(if we want to access that navbar here we want that link here-->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>


<body>

<header >

  <nav class="navbar navbar-expand-md navbar-dark " style="background-color:tomato">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Employee Details Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Employee</a>
        </li>
      </ul>
    </div>
   </div>
   </nav>

</header>
<br/>
<br/>

<div class="container">

     <h2 align="center">Employee List</h2>
    
     <!-- horizontal line tag -->
      <hr>
     
    <form action="insertform">
       <button class="btn btn-success">Add Employee</button>
    </form>
    
    <!-- fetch data using jstl -->
    <table class="table">
  <thead>
    <tr>
      <th scope="col">Eid</th>
      <th scope="col">Ename</th>
      <th scope="col">Egender</th>
      <th scope="col">Edob</th>
      <th scope="col">Edesignation</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="i" items="${al}">
    <tr>
       <td><c:out value="${i.eid}"></c:out></td>
       <td><c:out value="${i.ename}"></c:out></td>
       <td><c:out value="${i.egender}"></c:out></td>
       <td><c:out value="${i.edob}"></c:out></td>
       <td><c:out value="${i.edesignation}"></c:out></td>
       
       <!-- query string-help us to transfer d data one jsppage to another jsp page -->
       <td> <a href="editForm?eid=<c:out value="${i.eid}"></c:out>">Edit</a> 
       &nbsp;&nbsp; 
       <a href="delete?eid=<c:out value="${i.eid}"></c:out>">Delete</a> </td>
    </tr>
  
  </c:forEach>
  </tbody>
  
  </table>
  
 
    </div>
         </body>
</html>
         
      
         
       
    
    
    
    






