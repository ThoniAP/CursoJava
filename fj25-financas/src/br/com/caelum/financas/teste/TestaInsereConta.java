package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		
//		EntityManager manager = factory.createEntityManager();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Jose");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("12345-6");
		conta.setAgencia("0001");
		
		manager.getTransaction().begin();
		
//		manager.persist(conta);
		dao.adiciona(conta);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso!");
	}

}
