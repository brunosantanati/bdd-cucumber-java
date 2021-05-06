package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLancesSteps {

	private Lance lance;
	private Leilao leilao;
	private ArrayList<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
		//System.out.println("before");
	}

//	@After
//	public void tearDown() {
//		System.out.println("after");
//	}
//	
//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("before step");
//	}
//	
//	@AfterStep
//	public void afterStep() {
//		System.out.println("after step");
//	}
	
	// #### Um lance válido ####
	
	@Dado("um lance válido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propõe ao leilao")
	public void quando_propoe_um_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance é aceito")
	public void entao_o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	// #### Vários lances válidos ####
	
//	 @Dado("vários lances válidos") public void varios_lances_validos() { 
//		 Usuario usuario1 = new Usuario("fulano"); 
//		 lance10 = new Lance(usuario1, BigDecimal.TEN);
//	 
//		 Usuario usuario2 = new Usuario("beltrano"); 
//		 lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//		  
//		 leilao = new Leilao("Tablet XPTO"); 
//	 }

	@Dado("um lance de {double} reais do usuário {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lance);
	}

//	@Dado("^um lance de (\\d+[.]\\d\\d?) reais do usuário (\\w+)$")
//	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
//	    System.out.println(valor);
//	    System.out.println(nomeUsuario);
//	}

	@Quando("propõe vários lances ao leilão")
	public void propoe_varios_lances_ao_leilao() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances são aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(this.lista.size(), leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
	
	// #### Lances inválidos (usando Scenario Outline/Examples ou Esquema do Cenário/Exemplos) ####
	
	@Dado("um lance inválido de {double} reais e do usuário {string}")
	public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
		//System.out.println(nomeUsuario);
	    this.lance = new Lance(new BigDecimal(valor));
	}

	@Entao("o lance não é aceito")
	public void o_lance_nao_eh_aceito() {
	    Assert.assertEquals(0, leilao.getLances().size());
	}
	
	// ### Dois lances seguidos do mesmo usuário ###
	
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
//	    List<String> valores = dataTable.asList();
//	    for(String valor: valores) {
//	    	System.out.println(valor);
//	    }
		
		List<Map<String, String>> valores = dataTable.asMaps();
		for(Map<String, String> mapa : valores) {
			
			String valor = mapa.get("valor");
			String nome = mapa.get("nomeUsuario");
			
			Lance lance = new Lance(new Usuario(nome), new BigDecimal(valor));
			this.lista.add(lance);
		}
	    
	}
	
	@Dado("dois lances do mesmo usuário com os valores:")
	public void dois_lances_do_mesmo_usuario_com_os_valores(List<String> valores) {
	    valores.forEach(valor -> this.lista.add(new Lance(new Usuario("Fulano"), new BigDecimal(valor))));
	}
	
	@Entao("o segundo lance não é aceito")
	public void o_segundo_lance_nao_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}

}
