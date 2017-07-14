package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transacional;

@Transacional
public class ProdutoDao implements Serializable{
	
	@Inject
	private EntityManager manager;

	private static final long serialVersionUID = 1L;

	public void adiciona(Produto produto) {
//		EntityManager manager = new JPAUtil().getEntityManager();
//		manager.getTransaction().begin();

		//persiste o objeto
		manager.persist(produto);
		
//		manager.getTransaction().commit();
//		manager.close();
	}
	
	public int contaTodos() {
		long result = (Long) manager.createQuery("select count(n) from Produto n").getSingleResult();
		
		return (int) result;
	}


	public void remove(Produto produto) {
//		EntityManager manager = new JPAUtil().getEntityManager();
//		manager.getTransaction().begin();

		manager.remove(manager.merge(produto));

//		manager.getTransaction().commit();
//		manager.close();
	}

	public void atualiza(Produto produto) {
//		EntityManager manager = new JPAUtil().getEntityManager();
//		manager.getTransaction().begin();

		manager.merge(produto);
		
//		manager.getTransaction().commit();
//		manager.close();
	}

	public List<Produto> buscaPorNome(String nome) {

//		EntityManager manager = new JPAUtil().getEntityManager();

		String jpql = "select p from Produto p where "
				+ " lower(p.nome) like :nome order by p.nome";

		List<Produto> lista = manager.createQuery(jpql, Produto.class)
				.setParameter("nome", nome + "%").getResultList();

//		manager.close();
		
		return lista; 
	}

	public List<Produto> listaTodos() {
//		EntityManager manager = new JPAUtil().getEntityManager();
		
		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));

		List<Produto> lista = manager.createQuery(query).getResultList();

//		manager.close();
		
		return lista; 
	}
	
	public List<Produto> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));

		List<Produto> lista = manager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
	public Produto buscaPorId(Long id) {
//		EntityManager manager = new JPAUtil().getEntityManager();

		Produto produto = manager.find(Produto.class, id);

//		manager.close();

		return produto;
	}
}