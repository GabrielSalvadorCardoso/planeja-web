<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Criar Conta Poupan�a</title>
</head>
<body>
	<h2>Informe algumas informa��es sobre a conta</h2>
	<form action="criaContaPoupanca" method="post">
		<label for="valor">Valor em R$: </label>
		<input type="number" name="valor" min="0" step="0.01" id="valor" /> <br />
		
		<input type="hidden" name="taxaJuros" value="0.5"/>
		<!-- O idUser � retornado diretamente do usuario registrado na sess�o -->
		<input type="hidden" name="idUser" value="${usuario.id}" />
		
		<input type="submit" value="enviar" />
	</form>
</body>
</html>