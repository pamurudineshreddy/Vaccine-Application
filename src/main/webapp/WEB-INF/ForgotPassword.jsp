<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        img{
            width: 655px;
            height: 500px;
            background-repeat: no-repeat;
            
        }
        .row{
            margin-top: 7%;

        }
        .signup{
            display: inline;
        }
        .col-md-5{
            padding-left: 0;
            padding-right: 0;
        }
        body{
            background-color: #363432;
        }
        .card{
            background-color: black;

        }
        label{
            color: white;
        }
        h1{
            color: white;

        }
        input{
            color: black;
        }

    </style>
</head>
<body>


    <div class="row justify-content-center   ">
        <div class="col-md-5 card">
            <img src="new.jpg" alt="">
        </div>
       
        <div class="col-md-3 card">
            <form action="sendotp" method="post" >
                <br><br>
                <h1><strong>Hello,</strong></h1>
                <h1><strong>Welcome Back</strong></h1>
                <br>

                <label for="">E-mail</label>
                 <input  required type="email" class="form-control" placeholder=" " name="email" >
                 
                 <br>
                 <p style="color: red;">${validmail}  ${notvalidmail}</p>
                 <button class="btn btn-success" type="submit" style="padding-left: 20px; padding-right: 20px; width: 100%; border: 5px;">Send OTP</button>
            
            </form>
                 <br>
                 <label for=""style="margin-left:50px ; class='signup'">Don't have an account? <a href="registerpage"><strong>Sign-up</strong></a></label>

        </div>
       

    </div>

   
    
</body>
</html>