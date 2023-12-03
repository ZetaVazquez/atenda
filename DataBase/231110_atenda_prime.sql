-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2023 a las 20:30:39
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `atenda_prime`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'ferramentas'),
(2, 'roupa'),
(3, 'electrodomésticos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_pedido`
--

CREATE TABLE `linea_pedido` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `desconto` int(11) NOT NULL DEFAULT 0,
  `unidades` int(11) NOT NULL,
  `prezo` decimal(10,2) NOT NULL DEFAULT 0.00,
  `coste` decimal(10,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `linea_pedido`
--

INSERT INTO `linea_pedido` (`id`, `id_pedido`, `id_produto`, `desconto`, `unidades`, `prezo`, `coste`) VALUES
(527, 504, 1, 0, 20, 23.00, 5.00),
(528, 505, 1, 0, 5, 23.00, 5.00),
(529, 505, 2, 0, 5, 22.22, 15.40),
(530, 506, 1, 0, -3, 23.00, 5.00),
(531, 507, 1, 0, 6, 23.00, 5.00),
(532, 508, 1, 0, -3, 23.00, 5.00),
(533, 509, 1, 0, 1, 23.00, 5.00),
(534, 509, 2, 0, 2, 22.22, 15.40),
(535, 509, 3, 0, 1, 33.33, 20.00),
(536, 510, 1, 0, -1, 23.00, 5.00),
(537, 510, 2, 0, -1, 22.22, 15.40),
(538, 511, 2, 0, -1, 22.22, 15.40),
(539, 511, 3, 0, -1, 33.33, 20.00),
(541, 513, 1, 0, 3, 23.00, 5.00),
(542, 513, 2, 0, 1, 22.22, 15.40),
(543, 514, 1, 0, -1, 23.00, 5.00),
(544, 515, 1, 0, 1, 23.00, 5.00),
(545, 516, 1, 0, 1, 23.00, 5.00),
(546, 517, 1, 0, 1, 23.00, 5.00),
(547, 518, 2, 0, 1, 22.22, 15.40),
(548, 519, 1, 0, 1, 23.00, 5.00),
(549, 520, 1, 0, 1, 23.00, 5.00),
(554, 522, 1, 0, 1, 23.00, 5.00),
(555, 523, 2, 0, 3, 22.22, 15.40),
(556, 524, 32, 0, 1, 2.00, 1.00),
(557, 525, 3, 0, 1, 33.33, 20.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `nome`) VALUES
(1, 'Balay'),
(2, 'bellota'),
(3, 'Springfield');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opinion`
--

CREATE TABLE `opinion` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `valoracion` enum('1','2','3','4','5') NOT NULL,
  `texto` varchar(400) NOT NULL,
  `data_hora` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `opinion`
--

INSERT INTO `opinion` (`id`, `idUsuario`, `idProduto`, `valoracion`, `texto`, `data_hora`) VALUES
(1, 2, 2, '1', 'Muy malo', '2021-12-30 20:22:40'),
(4, 7, 2, '3', 'non me gustou moito', '2021-12-30 20:22:40'),
(5, 7, 2, '1', 'vou devolver todas as unidades', '2021-12-30 20:22:40'),
(13, 7, 2, '1', 'outro 1', '2022-01-01 23:48:26'),
(14, 7, 2, '1', 'outro 1.....', '2022-01-01 23:48:36'),
(16, 7, 2, '5', 'excellent washing machine', '2022-01-04 20:04:34'),
(17, 7, 2, '5', 'best buy', '2022-01-04 20:04:50'),
(23, 7, 1, '5', 'o melhor martelo do mundo', '2022-01-09 20:24:38'),
(24, 7, 1, '5', 'ok', '2022-01-09 20:24:54'),
(25, 7, 1, '5', 'ok', '2022-01-09 20:24:57'),
(26, 7, 1, '5', 'ok', '2022-01-09 20:24:58'),
(27, 7, 1, '5', 'ok', '2022-01-09 20:24:58'),
(28, 7, 1, '5', 'ok', '2022-01-09 20:24:58'),
(29, 7, 1, '5', 'ok', '2022-01-09 20:24:58'),
(30, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(31, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(32, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(33, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(34, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(35, 7, 1, '5', 'ok', '2022-01-09 20:24:59'),
(36, 7, 1, '5', 'ok', '2022-01-09 20:25:00'),
(37, 7, 1, '5', 'ok', '2022-01-09 20:25:00'),
(38, 7, 1, '5', 'ok', '2022-01-09 20:25:00'),
(39, 7, 1, '5', 'ok', '2022-01-09 20:25:00'),
(40, 7, 1, '1', 'mal', '2022-01-09 20:25:48'),
(41, 7, 1, '1', 'mal', '2022-01-09 20:25:49'),
(42, 7, 1, '1', 'mal', '2022-01-09 20:25:50'),
(43, 7, 1, '1', 'mal', '2022-01-09 20:25:51'),
(44, 7, 1, '1', 'mal', '2022-01-09 20:25:51'),
(45, 7, 1, '1', 'mal', '2022-01-09 20:25:52'),
(46, 7, 1, '1', 'mal', '2022-01-09 20:25:53'),
(47, 7, 1, '1', 'mal', '2022-01-09 20:25:53'),
(48, 7, 1, '1', 'mal', '2022-01-09 20:25:53'),
(49, 7, 1, '1', 'mal', '2022-01-09 20:25:54'),
(50, 7, 1, '1', 'mal', '2022-01-09 20:25:54'),
(51, 7, 1, '1', 'mal', '2022-01-09 20:25:54'),
(52, 7, 1, '1', 'mal', '2022-01-09 20:25:54'),
(53, 7, 1, '1', 'mal', '2022-01-09 20:25:54'),
(54, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(55, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(56, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(57, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(58, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(59, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(60, 7, 1, '1', 'mal', '2022-01-09 20:25:55'),
(61, 7, 1, '1', 'mal', '2022-01-09 20:25:56'),
(62, 7, 1, '1', 'mal', '2022-01-09 20:25:56'),
(63, 7, 1, '1', 'mal', '2022-01-09 20:25:56'),
(64, 7, 1, '1', 'mal', '2022-01-09 20:25:56'),
(65, 7, 1, '1', 'mal', '2022-01-09 20:25:56'),
(66, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(67, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(68, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(69, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(70, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(71, 7, 1, '1', 'mal', '2022-01-09 20:25:57'),
(72, 7, 1, '1', 'mal', '2022-01-09 20:25:58'),
(73, 7, 1, '1', 'mal', '2022-01-09 20:25:58'),
(74, 7, 1, '1', 'mal', '2022-01-09 20:25:58'),
(75, 7, 1, '1', 'mal', '2022-01-09 20:25:58'),
(76, 7, 1, '3', 'mal', '2022-01-09 20:26:19'),
(77, 7, 1, '3', 'mal', '2022-01-09 20:27:04'),
(78, 7, 1, '3', 'mal', '2022-01-09 20:27:43'),
(79, 7, 1, '2', '', '2022-01-09 20:28:25'),
(80, 7, 1, '3', 'moi mala', '2022-01-09 20:28:31'),
(81, 7, 1, '3', 'moi mala', '2022-01-09 20:28:37'),
(94, 7, 2, '2', 'ok', '2022-01-09 21:01:39'),
(95, 7, 2, '5', 'ok', '2022-01-09 21:01:48'),
(96, 7, 2, '5', 'ok', '2022-01-09 21:01:56'),
(97, 7, 1, '2', 'mal martelo', '2022-01-09 21:15:41'),
(98, 7, 1, '1', 'moi malo', '2022-01-09 21:32:23'),
(106, 7, 1, '5', 'excelente calidade/prezo', '2022-01-10 22:44:54'),
(107, 7, 2, '5', 'fantástica', '2022-01-11 12:58:49'),
(108, 7, 2, '1', 'excelente', '2022-01-11 12:58:58'),
(109, 7, 1, '3', 'regular', '2022-01-16 19:27:28'),
(110, 7, 1, '3', '', '2022-01-19 18:36:09'),
(111, 7, 1, '3', '', '2022-01-26 23:32:40'),
(112, 7, 2, '4', 'ok', '2022-02-14 15:05:49'),
(113, 7, 1, '5', '', '2022-05-31 12:27:51'),
(114, 32, 1, '3', 'ok', '2023-04-23 18:23:58'),
(115, 33, 2, '3', 'esto rompeu o primeiro día', '2023-05-02 17:02:40'),
(116, 7, 1, '4', 'moi bon. ingenieria alemana', '2023-05-31 16:58:45'),
(117, 35, 1, '3', 'moi bo martelo', '2023-06-14 18:43:23'),
(118, 38, 1, '1', 'no martillea, estafa', '2023-09-12 14:38:01'),
(119, 38, 2, '1', 'en vez de aspirar, espira, me dejó la habitación fatal, se debería llamar espiradora', '2023-09-12 14:39:47'),
(120, 38, 32, '4', 'buen tornillo, agarra bien las cosas,  pero por 2 EURAZOS me podría hacer la cama también', '2023-09-12 14:41:32'),
(121, 40, 3, '5', 'Un imán de mujeres ?  ?  ? ', '2023-09-13 13:50:13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `id_pedido_devol` int(11) DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `pechado` tinyint(1) NOT NULL DEFAULT 0,
  `recibido` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `id_pedido_devol`, `id_cliente`, `data_hora`, `pechado`, `recibido`) VALUES
(504, NULL, 32, '2023-04-23 18:21:06', 1, 1),
(505, NULL, 32, '2023-04-23 18:28:44', 1, 1),
(506, 505, 32, '2023-04-23 18:29:08', 1, 1),
(507, NULL, 7, '2023-04-23 18:43:29', 1, 1),
(508, 507, 7, '2023-04-27 17:44:08', 1, 1),
(509, NULL, 33, '2023-05-02 17:01:45', 1, 1),
(510, 509, 33, '2023-05-02 17:03:13', 1, 1),
(511, 509, 33, '2023-05-02 17:03:46', 1, 1),
(513, NULL, 7, '2023-05-11 15:41:13', 1, 1),
(514, 513, 7, '2023-05-11 15:43:16', 1, 1),
(515, NULL, 7, '2023-05-31 16:58:13', 1, 1),
(516, NULL, 7, '2023-06-14 18:39:08', 0, 0),
(517, NULL, 35, '2023-06-14 18:41:28', 1, 1),
(518, NULL, 35, '2023-06-14 18:42:25', 1, 1),
(519, NULL, 36, '2023-06-15 07:39:46', 1, 1),
(520, NULL, 36, '2023-06-16 17:32:45', 1, 1),
(522, NULL, 38, '2023-09-12 14:37:15', 1, 1),
(523, NULL, 38, '2023-09-12 14:39:05', 1, 1),
(524, NULL, 38, '2023-09-12 14:40:23', 1, 1),
(525, NULL, 40, '2023-09-13 13:49:14', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_marca` int(11) DEFAULT NULL,
  `nome` varchar(250) NOT NULL,
  `prezo` decimal(10,2) NOT NULL DEFAULT 0.00,
  `desconto` int(11) NOT NULL DEFAULT 0,
  `coste` decimal(10,2) NOT NULL DEFAULT 0.00,
  `iva` int(11) NOT NULL DEFAULT 21,
  `stock` int(11) NOT NULL DEFAULT 0,
  `foto` varchar(400) NOT NULL DEFAULT 'default.PNG',
  `baixa` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `produto`
--

INSERT INTO `produto` (`id`, `id_categoria`, `id_marca`, `nome`, `prezo`, `desconto`, `coste`, `iva`, `stock`, `foto`, `baixa`) VALUES
(1, 1, 2, 'martelo', 23.00, 10, 5.00, 2, 22, 'hammer.PNG__16c83ed4-00a8-4b9e-834f-4e5b05fc08b0.PNG', 0),
(2, 3, 1, 'aspiradora', 22.22, 0, 15.40, 3, 9, 'aspiradora.PNG__f4927f15-ae5b-465e-ae72-c673706dcbd9.PNG', 0),
(3, 2, 3, 'camisa', 33.33, 15, 20.00, 3, 89, 'camisa.PNG__770f41de-17dd-4242-a00f-d7785f366b94.PNG', 0),
(32, 1, 2, 'tornillo', 2.00, 2, 1.00, 1, 29, 'tornillo.PNG__1797d8cd-a857-4c22-8ea1-e5c99e9334d2.PNG', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `rol` enum('ADMIN','BASIC') NOT NULL DEFAULT 'BASIC',
  `avatar` varchar(200) NOT NULL,
  `baixa` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `username`, `password`, `nome`, `rol`, `avatar`, `baixa`) VALUES
(1, 'admin', '$2a$12$HsxlWMt4AVsOg/DffYZvYu6BQy77bcz3mwmAU61wRSx5IkXQhGEj6', 'Admin Perez', 'ADMIN', 'admin.PNG__7d66e2c2-31ca-415c-a50b-6e9ccf45250d.PNG', 0),
(2, 'dep', '$2a$12$xAg1CT2mBgStrjMY2JDuo.L7VRo.uZh/Av53KaaHFxXz60pznQurS', 'Manuel López', 'BASIC', 'gatopotato.PNG__18300abf-2e17-4c4b-9b16-3a99f82a1be9.PNG', 0),
(7, 'fran', '$2a$12$E7poCxGsbvNWv7fdw4ckTu7tQ5UZxXni1iiY.UFU8Nn13Xl0Rxxhm', 'Fran', 'BASIC', 'man02.PNG__e748c486-fb80-4a2d-bcbe-d28ab4b02c09.PNG', 0),
(32, 'pepe', '$2a$12$dt9QKdI.tFs37N./4JzTa.P4k.e94OK9fwshIX78oyghljfPUmGaK', 'Pepe', 'BASIC', 'man05.PNG__07ad806a-db48-4cdd-988b-0a0bbc3c6611.PNG', 0),
(33, 'maria', '$2a$12$BFJJq1CfvaQzVXCq7LSW7OPrh/fgZo9IUMi6iJa7zxgDRW4rESw6e', 'maria', 'BASIC', 'default.png', 0),
(34, 'rodrigo.djv@gmail.com', '$2a$12$hSX0araDdkV7qQwVPLKYwuJsuRyLC4aNbbFZd94AR1D8HtfmiH6zS', 'rodrigo', 'BASIC', 'default.png', 0),
(35, 'm@gmail.com', '$2a$12$i5SR3F5SwOzRwiFNBMxMQORXHeVApdG5fSp92FuFGOCuBH8PWe8HC', 'Man', 'BASIC', 'headphones.PNG__1ed68e44-ea23-4528-b1ce-1d7b0755f74d.PNG', 0),
(36, 'mel', '$2a$12$.gFJ5gvQHD7J375gapc1KuwSMz9ICOqefW.nl1a4JCmQ7N.4ZIA36', 'mel', 'BASIC', 'default.png', 0),
(37, 'luis@gmail.com', '$2a$12$9P2LeN0RnDQK/ZAKd4vixuAYtqmPJkYBgNYRXNodohFG1iE/xpnBm', 'Luis', 'BASIC', '1.png__4ce0a770-9842-4411-8e6d-e3da5cbb642f.png', 0),
(38, 'ralvarezferrera@gmial.com', '$2a$12$.UgXIEHMtdDbk4Qz2/tAf.kCSmz.GrEdQ/obsGn.fCXdO.IWyS2IS', 'Rober', 'BASIC', 'FBQoh6KXEAUiojD.jpg__5f1df66b-c1fe-4b5d-bcb1-8c65e03bb91b.jpg', 0),
(39, 'melomano23@hotmail.com', '$2a$12$IuE4eP9fWLXoBDDURr81CO7kd6k/.Hu3jxBJtkJDnIwFsqaP0Twma', 'Argento', 'BASIC', 'default.png', 0),
(40, 'luiskas22@gmail.com', '$2a$12$ECA3aIFueIcQMUsUGz4IIeGMfbLsNksOLjODc8ECiW.Ln3mPHLWGq', 'Luiskas22', 'BASIC', 'default.png', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_produto` (`id_produto`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `opinion`
--
ALTER TABLE `opinion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`,`idProduto`),
  ADD KEY `idProduto` (`idProduto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_pedido_devol` (`id_pedido_devol`);

--
-- Indices de la tabla `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_marca` (`id_marca`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=558;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `opinion`
--
ALTER TABLE `opinion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=526;

--
-- AUTO_INCREMENT de la tabla `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  ADD CONSTRAINT `linea_pedido_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `linea_pedido_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `opinion`
--
ALTER TABLE `opinion`
  ADD CONSTRAINT `opinion_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `opinion_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_pedido_devol`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
