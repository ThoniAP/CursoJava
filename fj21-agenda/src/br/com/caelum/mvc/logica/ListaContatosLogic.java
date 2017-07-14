package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;

public class ListaContatosLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res)
	        throws Exception  {
		
		
		req.setAttribute("contatos", new ContatoDao().getLista());
		
		return "lista-contatos.jsp";
		
	}

}
