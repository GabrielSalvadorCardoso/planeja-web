package com.ginfohouse.planejaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ginfohouse.planejaweb.dao.ContaPoupancaDao;
import com.ginfohouse.planejaweb.dao.UserDao;
import com.ginfohouse.planejaweb.model.ContaPoupanca;
import com.ginfohouse.planejaweb.model.User;

//Este Controller receberá todas as requisições
@Controller
public class ServletController{
	//A URL planeja-web/descricao aciona esta Action
	@RequestMapping("/descricao")
	public String descricao() {		
		//O Spring tentará despachar a requisição para /WEB-INF/view/description.jsp
		//O sufixo e o prefixo não precisam estar no retorno poi já foram definidos em spring-context.xml
		return "description";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping("/criar-poupanca")
	public String formContaPupanca() {
		return "criar-poupanca";
	}
	
	//O Spring preecherá o objeto User automaticamente desde que os nome dos inputs correspondam aos seus atributos
	@RequestMapping("/addUser")
	public String addUser(User user) {
		UserDao dao = new UserDao();
		dao.adiciona(user);
		
		return "usuario-adicionado";
	}
	
	@RequestMapping("/criaContaPoupanca")
	public String criaContaPoupanca(ContaPoupanca cPoupanca) {
		System.out.println("ID Conta: " + cPoupanca.getIdConta() +
							"\nID Usuario: " + cPoupanca.getIdUser()+
							"\nTaxa de Juros: " + cPoupanca.getTaxaJuros()+
							"\nValor: " + cPoupanca.getValor());
		//Se o usuario acionar a url 'planeja-web/criaPoupanca' sem inserir dados, ele será direcionado para o form
		try {			
			ContaPoupancaDao dao = new ContaPoupancaDao();
			dao.adiciona(cPoupanca);
			return "poupanca-criada";
		} catch(NullPointerException e) {
			return "criar-poupanca";
		}
	}
	
}

