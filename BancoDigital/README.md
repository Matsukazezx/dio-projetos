# 🏦 Banco Digital - Projeto Java com Orientação a Objetos

Este projeto é um desafio prático da plataforma [DIO - Digital Innovation One](https://www.dio.me/) com foco em aplicar os conceitos fundamentais de **Programação Orientada a Objetos (POO)** em Java. A proposta consiste em modelar um sistema bancário simples, simulando operações básicas como depósito, saque, transferência e listagem de contas por cliente.

---

## 🎯 Objetivos do Projeto

* Praticar **abstração**, **encapsulamento**, **herança** e **polimorfismo**.
* Simular o funcionamento de um banco com contas correntes e poupança.
* Implementar classes e interfaces orientadas a objetos.

---

## ⚖️ Funcionalidades

* Criar contas do tipo **Conta Corrente** e **Conta Poupança**.
* Realizar **depósitos**, **saques** e **transferências** entre contas.
* **Imprimir extratos bancários**.
* **Listar contas por cliente**.

---

## 📂 Estrutura do Projeto

```
BancoDigital
├── src/
│   ├── Banco.java
│   ├── Cliente.java
│   ├── Conta.java
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   ├── IConta.java
│   └── Main.java
```

---

## 📊 Classes e Interfaces

### `Banco`

* Representa o banco e armazena uma lista de contas.
* Permite listar contas por cliente.

### `Cliente`

* Representa o cliente com nome.

### `Conta (abstrata)`

* Possui atributos comuns (agência, número, saldo, cliente).
* Métodos: `sacar`, `depositar`, `transferir`, `imprimirInfosComuns`.

### `ContaCorrente` e `ContaPoupanca`

* Estendem a classe `Conta` e implementam o método `imprimirExtrato`.

### `IConta`

* Interface com os métodos comuns das contas.

---

## ⚡ Exemplo de Uso

```java
Cliente cliente = new Cliente();
cliente.setNome("João");

Conta cc = new ContaCorrente(cliente);
Conta poupanca = new ContaPoupanca(cliente);

cc.depositar(500);
cc.transferir(200, poupanca);

cc.imprimirExtrato();
poupanca.imprimirExtrato();

Banco banco = new Banco();
banco.setContas(List.of(cc, poupanca));
banco.listarContasPorCliente("João");
```


