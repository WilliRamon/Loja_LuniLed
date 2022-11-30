package br.com.luniled;

public class TelaPrincipal {
	
	public static void main(String[] args) {
		
		Service service = new Service();
		
//		service.estoque();
//		service.consultarEstoque();
		
		service.clientes();
		service.consultarClientesCadastrados();
	}

}
