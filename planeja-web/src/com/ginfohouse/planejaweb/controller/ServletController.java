package com.ginfohouse.planejaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ginfohouse.planejaweb.UserDao;
import com.ginfohouse.planejaweb.model.User;

//Este Controller receberá todas as requisições
@Controller
public class ServletController{
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	//O Spring preecherá o objeto User automaticamente desde que os nome dos inputs correspondam aos seus atributos
	@RequestMapping("addUser")
	public String addUser(User user) {
		UserDao dao = new UserDao();
		dao.adiciona(user);
		
		return "usuario-adicionado";
	}
	
	//A URL planeja-web/descricao aciona esta Action
	@RequestMapping("/descricao")
	public String descricao() {
		
		//O Spring tentará despachar a requisição para /WEB-INF/view/description.jsp
		//O sufixo e o prefixo não precisam estar no retorno poi já foram definidos em spring-context.xml
		return "description";
	}
}

