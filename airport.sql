-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Июн 21 2018 г., 16:19
-- Версия сервера: 5.6.38
-- Версия PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `airport`
--

-- --------------------------------------------------------

--
-- Структура таблицы `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `point` text NOT NULL,
  `plane` int(11) NOT NULL,
  `dispatchtime` text NOT NULL,
  `arrivaltime` text NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `flights`
--

INSERT INTO `flights` (`id`, `point`, `plane`, `dispatchtime`, `arrivaltime`, `status`) VALUES
(1, 'Минск - Москва', 1, '2018-06-12 17:00:00', '2018-06-12 21:00:00', 'ARRIVAL');

-- --------------------------------------------------------

--
-- Структура таблицы `flights_passengers`
--

CREATE TABLE `flights_passengers` (
  `id_flights` int(11) NOT NULL,
  `id_passengers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `flights_passengers`
--

INSERT INTO `flights_passengers` (`id_flights`, `id_passengers`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `flights_pilots`
--

CREATE TABLE `flights_pilots` (
  `id_flights` int(11) NOT NULL,
  `id_pilots` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `flights_pilots`
--

INSERT INTO `flights_pilots` (`id_flights`, `id_pilots`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `passengers`
--

CREATE TABLE `passengers` (
  `id` int(11) NOT NULL,
  `secondname` varchar(32) NOT NULL,
  `firstname` varchar(32) NOT NULL,
  `thirdname` varchar(32) NOT NULL,
  `passport` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `passengers`
--

INSERT INTO `passengers` (`id`, `secondname`, `firstname`, `thirdname`, `passport`) VALUES
(1, 'Зиновьев', 'Мирон ', 'Пантелеймонович', 'HB2964301585'),
(2, 'Дубинина', 'Пелагея  ', 'Игнатиевна ', 'HB2943158052');

-- --------------------------------------------------------

--
-- Структура таблицы `pilots`
--

CREATE TABLE `pilots` (
  `id` int(11) NOT NULL,
  `secondname` varchar(32) NOT NULL,
  `firstname` varchar(32) NOT NULL,
  `thirdname` varchar(32) NOT NULL,
  `experience` int(11) NOT NULL,
  `position` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `pilots`
--

INSERT INTO `pilots` (`id`, `secondname`, `firstname`, `thirdname`, `experience`, `position`) VALUES
(1, 'Русаков', 'Геннадий ', 'Гордеевич', 3, 1),
(2, 'Нестеров', 'Агафон ', 'Семенович', 2, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `plane`
--

CREATE TABLE `plane` (
  `id` int(11) NOT NULL,
  `model` text NOT NULL,
  `offsetability` int(11) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `plane`
--

INSERT INTO `plane` (`id`, `model`, `offsetability`, `type`) VALUES
(1, 'Boeing 747-400', 522, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `positions`
--

CREATE TABLE `positions` (
  `id` int(11) NOT NULL,
  `position` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `positions`
--

INSERT INTO `positions` (`id`, `position`) VALUES
(1, 'Первый пилот'),
(2, 'Второй пилот');

-- --------------------------------------------------------

--
-- Структура таблицы `types`
--

CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `types`
--

INSERT INTO `types` (`id`, `type`) VALUES
(1, 'Пассажирский'),
(2, 'Грузовой'),
(3, 'Частный');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`),
  ADD KEY `plane` (`plane`);

--
-- Индексы таблицы `flights_passengers`
--
ALTER TABLE `flights_passengers`
  ADD KEY `id_flights` (`id_flights`),
  ADD KEY `id_passengers` (`id_passengers`);

--
-- Индексы таблицы `flights_pilots`
--
ALTER TABLE `flights_pilots`
  ADD KEY `id_flights` (`id_flights`),
  ADD KEY `id_pilots` (`id_pilots`);

--
-- Индексы таблицы `passengers`
--
ALTER TABLE `passengers`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `pilots`
--
ALTER TABLE `pilots`
  ADD PRIMARY KEY (`id`),
  ADD KEY `position` (`position`);

--
-- Индексы таблицы `plane`
--
ALTER TABLE `plane`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`type`);

--
-- Индексы таблицы `positions`
--
ALTER TABLE `positions`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `passengers`
--
ALTER TABLE `passengers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `pilots`
--
ALTER TABLE `pilots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `plane`
--
ALTER TABLE `plane`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `positions`
--
ALTER TABLE `positions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`plane`) REFERENCES `plane` (`id`);

--
-- Ограничения внешнего ключа таблицы `flights_passengers`
--
ALTER TABLE `flights_passengers`
  ADD CONSTRAINT `flights_passengers_ibfk_1` FOREIGN KEY (`id_flights`) REFERENCES `flights` (`id`),
  ADD CONSTRAINT `flights_passengers_ibfk_2` FOREIGN KEY (`id_passengers`) REFERENCES `passengers` (`id`);

--
-- Ограничения внешнего ключа таблицы `flights_pilots`
--
ALTER TABLE `flights_pilots`
  ADD CONSTRAINT `flights_pilots_ibfk_1` FOREIGN KEY (`id_flights`) REFERENCES `flights` (`id`),
  ADD CONSTRAINT `flights_pilots_ibfk_2` FOREIGN KEY (`id_pilots`) REFERENCES `pilots` (`id`);

--
-- Ограничения внешнего ключа таблицы `pilots`
--
ALTER TABLE `pilots`
  ADD CONSTRAINT `pilots_ibfk_1` FOREIGN KEY (`position`) REFERENCES `positions` (`id`);

--
-- Ограничения внешнего ключа таблицы `plane`
--
ALTER TABLE `plane`
  ADD CONSTRAINT `plane_ibfk_1` FOREIGN KEY (`type`) REFERENCES `types` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
