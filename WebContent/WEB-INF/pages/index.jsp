<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.simpletablestyle,  td {
        padding:10px;
}
</style>
 
<title>Travel Trips</title>
</head>
<body>
 
    <br />
 
    <c:choose>
        <c:when test="${travelTripList.size()==0}">
            <em>No Travel Trip Saved.</em>
        </c:when>
        <c:otherwise>
            <table class="simpletablestyle">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Country</th>
                        <th>City</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Business</th>
                        <th></th>
                        <th></th>
                        <th></th>
             
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${travelTripList}" var="travelTrip">
                        <tr>
                            <td>${travelTrip.id}</td>
                            <td>${travelTrip.country}</td>
                            <td>${travelTrip.city}</td>
                            <td>${travelTrip.fromDate}</td>
                            <td>${travelTrip.toDate}</td>
                            <td>${travelTrip.business}</td>
                            <td>
                                <a href="<c:url value="/${travelTrip.id}/deleteTravelTrip.html"/>">
                                    delete</a></td>
                            <td>
                                <a href="<c:url value="/${travelTrip.id}/editTravelTripForm.html"/>">
                                    edit</a></td>
                            <td>
                                <a href="<c:url value="/${travelTrip.id}/detailsTravelTrip.html"/>">
                                    details</a></td>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
 
    <h4><a href="addTravelTripForm.html">Add New Travel Trip</a></h4>
    <a href="<c:url value="/export.html"/>"><b>Export</b></a>
 
</body>
</html>