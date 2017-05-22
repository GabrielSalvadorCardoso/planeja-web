<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conta Poupança Criada</title>
</head>
<body>
	<h2>Conta Poupança criada com sucesso!</h2>
	
	<form action="mostrarContasPoupanca" method="post">
		<!-- Enviando o id do usuario através do metodo POST, o usuario não terá contato com o id -->
		<input type="hidden" value="${usuario.id}" name="id" />
		<input type="submit" value="Minhas contas" />
	</form>
</body>
</html>