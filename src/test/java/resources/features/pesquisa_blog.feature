# language: pt
@pesquisa @web
Funcionalidade: Pesquisa de artigos no Blog do Agi
  Como um leitor do Blog do Agi
  Quero poder pesquisar por assuntos do meu interesse
  Para encontrar artigos relevantes rapidamente

  Contexto:
    Dado que eu acesso a pagina inicial do Blog do Agi

  Cenário: Pesquisa com resultados exatos
    Quando eu clico na lupa de pesquisa
    E busco pelo termo "investimentos"
    Então vejo a lista de artigos relacionados ao termo buscado

  Cenário: Pesquisa sem resultados encontrados
    Quando eu clico na lupa de pesquisa
    E busco pelo termo "xyzqwerty"
    Então vejo uma mensagem informando que nenhum resultado foi encontrado
    E nao vejo artigos listados na pagina

  Cenário: Acionar pesquisa sem preencher termo (Busca Vazia)
    Quando eu clico na lupa de pesquisa
    E submeto a pesquisa sem preencher nenhum termo
    Então sou redirecionado para a pagina de resultados com os ultimos artigos

  Cenário: Pesquisa com caracteres especiais
    Quando eu clico na lupa de pesquisa
    E busco pelo termo "@#$%"
    Então vejo uma mensagem informando que nenhum resultado foi encontrado
    Quando submeto a pesquisa
    Então sou redirecionado para a pagina de resultados mas nenhum resultado deve ser apresentado