<%@ page 
    pageEncoding="UTF-8"
    contentType="text/html; charset=utf-8"
    import = "java.util.ArrayList,cn.tedu.entity.*"
     
%>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!<br>
						<input type="text" name = "name">
						
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								job
							</td>
							<td>
								Opreation
							</td>							
						</tr>
						<%
						
							ArrayList<Emp> emps = (ArrayList<Emp>)request.getAttribute("allEmp");
						 	// 循环得到emps集合里面的所有数据
						 	for(int i = 0; i < emps.size(); i++){
						 		 Emp emp = emps.get(i);
						 		 
						%>
							<tr class="row<%=i%2+1 %>>">
								<td> <%=emp.getId() %> </td>
								<td> <%=emp.getName() %></td>
								<td> <%=emp.getSalary() %></td>
								<td> <%=emp.getJob() %></td>
								<td> 
									<a href="del?id=<%=emp.getId() %>" onclick="return confirm('确认删除<%=emp.getName() %>吗')" >delete</a>&nbsp;&nbsp;
									
									<a href="load?id=<%= emp.getId()%>">
										update
									</a>
									 
								</td>
								
							</tr>
							
						  <% } %>
						
						
					</table>
					<p>
						<input type="submit" class="button" value="AddEmp" onclick="location='addEmp.html'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
