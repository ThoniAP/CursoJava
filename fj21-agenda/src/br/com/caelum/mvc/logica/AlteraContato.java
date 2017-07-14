package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContato implements Logica{
	
	public String executa(HttpServletRequest req, HttpServletResponse res)
	        throws Exception {
		PrintWriter out = res.getWriter();
		
		long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.atualiza(contato);
		
		System.out.println("Atualizando contato...");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
