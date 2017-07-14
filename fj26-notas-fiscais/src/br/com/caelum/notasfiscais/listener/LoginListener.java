package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.tx.EmailComercial;

public class LoginListener {
	
	@Inject @EmailComercial
	private String email;
	
	public void onLogin(@Observes Usuario usuario) {
		System.out.printf("Usuario %s se logou no sistema. ", usuario.getLogin());
		System.out.println("Enviando email: " + email);
	}

}
