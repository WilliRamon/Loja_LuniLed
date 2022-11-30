package br.com.luniled.vo;

public class Produto {
	
	private String nomeProduto;
	private String categoria;
	private String marca;
	private int codigo;
	private int quantidadeEstoque;
	private double preco;
	
	public Produto() { }

	public Produto(String nomeProduto, String categoria, String marca, int codigo, int quantidadeEstoque,
			double preco) {
		this.nomeProduto = nomeProduto;
		this.categoria = categoria;
		this.marca = marca;
		this.codigo = codigo;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto: " + nomeProduto + "\nCategoria: " + categoria + "\nMarca: " + marca + "\nCodigo: "
				+ codigo + "\nQuantidade em Estoque: " + quantidadeEstoque + "\nPreco: " + preco + "\n====================";
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
