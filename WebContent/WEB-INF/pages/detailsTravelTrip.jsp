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

<title>Details Travel Trip</title>
</head>
<body>
	<h2>Details of your Travel Trip</h2>

	<table>
		<tbody>
			<tr>
				<td>ID:</td>
				<td>${detailsTravelTrip.id}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${detailsTravelTrip.country}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${detailsTravelTrip.city}</td>
			</tr>
			<tr>
				<td>From Date:</td>
				<td>${detailsTravelTrip.fromDate}</td>
			</tr>
			<tr>
				<td>To Date:</td>
				<td>${detailsTravelTrip.toDate}</td>
			</tr>
			<tr>
				<td>Business Trip:</td>
				<td>${detailsTravelTrip.business}</td>
			</tr>

		</tbody>
	</table>
	<a href="<c:url value="/myTravels.html"/>">Back</a>
	<a href="<c:url value="/${detailsTravelTrip.id}/editTravelTripForm.html"/>">
		edit</a>
</body>
</html>