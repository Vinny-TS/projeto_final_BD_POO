CREATE DATABASE IF NOT EXISTS locadora_veiculos;

USE locadora_veiculos;

CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);

CREATE TABLE Veiculos (
    id_veiculo INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano INT NOT NULL,
    placa VARCHAR(7) NOT NULL UNIQUE,
    disponivel BOOLEAN DEFAULT TRUE
);

CREATE TABLE Alugueis (
    id_aluguel INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_veiculo INT,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
    FOREIGN KEY (id_veiculo) REFERENCES Veiculos(id_veiculo)
);

CREATE TABLE Manutencao (
    id_manutencao INT AUTO_INCREMENT PRIMARY KEY,
    id_veiculo INT,
    data_manutencao DATE,
    descricao VARCHAR(255),
    FOREIGN KEY (id_veiculo) REFERENCES veiculos(id_veiculo)
);

select * from clientes;

select * from veiculos;

select * from alugueis;

select * from manutencao;



