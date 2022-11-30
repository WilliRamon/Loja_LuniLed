package br.com.luniled.main;

import br.com.luniled.service.ControleService;

public class TelaPrincipal {
	
	public static void main(String[] args) {
		
		ControleService service = new ControleService();
		
		service.estoque();
//		service.consultarEstoque();
		service.cadastrarProduto();
		service.consultarEstoque();
		
	}

}
