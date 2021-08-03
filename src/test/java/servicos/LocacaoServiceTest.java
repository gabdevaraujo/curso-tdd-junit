package servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	
	@Test
	public void teste() {
		
		//cenario
		LocacaoService locacaoService = new LocacaoService();
		
		Usuario usuario = new Usuario("Teste");
		Filme filme = new Filme("Teste FIlme", 5, 10.00);
		
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);


		//verificaoção
		errorCollector.checkThat(locacao.getValor(), is(5.0));
		errorCollector.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		errorCollector.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(false));
	}
}