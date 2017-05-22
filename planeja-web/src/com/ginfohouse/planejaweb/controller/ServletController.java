package com.ginfohouse.planejaweb.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ginfohouse.planejaweb.dao.ContaPoupancaDao;
import com.ginfohouse.planejaweb.model.ContaPoupanca;
import com.ginfohouse.planejaweb.model.User;

//Este Controller receberá todas as requisições referentes as contas
@Controller
public class ServletController{
	
	//A URL planeja-web/ciar-poupanca aciona esta Action
	@RequestMapping("/criar-poupanca")
	public String formContaPupanca() {
		//O Spring tentará despachar a requisição para /WEB-INF/view/criar-poupanca.jsp
		//O sufixo e o prefixo não precisam estar no retorno pois já foram definidos em spring-context.xml
		return "conta/criar-poupanca";
	}
	
	@RequestMapping("/criaContaPoupanca")
	public String criaContaPoupanca(ContaPoupanca cPoupanca) {
		//Se o usuario acionar a url 'planeja-web/criaPoupanca' sem inserir dados, ele será direcionado para o form
		try {			
			ContaPoupancaDao dao = new ContaPoupancaDao();
			dao.adiciona(cPoupanca);
			return "poupanca-criada";
		} catch(NullPointerException e) {
			return "conta/criar-poupanca";
		}
	}
	
	@RequestMapping("/mostrarContasPoupanca")
	public String monstrarContas(User user, Model model) {//Model permite associar um objeto do modelo para a view
		ContaPoupancaDao dao = new ContaPoupancaDao();
		List<ContaPoupanca> contasP = dao.select(user.getId());
		model.addAttribute("contasPoupanca", contasP);//A lista de contas poupança estará disponivel na view
		
		return "conta/mostrar-contas";
		//Futuramente será implementado um redirecionamento para a listagem de Fundos de Renda Fixa(FRF)
		//return "forward:mostrarContasFRF";
	}
	
	//Toda Action pode receber um ServletResponse como parametro
	@RequestMapping("depositar")
	public String depositar(Long idConta, double valor, Model model) {
		System.out.println("Id da Conta: " + idConta + "\nValor: " + valor);
		ContaPoupancaDao dao = new ContaPoupancaDao();
		dao.deposito(idConta, valor);
		
		model.addAttribute("contaP", dao.buscaPorId(idConta));
		
		//O redirecionamento da requisição aciona a função de callback
		//O JSP para o qual a requisição é redirecionada será enviado como argumento para a função de callback
		return "conta/valorAtualizado";
	}
}

