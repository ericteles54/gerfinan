package br.com.qualidadeintegrada.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.qualidadeintegrada.application.model.Conta;
import br.com.qualidadeintegrada.application.service.ContaServiceImpl;
import br.com.qualidadeintegrada.security.model.User;
import br.com.qualidadeintegrada.security.service.UserService;

@Controller
public class ContaController {

	@Autowired
	private ContaServiceImpl contaServiceImpl;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/app/contas", method = RequestMethod.GET)
	public ModelAndView conta() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app/contas");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", "Bem vindo " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Conteúdo permitido somente para usuários com perfil de Administrador");
	
		List<Conta> contas = new ArrayList<Conta>();
		contas.addAll(contaServiceImpl.findByUser(user));
		modelAndView.addObject("contas", contas);
		
		return modelAndView;
	}
	
}
