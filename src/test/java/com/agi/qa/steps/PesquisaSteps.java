package com.agi.qa.steps;

import com.agi.qa.pages.BlogHomePage;
import com.agi.qa.pages.SearchResultsPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class PesquisaSteps {

    private BlogHomePage homePage = new BlogHomePage();
    private SearchResultsPage resultsPage = new SearchResultsPage();

    @Dado("que eu acesso a pagina inicial do Blog do Agi")
    public void queEuAcessoAPaginaInicialDoBlogDoAgi() {
        homePage.acessarBlog();
    }

    @Quando("eu clico na lupa de pesquisa")
    public void euClicoNaLupaDePesquisa() {
        homePage.clicarLupaPesquisa();
    }

    @E("busco pelo termo {string}")
    public void buscoPeloTermo(String termo) {
        homePage.pesquisarPor(termo);
    }

    @E("submeto a pesquisa")
    @E("submeto a pesquisa sem preencher nenhum termo")
    public void submetoAPesquisa() {
        homePage.submeterPesquisa();
    }

    @Então("vejo a lista de artigos relacionados ao termo buscado")
    public void vejoAListaDeArtigosRelacionadosAoTermoBuscado() {
        Assertions.assertTrue(resultsPage.validarArtigosListadosPesquisa(), "Artigos deveriam aparecer.");
    }

    @Então("vejo uma mensagem informando que nenhum resultado foi encontrado")
    public void vejoUmaMensagemInformandoQueNenhumResultadoFoiEncontrado() {
        Assertions.assertEquals("No results found",
                resultsPage.getMensagemSemResultadosPesquisa(),
                "Mensagem de feedback de erro não encontrada.");
    }

    @E("nao vejo artigos listados na pagina")
    public void naoVejoArtigosListadosNaPagina() {
        Assertions.assertFalse(resultsPage.validarArtigosListadosPesquisa(), "A lista de artigos deveria estar vazia.");
    }

    @Então("sou redirecionado para a pagina de resultados com os ultimos artigos")
    public void souRedirecionadoParaAPaginaDeResultadosComOsUltimosArtigos() {
        validarPaginaDeResultados();
        Assertions.assertTrue(resultsPage.validarArtigosListadosPaginaDeResultados(), "Artigos deveriam aparecer.");
    }

    @Então("sou redirecionado para a pagina de resultados mas nenhum resultado deve ser apresentado")
    public void souRedirecionadoParaAPaginaDeResultadosMasNenhumResultadoDeveSerApresentado() {
        validarPaginaDeResultados();
        Assertions.assertEquals("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.",
                resultsPage.getMensagemSemResultadosPaginaDeResultados(),
                "Mensagem indicando que nenhum resultado foi encontrado não apareceu na tela.");
    }

    private void validarPaginaDeResultados() {
        Assertions.assertEquals("Resultados encontrados para:",
                resultsPage.validarPaginaDeResultados(),
                "Nenhuma mensagem de feedback de resultados encontrados.");
    }
}