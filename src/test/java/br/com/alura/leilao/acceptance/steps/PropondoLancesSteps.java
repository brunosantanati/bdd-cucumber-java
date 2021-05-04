package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLancesSteps {
	
	private Lance lance;
	private Leilao leilao;
	
	@Dado("um lance válido")
	public void dado_um_lance_válido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propõe um lance")
	public void quando_propõe_um_lance() {
		leilao = new Leilao("Tablet XPTO");
		leilao.propoe(lance);
	}
	
	@Entao("o lance é aceito")
	public void então_o_lance_é_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
}
