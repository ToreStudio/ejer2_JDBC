-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2016 a las 12:22:51
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.5.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `curso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumne`
--

CREATE TABLE `alumne` (
  `codi` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `alumne`
--

INSERT INTO `alumne` (`codi`, `nom`) VALUES
(1, 'Rafel Mateu'),
(2, 'Jose Martinez'),
(3, 'Angel Martorell'),
(4, 'Dolores Pons'),
(5, 'Antonia Sanç'),
(6, 'Alberto Perez'),
(7, 'Jaume Frau'),
(8, 'Pere Pons');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `assignatura`
--

CREATE TABLE `assignatura` (
  `codi` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `assignatura`
--

INSERT INTO `assignatura` (`codi`, `nom`) VALUES
(1, 'Programació'),
(2, 'Xarxes'),
(3, 'Bases de Dades'),
(4, 'Sistemes Operatius');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutoria`
--

CREATE TABLE `tutoria` (
  `codi` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `maxParticipants` int(11) NOT NULL,
  `codiAssignatura` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tutoria`
--

INSERT INTO `tutoria` (`codi`, `nom`, `maxParticipants`, `codiAssignatura`) VALUES
(1, 'Tutoria 1 Programació', 10, 1),
(2, 'Tutoria 2 Programació', 5, 1),
(3, 'Tutoria 1 Xarxes', 7, 2),
(4, 'Tutoria 1 Bases de Dades', 15, 3),
(5, 'Tutoria 2 Bases de Dades', 12, 3),
(6, 'Tutoria 1 Sistemes Operatius', 20, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutoriaalumne`
--

CREATE TABLE `tutoriaalumne` (
  `codiTutoria` int(11) NOT NULL,
  `codiAlumne` int(11) NOT NULL,
  `actiu` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tutoriaalumne`
--

INSERT INTO `tutoriaalumne` (`codiTutoria`, `codiAlumne`, `actiu`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 0),
(1, 4, 1),
(2, 2, 1),
(2, 5, 1),
(2, 6, 1),
(2, 7, 0),
(2, 8, 1),
(3, 1, 1),
(3, 7, 1),
(4, 3, 1),
(4, 6, 0),
(4, 8, 1),
(5, 4, 1),
(6, 4, 1),
(6, 5, 0),
(6, 6, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumne`
--
ALTER TABLE `alumne`
  ADD PRIMARY KEY (`codi`);

--
-- Indices de la tabla `assignatura`
--
ALTER TABLE `assignatura`
  ADD PRIMARY KEY (`codi`);

--
-- Indices de la tabla `tutoria`
--
ALTER TABLE `tutoria`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `codiAssignatura` (`codiAssignatura`);

--
-- Indices de la tabla `tutoriaalumne`
--
ALTER TABLE `tutoriaalumne`
  ADD PRIMARY KEY (`codiTutoria`,`codiAlumne`),
  ADD KEY `codiAlumne` (`codiAlumne`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tutoria`
--
ALTER TABLE `tutoria`
  ADD CONSTRAINT `tutoria_ibfk_1` FOREIGN KEY (`codiAssignatura`) REFERENCES `assignatura` (`codi`);

--
-- Filtros para la tabla `tutoriaalumne`
--
ALTER TABLE `tutoriaalumne`
  ADD CONSTRAINT `tutoriaalumne_ibfk_1` FOREIGN KEY (`codiTutoria`) REFERENCES `tutoria` (`codi`),
  ADD CONSTRAINT `tutoriaalumne_ibfk_2` FOREIGN KEY (`codiAlumne`) REFERENCES `alumne` (`codi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
