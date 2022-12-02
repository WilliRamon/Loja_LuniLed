package br.com.luniled.utilitarios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import br.com.luniled.vo.Produto;

public class ProdutoUtilitarios {
	
//	BiFunction<Produto, Integer, Boolean> isCodigoExiste = (produto, codigo) -> {
//		produto.stream().filter();
//	};

//	public final static BiFunction<ArrayList<Produto>, Integer, Boolean> isCodigoExiste = (produto, codigo) -> {
//		return produto.stream() == codigo;
//	};
	
	public final static Consumer<Produto> mostrarProduto = System.out::println;
	
}
