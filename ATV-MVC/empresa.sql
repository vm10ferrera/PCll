-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Ago-2018 às 03:08
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empresa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id_forn` int(3) NOT NULL,
  `nome_forn` varchar(150) NOT NULL,
  `nome_produto` varchar(150) NOT NULL,
  `endereco_forn` varchar(100) NOT NULL,
  `email_forn` varchar(150) NOT NULL,
  `telefone_forn` int(9) NOT NULL,
  `id_patrao` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_forn`, `nome_forn`, `nome_produto`, `endereco_forn`, `email_forn`, `telefone_forn`, `id_patrao`) VALUES
(1, 'wanderlei Augusto da Silva', 'bala de chiclete', 'Rua Casa, 58', 'func1@3.com', 123456789, 0),
(2, 'eric', 'andes', 'atr', 'oiu', 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id_func` int(3) NOT NULL,
  `nome_func` varchar(150) NOT NULL,
  `endereco_func` varchar(150) NOT NULL,
  `bairro_func` varchar(100) NOT NULL,
  `cep_func` int(8) NOT NULL,
  `cpf_func` int(11) NOT NULL,
  `email_func` varchar(100) NOT NULL,
  `telefone_func` int(9) NOT NULL,
  `rg_func` int(9) NOT NULL,
  `id_patrao` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id_func`, `nome_func`, `endereco_func`, `bairro_func`, `cep_func`, `cpf_func`, `email_func`, `telefone_func`, `rg_func`, `id_patrao`) VALUES
(1, 'wanderlei Augusto da Silva', 'Rua Casa, 58', 'Jardim Cerejeira', 87654320, 1234567890, 'func1@3.com', 123456789, 123456789, 0),
(2, 'aLDAIR', 'RAE', 'SER', 1081, 4321, 'DRT', 123, 1234, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `patrao`
--

CREATE TABLE `patrao` (
  `id_patrao` int(3) NOT NULL,
  `nome_patrao` varchar(150) NOT NULL,
  `nome_empresa` varchar(150) NOT NULL,
  `endereco_patrao` varchar(100) NOT NULL,
  `email_patrao` varchar(150) NOT NULL,
  `telefone_patrao` int(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `patrao`
--

INSERT INTO `patrao` (`id_patrao`, `nome_patrao`, `nome_empresa`, `endereco_patrao`, `email_patrao`, `telefone_patrao`) VALUES
(1, 'wanderlei Augusto da Silva', 'Ibiturinho', 'Rua Casa, 58', 'func1@3.com', 123456789);

-- --------------------------------------------------------

--
-- Estrutura da tabela `socio`
--

CREATE TABLE `socio` (
  `id_socio` int(3) NOT NULL,
  `nome_socio` varchar(150) NOT NULL,
  `endereco_socio` varchar(150) NOT NULL,
  `email_socio` varchar(100) NOT NULL,
  `telefone_socio` int(9) NOT NULL,
  `valor_contri` int(225) NOT NULL,
  `id_patrao` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `socio`
--

INSERT INTO `socio` (`id_socio`, `nome_socio`, `endereco_socio`, `email_socio`, `telefone_socio`, `valor_contri`, `id_patrao`) VALUES
(1, 'wanderlei Augusto da Silva', 'Rua Casa, 58', 'func1@3.com', 123456789, 3000, 0),
(2, 'ALDAIR', 'E', 'E', 123, 333, 2);



--
-- Indexes for dumped tables
--

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_forn`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_func`);

--
-- Indexes for table `patrao`
--
ALTER TABLE `patrao`
  ADD PRIMARY KEY (`id_patrao`);

--
-- Indexes for table `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`id_socio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_forn` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id_func` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `patrao`
--
ALTER TABLE `patrao`
  MODIFY `id_patrao` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `socio`
--
ALTER TABLE `socio`
  MODIFY `id_socio` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
