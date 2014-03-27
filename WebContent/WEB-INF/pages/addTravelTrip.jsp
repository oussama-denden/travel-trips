<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.simpletablestyle,td {
	padding: 10px;
}
</style>

<title>Add Travel Trip</title>
</head>
<body>

	<form:form commandName="newTravelTrip" id="reg"
		action="addTravelTrip.html">
		<h2>Travel Trip Registration</h2>
		<p>Enforces annotation-based constraints defined on the model
			class.</p>
		<table>
			<tbody>
				<tr>
					<td><form:label path="country">Country:</form:label></td>
					<td><form:input path="country" /></td>
					<td><form:errors class="invalid" path="country" /></td>
				</tr>
				<tr>
					<td><form:label path="city">City:</form:label></td>
					<td><form:input path="city" /></td>
					<td><form:errors class="invalid" path="city" /></td>
				</tr>
				<tr>
					<td><form:label path="fromDate">From:</form:label>
					<td><form:input path="fromDate" /></td>
					<td><form:errors class="invalid" path="fromDate" /></td>
				</tr>
				<tr>
					<td><form:label path="toDate">To:</form:label>
					<td><form:input path="toDate" /></td>
					<td><form:errors class="invalid" path="toDate" /></td>
				</tr>

				<tr>
					<td><form:label path="business">Business:</form:label>
					<td><form:checkbox path="business" /></td>
					<td><form:errors class="invalid" path="business" /></td>
				</tr>

			</tbody>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="Register" class="register" />
				</td>
				<td><a href="<c:url value="/myTravels.html"/>">Back</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>