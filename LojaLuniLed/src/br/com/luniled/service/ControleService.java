package br.com.luniled.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
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

	public void estoque() {
		listaProdutos.add(new Produto("Notebook", "Eletrônico", "Dell", 123, 5, 3800));
		listaProdutos.add(new Produto("Monitor", "Eletrônico", "Concordia", 124, 10, 1100.50));
		listaProdutos.add(new Produto("Caderno", "Papelaria", "jandaia", 125, 20, 55.90));
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
		// TODO Auto-generated method stub

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
				produto.setCodigo(ler.nextInt());
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
			System.out.println("Deseja cadastrar outro produto?\nDigite Sim ou Não.");
		} while (!ler.nextLine().toUpperCase().equals("NÃO"));
		
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
			}while(ClienteUtilitarios.isCodigoCpf.apply(listaClientes, cliente.getCpf()));
		
			ler.nextLine();
			System.out.println("Endereço: ");
			cliente.setEnderecoCliente(ler.nextLine());
		
			listaClientes.add(new Cliente(cliente.getNomeCliente(), cliente.getEnderecoCliente(), cliente.getCpf()));
			
			System.out.println("Deseja cadastrar outro cliente?\nDigite Sim ou Não.");
			
		}while(!ler.nextLine().toUpperCase().equals("NÃO"));
		
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
	public void totalVendido() {
		// TODO Auto-generated method stub

	}

}
