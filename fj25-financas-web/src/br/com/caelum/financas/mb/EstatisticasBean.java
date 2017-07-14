package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;


@Named
@ApplicationScoped
public class EstatisticasBean {
	
	@Inject
	private EntityManager manager;
	
	private Statistics estatisticas;

		public void gera() {
			Session session = this.manager.unwrap(Session.class);
			manager.close();
			this.estatisticas = session.getSessionFactory().getStatistics();
			System.out.println("Gerando estatisticas");
		}

		public final Statistics getEstatisticas() {
			return estatisticas;
		}

		public final void setEstatisticas(Statistics estatisticas) {
			this.estatisticas = estatisticas;
		}
		
		
}
