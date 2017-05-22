<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Contas</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/table.css' />">
	<script type="text/javascript" src="resources/js/jquery.js"></script>	
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
				<tr id="valorPoupanca${contaP.idConta}">
					<td>Valor em Conta</td> <td>${contaP.valor}</td>
				</tr>
				<tr>			
					<td>
						<input type="button" value="Acrescentar Valor" onClick='acrescentar(${contaP.idConta})' />
					</td>
					<td> 
						<input id="addValor${contaP.idConta}" type="number" min="0" step="0.01"/>
					</td>
				</tr>
				<tr>
					<td> <input type="button" value="Retirar Valor" /> </td>
					<td> <input type="number" min="0" step="0.01" disabled/> </td>
				</tr>
				
			</tbody>
		</table>
	</c:forEach>
	<p>
		<a href="criar-poupanca">Criar Conta Poupanca</a>
		<a href="#">Criar Conta Renda Fixa</a>
	</p>
	
	<script type="text/javascript" src="resources/js/calc_juros.js"></script>
</body>
</html>