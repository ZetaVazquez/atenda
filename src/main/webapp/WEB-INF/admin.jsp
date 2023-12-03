<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<br>
	<c:if test="${not empty sessionScope.user }">
	session["user"]: ${sessionScope.user}<br>
	session["rol"]: ${sessionScope.rol}<br>
	</c:if>
	<br><br>
	
<c:set value="${usuario}" var="user"></c:set>
<form action="logout" method="post">
	<img src="${pageContext.request.contextPath}/images?foto=${user.getFoto()}"
		alt="${user.getAvatar()}" width="50" height="50" name="fotoPerfil.jpg">
		
	<input type="submit" value="Logout">
</form>
<br>

<form action="admin" method="post">
 <h1>XESTION DE PRODUCTOS</h1>
 <c:set value="${producto}" var="prod"></c:set>
	<div>
		<table>
			<tr>
				<td>ID:</td>
				<td> <c:out value="${prod.getId()}" default="0"></c:out></td>
			</tr>
			<tr>
				<td>Categoria:</td>
				<td> <c:out value="${prod.getIdCategoria()}" ></c:out></td>
			</tr>
			<tr>
				<td>Marca:</td>
				<td> <c:out value="${prod.getIdMarca()}" ></c:out></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td> <input type="text" value="${prod.getNome()}" name="nome"></td>
			</tr>
			<tr>
				<td>Prezo:</td>
				<td> <input type="number" value="${prod.getPrezo()}" name="prezo"></td>
			</tr>
			<tr>
				<td>Desconto:</td>
				<td> <input type="number" value="${prod.getDesconto()}" name="desconto"></td>
			</tr>
			<tr>
				<td>Coste:</td>
				<td> <input type="text" value="${prod.getCoste()}" name="coste"></td>
			</tr>
			<tr>
				<td>IVA:</td>
				<td>
					<select name="iva" id="iva" required="required">
						<option value="5" 
							<c:if test="${prod.getIva()== 5}"> selected </c:if> 
						>5%</option>
						<option value="10" 
							<c:if test="${prod.getIva()== 10}"> selected </c:if> 
						>10%</option>
						<option value="21" 
							<c:if test="${prod.getIva()== 21}"> selected </c:if> 
						>21%</option>
					</select>
				<td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td> <input type="number" value="${prod.getStock()}" name="stock"></td>
			</tr>
			<tr>
				<td>Foto:</td>
				<td> <img alt="${prod.getFoto()}" src="${pageContext.request.contextPath}/images?foto=${prod.getFoto()}" width="200px" height="200px"></td>
				<td><input type="file" name="fotoInsert.jpg"></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><select name="baixa" id="baixa" required="required">
						<option value="true" 
							<c:if test="${prod.isBaixa()== true}"> selected </c:if> 
						>Baixa</option>
						<option value="false" 
							<c:if test="${prod.isBaixa()== false}">selected</c:if>
						>Alta</option>
					</select> 
				</td>
			</tr>
			<tr>
			<!-- Botones de guardar y borrar datos -->
				<td><input type="submit" value="guardar" name="action"></td>
				<td><input <c:choose>
					<c:when test="${prod.getId()!=null }">type="submit"</c:when>
					<c:otherwise>type="reset"</c:otherwise>
					</c:choose> type="submit" value="borrar" name="action">
				</td>
			</tr>
		</table>
	</div>
</form>



<table>

	<thead>
		<tr>
			<th>ID</th>
			<th>categoria</th>
			<th>Marca</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Desconto</th>
			<th>Coste</th>
			<th>IVA</th>
			<th>Stock</th>
			<th>Foto</th>
			<th>Estado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${productos}">
			<form action="${pageContext.request.contextPath}/admin" method="get" enctype="multipart/form-data">
				<tr>
					<td><c:out value="${producto.getId()}"></c:out><input type="hidden" value="${producto.getId()}" name="id"> </td>
					<td><c:out value="${producto.getIdCategoria()}"></c:out></td>
					<td><c:out value="${producto.getIdMarca()}"></c:out></td>
					<td><c:out value="${producto.getNome()}"></c:out></td>
					<td><c:out value="${producto.getPrezo()}"></c:out></td>
					<td><c:out value="${producto.getDesconto()}"></c:out></td>
					<td><c:out value="${producto.getCoste()}"></c:out></td>
					<td><c:out value="${producto.getIva()}"></c:out></td>
					<td><c:out value="${producto.getStock()}"></c:out></td>
					
					<td><img alt="${producto.getFoto()}"src="${pageContext.request.contextPath}/images?foto=${producto.getFoto()}" width="200px" height="200px"></td>
					<td><c:out value="${producto.isBaixa()}"></c:out></td>
					<!-- Botones de editar y softdelete -->
					<td><input type="submit" value="editar" name="action"></td>
					<td><input type="submit" value="softdelete" name="action"></td>
				</tr>
			</form>
		</c:forEach>
	</tbody>		
</table>
</body>
</html>