
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>
    <title>Form</title>
</head>
<body>
    <div class="card">
        <div class="card-body row justify-content-center">
           <div class="col-sm-6">
            <form action="registerdetails" class="form form-group" method="post">
                <h1 style="text-align: center;">Registeration </h1>
                <label for="">User Name </label>
                <input required type="text"  name="username" class="form-control">
                <label for=""> Password</label>
                <input required type="password" name ="password" class="form-control">
                <label for="">Confirm  Password</label>
                <input required type="password" name ="confirmpassword" class="form-control">
                <label for=""> Mobile Number</label>
                <input required type="number" name ="mobilenumber" class="form-control">
                  <label for="">Gender</label>
                  <select name="gender" id="" class="form-control dropdown">
                    <option value="" selected="selected" name="gender">Select</option>
                    <option value="male" name="male" >Male</option>
                    <option value="Female" name="female">Female</option>
                  </select>
                <label for="">Date of Birth </label>
                <input type="date"  name="dateofbirth" class="form-control">
                
                  <br>
                  <input type="submit" class="btn btn-success">
                  ${validatemessage}
                  ${passwordsmessage}
                  ${savedmessage}
        
            </form>
           </div>
        </div>

    </div>
    
</body>
</html>