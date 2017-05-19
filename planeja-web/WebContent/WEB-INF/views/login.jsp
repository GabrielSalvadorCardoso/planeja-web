<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		label {
			display: inline-block;
			width: 100px;
		}
	</style>
</head>
<body>
	<h2>Por favor, identifique-se. Caso não possua cadastro <a href="cadastro">clique aqui</a></h2>
	<form action="efetuarLogin" method="post">
		<label for="user">Usuario: </label>
		<input type="text" name="user" id="user" /> <br />
		
		<label for="pass">Senha: </label>
		<input type="password" name="pass" id="pass" /> <br />
		
		<input type="submit" value="ENVIAR">
	</form>
</body>
</html>