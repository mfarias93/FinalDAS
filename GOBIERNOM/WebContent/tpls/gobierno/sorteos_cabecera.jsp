<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<div id="elegir_sorteo_anterior">

<table>
  <tr>
  <td>
   		
<div id="div_volver">
<input type="button" id="volver" name="volver" Onclick="jGobierno.Opciones()" value ="<fmt:message key="Volver" bundle="${etq}" />" /> 
</div>

</td>

<td>
        <div id="seleccion_sorteo_ant">
<var><fmt:message key="Elegir_Sorteo" bundle="${etq}"/></var>

<select name="Sorteo_Elegido" id="Sorteo_Elegido" onChange="jGobierno.Elegido()">
        <c:choose>
        <c:when test="${listado.getSorteos().size() == 0}">
         <option value="SS"><fmt:message key="SIN_SORTEO" bundle="${etq}"/></option>
        </c:when> 
        <c:otherwise>
         <c:forEach var="sorteo" items="${listado.getSorteos()}">
         <option value="${sorteo.getNro_sorteo()}">${sorteo.getFecha()} - ${sorteo.getDescripcion()}</option>
         </c:forEach>
        </c:otherwise>
        </c:choose>
       
</select>

</div>
</td>
</table>

</div>
