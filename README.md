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
### Exemplo de usuario
- Crie um usuário com acesso ao banco
```shell
CREATE USER 'bolotematico-root'@'localhost' IDENTIFIED BY 'senha-root';
```
>obs.: o usuário e senha deve ser a mesma do arquivo application.propeties

- conceda todos os privilégios ao banco bolotematico
```shell
GRANT ALL PRIVILEGES ON bolotematico.* TO 'bolotematico-root'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

## Acessar a página
http://localhost:8080/


