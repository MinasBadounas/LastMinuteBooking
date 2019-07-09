<%-- 
    Document   : login
    Created on : Jul 08, 2019, 8:12:05 PM
    Author     : Panos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Please Sign-in</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="../../resources/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
      <form:form class="form-signin" action = "${pageContext.request.contextPath}/user/login" method = "POST" modelAttribute = "user">
      <img class="mb-4" src="../../resources/template.jpg" alt="" width="300" height="150">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <form:label class="sr-only" path="username">Username</form:label>
      <form:input class = "form-control" placeholder = "Username" required = "true" autofocus = "true" path = "username"/>
      <form:label class="sr-only" path = "password">Password</form:label>
      <form:input type = "password" class = "form-control" placeholder = "Password" required = "true" path = "password"/>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; Bootcamp 7 Team Project</p>
    </form:form>
  </body>
</html>

