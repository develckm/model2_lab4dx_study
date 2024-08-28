<%@ page import="java.util.List" %>
<%@ page import="com.lab4dx.l06_mvc.dto.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>고객 리스트</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="my-4">고객 리스트</h1>
    <p>
        <%
            Object customersObj=request.getAttribute("customers");
            List<CustomerDto> customers=(List<CustomerDto>)customersObj;
        %>
        <%=customersObj%>
    </p>
    <table class="table">
        <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>폰</th>
            <th>이메일</th>
        </tr>
        </thead>
        <tbody>
        <%for(CustomerDto c : customers){ %>
            <tr>
                <td><%=c.getCustomerId()%></td>
                <td><%=c.getCustomerName()%></td>
                <td><%=c.getCustomerPhone()%></td>
                <td><%=c.getCustomerEmail()%></td>
            </tr>
        <%}%>
        </tbody>
    </table>


</div>
</body>
</html>
