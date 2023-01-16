package br.com.luniled.main;

import java.util.Scanner;

import br.com.luniled.service.ControleService;

public class TelaPrincipal {

	public static void main(String[] args) {
		
		//NÃO ESTÁ VENDENDO PRODUTOS NOVOS CADASTRADOS

		ControleService service = new ControleService();
		Scanner ler = new Scanner(System.in);
		int escolha = 0;

		service.estoque();
		service.clientes();
		do {
			// service.acesso();
			System.out.println("Seja bem vindo a mais um dia!!!");
			System.out.println("==================================================");
			System.out.println("Digite 1: Para Consultar o Estoque\n");
			System.out.println("Digite 2: Para Consultar Cadastros dos Clientes \n");
			System.out.println("Digite 3: Para Realizar Venda\n");
			System.out.println("Digite 4: Para Cadastrar Produto\n");
			System.out.println("Digite 5: Para Cadastrar Cliente\n");
			System.out.println("Digite 6: Para Remover Produto do Estoque\n");
			System.out.println("Digite 7: Para Excluir Cadastro de Cliente\n");
			System.out.println("Digite 8: Consultar Todos os Produto Vendidos\n");
			System.out.println("Digite 9: Consultar Saldo Total Vendido\n");
			System.out.println("Digite 10: Para Sair");
			System.out.println("==================================================");
			escolha = ler.nextInt();

			switch (escolha) {
			case 1:
				service.consultarEstoque();
				break;
			case 2:
				service.consultarClientesCadastrados();
				;
				break;
			case 3:
				service.realizarVenda();
				break;
			case 4:
				service.cadastrarProduto();
				break;
			case 5:
				service.cadastrarCliente();
				break;
			case 6:
				service.excluirProduto();
				break;
			case 7:
				service.excluirCliente();
				break;
			case 8:
				service.consultarVendasRealizadas();
				break;
			case 9:
				service.saldoTotalVendido();
				break;
			default:
				System.out.println("Comando não encontrado");
				break;
			}
		} while (escolha != 10);
		System.out.println("Até Amanhã!!!");
	}

}
