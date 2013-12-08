-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2013 at 10:31 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `student`
--
CREATE DATABASE IF NOT EXISTS `student` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `student`;

-- --------------------------------------------------------

--
-- Table structure for table `bunkedclass`
--

CREATE TABLE IF NOT EXISTS `bunkedclass` (
  `usn` varchar(20) NOT NULL DEFAULT '',
  `os` int(11) NOT NULL DEFAULT '0',
  `ss` int(11) NOT NULL DEFAULT '0',
  `dbs` int(11) NOT NULL DEFAULT '0',
  `cn` int(11) NOT NULL DEFAULT '0',
  `se` int(11) NOT NULL DEFAULT '0',
  `java` int(11) NOT NULL DEFAULT '0',
  `javalab` int(11) NOT NULL DEFAULT '0',
  `cnlab` int(11) NOT NULL DEFAULT '0',
  `dbslab` int(11) NOT NULL DEFAULT '0',
  `sslab` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`usn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `holiday`
--

CREATE TABLE IF NOT EXISTS `holiday` (
  `eventdate` date NOT NULL,
  `day` varchar(10) NOT NULL,
  `event` varchar(20) NOT NULL,
  PRIMARY KEY (`event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `holiday`
--

INSERT INTO `holiday` (`eventdate`, `day`, `event`) VALUES
('2013-11-04', 'monday', 'balipadyami'),
('2013-10-16', 'wednesday', 'eid-ul-adha'),
('2013-10-02', 'wednesday', 'gandhi jayanti'),
('2013-09-09', 'monday', 'ganesh chaturthi'),
('2013-11-20', 'wednesday', 'kanakdasa jayanthi'),
('2013-11-01', 'friday', 'karnataka rajyotsava'),
('2013-10-04', 'friday', 'mahalaya amavasya'),
('2013-10-18', 'friday', 'maharishi valmiki ja'),
('2013-10-18', 'friday', 'maharishivalmiki jay'),
('2013-11-15', 'friday', 'muharram'),
('2013-11-02', 'saturday', 'naraka chaturdashi'),
('2013-08-16', 'friday', 'varamlakshmi vratha'),
('2013-10-14', 'monday', 'vijayadakshmi');

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE IF NOT EXISTS `studentdetails` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `fname` varchar(10) DEFAULT NULL,
  `lname` varchar(10) DEFAULT NULL,
  `usn` varchar(11) DEFAULT NULL,
  `class` varchar(3) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `pswd` varchar(15) DEFAULT NULL,
  `question` int(11) DEFAULT NULL,
  `answer` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `usn` (`usn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tta`
--

CREATE TABLE IF NOT EXISTS `tta` (
  `day` varchar(10) DEFAULT NULL,
  `ss` int(11) DEFAULT NULL,
  `os` int(11) DEFAULT NULL,
  `dbs` int(11) DEFAULT NULL,
  `cn` int(11) DEFAULT NULL,
  `se` int(11) DEFAULT NULL,
  `jav` int(11) DEFAULT NULL,
  `cnlab` int(11) DEFAULT NULL,
  `dbslab` int(11) DEFAULT NULL,
  `sslab` int(11) DEFAULT NULL,
  `javalab` int(11) DEFAULT NULL,
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tta`
--

INSERT INTO `tta` (`day`, `ss`, `os`, `dbs`, `cn`, `se`, `jav`, `cnlab`, `dbslab`, `sslab`, `javalab`) VALUES
('monday', 1, 1, 1, 0, 1, 1, 0, 0, 1, 0),
('tuesday', 0, 1, 1, 1, 1, 0, 0, 0, 0, 1),
('wednesday', 1, 1, 1, 1, 1, 1, 0, 0, 0, 0),
('thursday', 0, 0, 1, 1, 1, 1, 1, 0, 0, 0),
('friday', 0, 1, 0, 1, 0, 0, 0, 1, 0, 0),
('saturday', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ttb`
--

CREATE TABLE IF NOT EXISTS `ttb` (
  `day` varchar(10) DEFAULT NULL,
  `ss` int(11) DEFAULT NULL,
  `os` int(11) DEFAULT NULL,
  `dbs` int(11) DEFAULT NULL,
  `cn` int(11) DEFAULT NULL,
  `se` int(11) DEFAULT NULL,
  `jav` int(11) DEFAULT NULL,
  `cnlab` int(11) DEFAULT NULL,
  `dbslab` int(11) DEFAULT NULL,
  `sslab` int(11) DEFAULT NULL,
  `javalab` int(11) DEFAULT NULL,
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ttb`
--

INSERT INTO `ttb` (`day`, `ss`, `os`, `dbs`, `cn`, `se`, `jav`, `cnlab`, `dbslab`, `sslab`, `javalab`) VALUES
('monday', 1, 1, 1, 1, 0, 1, 0, 0, 1, 0),
('tuesday', 0, 1, 1, 1, 1, 1, 1, 0, 0, 0),
('wednesday', 0, 0, 1, 0, 1, 1, 0, 0, 0, 1),
('thursday', 0, 1, 1, 1, 1, 0, 0, 1, 0, 0),
('friday', 1, 1, 0, 1, 1, 0, 0, 0, 0, 0),
('saturday', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ttc`
--

CREATE TABLE IF NOT EXISTS `ttc` (
  `day` varchar(10) DEFAULT NULL,
  `ss` int(11) DEFAULT NULL,
  `os` int(11) DEFAULT NULL,
  `dbs` int(11) DEFAULT NULL,
  `cn` int(11) DEFAULT NULL,
  `se` int(11) DEFAULT NULL,
  `jav` int(11) DEFAULT NULL,
  `cnlab` int(11) DEFAULT NULL,
  `dbslab` int(11) DEFAULT NULL,
  `sslab` int(11) DEFAULT NULL,
  `javalab` int(11) DEFAULT NULL,
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ttc`
--

INSERT INTO `ttc` (`day`, `ss`, `os`, `dbs`, `cn`, `se`, `jav`, `cnlab`, `dbslab`, `sslab`, `javalab`) VALUES
('monday', 0, 1, 1, 1, 1, 1, 1, 0, 0, 0),
('tuesday', 0, 1, 1, 1, 1, 1, 0, 0, 0, 0),
('wednesday', 0, 0, 1, 1, 1, 1, 0, 0, 1, 0),
('thursday', 1, 1, 1, 0, 1, 0, 0, 0, 0, 1),
('friday', 1, 1, 0, 1, 0, 0, 0, 1, 0, 0),
('saturday', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
