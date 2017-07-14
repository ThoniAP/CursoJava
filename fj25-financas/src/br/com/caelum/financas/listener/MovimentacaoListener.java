package br.com.caelum.financas.listener;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoListener {
	
	@PrePersist
	@PreUpdate	
	public void atualizaData(Movimentacao mov) {
		
		mov.setData(Calendar.getInstance());
	}

}
