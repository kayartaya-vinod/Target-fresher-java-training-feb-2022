<%@ include file="./header.txt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>List of employees</h3>


<ul class="list-group">
	<c:forEach items="${employees}" var="e">
		<li class="list-group-item"><a href="./view-details?id=${e.id}">${e.firstname}
				${e.lastname}</a></li>
	</c:forEach>
</ul>
<%@ include file="./footer.txt"%>