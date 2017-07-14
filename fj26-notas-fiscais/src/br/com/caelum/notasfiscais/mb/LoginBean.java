package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

//@ManagedBean
//@Named
//@SessionScoped
//@RequestScoped
@Model
public class LoginBean implements Serializable{
	
	@Inject
	Event<Usuario> eventoLogin;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin() {
//		UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(usuario);
		System.out.println("O login era valido?" + loginValido);
		if (loginValido) {
			eventoLogin.fire(usuario);
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		}else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public String efetuaLogout() {
		usuarioLogado.deslogar();
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
 