<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test = "${ not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br>
</c:if>


<form action="executa?tarefa=NovaEmpresa" method="post">
    Nome: <input type="text" name="nome" /><br />
    <input type="submit" value="Enviar" />
</form>
<form action="executa?tarefa=Login" method = "POST">
	Email: <input type="text" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="enviar" />
</form>
<form action="executa?tarefa=Logout" method = "POST">
	<input type="hidden" value="Logout" />
	<input type="submit" value="Deslogar" />
</form>
</body>
</html>
