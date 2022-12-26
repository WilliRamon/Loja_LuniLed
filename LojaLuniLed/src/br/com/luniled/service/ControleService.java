package br.com.luniled.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

import br.com.luniled.OpcoesInterface;
import br.com.luniled.utilitarios.ClienteUtilitarios;
import br.com.luniled.utilitarios.ProdutoUtilitarios;
import br.com.luniled.vo.Cliente;
import br.com.luniled.vo.Produto;

public class ControleService implements OpcoesInterface {

	Scanner ler = new Scanner(System.in);
	Produto produto = new Produto();
	Cliente cliente = new Cliente();
	ArrayList<Produto> listaProdutos = new ArrayList<>();
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Produto> listaDeCompras = new ArrayList<>();

	public void estoque() {
		listaProdutos.add(new Produto("Notebook", "Eletrônico", "Dell", 123l, 5, 3800));
		listaProdutos.add(new Produto("Monitor", "Eletrônico", "Concordia", 124l, 10, 1100.50));
		listaProdutos.add(new Produto("Caderno", "Papelaria", "jandaia", 125l, 20, 55.90));
	}

	public void clientes() {
		listaClientes.add(new Cliente("Willi", "Rua Osasco", 1234567, 0));
		listaClientes.add(new Cliente("Ramon", "Rua Barueri", 2345678, 0));
		listaClientes.add(new Cliente("Sabino", "Rua Itapevi", 3456789, 0));
	}

	@Override
	public void acesso() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarEstoque() {
		System.out.println("========CONSULTAR ESTOQUE========");
		listaProdutos.forEach(livro -> System.out.println(livro));
	}

	@Override
	public void consultarClientesCadastrados() {
		System.out.println("==========CONSULTAR CLINTES CADASTRADOS=======");
		listaClientes.forEach(cliente -> System.out.println(cliente));
	}

	@Override
	public void realizarVenda() {
		System.out.println("==========TELA DE VENDA=======");
		this.consultarEstoque();
		
		System.out.println("Cliente já está cadastrado? (S/N)");
		if(ler.nextLine().toUpperCase().equals("N")) {
			this.cadastrarCliente();
		}
		do {
			System.out.println("Digite CPF: ");
			cliente.setCpf(ler.nextLong());
			System.out.println("Caso esse CPF não seja encontrado, será necessário que digite novamente.");
		}while(!ClienteUtilitarios.isCpfExiste.apply(listaClientes, cliente.getCpf()));
		
		do {
			do {
				System.out.println("Digite o código do produto: ");
				produto.setCodigo(ler.nextLong());	
				System.out.println("Caso esse código não seja encontrado, será necessário digitar novamente.");
			}while(!ProdutoUtilitarios.isCodigoExiste.apply(listaProdutos, produto.getCodigo()));
			
			listaProdutos.stream()
			.filter(lista -> lista.getCodigo() == produto.getCodigo())
			.forEach(produtoEscolhido -> {
				listaDeCompras.add(produtoEscolhido);
				System.out.println(produtoEscolhido);
				produtoEscolhido.setQuantidadeEstoque(produtoEscolhido.getQuantidadeEstoque() -1);
				});
			
			System.out.println("Finalizar Venda?(S/N)");
			ler.nextLine();
		}while(!ler.nextLine().toUpperCase().equals("S"));
		
		Double totalAPagar = listaDeCompras.stream()
		.map(lista -> lista.getPreco())
		.reduce(ProdutoUtilitarios.saldoTotal).get();
		
		this.formaDePagamento(totalAPagar);

		System.out.println("Venda Finalizada! Muito Obrigado!!!");
	}

	@Override
	public void consultarVendasRealizadas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrarProduto() {
		System.out.println("========CADASTRAR PRODUTOS=======");

		do {
			System.out.println("Nome do Produto: ");
			produto.setNomeProduto(ler.nextLine());

			System.out.println("Categoria: ");
			produto.setCategoria(ler.nextLine());

			System.out.println("Marca: ");
			produto.setMarca(ler.nextLine());

			do {
				System.out.println("Codigo: ");
				produto.setCodigo(ler.nextLong());
				System.out.println("Caso esse código já esteja cadastrado, será necessário registrar outro.");

			} while (ProdutoUtilitarios.isCodigoExiste.apply(listaProdutos, produto.getCodigo()));
			
			System.out.println("Quantidade em Estoque: ");
			produto.setQuantidadeEstoque(ler.nextInt());

			System.out.println("Preço: ");
			produto.setPreco(ler.nextDouble());

			listaProdutos.add(new Produto(produto.getNomeProduto(), produto.getCategoria(),
					produto.getMarca(), produto.getCodigo(), produto.getQuantidadeEstoque(),
					produto.getPreco()));
			
			ler.nextLine();
			System.out.println("Deseja cadastrar outro produto?(S/N)");
		} while (!ler.nextLine().toUpperCase().equals("N"));
		
		System.out.println("\nProduto(s) Cadastrado(s)!!!");
		System.out.println("\n=======Estoque Atual==========");
		listaProdutos.forEach(ProdutoUtilitarios.mostrarProduto);
	}

	@Override
	public void cadastrarCliente() {
		System.out.println("========CADASTRAR CLIENTE=======");
		
		do {
			System.out.println("Nome: ");
			cliente.setNomeCliente(ler.nextLine());
		
			do {
				System.out.println("CPF: ");
				cliente.setCpf(ler.nextLong());
				System.out.println("Caso esse CPF já esteja cadastrado, será necessário registrar outro.");
			}while(ClienteUtilitarios.isCpfExiste.apply(listaClientes, cliente.getCpf()));
		
			ler.nextLine();
			System.out.println("Endereço: ");
			cliente.setEnderecoCliente(ler.nextLine());
		
			listaClientes.add(new Cliente(cliente.getNomeCliente(), cliente.getEnderecoCliente(), cliente.getCpf()));
			
			System.out.println("Deseja cadastrar outro cliente?(S/N)");
			
		}while(!ler.nextLine().toUpperCase().equals("N"));
		
		System.out.println("\nCliente(s) Cadastrado(s)!!!");
		System.out.println("\n=======Registro Atual==========");
		listaClientes.forEach(ClienteUtilitarios.mostarClientes);
		
	}

	@Override
	public void excluirProduto() {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirCliente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarVenda() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saldoTotalVendido() {
		System.out.println("========SALDO TOTAL DE VENDAS=======");
		listaProdutos.stream()
		.map(lista -> lista.getPreco())
		.reduce(ProdutoUtilitarios.saldoTotal)
		.ifPresent(System.out::println);
		//REALIZAR CORREÇÃO
		//ESTÁ CALCULANDO TODOS OS PRODUTOS EM ESTOQUE
	}
	
	public void formaDePagamento(Double saldoTotal) {
		System.out.println("\nTotal à pagar: " + saldoTotal + "\n");
		String formaPagamento;
		do {
			System.out.println("Dinheiro ou Cartão? (D/C)");
			formaPagamento = ler.nextLine();
			System.out.println("Caso não seja encontrada a forma de pagamento, será preciso digitar novamento.");
			
		}while(formaPagamento.toUpperCase().equals("D") || formaPagamento.toUpperCase().equals("C"));
		
		if(formaPagamento.toUpperCase().equals("D")) {	
			System.out.println("Informa o Valor Pago: ");
			double valorPago = ler.nextDouble();
			double troco = valorPago - saldoTotal;
			
			while(troco < 0) {
				System.out.println("Pagamento Insuficiente");
				System.out.println("Total à pagar: " + Math.abs(troco));
				System.out.println("Didite o Pagamento: ");
				double valorComplementar = ler.nextDouble();
				troco = valorPago + valorComplementar - saldoTotal;
			}
			if (troco > 0){
				System.out.println("Troco: R$ " + troco);
			}
		}
		//FINALIZAR FORMA DE PAGAMENTO
	}

}
