-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 02 avr. 2025 à 15:03
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestioncourierpostal`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `Id_Agence` int(5) NOT NULL,
  `Nom_Agence` varchar(50) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Ville` varchar(25) NOT NULL,
  `Pays` varchar(25) NOT NULL,
  `Num_Tel` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`Id_Agence`, `Nom_Agence`, `Adresse`, `Ville`, `Pays`, `Num_Tel`) VALUES
(1, 'BWIZA', 'BWIZA', 'Bujumbura', 'Burundi', '+25769551230');

-- --------------------------------------------------------

--
-- Structure de la table `automobile`
--

CREATE TABLE `automobile` (
  `IdAutomobile` int(5) NOT NULL,
  `Num_Plaque` varchar(20) NOT NULL,
  `Marque_Automobile` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `automobile`
--

INSERT INTO `automobile` (`IdAutomobile`, `Num_Plaque`, `Marque_Automobile`) VALUES
(1, 'K 2534 A', 'TOYOTA');

-- --------------------------------------------------------

--
-- Structure de la table `boitepostale`
--

CREATE TABLE `boitepostale` (
  `IdPoste` int(11) NOT NULL,
  `Id_BP` int(10) NOT NULL,
  `Num_BP` varchar(7) NOT NULL,
  `Type_BP` varchar(50) NOT NULL,
  `Etat_BP` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `boitepostale`
--

INSERT INTO `boitepostale` (`IdPoste`, `Id_BP`, `Num_BP`, `Type_BP`, `Etat_BP`) VALUES
(3, 1, 'BP 1237', 'Boîte Postale Commerciale', 'Inactive'),
(4, 2, 'BP 3325', 'Boîte Postale Standard', 'Active'),
(5, 3, 'BP 3789', 'Boîte Postale Commerciale', 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `compagnie`
--

CREATE TABLE `compagnie` (
  `Id_Compagnie` int(15) NOT NULL,
  `Sigle_Compagnie` varchar(25) NOT NULL,
  `Nom_Compagnie` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `compagnie`
--

INSERT INTO `compagnie` (`Id_Compagnie`, `Sigle_Compagnie`, `Nom_Compagnie`) VALUES
(1, 'LMTL', 'LUMITEL');

-- --------------------------------------------------------

--
-- Structure de la table `conduire`
--

CREATE TABLE `conduire` (
  `Id_Conduire` int(15) NOT NULL,
  `Id_Employe` int(15) DEFAULT NULL,
  `Id_Automobile` int(15) DEFAULT NULL,
  `HeureDépart` datetime NOT NULL,
  `HeureRetour` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `consommable`
--

CREATE TABLE `consommable` (
  `Id_Consommable` int(11) NOT NULL,
  `Nom_Consommable` varchar(50) NOT NULL,
  `Quantité` int(11) NOT NULL,
  `Date_Achat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `courrier`
--

CREATE TABLE `courrier` (
  `Id_Courrier` int(5) NOT NULL,
  `Origine_Courrier` varchar(20) NOT NULL,
  `Destination_Courrier` varchar(20) NOT NULL,
  `Poids_Courrier` decimal(10,2) NOT NULL,
  `Type_Courrier` varchar(100) NOT NULL,
  `Date_Envoi` date NOT NULL,
  `Date_Reçu` date NOT NULL,
  `Description_Courrier` text DEFAULT NULL,
  `Montant_Paye` int(20) NOT NULL,
  `Statut` varchar(250) NOT NULL,
  `Id_Agence_Origine` int(5) DEFAULT NULL,
  `Id_Agence_Destination` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `courrier`
--

INSERT INTO `courrier` (`Id_Courrier`, `Origine_Courrier`, `Destination_Courrier`, `Poids_Courrier`, `Type_Courrier`, `Date_Envoi`, `Date_Reçu`, `Description_Courrier`, `Montant_Paye`, `Statut`, `Id_Agence_Origine`, `Id_Agence_Destination`) VALUES
(5, 'KININDO', 'KININDO', 8.00, 'Courrier Standard', '2024-12-25', '2024-12-28', 'HHHH', 3500, 'Envoyé', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `destinataire`
--

CREATE TABLE `destinataire` (
  `Id_Destinataire` int(5) NOT NULL,
  `Id_CourrierEnvoye` int(5) DEFAULT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Telephone` int(15) NOT NULL,
  `Sexe` varchar(10) NOT NULL,
  `Adresse` varchar(25) NOT NULL,
  `Num_Identité` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `destinataire`
--

INSERT INTO `destinataire` (`Id_Destinataire`, `Id_CourrierEnvoye`, `Prenom`, `Nom`, `Telephone`, `Sexe`, `Adresse`, `Num_Identité`) VALUES
(1, 5, 'ETIENNE', 'NIYOKWIZIGIRA', 69980162, 'Masculin', 'GIKUNGU MUTANGA NORD', '531.0304/66.584');

-- --------------------------------------------------------

--
-- Structure de la table `déposant`
--

CREATE TABLE `déposant` (
  `Id_Courrier` int(15) DEFAULT NULL,
  `Id_Déposant` int(15) NOT NULL,
  `Num_Identité` varchar(100) NOT NULL,
  `Adresse` varchar(25) NOT NULL,
  `Nom_Déposant` varchar(20) NOT NULL,
  `Prénom_Déposant` varchar(20) NOT NULL,
  `Tél_Déposant` varchar(20) NOT NULL,
  `Sexe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `déposant`
--

INSERT INTO `déposant` (`Id_Courrier`, `Id_Déposant`, `Num_Identité`, `Adresse`, `Nom_Déposant`, `Prénom_Déposant`, `Tél_Déposant`, `Sexe`) VALUES
(5, 4, '531.0304/66.534', 'KIRIRI', 'KABURA', 'CLAUDE', '61722796', 'Masculin');

-- --------------------------------------------------------

--
-- Structure de la table `dépêche`
--

CREATE TABLE `dépêche` (
  `Id_Dépêche` varchar(20) NOT NULL,
  `Poids_Dépêche` decimal(5,2) NOT NULL,
  `Origine_Dépêche` varchar(20) NOT NULL,
  `Destination_Dépêche` varchar(20) NOT NULL,
  `Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `dépêche`
--

INSERT INTO `dépêche` (`Id_Dépêche`, `Poids_Dépêche`, `Origine_Dépêche`, `Destination_Dépêche`, `Description`) VALUES
('UB/LISTES', 0.50, 'Bujumbura', 'Rumonge', 'Listes des notes des etudiants de UB BACIII/INFO');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `IdEmploye` int(5) NOT NULL,
  `Nom_Employe` varchar(20) NOT NULL,
  `Prenom_Employe` varchar(20) NOT NULL,
  `Matricule` varchar(20) NOT NULL,
  `DateNaiss_Employe` date NOT NULL,
  `DateEmb_Employe` date NOT NULL,
  `NumTel_Employe` varchar(20) NOT NULL,
  `Pswd_Employe` text NOT NULL,
  `Login_Employe` varchar(20) NOT NULL,
  `Id_Service` int(11) DEFAULT NULL,
  `Id_Agence` int(5) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `Statut` enum('Absent','Présent','','') NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`IdEmploye`, `Nom_Employe`, `Prenom_Employe`, `Matricule`, `DateNaiss_Employe`, `DateEmb_Employe`, `NumTel_Employe`, `Pswd_Employe`, `Login_Employe`, `Id_Service`, `Id_Agence`, `role`, `Statut`) VALUES
(1, 'NIYOKWIZIGIRA', 'ETIENNE', '20/3698', '2001-01-01', '2019-01-24', '69980162', '$2a$10$X7VJIIvOtKRtVHTFP1mmcuxy7qBYjy66iQGTSVz2maiBcKYl.eF/q', 'KEDO', 2, 1, 'admin', ''),
(2, 'NZAMBIMANA', 'JANVIER', '21/00934', '2002-06-07', '2025-04-01', '67444025', '$2a$10$uvyLtDFBLwpWSscwz4zTYu/OU9B/C3DJF4YwXXfb0Yl1ZAJ6jrWNq', '21/00934', 3, 1, 'agentSac', '');

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE `equipement` (
  `Id_Equipement` int(11) NOT NULL,
  `Nom_Equipement` varchar(50) NOT NULL,
  `Type_Equipement` varchar(50) NOT NULL,
  `Date_Achat` date NOT NULL,
  `État` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE `poste` (
  `IdPoste` int(11) NOT NULL,
  `Nom_poste` varchar(25) NOT NULL,
  `Régime` varchar(25) NOT NULL,
  `Pays` varchar(15) NOT NULL,
  `Ville` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `poste`
--

INSERT INTO `poste` (`IdPoste`, `Nom_poste`, `Régime`, `Pays`, `Ville`) VALUES
(3, 'KININDO', 'IMBO', 'Burundi', 'Bujumbura'),
(4, 'BWIZA', 'IMBO', 'Burundi', 'Bujumbura'),
(5, 'MUGERE', 'IMBO', 'Burundi', 'Rumonge');

-- --------------------------------------------------------

--
-- Structure de la table `route`
--

CREATE TABLE `route` (
  `IdRoute` int(15) NOT NULL,
  `NomRoute` varchar(20) NOT NULL,
  `VilleDépart` varchar(20) NOT NULL,
  `VilleEscale` varchar(20) NOT NULL,
  `Ville_Arrivé` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `route`
--

INSERT INTO `route` (`IdRoute`, `NomRoute`, `VilleDépart`, `VilleEscale`, `Ville_Arrivé`) VALUES
(1, 'RN3', 'Bujumbura', 'Rumonge', 'Dodoma');

-- --------------------------------------------------------

--
-- Structure de la table `sacinterne`
--

CREATE TABLE `sacinterne` (
  `Id_SacPetitSac` int(5) NOT NULL,
  `Poids_SacInterne` decimal(5,2) NOT NULL,
  `regime` varchar(250) NOT NULL,
  `region` varchar(250) NOT NULL,
  `Details_SacInterne` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `Id_Service` int(5) NOT NULL,
  `Nom_Service` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`Id_Service`, `Nom_Service`) VALUES
(1, 'Accueil'),
(2, 'Administration Système'),
(3, 'Courrier');

-- --------------------------------------------------------

--
-- Structure de la table `tarification`
--

CREATE TABLE `tarification` (
  `Id_Tarif` int(11) NOT NULL,
  `Type_Courrier` varchar(50) NOT NULL,
  `Tarif` decimal(10,2) NOT NULL,
  `Date_Validité` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `IdVille` int(15) NOT NULL,
  `GroupeVille` varchar(20) NOT NULL,
  `NomVille` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `villeconfigure`
--

CREATE TABLE `villeconfigure` (
  `idville` int(11) NOT NULL,
  `nomville` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Déchargement des données de la table `villeconfigure`
--

INSERT INTO `villeconfigure` (`idville`, `nomville`) VALUES
(1, 'Bujumbura'),
(2, 'Gitega'),
(3, 'Ngozi'),
(4, 'Muyinga'),
(5, 'Cibitoke'),
(6, 'Rumonge'),
(7, 'Makamba'),
(8, 'Rutana'),
(9, 'Bururi'),
(10, 'Mwaro'),
(36, 'Bubanza'),
(37, 'Kirundo'),
(38, 'Muramvya'),
(39, 'Bujumbura'),
(40, 'Gitega'),
(41, 'Ngozi'),
(42, 'Muyinga'),
(43, 'Cibitoke'),
(44, 'Rumonge'),
(45, 'Makamba'),
(46, 'Rutana'),
(47, 'Bururi'),
(48, 'Mwaro'),
(74, 'Bubanza'),
(75, 'Kirundo');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`Id_Agence`);

--
-- Index pour la table `automobile`
--
ALTER TABLE `automobile`
  ADD PRIMARY KEY (`IdAutomobile`);

--
-- Index pour la table `boitepostale`
--
ALTER TABLE `boitepostale`
  ADD PRIMARY KEY (`Id_BP`),
  ADD KEY `fkposte` (`IdPoste`);

--
-- Index pour la table `compagnie`
--
ALTER TABLE `compagnie`
  ADD PRIMARY KEY (`Id_Compagnie`);

--
-- Index pour la table `conduire`
--
ALTER TABLE `conduire`
  ADD PRIMARY KEY (`Id_Conduire`),
  ADD KEY `Id_Employe` (`Id_Employe`),
  ADD KEY `Id_Automobile` (`Id_Automobile`);

--
-- Index pour la table `consommable`
--
ALTER TABLE `consommable`
  ADD PRIMARY KEY (`Id_Consommable`);

--
-- Index pour la table `courrier`
--
ALTER TABLE `courrier`
  ADD PRIMARY KEY (`Id_Courrier`),
  ADD KEY `Id_Agence_Origine` (`Id_Agence_Origine`),
  ADD KEY `Id_Agence_Destination` (`Id_Agence_Destination`);

--
-- Index pour la table `destinataire`
--
ALTER TABLE `destinataire`
  ADD PRIMARY KEY (`Id_Destinataire`),
  ADD KEY `Id_CourrierEnvoye` (`Id_CourrierEnvoye`);

--
-- Index pour la table `déposant`
--
ALTER TABLE `déposant`
  ADD PRIMARY KEY (`Id_Déposant`),
  ADD KEY `Id_Courrier` (`Id_Courrier`);

--
-- Index pour la table `dépêche`
--
ALTER TABLE `dépêche`
  ADD PRIMARY KEY (`Id_Dépêche`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`IdEmploye`),
  ADD KEY `fkservice` (`Id_Service`),
  ADD KEY `Id_Agence` (`Id_Agence`);

--
-- Index pour la table `equipement`
--
ALTER TABLE `equipement`
  ADD PRIMARY KEY (`Id_Equipement`);

--
-- Index pour la table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`IdPoste`);

--
-- Index pour la table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`IdRoute`);

--
-- Index pour la table `sacinterne`
--
ALTER TABLE `sacinterne`
  ADD PRIMARY KEY (`Id_SacPetitSac`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Id_Service`);

--
-- Index pour la table `tarification`
--
ALTER TABLE `tarification`
  ADD PRIMARY KEY (`Id_Tarif`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`IdVille`);

--
-- Index pour la table `villeconfigure`
--
ALTER TABLE `villeconfigure`
  ADD PRIMARY KEY (`idville`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `Id_Agence` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `automobile`
--
ALTER TABLE `automobile`
  MODIFY `IdAutomobile` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `boitepostale`
--
ALTER TABLE `boitepostale`
  MODIFY `Id_BP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `compagnie`
--
ALTER TABLE `compagnie`
  MODIFY `Id_Compagnie` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `conduire`
--
ALTER TABLE `conduire`
  MODIFY `Id_Conduire` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `consommable`
--
ALTER TABLE `consommable`
  MODIFY `Id_Consommable` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `courrier`
--
ALTER TABLE `courrier`
  MODIFY `Id_Courrier` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `destinataire`
--
ALTER TABLE `destinataire`
  MODIFY `Id_Destinataire` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `déposant`
--
ALTER TABLE `déposant`
  MODIFY `Id_Déposant` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `IdEmploye` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `equipement`
--
ALTER TABLE `equipement`
  MODIFY `Id_Equipement` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `poste`
--
ALTER TABLE `poste`
  MODIFY `IdPoste` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `route`
--
ALTER TABLE `route`
  MODIFY `IdRoute` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `sacinterne`
--
ALTER TABLE `sacinterne`
  MODIFY `Id_SacPetitSac` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `service`
--
ALTER TABLE `service`
  MODIFY `Id_Service` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `tarification`
--
ALTER TABLE `tarification`
  MODIFY `Id_Tarif` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
