package br.com.luniled;

public interface OpcoesInterface {
	
	public abstract void acesso();
	
	public abstract void consultarEstoque();
	
	public abstract void consultarClientesCadastrados();
	
	public abstract void realizarVenda();
	
	public abstract void consultarVendasRealizadas();
	
	public abstract void cadastrarProduto();
	
	public abstract void cadastrarCliente();
	
	public abstract void excluirProduto();
	
	public abstract void excluirCliente();
	
	public abstract void cancelarVenda();
	
	public abstract void totalVendido();

}