<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conta Poupan�a Criada</title>
</head>
<body>
	<h2>Conta Poupan�a criada com sucesso!</h2>
	
	<form action="mostrarContasPoupanca" method="post">
		<!-- Enviando o id do usuario atrav�s do metodo POST, o usuario n�o ter� contato com o id -->
		<input type="hidden" value="${usuario.id}" name="id" />
		<input type="submit" value="Minhas contas" />
	</form>
</body>
</html>