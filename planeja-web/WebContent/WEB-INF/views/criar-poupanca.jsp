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
		<input type="number" name="valor" min="0" step="100" id="valor" /> <br />
		
		<input type="hidden" name="taxaJuros" value="0.5"/>
		<!-- O idUser dever� ser recuperado do usuario logado na sess�o, portanto o value="4" pe temporario, apenas para testes -->
		<input type="hidden" name="idUser" value="4" />
		
		<input type="submit" value="enviar" />
	</form>
</body>
</html>