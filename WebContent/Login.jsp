
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LOGIN</title>
    
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="bootstrap/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="signin.css" rel="stylesheet">
</head>
<style>
form {
   
    border: 2px solid #004EB1;
    border-radius: 15px 40px;
    background: #f1f1f1;
    margin-left : 30%;
    margin-right : 30%;
    margin-top: 10%;
    padding: 30px 30px;
}
</style>
<body style="background-image:url(images/background.jpg)">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Login.jsp">Employee Database Application</a>
    </div>
   
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span> New User? Sign Up</a></li>
    </ul>
  </div>
</nav>
<div class="container">

      <form class="form-signin" action="Login.do" method="get">
        <h2 class="form-signin-heading">Please Login</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
<% String msg = request.getParameter("msg");
  if(msg !=null)
	  request.setAttribute("status", msg);
	  %>
<div style="color: blue;" align="center"><h2>${status}</h2></div>
<br><br>
  <div class="mastfoot" align="center">
  <div class="inner">
  <p>&copy; <a href="#">All rights reserved to sTArLaBs</a>, by <a href="#">develpoers@starlabs</a>.</p>
  </div>
  </div>
</body>
</html>