<%@ page import="com.blisse.model.Flights" %>
<%@ page import="com.blisse.DAOAirport" %><%--
  Created by IntelliJ IDEA.
  User: skibu
  Date: 19.06.2018
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="assets/css/bootstrap.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
  <title>Airport</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container">
    <a class="navbar-brand" href="#"><i class="fas fa-plane"></i> Airport</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
      </ul>
      <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<div class="container my-lg-3">
  <div class="row">
    <div class="col-lg-12">
      <h1 class="text-center"><i class="far fa-paper-plane"></i> Flights</h1>
      <table class="table table-hover">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Point</th>
          <th scope="col">Dispatch time</th>
          <th scope="col">Arrival time</th>
          <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <% for (Flights f :DAOAirport.getDaoAirport().getFlights()) {%>
        <tr>
          <th scope="row"><%=f.getId()%></th>
          <td><%=f.getPoint()%></td>
          <td><%=f.getDispatchtime()%></td>
          <td><%=f.getArrivaltime()%></td>
          <td><%=f.getStatus()%></td>
        </tr>
        <%}%>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script type="text/javascript" src="assets/js/bootstrap.js">
</script>
</body>
</html>

