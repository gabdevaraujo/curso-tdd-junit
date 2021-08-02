package servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Test
	public void teste() {
		
		//cenario
		LocacaoService locacaoService = new LocacaoService();
		
		Usuario usuario = new Usuario("Teste");
		Filme filme = new Filme("Teste FIlme", 5, 10.00);
		
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);


		//verificaoção
		Assert.assertTrue(locacao.getValor() == 10.00);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}