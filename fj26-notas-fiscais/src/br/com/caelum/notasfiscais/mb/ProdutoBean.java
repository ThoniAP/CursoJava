package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.datamodel.DataModelProdutos;
import br.com.caelum.notasfiscais.modelo.Produto;

//@ManagedBean
//@Named
//@RequestScoped
@Model
public class ProdutoBean {
	
	@Inject
	private ProdutoDao dao;
	
	private Produto produto = new Produto();
	private double soma;
	
	private List<Produto> produtos;
	
	@Inject
	private DataModelProdutos dataModel; 
	
	public DataModelProdutos getDataModel() {
		return dataModel;
	}
	
	public void comecaComMaiuscula(FacesContext fc,
			UIComponent component, Object value)
	           throws ValidatorException {
		String valor = value.toString();
		
		if (!valor.matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage ("Deveria começar com maiúscula"));
			
		}
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava() {
		System.out.println("Será que vai passar por aqui?");
//		ProdutoDao dao = new ProdutoDao();
		
		if (produto.getId() == null) {
			dao.adiciona(produto);		
		}else {
			dao.atualiza(produto);
		}
		this.produtos = dao.listaTodos();
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = dao.listaTodos();
		}
		return produtos;
	}

	public double getSoma() {
//		getProdutos();
		for (Produto produto : produtos) {
			soma = soma + produto.getPreco();
		}
		return soma;
	}	
	
	public void remove(Produto produto) {
//		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	public void cancela() {
		this.produto = new Produto();
	}

}
