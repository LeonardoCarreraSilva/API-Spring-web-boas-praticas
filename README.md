[![licence mit](https://img.shields.io/badge/licence-MIT-blue.svg)](https://img.shields.io/github/license/LeonardoCarreraSilva/modelo-api-rest-spring-lombok)

# Modelo-api-rest-spring-lombok
:rocket: Aqui você ira encontrar um modelo de API Spring, com intuito de acelerar sua codificação.


## Requisitos 

 - Sprong tools ou qualquer IDE Java de sua preferencia
 - JDK Instalado

## Passo a Passo
- Importe o projeto maven
- Aguarde o maven instalar todas as dependência 
- Vá ao arquivo ApiRestBoasPraticasApplication.java
- Execute o mesmo
- Abra o site http://localhost:8080/swagger-ui.html

## Criando seus endpoints
Para criarmos um **Endpoint** temos temos que entender a estrutura utilizada!
Caso tenha que incluir um Endpoint que fará  um insert em uma tabela, teremos que primeiro criar um modelo dessa tabela,
observe no package **(com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model)** notamos que como o projeto utiliza Hibernate, ele criara uma tabela no banco de dados, tornando cada uma das nossas propriedades da classe em uma coluna, no nosso caso esse banco esta rodando em memória, para termos acesso basta acessar o link (http://localhost:8080/h2-console).

Após criarmos nosso modelos temos que criar um Repository para o mesmo no package **(com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository)** por padrão damos o nome do Modelo + Repository Ex: PessoaRepository.java.
A estrutura utilizada e muito simples, temos apenas que extender a classe JpaRepository passando como parâmetro dentro dos  <1, 2 >  1= Objeto modelo, 2=tipo do ID, com isso ja temos acesso aos principais métodos de persistência.

Chegamos ao principal, vamos finalmente criar nosso **ENDPOINT**, para isso vamos criar um arquivo Controller no package **(com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller)** o padrão de nomenclatura sera o mesmo adotado no Repository, sera de suma importância entendermos os comentários a cima da classe e métodos.

Logo a cima da classe temos dois comentários **@RestController e @RequestMapping(“/pessoa”)**,
@RestController dirá ao Spring que essa classe contra EndPoints, @RequestMapping(“/pessoa”) denominara o caminho raiz para as requisições nesse caso (localHost:8080/pessoa) sera a base.

Dentro da classe temos que “Autorizar” o nosso Repository instanciando ele e comentando com **@Autowired**.

Criaremos nossos endpoints com métodos, podemos que ter alguns tipos de retorno os mais utilizado são **Page<object> e ResponseEntity<object>**,
O Page retornara um json ja com paginação, podendo editar como necessário, ja o ResponseEntity retornara um json padrão com as informações.

Temos que comentar nosso método com oque ele representara na nossa requisição (GET, POST, PUT, DELETE) com as notações **(@GetMapping, @PostMapping, @PutMapping, @DeleteMapping)**, podemos ainda passar parâmetros como por exemplo **@GetMapping(“/{id}")**
Para passarmos um id em específico.

Nos parâmetros do método requerir uma informação em específico utilizando a anotação **@RequestBody** , ou estarmos o id citado a cima com **@PathVariable**.

Com essas informações mais estudos e analise do código exemplo, voce ja tem grande parte do conhecimento necessário para começar a brincar com esse projeto, não se esqueça sempre teste, clone, quebre conserte, entenda oque esta acontecendo, se voce ficou com alguma duvida meu email esta disponível logo a baixo  


## License
[MIT License](https://github.com/LeonardoCarreraSilva/modelo-api-rest-spring-lombok/blob/master/LICENSE) © [Leonardo Carrera da Silva](https://www.linkedin.com/in/leonardo-carrera-da-silva) leonardosilva.ads@hotmail.com



