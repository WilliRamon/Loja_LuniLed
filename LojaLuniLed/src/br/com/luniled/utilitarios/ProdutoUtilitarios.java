package br.com.luniled.utilitarios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import br.com.luniled.vo.Produto;

public class ProdutoUtilitarios {
	
	public final static BiFunction<ArrayList<Produto>, Long, Boolean> isCodigoExiste = (listaProduto, codigo) -> {
		return listaProduto.stream().anyMatch(lista -> lista.getCodigo() == codigo);
	};
	
	public final static Consumer<Produto> mostrarProduto = System.out::println;
	
	public final static Consumer<String> mostrarProdutoInString = System.out::println;
	
	public final static BinaryOperator<Double> saldoTotal = (ac, n) -> ac + n;
	
	public final static Predicate<String> isFormaPagamento = escolha -> {
		if(escolha.equalsIgnoreCase("D")) {return false;}
		else if(escolha.equalsIgnoreCase("C")) {return false;}
		return true;
	};
	
	public final static BinaryOperator<Double> calcularTroco = (valorPago, saldoTotal) ->
	{return valorPago - saldoTotal;};
	
	public final static BinaryOperator<Double> calcularTrocoComplementar = (troco, valorComplementar) ->
	{return troco + valorComplementar;};
	
	public final static Function<Produto, String> mapearNomeProduto = produto -> produto.getNomeProduto();
	
	public final static Function<Produto, Double> mapearPrecoProduto = lista -> lista.getPreco();
}
