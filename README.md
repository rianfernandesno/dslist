API que retorna uma lista de jogos, seguindo boas práticas e utilizando a criação de um DTO para ser o retorno da API. A entidade Belonging pode servir como uma referência de posicionamento para o frontend.

**Tecnologias**
+ Spring Boot
+ Spring Data MVC
+ PostgreSQL

**Práticas adotadas**
+ API REST
+ Consultas com Spring Data JPA
+ Injeção de Dependências

**API endpoints**

Para fazer as requisições foi utilizado o Postman

endpoints para a entidade GameController:
+ Retornar uma lista de Games método GET url: http://localhost:8080/games
+ Retornar uma lista de Games método GET por ID url:  http://localhost:8080/games/{id}

endpoints para a entidade GameListController
+ Retornar uma lista do tipo de Games método GET url:  http://localhost:8080/lists
+ Retornar um gênero especifico de games através da lista método Get url:  http://localhost:8080/{listid}/games
