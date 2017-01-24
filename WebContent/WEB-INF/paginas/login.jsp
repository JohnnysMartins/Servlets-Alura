<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<c:if test="${not empty usuarioLogado }">
			Usuario ${usuarioLogado.email} logado com sucesso!
		</c:if>
	</body>
</html>
