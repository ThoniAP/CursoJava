<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Calendar" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <%-- Comentario: nossa primeira página JSP --%>
    <h1>
    <%
       String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
    %>
    <% out.println(mensagem); %>
    </h1>
    
    <br />
    
    <h2>
    
    <%
       String desenvolvido = "Desenvolvido por (Anthoni)";
    %>
    
    <%= desenvolvido %>
    
    </h2>
    
    <br />
    
    <% System.out.println("Tudo foi executado!"); %>
    
    <br />
    
    A hora do sistema é:
    <%=Calendar.getInstance().getTime() %>

</body>
</html>