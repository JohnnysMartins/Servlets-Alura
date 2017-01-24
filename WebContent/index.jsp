<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test = "${ not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}</br>
</c:if>



<form  action="fazTudo" method="POST">
	<input type="hidden" value="NovaEmpresa" />
  Nome: <input type="text" name="nome">
  <input type="submit" value="Enviar">
</form>
<form action="fazTudo" method = "POST">
	<input type="hidden" value="Login" />
	Email: <input type="text" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="enviar" />
</form>
<form action="fazTudo?tarefa=Logout" method = "POST">
	<input type="hidden" value="Logout" />
	<input type="submit" value="Deslogar" />
</form>
</body>
</html>
