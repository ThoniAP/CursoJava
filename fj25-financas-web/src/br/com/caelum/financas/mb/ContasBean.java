package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

@Named
@ViewScoped
public class ContasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ContaDao contaDao;
    
	private Conta conta = new Conta();
	
	private List<Conta> contas;

	public Conta getConta() {
		this.contas = contaDao.lista();	
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		if (conta.getId() != null) {
			contaDao.altera(conta);
		}else {
			contaDao.adiciona(conta);
			System.out.println("Gravando a conta");	
		}

		limpaFormularioDoJSF();
		this.contas = contaDao.lista();
	}

	public List<Conta> getContas() {
		if (this.contas == null) {
			this.contas = contaDao.lista();			
		}
		System.out.println("Listando as contas");

		return contas;
	}

	public void remove() {
		Conta contaARemover = contaDao.busca(conta.getId());
		
		contaDao.remove(contaARemover);
		System.out.println("Removendo a conta");

		limpaFormularioDoJSF();
		this.contas = contaDao.lista();	
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
