-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.35-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for pbo_laundry
CREATE DATABASE IF NOT EXISTS `pbo_laundry` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pbo_laundry`;

-- Dumping structure for table pbo_laundry.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `tgl_transaksi` datetime DEFAULT CURRENT_TIMESTAMP,
  `tgl_kembali` datetime DEFAULT NULL,
  `jenis_cuci` varchar(50) DEFAULT NULL,
  `berat` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `FK_transaksi_kasir` (`id_user`),
  CONSTRAINT `FK_transaksi_kasir` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table pbo_laundry.transaksi: ~12 rows (approximately)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `nama`, `tgl_transaksi`, `tgl_kembali`, `jenis_cuci`, `berat`, `total`) VALUES
	(10, 1, 'Yoga', '2019-12-09 12:40:07', '2019-12-11 12:40:07', 'Cuci Setrika', 5, 25000),
	(12, 1, 'Brengl', '2019-12-09 21:34:43', '2019-12-11 21:34:43', 'Cuci Kering', 3, 30600),
	(13, 1, 'Kusuma', '2019-12-09 21:36:31', '2019-12-11 21:36:31', 'Cuci Kering', 3, 30600),
	(14, 1, 'Breng', '2019-12-09 21:37:06', '2019-12-11 21:37:06', 'Setrika', 2, 10200),
	(15, 1, 'Ferdi', '2019-12-09 21:52:10', '2019-12-11 21:52:10', 'Cuci Kering Setrika', 3, 45900),
	(17, 1, 'Denny', '2019-12-09 22:34:03', '2019-12-11 22:34:03', 'Cuci Kering', 3, 30600),
	(18, 1, 'Irvan', '2019-12-09 22:41:52', '2019-12-11 22:41:52', 'Cuci Kering', 2, 20400),
	(19, 1, 'Ferdi', '2019-12-09 23:28:09', '2019-12-11 23:28:09', 'Setrika', 2, 10200),
	(20, 1, 'rased', '2019-12-10 12:44:56', '2019-12-12 12:44:56', 'Cuci Kering', 2, 20400),
	(21, 1, 'Irfan', '2019-12-12 20:47:46', '2019-12-14 20:47:46', 'Cuci Kering Setrika', 2, 31500),
	(22, 1, 'Dhanu', '2019-12-13 16:25:59', '2019-12-15 16:25:59', 'Cuci Kering', 3, 31500),
	(23, 1, 'Irvan', '2019-12-13 17:23:30', '2019-12-15 17:23:30', 'Cuci Kering', 2, 21000);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

-- Dumping structure for table pbo_laundry.user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `gaji` int(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` enum('kasir','admin') NOT NULL DEFAULT 'kasir',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table pbo_laundry.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `nama`, `gaji`, `username`, `password`, `role`) VALUES
	(1, 'breng', 900000, 'breng', '123', 'kasir'),
	(2, 'gopla', NULL, 'gopla', '123', 'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
