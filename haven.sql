-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2022 at 12:24 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `haven`
--

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE `budget` (
  `ID_Budget` int(11) NOT NULL,
  `Montant` int(11) DEFAULT NULL,
  `Activite` varchar(100) DEFAULT NULL,
  `ID_Sponsor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `budget`
--

INSERT INTO `budget` (`ID_Budget`, `Montant`, `Activite`, `ID_Sponsor`) VALUES
(5, 200, 'pub', 11),
(6, 500, 'pub2', 11);

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `orderID` int(11) NOT NULL,
  `client` varchar(50) NOT NULL,
  `somme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`orderID`, `client`, `somme`) VALUES
(14, 'User', 0),
(40, 'null', 0),
(41, 'Maher', 50),
(42, 'User', 0),
(43, 'User', 0),
(44, 'User', 0),
(45, 'User', 0),
(46, 'User', 0),
(47, 'User', 0),
(48, 'User', 0),
(49, 'User', 0),
(50, 'User', 0),
(51, 'User', 0),
(52, 'User', 0),
(53, 'User', 0),
(54, 'User', 0),
(55, 'User', 0),
(56, 'User', 0),
(57, 'User', 0),
(58, 'User', 0),
(59, 'User', 0),
(60, 'User', 0),
(61, 'User', 0),
(62, 'User', 0),
(63, 'User', 0),
(64, 'User', 0),
(65, 'User', 0),
(66, 'User', 0),
(67, 'User', 0),
(68, 'User', 0),
(69, 'User', 0),
(70, 'User', 0),
(71, 'User', 0),
(72, 'User', 0),
(73, 'User', 0);

-- --------------------------------------------------------

--
-- Table structure for table `commandeproduit`
--

CREATE TABLE `commandeproduit` (
  `cpID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `sommePrix` int(11) NOT NULL,
  `orderID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `nbrJoueur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`id`, `nom`, `nbrJoueur`) VALUES
(1855839, 'fnatic', '4');

-- --------------------------------------------------------

--
-- Table structure for table `joueur`
--

CREATE TABLE `joueur` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `birthday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `partie`
--

CREATE TABLE `partie` (
  `idPartie` int(11) NOT NULL,
  `duree` float NOT NULL,
  `date_derou` date NOT NULL,
  `id_tournoi` int(11) NOT NULL,
  `score1` int(11) NOT NULL,
  `score2` int(11) NOT NULL,
  `id_equipe1` int(11) NOT NULL,
  `id_equipe2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `partie`
--

INSERT INTO `partie` (`idPartie`, `duree`, `date_derou`, `id_tournoi`, `score1`, `score2`, `id_equipe1`, `id_equipe2`) VALUES
(19, 30, '2022-03-16', 16, 5, 3, 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `productID` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `marque` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`productID`, `nom`, `type`, `marque`, `quantite`, `prix`) VALUES
(41, 'fsss', 'fff', 'G2 Esports', 75, 50),
(42, 'sfdgsgs', 'pull', 'Fnatic', 30, 20),
(44, 'sfgs', 'pull', 'Fnatic', 20, 30),
(45, 'pull bleu', 'vetement', 'Cloud 9', 10, 30),
(46, 'pull vert', 'vetement', 'Cloud 9', 25, 6),
(47, 'pull orangé', 'vetement', 'G2 Esports', 25, 6),
(48, 'pull 3', 'vetement', 'G2 Esports', 27, 8),
(49, 'k3', 'vetement', 'G2 Esports', 10, 10),
(51, 'g2 casq', 'casquette', 'G2 Esports', 21, 9),
(52, 'g2 casq 2', 'casquette', 'G2 Esports', 13, 8),
(53, 'hello', 'g', 'Fnatic', 30, 12),
(54, 'hi', 'casquette', 'Cloud 9', 5, 20),
(55, 'gsdf', 'gg', 'Cloud 9', 3, 5),
(56, 'fsd', 'fddd', 'Other', 20, 30),
(57, 'm55', 'casquette', 'G2 Esports', 35, 30);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_rec` int(11) NOT NULL,
  `content` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`id_rec`, `content`, `email`) VALUES
(14, 'hello', 'hello'),
(15, 'test', 'test'),
(16, '2', '2'),
(17, 'hbyoyuhbn', 'hbyoyuhbn');

-- --------------------------------------------------------

--
-- Table structure for table `reponse_reclam`
--

CREATE TABLE `reponse_reclam` (
  `id_answer` int(11) NOT NULL,
  `id_rec` int(11) NOT NULL,
  `content` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sponsors`
--

CREATE TABLE `sponsors` (
  `ID_Sponsor` int(11) NOT NULL,
  `Nom_Sponsor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `Prenom_Sponsor` varchar(50) DEFAULT NULL,
  `Montant` int(11) DEFAULT NULL,
  `Duree_spons` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sponsors`
--

INSERT INTO `sponsors` (`ID_Sponsor`, `Nom_Sponsor`, `Prenom_Sponsor`, `Montant`, `Duree_spons`) VALUES
(11, 'jerbi', 'skander', 550, 100),
(13, 'm', 'ramy', 200, 60);

-- --------------------------------------------------------

--
-- Table structure for table `tournois`
--

CREATE TABLE `tournois` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `nb_equipes` int(50) NOT NULL,
  `date_deb` date NOT NULL,
  `date_fin` date NOT NULL,
  `jeux` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tournois`
--

INSERT INTO `tournois` (`id`, `nom`, `nb_equipes`, `date_deb`, `date_fin`, `jeux`) VALUES
(16, 'tournoi 1 ', 4, '2022-03-15', '2022-03-19', 'CS:GO'),
(17, 'fs ', 4, '2022-03-14', '2022-03-16', 'gdfgd'),
(18, 'vxcvxc ', 4, '2022-03-21', '2022-03-23', 'LOL');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `pays` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `num_tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `email`, `login`, `mdp`, `pays`, `role`, `num_tel`) VALUES
(1, 'firas', 'soltani', '', '', '', '', '', 0),
(2, 'firas', 'soltani', 'firas', 'firas', 'firas', 'firas', 'tunisie', 93022066);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(15) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `num_tel` int(20) NOT NULL,
  `pays` varchar(15) NOT NULL,
  `role` varchar(15) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `banne` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `mdp`, `nom`, `prenom`, `email`, `num_tel`, `pays`, `role`, `etat`, `banne`) VALUES
(1, 'bachir', 'YmFjaGly', 'ffdsds', 'dfsdfsdf', 'dfsfddf', 88, 'ddsds', 'ddsds', 0, 0),
(2, 'vcx', 'dnhjdg==', 'vcx', 'vcx', 'vxcvx', 12345678, 'tn', 'comite', 0, 0),
(3, 'abc', 'abc', 'a', 'b', 'c', 1, 'tn', 'user', 0, 0),
(4, 'hhh', 'NTU=', 'ramy', 'klouz', 'ramy', 46, 'tn', 'comite', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`ID_Budget`),
  ADD KEY `ID_Sponsor` (`ID_Sponsor`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`orderID`);

--
-- Indexes for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  ADD PRIMARY KEY (`cpID`),
  ADD KEY `productconstraint` (`productID`),
  ADD KEY `orderID` (`orderID`);

--
-- Indexes for table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`idPartie`),
  ADD KEY `fk_tournois` (`id_tournoi`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_rec`) USING BTREE;

--
-- Indexes for table `reponse_reclam`
--
ALTER TABLE `reponse_reclam`
  ADD PRIMARY KEY (`id_answer`),
  ADD KEY `id_rec` (`id_rec`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `sponsors`
--
ALTER TABLE `sponsors`
  ADD PRIMARY KEY (`ID_Sponsor`);

--
-- Indexes for table `tournois`
--
ALTER TABLE `tournois`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `budget`
--
ALTER TABLE `budget`
  MODIFY `ID_Budget` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  MODIFY `cpID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `partie`
--
ALTER TABLE `partie`
  MODIFY `idPartie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_rec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `reponse_reclam`
--
ALTER TABLE `reponse_reclam`
  MODIFY `id_answer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sponsors`
--
ALTER TABLE `sponsors`
  MODIFY `ID_Sponsor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tournois`
--
ALTER TABLE `tournois`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `budget`
--
ALTER TABLE `budget`
  ADD CONSTRAINT `budget_ibfk_1` FOREIGN KEY (`ID_Sponsor`) REFERENCES `sponsors` (`ID_Sponsor`);

--
-- Constraints for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  ADD CONSTRAINT `orderconstraint` FOREIGN KEY (`orderID`) REFERENCES `commande` (`orderID`),
  ADD CONSTRAINT `productconstraint` FOREIGN KEY (`productID`) REFERENCES `produit` (`productID`);

--
-- Constraints for table `partie`
--
ALTER TABLE `partie`
  ADD CONSTRAINT `fk_tournois` FOREIGN KEY (`id_tournoi`) REFERENCES `tournois` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reponse_reclam`
--
ALTER TABLE `reponse_reclam`
  ADD CONSTRAINT `reponse_reclam_ibfk_1` FOREIGN KEY (`id_rec`) REFERENCES `reclamation` (`id_rec`),
  ADD CONSTRAINT `reponse_reclam_ibfk_2` FOREIGN KEY (`id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
