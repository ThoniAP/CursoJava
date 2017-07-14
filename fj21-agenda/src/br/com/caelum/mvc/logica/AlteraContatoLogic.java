package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;

public class AlteraContatoLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res)
	        throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
//		Contato contato = new Contato();
//		contato.setId(id);
		
		req.setAttribute("contato", new ContatoDao().pesquisa(id));
				
		return "altera-contato.jsp";
		
	}

}
