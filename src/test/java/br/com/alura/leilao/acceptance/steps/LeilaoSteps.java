package br.com.alura.leilao.acceptance.steps;

public class LeilaoSteps implements io.cucumber.java8.Pt{
	
	public LeilaoSteps() {
		Dado("um usuario logado", () -> {
			System.out.println("step 1");
		});
		
		Quando("acessa a pagina de novo leilao", () -> {
			System.out.println("step 2");
		});
		
		Quando("prenche o formulario com dados validos", () -> {
			System.out.println("step 3");
		});

		Entao("volta para a pagina de leiloes", () -> {
			System.out.println("step 4");
		});
		
		Entao("o novo leilao aparece na tabela", () -> {
			System.out.println("step 5");
		});
	}
}
