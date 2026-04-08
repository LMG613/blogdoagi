package com.agi.qa.pages;

import org.openqa.selenium.By;

public class BlogHomePage extends BasePage {

    private final By iconLupa = By.cssSelector("[aria-label='Search icon link']");
    private final By cmpPesquisa = By.cssSelector("input[class='search-field']");
    private final By btnPesquisar = By.id("search_submit");

    public void acessarBlog() {
        String baseUrl = System.getProperty("base.url", "https://blogdoagi.com.br/");
        driver.get(baseUrl);
    }

    public void clicarLupaPesquisa() {
        action.click(iconLupa, "lupa de pesquisa");
    }

    public void pesquisarPor(String termo) {
        action.sendKeys(cmpPesquisa, termo, "campo de pesquisa");
    }

    public void submeterPesquisa() {
        action.click(btnPesquisar, "botão de pesquisar");
    }
}