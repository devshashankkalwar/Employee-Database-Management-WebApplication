<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Employee Table</title>
</head>
<body>
<h2 align="center"><b>Employee Table</b> </h2>
<div align="right" style="margin-right:50px"><h4>Sort By:
<select width="50%">
<option value ="byname"></option>
<option value ="byname">By Name</option>
<option value ="bysalary">By Salary</option>
</select>  </h4>
</div>

<div class="table-responsive">
<table class="table table-striped width" style="border:solid">
<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Salary (INR)</th><th>Department</th></tr>
</thead>
<tbody>


</tbody>
</table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>