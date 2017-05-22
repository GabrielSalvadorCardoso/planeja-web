<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Criar Conta Poupança</title>
</head>
<body>
	<h2>Informe algumas informações sobre a conta</h2>
	<form action="criaContaPoupanca" method="post">
		<label for="valor">Valor em R$: </label>
		<input type="number" name="valor" min="0" step="0.01" id="valor" /> <br />
		
		<input type="hidden" name="taxaJuros" value="0.5"/>
		<!-- O idUser é retornado diretamente do usuario registrado na sessão -->
		<input type="hidden" name="idUser" value="${usuario.id}" />
		
		<input type="submit" value="enviar" />
	</form>
</body>
</html>