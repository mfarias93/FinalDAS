<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id= 'concesionaria_habilitadas'>
<table id='tabla_conce'>
<thead> 
<tr>     
	<td>DNI</td>
	<td>ID</td>
	<td><fmt:message key="APELLIDO" bundle="${etq}"/></td>
	<td><fmt:message key="NOMBRE" bundle="${etq}"/> </td>
	<td><fmt:message key="Nombre_Auto" bundle="${etq}"/></td> 
	<td><fmt:message key="Tipo_Modelo" bundle="${etq}"/></td>
	<td><fmt:message key="DOMINIO" bundle="${etq}"/></td>
	<td><fmt:message key="Buscar" bundle="${etq}"/> </td>
</tr>
</thead>
<tbody>     
        <c:forEach var="planes" items="${Planes.getPlanes()}">
        <tr>
	        <td>${planes.getId_persona()}</td>
	        <td>${planes.getIdentificador()}</td>
	        <td>${planes.getApellido()}</td>
	        <td>${planes.getNombre()}</td>
	        <td>${planes.getNombre_Auto()}</td>
	        <td>${planes.getTipo_modelo()}</td>
	        <td>${planes.getDominio()}</td>
	        <td><input type="image" id="busca_plan" name="busca_plan" onclick="jGobierno.Busca_Plan('${planes.getIdentificador()}')" src="/img/busca.png" title=<fmt:message key="Buscar" bundle="${etq}"/>  /></td>
	        </tr>
       </c:forEach>
</tbody>          
</table>
</div>
<div id="plan_buscado">

</div>




