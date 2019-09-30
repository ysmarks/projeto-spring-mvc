package br.com.spring.test;

import java.util.List;

import br.com.spring.dao.ContatoDAO;
import br.com.spring.domain.Contato;

public class ListaTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome() + " - Email: " + contato.getEmail() + " - Endereco: " + contato.getEndereco());
		}
	}
}
