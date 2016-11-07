
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign UP</title>
    
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="bootstrap/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="signin.css" rel="stylesheet">
</head>
<style>
form {
   
    border: 2px solid #004EB1;
    border-radius: 15px 40px;
    background: #f1f1f1;
    margin-left : 20%;
    margin-right : 20%;
    margin-top: 5%;
    padding: 30px 30px;
}
</style>
<body style="background-image:url(images/background.jpg)">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Employee Database Application</a>
    </div>
   
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span> Sign In</a></li>
    </ul>
  </div>
</nav>
<div class="container">

      <form class="form-horizontal" action="signup.do" method="get">
      <h2 class="form-signin-heading">Sign up</h2>
       <div class="form-group">
       <label for="inputfName" class="col-sm-2 control-label">First Name</label>
       <div class="col-sm-10">
       <input type="text" class="form-control" id="inputEmail3" placeholder="First Name" name="fName" required autofocus>
       </div>
       </div>
        <div class="form-group">
       <label for="inputlName" class="col-sm-2 control-label">Last Name</label>
       <div class="col-sm-10">
       <input type="text" class="form-control" id="inputlName" placeholder="Last Name" name="lName" required>
       </div>
       </div>
       <div class="form-group">
       <label for="inputEmail" class="col-sm-2 control-label">Email</label>
       <div class="col-sm-10">
       <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email" required>
       </div>
       </div>
       <div class="form-group">
       <label for="inputpassword" class="col-sm-2 control-label">Password</label>
       <div class="col-sm-10">
       <input type="password" class="form-control" id="inputpassword" placeholder="Password" name="password" required>
       </div>
       </div>
       <div class="form-group">
       <label for="inputcnfpassword" class="col-sm-2 control-label">Confirm Password</label>
       <div class="col-sm-10">
       <input type="password" class="form-control" id="inputcnfpassword" placeholder="Confirm Password" name="cnfpassword" required>
       </div>
       </div>
       <div class="form-group">
       <label for="inputNum" class="col-sm-2 control-label">Contact</label>
       <div class="col-sm-10">
       <input type="number" class="form-control" id="inputNum" placeholder="Contact" name="contact" required>
       </div>
       </div>
       <div class="form-group">
       <label for="inputdob" class="col-sm-2 control-label">Date of Birth</label>
       <div class="col-sm-10">
       <input type="date" class="form-control" id="inputdob" placeholder="DD/MM/YYYY" name="dob" required>
       </div>
       </div>
       <div class="form-group">
       <label class="col-sm-2 control-label">Gender</label>
       <div class="col-sm-10" required>
       <label class="radio-inline">
       <input type="radio" id="inputgender" name="gender" value ="male" required>Male</label>
       <label class="radio-inline">
       <input type="radio" id="inputgender" name="gender" value ="female" required>Female</label>
       </div>
       </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign me Up</button>
      </form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <% String msg = request.getParameter("msg");
  if(msg !=null)
	  request.setAttribute("status", msg);
	  %>
<div style="color: blue;" align="center"><h3>${status}</h3></div>
<br><br>
  <div class="mastfoot" align="center">
  <div class="inner">
  <p>&copy; <a href="#">All rights reserved to sTArLaBs</a>, by <a href="#">develpoers@starlabs</a>.</p>
  </div>
  </div>
</body>
</html>