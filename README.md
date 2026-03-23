# 🎟️ Sistema de Venda de Ingressos

## 📌 Sobre o Projeto

Este projeto consiste em um sistema de venda de ingressos desenvolvido em Java com interface gráfica utilizando Swing.
O sistema permite a compra de ingressos, geração de relatórios e persistência dos dados em arquivos.

O projeto foi evoluído com foco em boas práticas de Programação Orientada a Objetos, incluindo:

* Organização em pacotes
* Uso de Enum
* Serialização de dados
* Tratamento de exceções
* Multithreading

---

## ⚙️ Tecnologias Utilizadas

* Java (JDK 8+)
* Swing (Interface gráfica)
* Git e GitHub

---

## 📁 Estrutura de Pacotes

```
venda_ingresso
├── main        → Classe principal (execução do sistema)
├── entities    → Classes de domínio (Ingresso)
├── enums       → Enumerações (SetorEnum)
├── exceptions  → Exceções customizadas
├── services    → Regras de negócio e persistência
├── ui          → Interface gráfica
```

---

## ▶️ Como Executar

1. Clone o repositório:

```
git clone https://github.com/Juliehmleal/ARQDEOO_IFSP.git
```

2. Abra o projeto em uma IDE (NetBeans, IntelliJ ou Eclipse)

3. Execute a classe:

```
Principal.java
```

---

## 🧠 Conceitos Aplicados

### 🔹 Serialização

O sistema utiliza serialização para salvar os ingressos em arquivo `.ser`.

Exemplo:

```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
oos.writeObject(ingressos);
```

Isso permite que os dados persistam mesmo após o encerramento do programa.

---

### 🔹 Multithreading

O sistema simula múltiplos usuários comprando ingressos simultaneamente.

* Cada comprador roda em uma thread
* Uso de `Runnable`
* Uso de `synchronized` para evitar inconsistências

Exemplo:

```java
Thread t = new Thread(new CompradorRunnable(...));
t.start();
```

---

### 🔹 synchronized

Garante que apenas uma thread por vez execute a compra:

```java
public synchronized boolean comprarIngresso(Ingresso ingresso)
```

Evita problemas como:

* códigos duplicados
* vendas acima do limite

---

### 🔹 Thread Daemon

Uma thread roda em background salvando os ingressos automaticamente a cada 500ms.

---

## 👩‍💻 Autor

Julie Hervias Mendes Leal - 
IFSP - TSI - ARQDEOO
