package br.com.spring.test;

import br.com.spring.dao.ContatoDAO;
import br.com.spring.domain.Contato;

public class RemoveTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		contato.setId(1l);
		if (contato.getId() == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			dao.remover(contato);
		}
	}

}
