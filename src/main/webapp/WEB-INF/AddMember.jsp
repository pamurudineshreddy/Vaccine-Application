
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>
    <title>Add Family Member</title>
</head>
<body>
    <div class="card">
        <div class="card-body row justify-content-center">
           <div class="col-sm-6">
           <a href="allmembers" class="btn btn-outline-success my-2 my-sm-0" type="button"  >View Members</a>
					    ${nofamilydata }
                 <table class="table"   >
		        	<tr>
		        	<th>NAME</th>
		        	<th>GENDER</th>
		        	<th>DATE_OF_BIRTH</th>
		        	<th>ID_PROOF</th>
		        	<th>ID_PROOF_NO</th>
		        	<th>MOBILE_NUMBER</th>
		        	<th>VACCINE_TYPE</th>
		        	<th>DOSE</th>
		        	<th>Update</th>
		        	<th>Delete</th>
		        	</tr>
		        	<c:forEach items="${familydata}" var="d">
		        	<tr>
		        	<td>  ${d.name}</td>
		        	<td>  ${d.gender}</td>
		        	<td>  ${d.dateOfBirth}</td>
		        	<td>  ${d.idProof}</td>
		        	<td>  ${d.idProofNo}</td>
		        	<td>  ${d.mobileNumber}</td>
		        	<td>  ${d.vaccineType}</td>
		        	<td>  ${d.dose}</td>
		        	<%-- <td><a href="updateData/${d.id}">Edit</a></td>
		        	<td><a href="deleteData/${d.id}">Delete</a></td> --%>
		        	</tr>
		        	</c:forEach>
		        </table>
           
            <form action="addfamilymember" class="form form-group" method="post">
                <h1 style="text-align: center;">Family Member </h1>
                <label for=""> Name </label>
                <input required type="text" required  name="name" class="form-control">
				<label for="">Gender</label>
				<select name="gender" id="" class="form-control dropdown">
				  <option value="Male" name="male" selected="selected" >Male</option>
				  <option value="Female" name="female">Female</option>
				  <option value="Other"  name="other">Other</option>
				</select>
                <label for="">Date of Birth </label>
                <input type="date"  name="dateofbirth" required class="form-control">
				<label for="">Govt ID</label>
                  <select name="govtid" id="" class="form-control dropdown">
                    <option value="Aadhar" selected="selected" name="aadhar">Aadhar</option>
                    <option value="PAN" name="pan" >PAN</option>
                  </select>
                <label for=""> ID Proof Number</label>
                <input required type="text" required name ="idtext" class="form-control">
                <label for=""> Mobile Number</label>
                <input required type="number" required name ="mobilenumber" class="form-control">
				<label for="">Vaccine</label>
				<select name="vaccine" id="" class="form-control dropdown">
				  <option value="covaxin" selected="selected" name="covaxin">Co-Vaxin</option>
				  <option value="covishield" name="covishield" >Co-ViShield</option>
				</select>
                <label for="">Dose</label>
                  <select name="dose" id="" class="form-control dropdown">
                    <option value="dose1" selected="selected" name="dose1">Dose 1</option>
                    <option value="dose2" name="dose2" >Dose 2</option>
                    <option value="dose3" name="dose3">Dose 3</option>
                  </select>
                
                  <br>
                  <input type="submit" class="btn btn-success">
                  ${saved}
                
        
            </form>
           </div>
        </div>

    </div>
    
</body>
</html>