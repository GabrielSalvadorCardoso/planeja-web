<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bem vindo(a)</title>
</head>
<body>
	<h2>Bem vindo(a) ${usuario.nome}. O que deseja fazer? ID: ${usuario.id}</h2>
	<p> <a href="criar-poupanca">Criar Conta Poupança</a> </p>
	
	<form action="mostrarContasPoupanca" method="post">
		<!-- Enviando o id do usuario através do metodo POST, o usuario não terá contato com o id -->
		<input type="hidden" value="${usuario.id}" name="id" />
		<input type="submit" value="Minhas contas" />
	</form>
	
	<p> <a href="#">Fazer logoff</a> </p>
</body>
</html>