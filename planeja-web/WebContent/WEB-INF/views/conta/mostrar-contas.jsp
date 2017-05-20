<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Contas</title>
	<style>
		table {
			border: solid #ccc;
			border-radius: 5px;
		}
		td {
			padding: 5px;
			border: 1px #888 solid;
			border-radius: 5px;
		}
	</style>
</head>
<body>
	<h1>Contas de ${usuario.nome}</h1>
	<h2>Contas Poupança</h2>
	
	<c:forEach var="contaP" items="${contasPoupanca}">
		<table>
			<tbody>				
				<tr>
					<td>Codigo da Conta</td> <td>${contaP.idConta}</td>
				</tr>
				<tr>
					<td>Taxa de Juros</td> <td>${contaP.taxaJuros}</td>
				</tr>
				<tr>
					<td>Valor em Conta</td> <td>${contaP.valor}</td>
				</tr>
				<tr>			
					<td> <input type="button" value="Acrescentar Valor"> </td>
					<td> <input type="button" value="Retirar Valor" /> </td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	<p>
		<a href="criar-poupanca">Criar Conta Poupanca</a>
		<a href="#">Criar Conta Renda Fixa</a>
	</p>
</body>
</html>