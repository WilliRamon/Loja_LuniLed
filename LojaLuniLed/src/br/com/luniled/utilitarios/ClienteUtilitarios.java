package br.com.luniled.utilitarios;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import br.com.luniled.vo.Cliente;

public class ClienteUtilitarios {
	
	public final static BiFunction<ArrayList<Cliente>, Long, Boolean> isCodigoCpf = (listaCpf, cpf) -> {
		return listaCpf.stream().anyMatch(lista -> lista.getCpf() == cpf);
	};
	
	public final static Consumer<Cliente> mostarClientes = System.out::println;

}
