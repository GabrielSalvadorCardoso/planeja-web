package com.ginfohouse.planejaweb.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ginfohouse.planejaweb.dao.UserDao;
import com.ginfohouse.planejaweb.model.User;

@Controller
public class LoginController {
	//AUTENTICAÇÃO DE USUARIO
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/efetuarLogin")
	public String efetuaLogin(User user, HttpSession session) {
		System.out.println("User: " + user.getUser());
		UserDao dao = new UserDao();
		//Se o usuario existir no banco de dados adicionamos ele na sessão(fazemos login)
		if(dao.usuarioExiste(user).getUser() != null) {
			session.setAttribute("usuario", dao.usuarioExiste(user));			
			return "menu";
		} else {
			return "redirect:login";
		}
	}
	
	//CRIAÇÃO DE USUARIO
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	//O Spring preecherá o objeto User automaticamente desde que os nome dos inputs correspondam aos seus atributos
	@RequestMapping("/addUser")
	public String addUser(User user) {
		UserDao dao = new UserDao();
		dao.adiciona(user);
		
		return "usuario-adicionado";
	}
}
