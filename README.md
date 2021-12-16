# api_country_rest

Instruções:
branches: main, heroku e localhost-mysql


heroku
- Apenas aceder ao link da api que será partilhado por email.
- A api já encontra-se funcional;

localhost-mysql
- Fazer o clone do projecto:
- Executar o pull;
- Fazer o checkout usando o comando git checkout origin/localhost-mysql
- Actualizar as dependencias com o Maven:
- Criar a base de dados ou exportar a base de dados que encontra-se neste repositório com o nome “country_rest_api”;
- No arquivo api_country_rest/src/main/resources/application.properties, trocar as credenciais e o link da base de dados se for o caso. Nota, trocar para as credencias e o link da base de dados que deseja usar.
- Executar o Run as Spring Boot App no arquivo api_country_rest/src/main/java/com/osorio/country/CountryApplication.java, caso esteje usando o Spring Tool Suite;

- Pode ser encontrado aqui no repositório o arquivo ou a coleção de end-points para testar a api. Esta coleção foi exportada do postman.

