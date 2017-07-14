<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
     <link href="css/jquery.css" rel="stylesheet">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<h1>Altera Contatos</h1>
<hr />
<form action="mvc" method="post"> 
      Nome: <input type="text" name="nome" value="${contato.nome}" /><br />
      E-mail: <input type="text" name="email" value="${contato.email}" /><br />
      Endereço: <input type="text" name="endereco" value="${contato.endereco}" /><br />
      Data Nascimento: <caelum:campoData id="dataNascimento" dt="${contato.dataNascimento.time}" /><br />
      <input type="hidden" name="id" value="${contato.id}">
      <input type="hidden" name="logica" value="AlteraContato"/>
      <input type="submit" value="Gravar" />
</form>

<c:import url="rodape.jsp"/>

</body>
</html>