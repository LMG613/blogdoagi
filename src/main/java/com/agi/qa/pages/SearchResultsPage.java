package com.agi.qa.pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

    private final By listArtigosPesquisa = By.cssSelector("[aria-label='Search results'] a[href]");
    private final By msgSemResultadosPesquisa = By.cssSelector("[aria-label='Search results'] label[class='ast-search--no-results-heading']");

    private final By titleResultadosEcontrados = By.cssSelector("h1[class='page-title ast-archive-title']");
    private final By listArtigosPaginaDeResultados = By.cssSelector("#main article");
    private final By msgSemResultadosPaginaDeResultados = By.cssSelector("section[class='no-results not-found'] p");

    public boolean validarArtigosListadosPesquisa() {
        return action.isVisible(listArtigosPesquisa,
                "lista de artigos na pesquisa");
    }

    public String getMensagemSemResultadosPesquisa() {
        return action.getText(msgSemResultadosPesquisa,
                "mensagem de sem resultados para a pesquisa").trim();
    }

    public String validarPaginaDeResultados() {
        return action.getText(titleResultadosEcontrados,
                "titulo de página de resultados").trim();
    }

    public boolean validarArtigosListadosPaginaDeResultados() {
        return action.isVisible(listArtigosPaginaDeResultados,
                "lista de artigos na página de resultados");
    }

    public String getMensagemSemResultadosPaginaDeResultados() {
        return action.getText(msgSemResultadosPaginaDeResultados,
                "mensagem de sem resultados na página de resultados").trim();
    }
}