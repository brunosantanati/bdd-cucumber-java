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
	private Lance lance10;
	private Lance lance15;
	
	@Dado("um lance válido")
	public void dado_um_lance_válido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
		
		leilao = new Leilao("Tablet XPTO");
	}

	@Quando("propõe ao leilao")
	public void quando_propõe_um_lance() {
		leilao.propoe(lance);
	}
	
	@Entao("o lance é aceito")
	public void então_o_lance_é_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	/*
	 * @Dado("vários lances válidos") public void vários_lances_válidos() { Usuario
	 * usuario1 = new Usuario("fulano"); lance10 = new Lance(usuario1,
	 * BigDecimal.TEN);
	 * 
	 * Usuario usuario2 = new Usuario("beltrano"); lance15 = new Lance(usuario2, new
	 * BigDecimal("15.0"));
	 * 
	 * leilao = new Leilao("Tablet XPTO"); }
	 */
	
//	@Dado("um lance de {double} reais do usuário {string}")
//	public void um_lance_de_reais_do_usuário_fulano(Double valor, String nomeUsuario) {
//		System.out.println(valor + " " + nomeUsuario);
//	}
	
	@Dado("^um lance de (\\d+[.]\\d\\d?) reais do usuário (\\w+)$")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
	    System.out.println(valor);
	    System.out.println(nomeUsuario);
	}

	@Quando("propõe vários lances ao leilao")
	public void propõe_vários_lances_ao_leilao() {
		leilao.propoe(lance10);
		leilao.propoe(lance15);
	}
	
	@Entao("os lances são aceitos")
	public void os_lances_são_aceitos() {
		Assert.assertEquals(2, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	}
	
}
