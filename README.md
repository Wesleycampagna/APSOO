 Trabalho de APSOO
================================================================
[![NPM package][npm]][npm-url]
[![Build Size][build-size]][build-size-url]
[![Build Status][build-status]][build-status-url]
[![Dependencies][dependencies]][dependencies-url]
[![Dev Dependencies][dev-dependencies]][dev-dependencies-url]
[![Language Grade][lgtm]][lgtm-url]

#### Organização ####

A pasta Assets possui a configuração do banco, por meio dos arquivos de **`model`** (wbm), de **`imagem`** (png) e do **`template do banco`** (txt). Existe ainda neste pacote os scripts de contrução de banco de dados, população e querys usadas (nem todas foram usadas).

&mdash; [Assets](https://github.com/Wesleycampagna/apsoo_trabalho/tree/master/Assets)

A pasta src é o local ao qual é construido o **`codigo base`** do projeto. É o diretório que se encontra os arquivos que trabalham para fazer o sistema poposto por este trabalho funcionar. Seus três principais focos são banco de dados, design de interface e conexão dos anteriores.

&mdash; [src](https://github.com/Wesleycampagna/apsoo_trabalho/tree/master/src)

Para testes de **`query`** foi criado um diretório de base localidazdo em **`src/DataBase/testesQuerys`** para realiza-los.

&mdash; [testesQuery](https://github.com/Wesleycampagna/apsoo_trabalho/tree/master/src/DataBase/testesQuerys)


## Organização Interna do projeto

**describe**

> src > lib

&mdash; [library própria](https://github.com/Wesleycampagna/apsoo_trabalho/tree/master/src/lib)


**describe*

> src > Controls

&mdash; [Controladoras](https://github.com/Wesleycampagna/apsoo_trabalho/tree/master/src/Controls)


**.. terminar**


# instalação

## descrever ainda...

## Usar banco de dados

Foi escolhido usar banco de dados via Connector [JDBC](https://dev.mysql.com/downloads/connector/j/8.0.html) para obter os dados do banco de dados. 
Para configura-lo será necessário:

```java
    private Connection connect;
    private Statement statement;
    private final String dataBaseName;
    private final String password = "<sua senha bd>";
    private final String user = "<seu login bd>";
```
que atende a chamada de conexão:

```java
    try {
      // to problems with timezone, see bottom code
      connect = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/" + dataBaseName, 
        user, 
        password
      );
```
Pode ocorrer problemas com timezone, atribua o trecho acima como:

```java
    try {
      connect = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/" + 
        dataBaseName + "?useTimezone=true&serverTimezone=UTC",
        user, 
        password
      );
```

teste a conexão com [isto](https://github.com/Wesleycampagna/apsoo_trabalho/blob/master/src/DataBase/testesQuerys/connection_teste.java).


realizar a chamada do banco:

```java
      ControladoraBD instance = new ControladoraBD("<nome banco>");
      //or
      new ControladoraBD("<nome banco>");
```


`AS DEFAULT` nome do banco é **`policia_db`**



[npm]: https://img.shields.io/npm/v/three.svg
[npm-url]: https://www.npmjs.com/package/three
[build-size]: https://badge-size.herokuapp.com/mrdoob/three.js/master/build/three.min.js.svg?compression=gzip
[build-size-url]: https://github.com/mrdoob/three.js/tree/master/build
[build-status]: https://travis-ci.org/mrdoob/three.js.svg?branch=dev
[build-status-url]: https://travis-ci.org/mrdoob/three.js
[dependencies]: https://img.shields.io/david/mrdoob/three.js.svg
[dependencies-url]: https://david-dm.org/mrdoob/three.js
[dev-dependencies]: https://img.shields.io/david/dev/mrdoob/three.js.svg
[dev-dependencies-url]: https://david-dm.org/mrdoob/three.js#info=devDependencies
[lgtm]: https://img.shields.io/lgtm/grade/javascript/g/mrdoob/three.js.svg?label=code%20quality
[lgtm-url]: https://lgtm.com/projects/g/mrdoob/three.js/
