package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;

public class LeilaoSteps implements io.cucumber.java8.Pt{
	
	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;

	public LeilaoSteps() {
		Dado("um usuario logado", () -> {
			browser = new Browser();
			browser.seed();
			loginPage = browser.getLoginPage();
			leiloesPage = loginPage.realizaLoginComoFulano();
		});
		
		Quando("acessa a pagina de novo leilao", () -> {
			novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
		});
		
		Quando("prenche o formulario com dados validos", () -> {
			this.leiloesPage = this.novoLeilaoPage.preencheForm("PC Novo", "1500", "01/11/2020");
		});

		Entao("volta para a pagina de leiloes", () -> {
			Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
		});
		
		Entao("o novo leilao aparece na tabela", () -> {
			Assert.assertTrue(this.leiloesPage.existe("PC Novo", "1500", "01/11/2020", "fulano"));
			this.browser.clean();
		});
	}
}
