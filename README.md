# Legião Pluviarcana: Back-End

Repositório para a terceira Sprint Session do terceiro semestre do curso de Ciência da Computação do Insper, com a temática de Inovação Social. Para acessar e testar os Endpoints, acesse a documentação Swagger clicando [aqui](http://3.23.96.142:8080/).

### Autores

- Felipe Maluli de Carvalho Dias
- João Alfredo Cardoso Lamy
- Marcelo Marchetto
- Marcelo Rabello
- Thomas Chiari Ciocchetti de Souza

### Sobre

Esse projeto foi feito em parceria com a UNAS e o Observatório da Quebrada de Heliópolis com o objetivo de criar uma plataforma para automatizar o processo de coleta de dados e relatos de enchentes em Heliópolis. Nesse repositório se encontra o "cérebro" da aplicação, que está rodando em uma máquina EC2 da AWS. Aqui, os relatos e dados são processados e enviados para uma base de dados PostgreSQL, com as mídias salvas em um Bucket S3 da AWS.

Para automatizar a coleta de dados e relatos, foi utilizado um Bot de WhatsApp, que está rodando em um servidor Flask utilizando a API do Twilio. Para acessar o repositório do Bot, clique [aqui](https://github.com/Maraba23/whatsappbot-public-version). O projeto conta com uma página de administradores na qual os voluntários poderão acessar e gerenciar os relatos e mídias recebidas. O repositório pode ser acessado clicando [aqui](https://github.com/marchettomarcelo/sprint-2023.1). Também há um dashboard para a análise quantitativa dos dados recebidos, que atualmente roda localmente. O repositório, com todas as instruções para rodar a aplicação, pode ser acessado clicando [aqui](https://github.com/alfredjynx/DashBoard-Heliopolis). 

### Como instalar e rodar o projeto localmente?

Primeiramente, é necessário ter um servidor PostgreSQL rodando, seja localmente ou em uma máquina virtual. Para instalar o PostgreSQL, siga as instruções do site oficial clicando [aqui](https://www.postgresql.org/download/). Para criar um servidor PostgreSQL em uma máquina virtual, siga as instruções do site oficial clicando [aqui](https://aws.amazon.com/pt/getting-started/hands-on/create-connect-postgresql-db/).

Em seguida, é necessário instalar a versão 17 do Java JDK. Para instalar o Java JDK, siga as instruções do site oficial clicando [aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html). Também é necessário instalar o Maven. Para instalar o Maven, siga as instruções do site oficial clicando [aqui](https://maven.apache.org/install.html).

Com tudo instalado, clone o repositório utilizando o comando `git clone https://github.com/thomaschiari/Legiao-Pluviarcana-Back-End.git`. Em seguida, mude para a branch de deploy utilizando o comando `git checkout deploy`. Agora, edite o arquivo chamado `application.properties` na pasta `src/main/resources` e adicione o endereço de seu servidor PostgreSQL e suas credenciais de acesso. O arquivo deve ficar parecido com isso:

```
spring.datasource.url=jdbc:postgresql://3.23.96.142:5432/legiao_pluviarcana
spring.datasource.username=mirwox
spring.datasource.password=ZMLvKMY!uph9vYb
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.entity-packages-to-scan = com.example.entity
spring.jpa.show-sql = true
```

Com tudo pronto, rode o comando `mvn clean install` na pasta root do projeto. Em seguida, rode o comando `mvn spring-boot:run` para rodar o projeto. O projeto estará rodando em `localhost:8080`. Aproveite a API! ao acessar a página principal, será redirecionado diretamente para a página principal da documentação Swagger, onde poderá testar todos os endpoints da API.

