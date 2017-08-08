function acrescentar(id) {
	var val = $("#addValor"+id).val();
	//O valor recebido pela função de callback é a resposta da requisição, neste caso, o conteudo de uma JSP
	$.post("depositar", {'idConta': id, 'valor' : val}, function(valorAtualizado) {
		$("#valorPoupanca" + id).html(valorAtualizado);
	});
}

function calcJuros(id) {
	alert("Valor " + $("#valorConta" + id).val());
	var val = parseFloat($("#valorConta" + id).val());
	alert(isNaN(val));
	var meses = parseInt($("#meses" + id).val());
	alert(isNaN(meses));
		
	var cont;
	for(cont = 1; cont <= meses; cont++) {
		val = val + ((val / 100) * 0.5);
	}
	alert("Juros depois de " + meses + " meses: " + val.toFixed(2));
}