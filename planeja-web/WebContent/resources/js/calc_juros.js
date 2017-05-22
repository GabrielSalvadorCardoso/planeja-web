function acrescentar(id) {
	var val = $("#addValor"+id).val();
	//O valor recebido pela função de callback é a resposta da requisição, neste caso, o conteudo de uma JSP
	$.post("depositar", {'idConta': id, 'valor' : val}, function(valorAtualizado) {
		$("#valorPoupanca" + id).html(valorAtualizado);
	});
}