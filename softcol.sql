-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2022 a las 05:38:29
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `softcol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `Id` int(11) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Teléfono` bigint(20) NOT NULL,
  `Dirección` varchar(100) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`Id`, `Nombres`, `Apellidos`, `Teléfono`, `Dirección`, `Usuario`, `Contraseña`) VALUES
(1, 'Carlos Armando', 'Devia', 3197820942, 'Mz H Casa 7', 'parkista258', 'xdxdxd'),
(2, 'Carlos Eduardo', 'Casas', 3197820942, 'Mz H Casa 7', 'parkista258', 'xdxdxd'),
(3, 'x', 'c', 2341845, 'fa 31 #54-65', 'asdasfas', 'gfghfdghgfh'),
(4, 'Fabian Andrés', 'Devia Ochoa', 3197426520, 'Calle 31 #54-65', 'Fabian85747', '456152588');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `Id` int(11) NOT NULL,
  `Área` varchar(50) NOT NULL,
  `Descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`Id`, `Área`, `Descripcion`) VALUES
(1, 'Vasectomía', 'Es el campo donde se practica.....');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `IdCitas` int(11) NOT NULL,
  `Paciente` int(11) NOT NULL,
  `Médico` int(11) NOT NULL,
  `Tipo` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Estado` enum('Pendiente','Cancelada','Terminada') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `Id` int(11) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Teléfono` bigint(20) NOT NULL,
  `Dirección` varchar(100) NOT NULL,
  `Área` int(11) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`Id`, `Nombres`, `Apellidos`, `FechaNacimiento`, `Teléfono`, `Dirección`, `Área`, `Usuario`, `Contraseña`) VALUES
(1, 'dfsfds', 'dsad', '2000-02-24', 3197820911, 'hgfhhsgdf', 1, 'fdggfdhggf', 'dfgfdghgfdhgfh'),
(2, 'x', 'cddf', '2000-03-24', 2341845, 'fafa 31 #54-65', 1, 'asdasfas', '4558945454');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `Id` int(11) NOT NULL,
  `Cedula` bigint(20) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Teléfono` bigint(20) NOT NULL,
  `Dirección` varchar(100) NOT NULL,
  `Estado` enum('activo','desactivo') NOT NULL,
  `Usuario` varchar(100) NOT NULL,
  `Contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Id`, `Cedula`, `Nombres`, `Apellidos`, `FechaNacimiento`, `Teléfono`, `Dirección`, `Estado`, `Usuario`, `Contraseña`) VALUES
(1, 1001295983, 'Carlos Armando', 'Devia', '2000-02-27', 3197820942, 'Mz H Casa 7', 'activo', 'parkista258', 'xdxdxd'),
(4, 1004798554, 'Carlos Eduardo', 'Casas', '2000-02-27', 3197820942, 'Mz H Casa 7', 'activo', 'parkista258', 'xdxdxd'),
(5, 1005488, 'x', 'c', '1996-07-05', 2341845, 'fafa 31 #54-65', 'activo', 'asdasfas', '11111111'),
(6, 132114475, 'Lizeth', 'Bermúdez', '1998-03-18', 5447812, 'Cra 97 #79-62', 'activo', 'Liz12A', '14547487562124');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vw_medicos_areas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vw_medicos_areas` (
`Id` int(11)
,`Nombres` varchar(50)
,`Apellidos` varchar(50)
,`FechaNacimiento` date
,`Teléfono` bigint(20)
,`Dirección` varchar(100)
,`Área` varchar(50)
,`Usuario` varchar(50)
,`Contraseña` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vw_medicos_areas`
--
DROP TABLE IF EXISTS `vw_medicos_areas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_medicos_areas`  AS SELECT `medicos`.`Id` AS `Id`, `medicos`.`Nombres` AS `Nombres`, `medicos`.`Apellidos` AS `Apellidos`, `medicos`.`FechaNacimiento` AS `FechaNacimiento`, `medicos`.`Teléfono` AS `Teléfono`, `medicos`.`Dirección` AS `Dirección`, `area`.`Área` AS `Área`, `medicos`.`Usuario` AS `Usuario`, `medicos`.`Contraseña` AS `Contraseña` FROM (`medicos` join `area` on(`area`.`Id` = `medicos`.`Área`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`IdCitas`),
  ADD KEY `FK_medicos_citas` (`Médico`),
  ADD KEY `FK_pacientes_citas` (`Paciente`),
  ADD KEY `FK_area_citas` (`Tipo`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Medicos_Rol` (`Área`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Cedula` (`Cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `IdCitas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medicos`
--
ALTER TABLE `medicos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `FK_area_citas` FOREIGN KEY (`Tipo`) REFERENCES `area` (`Id`),
  ADD CONSTRAINT `FK_medicos_citas` FOREIGN KEY (`Médico`) REFERENCES `medicos` (`Id`),
  ADD CONSTRAINT `FK_pacientes_citas` FOREIGN KEY (`Paciente`) REFERENCES `pacientes` (`Id`);

--
-- Filtros para la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD CONSTRAINT `FK_Medicos_Rol` FOREIGN KEY (`Área`) REFERENCES `area` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
