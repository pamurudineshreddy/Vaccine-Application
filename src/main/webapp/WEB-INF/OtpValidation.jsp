<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reset Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

 <div class="card">
        <div class="card-body row justify-content-center">
           <div class="col-sm-6">
            <form action="newpassword" class="form form-group" method="post">
                <h1 style="text-align: center;">Password Reset </h1>
                <label for="">Email </label>
                <input required type="email"  name="email" class="form-control" value = "${validmail}" readonly >
                <p style="color: green;">${sentotp} </p>
                <label for=""> Enter OTP</label>
                <input required type="number" name ="otp" class="form-control">
                <label for=""> Password</label>
                <input required type="password" name ="password" class="form-control">
                <label for="">Confirm  Password</label>
                <input required type="password" name ="confirmpassword" class="form-control">
                
                  <br>
                  <input type="submit" class="btn btn-success">
        
                  ${otpconfirmation}
            </form>
            
           </div>
        </div>

    </div>

</body>
</html>