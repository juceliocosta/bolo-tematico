## Configuração do banco local Mariadb
- Faça login no seu servidor de base de dados MariaDB com o usuário root

```shell
sudo mysql -u root -p
```
- Crie a senha para acesso ao MariaDB.

- Crie a base de dados:

```shell
create database bolotematico;
```

- Crie um usuário com acesso ao banco
```shell
CREATE USER 'root-bolotematico'@'localhost' IDENTIFIED BY 'Senha-desse-usuario';
```

- conceda todos os privilégios ao banco bolotematico
```shell
GRANT ALL PRIVILEGES ON bolotematico.* TO 'root-bolotematico'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```
- Salve a senha desse usuário no atributo *spring.datasource.password* do arquivo **application.properties**

## Acessar a página
http://localhost:8080/


