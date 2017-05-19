package com.ginfohouse.planejaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//HandlerInterceptorAdapter é um Interceptor de requisições semelhante a HandlerInterceptor
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	private HttpServletResponse response;

	//O Interceptor captura todas as requisições
	//Antes de cada requisição o método 'preHandler' é executado
	//Depois da execução da ação o método 'postHandler' é executado
	//Depois da requisição ser totalmente processada o método 'afterCompletion' é executado
	//Os três métodos possuem uma implementação padrão em HandlerInterceptior, portanto só sobrescrevemos o necesario
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		//O método 'preHandler' recebe o controlador que esta sendo interceptado
		//O que determina o sucesso ou fracasso da requisição é o retorno deste método
		
		String uri = request.getRequestURI();//Retorna o endereco da requisição
		if(uri.endsWith("login") || uri.endsWith("efetuarLogin") || uri.endsWith("cadastro") || uri.endsWith("addUser")) {
			return true;
		}
		//Verificamos se existe um usuario registrado na sessão
		if(request.getSession().getAttribute("usuario") != null) {
			return true;
		} 
		
		//Se o usuario não estiver indo para a pagina de login ou não estiver logado redirecionamos para a pagina de login
		response.sendRedirect("login");
		return false;
		
	}
}
