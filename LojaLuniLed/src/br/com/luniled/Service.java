package br.com.luniled;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Service implements OpcoesInterface{
	
	Scanner ler = new Scanner(System.in);
	Produto produto = new Produto();
	Cliente cliente = new Cliente();
	ArrayList<Produto> listaProdutos = new ArrayList<>();
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	Consumer<String> print = System.out::println;
	Consumer<ArrayList<Produto>> print2 = System.out::println;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrarCliente() {
		// TODO Auto-generated method stub
		
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
