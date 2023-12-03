
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>


<br>
<c:if test="${not empty sessionScope.user }">
	session["user"]: ${sessionScope.user}<br>
	session["rol"]: ${sessionScope.rol}<br>

</c:if>
<br>
<!-- Formulario de autenticación -->
    <form action="login" method="post">
        <label for="username">Usuario:</label>
        <input type="text" id="username" name="username" required>
        
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required>
        
        <input type="submit" value="Login">
    </form>

  
   
    <h1>Listado de Productos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Prezo</th>
          	<th>Foto</th>
        </tr>
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td>${producto.id}</td>
                <td>${producto.nome}</td>
                <td>${producto.prezo}</td>
                <td>${producto.foto}</td>
            </tr>
        </c:forEach>
    </table>

    
</body>
</html>