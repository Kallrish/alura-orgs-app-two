# Projeto Orgs App

Olá, este repositório contém a implementação de código do segundo curso da Formação Android da Alura.
O código deste respositório tem a implementação extra do desafio proposto na descrição do curso (e que é comentado logo abaixo).

Abaixo deixo a explicação do repositório original:

![Thumbnail GitHub](https://user-images.githubusercontent.com/8989346/123294187-ff901300-d4ea-11eb-963c-ac1561afac6f.png)

![](https://img.shields.io/github/license/alura-cursos/android-com-kotlin-personalizando-ui)

# Orgs

App de simulação de um e-commerce para produtos naturais para o curso de personalização de UI no Android com Kotlin.

## 🔨 Funcionalidades do projeto

O App lista produtos com imagem, título, descrição e valor. Também, é possível cadastrar produtos. Todo armazenamento é mantido em memória do App, portanto, ao finalizar o App as informações são perdidas.

![](img/amostra.gif)

## ✔️ Técnicas e tecnologias utilizadas

As técnicas e tecnologias utilizadas pra isso são:

- `CardView`: container para apresentar cada produto na lista de produtos
- `RecyclerView`: listagem das produtos
- `ConstraintLayout`: ViewGroup padrão para implementar todos os layouts
- `ImageView`: View para apresentar imagens no App
- `Coil`: carregar imagens via requisição HTTP
- `View Binding`: busca de views do layout de forma segura
- `AlertDialog`: Exibição de formulário para carregar novas imagens do produto
- `Fontes personalizadas`: configuração para adicionar novas fontes
- `Extension functions`: adicionar comportamentos em outras classes para reutilizá-los
- `Personalização de tema`: modificação de cores para o tema do App

## 🎯 Desafio

Tela de detalhes do produto

![orgs-desafio-detalhes](https://user-images.githubusercontent.com/8989346/124600562-3a743e00-de3d-11eb-9d45-15e8a8d2976f.gif)
