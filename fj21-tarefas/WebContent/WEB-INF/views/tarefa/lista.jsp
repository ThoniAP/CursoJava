<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
     <script type="text/javascript" src="resources/js/jquery.js"></script>
<body>
     <script type="text/javascript">
          function finalizaAgora(id) {
        	  $.post("finalizaTarefa", {'id' : id}, function() {
        		  //selecionando o elemento html através da
        		  //ID e alterando o HTML dele
        		  $("#tarefa_"+id).html ("Finalizado");
        	  });
          }
     </script>
    
    <br> <br />
    
    <table border="2" CELLPADDING="2" CELLSPACING="0" WIDTH="75%" ALIGN="center" >
    <tr>
        <th COLSPAN="6">LISTA DE TAREFAS</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>DESCRIÇÃO</th>
        <th>FINALIZADO</th>
        <th>DATA DE FINALIZAÇÃO</th>
        <th COLSPAN="2">AÇÃO</th>
    </tr>
    <c:forEach items="${tarefas}" var="tarefa">
        <tr>
            <td ALIGN="center">${tarefa.id}</td>
            <td>${tarefa.descricao}</td>
            <c:if test="${tarefa.finalizado eq false}">
                <td ALIGN="center" id="tarefa_${tarefa.id}">
                    <a href="#" onClick="finalizaAgora(${tarefa.id})">
                       Finaliza agora!
                    </a>
                </td>  
            </c:if>
            
            <c:if test="${tarefa.finalizado eq true}">
                <td ALIGN="center">Finalizado</td>
            </c:if>      
              
            <td ALIGN="center">
                <fmt:formatDate value="${tarefa.dataFinalizacao.time}"
                pattern="dd/MM/yyyy"/>  
            </td>
            <td ALIGN="center"><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
            <td ALIGN="center"><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
    </c:forEach>
    <tr>
         <th COLSPAN="6" BGCOLOR="yellow"> <a href="novaTarefa">CRIAR NOVA TAREFA</a></th>
    
    </tr>
    </table>
    <br><br />
    
    <center>
        <a href="logout">LOGOUT</a>
    </center>
    
</body>
</html>