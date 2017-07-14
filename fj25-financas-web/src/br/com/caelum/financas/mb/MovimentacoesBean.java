package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.CategoriaDao;
import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Named
@ViewScoped
public class MovimentacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovimentacaoDao movimentacaoDao;
	@Inject
	private ContaDao contaDao;
	@Inject
	private CategoriaDao categoriaDao;
	
	private List<Movimentacao> movimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private Integer categoriaId;
	private List<Categoria> categorias;
	
	
	public void grava() {
		if (movimentacao.getId() != null) {
			movimentacaoDao.altera(movimentacao);	
		}else {
			Conta contaRelacionada = contaDao.busca(contaId);
			movimentacao.setConta(contaRelacionada);
			
			movimentacaoDao.adiciona(movimentacao);
			System.out.println("Fazendo a gravacao da movimentacao");
		}
				
		limpaFormularioDoJSF();
		this.movimentacoes = movimentacaoDao.listaComCategorias();
	}
	

	public void remove() {
		Movimentacao movARemover = movimentacaoDao.busca(movimentacao.getId());
		
		movimentacaoDao.remove(movARemover);
		
		System.out.println("Removendo a movimentacao");

		limpaFormularioDoJSF();
		this.movimentacoes = movimentacaoDao.listaComCategorias();
	}

	public List<Movimentacao> getMovimentacoes() {
		if (this.movimentacoes == null) {
			this.movimentacoes = movimentacaoDao.lista();
			
		}
		System.out.println("Listando movimentação");
		return movimentacoes;
	}
	
	public void adicionaCategoria() {
		if(this.categoriaId != null && this.categoriaId > 0) {
			Categoria categoria = categoriaDao.procura(this.categoriaId);
			this.movimentacao.getCategorias().add(categoria);
		}
	}
	
	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(LocalDateTime.now());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public List<Categoria> getCategorias() {
		if (this.categorias == null) {
			System.out.println("Listando as categorias");
			this.categorias = this.categoriaDao.lista();
		}
		return categorias;
	}


	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
}
