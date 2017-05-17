<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuario</title>
	<style>
		label {
			display: inline-block;
			width: 100px;
		}
	</style>
</head>
<body>
	<h1>Crie uma nova conta preechendo o formulario abaixo</h1>
	<form action="addUser" method="post">
		<label for="nome">Nome Completo: </label>
		<input type="text" name="nome" id="nome" /> <br />
		
		<label for="user">Usuario: </label>
		<input type="text" name="user" id="user" /> <br />
		
		<label for="pass">Senha: </label>
		<input type="password" name="pass" id="pass" /> <br /> <BR />
		
		<input type="submit" value="ENVIAR">
	</form>
</body>
</html>