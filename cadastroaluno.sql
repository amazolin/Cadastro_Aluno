
CREATE DATABASE IF NOT EXISTS cadastroaluno;
USE cadastroaluno;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Estrutura da tabela `tbaluno`
CREATE TABLE `tbaluno` (
  `RGM` varchar(50) NOT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Endereco` varchar(50) DEFAULT NULL,
  `UF` varchar(15) DEFAULT NULL,
  `Telefone` varchar(50) DEFAULT NULL,
  `Municipio` varchar(50) DEFAULT NULL,
  `DataNasc` varchar(50) DEFAULT NULL,
  `CPF` varchar(15) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Campus` varchar(50) DEFAULT NULL,
  `Turno` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RGM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Estrutura da tabela `tbcurso`
CREATE TABLE `tbcurso` (
  `aluno_rgm` varchar(50) DEFAULT NULL,
  `nome_curso` varchar(50) DEFAULT NULL,
  `semestre` varchar(50) DEFAULT NULL,
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCurso`),
  KEY `fk_aluno_rgm` (`aluno_rgm`),
  CONSTRAINT `fk_aluno_rgm` FOREIGN KEY (`aluno_rgm`) REFERENCES `tbaluno` (`RGM`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dados iniciais para `tbcurso`
INSERT INTO `tbcurso` (`aluno_rgm`, `nome_curso`, `semestre`, `idCurso`) VALUES
(NULL, 'Analise e Desenvolvimento de Sistemas', NULL, 1),
(NULL, 'Engenharia de Software', NULL, 2),
(NULL, 'Logistica', NULL, 3),
(NULL, 'Logistica Aeroportuaria', NULL, 4),
(NULL, 'Mecatronica', NULL, 5);

-- Estrutura da tabela `tbdisciplinas`
CREATE TABLE `tbdisciplinas` (
  `idDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `idCurso` int(11) DEFAULT NULL,
  `nome_disciplina` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDisciplina`),
  KEY `fk_idCurso` (`idCurso`),
  CONSTRAINT `fk_idCurso` FOREIGN KEY (`idCurso`) REFERENCES `tbcurso` (`idCurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dados iniciais para `tbdisciplinas`
INSERT INTO `tbdisciplinas` (`idDisciplina`, `idCurso`, `nome_disciplina`) VALUES
(1, 1, 'Algoritmos'),
(2, 1, 'Banco de Dados'),
(3, 1, 'Estrutura de Dados'),
(4, 1, 'Linguagem de Programacao'),
(5, 1, 'Programacao Orientada a Objetos'),
(6, 1, 'Sistemas Operacionais'),
(7, 2, 'Algoritmos'),
(8, 2, 'Banco de Dados'),
(9, 2, 'Calculo'),
(10, 2, 'Engenharia de Software'),
(11, 2, 'Estrutura de Dados'),
(12, 2, 'Programacao Orientada a Objetos'),
(13, 2, 'Sistemas Operacionais'),
(14, 3, 'Gestao de Equipes'),
(15, 3, 'Ingles  III'),
(16, 3, 'Ingles  IV'),
(17, 3, 'Logistica'),
(19, 3, 'Metodologia Cientifica'),
(20, 4, 'Gestao de Equipes'),
(21, 4, 'Ingles III'),
(22, 4, 'Ingles IV'),
(23, 4, 'Logistica Aeroportuaria'),
(24, 4, 'Metodologia Cientifica'),
(25, 5, 'Algoritmos'),
(26, 5, 'Estrutura de Dados'),
(81, 5, 'Mecanica'),
(82, 5, 'Programacao Orientada a Objetos'),
(83, 5, 'Sistemas Operacionais');

-- Estrutura da tabela `tbnotas_faltas`
CREATE TABLE `tbnotas_faltas` (
  `idNotaFalta` int(11) NOT NULL AUTO_INCREMENT,
  `idDisciplina` int(11) DEFAULT NULL,
  `aluno_rgm` varchar(20) DEFAULT NULL,
  `nota` double(5,2) DEFAULT NULL,
  `falta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idNotaFalta`),
  KEY `idDisciplina` (`idDisciplina`),
  KEY `aluno_rgm` (`aluno_rgm`),
  CONSTRAINT `tbnotas_faltas_ibfk_1` FOREIGN KEY (`idDisciplina`) REFERENCES `tbdisciplinas` (`idDisciplina`) ON DELETE CASCADE,
  CONSTRAINT `tbnotas_faltas_ibfk_2` FOREIGN KEY (`aluno_rgm`) REFERENCES `tbaluno` (`RGM`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
