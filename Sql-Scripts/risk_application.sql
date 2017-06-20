-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 19, 2017 at 08:46 PM
-- Server version: 5.6.34
-- PHP Version: 5.6.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `risk_application`
--
CREATE DATABASE IF NOT EXISTS `risk_application` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `risk_application`;

-- --------------------------------------------------------

--
-- Table structure for table `settled`
--

CREATE TABLE `settled` (
  `id` int(11) NOT NULL,
  `customer` int(1) DEFAULT NULL,
  `event` int(1) NOT NULL,
  `partcipant` int(2) NOT NULL,
  `stake` int(5) NOT NULL,
  `win` int(5) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `settled`
--

INSERT INTO `settled` (`id`, `customer`, `event`, `partcipant`, `stake`, `win`, `date_added`) VALUES
(1, 1, 2, 6, 5, 15, '2017-06-20 03:05:24');

-- --------------------------------------------------------

--
-- Table structure for table `unsettled`
--

CREATE TABLE `unsettled` (
  `id` int(11) NOT NULL,
  `customer` int(2) NOT NULL,
  `event` int(2) NOT NULL,
  `partcipant` int(2) NOT NULL,
  `stake` int(5) NOT NULL,
  `win` int(5) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unsettled`
--

INSERT INTO `unsettled` (`id`, `customer`, `event`, `partcipant`, `stake`, `win`, `date_added`) VALUES
(1, 1, 2, 3, 5, 15, '2017-06-20 02:10:02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `settled`
--
ALTER TABLE `settled`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unsettled`
--
ALTER TABLE `unsettled`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `settled`
--
ALTER TABLE `settled`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `unsettled`
--
ALTER TABLE `unsettled`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
