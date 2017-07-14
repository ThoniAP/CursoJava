package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraMovimentacao {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(manager);

		manager.getTransaction().begin();

		Movimentacao movimentacao = dao.busca(4);
		movimentacao.setDescricao("Conta de luz - Março/2017");
		
		manager.getTransaction().commit();
		manager.close();

		System.out.println("Movimentacao alterada com sucesso!");

	}
}
