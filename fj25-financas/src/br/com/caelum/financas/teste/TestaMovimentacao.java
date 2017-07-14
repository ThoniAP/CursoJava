package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		Conta conta = manager.find(Conta.class, 3);
		
//		Conta conta = new Conta();
//		conta.setBanco("Bradesco");
//		conta.setNumero("12345");
//		conta.setAgencia("123");
//		conta.setTitular("Daniel");
//		conta.setId(1);
		
//		manager.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
//		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz - Março/2017");
		movimentacao.setValor(new BigDecimal("54"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
//		manager.persist(movimentacao);
		
		dao.adiciona(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Movimentação realizada com sucesso !!!");
	}

}
