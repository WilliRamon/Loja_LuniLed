package br.com.luniled.vo;

public class Cliente {
	
	private String nomeCliente;
	private String enderecoCliente;
	private long cpf;
	private int quantidadeCompras;
	
	public Cliente() { }
	
	public Cliente(String nomeCliente, String enderecoCliente, long cpf) {
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.cpf = cpf;
		this.quantidadeCompras = 0;
	}

	public Cliente(String nomeCliente, String enderecoCliente, long cpf, int quantidadeCompras) {
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.cpf = cpf;
		this.quantidadeCompras = quantidadeCompras;
	}

	@Override
	public String toString() {
		return "Cliente: " + nomeCliente + "\nEndereco: " + enderecoCliente + "\nCpf: " + cpf
				+ "\nQuantidade de Compras: " + quantidadeCompras + "\n====================";
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public int getQuantidadeCompras() {
		return quantidadeCompras;
	}
	public void setQuantidadeCompras(int quantidadeCompras) {
		this.quantidadeCompras = quantidadeCompras;
	}

}
