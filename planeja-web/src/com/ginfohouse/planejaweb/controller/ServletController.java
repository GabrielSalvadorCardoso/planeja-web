package com.ginfohouse.planejaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

