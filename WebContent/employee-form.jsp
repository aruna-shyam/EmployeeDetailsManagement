<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>

<body>
<form action="redirect" method="post">

<header>

  <nav class="navbar navbar-expand-md navbar-dark " style="background-color:tomato">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Employee Details Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="employee">Employee</a>
        </li>
      </ul>
    </div>
   </div>
   </nav>

</header>

</form>
<br/>
<br/>
<div class="container" style="width:50%">


<c:if test="${employee ==null}">

    <form action="add" method="post">

    <h2>Add Employee</h2>

</c:if>

<c:if test="${employee !=null}">

   <form action="edit" method="post">

   <h2>Edit Employee</h2>

</c:if>


<div class="mb-3" hidden="hidden">
  <input value="<c:out value="${employee.eid}"></c:out>" type="text" class="form-control" id="exampleFormControlInput"  name="tbId">
</div>

<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Name</label>
  <!-- display d data inside the control -->
  <input type="text" value="<c:out value="${employee.ename}"></c:out>" class="form-control" id="exampleFormControlInput1"  name="tbName" placeholder="Enter Your Name" required="required">
</div>


<div class="form-check">
  <input type="radio" name="rdGender" value="<c:out value="${employee.egender}"></c:out>" class="form-control"/>Male
 </div>
<div class="form-check">
  <input  type="radio" name="rdGender" value="<c:out value="${employee.egender}"></c:out>" class="form-control" />Female
</div>

<div class="mb-3">
  <label for="exampleFormControlInput3" class="form-label">DateOfBirth</label>
  <input type="date" value="<c:out value="${employee.edob}"></c:out>" class="form-control" id="exampleFormControlInput3" name="tbBirth" placeholder="Select DOB" required="required">
</div>

<div class="mb-3">
  <label for="exampleFormControlInput3" class="form-label">Designation</label>
  <input type="text" value="<c:out value="${employee.edesignation}"></c:out>" class="form-control" id="exampleFormControlInput4" name="tbDesign" placeholder="Enter Your Designation" required="required">
</div>

<div>
  <button class="btn btn-success">Save</button>
</div>

</form>


</div>



</body>
</html>