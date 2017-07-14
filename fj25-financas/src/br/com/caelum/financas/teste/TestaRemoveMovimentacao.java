package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveMovimentacao {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		manager.getTransaction().begin();
		
		Movimentacao movimentacao = dao.busca(2);
		dao.remove(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Movimentacao removida com sucesso!");
		
	}

}
