package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.ViewModel;

//@Named
//@RequestScoped
//@ViewScoped
@ViewModel
public class NotaFiscalBean implements Serializable{
	
	private Item item = new Item();
	private Long idProduto;
	
	@Inject
	private ProdutoDao produtoDao;
	
	private NotaFiscal notaFiscal = new NotaFiscal();
	
	@Inject
	private NotaFiscalDao notaFiscaoDao;
	
	@Inject
	private DataModelNotasFiscais dataModel;
	
	public void gravar() {
		this.notaFiscaoDao.adiciona(notaFiscal);
		this.notaFiscal = new NotaFiscal();
	}
	
	public void guardaItem() {
		
		Produto produto = produtoDao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
		idProduto = null;
	}
	
	public List<NotaFiscal> listaNotaFiscal() {
		return this.notaFiscaoDao.listaTodos();
		
	}
	
	public DataModelNotasFiscais getDataModel() {
		return dataModel;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	

}
