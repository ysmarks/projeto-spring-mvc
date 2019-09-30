package br.com.spring.test;

import java.util.Calendar;

import br.com.spring.dao.ContatoDAO;
import br.com.spring.domain.Contato;

public class ContatoTest {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Paola Oliveira");
		contato.setEmail("oliveira@email.com"
				);
		contato.setEndereco("Rua das Belezas");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Contato: " + " - " + contato.getId() + " - " + contato.getNome() + " adicionado com sucesso!");
	}
}
