<%@ include file="./header.txt"%>

<h3>Employee details</h3>

<table class="table">
	<tr>
		<td>Name</td>
		<td>${emp.firstname} ${emp.lastname}</td>
	</tr>
	<tr>
		<td>Email address</td>
		<td>${emp.email}</td>
	</tr>
	<tr>
		<td>Phone #</td>
		<td>${emp.phone}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>Rs.${emp.salary}</td>
	</tr>
</table>

<form action="delete-employee" onsubmit="return confirm('Are you sure to delete this?')">
	<input type="hidden" name="id" value="${emp.id}" />
	<button class="btn btn-outline-danger">Delete</button>
</form>

<a href="./all-employees">View all employees</a>


<%@ include file="./footer.txt"%>