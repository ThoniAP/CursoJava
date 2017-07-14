package br.com.caelum.financas.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.service.Agendador;

@Named
@RequestScoped
public class AgendadorFormBean {
	
	@Inject
	private Agendador agendador;

	private String expressaoMinutos;
	private String expressaoSegundos;
	

	public void agendar() {
		agendador.agenda(expressaoMinutos, expressaoSegundos);
		
	}

	public String getExpressaoMinutos() {
		return expressaoMinutos;
	}

	public void setExpressaoMinutos(String expressaoMinutos) {
		this.expressaoMinutos = expressaoMinutos;
	}

	public String getExpressaoSegundos() {
		return expressaoSegundos;
	}

	public void setExpressaoSegundos(String expressaoSegundos) {
		this.expressaoSegundos = expressaoSegundos;
	}

}
