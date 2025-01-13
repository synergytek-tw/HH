-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hh
-- ------------------------------------------------------
-- Server version	5.5.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accmemo`
--

CREATE DATABASE IF NOT EXISTS hh;

DROP TABLE IF EXISTS `accmemo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accmemo` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `MemoDate` varchar(10) DEFAULT NULL,
  `PaymentDate` varchar(10) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `VoucherMemo` varchar(100) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accmemo`
--

LOCK TABLES `accmemo` WRITE;
/*!40000 ALTER TABLE `accmemo` DISABLE KEYS */;
/*!40000 ALTER TABLE `accmemo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `FlowKey` varchar(50) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Emp_id` varchar(20) DEFAULT NULL,
  `Language` varchar(20) DEFAULT NULL,
  `OpenMenu` char(1) DEFAULT NULL,
  `EffectDateFrom` varchar(20) DEFAULT NULL,
  `EffectDateTo` varchar(20) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin','tony@infos','admin','chinese','Y','2000-05-01','2100-12-31','admin','99');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accountingyear`
--

DROP TABLE IF EXISTS `accountingyear`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountingyear` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  `CanQueryFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountingyear`
--

LOCK TABLES `accountingyear` WRITE;
/*!40000 ALTER TABLE `accountingyear` DISABLE KEYS */;
/*!40000 ALTER TABLE `accountingyear` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `IdType` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `EnglishNames` varchar(200) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `CompanyReq` varchar(100) DEFAULT NULL,
  `EnglishCompanyReq` varchar(100) DEFAULT NULL,
  `TelNo` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnglishAddress` varchar(200) DEFAULT NULL,
  `Memo` text,
  `Appendix` varchar(100) DEFAULT NULL,
  `Birthday` varchar(20) DEFAULT NULL,
  `Company` varchar(5000) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `EnglishLastName` varchar(100) DEFAULT NULL,
  `EnglishFirstName` varchar(100) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `WebSite` varchar(50) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `ShowInClient` varchar(1) DEFAULT 'N',
  `ApplicantKind` varchar(50) DEFAULT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `TelNo2` varchar(50) DEFAULT NULL,
  `ApplicantType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant_2`
--

DROP TABLE IF EXISTS `applicant_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `IdType` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `EnglishNames` varchar(200) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `CompanyReq` varchar(100) DEFAULT NULL,
  `EnglishCompanyReq` varchar(100) DEFAULT NULL,
  `TelNo` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnglishAddress` varchar(200) DEFAULT NULL,
  `Memo` text,
  `Appendix` varchar(100) DEFAULT NULL,
  `Birthday` varchar(20) DEFAULT NULL,
  `Company` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `EnglishLastName` varchar(100) DEFAULT NULL,
  `EnglishFirstName` varchar(100) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `WebSite` varchar(50) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `ShowInClient` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_2`
--

LOCK TABLES `applicant_2` WRITE;
/*!40000 ALTER TABLE `applicant_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apwriteofflog`
--

DROP TABLE IF EXISTS `apwriteofflog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apwriteofflog` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TodosId` varchar(50) DEFAULT NULL,
  `PaymentId` varchar(50) DEFAULT NULL,
  `PayId` varchar(50) DEFAULT NULL,
  `WriteOffAmount` double(16,4) DEFAULT NULL,
  `WriteOffDate` varchar(10) DEFAULT NULL,
  `PaymentDetailType` varchar(50) DEFAULT NULL,
  `Reversal` varchar(50) DEFAULT NULL,
  `DoReversal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apwriteofflog`
--

LOCK TABLES `apwriteofflog` WRITE;
/*!40000 ALTER TABLE `apwriteofflog` DISABLE KEYS */;
/*!40000 ALTER TABLE `apwriteofflog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arwriteofflog`
--

DROP TABLE IF EXISTS `arwriteofflog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arwriteofflog` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TodosId` varchar(50) DEFAULT NULL,
  `InvoiceId` varchar(50) DEFAULT NULL,
  `ReceiptId` varchar(50) DEFAULT NULL,
  `WriteOffAmount` double(16,4) DEFAULT NULL,
  `WriteOffDate` varchar(10) DEFAULT NULL,
  `Reversal` varchar(50) DEFAULT NULL,
  `DoReversal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arwriteofflog`
--

LOCK TABLES `arwriteofflog` WRITE;
/*!40000 ALTER TABLE `arwriteofflog` DISABLE KEYS */;
/*!40000 ALTER TABLE `arwriteofflog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetadd`
--

DROP TABLE IF EXISTS `assetadd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetadd` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(255) DEFAULT NULL,
  `AssetType` varchar(50) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `AssetDept` varchar(50) DEFAULT NULL,
  `Keeper` varchar(50) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `AccountingNo` varchar(50) DEFAULT NULL,
  `AssetDate` varchar(10) DEFAULT NULL,
  `VoucherNo` varchar(50) DEFAULT NULL,
  `AssetUnitNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetadd`
--

LOCK TABLES `assetadd` WRITE;
/*!40000 ALTER TABLE `assetadd` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetadd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetadd_detail`
--

DROP TABLE IF EXISTS `assetadd_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetadd_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `AssetDate` varchar(10) DEFAULT NULL,
  `AssetNo` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `CategoryCode` varchar(50) DEFAULT NULL,
  `CodeSeries` varchar(10) DEFAULT NULL,
  `Source` varchar(50) DEFAULT NULL,
  `Unit` varchar(20) DEFAULT NULL,
  `Qty` double DEFAULT NULL,
  `UnitAmount` double DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Place` varchar(50) DEFAULT NULL,
  `ScrapValue` int(11) DEFAULT NULL,
  `CanUseYear` int(11) DEFAULT NULL,
  `Depreciation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetadd_detail`
--

LOCK TABLES `assetadd_detail` WRITE;
/*!40000 ALTER TABLE `assetadd_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetadd_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetdiscard`
--

DROP TABLE IF EXISTS `assetdiscard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetdiscard` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(255) DEFAULT NULL,
  `AssetType` varchar(50) DEFAULT NULL,
  `DiscardDate` varchar(10) DEFAULT NULL,
  `AssetDept` varchar(50) DEFAULT NULL,
  `Keeper` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetdiscard`
--

LOCK TABLES `assetdiscard` WRITE;
/*!40000 ALTER TABLE `assetdiscard` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetdiscard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetdiscard_detail`
--

DROP TABLE IF EXISTS `assetdiscard_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetdiscard_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `AssetNo` varchar(50) DEFAULT NULL,
  `Place` varchar(50) DEFAULT NULL,
  `UsedYear` int(11) DEFAULT NULL,
  `Reason` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetdiscard_detail`
--

LOCK TABLES `assetdiscard_detail` WRITE;
/*!40000 ALTER TABLE `assetdiscard_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetdiscard_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetmove`
--

DROP TABLE IF EXISTS `assetmove`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetmove` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(255) DEFAULT NULL,
  `AssetType` varchar(50) DEFAULT NULL,
  `MoveDate` varchar(10) DEFAULT NULL,
  `SrcAssetDept` varchar(50) DEFAULT NULL,
  `SrcKeeper` varchar(50) DEFAULT NULL,
  `NewAssetDept` varchar(50) DEFAULT NULL,
  `NewKeeper` varchar(50) DEFAULT NULL,
  `Reason` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetmove`
--

LOCK TABLES `assetmove` WRITE;
/*!40000 ALTER TABLE `assetmove` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetmove` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetmove_detail`
--

DROP TABLE IF EXISTS `assetmove_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetmove_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `AssetNo` varchar(50) DEFAULT NULL,
  `AssetDate` varchar(10) DEFAULT NULL,
  `Place` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `CategoryCode` varchar(50) DEFAULT NULL,
  `CodeSeries` varchar(10) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `CanUseYear` int(11) DEFAULT NULL,
  `Depreciation` varchar(50) DEFAULT NULL,
  `Term` int(11) DEFAULT NULL,
  `ScrapValue` int(11) DEFAULT NULL,
  `Source` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `Unit` varchar(20) DEFAULT NULL,
  `UnitPrice` int(11) DEFAULT NULL,
  `DocUrl` varchar(50) DEFAULT NULL,
  `UsedYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetmove_detail`
--

LOCK TABLES `assetmove_detail` WRITE;
/*!40000 ALTER TABLE `assetmove_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetmove_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assets` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `AssetDate` varchar(10) DEFAULT NULL,
  `AssetDept` varchar(50) DEFAULT NULL,
  `Keeper` varchar(50) DEFAULT NULL,
  `Place` varchar(50) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `AssetType` varchar(50) DEFAULT NULL,
  `CategoryCode` varchar(50) DEFAULT NULL,
  `CodeSeries` varchar(10) DEFAULT NULL,
  `Unit` varchar(20) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `UnitPrice` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `DepreciationAmount` int(11) DEFAULT NULL,
  `NetAmount` int(11) DEFAULT NULL,
  `Depreciation` varchar(50) DEFAULT NULL,
  `Term` int(11) DEFAULT NULL,
  `ScrapValue` int(11) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `CanUseYear` int(11) DEFAULT NULL,
  `Source` varchar(50) DEFAULT NULL,
  `AssetStatus` varchar(50) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attorney`
--

DROP TABLE IF EXISTS `attorney`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attorney` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `Firm` varchar(100) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `Account` varchar(50) DEFAULT NULL,
  `AccountName` varchar(50) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Tel1` varchar(50) DEFAULT NULL,
  `Tel2` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax1` varchar(50) DEFAULT NULL,
  `Fax2` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `Address1` varchar(200) DEFAULT NULL,
  `EnglishAddress1` varchar(200) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `EnglishAddress2` varchar(200) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `IdNo` varchar(20) DEFAULT NULL,
  `AttUrl` varchar(200) DEFAULT NULL,
  `BankAddress` varchar(200) DEFAULT NULL,
  `SwiftCode` varchar(100) DEFAULT NULL,
  `RountingNo` varchar(100) DEFAULT NULL,
  `IbanNo` varchar(100) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `EnglishFirmName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attorney`
--

LOCK TABLES `attorney` WRITE;
/*!40000 ALTER TABLE `attorney` DISABLE KEYS */;
/*!40000 ALTER TABLE `attorney` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attorney_2`
--

DROP TABLE IF EXISTS `attorney_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attorney_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `Firm` varchar(100) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `Account` varchar(50) DEFAULT NULL,
  `AccountName` varchar(50) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Tel1` varchar(50) DEFAULT NULL,
  `Tel2` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax1` varchar(50) DEFAULT NULL,
  `Fax2` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `Address1` varchar(200) DEFAULT NULL,
  `EnglishAddress1` varchar(200) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `EnglishAddress2` varchar(200) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `IdNo` varchar(20) DEFAULT NULL,
  `AttUrl` varchar(200) DEFAULT NULL,
  `BankAddress` varchar(200) DEFAULT NULL,
  `SwiftCode` varchar(100) DEFAULT NULL,
  `RountingNo` varchar(100) DEFAULT NULL,
  `IbanNo` varchar(100) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `EnglishFirmName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attorney_2`
--

LOCK TABLES `attorney_2` WRITE;
/*!40000 ALTER TABLE `attorney_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `attorney_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `AuthorityType` varchar(20) NOT NULL,
  `KeyValue` varchar(50) NOT NULL,
  `ProgramId` varchar(50) NOT NULL,
  `DisplayMenu` char(1) DEFAULT NULL,
  `CanControlField` char(1) DEFAULT NULL,
  `AllowQuery` char(1) DEFAULT NULL,
  `AllowInsert` char(1) DEFAULT NULL,
  `AllowUpdate` char(1) DEFAULT NULL,
  `AllowDelete` char(1) DEFAULT NULL,
  `AllowPrint` char(1) DEFAULT NULL,
  `JobType` varchar(50) DEFAULT NULL,
  `CanUse` char(1) DEFAULT NULL,
  `QueryAuthority` char(1) DEFAULT NULL,
  `UpdateAuthority` char(1) DEFAULT NULL,
  `DeleteAuthority` char(1) DEFAULT NULL,
  `OpenMenu` char(1) DEFAULT NULL,
  PRIMARY KEY (`AuthorityType`,`KeyValue`,`ProgramId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES ('Department','99','ap.menu.case','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.01','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.02','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.04','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.05','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.06','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.case.09','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.sys','1','','','','','','','','','S','S','S',NULL),('Department','99','ap.menu.sys.config','1','','','','','','','','','S','S','S',NULL),('Department','99','jsp.Applicant','','','1','1','1','1','','','','D','D','D',NULL),('Department','99','jsp.Attorney','','','1','1','1','1','','','','D','D','D',NULL),('Department','99','jsp.Client','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.DocumentManage','','','1','1','1','1','','','','D','D','D',NULL),('Department','99','jsp.Invoice','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.InvTitle','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.LegalCase','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.Opponent','','','1','1','1','1','','','','D','D','D',NULL),('Department','99','jsp.PayManage','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.Payment','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.Quotation','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.ReceiptManage','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.SalesOrder','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.ServiceProject','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.StandardQuo','','','1','1','1','1','1','','','S','S','S',NULL),('Department','99','jsp.StatisticalChart','','','1','1','1','1','1','','','D','D','D',NULL),('Department','99','jsp.ToDosQuery','','','1','1','','','','','','D','S','S',NULL),('Employee','admin','ap.menu.case','1','','','','','','','','','S','S','S',''),('Employee','admin','ap.menu.case.01','1','','','','','','','','','S','S','S',''),('Employee','admin','ap.menu.sys','1','','','','','','','','','S','S','S',NULL),('Employee','admin','ap.menu.sys.config','1','','','','','','','','','S','S','S',NULL),('Employee','admin','jsp.SystemConfig','','','1','1','1','1','1','','','S','S','S',NULL),('Groups','admin','a10.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','a20.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','a90.menu','1','Y','','','','','','','','A','A','A','1'),('Groups','admin','a91.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.Assets.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.Budjet.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flow.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flow.menu.basic','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flowForm.menu','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flowForm.menu.10','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flowForm.menu.20','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.flowForm.menu.30','1','Y','','','','','','','','A','A','A',''),('Groups','admin','ap.menu.budget','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.budget.02','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.01','1','','','','','','','','','S','S','S',NULL),('Groups','admin','ap.menu.case.02','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.03','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.04','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.04-1','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.05','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.06','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.07','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.08','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.09','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.case.10','1','','','','','','','','','S','S','S',NULL),('Groups','admin','ap.menu.personal','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys.basic','1','','','','','','','','','S','S','S',''),('Groups','admin','ap.menu.sys.config','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys.flow','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys.log','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys.main','1','','','','','','','','','','','',''),('Groups','admin','ap.menu.sys.org','1','','','','','','','','','','','',''),('Groups','admin','jsp.Account','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.AgreementManage','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Applicant','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.Attorney','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.Authority','','','','','1','','','','','S','A','S',''),('Groups','admin','jsp.BankAccountManagement','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Category','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.changePwd','','','','','1','','','','','S','A','S',''),('Groups','admin','jsp.ChartDefine','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Client','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.CommissionedCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Contract','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.CopyrightCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Department','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.DocumentManage','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Employee','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.FeeSchedule','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.FileManage','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.Groups','','','1','1','1','1','','','Y','A','A','A',''),('Groups','admin','jsp.Guaranty','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.HourlyCharge','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.InterConfQuery','','','1','','','','','','','S','S','S',NULL),('Groups','admin','jsp.Inventors','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.Invoice','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.InvoiceDetail','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.InvTitle','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.Job','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.JobAgent','','','1','1','1','1','','J99','Y','A','A','A',''),('Groups','admin','jsp.JobType','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.LegalCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.LogInfo','','','1','','','1','','','','A','A','A',''),('Groups','admin','jsp.MailLog','','','1','','','1','','','','A','S','A',''),('Groups','admin','jsp.MailManager','','','','','1','','','','','S','A','S',''),('Groups','admin','jsp.MailThreadConfig','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.MiscFee','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.MyFavor','','','1','1','1','1','','','','S','S','S',''),('Groups','admin','jsp.Notice','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.Opponent','','','1','1','1','1','','','','A','A','A',NULL),('Groups','admin','jsp.PatentCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.PatentCaseInternal','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.PatentMatterConfig','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.PayChargeMamage','','','1','','','','1','','','A','S','S',''),('Groups','admin','jsp.PayManage','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Payment','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.PerformanceMonthReport','','','1','','','','','','','S','S','S',''),('Groups','admin','jsp.Phrase','','','1','1','1','1','','','','S','S','S',''),('Groups','admin','jsp.Program','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.Quotation','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.ReceiptManage','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Receivable','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.RenewalLog','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.Report','','','1','','','','','','','A','S','S',NULL),('Groups','admin','jsp.ReportDefine','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.ReportTableSetting','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.RequestPayment','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.SalesOrder','','','1','1','1','1','1','','','A','A','S',''),('Groups','admin','jsp.ScheduleManager','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.ServiceProject','','','1','1','1','1','1','','Y','A','A','A',''),('Groups','admin','jsp.SignedManage','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.Sponsor','','','1','1','1','1','','J99','Y','A','A','A',''),('Groups','admin','jsp.StandardQuo','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.StandardTask','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.StatisticalChart','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.SystemConfig','','','1','1','1','1','1','','','A','A','A',NULL),('Groups','admin','jsp.SystemLogo','','','1','1','1','','','','','A','A','S',''),('Groups','admin','jsp.TimesheetManagement','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.TimesheetManagementReport','','','1','','','','','','','A','S','S',''),('Groups','admin','jsp.TimesheetPayManagement','','','1','','','','1','','','A','S','S',''),('Groups','admin','jsp.ToDosAssign','','','1','','','','','','','S','S','S',NULL),('Groups','admin','jsp.ToDosQuery','','','1','1','','','','','','A','S','S',''),('Groups','admin','jsp.TrademarkCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.TrademarkExtend','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.TrademarkFeeSchedule','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.TrademarkMonitorManage','','','1','','','','','','','S','S','S',NULL),('Groups','admin','jsp.TrademarkRenewalLog','','','1','1','1','1','1','','','A','A','A',''),('Groups','admin','jsp.UploadFiles','','','1','1','1','1','','','','A','A','A',''),('Groups','admin','jsp.WeekReportList','','','1','','','','','','','S','S','S',''),('Groups','admin','jsp.WorkPlan','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','a10.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','a20.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','a90.menu','1','Y','','','','','','','','A','A','A','1'),('Groups','G01','a91.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.Assets.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.Budjet.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flow.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flow.menu.basic','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flowForm.menu','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flowForm.menu.10','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flowForm.menu.20','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.flowForm.menu.30','1','Y','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.budget','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.budget.02','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.01','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.02','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.03','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.04','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.04-1','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.05','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.06','1','','','','','','','','','A','A','A',NULL),('Groups','G01','ap.menu.case.07','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.08','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.case.09','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.sys','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.sys.basic','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.sys.flow','1','','','','','','','','','A','A','A',''),('Groups','G01','ap.menu.sys.log','1','','','','','','','','','A','A','A',NULL),('Groups','G01','ap.menu.sys.main','1','','','','','','','','','A','A','A',NULL),('Groups','G01','ap.menu.sys.org','1','','','','','','','','','A','A','A',NULL),('Groups','G01','jsp.AgreementManage','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.Applicant','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.Attorney','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.Category','','','1','1','1','','','','','A','A','A',NULL),('Groups','G01','jsp.Client','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.CommissionedCase','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.Contract','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.DocumentManage','','','1','','','','','','','A','A','A',''),('Groups','G01','jsp.FeeSchedule','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.HourlyCharge','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Inventors','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.Invoice','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.InvoiceDetail','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.InvTitle','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Job','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.JobAgent','','','1','1','1','1','','J99','Y','A','A','A',''),('Groups','G01','jsp.JobType','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.LegalCase','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.MiscFee','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Notice','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Opponent','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.PatentCase','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.PatentCaseInternal','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.PatentMatterConfig','','','1','1','1','1','','','Y','A','A','A',''),('Groups','G01','jsp.PayManage','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Payment','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Quotation','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.ReceiptManage','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.Receivable','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.RenewalLog','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.ReportDefine','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.RequestPayment','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.SalesOrder','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.ServiceProject','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.Sponsor','','','1','1','1','1','','J99','Y','A','A','A',''),('Groups','G01','jsp.StandardQuo','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.StandardTask','','','1','1','1','1','','','Y','A','A','A',''),('Groups','G01','jsp.StatisticalChart','','','1','','','','','','','A','A','A',NULL),('Groups','G01','jsp.TimesheetManagement','','','1','1','1','1','','','','A','A','A',NULL),('Groups','G01','jsp.TimesheetPayManagement','','','1','','','','','','','A','A','A',NULL),('Groups','G01','jsp.ToDosAssign','','','1','','','','','','','A','A','A',NULL),('Groups','G01','jsp.ToDosQuery','','','1','','','','','','','A','A','A',''),('Groups','G01','jsp.TrademarkCase','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.TrademarkExtend','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.TrademarkFeeSchedule','','','1','1','1','1','1','','','A','A','A',''),('Groups','G01','jsp.TrademarkRenewalLog','','','1','1','1','1','','','','A','A','A',''),('Groups','G01','jsp.WeekReportList','','','1','','','','','','','A','A','A',''),('Groups','G01','jsp.WorkPlan','','','1','1','1','1','','','','A','A','A','');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankaccountmanagement`
--

DROP TABLE IF EXISTS `bankaccountmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankaccountmanagement` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `BranchBankName` varchar(50) NOT NULL,
  `BankName` varchar(50) NOT NULL,
  `BankId` varchar(50) DEFAULT NULL,
  `AccountId` varchar(50) NOT NULL,
  `AccountName` varchar(50) NOT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `SwiftCode` varchar(50) DEFAULT NULL,
  `BankAddress1` varchar(100) DEFAULT NULL,
  `Balance` float(16,2) DEFAULT '0.00',
  `Notes` varchar(200) DEFAULT NULL,
  `ContactPerson` varchar(50) DEFAULT NULL,
  `BankTel` varchar(50) DEFAULT NULL,
  `CreateDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccountmanagement`
--

LOCK TABLES `bankaccountmanagement` WRITE;
/*!40000 ALTER TABLE `bankaccountmanagement` DISABLE KEYS */;
/*!40000 ALTER TABLE `bankaccountmanagement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `ManufactureDate` varchar(10) DEFAULT NULL,
  `ExpiryDate` varchar(10) DEFAULT NULL,
  `ProductId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billmanage`
--

DROP TABLE IF EXISTS `billmanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billmanage` (
  `AccountName` varchar(20) DEFAULT NULL,
  `AccountPayableDate` varchar(10) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `CostCenter` varchar(50) DEFAULT NULL,
  `InvoiceSummary` varchar(8) DEFAULT NULL,
  `Matter` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `PaymentStatus` varchar(50) DEFAULT NULL,
  `PaymentTerm` varchar(50) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `PayoutDate` varchar(10) DEFAULT NULL,
  `RelatedCaseNo` varchar(50) DEFAULT NULL,
  `RequestDate` varchar(10) DEFAULT NULL,
  `Requester` varchar(10) DEFAULT NULL,
  `Flowkey` varchar(50) NOT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `AccountFullName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Flowkey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billmanage`
--

LOCK TABLES `billmanage` WRITE;
/*!40000 ALTER TABLE `billmanage` DISABLE KEYS */;
/*!40000 ALTER TABLE `billmanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billmanagedetail`
--

DROP TABLE IF EXISTS `billmanagedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billmanagedetail` (
  `Flowkey` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `InvoiceDate` varchar(10) DEFAULT NULL,
  `InvoiceType` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(15) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `InvoiceAmount` varchar(8) DEFAULT NULL,
  `NtdwoTaxAmount` varchar(8) DEFAULT NULL,
  `TaxAmount` varchar(8) DEFAULT NULL,
  `Taxed` varchar(1) DEFAULT NULL,
  `AmountIncludeTax` varchar(8) DEFAULT NULL,
  `AttorneyIncomeTax` varchar(1) DEFAULT NULL,
  `TaxAmount2` varchar(8) DEFAULT NULL,
  `ShouldPay` varchar(8) DEFAULT NULL,
  `Paid` varchar(1) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `AccountPayDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Flowkey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billmanagedetail`
--

LOCK TABLES `billmanagedetail` WRITE;
/*!40000 ALTER TABLE `billmanagedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `billmanagedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `GroupFlag` char(1) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `DeptSigner1` varchar(50) DEFAULT NULL,
  `DeptSigner2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowadjust`
--

DROP TABLE IF EXISTS `borrowadjust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrowadjust` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `BorrowDept` varchar(50) DEFAULT NULL,
  `Borrower` varchar(50) DEFAULT NULL,
  `BudgetDept` varchar(50) DEFAULT NULL,
  `SrcFlowKey` varchar(50) DEFAULT NULL,
  `Amount_D` int(11) DEFAULT NULL,
  `Amount_C` int(11) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowadjust`
--

LOCK TABLES `borrowadjust` WRITE;
/*!40000 ALTER TABLE `borrowadjust` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowadjust` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget`
--

DROP TABLE IF EXISTS `budget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `TotalAmount` int(11) DEFAULT NULL,
  `ControlFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget`
--

LOCK TABLES `budget` WRITE;
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_detail`
--

DROP TABLE IF EXISTS `budget_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Jan` int(11) DEFAULT NULL,
  `Feb` int(11) DEFAULT NULL,
  `Mar` int(11) DEFAULT NULL,
  `Apr` int(11) DEFAULT NULL,
  `May` int(11) DEFAULT NULL,
  `Jun` int(11) DEFAULT NULL,
  `Jul` int(11) DEFAULT NULL,
  `Aug` int(11) DEFAULT NULL,
  `Sep` int(11) DEFAULT NULL,
  `Oct` int(11) DEFAULT NULL,
  `Nov` int(11) DEFAULT NULL,
  `Dec` int(11) DEFAULT NULL,
  `TotalAmount` int(11) DEFAULT NULL,
  `ControlFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_detail`
--

LOCK TABLES `budget_detail` WRITE;
/*!40000 ALTER TABLE `budget_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budgetshare`
--

DROP TABLE IF EXISTS `budgetshare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetshare` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `BudgetDate` varchar(10) DEFAULT NULL,
  `Reason` varchar(200) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetshare`
--

LOCK TABLES `budgetshare` WRITE;
/*!40000 ALTER TABLE `budgetshare` DISABLE KEYS */;
/*!40000 ALTER TABLE `budgetshare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budgetshare_detail`
--

DROP TABLE IF EXISTS `budgetshare_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetshare_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `BudgetDept` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetshare_detail`
--

LOCK TABLES `budgetshare_detail` WRITE;
/*!40000 ALTER TABLE `budgetshare_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `budgetshare_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Year` varchar(50) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `Cylinder` varchar(100) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `CarPhoto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrequest`
--

DROP TABLE IF EXISTS `carrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrequest` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyTime` varchar(20) DEFAULT NULL,
  `UseReason` varchar(200) DEFAULT NULL,
  `UseTimeFrom` varchar(20) DEFAULT NULL,
  `UseTimeTo` varchar(20) DEFAULT NULL,
  `Place` varchar(100) DEFAULT NULL,
  `MemberName` varchar(100) DEFAULT NULL,
  `CargoName` varchar(200) DEFAULT NULL,
  `DriverBySelf` char(1) DEFAULT NULL,
  `Driver` varchar(50) DEFAULT NULL,
  `UseCar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrequest`
--

LOCK TABLES `carrequest` WRITE;
/*!40000 ALTER TABLE `carrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartrack`
--

DROP TABLE IF EXISTS `cartrack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartrack` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `UseReason` varchar(200) DEFAULT NULL,
  `Driver` varchar(50) DEFAULT NULL,
  `UseCar` varchar(50) DEFAULT NULL,
  `UseTimeFrom` varchar(20) DEFAULT NULL,
  `UseTimeTo` varchar(20) DEFAULT NULL,
  `Place` varchar(200) DEFAULT NULL,
  `MileageFrom` int(11) DEFAULT NULL,
  `MileageTo` int(11) DEFAULT NULL,
  `Mileage` int(11) DEFAULT NULL,
  `UseGases` int(11) DEFAULT NULL,
  `MileAverage` double DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartrack`
--

LOCK TABLES `cartrack` WRITE;
/*!40000 ALTER TABLE `cartrack` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartrack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caseprivilege`
--

DROP TABLE IF EXISTS `caseprivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caseprivilege` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `EmployeeId` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `DeptId` varchar(50) DEFAULT NULL,
  `DeptName` varchar(50) DEFAULT NULL,
  `Privilege` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `CreateFrom` varchar(50) DEFAULT NULL,
  `CaseKey` varchar(50) DEFAULT NULL,
  `PrivilegeKind` varchar(1) NOT NULL DEFAULT 'E',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caseprivilege`
--

LOCK TABLES `caseprivilege` WRITE;
/*!40000 ALTER TABLE `caseprivilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `caseprivilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `CategoryFlag` char(1) DEFAULT NULL,
  `CategoryGroup` varchar(50) DEFAULT NULL,
  `SubjectId_D` varchar(50) DEFAULT NULL,
  `SubjectId_C` varchar(50) DEFAULT NULL,
  `Helper` varchar(50) DEFAULT NULL,
  `Sponsor` varchar(50) DEFAULT NULL,
  `Controler` varchar(50) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Rate` double DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('99','99','admin','系統維護人員','J99','','Title','','','','','','',1),('AccountingType','99','raychu','帳款種類','','Y','','','','','','','',1),('AccountTitle','99','raychu','科目','','Y','','','','','','','',1),('AccountTitle01','Demo','admin','官費','AccountTitle','','','','','','','','1',1),('AccountTitle01E','Demo','admin','Official Fees','AccountTitleE','','','','','','','','',1),('AccountTitle02','Demo','admin','複代理人服務費','AccountTitle','','','','','','','','2',2),('AccountTitle02E','Demo','admin','Attorney Fees','AccountTitleE','','','','','','','','',1),('AccountTitle03','Demo','admin','本所服務費','AccountTitle','','','','','','','','3',3),('AccountTitle03E','Demo','admin',' Service Fees','AccountTitleE','','','','','','','','',1),('AccountTitle04','99','admin','事務費','AccountTitle','','','','','','','','4',3),('AccountTitleE','Demo','admin','科目英文','','Y','','','','','','','',1),('ACT01','99','raychu','收款','AccountingType','','','','','','','','',1),('ACT02','99','raychu','付款','AccountingType','','','','','','','','',1),('Action','Demo','admin','異動別','','Y','','','','','','','',1),('AD','99','admin','安道爾','PatentOffice','','','','','','','',' Andorra',1),('AE','99','admin','阿聯','PatentOffice','','','','','','','',' United Arab Emirates',1),('AF','99','admin','阿富汗','PatentOffice','','','','','','','',' Afghanistan',1),('AG','99','admin','安地卡','PatentOffice','','','','','','','',' Antigua and Barbuda',1),('AgreementMainType','99','admin','合約大類','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AgreementStatus','99','admin','合約管理狀態','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AgreementSubType','99','admin','合約子類','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AI','99','admin','安圭拉','PatentOffice','','','','','','','',' Anguilla',1),('AL','99','admin','阿爾巴尼亞','PatentOffice','','','','','','','',' Albania',1),('All','99','tony','公告至每一個人','AuthorityType','','','','','','','','',1),('AM','99','admin','亞美尼亞','PatentOffice','','','','','','','',' Armenia',1),('AMMT01','99','admin','合約大類1','AgreementMainType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AMMT02','99','admin','合約大類2','AgreementMainType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AMS01','99','admin','準備','AgreementStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AMS02','99','admin','進行','AgreementStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AMS03','99','admin','暫停','AgreementStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AMS04','99','admin','結束','AgreementStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('AN','99','admin','荷屬安地列斯','PatentOffice','','','','','','','',' NETHERLANDS ANTILLES',1),('An01','99','raychu','第一代理人','AttorneyType','','','','','','','','',1),('An02','99','raychu','第二代理人','AttorneyType','','','','','','','','',1),('An03','99','raychu','第三代理人','AttorneyType','','','','','','','','',1),('AO','99','admin','安哥拉','PatentOffice','','','','','','','',' Angola',1),('AP','99','admin','非洲地區知識產權組織','PatentOffice','','','','','','','',' African Regional Intellectual Property Organization(ARIPO)',1),('ApplicantKind','Demo','admin','聯絡人屬性','','Y','','','','','','','',1),('ApplyRaightSource','99','admin','申請權取得方式 (EP案)','','Y','','','','','','','',1),('AQ','99','admin','南極洲','PatentOffice','','','','','','','',' Antarctica',1),('AR','99','admin','阿根廷','PatentOffice','','','','','','','',' Argentina',1),('ARS01','99','admin','As employer(s)','ApplyRaightSource','Y','','','','','','','',1),('ARS02','99','admin','By an agreement','ApplyRaightSource','Y','','','','','','','',1),('ARS03','99','admin','As successor(s) in title','ApplyRaightSource','Y','','','','','','','',1),('ARStatus','99','raychu','付款狀態','Receivable','Y','','','','','','','',1),('ARStatus01','99','simon','未入帳','ARStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ARStatus02','99','simon','尚有餘款未入帳','ARStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ARStatus03','99','raychu','已入帳','ARStatus','','','','','','','','',1),('AS','99','admin','美屬薩摩亞','PatentOffice','','','','','','','',' American Samoa',1),('AS00','Demo','admin','不需指派','AssignStatus','','','','','','','','',1),('AS01','Demo','admin','待指派','AssignStatus','','','','','','','','',1),('AS02','Demo','admin','指派完成','AssignStatus','','','','','','','','',1),('AssignStatus','Demo','admin','指派狀態','','Y','','','','','','','',1),('AT','99','admin','奧地利','PatentOffice','','','','','','','',' Austria',1),('ATitle01','Demo','admin','XXX專利商標事務所','AttorneyTitle','Y','ATitle01','','','','','','RD20150204.01;RD20130809.07;0001',1),('ATitle02','Demo','admin','ABC智慧資產管理有限公司','AttorneyTitle','Y','','','','','','','InvoiceDoc2;RD20130815.01;',1),('ATitle03','Demo','admin','OOO Intellectual Capital Management Co., Ltd.','AttorneyTitle','Y','','','','','','','InvoiceDoc3;RD20130815.03;',2),('ATitle04','Demo','admin','OOO Patent and Trademark Office','AttorneyTitle','Y','','','','','','','InvoiceDoc5;RD20130628.03;RD20130815.02;RD20150204.01',2),('AttorneyTitle','99','admin','單據抬頭','','Y','','','','','','','',1),('AttorneyType','99','raychu','代理人類別','PatentCase','Y','','','','','','','',1),('AU','99','admin','澳大利亞','PatentOffice','','','','','','','',' Australia',1),('AUD','99','admin','澳幣','Currency','','','','','','','','',28.17),('AuthorityType','99','raychu','公告對象類別','','Y','','','','','','','',1),('AW','99','admin','阿魯巴','PatentOffice','','','','','','','',' Aruba',1),('AZ','99','admin','亞塞拜然','PatentOffice','','','','','','','',' Azerbaijan',1),('BA','99','admin','波士尼亞和黑塞哥維那','PatentOffice','','','','','','','',' Bosnia and Herzegovina',1),('BaseDate','99','raychu','基準日','StandardTask','Y','','','','','','','',1),('BB','99','admin','巴貝多','PatentOffice','','','','','','','',' Barbados',1),('BD','99','admin','孟加拉','PatentOffice','','','','','','','',' Bangladesh',1),('BD01','99','raychu','收發文日','BaseDate','','','','','','','','',1),('BD02','99','raychu','立案日','BaseDate','','','','','','','','',1),('BD03','99','raychu','委外日','BaseDate','','','','','','','','',1),('BD04','99','raychu','申請日','BaseDate','','','','','','','','',1),('BD05','99','raychu','公開日','BaseDate','','','','','','','','',1),('BD06','Demo','admin','法定期限','BaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('BD07','Demo','admin','最早優先權日','BaseDate','','','','','','','','',1),('BD08','Demo','admin','公告日','BaseDate','','','','','','','','',1),('BE','99','admin','比利時','PatentOffice','','','','','','','',' Belgium',1),('BF','99','admin','布吉納法索','PatentOffice','','','','','','','',' Burkina Faso',1),('BG','99','admin','保加利亞','PatentOffice','','','','','','','',' Bulgaria',1),('BH','99','admin','巴林','PatentOffice','','','','','','','',' Bahrain',1),('BI','99','admin','蒲隆地','PatentOffice','','','','','','','',' Burundi',1),('BillSendDoc401','Demo','admin','收據','BillSendDoc4','','','','','','','','',1),('BillSendDoc402','Demo','admin','發票','BillSendDoc4','','','','','','','','',1),('BillSendDoc41','Demo','admin','我方請款LETTER、請款單、我方服務費','','Y','','','','','','','',1),('BillSendDoc4101','Demo','admin','需','BillSendDoc41','','','','','','','','',1),('BillSendDoc4102','Demo','admin','不需','BillSendDoc41','','','','','','','','',1),('BJ','99','admin','貝南','PatentOffice','','','','','','','',' Benin',1),('BM','99','admin','百慕達','PatentOffice','','','','','','','',' Bermuda',1),('BN','99','admin','汶萊','PatentOffice','','','','','','','',' Brunei Darussalam',1),('BO','99','admin','玻利維亞','PatentOffice','','','','','','','',' Bolivia (Plurinational State of)',1),('BonusStatus','99','simon','待辦事項狀態','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('BonusStatus01','99','simon','未發放','BonusStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('BonusStatus02','99','simon','已發放','BonusStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('BonusStatus03','99','simon','其他','BonusStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('BorrowStatus','99','admin','借閱狀態','','Y','','','','','','','',1),('BQ','99','admin','荷蘭加勒比區','PatentOffice','','','','','','','',' Bonaire,Sint Eustatius and Saba',1),('BR','99','admin','巴西','PatentOffice','','','','','','','',' Brazil',1),('BRL','TPSA00','triciachang','巴西雷亞爾','Currency','','','','','','','','',0),('BS','99','admin','巴哈馬','PatentOffice','','','','','','','',' Bahamas',1),('BS01','99','admin','未借出','BorrowStatus','','','','','','','','',1),('BS02','99','admin','已借出','BorrowStatus','','','','','','','','',1),('BS03','99','admin','已借出預訂','BorrowStatus','','','','','','','','',1),('BS04','99','admin','遺失','BorrowStatus','','','','','','','','',1),('BT','99','admin','不丹','PatentOffice','','','','','','','',' Bhutan',1),('BV','99','admin','布威島','PatentOffice','','','','','','','',' Bouvet Island',1),('BW','99','admin','波札那','PatentOffice','','','','','','','',' Botswana',1),('BX','99','admin','比荷盧經濟聯盟','PatentOffice','','','','','','','',' Benelux',1),('BY','99','admin','白俄羅斯','PatentOffice','','','','','','','',' Belarus',1),('BZ','99','admin','貝里斯','PatentOffice','','','','','','','',' Belize',1),('CA','99','admin','加拿大','PatentOffice','','','','','','','',' Canada',1),('CA01','99','simon','國內案','CaseAttribute',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CA02','99','simon','國外案','CaseAttribute',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Ca20130604.03','Essen02','TPAD1','CPC软件','CcSendType','','','','','','','','',1),('Ca20130801.01','TPAD00','ad103','檢索','SubType','','','','','','','','',1),('Ca20140625.01','titanpat','titanpat01','官方郵寄日','BaseDate','','StandardTask','','','','','','',1),('Ca20170104.01','YUSO','YUSO','申請','AccountingType','','AccountTitle','','','','','','',1),('CAD','99','admin','加幣','Currency','','','','','','','','',27.682),('CaseAttribute','99','simon','案件屬性','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Category','99','raychu','類型','PatentCase','Y','','','','','','','',1),('CBD01','Demo','admin','收發文日','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CBD02','Demo','admin','公開日','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CBD03','Demo','admin','申請日','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CBD04','Demo','admin','實際完成日','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CBD05','Demo','admin','實際登記日','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CBD06','Demo','admin','法定期限','CopyrightBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('CC001','99','raychu','潛在客戶','Category','','','','','','','','',1),('CC002','99','raychu','成交客戶','Category','','','','','','','','',1),('CC003','99','raychu','主要客戶','Category','','','','','','','','',1),('CC004','99','raychu','問題客戶','Category','','','','','','','','',1),('CcSendType','99','raychu','副本寄送方式','PatentCase','Y','','','','','','','',1),('CCST01','99','raychu','平信','CcSendType','','','','','','','','',1),('CCST02','99','raychu','限時','CcSendType','','','','','','','','',1),('CCST03','99','raychu','掛號','CcSendType','','','','','','','','',1),('CCST04','99','raychu','雙掛號','CcSendType','','','','','','','','',1),('CCST05','99','raychu','航空','CcSendType','','','','','','','','',1),('CCST06','99','raychu','Fax','CcSendType','','','','','','','','',1),('CCST07','99','raychu','Email','CcSendType','','','','','','','','',1),('CCST08','99','raychu','親送','CcSendType','','','','','','','','',1),('CD','99','admin','民主剛果','PatentOffice','','','','','','','',' CONGO, THE DEMOCRATIC REPUBLIC OF TH',1),('CF','99','admin','中非','PatentOffice','','','','','','','',' Central African Republic',1),('CG','99','admin','剛果','PatentOffice','','','','','','','',' Congo',1),('CH','99','admin','瑞士','PatentOffice','','','','','','','',' Switzerland',1),('ChartType','99','raychu','圖表類別','','Y','','','','','','','',1),('CHF','TPSA00','triciachang','瑞士法郎','Currency','','','','','','','','',34.323),('CI','99','admin','象牙海岸','PatentOffice','','','','','','','',' Côte d\'Ivoire',1),('CitationType','99','simon','引證資料類別','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CK','99','admin','庫克群島','PatentOffice','','','','','','','',' Cook Islands',1),('CL','99','admin','智利','PatentOffice','','','','','','','',' Chile',1),('ClientFunction','99','raychu','客戶資料','','Y','','','','','','','',1),('CLK01','Demo','admin','案件聯絡人','ApplicantKind','','','','','','','','',1),('CLK02','Demo','admin','請款聯絡人','ApplicantKind','','','','','','','','',1),('CLK03','TPAD00','ad103','申請人','ApplicantKind','','','','','','','','',1),('CLK04','TPAD00','ad103','發明人','ApplicantKind','','','','','','','','',1),('CLK05','99','admin','當事人','ApplicantKind','','','','','','','','',1),('CLK06','99','admin','承辦工程師','ApplicantKind','','','','','','','','',1),('CM','99','admin','喀麥隆','PatentOffice','','','','','','','',' Cameroon',1),('CM01','99','admin','申請','CopyrightMatter','','','','','','','','',1),('CM02','99','admin','讓與','CopyrightMatter','','','','','','','','',1),('CM03','99','admin','授權','CopyrightMatter','','','','','','','','',1),('CM04','99','admin','質權登記','CopyrightMatter','','','','','','','','',1),('CM05','99','admin','年費','CopyrightMatter','','','','','','','','',1),('CMainT01','99','admin','著作權登記','CopyrightMainType','','','','','','','','',1),('CMainT02','99','admin','著作權授權','CopyrightMainType','','','','','','','','',1),('CMainT03','99','admin','集成積體電路布圖設計登記','CopyrightMainType','','','','','','','','',1),('CMainT04','99','admin','商品條碼','CopyrightMainType','','','','','','','','',1),('CMainT05','Demo','admin','軟件登記','CopyrightMainType','','','','','','','','',1),('CN','99','admin','中國','PatentOffice','','','','','','','',' People\'s Republic of China',1),('CO','99','admin','哥倫比亞','PatentOffice','','','','','','','',' Colombia',1),('color','99','raychu','圖樣顏色','TrademarkCase','Y','','','','','','','',1),('Color01','99','raychu','墨色','Color','','','','','','','','',1),('Color02','99','raychu','彩色','Color','','','','','','','','',1),('CommissionedStatus','99','simon','委辦案件狀態','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CopyRight','99','admin','著作權案件','','Y','','','','','','','',1),('CopyrightMainType','99','raychu','著作權案件類別','','Y','','','','','','','',1),('CopyrightMatter','99','raychu','著作權案件性質','Matter','Y','','','','','','','',1),('CopyRightStatus','99','admin','著作權狀態','CopyRight','Y','','','','','','','',1),('CopyrightSubType','99','raychu','著作權案件中類','','Y','','','','','','','',1),('CopyRightUnit','99','admin','著作單位','CopyRight','Y','','','','','','','',1),('Court','99','simon','法院','','Y','','',NULL,NULL,NULL,NULL,NULL,1),('Court01','99','simon','司法院職務法庭','Court','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02','99','simon','高等(行政)法院','Court','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-01','99','simon','臺灣高等法院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-02','99','simon','臺北高等行政法院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-03','99','simon','臺中高等行政法院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-04','99','simon','高雄高等行政法院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-05','99','simon','智慧財產法院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-06','99','simon','臺灣高等法院臺中分院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-07','99','simon','臺灣高等法院臺南分院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-08','99','simon','臺灣高等法院高雄分院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-09','99','simon','臺灣高等法院花蓮分院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court02-10','99','simon','臺灣高等法院金門分院','Court02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03','99','simon','地方法院','Court','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-01','99','simon','臺灣臺北地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-02','99','simon','臺灣新北地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-03','99','simon','臺灣士林地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-04','99','simon','臺灣桃園地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-05','99','simon','臺灣新竹地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-06','99','simon','臺灣苗栗地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-07','99','simon','臺灣臺中地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-08','99','simon','臺灣南投地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-09','99','simon','臺灣彰化地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-10','99','simon','臺灣雲林地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-11','99','simon','臺灣嘉義地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-12','99','simon','臺灣臺南地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-13','99','simon','臺灣高雄地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-14','99','simon','臺灣屏東地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-15','99','simon','臺灣臺東地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-16','99','simon','臺灣花蓮地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-17','99','simon','臺灣宜蘭地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-18','99','simon','臺灣基隆地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-19','99','simon','臺灣澎湖地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-20','99','simon','臺灣高雄少年及家事法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-21','99','simon','福建連江地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Court03-22','99','simon','福建金門地方法院','Court03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType','99','simon','庭類','','Y','','',NULL,NULL,NULL,NULL,NULL,1),('CourtType01','99','simon','調解','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType02','99','simon','準備程序','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType03','99','simon','調查','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType04','99','simon','訊問','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType05','99','simon','審理','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CourtType06','99','simon','宣判','CourtType','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('CovEntity','99','admin','政府機關','','Y','','','','','','','',1),('CovEntity01','99','admin','智財局','CovEntity','','','','','','','','',1),('CovEntity02','99','admin','經濟部','CovEntity','','','','','','','','',1),('CR','99','admin','克羅埃西亞','PatentOffice','','','','','','','',' Costa Rica',1),('CRS01','99','admin','撰稿','CopyRightStatus','','','','','','','','',1),('CRS02','99','admin','客戶看稿','CopyRightStatus','','','','','','','','',1),('CRS03','99','admin','準備送件','CopyRightStatus','','','','','','','','',1),('CRS04','99','admin','審查中','CopyRightStatus','','','','','','','','',1),('CRS05','99','admin','答辯中','CopyRightStatus','','','','','','','','',1),('CRS05.1','TPAD00','ad103','答辯中-撰稿','CopyRightStatus','','','','','','','','',1),('CRS06','99','admin','已領證','CopyRightStatus','','','','','','','','',1),('CRS07','99','admin','結案','CopyRightStatus','','','','','','','','',1),('CRS08','99','admin','等待','CopyRightStatus','','','','','','','','',1),('CRS09','99','admin','暫停','CopyRightStatus','','','','','','','','',1),('CRU01','99','admin','光碟','CopyRightUnit','','','','','','','','',1),('CRU02','99','admin','A4','CopyRightUnit','','','','','','','','',1),('CRU03','99','admin','A3','CopyRightUnit','','','','','','','','',1),('CRU04','99','admin','冊','CopyRightUnit','','','','','','','','',1),('CRU05','99','admin','首','CopyRightUnit','','','','','','','','',1),('CRU06','99','admin','件','CopyRightUnit','','','','','','','','',1),('CSubT01','99','admin','語文','CopyrightSubType','','','','','','','','',1),('CSubT02','99','admin','音樂','CopyrightSubType','','','','','','','','',1),('CSubT03','99','admin','戲劇、舞蹈','CopyrightSubType','','','','','','','','',1),('CSubT04','99','admin','美術','CopyrightSubType','','','','','','','','',1),('CSubT05','99','admin','攝影','CopyrightSubType','','','','','','','','',1),('CSubT06','99','admin','圖形','CopyrightSubType','','','','','','','','',1),('CSubT07','99','admin','視聽','CopyrightSubType','','','','','','','','',1),('CSubT08','99','admin','錄音','CopyrightSubType','','','','','','','','',1),('CSubT09','99','admin','建築','CopyrightSubType','','','','','','','','',1),('CSubT10','99','admin','電腦程式','CopyrightSubType','','','','','','','','',1),('CSubT11','99','admin','商品條碼','CopyrightSubType','','','','','','','','',1),('CU','99','admin','古巴','PatentOffice','','','','','','','',' Cuba',1),('Currency','99','raychu','幣別','PatentCase','Y','','','','','','','',1),('CV','99','admin','維德角','PatentOffice','','','','','','','',' Cape Verde',1),('CW','99','admin','庫拉索','PatentOffice','','','','','','','',' Curaçao',1),('CY','99','admin','賽普勒斯','PatentOffice','','','','','','','',' Cyprus',1),('CZ','99','admin','捷克','PatentOffice','','','','','','','',' Czech Republic',1),('D01','99','tony','第一職等','Salary_Point','','','','','','','','',1),('D02','99','tony','第二職等','Salary_Point','','','','','','','','',1),('D03','99','tony','第三職等','Salary_Point','','','','','','','','',1),('D04','99','tony','第四職等','Salary_Point','','','','','','','','',1),('D05','99','tony','第五職等','Salary_Point','','','','','','','','',1),('D06','99','tony','第六職等','Salary_Point','','','','','','','','',1),('D07','99','tony','第七職等','Salary_Point','','','','','','','','',1),('D08','99','tony','第八職等','Salary_Point','','','','','','','','',1),('D09','99','tony','第九職等','Salary_Point','','','','','','','','',1),('DE','99','admin','德國','PatentOffice','','','','','','','',' Germany',1),('delete','Demo','admin','delete','Action','','','','','','','','',1),('Department','99','tony','公告至部門','AuthorityType','','','','','','','','',1),('DJ','99','admin','吉布地','PatentOffice','','','','','','','',' Djibouti',1),('DK','99','admin','丹麥','PatentOffice','','','','','','','',' Denmark',1),('DK01','99','raychu','收文','DocumentKind','','','','','','','','',1),('DK02','99','raychu','發文','DocumentKind','','','','','','','','',1),('DK03','99','raychu','內部文件歸檔','DocumentKind','','','','','','','','',1),('DK04','99','raychu','外部文件歸檔','DocumentKind','','','','','','','','',1),('DM','99','admin','多米尼克','PatentOffice','','','','','','','',' Dominica',1),('DO','99','admin','多明尼加','PatentOffice','','','','','','','',' Dominican Republic',1),('Doc1-C01','Demo','admin','OO專利商標事務所','InvoiceDoc1','','','','','','','','',1),('Doc1-C02','Demo','admin','OO Patent And Trademark Office','InvoiceDoc1','','','','','','','','',1),('Doc1-C03','Demo','admin','OO市O區O路O段O號O樓','InvoiceDoc1','','','','','','','','',1),('Doc1-C04','Demo','admin','OF, No.OO, Sec O, OOOO Rd., Da\'an Dist., Taipei City, 106, Taiwan','InvoiceDoc1','','','','','','','','',1),('Doc1-C05','Demo','admin','TEL: 886-x-xxxxxxxx FAX：886-x-xxxxxxx','InvoiceDoc1','','','','','','','','',1),('Doc1-C06','Demo','admin','戶名：OO專利商標事務所','InvoiceDoc1','','','','','','','','',1),('Doc1-C07','Demo','admin','銀行：合作金庫-OO分行','InvoiceDoc1','','','','','','','','',1),('Doc1-C08','Demo','admin','銀行代碼：006','InvoiceDoc1','','','','','','','','',1),('Doc1-C09','Demo','admin','帳號：xxxx-xxx-xxxxxx','InvoiceDoc1','','','','','','','','',1),('Doc2-C01','Demo','admin','OO智慧資產管理有限公司','InvoiceDoc2','','','','','','','','',1),('Doc2-C02','Demo','admin','OO Intellectual Capital Management Co., Ltd.','InvoiceDoc2','','','','','','','','',1),('Doc2-C03','Demo','admin','OO市O區O路O段O號O樓','InvoiceDoc2','','','','','','','','',1),('Doc2-C04','Demo','admin','OOF, No.O, Sec O, OOOO Rd., Da\'an Dist., Taipei City, 106, Taiwan','InvoiceDoc2','','','','','','','','',1),('Doc2-C05','Demo','admin','TEL: 886-x-xxxxxxx FAX：886-x-xxxxxxxx','InvoiceDoc2','','','','','','','','',1),('Doc2-C06','Demo','admin','戶名：OO智慧資產管理有限公司','InvoiceDoc2','','','','','','','','',1),('Doc2-C07','Demo','admin','銀行：合作金庫-xx分行','InvoiceDoc2','','','','','','','','',1),('Doc2-C08','Demo','admin','銀行代碼：006','InvoiceDoc2','','','','','','','','',1),('Doc2-C09','Demo','admin','帳號：xxxx-xxx-xxxxxx','InvoiceDoc2','','','','','','','','',1),('Doc3-C01','Demo','admin','OOO Intellectual Capital Management Co., Ltd.','InvoiceDoc3','','','','','','','','',1),('Doc3-C02','Demo','admin','','InvoiceDoc3','','','','','','','','',1),('Doc3-C03','Demo','admin','OOXXXOOXXXX','InvoiceDoc3','','','','','','','','',1),('Doc3-C04','Demo','admin','','InvoiceDoc3','','','','','','','','',1),('Doc3-C05','Demo','admin','','InvoiceDoc3','','','','','','','','',1),('Doc3-C06','Demo','admin','Beneficiary Account Name:OOO Intellectual Capital Management Co., Ltd.','InvoiceDoc3','','','','','','','','',1),('Doc3-C07','Demo','admin','Bank Code/Branch Code:xxx/xxx','InvoiceDoc3','','','','','','','','',1),('Doc3-C08','Demo','admin','Account No.: xxx-x-xxxxxx-x','InvoiceDoc3','','','','','','','','',1),('Doc3-C09','Demo','admin','Beneficiary Bank:Standard Chartered Bank(HK) Limited','InvoiceDoc3','','','','','','','','',1),('Doc3-C10','Demo','admin','Swift Code:xxxxxxxxx','InvoiceDoc3','','','','','','','','',1),('Doc3-C11','Demo','admin','New York Correspondent Bank:Standard Chartered Bank New York','InvoiceDoc3','','','','','','','','',1),('Doc3-C12','Demo','admin','Swift Code: xxxxxxxx','InvoiceDoc3','','','','','','','','',1),('Doc4-C01','Demo','admin','OOO Intellectual Capital Management Co., Ltd.','InvoiceDoc4','','','','','','','','',1),('Doc4-C02','Demo','admin','','InvoiceDoc4','','','','','','','','',1),('Doc4-C03','Demo','admin','OOXXXOOXXXX','InvoiceDoc4','','','','','','','','',1),('Doc4-C04','Demo','admin','','InvoiceDoc4','','','','','','','','',1),('Doc4-C05','Demo','admin','','InvoiceDoc4','','','','','','','','',1),('Doc5-C01','Demo','admin','OOOO PATENT AND TRADEMARK OFFICE','InvoiceDoc5','','','','','','','','',1),('Doc5-C02','Demo','admin','','InvoiceDoc5','','','','','','','','',1),('Doc5-C03','Demo','admin','OOF, No.OO, Sec OO, OOO Rd., Da\'an Dist., Taipei City, 106, Taiwan','InvoiceDoc5','','','','','','','','',1),('Doc5-C04','Demo','admin','Tel: 886-x-xxxx-xxxx  Fax: 886-x-xxxx-xxxx','InvoiceDoc5','','','','','','','','',1),('Doc5-C05','Demo','admin','','InvoiceDoc5','','','','','','','','',1),('Doc5-C06','Demo','admin','Beneficiary Account Name: OO PATENT AND TRADEMARK OFFICE','InvoiceDoc5','','','','','','','','',1),('Doc5-C07','Demo','admin','Beneficiary Account No.: xxxx-xxx-xxxxxx','InvoiceDoc5','','','','','','','','',1),('Doc5-C08','Demo','admin','Bank Name :TAIWAN COOPERATIVE BANK Ta-An BRANCH','InvoiceDoc5','','','','','','','','',1),('Doc5-C09','Demo','admin','Swift Code: xxxxxxxxx','InvoiceDoc5','','','','','','','','',1),('Doc5-C10','Demo','admin','','InvoiceDoc5','','','','','','','','',1),('Doc5-C11','Demo','admin','','InvoiceDoc5','','','','','','','','',1),('Doc5-C12','Demo','admin','','InvoiceDoc5','','','','','','','','',1),('Doc6-C01','Demo','admin','OO專利商標事務所','InvoiceDoc6','','','','','','','','',1),('Doc6-C02','Demo','admin','OO Patent And Trademark Office','InvoiceDoc6','','','','','','','','',1),('Doc6-C03','Demo','admin','OO市O路O段O號O樓','InvoiceDoc6','','','','','','','','',1),('Doc6-C04','Demo','admin','OOF, No.OO, Sec O, OOOOO Rd., Da\'an Dist., Taipei City, 106, Taiwan','InvoiceDoc6','','','','','','','','',1),('Doc6-C05','Demo','admin','TEL: 886-x-xxxxxxxx FAX: 886-x-xxxxxxxx','InvoiceDoc6','','','','','','','','',1),('Doc6-C06','Demo','admin','戶名：OO專利商標事務所','InvoiceDoc6','','','','','','','','',1),('Doc6-C07','Demo','admin','銀行：合作金庫-OO分行','InvoiceDoc6','','','','','','','','',1),('Doc6-C08','Demo','admin','銀行代碼：006','InvoiceDoc6','','','','','','','','',1),('Doc6-C09','Demo','admin','帳號：xxxx-xxx-xxxxxx','InvoiceDoc6','','','','','','','','',1),('Doc7-C01','Demo','admin','XXX','InvoiceDoc7','','','','','','','','',1),('Doc7-C02','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('Doc7-C03','Demo','admin','XXX','InvoiceDoc7','','','','','','','','',1),('Doc7-C04','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('Doc7-C05','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('Doc7-C06','Demo','admin','Beneficiary Account Name: xxxxxxxxx','InvoiceDoc7','','','','','','','','',1),('Doc7-C07','Demo','admin','Beneficiary Account No.: xxxx-xxx-xxxxx-x','InvoiceDoc7','','','','','','','','',1),('Doc7-C08','Demo','admin','Beneficiary Bank: Taiwan Cooperative Bank, Hong Kong Branch ','InvoiceDoc7','','','','','','','','',1),('Doc7-C09','Demo','admin','Swift Code: xxxxxxxxx','InvoiceDoc7','','','','','','','','',1),('Doc7-C10','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('Doc7-C11','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('Doc7-C12','Demo','admin','　','InvoiceDoc7','','','','','','','','',1),('DocTarget01','99','raychu','智慧局/知识产权局 ','DocumentTarget','','','','','','','','',1),('DocTarget02','99','raychu','經濟部','DocumentTarget','','','','','','','','',1),('DocTarget03','99','raychu','行政法院(律師)','DocumentTarget','','','','','','','','',1),('DocTarget04','99','raychu','著作權委員會/版权局','DocumentTarget','','','','','','','','',1),('DocTarget05','TPAD00','ad103','商標局','DocumentTarget','','','','','','','','',1),('Document','99','raychu','收發文','','Y','','','','','','','',1),('DocumentKind','99','raychu','文件類型','Document','Y','','','','','','','',1),('DocumentTarget','99','raychu','收發文對象','Document','Y','','','','','','','',1),('DocumentType','99','tony','文件類別','PatentCase','Y','','','','','','','',1),('DocumentUnit','99','simon','發文單位','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('DraftStatus','99','tony','提案狀態','','Y','','','','','','','',1),('DS01','99','tony','提案填寫中','DraftStatus','','','','','','','','',1),('DS02','99','tony','IP部門作業中','DraftStatus','','','','','','','','',1),('DS03','99','tony','技術審查中','DraftStatus','','','','','','','','',1),('DS04','99','tony','退回修改','DraftStatus','','','','','','','','',1),('DS05','99','tony','暫緩申請','DraftStatus','','','','','','','','',1),('DS06','99','tony','准予申請','DraftStatus','','','','','','','','',1),('DS07','99','tony','駁回申請','DraftStatus','','','','','','','','',1),('DS08','99','tony','撤銷提案','DraftStatus','','','','','','','','',1),('DT01','99','tony','原始圖稿','DocumentType','','','','','','','','',1),('DT02','99','raychu','委任書','DocumentType','','','','','','','','',1),('DT03','99','raychu','專利Claim初稿','DocumentType','','','','','','','','',1),('DT04','99','raychu','說明書-修正稿','DocumentType','','','','','','','','',1),('DT05','99','raychu','說明書-定稿','DocumentType','','','','','','','','',1),('DT06','99','raychu','通知書','DocumentType','','','','','','','','',1),('DT07','99','raychu','指示書','DocumentType','','','','','','','','',1),('DT08','99','raychu','答辯書','DocumentType','','','','','','','','',1),('DT09','18111','0195','用印-簽章文件','DocumentType','','','','','','','','',1),('DT10','18111','0195','送件版-專利說明書','DocumentType','','','','','','','','',1),('DT11','18111','0195','國外(代理人)信函/通知書','DocumentType','','','','','','','','',1),('DT12','18111','0195','事務所-信函/通知書','DocumentType','','','','','','','','',1),('DT13','18111','0195','智慧財產局-函/通知書','DocumentType','','','','','','','','',1),('DT14','18111','0195','專利-相關文件','DocumentType','','','','','','','','',1),('DT15','18111','0195','發明人資料','DocumentType','','','','','','','','',1),('DT16','18111','0195','繳交年費通知','DocumentType','','','','','','','','',1),('DT17','18111','0195','專利證書','DocumentType','','','','','','','','',1),('DU01','99','simon','政府','DocumentUnit',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('DU02','99','simon','代理人','DocumentUnit',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('DU03','99','simon','客戶','DocumentUnit',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('DZ','99','admin','阿爾及利亞','PatentOffice','','','','','','','',' Algeria',1),('E01','99','raychu','小實體','Entity','','','','','','','','',1),('E02','99','raychu','大實體','Entity','','','','','','','','',1),('E03','Demo','admin','微實體','Entity','','','','','','','','',1),('EA','99','admin','歐亞專利組織（EAPO）','PatentOffice','','','','','','','',' Eurasian Patent Organization(EAPO)',1),('EC','99','admin','厄瓜多','PatentOffice','','','','','','','',' Ecuador',1),('EE','99','admin','愛沙尼亞','PatentOffice','','','','','','','',' Estonia',1),('EG','99','admin','埃及','PatentOffice','','','','','','','',' Egypt',1),('EH','99','admin','西撒哈拉','PatentOffice','','','','','','','',' Western Sahara',1),('EM','99','admin','協調局內部市場（EPO）','PatentOffice','','','','','','','',' Office for Harmonization in the Internal Market (EPO)',1),('Employee','99','tony','公告至個人','AuthorityType','','','','','','','','',1),('EmployeeFunction','99','raychu','員工資料','','Y','','','','','','','',1),('EnableStatus','99','raychu','啟用狀態','StandardTask','Y','','','','','','','',1),('Entity','99','raychu','Entity','PatentCase','Y','','','','','','','',1),('EP','99','admin','歐洲專利局（EPO）','PatentOffice','','','','','','','',' European Patent Office (EPO)',1),('ER','99','admin','厄利垂亞','PatentOffice','','','','','','','',' Eritrea',1),('ES','99','admin','西班牙','PatentOffice','','','','','','','',' Spain',1),('ES01','99','raychu','未啟用','EnableStatus','','','','','','','','',1),('ES02','99','raychu','已啟用','EnableStatus','','','','','','','','',1),('ES03','99','raychu','暫停','EnableStatus','','','','','','','','',1),('ES04','99','raychu','作廢','EnableStatus','','','','','','','','',1),('ET','99','admin','衣索比亞','PatentOffice','','','','','','','',' Ethiopia',1),('EU','99','admin','歐盟智慧財產局EUIPO','PatentOffice','','','','','','','',' European Union',1),('EURO','Demo','admin','歐元','Currency','','','','','','','','',41.918),('FI','99','admin','芬蘭','PatentOffice','','','','','','','',' Finland',1),('FJ','99','admin','斐濟','PatentOffice','','','','','','','',' Fiji',1),('FK','99','admin','福克蘭群島','PatentOffice','','','','','','','',' Falkland Islands (Malvinas)',1),('FO','99','admin','法羅群島','PatentOffice','','','','','','','',' Faroe Islands',1),('FR','99','admin','法國','PatentOffice','','','','','','','',' France',1),('GA','99','admin','加彭','PatentOffice','','','','','','','',' Gabon',1),('GB','99','admin','英國','PatentOffice','','','','','','','',' United Kingdom',1),('GBP','TPAC00','TPAC1','英磅','Currency','','','','','','','','',50.992),('GC','99','admin','在海灣阿拉伯國家合作委員會專利局（GCC）','PatentOffice','','','','','','','',' Patent Office of the Cooperation Council for the Arab States of the Gulf(GCC)',1),('GC01','99','raychu','撤回','GiveupCode','','','','','','','','',1),('GC02','99','raychu','客戶自行繳年費及維護(核准後)','GiveupCode','','','','','','','','',1),('GC03','99','raychu','逾期未領證','GiveupCode','','','','','','','','',1),('GC04','99','raychu','放棄維護專利(不繳年費)','GiveupCode','','','','','','','','',1),('GC05','99','raychu','逾期未繳年費','GiveupCode','','','','','','','','',1),('GC06','99','raychu','被撤銷（舉發）','GiveupCode','','','','','','','','',1),('GC07','TPAD00','ad103','放棄答辯','GiveupCode','','','','','','','','',1),('GC08','TPAD00','ad103','公司已解散','GiveupCode','','','','','','','','',1),('GC09','TPAD00','ad103','放棄請求實審','GiveupCode','','','','','','','','',1),('GC10','TPAD00','ad103','無法聯繫上客戶','GiveupCode','','','','','','','','',1),('GC11','TPAD00','ad103','放棄申請','GiveupCode','','','','','','','','',1),('GC12','TPAD00','ad103','變更代理','GiveupCode','','','','','','','','',1),('GC13','TPAD00','ad103','優先權已屆滿(PCT及臨時案)','GiveupCode','','','','','','','','',1),('GD','99','admin','格瑞那達','PatentOffice','','','','','','','',' Grenada',1),('GE','99','admin','喬治亞','PatentOffice','','','','','','','',' Georgia',1),('GG','99','admin','根息島','PatentOffice','','','','','','','',' Guernsey',1),('GH','99','admin','迦納','PatentOffice','','','','','','','',' Ghana',1),('GI','99','admin','直布羅陀','PatentOffice','','','','','','','',' Gibraltar',1),('GiveupCode','99','tony','專利無效原因','PatentCase','Y','','','','','','','',1),('GL','99','admin','格陵蘭','PatentOffice','','','','','','','',' Greenland',1),('GM','99','admin','甘比亞','PatentOffice','','','','','','','',' Gambia',1),('GN','99','admin','幾內亞','PatentOffice','','','','','','','',' Guinea',1),('GQ','99','admin','赤道幾內亞','PatentOffice','','','','','','','',' Equatorial Guinea',1),('GR','99','admin','希臘','PatentOffice','','','','','','','',' Greece',1),('Groups','99','tony','公告至組群','AuthorityType','','','','','','','','',1),('GS','99','admin','南喬治亞與南三明治群島','PatentOffice','','','','','','','',' South Georgia and the South Sandwich Islands',1),('GT','99','admin','瓜地馬拉','PatentOffice','','','','','','','',' Guatemala',1),('GT01','99','simon','假扣押','GuarantyType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('GT02','99','simon','賠償金','GuarantyType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('GuarantyType','99','admin','保管類別','','Y','','','','','','','',1),('GW','99','admin','幾內亞比索','PatentOffice','','','','','','','',' Guinea-Bissau',1),('GY','99','admin','蓋亞那','PatentOffice','','','','','','','',' Guyana',1),('HK','99','admin','香港','PatentOffice','','','','','','','',' Hong Kong',1),('HKD','99','admin','港幣','Currency','','','','','','','','',3.925),('HN','99','admin','宏都拉斯','PatentOffice','','','','','','','',' Honduras',1),('HR','99','admin','克羅埃西亞','PatentOffice','','','','','','','',' Croatia',1),('HT','99','admin','海地','PatentOffice','','','','','','','',' Haiti',1),('HU','99','admin','匈牙利','PatentOffice','','','','','','','',' Hungary',1),('IB','99','admin','在世界知識產權組織的國際局（WIPO）','PatentOffice','','','','','','','',' International Bureau of the World Intellectual Property Organization(WIPO)',1),('ID','99','admin','印尼','PatentOffice','','','','','','','',' Indonesia',1),('Id01','99','tony','自然人','IdType','','','','','','','','',1),('Id02','99','tony','法人','IdType','','','','','','','','',1),('Identity','99','raychu','身分類別','ClientFunction','Y','','','','','','','',1),('Identity01','99','raychu','自然人','Identity','','','','','','','','',1),('Identity02','99','raychu','法人','Identity','','','','','','','','',1),('IDR','TPSA00','triciachang','印尼盾','Currency','','','','','','','','',0),('IdType','99','tony','身份類別','PatentCase','Y','','','','','','','',1),('IE','99','admin','愛爾蘭','PatentOffice','','','','','','','',' Ireland',1),('IL','99','admin','以色列','PatentOffice','','','','','','','',' Israel',1),('ILS','TPSA00','triciachang','以色列謝克爾','Currency','','','','','','','','',0),('IM','99','admin','曼島','PatentOffice','','','','','','','',' Isle of Man',1),('IN','99','admin','印度','PatentOffice','','','','','','','',' India',1),('Industry','99','simon','行業別','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Industry01','99','simon','行業別1','Industry',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Industry02','99','simon','行業別2','Industry',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('INR','TPSA00','triciachang','盧比','Currency','','','','','','','','',0),('insert','Demo','admin','insert','Action','','','','','','','','',1),('inv001','99','raychu','收據','InvoiceType','','','','','','','','',1),('inv002','99','raychu','發票','InvoiceType','','','','','','','','',1),('inv003','99','raychu','Invoice','InvoiceType','','','','','','','','',1),('InventorType','99','tony','發明人類別','PatentCase','Y','','','','','','','',1),('InvoiceDoc1','Demo','admin','收據-請款單','','Y','','','','','','','UL15035.001',1),('InvoiceDoc2','Demo','admin','發票-請款單','','Y','','','','','','','',1),('InvoiceDoc3','Demo','admin','Invoice-事務所','','Y','','','','','','','',1),('InvoiceDoc4','Demo','admin','Timesheet','','Y','','','','','','','',1),('InvoiceDoc5','Demo','admin','Invoice-公司','','Y','','','','','','','',1),('InvoiceDoc6','TPSA00','triciachang','Invoice','','Y','','','','','','','',1),('InvoiceDoc7','Demo','admin','Invoice-GS','','Y','','','','','','','',1),('InvoiceStatus','99','simon','請款單狀態','','Y','','','','','','','',1),('InvoiceStatus01','99','simon','未請款','InvoiceStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceStatus02','99','simon','請款已出','InvoiceStatus','','','','','','','','',1),('InvoiceStatus03','99','simon','部分收款','InvoiceStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceStatus04','99','admin','收款完成','InvoiceStatus','','','','','','','','',1),('InvoiceStatus05','99','simon','作廢','InvoiceStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceTyep','99','simon','單據類別','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceTyep01','99','simon','單據類別1','InvoiceTyep',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceTyep02','99','simon','單據類別2','InvoiceTyep',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('InvoiceType','99','raychu','收據類別','PatentCase','Y','','','','','','','',1),('IpType','99','raychu','綜合案件種類','Receivable','Y','','','','','','','',1),('IQ','99','admin','伊拉克','PatentOffice','','','','','','','',' Iraq',1),('IR','99','admin','伊朗','PatentOffice','','','','','','','',' Iran (Islamic Republic of)',1),('IS','99','admin','冰島','PatentOffice','','','','','','','',' Iceland',1),('IT','99','admin','義大利','PatentOffice','','','','','','','',' Italy',1),('IT01','99','tony','發明人','InventorType','','','','','','','','',1),('IT02','99','tony','專利權人','InventorType','','','','','','','','',1),('IT03','99','tony','被授權人','InventorType','','','','','','','','',1),('IT04','99','tony','質設人','InventorType','','','','','','','','',1),('IT05','99','tony','被繼承人','InventorType','','','','','','','','',1),('IT06','99','tony','受讓人','InventorType','','','','','','','','',1),('IT07','99','tony','讓與人','InventorType','','','','','','','','',1),('IT08','99','tony','信託','InventorType','','','','','','','','',1),('IT09','99','tony','異議人','InventorType','','','','','','','','',1),('IT10','99','tony','舉發人','InventorType','','','','','','','','',1),('IT11','99','tony','繼承人','InventorType','','','','','','','','',1),('J99','99','tony','系統維護','Title','Y','','','','','','','',1),('JA00','99','tony','所長','JD00','','Title','','','','','','',1),('JA01','99','tony','副所長','JD00','','Title','','','','','','',1),('JA02','99','tony','合夥人','JD00','','Title','','','','','','',1),('JA03','Demo','admin','律師','JD00','','Title','','','','','','',1),('JA04','Demo','admin','業務經理','JD00','','Title','','','','','','',1),('JA05','Demo','admin','專案經理','JD00','','Title','','','','','','',1),('JA06','Demo','admin','專利部經理','JD00','','Title','','','','','','',1),('JA07','Demo','admin','經理','JD00','','Title','','','','','','',1),('JA08','Demo','admin','主任','JD00','','Title','','','','','','',1),('JA09','Demo','admin','會計','JD00','','Title','','','','','','',1),('JA11','Demo','admin','資深專利工程師','JD01','','Title','','','','','','',1),('JA12','Demo','admin','工程師','JD01','','Title','','','','','','',1),('JA13','Demo','admin','程序','JD01','','Title','','','','','','',1),('JA14','Demo','admin','長期工讀生','JD01','','Title','','','','','','',1),('JA15','Demo','admin','業務助理','JD01','','Title','','','','','','',1),('JA16','Demo','admin','外包委案人員','JD01','','Title','','','','','','',1),('JD00','99','tony','管理層','Title','Y','','','','','','','',1),('JD01','99','tony','職員','Title','Y','','','','','','','',1),('JD02','99','tony','技工友','Title','Y','','','','','','','',1),('JD03','99','tony','約聘人員','Title','Y','','','','','','','',1),('JD04','99','tony','外包人員','Title','Y','','','','','','','',1),('JE','99','admin','澤西島','PatentOffice','','','','','','','',' Jersey',1),('JM','99','admin','牙買加','PatentOffice','','','','','','','',' Jamaica',1),('JO','99','admin','約旦','PatentOffice','','','','','','','',' Jordan',1),('JobTitle','99','raychu','群組職務','EmployeeFunction','Y','','','','','','','',1),('Job_Degree','99','raychu','群組別','EmployeeFunction','Y','','','','','','','',1),('JP','99','admin','日本','PatentOffice','','','','','','','',' Japan',1),('JPY','TPSA00','triciachang','日圓','Currency','','','','','','','','',0.2967),('JT01','99','raychu','群組成員','JobTitle','','','','','','','','',1),('J_D01','99','tony','主辦組','Job_Degree','','','','','','','','',1),('J_D02','99','tony','協辦組','Job_Degree','','','','','','','','',1),('J_D03','99','tony','外部人員','Job_Degree','','','','','','','','',1),('KE','99','admin','肯亞','PatentOffice','','','','','','','',' Kenya',1),('KG','99','admin','吉爾吉斯','PatentOffice','','','','','','','',' Kyrgyzstan',1),('KH','99','admin','柬埔寨','PatentOffice','','','','','','','',' Cambodia',1),('KI','99','admin','吉里巴斯','PatentOffice','','','','','','','',' Kiribati',1),('KM','99','admin','葛摩','PatentOffice','','','','','','','',' Comoros',1),('KN','99','admin','聖克里斯多福及尼維斯','PatentOffice','','','','','','','',' Saint Kitts and Nevis',1),('KP','99','admin','北韓','PatentOffice','','','','','','','',' Korea (Democratic People\'s Republic of)',1),('KR','99','admin','韓國','PatentOffice','','','','','','','',' Korea (Republic of)',1),('KRW','TPSA00','triciachang','韓幣','Currency','','','','','','','','',1),('KS','99','admin','科索沃','PatentOffice','','','','','','','',' Republika Kosovo',1),('KW','99','admin','科威特','PatentOffice','','','','','','','',' Kuwait',1),('KY','99','admin','開曼群島 ','PatentOffice','','','','','','','',' Cayman Islands',1),('KZ','99','admin','哈薩克','PatentOffice','','','','','','','',' Kazakhstan',1),('LA','99','admin','寮國','PatentOffice','','','','','','','',' Lao People\'s Democratic Republic',1),('LB','99','admin','黎巴嫩','PatentOffice','','','','','','','',' Lebanon',1),('LBD01','Demo','admin','收發文日','LegalBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('LBD02','Demo','admin','立案日','LegalBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('LBD03','Demo','admin','遞出日期','LegalBaseDate','','','','','','','','',1),('LBD04','Demo','admin','法定期限','LegalBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('LC','99','admin','聖露西亞','PatentOffice','','','','','','','',' Saint Lucia',1),('LCDT01','99','simon','法律文件類別1','LegalDocType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'T',1),('LCDT02','99','simon','法律文件類別2','LegalDocType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TOT',1),('LCS01','Demo','admin','撰稿','LegalCaseStatus','','','','','','','','',1),('LCS02','Demo','admin','客戶看稿','LegalCaseStatus','','','','','','','','',1),('LCS03','Demo','admin','審查中','LegalCaseStatus','','','','','','','','',1),('LCS04','Demo','admin','答辯中','LegalCaseStatus','','','','','','','','',1),('LCS04.1','TPAD00','ad103','答辯中-撰稿','LegalCaseStatus','','','','','','','','',1),('LCS05','Demo','admin','結案','LegalCaseStatus','','','','','','','','',1),('LCS06','Demo','admin','暫停','LegalCaseStatus','','','','','','','','',1),('LegalBaseDate','99','alex','法律案件基準日','LegalCase','Y','','','','','','','',1),('LegalCase','99','raychu','法律案件','','Y','','','','','','','',1),('LegalCaseStatus','99','raychu','法律案件狀態','LegalCase','Y','','','','','','','',1),('LegalDocType','99','raychu','法律文件類別','DocumentType','Y','','','','','','','',1),('LegalMatter','99','raychu','法律案件性質','Matter','Y','','','','','','','',1),('LI','99','admin','列支敦斯登','PatentOffice','','','','','','','',' Liechtenstein',1),('LineChart','99','raychu','折線圖','ChartType','','','','','','','','',1),('LK','99','admin','斯里蘭卡','PatentOffice','','','','','','','',' Sri Lanka',1),('LM01','99','raychu','法律案件性質1','LegalMatter','','','','','','','','',1),('LM02','99','raychu','法律案件性質2','LegalMatter','','','','','','','','',1),('LM03','99','raychu','法律案件性質3','LegalMatter','','','','','','','','',1),('LR','99','admin','賴比瑞亞','PatentOffice','','','','','','','',' Liberia',1),('LS','99','admin','賴索托','PatentOffice','','','','','','','',' Lesotho',1),('LT','99','admin','立陶宛','PatentOffice','','','','','','','',' Lithuania',1),('LU','99','admin','盧森堡','PatentOffice','','','','','','','',' Luxembourg',1),('LV','99','admin','拉脫維亞','PatentOffice','','','','','','','',' Latvia',1),('LY','99','admin','利比亞','PatentOffice','','','','','','','',' Libya',1),('MA','99','admin','摩洛哥','PatentOffice','','','','','','','',' Morocco',1),('MailType','99','simon','郵件類別','','Y','','','','','','','',1),('MainT00','99','admin','其他','MainType','','','','','','','','',1),('MainT01','99','admin','一般民事及執行事件','MainType','','','','','','','','',1),('MainT02','99','admin','買賣','MainType','','','','','','','','',1),('MainT03','99','admin','租賃','MainType','','','','','','','','',1),('MainT04','99','admin','借貸','MainType','','','','','','','','',1),('MainT05','99','admin','承攬','MainType','','','','','','','','',1),('MainT06','99','admin','委任','MainType','','','','','','','','',1),('MainT07','99','admin','委建、合建、設計贏','MainType','','','','','','','','',1),('MainT08','99','admin','保證','MainType','','','','','','','','',1),('MainT09','99','admin','信託','MainType','','','','','','','','',1),('MainT10','99','admin','侵權行為','MainType','','','','','','','','',1),('MainT11','99','admin','不當得利','MainType','','','','','','','','',1),('MainT12','99','admin','無因管理','MainType','','','','','','','','',1),('MainT13','99','admin','其他債權事件','MainType','','','','','','','','',1),('MainT14','99','admin','確認物權存在或不存在','MainType','','','','','','','','',1),('MainT15','99','admin','行使物上請求權','MainType','','','','','','','','',1),('MainT16','99','admin','共有物分割','MainType','','','','','','','','',1),('MainT17','99','admin','其他物權事件','MainType','','','','','','','','',1),('MainT18','99','admin','離婚、婚姻無效','MainType','','','','','','','','',1),('MainT19','99','admin','繼承','MainType','','','','','','','','',1),('MainT20','L','steven','test','MainType','','','','','','','','',1),('MainType','99','raychu','法務案件類別','','Y','','','','','','','',1),('MarkType','99','raychu','商標樣態','TrademarkCase','Y','','','','','','','',1),('Matter','99','raychu','案件性質','PatentCase','Y','','','','','','','',1),('MC','99','admin','摩納哥','PatentOffice','','','','','','','',' Monaco',1),('MD','99','admin','摩爾多瓦','PatentOffice','','','','','','','',' Moldova (Republic of)',1),('ME','99','admin','蒙特內哥羅','PatentOffice','','','','','','','',' Montenegro',1),('MFST01','99','simon','私人','MiscFeesSubType','','','','','','','','',1),('MFST02','99','admin','OF','MiscFeesSubType','','','','','','','','',1),('MFST03','99','admin','當事人','MiscFeesSubType','','','','','','','','',1),('MFST04','99','admin','Pending','MiscFeesSubType','','','','','','','','',1),('MFT01','99','simon','郵費','MiscFeeType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MFT02','99','simon','傳真','MiscFeeType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MFT03','99','simon','影印費','MiscFeeType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MFT04','99','simon','代收代付','MiscFeeType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MG','99','admin','馬達加斯加','PatentOffice','','','','','','','',' Madagascar',1),('MiscFeesSubType','99','simon','事務費使用類別','','Y','','','','','','','',1),('MiscFeeType','99','simon','MiscFeeType','','Y','','','','','','','',1),('MiscStatus','99','admin','事務費狀態','','Y','','','','','','','',1),('MK','99','admin','馬其頓','PatentOffice','','','','','','','',' Macedonia (the former Yugoslav Republic of)',1),('ML','99','admin','馬利','PatentOffice','','','','','','','',' Mali',1),('MM','99','admin','緬甸','PatentOffice','','','','','','','',' Myanmar',1),('MN','99','admin','蒙古','PatentOffice','','','','','','','',' Mongolia',1),('MO','99','admin','澳門','PatentOffice','','','','','','','',' Macao',1),('MP','99','admin','南非北馬里亞納群島','PatentOffice','','','','','','','',' Northern Mariana Islands',1),('MQ','99','admin','法屬馬丁尼克','PatentOffice','','','','','','','',' Martinique',1),('MR','99','admin','茅利塔尼亞','PatentOffice','','','','','','','',' Mauritania',1),('MS','99','admin','蒙塞拉特島','PatentOffice','','','','','','','',' Montserrat',1),('MS00','99','admin','不需請款','MiscStatus','Y','','','','','','','',1),('MS01','99','admin','待請款','MiscStatus','Y','','','','','','','',1),('MS02','99','admin','已請款','MiscStatus','Y','','','','','','','',1),('MT','99','admin','馬耳他','PatentOffice','','','','','','','',' Malta',1),('MT01','99','simon','平信','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MT02','99','simon','限時','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MT03','99','simon','普掛','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MT04','99','simon','限掛','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MT05','99','simon','快遞','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MT06','99','simon','航空','MailType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('MU','99','admin','模里西斯','PatentOffice','','','','','','','',' Mauritius',1),('MV','99','admin','馬爾地夫','PatentOffice','','','','','','','',' Maldives',1),('MW','99','admin','馬拉威','PatentOffice','','','','','','','',' Malawi',1),('MX','99','admin','墨西哥','PatentOffice','','','','','','','',' Mexico',1),('MY','99','admin','馬來西亞','PatentOffice','','','','','','','',' Malaysia',1),('MZ','99','admin','莫三比克','PatentOffice','','','','','','','',' Mozambique',1),('N01','99','raychu','中華民國','Nationality','','','','','','','','',1),('NA','99','admin','通用','PatentOffice','','','','','','','',' Namibia',1),('Nationality','99','tony','國籍','PatentCase','Y','','','','','','','',1),('NE','99','admin','尼日','PatentOffice','','','','','','','',' Niger',1),('NewCase','Demo','admin','新案件','ShowItem','','','','','','','','',1),('NewCase01','Demo','admin','新申請案','NewCase','','','','','','','','',1),('NewCase02','Demo','admin','OA答辯','NewCase','','','','','','','','',1),('NewCase04','Demo','admin','領證及年費','NewCase','','','','','','','','',1),('NewCase05','Demo','admin','其他','NewCase','','','','','','','','',1),('NF','99','admin','諾福克群島','PatentOffice','','','','','','','',' Norfolk Island',1),('NG','99','admin','奈及利亞','PatentOffice','','','','','','','',' Nigeria',1),('NI','99','admin','尼加拉瓜','PatentOffice','','','','','','','',' Nicaragua',1),('NL','99','admin','荷蘭','PatentOffice','','','','','','','',' Netherlands',1),('NO','99','admin','挪威','PatentOffice','','','','','','','',' Norway',1),('NonUS.Pub','99','simon','非美國公開專利','CitationType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('NP','99','admin','尼泊爾','PatentOffice','','','','','','','',' Nepal',1),('NPL','99','simon','非專利文獻','CitationType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('NR','99','admin','諾魯','PatentOffice','','','','','','','',' Nauru',1),('NTD','99','raychu','新台幣','Currency','','','','','','','','',1),('NZ','99','admin','紐西蘭','PatentOffice','','','','','','','',' New Zealand',1),('NZD','TPAD00','55','紐西蘭元','Currency','','','','','','','','',25.977),('OA','99','admin','非洲知識產權組織','PatentOffice','','','','','','','',' African Intellectual Property Organization (OAPI) ',1),('OK01','99','simon','被告','OppoKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('OK02','99','simon','連帶','OppoKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('OK03','99','simon','關係人','OppoKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('OK04','99','simon','合作關係','OppoKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('OldCase','Demo','admin','舊案件','ShowItem','','','','','','','','',1),('OldCase01','Demo','admin','OA答辯','OldCase','','','','','','','','',1),('OldCase02','Demo','admin','領證及年費','OldCase','','','','','','','','',1),('OldCase03','Demo','admin','其他','OldCase','','','','','','','','',1),('OM','99','admin','阿曼','PatentOffice','','','','','','','',' Oman',1),('OppoKind','99','simon','對照屬性','','Y','','','','','','','',1),('OS00','Demo','admin','已立案','SoStatus','','','','','','','','',1),('OS01','Demo','admin','可請款','SoStatus','','','','','','','','',1),('OS02','Demo','admin','已請款','SoStatus','','','','','','','','',1),('OS03','Demo','admin','作廢','SoStatus','','','','','','','','',1),('OT01','99','raychu','公營企業','OwnershipType','','','','','','','','',1),('OT02','99','raychu','私營企業-獨資','OwnershipType','','','','','','','','',1),('OT03','99','raychu','私營企業-合夥','OwnershipType','','','','','','','','',1),('OT04','99','raychu','私營企業-私人有限公司','OwnershipType','','','','','','','','',1),('OT05','99','raychu','私營企業-公眾有限公司','OwnershipType','','','','','','','','',1),('OwnershipType','99','raychu','擁有權','ClientFunction','Y','','','','','','','',1),('PA','99','admin','巴拿馬','PatentOffice','','','','','','','',' Panama',1),('PAK01','99','admin','原始申請人','PatentAppKind','','','','','','','','',1),('PAK02','99','admin','受讓人','PatentAppKind','','','','','','','','',1),('PatentAppKind','99','admin','申請人屬性','PatentCase','Y','','','','','','','',1),('PatentCase','99','tony','專利案件','','Y','','','','','','','',1),('PatentCaseType','99','raychu','專利案件種類','PatentCase','Y','','','','','','','',1),('PatentCitationStatus','99','admin','專利引證狀態','','Y','','','','','','','',1),('PatentDocType','99','raychu','專利文件類別','DocumentType','Y','','','','','','','',1),('PatentOffice','99','tony','申請國家','PatentCase','Y','','','','','','','',1),('PatentType','99','tony','專利類別','PatentCase','Y','','','','','','','',1),('Pay01','99','raychu','匯款','ReceiveType','','','','','','','','',1),('Pay02','99','raychu','支票','ReceiveType','','','','','','','','',1),('Pay03','99','raychu','現金','ReceiveType','','','','','','','','',1),('Pay04','99','admin','ATM匯款','ReceiveType','','','','','','','','',1),('PayKind','99','simon','付款種類',NULL,'Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayKind01','99','simon','一般','PayKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayKind02','99','simon','預付款','PayKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayKind03','99','simon','保管款','PayKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Payment','99','raychu','付款條件','PatentCase','Y','','','','','','','',1),('PaymentKind','99','simon','付費方式','','Y','','','','','','','',1),('PaymentPolicy','99','admin','計費方式','','Y','','','','','','','',1),('PaymentTerm','99','raychu','付款條件','PatentCase','Y','','','','','','','',1),('PaymentType','99','raychu','付款方式','PatentCase','Y','','','','','','','',1),('PayToParty','99','simon','付款對象','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayToParty01','99','simon','代理人','PayToParty',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayToParty02','99','simon','政府機關','PayToParty',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayToParty03','99','simon','其他','PayToParty',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PayType','99','raychu','付款類別','Receivable','Y','','','','','','','',1),('PayType01','99','raychu','匯款','PayType','','','','','','','','',1),('PayType02','99','raychu','支票','PayType','','','','','','','','',1),('PayType03','99','raychu','現金','PayType','','','','','','','','',1),('PCDT01','99','raychu','信函','PatentDocType','','','','','','','','T',1),('PCDT02','99','raychu','傳真','PatentDocType','','','','','','','','TOT',1),('PCDT03','99','raychu','e-mail','PatentDocType','','','','','','','','',1),('PCDT04','99','raychu','電話連絡','PatentDocType','','','','','','','','',1),('PCDT05','99','raychu','副本','PatentDocType','','','','','','','','',1),('PCDT06','99','raychu','通知函','PatentDocType','','','','','','','','',1),('PCS01','99','admin','未確認','PatentCitationStatus','','','','','','','','',1),('PCS02','99','admin','已提交(未套印)','PatentCitationStatus','','','','','','','','',1),('PCS03','99','admin','無需提交','PatentCitationStatus','','','','','','','','',1),('PCS04','99','admin','已提交(已套印)','PatentCitationStatus','','','','','','','','',1),('PCT','99','admin','世界智慧財產權組織','PatentOffice','','','','','','','','專利合作條約（Patent Cooperation Treaty, PCT）',1),('PCT01','99','raychu','申請案','PatentCaseType','','','','','','','','P',1),('PCT02','99','admin','專利分析、檢索、稽核','PatentCaseType','','','','','','','','CFP',1),('PCT03','99','admin','撰稿','PatentCaseType','','','','','','','','CFP',1),('PCT04','99','admin','翻譯','PatentCaseType','','','','','','','','CFP',1),('PCT05','99','admin','技術報告','PatentCaseType','','','','','','','','CFP',1),('PCT06','99','admin','其他報告','PatentCaseType','','','','','','','','CFP',1),('PCT07','99','admin','訴願','PatentCaseType','','','','','','','','CFP',1),('PCT08','99','admin','舉發','PatentCaseType','','','','','','','','CFP',1),('PCT09','99','admin','被舉發','PatentCaseType','','','','','','','','CFP',1),('PCT10','99','admin','民事訴訟','PatentCaseType','','','','','','','','CFP',1),('PCT11','99','admin','行政訴訟','PatentCaseType','','','','','','','','',1),('PCT12','99','admin','SBIR','PatentCaseType','','','','','','','','',1),('PCT13','99','admin','其他','PatentCaseType','','','','','','','','',1),('PE','99','admin','秘魯','PatentOffice','','','','','','','',' Peru',1),('PF','99','admin','法屬玻里尼西亞','PatentOffice','','','','','','','',' French Polynesia',1),('PG','99','admin','巴布亞紐幾內亞','PatentOffice','','','','','','','',' PAPUA NEW GUINEA ',1),('PH','99','admin','菲律賓','PatentOffice','','','','','','','',' Philippines',1),('PieChart','99','raychu','圓餅圖','ChartType','','','','','','','','',1),('PK','99','admin','巴基斯坦','PatentOffice','','','','','','','',' Pakistan',1),('PK01','99','simon','定額','PaymentKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PK02','99','simon','計時','PaymentKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PK03','99','simon','顧問','PaymentKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PK04','99','simon','免酬','PaymentKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PL','99','admin','波蘭','PatentOffice','','','','','','','',' Poland',1),('pm01','99','raychu','0 day','PaymentTerm','','','','','','','','',1),('pm02','99','raychu','15 Day','PaymentTerm','','','','','','','','',1),('pm03','99','raychu','30 days','PaymentTerm','','','','','','','','',1),('PN01','Demo','admin','發明','PatentType','Y','','','','','','','',1),('PN01-CN','TPAD00','ad103','发明','PN01','','','','','','','','CN',1),('PN01-HK','TPAD00','ad103','標準專利','PN01','','','','','','','','HK',1),('PN01-JP','Demo','admin','特許','PN01','','','','','','','','JP',1),('PN01-TW','TPAD00','ad103','發明','PN01','','','','','','','','TW',1),('PN01-US','Demo','admin','Utility','PN01','','','','','','','','US',1),('PN02','Demo','admin','新型','PatentType','Y','','','','','','','',1),('PN02-CN','Demo','admin','實用新型','PN02','','','','','','','','CN',1),('PN02-DE','Demo','admin','Utility Model','PN02','','','','','','','','CN',1),('PN02-HK','TPAD00','ad103','短期專利','PN02','','','','','','','','HK',1),('PN02-JP','Demo','admin','實用新案','PN02','','','','','','','','JP',1),('PN02-TW','TPAD00','ad103','新型','PN02','','','','','','','','TW',1),('PN03','Demo','admin','設計','PatentType','Y','','','','','','','',1),('PN03-CN','Demo','admin','外观设计','PN03','','','','','','','','CN',1),('PN03-HK','TPAD00','ad103','外觀設計','PN03','','','','','','','','HK',1),('PN03-JP','Demo','admin','意匠','PN03','','','','','','','','JP',1),('PN03-TW','TPAD00','ad103','設計','PN03','','','','','','','','TW',1),('PN03-US','Demo','admin','Design','PN03','','','','','','','','US',1),('PN05','Demo','admin','Provisional','PatentType','','','','','','','','',1),('PN07','Demo','admin','PCT國際階段','PatentType','','','','','','','','',1),('PN10','Demo','admin','年費管制','PatentType','','','','','','','','',1),('PN13','Demo','admin','舉發及無效','PatentType','','','','','','','','',1),('PR','99','admin','波多黎各','PatentOffice','','','','','','','',' Puerto Rico',1),('Priority','99','simon','優先順序','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Priority01','99','simon','1','Priority',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Priority02','99','simon','2','Priority',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Priority03','99','simon','3','Priority',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Priority04','99','simon','4','Priority',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('Priority05','99','simon','5','Priority',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PriorityRight','Demo','admin','優先權','','Y','','','','','','','',1),('PriorityRight01','Demo','admin','不主張','PriorityRight','','','','','','','','',1),('PriorityRight02','Demo','admin','主張優先權','PriorityRight','','','','','','','','',1),('PS','99','admin','巴勒斯坦','PatentOffice','','','','','','','',' Palestine, State of',1),('PSW','99','admin','約旦河西岸','PatentOffice','','','','','','','',' West Bank',1),('PT','99','admin','葡萄牙','PatentOffice','','','','','','','',' Portugal',1),('PT01','99','simon','轉帳扣繳','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT02','99','simon','當月月結','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT03','99','simon','即期票','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT04','99','simon','匯款','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT05','99','simon','員工代墊','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT06','99','simon','零用金代墊','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PT07','99','simon','其他','PaymentType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('PW','99','admin','帛琉','PatentOffice','','','','','','','',' Palau',1),('PY','99','admin','巴拉圭','PatentOffice','','','','','','','',' Paraguay',1),('QA','99','admin','卡達','PatentOffice','','','','','','','',' Qatar',1),('QAS01','99','simon','核可','QuotationApproveStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QAS02','99','simon','退回修改','QuotationApproveStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QDoc1-C01','Demo','admin','OO專利商標事務所','ATitle01','','','','','','','','',1),('QDoc1-C02','Demo','admin','■台北辦公室：OO市OO路O段O號O樓 ','ATitle01','','','','','','','','',1),('QDoc1-C03','Demo','admin','■電話：886-X-XXXXXXX ■ 傳真專線：886-X-XXXXXXXX ■ http://www.xxx.com.tw','ATitle01','','','','','','','','',1),('QDoc1E-C01','Demo','admin','OOO Intellectual Capital Management Co., Ltd.','ATitle03','','','','','','','','',2),('QDoc1E-C02','Demo','admin','■OOF, No.OO, Sec O, Dunhua S. Rd., Da\'an Dist., Taipei City, 106, Taiwan','ATitle03','','','','','','','','',2),('QDoc1E-C03','Demo','admin','■TEL：886-x-xxxxxxxx ■ FAX：886-x-xxxxxxxx ■ http://www.xxxxx.com','ATitle03','','','','','','','','',2),('QDoc2-C01','Demo','admin','OO智慧資產管理有限公司','ATitle02','','','','','','','','',1),('QDoc2-C02','Demo','admin','■台北辦公室：OO市OO路O段OO號O樓 ','ATitle02','','','','','','','','',1),('QDoc2-C03','Demo','admin','■電話：886-x-xxxxxxxx ■ 傳真專線：886-x-xxxxxxxx ■ http://www.xxxxx.com.tw','ATitle02','','','','','','','','',1),('QDoc4-C01','Demo','admin','OOOOO PATENT AND TRADEMARK OFFICE','ATitle04','','','','','','','','',2),('QDoc4-C02','Demo','admin','OF, No.O, Sec O, Dunhua S. Rd., Da\'an Dist., Taipei City, 106, Taiwan','ATitle04','','','','','','','','',2),('QDoc4-C03','Demo','admin','Tel: 886-x-xxxx-xxxx  Fax: 886-x-xxxx-xxxx','ATitle04','','','','','','','','',2),('QDoc5-C01','Demo','admin','OO國際專利商標事務所','ATitle05','','','','','','','','',1),('QDoc5-C02','Demo','admin','■台北辦公室：OO市OO路OO號O樓','ATitle05','','','','','','','','',1),('QDoc5-C03','Demo','admin','■電話：886-X-XXXXXXXX ■ 傳真專線：886-X-XXXXX ■ http://www.xxxxxxxx.com.tw','ATitle05','','','','','','','','',1),('QU10','99','simon','草擬中','CommissionedStatus','','','','','','','','',1),('QU11','Demo','admin','草擬完成','CommissionedStatus','','','','','','','','',1),('QU15','99','simon','退回修改','CommissionedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QU20','99','simon','待核可','CommissionedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QU30','99','simon','已核可','CommissionedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QU50','99','simon','已立案','CommissionedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QU60','Demo','admin','作廢','CommissionedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('QuotationApproveStatus','99','simon','核可狀態',NULL,'Y','','','','','','','',1),('QuotationDoc1','Demo','admin','報價單','','Y','','','','','','','',1),('QuotationDoc1E','Demo','admin','報價單','','Y','','','','','','','',1),('QZ','99','admin','社區植物品種局（歐盟）（CPVO）','PatentOffice','','','','','','','',' Community Plant Variety Office(European Union)(CPVO)',1),('R01','99','admin','主辦律師','Role','','','','','','','','',1),('R02','99','admin','協辦律師','Role','','','','','','','','',1),('R03','99','admin','秘書','Role','','','','','','','','',1),('Receivable','99','raychu','應收帳款','','Y','','','','','','','',1),('ReceiveType','99','raychu','收款類別','PatentCase','Y','','','','','','','',1),('ReceKind','99','simon','收款種類',NULL,'Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ReceKind01','99','simon','一般','ReceKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ReceKind02','99','simon','預收款','ReceKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ReceKind03','99','simon','事務費','ReceKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ReceKind04','99','simon','事務費預收','ReceKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ReceKind05','99','simon','保管款','ReceKind',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RenewStatus','99','admin','年費確認狀態','','Y','','','','','','','',1),('ResidencyType','99','admin','居住地(US案用)','','Y','','','','','','','',1),('RightStatus','99','raychu','案件狀態','PatentCase','Y','','','','','','','',1),('RIT01','99','raychu','申請案','IpType','','','','','','','','',1),('RIT02','99','raychu','舉發案','IpType','','','','','','','','',1),('RIT03','99','raychu','被舉發','IpType','','','','','','','','',1),('RIT04','99','raychu','答辯','IpType','','','','','','','','',1),('RIT05','99','raychu','訴願','IpType','','','','','','','','',1),('RIT06','99','raychu','行政訴訟','IpType','','','','','','','','',1),('RIT07','99','raychu','年費維護','IpType','','','','','','','','',1),('RIT08','99','raychu','侵權訴訟','IpType','','','','','','','','',1),('RIT09','99','raychu','其他','IpType','','','','','','','','',1),('RIT10','99','raychu','國內商標(T)','IpType','','','','','','','','',1),('RIT11','99','raychu','國外商標(TOT)','IpType','','','','','','','','',1),('RIT12','99','raychu','法務(L)','IpType','','','','','','','','',1),('RIT13','99','raychu','著作權(C)','IpType','','','','','','','','',1),('RMB','99','admin','人民幣','Currency','','','','','','','','',4.89),('RNS01','99','admin','產生','RenewStatus','','','','','','','','',1),('RNS015','99','admin','已連結報價','RenewStatus','','','','','','','','',1),('RNS02','99','admin','已列印確認單','RenewStatus','','','','','','','','',1),('RNS025','99','admin','已產生訂單','RenewStatus','','','','','','','','',1),('RNS03','99','admin','確認完成','RenewStatus','','','','','','','','',1),('RO','99','admin','羅馬尼亞','PatentOffice','','','','','','','',' Romania',1),('Role','99','admin','角色','','Y','','','','','','','',1),('RS','99','admin','塞爾維亞','PatentOffice','','','','','','','',' Serbia',1),('RS00','99','admin','待確認','RightStatus','','','','','','','','',1),('RS01','Demo','admin','撰稿','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS02','Demo','admin','客戶看稿','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS03','Demo','admin','準備送件','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS04','Demo','admin','審查中','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS05','Demo','admin','答辯中','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS05.1','TPAD00','ad103','答辯中-撰稿','RightStatus','','','','','','','','',1),('RS06','Demo','admin','复审请求','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS07','Demo','admin','待繳費','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS08','Demo','admin','待繳費領證','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS09','Demo','admin','待領證','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS10','Demo','admin','已領證','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS11','Demo','admin','結案','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS12','Demo','admin','等待','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS13','Demo','admin','暫停','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('RS13.1','TPAD00','ad103','補正中','RightStatus','','','','','','','','',1),('RS14','Demo','admin','新案-申請中','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS15','Demo','admin','OA1-通知','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS15.1','TPAD00','ad103','OA1-撰稿','RightStatus','','','','','','','','setColor',1),('RS16','Demo','admin','OA1-已答辯','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS17','Demo','admin','OA2-通知','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS17.1','TPAD00','ad103','OA2-撰稿','RightStatus','','','','','','','','setColor',1),('RS18','Demo','admin','OA2-已答辯','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS19','Demo','admin','OA3-通知','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS19.1','TPAD00','ad103','OA3-撰稿','RightStatus','','','','','','','','setColor',1),('RS20','Demo','admin','OA3-已答辯','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS21','Demo','admin','OA4-通知','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS21.1','TPAD00','ad103','OA4-撰稿','RightStatus','','','','','','','','setColor',1),('RS22','Demo','admin','OA4-已答辯','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS23','Demo','admin','核准-通知','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS24','Demo','admin','核准-待領證','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RS25','Demo','admin','核准-領證','RightStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'setColor',1),('RU','99','admin','俄羅斯','PatentOffice','','','','','','','',' Russian Federation',1),('RUB','TPAD00','55','盧比','Currency','','','','','','','','',0),('RUM','TPSA00','triciachang','盧布','Currency','','','','','','','','',0),('RW','99','admin','盧安達','PatentOffice','','','','','','','',' Rwanda',1),('SA','99','admin','沙烏地阿拉伯','PatentOffice','','','','','','','',' Saudi Arabia',1),('Salary_Point','99','tony','職等','','Y','','','','','','','',1),('SB','99','admin','南斯拉夫','PatentOffice','','','','','','','',' Solomon Islands',1),('SBD01','99','admin','收發文日','ServiceProjectBaseDate','','','','','','','','',1),('SBD02','99','admin','專案起始日','ServiceProjectBaseDate','','','','','','','','',1),('SBD03','99','admin','法定期限','ServiceProjectBaseDate','','','','','','','','',1),('SC','99','admin','塞席爾','PatentOffice','','','','','','','',' Seychelles',1),('SD','99','admin','蘇丹','PatentOffice','','','','','','','',' Sudan',1),('SE','99','admin','瑞典','PatentOffice','','','','','','','',' Sweden',1),('SEK','TPSA00','triciachang','瑞典幣','Currency','','','','','','','','',4.652),('ServiceProject','99','admin','服務專案','','Y','','','','','','','',1),('ServiceProjectBaseDate','99','admin','顧問案基準日','','Y','','','','','','','',1),('ServiceStatus','99','admin','專案狀態','ServiceProject','Y','','','','','','','',1),('ServiceStatus01','99','simon','專案狀態1','ServiceStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('ServiceTypeMain','99','admin','專案大類','ServiceProject','Y','','','','','','','',1),('ServiceTypeMain01','99','simon','法顧年約','ServiceTypeMain','','','','','','','','',1),('ServiceTypeSub','99','admin','專案中類','ServiceProject','Y','','','','','','','',1),('ServiceTypeSub01','99','simon','專案中類1','ServiceTypeSub',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('SG','99','admin','新加坡','PatentOffice','','','','','','','',' Singapore',1),('SGD','99','admin','新幣','Currency','','','','','','','','',24.152),('SH','99','admin','聖赫勒拿島','PatentOffice','','','','','','','',' Saint Helena, Ascension and Tristan da Cunha',1),('ShowItem','Demo','admin','新舊案件','','Y','','','','','','','',1),('SI','99','admin','斯洛維尼亞','PatentOffice','','','','','','','',' Slovenia',1),('SignedStatus','99','admin','簽核狀態','','Y','','','','','','','',1),('SignedStatus01','99','admin','待簽核','SignedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('SignedStatus02','99','admin','簽核中','SignedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('SignedStatus03','99','admin','簽核完成','SignedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('SignedStatus04','99','admin','退回','SignedStatus',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('SK','99','admin','斯洛伐克','PatentOffice','','','','','','','',' Svalbard and Jan Mayen',1),('SL','99','admin','獅子山','PatentOffice','','','','','','','',' Sierra Leone',1),('SM','99','admin','聖馬利諾','PatentOffice','','','','','','','',' San Marino',1),('SN','99','admin','塞內加爾','PatentOffice','','','','','','','',' Senegal',1),('SO','99','admin','索馬利亞','PatentOffice','','','','','','','',' Somalia',1),('SoStatus','Demo','admin','訂單狀態','','Y','','','','','','','',1),('SR','99','admin','塞爾維亞','PatentOffice','','','','','','','',' SURINAME ',1),('SS','99','admin','南蘇丹','PatentOffice','','','','','','','',' South Sudan',1),('SS01','99','admin','準備中','ServiceStatus','','','','','','','','',1),('SS02','99','admin','執行中','ServiceStatus','','','','','','','','',1),('SS03','99','admin','已結案','ServiceStatus','','','','','','','','',1),('ST','99','admin','聖多美普林西比','PatentOffice','','','','','','','',' Sao Tome and Principe',1),('StandardTask','99','raychu','標準期限管制','','Y','','','','','','','',1),('StandardTaskCaseType','99','alex','案件種類','','Y','','','','','','','',1),('STC01','99','alex','專利案件','StandardTaskCaseType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('STC02','99','alex','商標案件','StandardTaskCaseType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('STC03','99','alex','法律案件','StandardTaskCaseType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('STC04','99','alex','著作權案件','StandardTaskCaseType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('STC05','99','admin','顧問案','StandardTaskCaseType','','','','','','','','',1),('STM01','99','admin','智權年約','ServiceTypeMain','','','','','','','','',1),('STM02','99','admin','管顧年約','ServiceTypeMain','','','','','','','','',1),('STM03','99','admin','會計服務','ServiceTypeMain','','','','','','','','',1),('STS01','99','admin','中類一','ServiceTypeSub','','','','','','','','',1),('STS02','99','admin','中類二','ServiceTypeSub','','','','','','','','',1),('Subject','99','raychu','科目','Document','Y','','','','','','','',1),('Subject01','99','raychu','政府規費','Subject','','','','','','','','',1),('Subject02','99','raychu','複代理費','Subject','','','','','','','','',1),('Subject03','99','raychu','服務費','Subject','','','','','','','','',1),('Subject04','99','raychu','規費+服務費','Subject','','','','','','','','',1),('SubT01','Demo','admin','物權','SubType','','','','','','','','',1),('SubT02','Demo','admin','債權','SubType','','','','','','','','',1),('SubT03','Demo','admin','親屬','SubType','','','','','','','','',1),('SubT04','Demo','admin','繼承','SubType','','','','','','','','',1),('SubType','99','raychu','法律案件中類','','Y','','','','','','','',1),('SV','99','admin','薩爾瓦多','PatentOffice','','','','','','','',' El Salvador',1),('SX','99','admin','荷屬聖馬丁','PatentOffice','','','','','','','',' Sint Maarten (Dutch part)',1),('SY','99','admin','敘利亞','PatentOffice','','','','','','','',' Syrian Arab Republic',1),('SZ','99','admin','史瓦濟蘭','PatentOffice','','','','','','','',' Swaziland',1),('TaxT01','Demo','admin','台灣執行業務所得 10%','TaxType','','','','','','','','',0.1),('TaxT02','Demo','admin','台灣營業稅 5%','TaxType','','','','','','','','',0.05),('TaxT03','Demo','admin','中國營業稅1 3%','TaxType','','','','','','','','',0.03),('TaxT04','Demo','admin','中國營業稅2 6%','TaxType','','','','','','','','',0.06),('TaxT05','Demo','admin','中國營業稅3 11%','TaxType','','','','','','','','',0.11),('TaxType','Demo','admin','稅別','','Y','','','','','','','',1),('TBD01','99','alex','收發文日','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TBD02','99','alex','立案日','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TBD03','99','alex','申請日','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TBD04','99','alex','公告日','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TBD05','99','alex','註冊日','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TBD06','Demo','admin','法定期限','TrademarkBaseDate',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1),('TC','99','admin','土克斯及開科斯群島','PatentOffice','','','','','','','',' Turks and Caicos Islands',1),('TCCS01','99','raychu','逾期未領證','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS02','99','raychu','放棄答辯','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS03','99','raychu','公司已解散','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS04','99','raychu','放棄維護商標權','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS05','99','raychu','逾期未延展','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS06','99','raychu','被廢止','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS07','99','raychu','被撤銷','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS08','TPAD00','ad103','無法聯繫上客戶','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS09','TPAD00','ad103','放棄申請','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS10','TPAD00','ad103','放棄領證','TrademarkCaseCloseStatus','','','','','','','','',1),('TCCS11','TPAD00','ad103','變更代理','TrademarkCaseCloseStatus','','','','','','','','',1),('TCDT01','99','raychu','信函','TradeMarkDocType','','','','','','','','',1),('TCDT02','99','raychu','傳真','TradeMarkDocType','','','','','','','','',1),('TCDT03','99','raychu','e-mail','TradeMarkDocType','','','','','','','','',1),('TCDT04','99','raychu','電話連絡','TradeMarkDocType','','','','','','','','',1),('TCDT05','99','raychu','副本','TradeMarkDocType','','','','','','','','',1),('TCDT06','99','raychu','通知函','TradeMarkDocType','','','','','','','','',1),('TCS01','Demo','admin','撰稿','TrademarkCaseStatus','','','','','','','','T',1),('TCS02','Demo','admin','客戶看稿','TrademarkCaseStatus','','','','','','','','T',1),('TCS03','Demo','admin','準備送件','TrademarkCaseStatus','','','','','','','','T',1),('TCS04','Demo','admin','審查中','TrademarkCaseStatus','','','','','','','','T',1),('TCS05','Demo','admin','答辯中','TrademarkCaseStatus','','','','','','','','T',1),('TCS05.1','TPAD00','ad103','答辯中-撰稿','TrademarkCaseStatus','','','','','','','','T',1),('TCS06','Demo','admin','待繳費','TrademarkCaseStatus','','','','','','','','T',1),('TCS07','Demo','admin','待領證','TrademarkCaseStatus','','','','','','','','T',1),('TCS08','Demo','admin','已領證','TrademarkCaseStatus','','','','','','','','T',1),('TCS09','Demo','admin','結案','TrademarkCaseStatus','','','','','','','','T',1),('TCS10','Demo','admin','等待','TrademarkCaseStatus','','','','','','','','T',1),('TCS11','Demo','admin','暫停','TrademarkCaseStatus','','','','','','','','T',1),('TCT01','99','admin','申請','TrademarkCaseType','','','','','','','','T',1),('TCT02','99','admin','分割','TrademarkCaseType','','','','','','','','TOT',1),('TD','99','admin','查德','PatentOffice','','','','','','','',' Chad',1),('TDS01','99','simon','未完成','ToDosStatus','','','','','','','','',1),('TDS02','99','admin','已完成XX','ToDosStatus','','','','','','','','',1),('TechC01','99','admin','太陽能','TechCategory',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TechC02','99','admin','半導體','TechCategory',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TechC03','99','admin','光電','TechCategory',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TechC04','99','admin','其他','TechCategory',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TechCategory','99','admin','類別','PatentCase','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TechGroup','Demo','admin','技術組別','EmployeeFunction','Y','','','','','','','',1),('TechGroup01','Demo','admin','電子組','TechGroup','','','','','','','','',1),('TechGroup02','Demo','admin','機械組','TechGroup','','','','','','','','',1),('TechGroup03','Demo','admin','生醫組','TechGroup','','','','','','','','',1),('TechGroup04','Demo','admin','化學組','TechGroup','','','','','','','','',1),('TG','99','admin','多哥','PatentOffice','','','','','','','',' Togo',1),('TH','99','admin','泰國','PatentOffice','','','','','','','',' Thailand',1),('THB','TPSA00','triciachang','泰銖','Currency','','','','','','','','',0.9732),('TimeStatus','99','admin','工時請款狀態','','Y','','','','','','','',1),('Title','99','raychu','職稱','EmployeeFunction','Y','','','','','','','',1),('TJ','99','admin','塔吉克','PatentOffice','','','','','','','',' Tajikistan',1),('TK01','99','admin','圖及文','TrademarkKind','','','','','','','','',1),('TK02','99','admin','圖','TrademarkKind','','','','','','','','',1),('TK03','99','admin','文','TrademarkKind','','','','','','','','',1),('TL','99','admin','東帝汶','PatentOffice','','','','','','','',' Timor-Leste',1),('TM','99','admin','土庫曼','PatentOffice','','','','','','','',' Turkmenistan',1),('TMM01','99','raychu','申請','TradeMarkMatter','','','','','','','','',1),('TMM02','99','raychu','答辯','TradeMarkMatter','','','','','','','','',1),('TMM03','99','raychu','程序','TradeMarkMatter','','','','','','','','',1),('TMM04','99','raychu','領證','TradeMarkMatter','','','','','','','','',1),('TMM05','99','raychu','延展','TradeMarkMatter','','','','','','','','',1),('TMM06','99','raychu','訴願','TradeMarkMatter','','','','','','','','',1),('TMM07','99','raychu','異議','TradeMarkMatter','','','','','','','','',1),('TMM08','99','raychu','移轉','TradeMarkMatter','','','','','','','','',1),('TMM09','99','raychu','授權','TradeMarkMatter','','','','','','','','',1),('TMM10','99','raychu','宣示','TradeMarkMatter','','','','','','','','',1),('TMM11','99','raychu','分割','TradeMarkMatter','','','','','','','','',1),('TMM12','99','raychu','評定','TradeMarkMatter','','','','','','','','',1),('TMM13','99','raychu','縮減','TradeMarkMatter','','','','','','','','',1),('TMM14','99','raychu','行政訴訟','TradeMarkMatter','','','','','','','','',1),('TMM15','99','raychu','廢止','TradeMarkMatter','','','','','','','','',1),('TMT01','99','raychu','平面','MarkType','','','','','','','','',1),('TMT02','99','raychu','顏色','MarkType','','','','','','','','',1),('TMT03','99','raychu','立體','MarkType','','','','','','','','',1),('TMT04','99','raychu','聲音','MarkType','','','','','','','','',1),('TN','99','admin','突尼西亞','PatentOffice','','','','','','','',' Tunisia',1),('TO','99','admin','東加','PatentOffice','','','','','','','',' Tonga',1),('ToDosStatus','99','simon','待辦事項狀態','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TR','99','admin','土耳其','PatentOffice','','','','','','','',' Turkey',1),('TrademarkBaseDate','99','alex','商標案件基準日','TrademarkCase','Y','','','','','','','',1),('TrademarkCase','99','raychu','商標案件','','Y','','','','','','','',1),('TrademarkCaseCloseStatus','99','admin','結案狀態','TrademarkCase','Y','','','','','','','',1),('TrademarkCaseStatus','99','raychu','案件狀態','TrademarkCase','Y','','','','','','','',1),('TrademarkCaseType','99','admin','商標案件種類','TrademarkCase','Y','','','','','','','',1),('TradeMarkDocType','99','raychu','商標文件類別','DocumentType','Y','','','','','','','',1),('TrademarkKind','99','admin','商標類型','TrademarkCase','Y','','','','','','','',1),('TradeMarkMatter','99','raychu','商標案件性質','Matter','Y','','','','','','','',1),('TrademarkType','99','admin','商標類別','TrademarkCase','Y','','','','','','','',1),('TS01','99','admin','尚未請款','TimeStatus','','','','','','','','',1),('TS02','99','admin','已請款','TimeStatus','','','','','','','','',1),('TT','99','admin','千里達','PatentOffice','','','','','','','',' TRINIDAD AND TOBAGO ',1),('TT01','99','tony','商標','TrademarkType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('TT02','99','raychu','團體商標','TrademarkType','','','','','','','','',1),('TT03','99','raychu','證明標章','TrademarkType','','','','','','','','',1),('TT04','99','raychu','團體標章','TrademarkType','','','','','','','','',1),('TV','99','admin','吐瓦魯','PatentOffice','','','','','','','',' Tuvalu',1),('TW','99','admin','台灣','PatentOffice','','','','','','','',' Taiwan, Province of China',1),('TZ','99','admin','坦尚尼亞','PatentOffice','','','','','','','',' Tanzania, United Republic of',1),('UA','99','admin','烏克蘭','PatentOffice','','','','','','','',' Ukraine',1),('UG','99','admin','烏干達','PatentOffice','','','','','','','',' Uganda',1),('Unit','Demo','admin','單位','','Y','','','','','','','',1),('Unit01','Demo','admin','案','Unit','','','','','','','','',1),('Unit02','Demo','admin','件','Unit','','','','','','','','',1),('Unit03','Demo','admin','次','Unit','','','','','','','','',1),('Unit04','Demo','admin','份','Unit','','','','','','','','',1),('Unit05','Demo','admin','圖','Unit','','','','','','','','',1),('Unit06','Demo','admin','項','Unit','','','','','','','','',1),('Unit07','Demo','admin','篇','Unit','','','','','','','','',1),('Unit08','Demo','admin','字','Unit','','','','','','','','',1),('Unit09','Demo','admin','100字','Unit','','','','','','','','',1),('Unit10','TPSA00','triciachang','頁','Unit','','','','','','','','',1),('update','Demo','admin','update','Action','','','','','','','','',1),('US','99','admin','美國','PatentOffice','','','','','','','',' United States',1),('US.Patent','99','simon','美國專利','CitationType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('US.Pub','99','simon','美國公開專利','CitationType',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('USD','Demo','admin','美金','Currency','','','','','','','','',30.235),('USR01','99','admin','US Residency','ResidencyType','Y','','','','','','','',1),('USR02','99','admin','Non US Residency','ResidencyType','Y','','','','','','','',1),('UY','99','admin','烏拉圭','PatentOffice','','','','','','','',' Uruguay',1),('UZ','99','admin','烏茲別克','PatentOffice','','','','','','','',' Uzbekistan',1),('VA','99','admin','梵蒂岡','PatentOffice','','','','','','','',' Holy See (Vatican City State)',1),('VC','99','admin','聖文森及格瑞那丁','PatentOffice','','','','','','','',' Saint Vincent and the Grenadines',1),('VE','99','admin','委內瑞拉','PatentOffice','','','','','','','',' Venezuela (Bolivarian Republic of)',1),('VG','99','admin','英屬維爾京群島','PatentOffice','','','','','','','',' VIRGIN ISLANDS, BRITISH ',1),('VN','99','admin','越南','PatentOffice','','','','','','','',' Vietnam',1),('VND','TPSA00','triciachang','越南幣','Currency','','','','','','','','',0),('VU','99','admin','萬那杜','PatentOffice','','','','','','','',' Vanuatu',1),('WorkType','99','simon','工作類型','','Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),('WorkType01','99','simon','出刑事庭','WorkType','','','','','','','','',1),('WorkType02','99','simon','出差','WorkType','','','','','','','','',1),('WorkType03','99','admin','閱卷','WorkType','','','','','','','','',1),('WorkType04','99','admin','會議記錄','WorkType','','','','','','','','',1),('WorkType05','99','admin','出民事庭','WorkType','','','','','','','','',1),('WorkType06','99','admin','合約審閱','WorkType','','','','','','','','',1),('WorkType07','99','admin','顧問諮詢','WorkType','','','','','','','','',1),('WS','99','admin','薩摩亞','PatentOffice','','','','','','','',' Samoa',1),('XN','99','admin','北歐專利局（NPI）','PatentOffice','','','','','','','',' Nordic Patent Institute(NPI)',1),('YE','99','admin','葉門','PatentOffice','','','','','','','',' Yemen',1),('YU','99','admin','南斯拉夫','PatentOffice','','','','','','','',' YUGOSLAVIA ',1),('ZA','99','admin','南非','PatentOffice','','','','','','','',' South Africa',1),('ZM','99','admin','尚比亞','PatentOffice','','','','','','','',' Zambia',1),('ZR','99','admin','薩伊','TrademarkCase','','PatentOffice','','','','','','',1),('ZW','99','admin','辛巴威','PatentOffice','','','','','','','',' Zimbabwe',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chartdefine`
--

DROP TABLE IF EXISTS `chartdefine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chartdefine` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Names` varchar(100) NOT NULL,
  `ChartType` varchar(50) NOT NULL,
  `X_AxisText` varchar(50) NOT NULL,
  `Y1_AxisText` varchar(50) NOT NULL,
  `Y2_AxisText` varchar(50) NOT NULL,
  `SqlString_1` varchar(500) NOT NULL,
  `SqlString_2` varchar(500) NOT NULL,
  `DataByUser` char(1) NOT NULL,
  `ValueFrom` varchar(50) NOT NULL,
  `DataFrom_1` varchar(50) NOT NULL,
  `DataFrom_2` varchar(50) NOT NULL,
  `G2_DataFrom_1` varchar(50) NOT NULL,
  `G2_DataFrom_2` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chartdefine`
--

LOCK TABLES `chartdefine` WRITE;
/*!40000 ALTER TABLE `chartdefine` DISABLE KEYS */;
INSERT INTO `chartdefine` VALUES ('CalendarYearRevenue','99','raychu','歷年營收','BarChart','','','','SELECT SUBSTR( VoucherDate, 1, 4 ) AS Group1, sum( TotalRequestPayNtdAmount) AS ValueY FROM invoice GROUP BY SUBSTR( VoucherDate, 1, 4 ) ','','Y','案件數量','','專利狀態區間','',''),('PatentChart01','99','raychu','專利案件-類別分組統計表','BarChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from PatentCase M  inner join Category R2 on M.PatentType=R2.FlowKey Group by R2.Names ','','Y','案件數量','','專利類別區間','',''),('PatentChart02','99','raychu','專利案件-申請國家分組統計表','BarChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from PatentCase M  inner join Category R2 on M.PatentOffice=R2.FlowKey Group by R2.Names ','','Y','案件數量','','專利申請國家區間','',''),('PatentChart03','99','raychu','專利案件-狀態分組統計表','PieChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from PatentCase M  inner join Category R2 on M.Status=R2.FlowKey Group by R2.Names ','','Y','案件數量','','專利狀態區間','',''),('PatentChart05','99','raychu','專利案件-國家vs狀態分類統計表','BarChart','國家別','件數','','select R1.Names as Group1,R2.Names as Group2,Count(M.FlowKey) as ValueY \r\nfrom PatentCase M \r\ninner join Category R1 on M.PatentOffice=R1.FlowKey  \r\ninner join Category R2 on M.Status=R2.FlowKey \r\nGroup by R1.Names, R2.Names ','','Y','','國家區間','','',''),('PatentChart06','99','raychu','專利案件-申請年度統計表','LineChart','申請年','件數','','SELECT SUBSTR(ApplyDate,1,4) AS Group1, count(M.FlowKey) as ValueY FROM PatentCase M GROUP BY SUBSTR(ApplyDate,1,4)','','Y','','年份區間','','',''),('PatentChart07','99','raychu','專利案件-獲證年度統計表','LineChart','獲證年','件數','','SELECT SUBSTR(IssueDate,1,4) AS Group1, count(M.FlowKey) as ValueY FROM PatentCase M GROUP BY SUBSTR(IssueDate,1,4)','','Y','','年份區間','','',''),('TrademarkChart01','99','raychu','商標案件-類別分組統計表','BarChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from TrademarkCase M  inner join Category R2 on M.TrademarkType=R2.FlowKey Group by R2.Names ','','Y','案件數量','','商標類別區間','',''),('TrademarkChart02','99','raychu','商標案件-申請國家分組統計表','BarChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from TrademarkCase M  inner join Category R2 on M.Office=R2.FlowKey Group by R2.Names ','','Y','案件數量','','商標申請國家區間','',''),('TrademarkChart03','99','raychu','商標案件-狀態分組統計表','PieChart','','','','select R2.Names as Group2,Count(M.FlowKey) as ValueY from TrademarkCase M  inner join Category R2 on M.Status=R2.FlowKey Group by R2.Names ','','Y','案件數量','','專利狀態區間','',''),('TrademarkChart05','99','raychu','商標案件-國家vs狀態分類統計表','BarChart','國家別','件數','','select R1.Names as Group1,R2.Names as Group2,Count(M.FlowKey) as ValueY \r\nfrom TrademarkCase M \r\ninner join Category R1 on M.Office=R1.FlowKey  \r\ninner join Category R2 on M.Status=R2.FlowKey \r\nGroup by R1.Names, R2.Names ','','Y','','國家區間','','',''),('TrademarkChart06','99','raychu','商標案件-申請年度統計表','LineChart','申請年','件數','','SELECT SUBSTR(FillingDate,1,4) AS Group1, count(M.FlowKey) as ValueY FROM TrademarkCase M GROUP BY SUBSTR(FillingDate,1,4)','','Y','','年份區間','','',''),('TrademarkChart07','99','raychu','商標案件-公告年度統計表','LineChart','公告年','件數','','SELECT SUBSTR(IssueDate,1,4) AS Group1, count(M.FlowKey) as ValueY FROM TrademarkCase M GROUP BY SUBSTR(IssueDate,1,4)','','Y','','年份區間','','',''),('YearRevenue','99','raychu','當年營收','BarChart','國家別','件數','','select R1.Names as Group1,R2.Names as Group2,Count(M.FlowKey) as ValueY \r\nfrom TrademarkCase M \r\ninner join Category R1 on M.Office=R1.FlowKey  \r\ninner join Category R2 on M.Status=R2.FlowKey \r\nGroup by R1.Names, R2.Names ','','Y','','年份區間','','','');
/*!40000 ALTER TABLE `chartdefine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `CompanyName` varchar(200) DEFAULT NULL,
  `EnglishCompanyName` varchar(200) DEFAULT NULL,
  `RegisteredNo` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Tel1` varchar(100) DEFAULT NULL,
  `Tel2` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax1` varchar(50) DEFAULT NULL,
  `Fax2` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `WebSite` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Zip1` varchar(50) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `Address1` varchar(200) DEFAULT NULL,
  `EnglishAddress1` varchar(200) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `EnglishAddress2` varchar(200) DEFAULT NULL,
  `OwnershipType` varchar(50) DEFAULT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `Industry` varchar(50) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `Credit` varchar(50) DEFAULT NULL,
  `Revenue` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `InvoiceTitle` varchar(100) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Appendix` varchar(100) DEFAULT NULL,
  `Sponsor` varchar(50) DEFAULT NULL,
  `Payment` varchar(50) DEFAULT NULL,
  `AlertDay` int(11) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Email3` varchar(50) DEFAULT NULL,
  `AccountingContact` varchar(50) DEFAULT NULL,
  `Accounting` varchar(50) DEFAULT NULL,
  `AccountingContactTel` varchar(50) DEFAULT NULL,
  `AccountingContactFax` varchar(50) DEFAULT NULL,
  `AccountingTel` varchar(50) DEFAULT NULL,
  `AccountingFax` varchar(50) DEFAULT NULL,
  `AccountingAddr` varchar(50) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `EnglishFirstName` varchar(50) DEFAULT NULL,
  `EnglishLastName` varchar(50) DEFAULT NULL,
  `Identity` varchar(50) DEFAULT NULL,
  `GuanAccountDate` varchar(50) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `InvoiceTitle1` varchar(100) DEFAULT NULL,
  `InvoiceTitle2` varchar(50) DEFAULT NULL,
  `RegisteredNo2` varchar(50) DEFAULT NULL,
  `AlsoAddContact` varchar(1) DEFAULT NULL,
  `AccountingEmail` varchar(50) DEFAULT NULL,
  `ContactCompany` varchar(100) DEFAULT NULL,
  `ContactDept` varchar(100) DEFAULT NULL,
  `Introduce` varchar(50) DEFAULT NULL,
  `UploadDoc` varchar(50) DEFAULT NULL,
  `UploadDoc2` varchar(50) DEFAULT NULL,
  `UploadDoc3` varchar(50) DEFAULT NULL,
  `UploadDocName` varchar(100) DEFAULT NULL,
  `UploadDocName2` varchar(100) DEFAULT NULL,
  `UploadDocName3` varchar(100) DEFAULT NULL,
  `AccountingOffice` varchar(50) NOT NULL,
  `AccountingMissTel` varchar(50) NOT NULL,
  `AccountingMissFax` varchar(50) NOT NULL,
  `AccountingOfficeTel` varchar(50) NOT NULL,
  `AccountingOfficeFax` varchar(50) NOT NULL,
  `AccountingOfficeAddr` varchar(200) NOT NULL,
  `BankBranches` varchar(100) DEFAULT NULL,
  `BankBranches2` varchar(100) DEFAULT NULL,
  `GroupName` varchar(50) DEFAULT NULL,
  `ContactRecord` text,
  `CaseAD` varchar(50) DEFAULT NULL,
  `SponsorAssistantName` varchar(1000) DEFAULT NULL,
  `BillingContact` varchar(50) DEFAULT NULL,
  `SponsorAssistant` varchar(300) DEFAULT NULL,
  `Zip3` varchar(50) DEFAULT NULL,
  `Zip4` varchar(50) DEFAULT NULL,
  `Tel1ExNo` varchar(50) DEFAULT NULL,
  `Tel2ExNo` varchar(50) DEFAULT NULL,
  `BillingContactEmail` varchar(100) DEFAULT NULL,
  `Email1` varchar(100) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `EnglishAddress3` varchar(200) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `ShowItem` varchar(50) DEFAULT NULL,
  `NewCaseOthers` varchar(50) DEFAULT NULL,
  `OldCaseOthers` varchar(50) DEFAULT NULL,
  `NewCase` varchar(50) DEFAULT NULL,
  `OldCase` varchar(50) DEFAULT NULL,
  `TwCase` varchar(50) DEFAULT NULL,
  `OtherCase` varchar(50) DEFAULT NULL,
  `Paper1` varchar(50) DEFAULT NULL,
  `ElectronicFiles1` varchar(50) DEFAULT NULL,
  `Files1` varchar(50) DEFAULT NULL,
  `Files1Other` varchar(500) DEFAULT NULL,
  `Paper2` varchar(50) DEFAULT NULL,
  `ElectronicFiles2` varchar(50) DEFAULT NULL,
  `Files2` varchar(50) DEFAULT NULL,
  `Files2Other` varchar(500) DEFAULT NULL,
  `Attorney` varchar(1) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `Datalack` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_2`
--

DROP TABLE IF EXISTS `client_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `CompanyName` varchar(200) DEFAULT NULL,
  `EnglishCompanyName` varchar(200) DEFAULT NULL,
  `RegisteredNo` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Tel1` varchar(100) DEFAULT NULL,
  `Tel2` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax1` varchar(50) DEFAULT NULL,
  `Fax2` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `WebSite` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Zip1` varchar(50) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `Address1` varchar(200) DEFAULT NULL,
  `EnglishAddress1` varchar(200) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `EnglishAddress2` varchar(200) DEFAULT NULL,
  `OwnershipType` varchar(50) DEFAULT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `Industry` varchar(50) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `Credit` varchar(50) DEFAULT NULL,
  `Revenue` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `InvoiceTitle` varchar(100) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Appendix` varchar(100) DEFAULT NULL,
  `Sponsor` varchar(50) DEFAULT NULL,
  `Payment` varchar(50) DEFAULT NULL,
  `AlertDay` int(11) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Email3` varchar(50) DEFAULT NULL,
  `AccountingContact` varchar(50) DEFAULT NULL,
  `Accounting` varchar(50) DEFAULT NULL,
  `AccountingContactTel` varchar(50) DEFAULT NULL,
  `AccountingContactFax` varchar(50) DEFAULT NULL,
  `AccountingTel` varchar(50) DEFAULT NULL,
  `AccountingFax` varchar(50) DEFAULT NULL,
  `AccountingAddr` varchar(50) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `EnglishFirstName` varchar(50) DEFAULT NULL,
  `EnglishLastName` varchar(50) DEFAULT NULL,
  `Identity` varchar(50) DEFAULT NULL,
  `GuanAccountDate` varchar(50) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `InvoiceTitle1` varchar(100) DEFAULT NULL,
  `InvoiceTitle2` varchar(50) DEFAULT NULL,
  `RegisteredNo2` varchar(50) DEFAULT NULL,
  `AlsoAddContact` varchar(1) DEFAULT NULL,
  `AccountingEmail` varchar(50) DEFAULT NULL,
  `ContactCompany` varchar(100) DEFAULT NULL,
  `ContactDept` varchar(100) DEFAULT NULL,
  `Introduce` varchar(50) DEFAULT NULL,
  `UploadDoc` varchar(50) DEFAULT NULL,
  `UploadDoc2` varchar(50) DEFAULT NULL,
  `UploadDoc3` varchar(50) DEFAULT NULL,
  `UploadDocName` varchar(100) DEFAULT NULL,
  `UploadDocName2` varchar(100) DEFAULT NULL,
  `UploadDocName3` varchar(100) DEFAULT NULL,
  `AccountingOffice` varchar(50) NOT NULL,
  `AccountingMissTel` varchar(50) NOT NULL,
  `AccountingMissFax` varchar(50) NOT NULL,
  `AccountingOfficeTel` varchar(50) NOT NULL,
  `AccountingOfficeFax` varchar(50) NOT NULL,
  `AccountingOfficeAddr` varchar(200) NOT NULL,
  `BankBranches` varchar(100) DEFAULT NULL,
  `BankBranches2` varchar(100) DEFAULT NULL,
  `GroupName` varchar(50) DEFAULT NULL,
  `ContactRecord` text,
  `CaseAD` varchar(50) DEFAULT NULL,
  `SponsorAssistantName` varchar(1000) DEFAULT NULL,
  `BillingContact` varchar(50) DEFAULT NULL,
  `SponsorAssistant` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_2`
--

LOCK TABLES `client_2` WRITE;
/*!40000 ALTER TABLE `client_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientbilling`
--

DROP TABLE IF EXISTS `clientbilling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientbilling` (
  `FlowKey` int(11) NOT NULL AUTO_INCREMENT,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ShowItem` varchar(50) DEFAULT NULL,
  `NewCaseOthers` varchar(50) DEFAULT NULL,
  `OldCaseOthers` varchar(50) DEFAULT NULL,
  `NewCase` varchar(50) DEFAULT NULL,
  `OldCase` varchar(50) DEFAULT NULL,
  `TwCase` varchar(50) DEFAULT NULL,
  `OtherCase` varchar(50) DEFAULT NULL,
  `Paper1` varchar(50) DEFAULT NULL,
  `ElectronicFiles1` varchar(50) DEFAULT NULL,
  `Files1` varchar(50) DEFAULT NULL,
  `Files1Other` varchar(500) DEFAULT NULL,
  `Paper2` varchar(50) DEFAULT NULL,
  `ElectronicFiles2` varchar(50) DEFAULT NULL,
  `Files2` varchar(50) DEFAULT NULL,
  `Files2Other` varchar(500) DEFAULT NULL,
  `AttorneyTitle` varchar(50) DEFAULT NULL,
  `BillSendDoc1` varchar(50) DEFAULT 'N',
  `BillSendDoc2` varchar(50) DEFAULT 'N',
  `BillSendDoc3` varchar(50) DEFAULT 'N',
  `BillSendDoc4` varchar(50) DEFAULT 'N',
  `BillSendDoc5` varchar(50) DEFAULT 'N',
  `BillSendDoc6` varchar(50) DEFAULT 'N',
  `BillSendDoc7` varchar(50) DEFAULT 'N',
  `BillSendDoc8` varchar(50) DEFAULT 'N',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientbilling`
--

LOCK TABLES `clientbilling` WRITE;
/*!40000 ALTER TABLE `clientbilling` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientbilling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientdocument`
--

DROP TABLE IF EXISTS `clientdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `DocumentType` varchar(50) DEFAULT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) DEFAULT NULL,
  `DocumentNo` varchar(50) DEFAULT NULL,
  `DocumentKind` varchar(50) DEFAULT NULL,
  `DocumentDate` varchar(10) DEFAULT NULL,
  `DocumentTarget` varchar(50) DEFAULT NULL,
  `DocumentProcess` varchar(50) DEFAULT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(400) DEFAULT NULL,
  `AttachmentName2` varchar(400) DEFAULT NULL,
  `AttachmentName3` varchar(400) DEFAULT NULL,
  `AttachmentName4` varchar(400) DEFAULT NULL,
  `AttachmentName5` varchar(400) DEFAULT NULL,
  `AttachmentName6` varchar(400) DEFAULT NULL,
  `AttachmentName7` varchar(400) DEFAULT NULL,
  `AttachmentName8` varchar(400) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientdocument`
--

LOCK TABLES `clientdocument` WRITE;
/*!40000 ALTER TABLE `clientdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateTime` varchar(20) NOT NULL,
  `Summary` varchar(200) NOT NULL,
  `Names` varchar(200) NOT NULL,
  `Workplan` varchar(50) NOT NULL,
  `PlanType` varchar(50) NOT NULL,
  `PlanDept` varchar(50) NOT NULL,
  `PlanLeader` varchar(50) NOT NULL,
  `Target` varchar(200) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `CloseDate` varchar(20) NOT NULL,
  `CloseReason` varchar(50) NOT NULL,
  `ContractDate` varchar(10) NOT NULL,
  `EndDate` varchar(10) NOT NULL,
  `SignOutId` varchar(50) NOT NULL,
  `SignOutTime` varchar(20) NOT NULL,
  `SignOutName` varchar(50) NOT NULL,
  `UpdateTime` varchar(20) NOT NULL,
  `Updater` varchar(50) NOT NULL,
  `Creator` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractauthorize`
--

DROP TABLE IF EXISTS `contractauthorize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractauthorize` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `Nationality` varchar(50) NOT NULL,
  `PatentType` varchar(50) NOT NULL,
  `PatentNo` varchar(50) NOT NULL,
  `PatentNames` varchar(200) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Authorize` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractauthorize`
--

LOCK TABLES `contractauthorize` WRITE;
/*!40000 ALTER TABLE `contractauthorize` DISABLE KEYS */;
/*!40000 ALTER TABLE `contractauthorize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractdocument`
--

DROP TABLE IF EXISTS `contractdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `DocumentType` varchar(50) NOT NULL,
  `DocumentName` varchar(100) NOT NULL,
  `DocumentUrl` varchar(50) NOT NULL,
  `Edition` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractdocument`
--

LOCK TABLES `contractdocument` WRITE;
/*!40000 ALTER TABLE `contractdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `contractdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractroyalties`
--

DROP TABLE IF EXISTS `contractroyalties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractroyalties` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `RoyaltiesType` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `PaymentDate` varchar(10) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractroyalties`
--

LOCK TABLES `contractroyalties` WRITE;
/*!40000 ALTER TABLE `contractroyalties` DISABLE KEYS */;
/*!40000 ALTER TABLE `contractroyalties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightapplicant`
--

DROP TABLE IF EXISTS `copyrightapplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightapplicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `ApplicantOrder` varchar(50) NOT NULL,
  `ApplicantId` varchar(50) NOT NULL,
  `ApplicantName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightapplicant`
--

LOCK TABLES `copyrightapplicant` WRITE;
/*!40000 ALTER TABLE `copyrightapplicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightapplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightattorney`
--

DROP TABLE IF EXISTS `copyrightattorney`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightattorney` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `AttorneyType` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `AttorneyName` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightattorney`
--

LOCK TABLES `copyrightattorney` WRITE;
/*!40000 ALTER TABLE `copyrightattorney` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightattorney` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightcase`
--

DROP TABLE IF EXISTS `copyrightcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightcase` (
  `FlowKey` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `CaseNo2` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `MainType` varchar(50) NOT NULL,
  `SubType` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Priority` varchar(50) NOT NULL,
  `TargetStartDate` varchar(10) NOT NULL,
  `RealStartDate` varchar(10) NOT NULL,
  `TargetFinishDate` varchar(10) NOT NULL,
  `RealFinishDate` varchar(10) NOT NULL,
  `TmpField_01` varchar(50) NOT NULL,
  `TmpField_02` varchar(50) NOT NULL,
  `TmpField_03` varchar(50) NOT NULL,
  `TmpField_04` varchar(50) NOT NULL,
  `TmpField_05` varchar(50) NOT NULL,
  `TmpField_06` varchar(50) NOT NULL,
  `TmpField_07` varchar(50) NOT NULL,
  `TmpField_08` varchar(50) NOT NULL,
  `TmpField_09` varchar(50) NOT NULL,
  `TmpField_10` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `CopyRightUnit` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `NumberOfUnits` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `CaseOpenfile` varchar(200) DEFAULT NULL,
  `EnglishTitle` varchar(500) DEFAULT NULL,
  `CaseAssignedTo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightcase`
--

LOCK TABLES `copyrightcase` WRITE;
/*!40000 ALTER TABLE `copyrightcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightcase_2`
--

DROP TABLE IF EXISTS `copyrightcase_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightcase_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `CaseNo2` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `MainType` varchar(50) NOT NULL,
  `SubType` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Priority` varchar(50) NOT NULL,
  `TargetStartDate` varchar(10) NOT NULL,
  `RealStartDate` varchar(10) NOT NULL,
  `TargetFinishDate` varchar(10) NOT NULL,
  `RealFinishDate` varchar(10) NOT NULL,
  `TmpField_01` varchar(50) NOT NULL,
  `TmpField_02` varchar(50) NOT NULL,
  `TmpField_03` varchar(50) NOT NULL,
  `TmpField_04` varchar(50) NOT NULL,
  `TmpField_05` varchar(50) NOT NULL,
  `TmpField_06` varchar(50) NOT NULL,
  `TmpField_07` varchar(50) NOT NULL,
  `TmpField_08` varchar(50) NOT NULL,
  `TmpField_09` varchar(50) NOT NULL,
  `TmpField_10` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `CopyRightUnit` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `NumberOfUnits` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightcase_2`
--

LOCK TABLES `copyrightcase_2` WRITE;
/*!40000 ALTER TABLE `copyrightcase_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightcase_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightcolleagues`
--

DROP TABLE IF EXISTS `copyrightcolleagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightcolleagues` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `EmpId` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Memo` varchar(500) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightcolleagues`
--

LOCK TABLES `copyrightcolleagues` WRITE;
/*!40000 ALTER TABLE `copyrightcolleagues` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightcolleagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightdocument`
--

DROP TABLE IF EXISTS `copyrightdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `DocumentType` varchar(50) NOT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) NOT NULL,
  `DocumentNo` varchar(50) NOT NULL,
  `DocumentKind` varchar(50) NOT NULL,
  `DocumentDate` varchar(10) NOT NULL,
  `DocumentTarget` varchar(50) NOT NULL,
  `DocumentProcess` varchar(50) NOT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(100) DEFAULT NULL,
  `AttachmentName2` varchar(100) DEFAULT NULL,
  `AttachmentName3` varchar(100) DEFAULT NULL,
  `AttachmentName4` varchar(100) DEFAULT NULL,
  `AttachmentName5` varchar(100) DEFAULT NULL,
  `AttachmentName6` varchar(100) DEFAULT NULL,
  `AttachmentName7` varchar(100) DEFAULT NULL,
  `AttachmentName8` varchar(100) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightdocument`
--

LOCK TABLES `copyrightdocument` WRITE;
/*!40000 ALTER TABLE `copyrightdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyrightpriority`
--

DROP TABLE IF EXISTS `copyrightpriority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyrightpriority` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `PriorityDate` varchar(10) NOT NULL,
  `ApplyNo` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `Document` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyrightpriority`
--

LOCK TABLES `copyrightpriority` WRITE;
/*!40000 ALTER TABLE `copyrightpriority` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyrightpriority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `MembershipDate` varchar(10) DEFAULT NULL,
  `QualificationsDate` varchar(10) DEFAULT NULL,
  `CustomerType` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `TelNo` varchar(20) DEFAULT NULL,
  `Fax` varchar(20) DEFAULT NULL,
  `CellNo` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `RegisteredAddress` varchar(200) DEFAULT NULL,
  `SameFlag` char(1) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnterpriseNo` varchar(50) DEFAULT NULL,
  `CollectType` varchar(50) DEFAULT NULL,
  `PriceDiscount` double DEFAULT NULL,
  `SpecialDiscount` double DEFAULT NULL,
  `IsVia` char(1) DEFAULT NULL,
  `SaleDept` varchar(50) DEFAULT NULL,
  `Salesponsor` varchar(50) DEFAULT NULL,
  `HasChildFlag` char(1) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `Branch` varchar(50) DEFAULT NULL,
  `AccountingName` varchar(50) DEFAULT NULL,
  `AccountingNo` varchar(50) DEFAULT NULL,
  `PvRate` double DEFAULT NULL,
  `Birthday` varchar(10) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `BonusParent` varchar(50) DEFAULT NULL,
  `AmountFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dailydata`
--

DROP TABLE IF EXISTS `dailydata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dailydata` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  `BusinessDate` varchar(10) DEFAULT NULL,
  `DancerTeam` varchar(50) DEFAULT NULL,
  `FirstSubTotal` int(11) DEFAULT NULL,
  `FirstUnit` double DEFAULT NULL,
  `FirstAmount` int(11) DEFAULT NULL,
  `SecondSubTotal` int(11) DEFAULT NULL,
  `SecondUnit` double DEFAULT NULL,
  `SecondAmount` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dailydata`
--

LOCK TABLES `dailydata` WRITE;
/*!40000 ALTER TABLE `dailydata` DISABLE KEYS */;
/*!40000 ALTER TABLE `dailydata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dailydata_detail`
--

DROP TABLE IF EXISTS `dailydata_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dailydata_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `BusinessDate` varchar(10) DEFAULT NULL,
  `Dancer` varchar(50) DEFAULT NULL,
  `InFlag` char(1) DEFAULT NULL,
  `FirstCount` int(11) DEFAULT NULL,
  `FirstUnit` int(11) DEFAULT NULL,
  `FirstAmount` int(11) DEFAULT NULL,
  `SecondCount` int(11) DEFAULT NULL,
  `SecondUnit` int(11) DEFAULT NULL,
  `SecondAmount` int(11) DEFAULT NULL,
  `FirstInFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dailydata_detail`
--

LOCK TABLES `dailydata_detail` WRITE;
/*!40000 ALTER TABLE `dailydata_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `dailydata_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dancer`
--

DROP TABLE IF EXISTS `dancer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dancer` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `DancerType` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `SecondBonus` double DEFAULT NULL,
  `FirstBonus` double DEFAULT NULL,
  `OtherBonus` double DEFAULT NULL,
  `DancerTeam` varchar(50) DEFAULT NULL,
  `IdNo` varchar(20) DEFAULT NULL,
  `TelNo` varchar(20) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dancer`
--

LOCK TABLES `dancer` WRITE;
/*!40000 ALTER TABLE `dancer` DISABLE KEYS */;
/*!40000 ALTER TABLE `dancer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dancerteam`
--

DROP TABLE IF EXISTS `dancerteam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dancerteam` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `EffectFlag` char(1) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `SecondBonusBase` int(11) DEFAULT NULL,
  `SecondBonus` double DEFAULT NULL,
  `FirstBonus` double DEFAULT NULL,
  `OtherBonus` double DEFAULT NULL,
  `TaxRate` int(11) DEFAULT NULL,
  `CleanCharge` int(11) DEFAULT NULL,
  `DrinkType` varchar(50) DEFAULT NULL,
  `DrinkCharge` int(11) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dancerteam`
--

LOCK TABLES `dancerteam` WRITE;
/*!40000 ALTER TABLE `dancerteam` DISABLE KEYS */;
/*!40000 ALTER TABLE `dancerteam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dataimport`
--

DROP TABLE IF EXISTS `dataimport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataimport` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ImportTable` varchar(50) NOT NULL,
  `DataSource` varchar(100) NOT NULL,
  `Summary` varchar(500) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataimport`
--

LOCK TABLES `dataimport` WRITE;
/*!40000 ALTER TABLE `dataimport` DISABLE KEYS */;
/*!40000 ALTER TABLE `dataimport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deductdata`
--

DROP TABLE IF EXISTS `deductdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deductdata` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  `BusinessDate` varchar(10) DEFAULT NULL,
  `DancerTeam` varchar(50) DEFAULT NULL,
  `Dancer` varchar(50) DEFAULT NULL,
  `DeductType` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `SrcTable` varchar(50) DEFAULT NULL,
  `SrcFlowKey` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deductdata`
--

LOCK TABLES `deductdata` WRITE;
/*!40000 ALTER TABLE `deductdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `deductdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `TransDate` varchar(10) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `VendorId` varchar(50) DEFAULT NULL,
  `VendorName` varchar(100) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(50) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Tax` int(11) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_detail`
--

DROP TABLE IF EXISTS `delivery_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ProductId` varchar(50) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `Unit` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `UnitPrice` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Tax` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_detail`
--

LOCK TABLES `delivery_detail` WRITE;
/*!40000 ALTER TABLE `delivery_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Dept_name` varchar(50) DEFAULT NULL,
  `Parent_id` varchar(50) DEFAULT NULL,
  `Signer_Emp_id` varchar(50) DEFAULT NULL,
  `Dept_code` varchar(50) DEFAULT NULL,
  `CanApprove` char(1) DEFAULT NULL,
  `SubjectControler` varchar(50) DEFAULT NULL,
  `SubDeptFlag` char(1) DEFAULT NULL,
  `EnterpriseNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('99','99','admin','新聚能科技顧問','','admin','Synergytek','','','','');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depreciation`
--

DROP TABLE IF EXISTS `depreciation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depreciation` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `DepreciationDate` varchar(10) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depreciation`
--

LOCK TABLES `depreciation` WRITE;
/*!40000 ALTER TABLE `depreciation` DISABLE KEYS */;
/*!40000 ALTER TABLE `depreciation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depreciation_detail`
--

DROP TABLE IF EXISTS `depreciation_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depreciation_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `AssetNo` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `CanUseYear` int(11) DEFAULT NULL,
  `Term` int(11) DEFAULT NULL,
  `ScrapValue` int(11) DEFAULT NULL,
  `NetAmount` int(11) DEFAULT NULL,
  `DepreciationAmount` int(11) DEFAULT NULL,
  `NewNetAmount` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depreciation_detail`
--

LOCK TABLES `depreciation_detail` WRITE;
/*!40000 ALTER TABLE `depreciation_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `depreciation_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draft`
--

DROP TABLE IF EXISTS `draft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draft` (
  `FlowKey` varchar(50) CHARACTER SET utf8 NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `DeptName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ApplicantName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `DoNotExamine` char(1) DEFAULT NULL,
  `CompanyId` varchar(50) DEFAULT NULL,
  `DeptId` varchar(50) DEFAULT NULL,
  `InventorId` varchar(50) DEFAULT NULL,
  `DraftNo` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `Title` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `OriginalTitle` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `ProjectNo` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ProjectName` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `ProjectFileUrl` varchar(100) DEFAULT NULL,
  `BeginDate` varchar(10) DEFAULT NULL,
  `EndDate` varchar(10) DEFAULT NULL,
  `FinanceDept` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ProjectLeader` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ProjectFlag` char(1) DEFAULT NULL,
  `ProjectRate` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ProjectMemo` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ApplyIndustry` text CHARACTER SET utf8,
  `ApplyProduct` text CHARACTER SET utf8,
  `ApplyCompany` text CHARACTER SET utf8,
  `Shortcoming` text CHARACTER SET utf8,
  `Summary` text CHARACTER SET utf8,
  `EngSummary` text CHARACTER SET utf8,
  `Purpose` text CHARACTER SET utf8,
  `Advantages` text CHARACTER SET utf8,
  `Description` text CHARACTER SET utf8,
  `CloseTime` varchar(20) DEFAULT NULL,
  `CloserName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `PerferredDesc` text CHARACTER SET utf8,
  `Claims` text CHARACTER SET utf8,
  `PreCaseAgent` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `PreCaseDocument` varchar(100) DEFAULT NULL,
  `BonusStatus` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `TechCategory` varchar(50) DEFAULT NULL,
  `IpSuggest` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `CommitTime` int(11) DEFAULT '0',
  `SerialChildCase` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draft`
--

LOCK TABLES `draft` WRITE;
/*!40000 ALTER TABLE `draft` DISABLE KEYS */;
/*!40000 ALTER TABLE `draft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftassignexaminer`
--

DROP TABLE IF EXISTS `draftassignexaminer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftassignexaminer` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `EmpId` varchar(50) DEFAULT NULL,
  `GroupType` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Institution` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Dept` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Central` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Title` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Address` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 5120 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftassignexaminer`
--

LOCK TABLES `draftassignexaminer` WRITE;
/*!40000 ALTER TABLE `draftassignexaminer` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftassignexaminer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftattachment`
--

DROP TABLE IF EXISTS `draftattachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftattachment` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `AttachmentUrl` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `AttachmentDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftattachment`
--

LOCK TABLES `draftattachment` WRITE;
/*!40000 ALTER TABLE `draftattachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftattachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftdocument`
--

DROP TABLE IF EXISTS `draftdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `DocumentType` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `DocumentUrl` varchar(100) DEFAULT NULL,
  `DocumentName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `DocumentDate` varchar(10) DEFAULT NULL,
  `DocumentPublication` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `DocumentArea` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftdocument`
--

LOCK TABLES `draftdocument` WRITE;
/*!40000 ALTER TABLE `draftdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftinventor`
--

DROP TABLE IF EXISTS `draftinventor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftinventor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `InventorId` varchar(50) DEFAULT NULL,
  `InventorOrder` int(11) DEFAULT NULL,
  `ChineseName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `EnglishName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `ContributionShare` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftinventor`
--

LOCK TABLES `draftinventor` WRITE;
/*!40000 ALTER TABLE `draftinventor` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftinventor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftlog`
--

DROP TABLE IF EXISTS `draftlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftlog` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `LogTime` varchar(20) NOT NULL,
  `LogStatus` varchar(50) NOT NULL,
  `Logger` varchar(50) NOT NULL,
  `LogMemo` varchar(500) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftlog`
--

LOCK TABLES `draftlog` WRITE;
/*!40000 ALTER TABLE `draftlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftoffice`
--

DROP TABLE IF EXISTS `draftoffice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftoffice` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentID` varchar(50) DEFAULT NULL,
  `Priority` int(11) DEFAULT NULL,
  `PatentOffice` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Reason` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `PatentCaseNo` varchar(50) DEFAULT NULL,
  `AgentNo` varchar(50) NOT NULL,
  `PatentType` varchar(50) NOT NULL DEFAULT ' ',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftoffice`
--

LOCK TABLES `draftoffice` WRITE;
/*!40000 ALTER TABLE `draftoffice` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftoffice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftpatent`
--

DROP TABLE IF EXISTS `draftpatent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftpatent` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `PatentNo` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `UploadFile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftpatent`
--

LOCK TABLES `draftpatent` WRITE;
/*!40000 ALTER TABLE `draftpatent` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftpatent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftpic`
--

DROP TABLE IF EXISTS `draftpic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftpic` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `PicName` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `PicUrl` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftpic`
--

LOCK TABLES `draftpic` WRITE;
/*!40000 ALTER TABLE `draftpic` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftpic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftrecommend`
--

DROP TABLE IF EXISTS `draftrecommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftrecommend` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `EmpId` varchar(50) DEFAULT NULL,
  `GroupType` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Institution` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Dept` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Central` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Title` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Address` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftrecommend`
--

LOCK TABLES `draftrecommend` WRITE;
/*!40000 ALTER TABLE `draftrecommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftrecommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftreexamine`
--

DROP TABLE IF EXISTS `draftreexamine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftreexamine` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `CreateDate` varchar(10) NOT NULL,
  `NoticeDate` varchar(10) NOT NULL,
  `DeadlineDate` varchar(10) NOT NULL,
  `FinishedDate` varchar(10) NOT NULL,
  `Reviewer` varchar(50) NOT NULL,
  `ReviewerName` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 5120 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftreexamine`
--

LOCK TABLES `draftreexamine` WRITE;
/*!40000 ALTER TABLE `draftreexamine` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftreexamine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draftreexamineoffice`
--

DROP TABLE IF EXISTS `draftreexamineoffice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `draftreexamineoffice` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `OfficeName` varchar(50) NOT NULL,
  `Result` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 5120 kB; InnoDB free: 5120 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draftreexamineoffice`
--

LOCK TABLES `draftreexamineoffice` WRITE;
/*!40000 ALTER TABLE `draftreexamineoffice` DISABLE KEYS */;
/*!40000 ALTER TABLE `draftreexamineoffice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drafttechexamine`
--

DROP TABLE IF EXISTS `drafttechexamine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drafttechexamine` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `CreateDate` varchar(10) NOT NULL,
  `NoticeDate` varchar(10) NOT NULL,
  `DeadlineDate` varchar(10) NOT NULL,
  `FinishedDate` varchar(10) NOT NULL,
  `Reviewer` varchar(50) NOT NULL,
  `ReviewerName` varchar(50) NOT NULL,
  `Utilzation` char(1) NOT NULL,
  `Novelty` char(1) NOT NULL,
  `Advance` char(1) NOT NULL,
  `Suitable` char(1) NOT NULL,
  `ProvenData1` char(1) NOT NULL,
  `ProvenData2` char(1) NOT NULL,
  `ProvenData3` char(1) NOT NULL,
  `ProvenData4` char(1) NOT NULL,
  `UploadFile` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drafttechexamine`
--

LOCK TABLES `drafttechexamine` WRITE;
/*!40000 ALTER TABLE `drafttechexamine` DISABLE KEYS */;
/*!40000 ALTER TABLE `drafttechexamine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drafttechexamineoffice`
--

DROP TABLE IF EXISTS `drafttechexamineoffice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drafttechexamineoffice` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `OfficeName` varchar(50) NOT NULL,
  `Result` varchar(50) NOT NULL,
  `Command` varchar(500) NOT NULL,
  `UploadFile` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 5120 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drafttechexamineoffice`
--

LOCK TABLES `drafttechexamineoffice` WRITE;
/*!40000 ALTER TABLE `drafttechexamineoffice` DISABLE KEYS */;
/*!40000 ALTER TABLE `drafttechexamineoffice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Emp_name` varchar(50) DEFAULT NULL,
  `Id_no` varchar(12) DEFAULT NULL,
  `Dept_id` varchar(50) DEFAULT NULL,
  `Agent_Emp_id` varchar(50) DEFAULT NULL,
  `Tel_no` varchar(50) DEFAULT NULL,
  `Mobile_no` varchar(50) DEFAULT NULL,
  `Extension` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `OnBoard_date` varchar(20) DEFAULT NULL,
  `Leaves_date` varchar(20) DEFAULT NULL,
  `Birthday` varchar(10) DEFAULT NULL,
  `Job_Degree` varchar(50) DEFAULT NULL,
  `Salary_Point` varchar(50) DEFAULT NULL,
  `HourlyCharge` varchar(50) DEFAULT NULL,
  `Bracket1` int(4) DEFAULT '0',
  `Bracket2` int(4) DEFAULT '0',
  `Bracket3` int(4) DEFAULT '0',
  `Weighting1` double(5,2) DEFAULT '0.00',
  `Weighting2` double(5,2) DEFAULT '0.00',
  `RatedPoints` int(10) DEFAULT NULL,
  `TechGroup` varchar(50) DEFAULT NULL,
  `JobTitleRole` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('20170828','99','admin','20170828','','20170828','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('20170828-1','99','admin','20170828-1','','20170828-1','','','','','','','JA08','','','','','','',0,0,0,0.00,0.00,0,'',''),('admin','99','admin','系統管理者','','99','','','','','','','99','','','','','D01','HC20140604.001',0,0,0,0.00,0.00,0,'TechGroup04','R03'),('BL01','99','admin','白鯨01','','BL','','','','','','','JA08','','','','','D02','HC20140604.002',0,0,0,0.00,0.00,0,'',''),('DF01','99','admin','DF01','','DF','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('DF02','99','admin','DF02','','DF','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('DP01','99','admin','博士01','','DP','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('DP02','99','admin','博士02','','DP','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('Employee01','99','admin','Employee01','','Test01','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('Employee0101','99','admin','Employee0101','','Test0101','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('FM','99','admin','法瑪南強','','FM','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('GT01','99','admin','鉅鼎01','','GT','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('GT02','99','admin','鉅鼎02','','GT','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('HH01','99','admin','漢法01','','HH','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('HH02','99','admin','漢法02','','HH','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('HX','99','admin','和信','','HX','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('JH','99','admin','照華','','JH','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('John KIM','99','test','金英浩','','IPW-Engineer','','','','','','','JA12','','','','','','',0,0,0,0.00,0.00,0,'',''),('KS','99','admin','誠祐','','KS','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('KSP01','99','admin','凱博荷盛01','','KSP','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('KSP02','99','admin','凱博荷盛02','','KSP','','','','','','','JA09','','','','','','',0,0,0,0.00,0.00,0,'',''),('longriver01','99','admin','長江01','','PTL','','','','','','','JA07','','','','','D04','HC20191113.002',0,0,0,0.00,0.00,0,'','R03'),('longriver02','99','admin','財務一','','PTL','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('longriver03','99','admin','財務二','','PTL','','','','','','','JA09','','','','','','',0,0,0,0.00,0.00,0,'',''),('longriver04','99','admin','長江四','','PTL','','','','','','','JA09','','','','','','',0,0,0,0.00,0.00,0,'',''),('marx','99','admin','marx','','marx','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('mission','99','admin','亞信','','Demo3','','','','','','','JA13','','','','','','',0,0,0,0.00,0.00,0,'',''),('ML','99','admin','萬宏','','ML','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('PT01','99','admin','測試','','PT','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('RL','99','admin','任遠','','L','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('RYIP','99','admin','榮裕','','PT','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('steven','99','admin','steven','','L','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('SW01','99','admin','SW01','','SW','','','','','','','JA07','','','','J_D01','D01','HC20141212.001',0,0,0,0.00,0.00,0,'','R01'),('SW02','99','admin','SW02','','SW','','','','','','','JA07','','','','J_D01','D01','HC20140604.001',0,0,0,0.00,0.00,0,'','R01'),('TCL','99','admin','TCL','','TCL','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('test1','99','admin','test1','','Demo','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('test2','99','admin','test2','','Demo2','','','','','','慶辰','JA01','','','','','','',0,0,0,0.00,0.00,0,'',''),('test3','99','admin','test3','','Demo2','','','','','','慶辰','JA08','','','','','','',0,0,0,0.00,0.00,0,'',''),('test4','99','admin','test4','','Demo2','','','','','','慶辰','JA05','','','','','','',0,0,0,0.00,0.00,0,'',''),('test5','99','admin','test5','','Demo','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('test6','99','admin','test6','','99','','','','','','','JA03','','','','','','',0,0,0,0.00,0.00,0,'',''),('test7','99','admin','test7','','Demo2','','','','','','','JA03','','','','','','',0,0,0,0.00,0.00,0,'',''),('test8','99','admin','test8','','Test','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('TPFM','99','admin','台北法瑪','','PT','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('yang','99','admin','yang','','Demo3','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('yd','99','admin','育德','','Demo','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('yuso01','99','admin','宇州01','','yuso','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('yuso02','99','admin','宇州02','','yuso','','','','','','','JA07','','','','','','',0,0,0,0.00,0.00,0,'',''),('yuso03','99','admin','宇州03','','yuso','','','','','','','JA13','','','','','','',0,0,0,0.00,0.00,0,'','');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errorreport`
--

DROP TABLE IF EXISTS `errorreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `errorreport` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyTime` varchar(20) DEFAULT NULL,
  `ErrorType` varchar(50) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  `Suggest` varchar(255) DEFAULT NULL,
  `Response` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errorreport`
--

LOCK TABLES `errorreport` WRITE;
/*!40000 ALTER TABLE `errorreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `errorreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expendable`
--

DROP TABLE IF EXISTS `expendable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expendable` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(255) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `SrcDepartment` varchar(50) DEFAULT NULL,
  `SrcApplicant` varchar(50) DEFAULT NULL,
  `SubjectControler` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `VoucherNo` varchar(50) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `AccountingDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expendable`
--

LOCK TABLES `expendable` WRITE;
/*!40000 ALTER TABLE `expendable` DISABLE KEYS */;
/*!40000 ALTER TABLE `expendable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expendable_detail`
--

DROP TABLE IF EXISTS `expendable_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expendable_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ExpendableNo` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `ExpendableCode` varchar(50) DEFAULT NULL,
  `Unit` varchar(20) DEFAULT NULL,
  `Qty` double DEFAULT NULL,
  `UnitAmount` double DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Vendor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expendable_detail`
--

LOCK TABLES `expendable_detail` WRITE;
/*!40000 ALTER TABLE `expendable_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `expendable_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expendableapply`
--

DROP TABLE IF EXISTS `expendableapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expendableapply` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `GoodsApplyDate` varchar(10) DEFAULT NULL,
  `Reason` varchar(200) DEFAULT NULL,
  `WorkPlan` varchar(200) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expendableapply`
--

LOCK TABLES `expendableapply` WRITE;
/*!40000 ALTER TABLE `expendableapply` DISABLE KEYS */;
/*!40000 ALTER TABLE `expendableapply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expendableapply_detail`
--

DROP TABLE IF EXISTS `expendableapply_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expendableapply_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ExpendableCode` varchar(50) DEFAULT NULL,
  `ExpendableNo` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `Unit` varchar(20) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `UnitAmount` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expendableapply_detail`
--

LOCK TABLES `expendableapply_detail` WRITE;
/*!40000 ALTER TABLE `expendableapply_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `expendableapply_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exportcvsrecord`
--

DROP TABLE IF EXISTS `exportcvsrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exportcvsrecord` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ExportSql` varchar(1000) NOT NULL,
  `ExportDateTime` varchar(20) NOT NULL,
  `ExportProgram` varchar(50) NOT NULL,
  `ExportFile` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exportcvsrecord`
--

LOCK TABLES `exportcvsrecord` WRITE;
/*!40000 ALTER TABLE `exportcvsrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `exportcvsrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filemanage`
--

DROP TABLE IF EXISTS `filemanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filemanage` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `BorroeDate` varchar(50) DEFAULT NULL,
  `Borrower` varchar(50) DEFAULT NULL,
  `BorrowDept` varchar(50) DEFAULT NULL,
  `FileNo` varchar(50) DEFAULT NULL,
  `ReturnDate` varchar(50) DEFAULT NULL,
  `BorrowStatus` varchar(50) DEFAULT NULL,
  `Note` varchar(600) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filemanage`
--

LOCK TABLES `filemanage` WRITE;
/*!40000 ALTER TABLE `filemanage` DISABLE KEYS */;
/*!40000 ALTER TABLE `filemanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flow`
--

DROP TABLE IF EXISTS `flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flow` (
  `FlowKey` varchar(50) NOT NULL,
  `Creater_id` varchar(50) DEFAULT NULL,
  `Creater_name` varchar(50) DEFAULT NULL,
  `Applicant_id` varchar(50) DEFAULT NULL,
  `Applicant_name` varchar(50) DEFAULT NULL,
  `Create_time` varchar(20) DEFAULT NULL,
  `Flow_id` varchar(50) DEFAULT NULL,
  `Flow_name` varchar(255) DEFAULT NULL,
  `Signer_id` varchar(50) DEFAULT NULL,
  `Signer_name` varchar(50) DEFAULT NULL,
  `Decider_id` varchar(50) DEFAULT NULL,
  `Decider_name` varchar(50) DEFAULT NULL,
  `Decide_time` varchar(50) DEFAULT NULL,
  `Closer_id` varchar(20) DEFAULT NULL,
  `Closer_name` varchar(50) DEFAULT NULL,
  `Closed_time` varchar(20) DEFAULT NULL,
  `Total_steps` int(11) DEFAULT NULL,
  `Finished_steps` int(11) DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL,
  `Form_tableName` varchar(50) DEFAULT NULL,
  `SrcSigner_id` varchar(50) DEFAULT NULL,
  `CloseFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow`
--

LOCK TABLES `flow` WRITE;
/*!40000 ALTER TABLE `flow` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flow_detail`
--

DROP TABLE IF EXISTS `flow_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flow_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `Step` int(11) DEFAULT NULL,
  `Step_name` varchar(50) DEFAULT NULL,
  `Signer_id` varchar(50) DEFAULT NULL,
  `Signer_name` varchar(50) DEFAULT NULL,
  `Signer_title` varchar(50) DEFAULT NULL,
  `Signer_department` varchar(50) DEFAULT NULL,
  `Signed_time` varchar(50) DEFAULT NULL,
  `Signed_result` varchar(50) DEFAULT NULL,
  `Decided` char(1) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow_detail`
--

LOCK TABLES `flow_detail` WRITE;
/*!40000 ALTER TABLE `flow_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsapply`
--

DROP TABLE IF EXISTS `goodsapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodsapply` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplicantName` varchar(50) DEFAULT NULL,
  `ApplicantJobName` varchar(50) DEFAULT NULL,
  `ApplyDeptName` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(20) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `ApplyType` varchar(50) DEFAULT NULL,
  `BudgetControler` varchar(50) DEFAULT NULL,
  `DeptSigner1` varchar(50) DEFAULT NULL,
  `DeptSigner2` varchar(50) DEFAULT NULL,
  `Helper` varchar(50) DEFAULT NULL,
  `PurchaseMan` varchar(50) DEFAULT NULL,
  `InfosSponsor` varchar(50) DEFAULT NULL,
  `SubjectControler1` varchar(50) DEFAULT NULL,
  `SubjectControler2` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `BudgetAmount` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `BudgetDate` varchar(10) DEFAULT NULL,
  `NeedDate` varchar(10) DEFAULT NULL,
  `Reason` varchar(200) DEFAULT NULL,
  `CrossCheck` char(1) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  `Vendor` varchar(200) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `AssetNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsapply`
--

LOCK TABLES `goodsapply` WRITE;
/*!40000 ALTER TABLE `goodsapply` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsapply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsapply_detail`
--

DROP TABLE IF EXISTS `goodsapply_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodsapply_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `GoodsName` varchar(200) DEFAULT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  `Unit` varchar(10) DEFAULT NULL,
  `Qty` double DEFAULT NULL,
  `UnitPrice` double DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `ElectricPay` char(1) DEFAULT NULL,
  `Protection` char(1) DEFAULT NULL,
  `Vendor` varchar(100) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `QuotationUrl` varchar(100) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsapply_detail`
--

LOCK TABLES `goodsapply_detail` WRITE;
/*!40000 ALTER TABLE `goodsapply_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsapply_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `FlowKey` varchar(50) NOT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `Leader` varchar(20) DEFAULT NULL,
  `DateFrom` varchar(20) DEFAULT NULL,
  `DateTo` varchar(20) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES ('admin','系統管理群組','admin','2006-04-01','2100-12-31','admin','99'),('G01','程序人員','admin','2010-01-01','2100-12-31','admin','Demo'),('G02','財務群組','admin','2014-01-01','2100-12-31','admin','99'),('G03','報價核可者','admin','2014-01-01','2100-12-31','admin','99'),('G090','簽核人選單','admin','2017-06-19','2100-12-31','admin','99'),('G091','結束簽核權限','admin','2017-06-19','2100-12-31','admin','99');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_detail`
--

DROP TABLE IF EXISTS `groups_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `Emp_id` varchar(50) DEFAULT NULL,
  `JobTitle` varchar(50) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_detail`
--

LOCK TABLES `groups_detail` WRITE;
/*!40000 ALTER TABLE `groups_detail` DISABLE KEYS */;
INSERT INTO `groups_detail` VALUES ('admin',1,'admin','JT01','2000-01-01','2100-12-31'),('G01',1,'admin','JT01','2013-01-01','2100-12-31'),('G02',1,'admin','JT01','2014-01-01','2100-12-31'),('G03',1,'admin','JT01','2014-01-01','2100-12-31'),('G090',1,'admin','JT01','2017-06-19','2100-12-31');
/*!40000 ALTER TABLE `groups_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guaranty`
--

DROP TABLE IF EXISTS `guaranty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guaranty` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `ProNo` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InDate` varchar(50) DEFAULT NULL,
  `OutDate` varchar(50) DEFAULT NULL,
  `GuarantyType` varchar(50) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` double(14,2) DEFAULT '0.00',
  `ExchangeRate` double(14,4) DEFAULT '0.0000',
  `NTAmount` int(10) DEFAULT '0',
  `Note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guaranty`
--

LOCK TABLES `guaranty` WRITE;
/*!40000 ALTER TABLE `guaranty` DISABLE KEYS */;
/*!40000 ALTER TABLE `guaranty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hourlycharge`
--

DROP TABLE IF EXISTS `hourlycharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hourlycharge` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `SalaryPoint` varchar(50) NOT NULL,
  `HourlyRate` varchar(10) NOT NULL,
  `Currency` varchar(50) NOT NULL,
  `Command` varchar(200) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hourlycharge`
--

LOCK TABLES `hourlycharge` WRITE;
/*!40000 ALTER TABLE `hourlycharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `hourlycharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `importdeductdata`
--

DROP TABLE IF EXISTS `importdeductdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `importdeductdata` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  `FileUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importdeductdata`
--

LOCK TABLES `importdeductdata` WRITE;
/*!40000 ALTER TABLE `importdeductdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `importdeductdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventors`
--

DROP TABLE IF EXISTS `inventors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventors` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Company` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `EnglishLastName` varchar(50) DEFAULT NULL,
  `EnglishFirstName` varchar(50) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnglishAddress` varchar(200) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Appendix` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventors`
--

LOCK TABLES `inventors` WRITE;
/*!40000 ALTER TABLE `inventors` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `ClientName` varchar(100) DEFAULT NULL,
  `InvoiceType` varchar(50) DEFAULT NULL,
  `PaymentTerm` varchar(50) DEFAULT NULL,
  `AttorneyTitle` varchar(50) DEFAULT NULL,
  `InvoiceTitle` varchar(500) DEFAULT NULL,
  `InvoiceDate` varchar(10) DEFAULT NULL,
  `ArDate` varchar(10) DEFAULT NULL,
  `TotalTax` int(16) DEFAULT '0',
  `TotalTax2` int(16) DEFAULT '0',
  `TotalRequestPayNtdAmount` int(11) DEFAULT '0',
  `TotalWriteOffAmount` int(11) DEFAULT '0',
  `TotalDiscountAmount` int(11) DEFAULT '0',
  `Title` varchar(500) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `SubType` varchar(50) DEFAULT NULL,
  `ServiceFee` int(16) DEFAULT '0',
  `GovFee` int(12) DEFAULT '0',
  `ApplyNo` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(50) DEFAULT NULL,
  `Matter` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `VoucherDate` varchar(10) DEFAULT NULL,
  `BillDate` varchar(10) DEFAULT NULL,
  `Note` varchar(500) DEFAULT NULL,
  `TaskDescription` varchar(500) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `InvoiceStatus` varchar(50) DEFAULT NULL,
  `TotalAmountDeductTTax2` int(11) DEFAULT '0',
  `ServiceFeeDeductTTax2` int(11) DEFAULT '0',
  `TaskCreator` varchar(50) DEFAULT NULL,
  `TrademarkClassification` varchar(500) DEFAULT NULL,
  `RegisterNo` varchar(50) DEFAULT NULL,
  `TotalUntaxedAmount` int(16) DEFAULT '0',
  `InvoiceMonth` varchar(50) DEFAULT NULL,
  `FreeServiceNumberOfMonth` float(16,1) DEFAULT NULL,
  `TwdHourlyCharge` int(16) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `RegisteredNo` varchar(50) DEFAULT NULL,
  `InvoiceNumber` varchar(50) DEFAULT NULL,
  `ReceiptNumber` varchar(50) DEFAULT NULL,
  `TwdDeductionAmount` int(11) DEFAULT NULL,
  `TotalAmountAfterDiscount` int(11) DEFAULT NULL,
  `TimesheetMerge` varchar(1) DEFAULT NULL,
  `MultiTodos` varchar(1) DEFAULT NULL,
  `AttorneyFeeNtd` int(11) DEFAULT '0',
  `IndependentClaim` int(11) DEFAULT '0',
  `DependentClaim` int(11) DEFAULT '0',
  `GovFeeAmount` double(16,2) DEFAULT '0.00',
  `ServiceFeeAmount` double(16,2) DEFAULT '0.00',
  `AttorneyFee` double(16,2) DEFAULT '0.00',
  `BillingContact` varchar(200) DEFAULT NULL,
  `CaseClient` varchar(400) DEFAULT NULL,
  `AssignedTo` varchar(50) DEFAULT NULL,
  `Title2` varchar(50) DEFAULT NULL,
  `SoKey` varchar(50) DEFAULT NULL,
  `AmountReceipts` double(16,2) DEFAULT '0.00',
  `AmountReceivable` double(16,2) DEFAULT '0.00',
  `TotalIncludeTaxAmount` double(16,2) DEFAULT '0.00',
  `TotalNotIncludeTaxAmount` double(16,2) DEFAULT '0.00',
  `CaseNo2` varchar(50) DEFAULT NULL,
  `AttorneyBillNo` varchar(200) DEFAULT NULL,
  `AccountReceivableDay` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_miscfee`
--

DROP TABLE IF EXISTS `invoice_miscfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_miscfee` (
  `invoice_flowkey` varchar(50) NOT NULL,
  `miscfee_flowkey` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_miscfee`
--

LOCK TABLES `invoice_miscfee` WRITE;
/*!40000 ALTER TABLE `invoice_miscfee` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_miscfee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_timesheet`
--

DROP TABLE IF EXISTS `invoice_timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_timesheet` (
  `invoice_flowkey` varchar(50) NOT NULL,
  `timesheet_flowkey` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_timesheet`
--

LOCK TABLES `invoice_timesheet` WRITE;
/*!40000 ALTER TABLE `invoice_timesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoicedetail`
--

DROP TABLE IF EXISTS `invoicedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoicedetail` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `TodosId` varchar(50) DEFAULT NULL,
  `RequestPay` int(11) DEFAULT '0',
  `TaxCheck` varchar(1) DEFAULT NULL,
  `Tax` int(16) DEFAULT '0',
  `Tax2Check` varchar(1) DEFAULT NULL,
  `Tax2` int(16) DEFAULT '0',
  `InclTaxNtdAmount` int(11) DEFAULT '0',
  `Withholding` varchar(1) DEFAULT NULL,
  `DiscountAmount` int(16) DEFAULT '0',
  `AlreadyWriteOffAmount` int(16) DEFAULT '0',
  `NotYetWriteOff` int(11) DEFAULT '0',
  `WriteOffRecode` varchar(1000) DEFAULT NULL,
  `TaskDescription` varchar(600) DEFAULT NULL,
  `InvoiceCurrency` varchar(50) DEFAULT NULL,
  `InvoiceExchangeRate` decimal(16,6) DEFAULT '0.000000',
  `InvoiceAmount` float(16,2) DEFAULT '0.00',
  `UntaxedAmount` int(16) DEFAULT '0',
  `Memo` varchar(150) DEFAULT NULL,
  `Points` double(16,2) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` double(16,4) DEFAULT NULL,
  `ExchangeRate` double(16,4) DEFAULT NULL,
  `TwdAmount` int(12) DEFAULT '0',
  `NotYetRequestPayAmount` int(12) DEFAULT '0',
  `RequestPayAmount` int(12) DEFAULT '0',
  `TaxInclude` varchar(1) DEFAULT 'Y',
  `SoDetailFk` varchar(50) DEFAULT NULL,
  `TaxType` varchar(50) DEFAULT NULL,
  `TaxAmount` float(16,2) DEFAULT '0.00',
  `NotIncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `IncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `TodosTitle` varchar(600) DEFAULT NULL,
  `UnitPrice` double(10,2) DEFAULT '0.00',
  `Quantity` int(5) DEFAULT '1',
  `Unit` varchar(50) DEFAULT NULL,
  `ChineseDescription` varchar(600) DEFAULT NULL,
  `Miscellaneous` double(10,2) DEFAULT '0.00',
  `detailorder` int(11) DEFAULT '99',
  `MulitType2` int(1) DEFAULT '1',
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoicedetail`
--

LOCK TABLES `invoicedetail` WRITE;
/*!40000 ALTER TABLE `invoicedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoicedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invtitle`
--

DROP TABLE IF EXISTS `invtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invtitle` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `InvoiceTitle` varchar(100) DEFAULT NULL,
  `RegisteredNo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invtitle`
--

LOCK TABLES `invtitle` WRITE;
/*!40000 ALTER TABLE `invtitle` DISABLE KEYS */;
/*!40000 ALTER TABLE `invtitle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobagent`
--

DROP TABLE IF EXISTS `jobagent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobagent` (
  `FlowKey` varchar(50) NOT NULL,
  `Emp_id` varchar(20) DEFAULT NULL,
  `Agent` varchar(20) DEFAULT NULL,
  `TimeFrom` varchar(20) DEFAULT NULL,
  `TimeTo` varchar(20) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobagent`
--

LOCK TABLES `jobagent` WRITE;
/*!40000 ALTER TABLE `jobagent` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobagent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobtype`
--

DROP TABLE IF EXISTS `jobtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobtype` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ForInv` varchar(50) DEFAULT NULL,
  `CNName` varchar(100) DEFAULT NULL,
  `ENName` varchar(100) DEFAULT NULL,
  `JPName` varchar(100) DEFAULT NULL,
  `KRName` varchar(100) DEFAULT NULL,
  `Activation` varchar(50) DEFAULT NULL,
  `Role` varchar(500) DEFAULT NULL,
  `Note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobtype`
--

LOCK TABLES `jobtype` WRITE;
/*!40000 ALTER TABLE `jobtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave`
--

DROP TABLE IF EXISTS `leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Agent` varchar(50) DEFAULT NULL,
  `LeaveType` varchar(50) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `DateFrom` varchar(20) DEFAULT NULL,
  `DateTo` varchar(20) DEFAULT NULL,
  `Day` int(11) DEFAULT NULL,
  `Hour` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave`
--

LOCK TABLES `leave` WRITE;
/*!40000 ALTER TABLE `leave` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalapplicant`
--

DROP TABLE IF EXISTS `legalapplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalapplicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ApplicantOrder` varchar(50) DEFAULT NULL,
  `ApplicantId` varchar(50) DEFAULT NULL,
  `ApplicantName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalapplicant`
--

LOCK TABLES `legalapplicant` WRITE;
/*!40000 ALTER TABLE `legalapplicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalapplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalattorney`
--

DROP TABLE IF EXISTS `legalattorney`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalattorney` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `AttorneyType` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `AttorneyName` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalattorney`
--

LOCK TABLES `legalattorney` WRITE;
/*!40000 ALTER TABLE `legalattorney` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalattorney` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalcase`
--

DROP TABLE IF EXISTS `legalcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalcase` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `MainType` varchar(50) NOT NULL,
  `SubType` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Priority` varchar(50) NOT NULL,
  `TargetStartDate` varchar(10) NOT NULL,
  `RealStartDate` varchar(10) NOT NULL,
  `TargetFinishDate` varchar(10) NOT NULL,
  `RealFinishDate` varchar(10) NOT NULL,
  `TmpField_01` varchar(50) NOT NULL,
  `TmpField_02` varchar(50) NOT NULL,
  `TmpField_03` varchar(50) NOT NULL,
  `TmpField_04` varchar(50) NOT NULL,
  `TmpField_05` varchar(50) NOT NULL,
  `TmpField_06` varchar(50) NOT NULL,
  `TmpField_07` varchar(50) NOT NULL,
  `TmpField_08` varchar(50) NOT NULL,
  `TmpField_09` varchar(50) NOT NULL,
  `TmpField_10` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `Memo` text,
  `OtherLFirm` varchar(50) DEFAULT NULL,
  `OtherLawyer` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `AttorneyNum` varchar(50) DEFAULT NULL,
  `CaseOpenfile` varchar(200) DEFAULT NULL,
  `EnglishTitle` varchar(500) DEFAULT NULL,
  `CaseAssignedTo` varchar(50) DEFAULT NULL,
  `CloseDate` varchar(50) DEFAULT NULL,
  `FiledDate` varchar(50) DEFAULT NULL,
  `IncludeMisc` varchar(50) DEFAULT NULL,
  `PaymentKind` varchar(50) DEFAULT NULL,
  `ContactDate` varchar(50) DEFAULT NULL,
  `Referrals` varchar(50) DEFAULT NULL,
  `CaseStartDate` varchar(10) DEFAULT NULL,
  `CaseEndDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalcase`
--

LOCK TABLES `legalcase` WRITE;
/*!40000 ALTER TABLE `legalcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalcase_2`
--

DROP TABLE IF EXISTS `legalcase_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalcase_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `MainType` varchar(50) NOT NULL,
  `SubType` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Priority` varchar(50) NOT NULL,
  `TargetStartDate` varchar(10) NOT NULL,
  `RealStartDate` varchar(10) NOT NULL,
  `TargetFinishDate` varchar(10) NOT NULL,
  `RealFinishDate` varchar(10) NOT NULL,
  `TmpField_01` varchar(50) NOT NULL,
  `TmpField_02` varchar(50) NOT NULL,
  `TmpField_03` varchar(50) NOT NULL,
  `TmpField_04` varchar(50) NOT NULL,
  `TmpField_05` varchar(50) NOT NULL,
  `TmpField_06` varchar(50) NOT NULL,
  `TmpField_07` varchar(50) NOT NULL,
  `TmpField_08` varchar(50) NOT NULL,
  `TmpField_09` varchar(50) NOT NULL,
  `TmpField_10` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `Memo` text,
  `OtherLFirm` varchar(50) DEFAULT NULL,
  `OtherLawyer` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalcase_2`
--

LOCK TABLES `legalcase_2` WRITE;
/*!40000 ALTER TABLE `legalcase_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalcase_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalcolleagues`
--

DROP TABLE IF EXISTS `legalcolleagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalcolleagues` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `EmpId` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Memo` varchar(500) NOT NULL,
  `Job_Degree` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `HourlyRate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalcolleagues`
--

LOCK TABLES `legalcolleagues` WRITE;
/*!40000 ALTER TABLE `legalcolleagues` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalcolleagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legaldocument`
--

DROP TABLE IF EXISTS `legaldocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legaldocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `DocumentType` varchar(50) NOT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) NOT NULL,
  `DocumentNo` varchar(50) NOT NULL,
  `DocumentKind` varchar(50) NOT NULL,
  `DocumentDate` varchar(10) NOT NULL,
  `DocumentTarget` varchar(50) NOT NULL,
  `DocumentProcess` varchar(50) NOT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(100) DEFAULT NULL,
  `AttachmentName2` varchar(100) DEFAULT NULL,
  `AttachmentName3` varchar(100) DEFAULT NULL,
  `AttachmentName4` varchar(100) DEFAULT NULL,
  `AttachmentName5` varchar(100) DEFAULT NULL,
  `AttachmentName6` varchar(100) DEFAULT NULL,
  `AttachmentName7` varchar(100) DEFAULT NULL,
  `AttachmentName8` varchar(100) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legaldocument`
--

LOCK TABLES `legaldocument` WRITE;
/*!40000 ALTER TABLE `legaldocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `legaldocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalopponent`
--

DROP TABLE IF EXISTS `legalopponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalopponent` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `OpponentOrder` varchar(50) DEFAULT NULL,
  `OpponentId` varchar(50) DEFAULT NULL,
  `OpponentName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalopponent`
--

LOCK TABLES `legalopponent` WRITE;
/*!40000 ALTER TABLE `legalopponent` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalopponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalpriority`
--

DROP TABLE IF EXISTS `legalpriority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalpriority` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `PriorityDate` varchar(10) NOT NULL,
  `ApplyNo` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `Document` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalpriority`
--

LOCK TABLES `legalpriority` WRITE;
/*!40000 ALTER TABLE `legalpriority` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalpriority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalrelative`
--

DROP TABLE IF EXISTS `legalrelative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalrelative` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `RelativeOrder` varchar(50) DEFAULT NULL,
  `RelativeId` varchar(50) DEFAULT NULL,
  `RelativeName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalrelative`
--

LOCK TABLES `legalrelative` WRITE;
/*!40000 ALTER TABLE `legalrelative` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalrelative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalsitting`
--

DROP TABLE IF EXISTS `legalsitting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalsitting` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TrialNoYear` varchar(50) DEFAULT NULL,
  `TrialNoW` varchar(50) DEFAULT NULL,
  `TrialNo` varchar(50) DEFAULT NULL,
  `TrialTime` varchar(20) DEFAULT NULL,
  `GroupNo` varchar(50) DEFAULT NULL,
  `Court` varchar(50) DEFAULT NULL,
  `CourtType` varchar(50) DEFAULT NULL,
  `AppointedLawyer` varchar(50) DEFAULT NULL,
  `CourtName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalsitting`
--

LOCK TABLES `legalsitting` WRITE;
/*!40000 ALTER TABLE `legalsitting` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalsitting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginfo`
--

DROP TABLE IF EXISTS `loginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginfo` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateTable` varchar(50) DEFAULT NULL,
  `SrcFlowKey` varchar(50) DEFAULT NULL,
  `UpdateUserId` varchar(50) DEFAULT NULL,
  `UpdateUserName` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Action` varchar(20) DEFAULT NULL,
  `ActionInfo` varchar(4000) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `ToDosTitle` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginfo`
--

LOCK TABLES `loginfo` WRITE;
/*!40000 ALTER TABLE `loginfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `loginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lossreport`
--

DROP TABLE IF EXISTS `lossreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lossreport` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `LossDate` varchar(10) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `ProductNo` varchar(50) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lossreport`
--

LOCK TABLES `lossreport` WRITE;
/*!40000 ALTER TABLE `lossreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `lossreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maillog`
--

DROP TABLE IF EXISTS `maillog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maillog` (
  `KeyValue` varchar(50) NOT NULL,
  `KeepLogAmount` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`KeyValue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maillog`
--

LOCK TABLES `maillog` WRITE;
/*!40000 ALTER TABLE `maillog` DISABLE KEYS */;
/*!40000 ALTER TABLE `maillog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maillog_detail`
--

DROP TABLE IF EXISTS `maillog_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maillog_detail` (
  `KeyValue` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `LogDetail` longtext,
  PRIMARY KEY (`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maillog_detail`
--

LOCK TABLES `maillog_detail` WRITE;
/*!40000 ALTER TABLE `maillog_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `maillog_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailmanager`
--

DROP TABLE IF EXISTS `mailmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailmanager` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `MailLink` varchar(100) DEFAULT NULL,
  `CreatorCheck` varchar(1) DEFAULT NULL,
  `AssignToCheck` varchar(1) DEFAULT NULL,
  `SupervisorCheck` varchar(1) DEFAULT NULL,
  `GroupSendCheck` varchar(1) DEFAULT NULL,
  `AlertDateSend` varchar(1) DEFAULT NULL,
  `AlertMon` varchar(1) DEFAULT NULL,
  `AlertTue` varchar(1) DEFAULT NULL,
  `AlertWed` varchar(1) DEFAULT NULL,
  `AlertThu` varchar(1) DEFAULT NULL,
  `AlertFri` varchar(1) DEFAULT NULL,
  `AlertSat` varchar(1) DEFAULT NULL,
  `AlertSun` varchar(1) DEFAULT NULL,
  `MailClearMonth` int(11) DEFAULT '0',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailmanager`
--

LOCK TABLES `mailmanager` WRITE;
/*!40000 ALTER TABLE `mailmanager` DISABLE KEYS */;
INSERT INTO `mailmanager` VALUES ('MailManager','99','admin','http://demo.synergytek.com.tw:8080/HH/Home.jsp','Y','Y','','','Y','','','','','','','',1);
/*!40000 ALTER TABLE `mailmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailthreadconfig`
--

DROP TABLE IF EXISTS `mailthreadconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailthreadconfig` (
  `KeyValue` varchar(50) NOT NULL,
  `ExecuteStatus` varchar(10) DEFAULT NULL,
  `LastExecuteTime` varchar(20) DEFAULT NULL,
  `NextExecuteTime` varchar(20) DEFAULT NULL,
  `DelayTime` varchar(20) DEFAULT NULL,
  `MailPeriod` varchar(20) DEFAULT NULL,
  `Host` varchar(50) DEFAULT NULL,
  `EmailAddress` varchar(100) DEFAULT NULL,
  `EmailAccount` varchar(50) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Authority` varchar(10) DEFAULT NULL,
  `TurnOn` varchar(10) DEFAULT NULL,
  `TestAddress` varchar(100) DEFAULT NULL,
  `SecurityType` varchar(10) DEFAULT NULL,
  `SmtpPort` int(11) DEFAULT '25',
  `Exchange` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`KeyValue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailthreadconfig`
--

LOCK TABLES `mailthreadconfig` WRITE;
/*!40000 ALTER TABLE `mailthreadconfig` DISABLE KEYS */;
INSERT INTO `mailthreadconfig` VALUES ('adsl.savecom.net.tw.001','','2015-11-12 09:45:22','2015-11-12 10:45:22','','60','61.63.128.100','test','jeremy.lee@sysmaintain.com.tw','','','','jeremy.lee@sysmaintain.com.tw','',25,'');
/*!40000 ALTER TABLE `mailthreadconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailthreadconfig_detail`
--

DROP TABLE IF EXISTS `mailthreadconfig_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailthreadconfig_detail` (
  `KeyValue` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `SourceTableName` varchar(50) DEFAULT NULL,
  `PKey` varchar(50) NOT NULL DEFAULT '',
  `MailTo` varchar(255) DEFAULT NULL,
  `CCTo` varchar(255) DEFAULT NULL,
  `BCCTo` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Content` longtext,
  `AttachFile` varchar(255) DEFAULT NULL,
  `MailTime` varchar(20) DEFAULT NULL,
  `Scheduled` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailthreadconfig_detail`
--

LOCK TABLES `mailthreadconfig_detail` WRITE;
/*!40000 ALTER TABLE `mailthreadconfig_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `mailthreadconfig_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makebalance`
--

DROP TABLE IF EXISTS `makebalance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `makebalance` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makebalance`
--

LOCK TABLES `makebalance` WRITE;
/*!40000 ALTER TABLE `makebalance` DISABLE KEYS */;
/*!40000 ALTER TABLE `makebalance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makebalance_detail`
--

DROP TABLE IF EXISTS `makebalance_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `makebalance_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `DancerTeam` varchar(50) DEFAULT NULL,
  `OtherCumulative` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makebalance_detail`
--

LOCK TABLES `makebalance_detail` WRITE;
/*!40000 ALTER TABLE `makebalance_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `makebalance_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miscfee`
--

DROP TABLE IF EXISTS `miscfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miscfee` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateDate` varchar(50) DEFAULT NULL,
  `EmpId` varchar(50) NOT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `ProNo` varchar(50) DEFAULT NULL,
  `MiscFeeType` varchar(50) DEFAULT NULL,
  `MiscFeesSubType` varchar(50) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `MailType` varchar(50) DEFAULT NULL,
  `Receiver` varchar(50) DEFAULT NULL,
  `TrackingNo` varchar(50) DEFAULT NULL,
  `FaxNo` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Size` varchar(50) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `Quantity` int(10) DEFAULT NULL,
  `UnitPrice` int(10) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` double(14,2) DEFAULT NULL,
  `ExchangeRate` double(14,4) DEFAULT NULL,
  `NTAmount` int(10) DEFAULT NULL,
  `InvStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miscfee`
--

LOCK TABLES `miscfee` WRITE;
/*!40000 ALTER TABLE `miscfee` DISABLE KEYS */;
/*!40000 ALTER TABLE `miscfee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modifygoodsapply`
--

DROP TABLE IF EXISTS `modifygoodsapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modifygoodsapply` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `SrcFlowKey` varchar(50) DEFAULT NULL,
  `SrcSummary` varchar(255) DEFAULT NULL,
  `SrcAccountingYear` varchar(50) DEFAULT NULL,
  `SrcWorkPlan` varchar(50) DEFAULT NULL,
  `SrcSubject` varchar(50) DEFAULT NULL,
  `SrcAmount` int(11) DEFAULT NULL,
  `CancelFlag` char(1) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modifygoodsapply`
--

LOCK TABLES `modifygoodsapply` WRITE;
/*!40000 ALTER TABLE `modifygoodsapply` DISABLE KEYS */;
/*!40000 ALTER TABLE `modifygoodsapply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modifygoodsapply_detail`
--

DROP TABLE IF EXISTS `modifygoodsapply_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modifygoodsapply_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `GoodsName` varchar(255) DEFAULT NULL,
  `SrcQty` double DEFAULT NULL,
  `SrcUnitPrice` double DEFAULT NULL,
  `SrcAmount` int(11) DEFAULT NULL,
  `SrcVendor` varchar(100) DEFAULT NULL,
  `Qty` double DEFAULT NULL,
  `UnitPrice` double DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Vendor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modifygoodsapply_detail`
--

LOCK TABLES `modifygoodsapply_detail` WRITE;
/*!40000 ALTER TABLE `modifygoodsapply_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `modifygoodsapply_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myfavor`
--

DROP TABLE IF EXISTS `myfavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myfavor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Subject` varchar(100) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `PageUrl` varchar(100) DEFAULT NULL,
  `NewWindow` char(1) DEFAULT NULL,
  `UseMyFile` char(1) DEFAULT NULL,
  `FileUrl` varchar(100) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myfavor`
--

LOCK TABLES `myfavor` WRITE;
/*!40000 ALTER TABLE `myfavor` DISABLE KEYS */;
INSERT INTO `myfavor` VALUES ('MF20140822.01','99','admin','ssdfsd','','http://www.google.com.tw','','','','2014-08-22','2014-12-31'),('MF20160308.01','Demo','test1','test','','http://demo.synergytek.com.tw:8080/HH/Home.jsp','Y','','','2016-01-01','2016-12-31');
/*!40000 ALTER TABLE `myfavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Appendix` varchar(200) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  `LinkUrl` varchar(200) DEFAULT NULL,
  `LinkTitle` varchar(50) DEFAULT NULL,
  `UrlDateFrom` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES ('Nc20110216.01','Demo','admin','IPServ. In Firm 系統操作說明手冊','IPServ. In Firm 系統操作說明手冊','Document/Notice/admin/UL17044.001.pdf','2011-01-01','2030-01-01','','','');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_detail`
--

DROP TABLE IF EXISTS `notice_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `AuthorityType` varchar(50) DEFAULT NULL,
  `AuthorityId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_detail`
--

LOCK TABLES `notice_detail` WRITE;
/*!40000 ALTER TABLE `notice_detail` DISABLE KEYS */;
INSERT INTO `notice_detail` VALUES ('Nc20110216.01',1,'All','');
/*!40000 ALTER TABLE `notice_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opponent`
--

DROP TABLE IF EXISTS `opponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opponent` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `IdType` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `EnglishNames` varchar(200) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `CompanyReq` varchar(100) DEFAULT NULL,
  `EnglishCompanyReq` varchar(100) DEFAULT NULL,
  `TelNo` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnglishAddress` varchar(200) DEFAULT NULL,
  `Memo` text,
  `Appendix` varchar(100) DEFAULT NULL,
  `Birthday` varchar(20) DEFAULT NULL,
  `Company` varchar(5000) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `EnglishLastName` varchar(100) DEFAULT NULL,
  `EnglishFirstName` varchar(100) DEFAULT NULL,
  `Email2` varchar(50) DEFAULT NULL,
  `Skype` varchar(50) DEFAULT NULL,
  `Msn` varchar(50) DEFAULT NULL,
  `WebSite` varchar(50) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `Zip2` varchar(50) DEFAULT NULL,
  `ShowInClient` varchar(1) DEFAULT 'N',
  `ApplicantKind` varchar(50) DEFAULT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `TelNo2` varchar(50) DEFAULT NULL,
  `ApplicantType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opponent`
--

LOCK TABLES `opponent` WRITE;
/*!40000 ALTER TABLE `opponent` DISABLE KEYS */;
/*!40000 ALTER TABLE `opponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentapplicant`
--

DROP TABLE IF EXISTS `patentapplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentapplicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ApplicantOrder` varchar(50) DEFAULT NULL,
  `ApplicantId` varchar(50) DEFAULT NULL,
  `ApplicantName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentapplicant`
--

LOCK TABLES `patentapplicant` WRITE;
/*!40000 ALTER TABLE `patentapplicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentapplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentattorney`
--

DROP TABLE IF EXISTS `patentattorney`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentattorney` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `AttorneyType` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `AttorneyName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentattorney`
--

LOCK TABLES `patentattorney` WRITE;
/*!40000 ALTER TABLE `patentattorney` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentattorney` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentcase`
--

DROP TABLE IF EXISTS `patentcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentcase` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `IdeaId` varchar(50) DEFAULT NULL,
  `FamilyOrder` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Title` varchar(500) DEFAULT NULL,
  `OriginalTitle` varchar(500) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `PublishDate` varchar(10) DEFAULT NULL,
  `PublishNo` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `GiveupCode` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `OutsourceDate` varchar(10) DEFAULT NULL,
  `SignOutId` varchar(50) DEFAULT NULL,
  `SignOutTime` varchar(20) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `SignOutName` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `LicenseDate` varchar(10) DEFAULT NULL,
  `LicenseNo` varchar(50) DEFAULT NULL,
  `FeeScheduleDate` varchar(10) DEFAULT NULL,
  `FeeSchedule` float(10,1) DEFAULT NULL,
  `ProjectCode` varchar(50) DEFAULT NULL,
  `Keyword` varchar(50) DEFAULT NULL,
  `TechCategory` varchar(50) DEFAULT NULL,
  `FuncCategory` varchar(50) DEFAULT NULL,
  `Ipc` varchar(500) DEFAULT NULL,
  `Uspc` varchar(500) DEFAULT NULL,
  `Fi` varchar(500) DEFAULT NULL,
  `Locarno` varchar(500) DEFAULT NULL,
  `Gattezz` varchar(50) DEFAULT NULL,
  `ExamineDate` varchar(10) DEFAULT NULL,
  `RightBeginDate` varchar(10) DEFAULT NULL,
  `RightEndDate` varchar(10) DEFAULT NULL,
  `PctAppDate` varchar(10) DEFAULT NULL,
  `PctAppNo` varchar(50) DEFAULT NULL,
  `PctPublishDate` varchar(10) DEFAULT NULL,
  `WipoNo` varchar(50) DEFAULT NULL,
  `NationalPhaseDate` varchar(10) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `ExamineDueDate` varchar(10) DEFAULT NULL,
  `TechReportApply` char(1) DEFAULT NULL,
  `IndependentClaim` int(11) DEFAULT NULL,
  `DependentClaim` int(11) DEFAULT NULL,
  `Drawing` int(11) DEFAULT NULL,
  `TotalPage` int(11) DEFAULT NULL,
  `CaseStartDate` varchar(20) DEFAULT NULL,
  `CaseAttribute` varchar(50) DEFAULT NULL,
  `PatentCaseType` varchar(50) DEFAULT NULL,
  `DeliveryDate` varchar(10) DEFAULT NULL,
  `Remark` text,
  `ImageUrl` varchar(100) DEFAULT NULL,
  `IDS` varchar(1) DEFAULT NULL,
  `Priority` varchar(1) DEFAULT NULL,
  `IDSCaseNo` varchar(50) DEFAULT NULL,
  `PriorityCaseNo` varchar(50) DEFAULT NULL,
  `OtherCaseNo` varchar(50) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `LastSchedule` varchar(200) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `PriorityDeadLine` varchar(10) DEFAULT NULL,
  `WrittenMan` varchar(50) DEFAULT NULL,
  `WrittenFinishedDate` varchar(10) DEFAULT NULL,
  `MappingMan` varchar(50) DEFAULT NULL,
  `MappingFinishedDate` varchar(10) DEFAULT NULL,
  `TranslateMan` varchar(50) DEFAULT NULL,
  `TranslateFinishedDate` varchar(10) DEFAULT NULL,
  `RejectionMan` varchar(50) DEFAULT NULL,
  `RejectionFinishedDate` varchar(10) DEFAULT NULL,
  `ReplyMan` varchar(50) DEFAULT NULL,
  `ReplyFinishedDate` varchar(10) DEFAULT NULL,
  `AutoPay` varchar(1) DEFAULT NULL,
  `PaymentConfirming` varchar(1) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `AttorneyNum` varchar(50) DEFAULT NULL,
  `EnglishTitle` varchar(500) DEFAULT NULL,
  `ApplyTransDate` varchar(10) DEFAULT NULL,
  `ApplyTransTo` varchar(200) DEFAULT NULL,
  `RightTransDate` varchar(10) DEFAULT NULL,
  `RightTransTo` varchar(200) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `CaseApplicantNames` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `CaseApplicant` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `PctNationalPhase` varchar(50) DEFAULT NULL,
  `CaseAssignedTo` varchar(50) DEFAULT NULL,
  `ClientName` varchar(200) DEFAULT NULL,
  `CloseDate` varchar(50) DEFAULT NULL,
  `SpecialRequest` varchar(500) DEFAULT NULL,
  `ContactDate` varchar(50) DEFAULT NULL,
  `Referrals` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentcase`
--

LOCK TABLES `patentcase` WRITE;
/*!40000 ALTER TABLE `patentcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentcase_2`
--

DROP TABLE IF EXISTS `patentcase_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentcase_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `IdeaId` varchar(50) DEFAULT NULL,
  `FamilyOrder` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Title` varchar(500) DEFAULT NULL,
  `OriginalTitle` varchar(500) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `PublishDate` varchar(10) DEFAULT NULL,
  `PublishNo` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `GiveupCode` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `OutsourceDate` varchar(10) DEFAULT NULL,
  `SignOutId` varchar(50) DEFAULT NULL,
  `SignOutTime` varchar(20) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `SignOutName` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `LicenseDate` varchar(10) DEFAULT NULL,
  `LicenseNo` varchar(50) DEFAULT NULL,
  `FeeScheduleDate` varchar(10) DEFAULT NULL,
  `FeeSchedule` float(10,1) DEFAULT NULL,
  `ProjectCode` varchar(50) DEFAULT NULL,
  `Keyword` varchar(50) DEFAULT NULL,
  `TechCategory` varchar(50) DEFAULT NULL,
  `FuncCategory` varchar(50) DEFAULT NULL,
  `Ipc` varchar(500) DEFAULT NULL,
  `Uspc` varchar(500) DEFAULT NULL,
  `Fi` varchar(500) DEFAULT NULL,
  `Locarno` varchar(500) DEFAULT NULL,
  `Gattezz` varchar(50) DEFAULT NULL,
  `ExamineDate` varchar(10) DEFAULT NULL,
  `RightBeginDate` varchar(10) DEFAULT NULL,
  `RightEndDate` varchar(10) DEFAULT NULL,
  `PctAppDate` varchar(10) DEFAULT NULL,
  `PctAppNo` varchar(50) DEFAULT NULL,
  `PctPublishDate` varchar(10) DEFAULT NULL,
  `WipoNo` varchar(50) DEFAULT NULL,
  `NationalPhaseDate` varchar(10) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `ExamineDueDate` varchar(10) DEFAULT NULL,
  `TechReportApply` char(1) DEFAULT NULL,
  `IndependentClaim` int(11) DEFAULT NULL,
  `DependentClaim` int(11) DEFAULT NULL,
  `Drawing` int(11) DEFAULT NULL,
  `TotalPage` int(11) DEFAULT NULL,
  `CaseStartDate` varchar(20) DEFAULT NULL,
  `CaseAttribute` varchar(50) DEFAULT NULL,
  `PatentCaseType` varchar(50) DEFAULT NULL,
  `DeliveryDate` varchar(10) DEFAULT NULL,
  `Remark` text,
  `ImageUrl` varchar(100) DEFAULT NULL,
  `IDS` varchar(1) DEFAULT NULL,
  `Priority` varchar(1) DEFAULT NULL,
  `IDSCaseNo` varchar(50) DEFAULT NULL,
  `PriorityCaseNo` varchar(50) DEFAULT NULL,
  `OtherCaseNo` varchar(50) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `LastSchedule` varchar(200) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `PriorityDeadLine` varchar(10) DEFAULT NULL,
  `WrittenMan` varchar(50) DEFAULT NULL,
  `WrittenFinishedDate` varchar(10) DEFAULT NULL,
  `MappingMan` varchar(50) DEFAULT NULL,
  `MappingFinishedDate` varchar(10) DEFAULT NULL,
  `TranslateMan` varchar(50) DEFAULT NULL,
  `TranslateFinishedDate` varchar(10) DEFAULT NULL,
  `RejectionMan` varchar(50) DEFAULT NULL,
  `RejectionFinishedDate` varchar(10) DEFAULT NULL,
  `ReplyMan` varchar(50) DEFAULT NULL,
  `ReplyFinishedDate` varchar(10) DEFAULT NULL,
  `AutoPay` varchar(1) DEFAULT NULL,
  `PaymentConfirming` varchar(1) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `AttorneyNum` varchar(50) DEFAULT NULL,
  `EnglishTitle` varchar(500) DEFAULT NULL,
  `ApplyTransDate` varchar(10) DEFAULT NULL,
  `ApplyTransTo` varchar(200) DEFAULT NULL,
  `RightTransDate` varchar(10) DEFAULT NULL,
  `RightTransTo` varchar(200) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `CaseApplicantNames` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `CaseApplicant` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `PctNationalPhase` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentcase_2`
--

LOCK TABLES `patentcase_2` WRITE;
/*!40000 ALTER TABLE `patentcase_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentcase_2` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `patentcitation`
--

DROP TABLE IF EXISTS `patentcitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentcitation` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `CitationType` varchar(50) DEFAULT NULL,
  `RelateDocNo` varchar(50) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `PublishNo` varchar(50) DEFAULT NULL,
  `PublishDate` varchar(10) DEFAULT NULL,
  `CountryCode` varchar(50) DEFAULT NULL,
  `KindCode` varchar(50) DEFAULT NULL,
  `PatenteeApplicant` varchar(100) DEFAULT NULL,
  `DocPage` varchar(100) DEFAULT NULL,
  `ExaminerInitial` varchar(1) DEFAULT NULL,
  `InternalCaseNo` varchar(50) DEFAULT NULL,
  `UploadFiles` varchar(100) DEFAULT NULL,
  `NonPatentMemo` varchar(1000) DEFAULT NULL,
  `IsUsIds` varchar(1) DEFAULT NULL,
  `UsIdsDate` varchar(10) DEFAULT NULL,
  `IsEpIds` varchar(1) DEFAULT NULL,
  `EpIdsDate` varchar(10) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `UsStatus` varchar(50) DEFAULT NULL,
  `EpStatus` varchar(50) DEFAULT NULL,
  `T5` varchar(1) DEFAULT NULL,
  `Memo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentcitation`
--

LOCK TABLES `patentcitation` WRITE;
/*!40000 ALTER TABLE `patentcitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentcitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentdocument`
--

DROP TABLE IF EXISTS `patentdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `DocumentType` varchar(50) DEFAULT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) DEFAULT NULL,
  `DocumentNo` varchar(50) DEFAULT NULL,
  `DocumentKind` varchar(50) DEFAULT NULL,
  `DocumentDate` varchar(10) DEFAULT NULL,
  `DocumentTarget` varchar(50) DEFAULT NULL,
  `DocumentProcess` varchar(50) DEFAULT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(100) DEFAULT NULL,
  `AttachmentName2` varchar(100) DEFAULT NULL,
  `AttachmentName3` varchar(100) DEFAULT NULL,
  `AttachmentName4` varchar(100) DEFAULT NULL,
  `AttachmentName5` varchar(100) DEFAULT NULL,
  `AttachmentName6` varchar(100) DEFAULT NULL,
  `AttachmentName7` varchar(100) DEFAULT NULL,
  `AttachmentName8` varchar(100) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentdocument`
--

LOCK TABLES `patentdocument` WRITE;
/*!40000 ALTER TABLE `patentdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentinventor`
--

DROP TABLE IF EXISTS `patentinventor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentinventor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `InventorType` varchar(50) DEFAULT NULL,
  `InventorOrder` varchar(20) DEFAULT NULL,
  `ContributionShare` int(11) DEFAULT NULL,
  `Inventor` varchar(50) DEFAULT NULL,
  `InventorName` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `EnglishNames` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentinventor`
--

LOCK TABLES `patentinventor` WRITE;
/*!40000 ALTER TABLE `patentinventor` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentinventor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentmatterconfig`
--

DROP TABLE IF EXISTS `patentmatterconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentmatterconfig` (
  `FlowKey` varchar(50) NOT NULL,
  `MatterDisciption` varchar(200) DEFAULT NULL,
  `MatterName` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(1000) DEFAULT NULL,
  `PatentType` varchar(1000) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `CaseKind` varchar(50) DEFAULT NULL,
  `ForSales` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentmatterconfig`
--

LOCK TABLES `patentmatterconfig` WRITE;
/*!40000 ALTER TABLE `patentmatterconfig` DISABLE KEYS */;
INSERT INTO `patentmatterconfig` VALUES ('TWP01','','台灣發明申請','TW, ','PN01, ','admin','99','STC01',''),('TM01','台灣商標申請','台灣商標申請','TW, ','TT01, TT02, TT03, TT04, ','admin','99','STC02',''),('TM02','台灣商標領證','台灣商標領證','TW, ','TT01, TT02, TT03, TT04, ','admin','PWC','STC02',''),('TM03','','111','AD, ','TT01, ','admin','99','STC02','Y'),('PTC','','申請','TW, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTA','','申請/實審 ','TW, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PTC01','','變更發明人','TW, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTC02','','技術報告','TW, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTWPN03PA040','','台灣設計第四年年費','TW, ','PN03, ','admin','99','STC01','Y'),('PTWPN03PA030','','台灣設計第三年年費','TW, ','PN03, ','admin','99','STC01','Y'),('PCC01','','中國大陸-檢索(技術報告)','CN, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTC04','','申請權讓與','TW, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTWPN02PA040','','台灣新型第四年年費','TW, ','PN02, ','admin','99','STC01','Y'),('PTWPN02PA030','','台灣新型第三年年費','TW, ','PN02, ','admin','99','STC01','Y'),('PTWPN01PA040','','台灣發明第四年年費','TW, ','PN01, ','admin','99','STC01','Y'),('PTWPN01PA030','','台灣發明第三年年費','TW, ','PN01, ','admin','99','STC01','Y'),('PTWPN03PA020','','台灣設計第二年年費','TW, ','PN03, ','admin','99','STC01','Y'),('PTWPN02PA020','','台灣新型第二年年費','TW, ','PN02, ','admin','99','STC01','Y'),('PTM05','','申請/實審/權項費(項)','TW, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PUS','','申請/讓與/翻譯費','null','null','titanpat01','titanpat','STC01','Y'),('PUS01','','領證/公開','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PUS02','','更正(發明人地址)','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PUS03','','申請權讓與/變更代理人','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PTWPN01PA020','','台灣發明第二年年費','TW, ','PN01, ','admin','99','STC01','Y'),('PTC07','','申請權讓與','TW, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PJP','','專利權讓與','JP, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PCN02','','補正(一)','CN, ','PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC','','申請/優先權','AU, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTC08','','發明獎甄選','TW, ','PN01, ','titanpat01','titanpat','STC01','Y'),('TM2-2','','申請/未使用','CA, ','TT01, ','titanpat01','titanpat','STC02','Y'),('PTA05','','申請/優先權/實審','TW, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PTA06','','申請/優先權/檢索(新穎性)','NL, ','PN01, ','titanpat01','titanpat','STC01','Y'),('TM1','','申請','TW, ','TT01, ','admin','titanpat','STC02','Y'),('TM2','','申請/未使用','US, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM3','','公證','AR, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM4','','全期註冊費','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM5','','延展','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM6','','中國大陸-商標-異議','CN, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM7','(長風)','異議答辯','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM8','','移轉','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM9','（巴拿馬）','第三國認證','AR, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM10','','陳述意見書','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM11','','期限控管(延展)','ID, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM12','','減縮商品','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM13','','答辯','CN, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM14','','訴願','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM15','(申請人更名)','註冊變更','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM16','','評定','TW, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM17','','領證','null','TT01, ','titanpat01','titanpat','STC02','Y'),('TM18','','領證/宣誓使用','CA, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM19','','審定公告','PH, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM13-1','','答辯','US, ','TT01, ','titanpat01','titanpat','STC02','Y'),('TM18-1','','領證/宣誓使用','US, ','TT01, ','titanpat01','titanpat','STC02','Y'),('PTAC-1','','申請/優先權','BR, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-2','','申請/優先權','CA, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-3','','中國大陸-發明-申請/優先權','CN, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PTAC-4','','申請/優先權','EU, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-5','','申請/優先權','IN, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-6','','申請/優先權','JP, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-7','','申請/優先權','KR, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-8','','申請/優先權','RU, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PTAC-9','','申請/優先權','US, ','PN01, PN02, ','titanpat01','titanpat','STC01','Y'),('PMC20140605.001','','美國發明申請-官費','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PMC20140605.002','','美國發明申請-複代理人費','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('PMC20140605.003','','美國發明申請-服務費','US, ','PN01, ','titanpat01','titanpat','STC01','Y'),('L01','台灣民事訴訟','台灣民事訴訟','TW, ','MainT01, ','admin','99','STC03',''),('L02','中國民事訴訟','中國民事訴訟','CN, ','MainT01, ','admin','99','STC03',''),('L03','法律顧問','中國法律顧問','CN, ','MainT00, MainT01, MainT02, MainT03, MainT04, MainT05, MainT06, MainT07, MainT08, MainT09, MainT10, MainT11, MainT12, MainT13, MainT14, MainT15, MainT16, MainT17, MainT18, MainT19, ','admin','99','STC03',''),('PMC20140610.001','','','CN, ','PN02, ','titanpat01','titanpat','STC01','Y'),('CR01','','著作權登記','TW, ','CMainT01, ','admin','99','STC04','Y'),('CR02','','著作權授權','TW, ','CMainT02, ','admin','99','STC04','Y'),('PMC20140625.001','美國-專利答辯','美國-專利答辯','US, ','PN01, ','admin','titanpat','STC01','Y'),('TTWTT02PA100','','台灣團體商標延展10年','TW, ','TT02, ','admin','99','STC02','Y'),('TTWTT01PA100','','台灣商標延展10年','TW, ','TT01, ','admin','99','STC02','Y'),('PTWPN03PA010','','台灣設計第一年年費','TW, ','PN03, ','admin','99','STC01','Y'),('PMC20140805.001','','','AD, AO, ','PN02, PN06, ','admin','99','STC01','Y'),('PTWPN01PA010','','台灣發明第一年年費','TW, ','PN01, ','admin','99','STC01','Y'),('PTWPN02PA010','','台灣新型第一年年費','TW, ','PN02, ','admin','99','STC01','Y'),('PUSPN01PA035','','美國發明第3.5年年費','US, ','PN01, ','admin','99','STC01','Y'),('PUSPN01PA070','','美國發明第7年年費','US, ','PN01, ','admin','99','STC01','Y'),('TUSTT01PA100','','美國商標延展10年','US, ','TT01, ','admin','99','STC02','Y'),('TCNTT01PA100','','中國商標延展10年','CN, ','TT01, ','admin','99','STC02','Y'),('TJPTT01PA100','','日本商標延展10年','JP, ','TT01, ','admin','99','STC02','Y'),('PMC20140903.001','','台灣法顧','TW, ','ServiceTypeMain01, ','admin','99','STC05','Y'),('PMC20140903.002','','台灣法顧','TW, ','ServiceTypeMain01, ','admin','99','STC05',''),('PMC20180110.003','會計服務(月)','會計服務(月)','TW, ','STM03, ','admin','99','STC05','Y'),('CN03','','中國專利授權維護階段','CN, ','PN01, PN02, PN03, ','admin','99','STC01','Y'),('CN04','','中國專利複審階段','CN, ','PN01, PN02, PN03, ','admin','99','STC01',''),('WO01','','PCT國際階段','PCT, ','PN01, PN02, PN03, ','admin','99','STC01',''),('PT0001','','專利申請','TW, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT0002','','答辯','TW, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT0003','','領證及第一年年費','TW, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-CN-0001','','申請(實審)','CN, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-CN-0002','','答辯','CN, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-CN-0003','','領證','CN, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-US-0001','','申請含實審','US, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-US-0002','','答辯','US, ','PN01, ','WIPO','WIPO','STC01','Y'),('PT-US-0003','','領證','US, ','PN01, ','WIPO','WIPO','STC01','Y'),('CN01','','中國專利申請階段','CN, ','PN01, PN02, PN03, ','admin','99','STC01',''),('CN02','','中國專利實質審查階段','CN, ','PN01, PN02, PN03, ','admin','99','STC01',''),('PMC20150819.001','','台灣發明專利申請含實審','TW, ','PN01, ','WIPO','WIPO','STC01','Y'),('PMC20150819.002','','台灣發明專利申請不含實審','TW, ','PN01, ','WIPO','WIPO','STC01','Y'),('PMC20150918.001','美國-專利答辯','美國-專利答辯','US, ','PN01, PN02, PN03, PN04, PN05, PN06, PN07, PN08, PN09, PN10, PN11, PN12, PN13, ','admin','99','STC01',''),('PMC20151203.001','','撰稿中(新案)','CN, EP, JP, KR, TW, US, ','PN01, PN02, PN03, ','test','99','STC01',''),('IPW-01','','接案','CN, EP, JP, KR, TW, US, ','PN01, PN02, PN03, PN09, PN11, ','test','99','STC01',''),('PMC20160512.001','','年費代繳','BF, ','PN10, ','admin','99','STC01',''),('PMC20160513.001','','專利翻譯','TW, ','PN08, ','test4','Demo','STC01','Y'),('PMC20160516.001','專利年費','專利年費','TW, ','PN10, ','test4','Demo','STC01','Y'),('PMC20160518.001','','','TW, ','PN10, ','test4','Demo','STC01','Y'),('PMC20170104.001','','台灣新計','TW, ','PN03, ','YUSO','YUSO','STC01','Y'),('L04','法律顧問','台灣法律顧問','TW, ','MainT01, ','admin','99','STC03','Y');
/*!40000 ALTER TABLE `patentmatterconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patentpriority`
--

DROP TABLE IF EXISTS `patentpriority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patentpriority` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `PriorityDate` varchar(10) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `Document` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patentpriority`
--

LOCK TABLES `patentpriority` WRITE;
/*!40000 ALTER TABLE `patentpriority` DISABLE KEYS */;
/*!40000 ALTER TABLE `patentpriority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymanage`
--

DROP TABLE IF EXISTS `paymanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymanage` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `PayToParty` varchar(50) DEFAULT NULL,
  `CovEntity` varchar(50) DEFAULT NULL,
  `PayToPartyName` varchar(100) DEFAULT NULL,
  `PayType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `PayAmount` float(16,2) DEFAULT '0.00',
  `ExchangeRate` float(16,4) DEFAULT '0.0000',
  `PayNtdAmount` int(16) DEFAULT '0',
  `CheckNo` varchar(50) DEFAULT NULL,
  `Account` varchar(50) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `PayCheckDate` varchar(10) DEFAULT NULL,
  `RealReceiveDate` varchar(10) DEFAULT NULL,
  `ReceiveDate` varchar(10) DEFAULT NULL,
  `WriteOffBalance` float(16,2) DEFAULT '0.00',
  `ExchangeGain` float(16,2) DEFAULT '0.00',
  `ExchangeLoss` float(16,2) DEFAULT '0.00',
  `WriteOffLog` varchar(4000) DEFAULT NULL,
  `AlreadyWriteOffAmount` float(16,2) DEFAULT '0.00',
  `memo` varchar(500) DEFAULT NULL,
  `CommissionCharge` float DEFAULT '0',
  `PayKind` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymanage`
--

LOCK TABLES `paymanage` WRITE;
/*!40000 ALTER TABLE `paymanage` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `PayToParty` varchar(50) DEFAULT NULL,
  `CovEntity` varchar(50) DEFAULT NULL,
  `PayToPartyName` varchar(100) DEFAULT NULL,
  `AttorneyId` varchar(50) DEFAULT NULL,
  `PaymentDate` varchar(10) DEFAULT NULL,
  `ApDate` varchar(10) DEFAULT NULL,
  `TotalPaymentNtdAmount` int(16) DEFAULT '0',
  `TotalWriteOffAmount` float(16,2) DEFAULT '0.00',
  `TotalDiscountAmount` float(16,2) DEFAULT '0.00',
  `Title` varchar(500) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `SubType` varchar(50) DEFAULT NULL,
  `ApplyNo` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(50) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `Matter` varchar(50) DEFAULT NULL,
  `PaymentNo` varchar(50) DEFAULT NULL,
  `ReceiptDate` varchar(10) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` float(16,2) DEFAULT '0.00',
  `ExchangeRate` float(16,4) DEFAULT '0.0000',
  `Note` varchar(200) DEFAULT NULL,
  `TotalAmountDeductTTax2` int(11) DEFAULT '0',
  `ServiceFeeDeductTTax2` int(11) DEFAULT '0',
  `OriginalCurrency` varchar(50) DEFAULT NULL,
  `OriginalCurrencyAmount` varchar(50) DEFAULT NULL,
  `ServiceFeeNtd` int(12) DEFAULT '0',
  `GovFeeNtd` int(12) DEFAULT '0',
  `totalTax` int(12) DEFAULT '0',
  `totalTax2` int(12) DEFAULT '0',
  `totalWithHolding` int(12) DEFAULT '0',
  `otherFeeNtd` int(12) DEFAULT '0',
  `attorneyFeeNtd` int(12) DEFAULT '0',
  `GovFee` double(16,2) DEFAULT '0.00',
  `attorneyFee` double(16,2) DEFAULT '0.00',
  `otherFee` double(16,2) DEFAULT '0.00',
  `ServiceFee` double(16,2) DEFAULT '0.00',
  `WriteOffRecode` varchar(2000) DEFAULT NULL,
  `InternalInvoiceNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentdetail`
--

DROP TABLE IF EXISTS `paymentdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentdetail` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `TodosId` varchar(50) DEFAULT NULL,
  `PaymentTitle` varchar(50) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` float(16,2) DEFAULT '0.00',
  `ExchangeRate` float(16,4) DEFAULT '0.0000',
  `NtdAmount` int(16) DEFAULT '0',
  `PaymentAmount` int(16) DEFAULT '0',
  `AlreadyWriteOffAmount` int(16) DEFAULT '0',
  `NotYetWriteOff` int(16) DEFAULT '0',
  `DiscountAmount` int(16) DEFAULT '0',
  `Note` varchar(1000) DEFAULT NULL,
  `WriteOffRecode` varchar(1000) DEFAULT NULL,
  `PaymentDetailType` varchar(50) DEFAULT NULL,
  `Payment` float(16,2) DEFAULT '0.00',
  `PaymentCurrency` varchar(50) DEFAULT NULL,
  `PaymentExchangeRate` float(16,4) DEFAULT '0.0000',
  `Tax` int(11) DEFAULT '0',
  `TaxCheck` varchar(1) DEFAULT NULL,
  `Tax2Check` varchar(1) DEFAULT NULL,
  `Tax2` int(11) DEFAULT '0',
  `Withholding` varchar(1) DEFAULT NULL,
  `InclTaxNtdAmount` int(11) DEFAULT '0',
  `Memo` varchar(100) DEFAULT NULL,
  `TaskDescription` varchar(200) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentdetail`
--

LOCK TABLES `paymentdetail` WRITE;
/*!40000 ALTER TABLE `paymentdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmemo`
--

DROP TABLE IF EXISTS `paymentmemo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentmemo` (
  `FlowKey` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `PaymentDate` varchar(10) DEFAULT NULL,
  `MemoDate` varchar(50) DEFAULT NULL,
  `Payee` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `PayType` varchar(50) DEFAULT NULL,
  `PaymentReport` varchar(50) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmemo`
--

LOCK TABLES `paymentmemo` WRITE;
/*!40000 ALTER TABLE `paymentmemo` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentmemo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmemo_detail`
--

DROP TABLE IF EXISTS `paymentmemo_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentmemo_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `SrcTableName` varchar(50) DEFAULT NULL,
  `SrcFlowKey` varchar(50) DEFAULT NULL,
  `FlowName` varchar(200) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `InvoiceDate` varchar(10) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `InvoiceNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmemo_detail`
--

LOCK TABLES `paymentmemo_detail` WRITE;
/*!40000 ALTER TABLE `paymentmemo_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentmemo_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pettycash`
--

DROP TABLE IF EXISTS `pettycash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pettycash` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `DeptSigner1` varchar(50) DEFAULT NULL,
  `DeptSigner2` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `Payee` varchar(50) DEFAULT NULL,
  `BudgetDept` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `BudgetAmount` int(11) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `TaxFlag` char(1) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  `LoanFlag` char(1) DEFAULT NULL,
  `BudgetDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pettycash`
--

LOCK TABLES `pettycash` WRITE;
/*!40000 ALTER TABLE `pettycash` DISABLE KEYS */;
/*!40000 ALTER TABLE `pettycash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phrase`
--

DROP TABLE IF EXISTS `phrase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phrase` (
  `FlowKey` varchar(50) NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phrase`
--

LOCK TABLES `phrase` WRITE;
/*!40000 ALTER TABLE `phrase` DISABLE KEYS */;
/*!40000 ALTER TABLE `phrase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pkeyno`
--

DROP TABLE IF EXISTS `pkeyno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pkeyno` (
  `pkey` varchar(50) NOT NULL,
  `no` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pkeyno`
--

LOCK TABLES `pkeyno` WRITE;
/*!40000 ALTER TABLE `pkeyno` DISABLE KEYS */;
INSERT INTO `pkeyno` VALUES ('',3),('0002',1),('001--',1),('001-9535-',1),('001-9537-',1),('001-9539-',1),('001-ABC-',1),('002-9062-',1),('002-9266-',1),('002-ABC-',1),('107F0681',1),('1129',1),('1234',1),('2014D',1),('2016D',1),('2016D.0001',3),('2016D.0001Log',2),('9485-005TW',2),('9518',1),('9541',1),('9551',1),('9567',1),('9578',1),('9580',1),('A01',1),('ac140001-L',2),('actionip',2),('admin',9),('adsl.savecom.net.tw',1),('amay',1),('Ap20140530',11),('Ap20140603',1),('Ap20140604',6),('Ap20140605',28),('Ap20140606',15),('Ap20140609',4),('Ap20140610',6),('Ap20140612',18),('Ap20140613',10),('Ap20140619',2),('Ap20140620',5),('Ap20140703',3),('Ap20140805',1),('Ap20140828',2),('Ap20140903',1),('Ap20140915',2),('Ap20140916',15),('Ap20140917',3),('Ap20140918',4),('Ap20140930',5),('Ap20141030',1),('Ap20141106',1),('Ap20141118',2),('Ap20141201',1),('Ap20141202',11),('Ap20141225',1),('Ap20150203',1),('Ap20150204',2),('Ap20150208',2),('Ap20150318',1),('Ap20150819',7),('Ap20150820',1),('Ap20150831',1),('Ap20150904',2),('Ap20151109',8),('Ap20151112',2),('Ap20151113',2),('Ap20151117',2),('Ap20151118',1),('Ap20151202',4),('Ap20151203',10),('Ap20151207',10),('Ap20160107',1),('Ap20160218',1),('Ap20160311',2),('Ap20160312',1),('Ap20160314',1),('Ap20160406',2),('Ap20160505',2),('Ap20160511',6),('Ap20160512',1),('Ap20160516',1),('Ap20160518',1),('Ap20160524',1),('Ap20160711',1),('Ap20160713',1),('Ap20161127',3),('Ap20161220',1),('Ap20170104',4),('Ap20170320',2),('Ap20170419',2),('Ap20170515',2),('Ap20170717',2),('Ap20170721',2),('Ap20170809',1),('Ap20170828',2),('Ap20170913',2),('Ap20171222',2),('Ap20180110',1),('Ap20180116',2),('Ap20180117',1),('Ap20180122',2),('Ap20180123',1),('Ap20180124',8),('Ap20180125',3),('Ap20180126',3),('Ap20180128',2),('Ap20180129',1),('Ap20180206',6),('Ap20180208',2),('Ap20180227',1),('Ap20180301',9),('Ap20180302',2),('Ap20180321',4),('Ap20180327',2),('Ap20180328',7),('Ap20180410',1),('Ap20180626',2),('Ap20180628',2),('Ap20180703',1),('Ap20180704',3),('Ap20180710',1),('Ap20180717',3),('Ap20180720',3),('Ap20180724',1),('Ap20180725',1),('Ap20180727',2),('Ap20180803',3),('Ap20180927',3),('Ap20181001',3),('Ap20181003',1),('Ap20181018',1),('Ap20181019',2),('Ap20181023',1),('Ap20181127',2),('Ap20181128',1),('Ap20181129',3),('Ap20181205',1),('Ap20190220',2),('Ap20190221',1),('Ap20190612',2),('Ap20190613',1),('Ap20190614',1),('Ap20190621',2),('Ap20190726',2),('Ap20190730',1),('Ap20190819',1),('Ap20190903',2),('Ap20190918',1),('Ap20190923',3),('Ap20191009',10),('Ap20191015',2),('Ap20191016',2),('Ap20191017',6),('At20140531',1),('At20140603',2),('At20140613',2),('At20140828',1),('At20141106',1),('At20160312',1),('At20170104',1),('At20170320',1),('At20170515',1),('At20170717',1),('At20170913',1),('At20180626',1),('At20180704',1),('At20180717',1),('At20180727',1),('At20180927',1),('At20181001',1),('At20181019',1),('At20181127',1),('At20190220',1),('At20190612',1),('At20190625',1),('At20190730',1),('At20190903',1),('At20191009',1),('AWL20140530',2),('AWL20140609',1),('AWL20140612',8),('AWL20140620',4),('AWL20140623',12),('AWL20140625',1),('AWL20140628',1),('AWL20140721',2),('AWL20140925',2),('AWL20141119',1),('AWL20150505',5),('AWL20150514',3),('AWL20150905',3),('AWL20150918',2),('AWL20180111',2),('AWL20180117',1),('AWL20180125',2),('AWL20180126',2),('AWL20180206',1),('AWL20180327',1),('AWL20180703',1),('AWL20180730',1),('AWL20180803',1),('AWL20181019',1),('AWL20181129',1),('AWL20190612',2),('AWL20190625',2),('AWL20190806',1),('AWL20191016',4),('AWL20191113',1),('BAM20140925',1),('BL01',3),('C-CR01-001-1-ABC-',1),('C-CR01-001-3-ABC-',1),('Ca20140625',1),('Ca20151202',1),('Ca20170104',1),('CC20140530',4),('CC20140530.001',4),('CC20140530.002',1),('CC20140530.003',3),('CC20140530.004',2),('CC20140604',3),('CC20140604.001',4),('CC20140604.002',1),('CC20140604.003',1),('CC20140605',2),('CC20140605.001',7),('CC20140605.002',5),('CC20140606',11),('CC20140606.001',6),('CC20140606.002',4),('CC20140606.003',3),('CC20140606.004',4),('CC20140606.005',4),('CC20140606.006',1),('CC20140606.007',2),('CC20140606.008',2),('CC20140606.009',3),('CC20140606.010',3),('CC20140606.011',8),('CC20140609',1),('CC20140609.001',2),('CC20140610',7),('CC20140610.001',2),('CC20140610.002',4),('CC20140610.003',4),('CC20140610.004',3),('CC20140610.005',8),('CC20140610.006',2),('CC20140610.007',2),('CC20140611',1),('CC20140611.001',4),('CC20140612',4),('CC20140612.001',11),('CC20140612.004',15),('CC20140613',2),('CC20140613.001',3),('CC20140619',11),('CC20140619.001',2),('CC20140619.002',1),('CC20140619.003',1),('CC20140619.004',1),('CC20140619.005',5),('CC20140619.006',1),('CC20140619.007',1),('CC20140619.008',1),('CC20140619.009',2),('CC20140619.010',1),('CC20140619.011',3),('CC20140620',2),('CC20140620.001',4),('CC20140620.002',1),('CC20140623',3),('CC20140623.001',2),('CC20140623.002',2),('CC20140623.003',4),('CC20140703',1),('CC20140703.001',1),('CC20140704',1),('CC20140704.001',1),('CC20140707',2),('CC20140707.001',2),('CC20140707.002',2),('CC20140805',1),('CC20140805.001',5),('CC20140916',2),('CC20140916.001',1),('CC20140916.002',2),('CC20140918',2),('CC20140918.001',2),('CC20140918.002',2),('CC20141021',1),('CC20141021.001',3),('CC20141210',1),('CC20141210.001',2),('CC20150904',1),('CC20150904.001',3),('CC20151202',2),('CC20151202.001',1),('CC20151202.002',1),('CC20151207',1),('CC20151207.001',2),('CC20160512',2),('CC20160512.001',1),('CC20160512.002',1),('CC20160513',1),('CC20160513.001',1),('CC20170419',1),('CC20170419.001',2),('CC20170515',1),('CC20170515.001',2),('CC20180110',1),('CC20180110.001',3),('CC20180111',2),('CC20180111.001',2),('CC20180111.002',2),('CC20180117',2),('CC20180117.001',1),('CC20180117.002',1),('CC20180122',1),('CC20180122.001',1),('CC20180124',3),('CC20180124.001',1),('CC20180124.002',2),('CC20180124.003',1),('CC20180125',2),('CC20180125.001',1),('CC20180125.002',1),('CC20180126',3),('CC20180206',2),('CC20180206.001',1),('CC20180206.002',1),('CC20180327',1),('CC20180327.001',7),('CC20180626',1),('CC20180626.001',1),('CC20180717',1),('CC20180717.001',1),('CC20180720',1),('CC20180720.001',2),('CC20180726',1),('CC20180726.001',3),('CC20180927',1),('CC20180927.001',1),('CC20180928',1),('CC20180928.001',1),('CC20181001',1),('CC20181129',1),('CC20181129.001',2),('CC20191004',1),('CC20191004.001',3),('CC20191009',2),('CC20191016',1),('CC20191016.001',1),('CC20191017',2),('CC20191017.001',1),('Client.Common.admin',1),('Client.Personal.admin',3),('CopyrightCase.Common.admin',1),('DF01',1),('DM20141119',1),('DM20141120',1),('DM20150820',2),('DM20150903',2),('DM20160308',1),('DM20170104',1),('DM20170120',1),('DM20170913',1),('DP01',2),('esther',3),('FM20141013',3),('FM20141119',1),('GT01',1),('GT02',3),('GU20140909',2),('GU20140911',1),('HC20140604',2),('HC20140610',1),('HC20141212',2),('HC20161127',1),('HC20170104',2),('HC20191113',2),('HH01',6),('HX',5),('Invoice.Common.admin',1),('Invoice.Personal.admin',1),('Invoice20140530',5),('Invoice20140530.001',2),('Invoice20140530.002',1),('Invoice20140530.003',1),('Invoice20140530.004',1),('Invoice20140609',2),('Invoice20140609.001',2),('Invoice20140609.002',2),('Invoice20140610',2),('Invoice20140610.002',2),('Invoice20140611',2),('Invoice20140611.001',1),('Invoice20140611.002',2),('Invoice20140612',22),('Invoice20140612.001',5),('Invoice20140612.002',2),('Invoice20140612.003',2),('Invoice20140612.004',3),('Invoice20140612.005',2),('Invoice20140612.006',2),('Invoice20140612.007',2),('Invoice20140612.008',2),('Invoice20140612.009',2),('Invoice20140612.010',2),('Invoice20140612.011',2),('Invoice20140612.012',2),('Invoice20140612.014',2),('Invoice20140612.015',2),('Invoice20140612.017',2),('Invoice20140612.022',2),('Invoice20140617',1),('Invoice20140617.001',2),('Invoice20140618',8),('Invoice20140618.003',1),('Invoice20140619',10),('Invoice20140619.010',2),('Invoice20140623',11),('Invoice20140623.004',2),('Invoice20140623.008',2),('Invoice20140623.009',2),('Invoice20140623.010',2),('Invoice20140623.011',2),('Invoice20140628',3),('Invoice20140628.001',2),('Invoice20140628.002',2),('Invoice20140628.003',2),('Invoice20140807',4),('Invoice20140807.003',2),('Invoice20140807.004',2),('Invoice20140821',4),('Invoice20140821.001',1),('Invoice20140821.002',1),('Invoice20140821.003',1),('Invoice20140821.004',1),('Invoice20140822',1),('Invoice20140822.001',1),('Invoice20140918',2),('Invoice20140918.001',2),('Invoice20140918.002',2),('Invoice20141014',1),('Invoice20141014.001',1),('Invoice20141016',1),('Invoice20141016.001',1),('Invoice20141020',2),('Invoice20141107',1),('Invoice20141107.001',2),('Invoice20141117',1),('Invoice20141118',2),('Invoice20141118.001',1),('Invoice20141118.002',4),('Invoice20141119',1),('Invoice20141119.001',1),('Invoice20141120',9),('Invoice20141120.001',1),('Invoice20141120.002',1),('Invoice20141120.003',1),('Invoice20141120.004',1),('Invoice20141120.005',1),('Invoice20141120.006',1),('Invoice20141120.007',1),('Invoice20141120.008',1),('Invoice20141120.009',1),('Invoice20150819',1),('Invoice20150828',1),('Invoice20150828.001',1),('Invoice20150905',1),('Invoice20150905.001',1),('Invoice20150918',1),('Invoice20150918.001',2),('Invoice20151112',1),('Invoice20151112.001',2),('Invoice20151207',1),('Invoice20151207.001',1),('Invoice20151226',2),('Invoice20151228',3),('Invoice20151228.001',2),('Invoice20160422',2),('Invoice20160422.002',2),('Invoice20160718',1),('Invoice20160718.001',2),('Invoice20161124',1),('Invoice20161128',1),('Invoice20161128.001',2),('Invoice20170515',2),('Invoice20170515.002',2),('Invoice20170717',2),('Invoice20170717.001',1),('Invoice20170717.002',1),('Invoice20170721',1),('Invoice20170721.001',1),('Invoice20170809',1),('Invoice20170809.001',1),('Invoice20171222',1),('Invoice20171222.001',1),('Invoice20180111',4),('Invoice20180111.001',2),('Invoice20180111.004',2),('Invoice20180115',3),('Invoice20180115.003',3),('Invoice20180117',3),('Invoice20180117.003',1),('Invoice20180125',8),('Invoice20180125.001',4),('Invoice20180125.002',4),('Invoice20180125.005',1),('Invoice20180125.007',1),('Invoice20180125.008',1),('Invoice20180206',2),('Invoice20180206.001',3),('Invoice20180206.002',3),('Invoice20180327',1),('Invoice20180327.001',2),('Invoice20180703',1),('Invoice20180703.001',2),('Invoice20180730',1),('Invoice20180730.001',1),('Invoice20180803',5),('Invoice20180803.001',4),('Invoice20180926',2),('Invoice20180926.001',1),('Invoice20180926.002',1),('Invoice20181019',1),('Invoice20181019.001',2),('Invoice20181116',1),('Invoice20181116.001',1),('Invoice20181129',1),('Invoice20181129.001',1),('Invoice20190410',1),('Invoice20190410.001',1),('Invoice20190612',1),('Invoice20190612.001',2),('Invoice20190625',1),('Invoice20190625.001',2),('Invoice20190806',1),('Invoice20190806.001',2),('Invoice20190826',1),('Invoice20190826.001',1),('Invoice20190923',1),('Invoice20190923.001',1),('Invoice20190926',1),('Invoice20190926.001',4),('Invoice20191016',2),('Invoice20191016.002',2),('Invoice20191017',3),('Invoice20191017.001',1),('Invoice20191017.002',1),('Invoice20191017.003',1),('Invoice20191113',1),('Invoice20191113.001',2),('IT20140530',3),('IT20140604',1),('IT20140605',5),('IT20140606',6),('IT20140609',3),('IT20140610',2),('IT20140613',2),('IT20140620',2),('IT20140915',2),('IT20140916',4),('IT20140930',1),('IT20141118',1),('IT20150208',1),('IT20150819',1),('IT20150904',3),('IT20151109',4),('IT20151202',1),('IT20151203',3),('IT20151207',4),('IT20160311',1),('IT20160511',3),('IT20160524',1),('IT20160711',1),('IT20161127',3),('IT20161220',1),('IT20170104',1),('IT20170320',1),('IT20170419',1),('IT20170515',1),('IT20170717',1),('IT20170721',1),('IT20170913',1),('IT20171222',1),('IT20180110',1),('IT20180116',1),('IT20180122',1),('IT20180123',1),('IT20180124',3),('IT20180125',2),('IT20180126',1),('IT20180206',1),('IT20180328',2),('IT20180626',1),('IT20180703',1),('IT20180704',1),('IT20180717',1),('IT20180720',4),('IT20180725',1),('IT20180727',1),('IT20180803',1),('IT20180927',1),('IT20181001',2),('IT20181019',1),('IT20181127',1),('IT20181129',1),('IT20190220',1),('IT20190221',1),('IT20190612',1),('IT20190621',1),('IT20190726',1),('IT20190819',1),('IT20190903',1),('IT20190918',1),('IT20190923',1),('IT20191009',5),('IT20191017',3),('JT',8),('KASAN',2),('KS',2),('KSP01',4),('L-L01-004-3-ABC-',1),('L-L02-001-3-ABC-',1),('L-L02-002-ABC-',1),('L-L03-002-3--',1),('L-L03-002-3-9487-',1),('L-L04-001-3-ABC-',1),('LC20140610',1),('LC20140610.001',30),('LC20140611',1),('LC20140611.001',30),('LC20140616',3),('LC20140916',2),('LC20140916.001',5),('LC20140916.002',15),('LC20141115',1),('LC20141115.001',6),('LC20141119',1),('LC20141119.001',16),('LC20151207',1),('LC20151207.001',19),('LC20161104',1),('LC20161104.001',29),('LC20170104',1),('LC20170717',1),('LC20170717.001',19),('LC20170721',1),('LC20170721.001',4),('LC20171222',1),('LC20171222.001',17),('LC20180116',1),('LC20180116.001',11),('LC20180117',1),('LC20180117.001',2),('LC20180128',1),('LC20180128.001',3),('LC20180129',1),('LC20180129.001',14),('LC20180208',1),('LC20180208.001',3),('LC20180211',1),('LC20180211.001',2),('LC20180227',2),('LC20180227.001',53),('LC20180227.002',7),('LC20180301',1),('LC20180301.001',14),('LC20180321',6),('LC20180321.001',6),('LC20180321.004',1),('LC20180321.005',3),('LC20180725',1),('LC20180725.001',12),('LC20180726',1),('LC20180727',1),('LC20180727.001',8),('LC20180803',1),('LC20180928',1),('LC20180928.001',7),('LC20181023',1),('LC20181023.001',10),('LC20181024',1),('LC20181024.001',6),('LC20190625',1),('LC20190625.001',7),('LC20190923',3),('LC20190923.001',9),('LegalCase.Common.admin',1),('Log20140530',110),('Log20140531',3),('Log20140602',2),('Log20140603',13),('Log20140604',35),('Log20140605',61),('Log20140606',89),('Log20140609',57),('Log20140610',209),('Log20140611',56),('Log20140612',147),('Log20140613',29),('Log20140616',8),('Log20140617',6),('Log20140618',46),('Log20140619',48),('Log20140620',50),('Log20140623',51),('Log20140625',6),('Log20140627',1),('Log20140628',4),('Log20140630',5),('Log20140701',4),('Log20140703',9),('Log20140704',3),('Log20140707',2),('Log20140709',3),('Log20140721',10),('Log20140722',2),('Log20140803',4),('Log20140805',27),('Log20140806',4),('Log20140807',58),('Log20140808',5),('Log20140811',4),('Log20140812',8),('Log20140813',8),('Log20140814',133),('Log20140817',1),('Log20140818',1),('Log20140821',4),('Log20140822',5),('Log20140828',2),('Log20140829',8),('Log20140830',1),('Log20140831',10),('Log20140901',1),('Log20140902',5),('Log20140903',12),('Log20140904',2),('Log20140909',14),('Log20140911',13),('Log20140912',5),('Log20140915',15),('Log20140916',37),('Log20140917',20),('Log20140918',54),('Log20140919',1),('Log20140924',3),('Log20140925',9),('Log20140926',10),('Log20140930',37),('Log20141001',30),('Log20141002',3),('Log20141003',3),('Log20141007',2),('Log20141008',15),('Log20141013',17),('Log20141014',19),('Log20141015',1),('Log20141016',3),('Log20141020',6),('Log20141021',13),('Log20141022',3),('Log20141106',7),('Log20141107',15),('Log20141113',11),('Log20141114',1),('Log20141115',5),('Log20141117',3),('Log20141118',14),('Log20141119',34),('Log20141120',42),('Log20141121',1),('Log20141127',18),('Log20141128',1),('Log20141130',2),('Log20141202',1),('Log20141204',3),('Log20141210',7),('Log20141212',13),('Log20141222',3),('Log20141225',7),('Log20141226',1),('Log20141229',1),('Log20150109',3),('Log20150112',7),('Log20150113',3),('Log20150120',1),('Log20150121',1),('Log20150204',5),('Log20150206',1),('Log20150208',4),('Log20150302',2),('Log20150303',1),('Log20150311',25),('Log20150317',1),('Log20150318',4),('Log20150424',6),('Log20150427',3),('Log20150429',1),('Log20150505',9),('Log20150508',3),('Log20150512',10),('Log20150514',9),('Log20150518',2),('Log20150522',1),('Log20150523',4),('Log20150527',5),('Log20150626',2),('Log20150702',2),('Log20150728',4),('Log20150811',4),('Log20150819',66),('Log20150820',12),('Log20150828',6),('Log20150903',2),('Log20150904',14),('Log20150905',56),('Log20150918',29),('Log20150923',34),('Log20151009',2),('Log20151015',4),('Log20151030',3),('Log20151104',11),('Log20151106',4),('Log20151109',58),('Log20151111',5),('Log20151112',28),('Log20151113',27),('Log20151116',1),('Log20151117',18),('Log20151118',13),('Log20151124',9),('Log20151125',1),('Log20151127',1),('Log20151201',4),('Log20151202',75),('Log20151203',53),('Log20151204',1),('Log20151207',79),('Log20151208',4),('Log20151209',4),('Log20151210',35),('Log20151211',1),('Log20151214',1),('Log20151215',8),('Log20151217',9),('Log20151221',15),('Log20151222',3),('Log20151226',6),('Log20151228',23),('Log20151230',13),('Log20160103',1),('Log20160105',2),('Log20160106',3),('Log20160107',2),('Log20160112',1),('Log20160122',1),('Log20160125',2),('Log20160218',8),('Log20160223',1),('Log20160302',2),('Log20160308',27),('Log20160309',8),('Log20160311',3),('Log20160312',6),('Log20160314',2),('Log20160318',1),('Log20160321',8),('Log20160322',3),('Log20160329',3),('Log20160406',8),('Log20160418',1),('Log20160419',4),('Log20160421',1),('Log20160422',21),('Log20160425',5),('Log20160503',4),('Log20160504',5),('Log20160505',4),('Log20160506',1),('Log20160511',6),('Log20160512',3),('Log20160513',1),('Log20160518',24),('Log20160524',5),('Log20160607',1),('Log20160608',12),('Log20160614',3),('Log20160630',5),('Log20160707',6),('Log20160711',13),('Log20160712',2),('Log20160713',1),('Log20160714',2),('Log20160718',18),('Log20160721',9),('Log20160728',2),('Log20160802',1),('Log20160906',1),('Log20161024',2),('Log20161028',1),('Log20161102',3),('Log20161104',14),('Log20161107',1),('Log20161124',21),('Log20161125',4),('Log20161127',16),('Log20161128',19),('Log20161129',1),('Log20161130',9),('Log20161201',19),('Log20161203',4),('Log20161209',2),('Log20161213',1),('Log20161214',6),('Log20161220',5),('Log20161221',6),('Log20161222',1),('Log20161230',4),('Log20170103',37),('Log20170104',23),('Log20170106',1),('Log20170109',5),('Log20170111',2),('Log20170112',12),('Log20170116',6),('Log20170117',51),('Log20170119',7),('Log20170120',18),('Log20170124',1),('Log20170202',1),('Log20170206',8),('Log20170208',2),('Log20170316',1),('Log20170320',23),('Log20170323',2),('Log20170324',1),('Log20170327',1),('Log20170328',7),('Log20170405',2),('Log20170411',3),('Log20170414',13),('Log20170417',1),('Log20170419',63),('Log20170420',1),('Log20170425',2),('Log20170509',1),('Log20170511',3),('Log20170515',40),('Log20170602',1),('Log20170619',9),('Log20170623',7),('Log20170628',10),('Log20170630',6),('Log20170703',5),('Log20170704',7),('Log20170705',2),('Log20170717',47),('Log20170718',16),('Log20170719',21),('Log20170721',57),('Log20170728',4),('Log20170804',7),('Log20170809',4),('Log20170810',6),('Log20170814',8),('Log20170822',6),('Log20170823',1),('Log20170828',19),('Log20170905',3),('Log20170906',3),('Log20170913',12),('Log20170921',6),('Log20171003',1),('Log20171006',8),('Log20171016',1),('Log20171025',1),('Log20171114',1),('Log20171115',2),('Log20171221',1),('Log20171222',23),('Log20171228',1),('Log20180109',5),('Log20180110',16),('Log20180111',54),('Log20180115',16),('Log20180116',27),('Log20180117',38),('Log20180118',2),('Log20180119',1),('Log20180122',10),('Log20180123',3),('Log20180124',31),('Log20180125',53),('Log20180126',17),('Log20180128',1),('Log20180129',5),('Log20180131',6),('Log20180205',2),('Log20180206',35),('Log20180208',7),('Log20180211',6),('Log20180227',40),('Log20180301',28),('Log20180307',3),('Log20180317',4),('Log20180319',2),('Log20180321',26),('Log20180322',2),('Log20180323',12),('Log20180326',6),('Log20180327',21),('Log20180328',6),('Log20180408',5),('Log20180410',3),('Log20180411',2),('Log20180412',2),('Log20180413',1),('Log20180419',3),('Log20180420',2),('Log20180423',1),('Log20180502',2),('Log20180510',1),('Log20180526',3),('Log20180605',3),('Log20180607',1),('Log20180608',3),('Log20180614',1),('Log20180626',25),('Log20180628',12),('Log20180629',1),('Log20180701',3),('Log20180703',19),('Log20180704',26),('Log20180710',11),('Log20180716',3),('Log20180717',16),('Log20180718',5),('Log20180720',13),('Log20180724',4),('Log20180725',17),('Log20180726',14),('Log20180727',40),('Log20180730',19),('Log20180731',7),('Log20180803',29),('Log20180808',1),('Log20180926',4),('Log20180927',21),('Log20180928',25),('Log20181001',11),('Log20181003',4),('Log20181008',2),('Log20181009',6),('Log20181018',23),('Log20181019',35),('Log20181023',9),('Log20181024',3),('Log20181030',3),('Log20181105',2),('Log20181108',3),('Log20181109',5),('Log20181116',36),('Log20181119',2),('Log20181122',1),('Log20181127',22),('Log20181128',2),('Log20181129',37),('Log20181203',2),('Log20181204',1),('Log20181205',9),('Log20181213',3),('Log20190220',30),('Log20190221',2),('Log20190226',5),('Log20190227',3),('Log20190313',1),('Log20190410',2),('Log20190527',1),('Log20190529',2),('Log20190605',2),('Log20190612',26),('Log20190613',1),('Log20190614',19),('Log20190621',8),('Log20190625',47),('Log20190703',3),('Log20190705',1),('Log20190707',3),('Log20190708',2),('Log20190726',7),('Log20190730',13),('Log20190806',14),('Log20190819',4),('Log20190822',1),('Log20190826',12),('Log20190903',9),('Log20190904',1),('Log20190905',13),('Log20190908',11),('Log20190909',12),('Log20190916',1),('Log20190917',2),('Log20190918',4),('Log20190923',33),('Log20190926',8),('Log20191004',3),('Log20191009',26),('Log20191013',2),('Log20191015',1),('Log20191016',39),('Log20191017',35),('Log20191021',1),('Log20191022',5),('Log20191028',1),('Log20191030',2),('Log20191104',1),('Log20191108',2),('Log20191113',31),('Log20191114',4),('Log20191115',1),('longriver01',8),('longriver02',1),('MF20140822',1),('MF20140830',1),('MF20140831',2),('MF20140901',1),('MF20140904',1),('MF20141013',1),('MF20141014',5),('MF20141119',2),('MF20141120',4),('MF20151203',1),('MF20160308',1),('MF20160505',1),('MF20170718',1),('MF20191113',2),('ML',6),('msa.hinet.net',1),('Nc20170103',1),('Nc20171228',1),('null',3),('OP20140902',2),('OP20140916',1),('OP20141001',2),('OP20141119',1),('OP20151207',1),('OP20170717',2),('OP20171222',1),('OP20180116',1),('OP20180301',1),('OP20180725',1),('OP20180928',1),('OP20181023',2),('OP20190625',1),('OP20190923',1),('P-14',1),('P-16',1),('P-PCC-001-1-6606-',1),('P-PCC-001-1-ABC-',1),('P-PCC-001-3-6606-',1),('P-PCC-001-3-ABC-',1),('P-PCC01-003-9589-',1),('P-PCC02-001-2-6606-',1),('P-PCC02-001-2-ABC-',1),('P-PCC02-001-3-6606-',1),('P-PCC02-001-3-ABC-',1),('P-PCC03-001-2-ABC-',1),('P-PCC03-001-3-ABC-',1),('P-PCN02-001',1),('P-PCN02-001--',1),('P-PCN02-001-9513-',1),('P-PCN02-001-9522-',1),('P-PCN02-001-ABC-',1),('P-PMC20140605.001-001-1-8851-',1),('P-PMC20140605.001-001-1-ABC-',1),('P-PMC20140605.002-001-2-8851-',1),('P-PMC20140605.002-001-2-9490-',1),('P-PMC20140605.002-001-2-9579-',1),('P-PMC20140605.002-001-2-ABC-',1),('P-PMC20140605.003-001-3-8851-',1),('P-PMC20140605.003-001-3-9490-',1),('P-PMC20140605.003-001-3-9579-',1),('P-PMC20140605.003-001-3-ABC-',1),('P-PMC20150819.001-001-3-ABC-',1),('P-PMC20150819.001-002-1-9513-',1),('P-PMC20150819.001-002-1-ABC-',1),('P-PMC20150819.002-001-3-ABC-',1),('P-PMC20160512.001-001-9513-',1),('P-PMC20160512.001-001-9522-',1),('P-PMC20160512.001-001-ABC-',1),('P-PT-CN-0001-001-3-9501-',3),('P-PT-CN-0001-001-3-ABC-',1),('P-PT-CN-0002-001-3-9501-',3),('P-PT-CN-0002-001-3-9589-',2),('P-PT-CN-0002-001-3-ABC-',1),('P-PT-US-0001-001-9501-',2),('P-PT-US-0001-001-9579-',1),('P-PT-US-0001-001-ABC-',1),('P-PT-US-0002-001-3-9501-',2),('P-PT-US-0002-001-3-ABC-',1),('P-PT-US-0003-001-3-9501-',2),('P-PT-US-0003-001-3-ABC-',1),('P-PT-US-0003-US-1-9501-',2),('P-PT-US-0003-US-1-ABC-',1),('P-PT-US-0003-US-2-9501-',2),('P-PT-US-0003-US-2-ABC-',1),('P-PT0001-002-3-9501-',3),('P-PT0001-002-3-ABC-',1),('P-PT0001-003-1--',1),('P-PT0001-003-1-9501-',3),('P-PT0001-003-1-ABC-',1),('P-PT0001-004-3-9522-',1),('P-PT0001-004-3-ABC-',1),('P-PT0001-005-3-9523-',1),('P-PT0001-005-3-ABC-',1),('P-PT0002-001-3-9501-',3),('P-PT0002-001-3-ABC-',1),('P-PT0003-001-1-9501-',3),('P-PT0003-001-1-ABC-',1),('P-PT0003-001-3-9501-',3),('P-PT0003-001-3-ABC-',1),('P-PT0003-002-ABC-',1),('P-PTA-001-1-0001-',1),('P-PTA-001-1-ABC-',1),('P-PTA-001-3-0001-',1),('P-PTA-001-3-ABC-',1),('P-PTA-002-1-ABC-',1),('P-PTA-003-3-ABC-',1),('P-PTA-004-3-ABC-',1),('P-PTAC-3-001-2-8895-',1),('P-PTAC-3-001-2-9489-',5),('P-PTAC-3-001-2-ABC-',1),('P-PTAC-3-3-3-8895-',1),('P-PTAC-3-3-3-9489-',5),('P-PTAC-3-3-3-9489-0001',1),('P-PTAC-3-3-3-ABC-',1),('P-PTC-001-1-0001-',1),('P-PTC-001-1-6619-',1),('P-PTC-001-1-884-',1),('P-PTC-001-1-8851-',1),('P-PTC-001-1-8888-',1),('P-PTC-001-1-8895-',2),('P-PTC-001-1-8897-',1),('P-PTC-001-1-ABC-',1),('P-PTC-001-3-0001-',1),('P-PTC-001-3-6619-',1),('P-PTC-001-3-884-',1),('P-PTC-001-3-8851-',1),('P-PTC-001-3-8888-',1),('P-PTC-001-3-8895-',2),('P-PTC-001-3-8897-',1),('P-PTC-001-3-ABC-',1),('P-PTC01-001-1-ABC-',1),('P-PTC01-001-3-ABC-',1),('P-PTC02-001-1-ABC-',1),('P-PTC02-001-3-ABC-',1),('P-PTC03-001-1--',1),('P-PTC03-001-1-6606-',2),('P-PTC03-001-1-ABC-',1),('P-PTC03-001-3--',1),('P-PTC03-001-3-6606-',2),('P-PTC03-001-3-ABC-',1),('P-PTC04-001-1-8888-',2),('P-PTC04-001-1-ABC-',1),('P-PTC04-001-3-8888-',2),('P-PTC04-001-3-ABC-',1),('P-PTC06-001-1-ABC-',1),('P-PTC06-001-3-ABC-',1),('P-PTC08-001-1-ABC-',1),('P-PTC08-001-3-ABC-',1),('P-PTM05-001-1-6606-',6),('P-PTM05-001-1-8851-',2),('P-PTM05-001-1-ABC-',1),('P-PTM05-001-3-6606-',7),('P-PTM05-001-3-6606-0001',1),('P-PTM05-001-3-6606-0007',1),('P-PTM05-001-3-8851-',2),('P-PTM05-001-3-ABC-',1),('P-PTWPN01PA010-001-1-9487-',1),('P-PTWPN01PA010-001-1-ABC-',1),('P-PTWPN01PA010-001-3--',1),('P-PTWPN01PA010-001-3-9487-',1),('P-PTWPN01PA010-001-3-ABC-',1),('P-PTWPN01PA010-002-3-9519-',3),('P-PTWPN01PA010-002-3-ABC-',1),('P-PTWPN01PA020-001-1-ABC-',1),('P-PTWPN01PA020-001-3-ABC-',1),('P-PTWPN01PA030-001-1-ABC-',1),('P-PTWPN01PA030-001-3-ABC-',1),('P-PTWPN01PA040-001-1-ABC-',1),('P-PTWPN01PA040-001-1-R1CH-',1),('P-PTWPN01PA040-002-3-ABC-',1),('P-PTWPN01PA040-002-3-R1CH-',1),('P-PTWPN02PA-001-1-9489-',1),('P-PTWPN02PA-001-3-9489-',1),('P-PTWPN02PA010-001-1-ABC-',1),('P-PTWPN02PA010-001-3-ABC-',1),('P-PTWPN02PA020-001-1-ABC-',1),('P-PTWPN02PA020-001-3-ABC-',1),('P-PTWPN02PA030-001-1-ABC-',1),('P-PTWPN02PA030-001-3-ABC-',1),('P-PTWPN02PA040-001-1-ABC-',1),('P-PTWPN02PA040-001-3-ABC-',1),('P-PTWPN03PA010-001-1-ABC-',1),('P-PTWPN03PA010-001-3-ABC-',1),('P-PTWPN03PA020-001-1-ABC-',1),('P-PTWPN03PA020-001-3-ABC-',1),('P-PTWPN03PA030-001-1-ABC-',1),('P-PTWPN03PA030-001-3-ABC-',1),('P-PTWPN03PA040-001-1-ABC-',1),('P-PTWPN03PA040-001-3-ABC-',1),('P-PUSPN01PA035-001-1-ABC-',1),('P-PUSPN01PA035-001-2--',1),('P-PUSPN01PA035-001-2-9516-',1),('P-PUSPN01PA035-001-2-ABC-',1),('P-PUSPN01PA035-001-3-ABC-',1),('P-PUSPN01PA070-001-1-ABC-',1),('P-PUSPN01PA070-001-2-ABC-',1),('P-PUSPN01PA070-001-3-ABC-',1),('P-TWP01-006-1-0001-',1),('P-TWP01-006-1-0002-',2),('P-TWP01-006-1-9489-',1),('P-TWP01-006-1-9553-',1),('P-TWP01-006-1-ABC-',1),('P-TWP01-006-3-0001-',1),('P-TWP01-006-3-0002-',1),('P-TWP01-006-3-9495-',1),('P-TWP01-006-3-9553-',1),('P-TWP01-006-3-ABC-',1),('P-TWP01-007-1-0003-',2),('P-TWP01-007-1-6606-',1),('P-TWP01-007-1-ABC-',1),('P-TWP01-007-3-0003-',2),('P-TWP01-007-3-6606-',1),('P-TWP01-007-3-9487-',1),('P-TWP01-007-3-9579-',1),('P-TWP01-007-3-ABC-',1),('P-TWP01-008-1-9487-',1),('P-TWP01-008-1-9489-',1),('P-TWP01-008-1-9579-',1),('P-TWP01-008-1-ABC-',1),('P-TWP01-009-3-ABC-',1),('P-TWP01-010-9516-',1),('P-TWP01-010-ABC-',1),('P-TWP01-016-1-9513-',1),('P-TWP01-016-1-ABC-',1),('P-TWP01-016-1-HOMN-',1),('P-TWP01-018-3-9588-',1),('PatentCase.Common.admin',8),('PatentCase.Common.test',4),('PatentCase.Personal.admin',2),('Pay20140531',1),('Pay20140605',7),('Pay20140609',3),('Pay20140609.003',5),('Pay20140618',1),('Pay20140620',1),('Pay20140623',2),('Pay20140623.002',1),('Pay20140721',1),('Pay20140917',1),('Pay20140925',1),('Pay20150505',4),('Pay20150514',1),('Pay20150518',1),('Pay20150905',1),('Pay20151030',1),('Pay20151228',4),('Pay20180117',1),('Pay20180205',1),('Pay20180730',1),('Pay20181019',1),('Pay20190220',1),('Pay20190612',1),('Pay20190625',1),('Pay20190806',1),('Pay20191016',1),('PC20140530',7),('PC20140530.001',11),('PC20140530.002',1),('PC20140530.003',3),('PC20140530.004',9),('PC20140530.005',1),('PC20140530.006',3),('PC20140530.007',7),('PC20140602',1),('PC20140602.001',2),('PC20140605',6),('PC20140605.001',2),('PC20140605.002',14),('PC20140605.003',2),('PC20140605.004',13),('PC20140605.005',7),('PC20140605.006',5),('PC20140606',5),('PC20140606.001',4),('PC20140606.002',2),('PC20140606.003',2),('PC20140606.004',3),('PC20140609',7),('PC20140609.001',2),('PC20140609.003',2),('PC20140609.004',1),('PC20140609.005',2),('PC20140609.007',1),('PC20140610',1),('PC20140610.001',1),('PC20140611',6),('PC20140611.002',4),('PC20140611.004',1),('PC20140612',1),('PC20140612.001',1),('PC20140618',5),('PC20140618.001',6),('PC20140618.004',3),('PC20140619',2),('PC20140619.002',2),('PC20140623',3),('PC20140623.001',4),('PC20140623.003',2),('PC20140625',1),('PC20140625.001',1),('PC20140709',1),('PC20140709.001',31),('PC20140811',1),('PC20140811.001',6),('PC20140828',1),('PC20140828.001',4),('PC20140903',1),('PC20140917',3),('PC20140917.001',11),('PC20140917.002',16),('PC20140917.003',5),('PC20140918',2),('PC20140918.001',4),('PC20140918.002',1),('PC20140930',4),('PC20140930.001',20),('PC20140930.002',22),('PC20140930.003',18),('PC20140930.004',30),('PC20141008',1),('PC20141008.001',10),('PC20141021',3),('PC20141021.001',4),('PC20141021.002',3),('PC20141118',1),('PC20141118.001',16),('PC20150204',1),('PC20150208',1),('PC20150208.001',5),('PC20150318',1),('PC20150318.001',3),('PC20150424',1),('PC20150424.001',1),('PC20150512',3),('PC20150512.001',1),('PC20150512.002',10),('PC20150512.003',2),('PC20150819',3),('PC20150819.001',3),('PC20150819.002',20),('PC20150819.003',11),('PC20150820',1),('PC20151104',2),('PC20151104.001',9),('PC20151104.002',4),('PC20151109',1),('PC20151109.001',31),('PC20151112',1),('PC20151112.001',11),('PC20151117',1),('PC20151117.001',2),('PC20151118',1),('PC20151118.001',2),('PC20151124',1),('PC20151124.001',2),('PC20151202',5),('PC20151202.001',12),('PC20151202.002',12),('PC20151202.003',7),('PC20151202.004',5),('PC20151202.005',16),('PC20151203',10),('PC20151203.001',14),('PC20151203.002',6),('PC20151203.003',10),('PC20151203.004',19),('PC20151203.005',11),('PC20151203.006',17),('PC20151203.007',15),('PC20151203.008',10),('PC20151203.009',9),('PC20151203.010',5),('PC20151207',2),('PC20151207.001',67),('PC20151207.002',15),('PC20151210',1),('PC20151210.001',12),('PC20151215',1),('PC20151215.001',26),('PC20160218',2),('PC20160218.001',2),('PC20160218.002',3),('PC20160312',1),('PC20160312.001',40),('PC20160406',1),('PC20160406.001',4),('PC20160511',2),('PC20160511.001',1),('PC20160518',3),('PC20160518.001',17),('PC20160518.002',5),('PC20160518.003',23),('PC20160707',1),('PC20160728',1),('PC20160728.001',7),('PC20161127',2),('PC20161127.002',4),('PC20161128',1),('PC20161128.001',4),('PC20161129',1),('PC20161129.001',23),('PC20170104',1),('PC20170104.001',14),('PC20170112',2),('PC20170112.002',1),('PC20170320',1),('PC20170320.001',9),('PC20170323',1),('PC20170414',1),('PC20170414.001',6),('PC20170419',1),('PC20170419.001',6),('PC20170420',1),('PC20170420.001',3),('PC20170515',1),('PC20170515.001',19),('PC20170728',1),('PC20170728.001',1),('PC20170828',2),('PC20170828.001',13),('PC20170828.002',7),('PC20171006',1),('PC20171006.001',11),('PC20180111',1),('PC20180111.001',1),('PC20180117',1),('PC20180117.001',25),('PC20180408',1),('PC20180408.001',13),('PC20180626',1),('PC20180626.001',15),('PC20180628',2),('PC20180628.001',14),('PC20180628.002',10),('PC20180701',1),('PC20180704',1),('PC20180704.001',12),('PC20180710',1),('PC20180710.001',25),('PC20180717',1),('PC20180717.001',8),('PC20180720',1),('PC20180720.001',10),('PC20180727',1),('PC20180727.001',14),('PC20180928',1),('PC20180928.001',14),('PC20181001',2),('PC20181001.001',1),('PC20181001.002',8),('PC20181003',1),('PC20181003.001',6),('PC20181009',2),('PC20181009.001',4),('PC20181009.002',1),('PC20181018',1),('PC20181018.001',6),('PC20181019',1),('PC20181019.001',3),('PC20181116',1),('PC20181116.001',2),('PC20181127',1),('PC20181127.001',15),('PC20181213',1),('PC20181213.001',12),('PC20190220',1),('PC20190220.001',11),('PC20190612',1),('PC20190612.001',9),('PC20190614',2),('PC20190614.001',2),('PC20190614.002',1),('PC20190625',1),('PC20190625.001',13),('PC20190730',1),('PC20190730.001',12),('PC20190806',2),('PC20190806.001',4),('PC20190819',1),('PC20190819.001',2),('PC20190826',1),('PC20190826.001',6),('PC20190903',1),('PC20190903.001',14),('PC20190918',1),('PC20190918.001',1),('PC20191009',3),('PC20191009.001',2),('PC20191009.002',2),('PC20191009.003',3),('PC20191016',2),('PC20191016.001',7),('PC20191017',3),('PC20191017.001',5),('PC20191017.002',7),('PC20191017.003',3),('PL0001',2),('PM20140605',1),('PM20140618',5),('PM20140620',3),('PM20140623',5),('PM20140628',1),('PM20140704',1),('PM20140911',3),('PM20141127',2),('PM20141129',1),('PM20150429',1),('PM20150505',4),('PM20150514',1),('PM20150905',1),('PM20160422',1),('PM20170511',2),('PM20170810',1),('PM20180317',1),('PM20190625',1),('PM20191016',1),('PMC20140530',1),('PMC20140603',1),('PMC20140604',1),('PMC20140605',3),('PMC20140610',1),('PMC20140625',1),('PMC20140805',2),('PMC20140903',3),('PMC20141128',1),('PMC20150819',2),('PMC20150918',1),('PMC20151203',1),('PMC20160512',1),('PMC20160513',1),('PMC20160516',1),('PMC20160518',1),('PMC20170104',1),('PMC20180110',3),('PMC20180323',1),('PT01',5),('PTW-TG-N-9513-',1),('PTW-TG-N-ABC-',1),('PTW-TG-N-HOMN-',2),('PTW-TG-N-R1CH-',1),('PTW-TP-N-1234-',1),('PTW-TP-N-9513-',1),('PTW-TP-N-9516-',1),('PTW-TP-N-9550-',1),('PTW-TP-N-9558-',2),('PTW-TP-N-9590-',2),('PTW-TP-N-ABC-',1),('PTW-TP-N-HOMN-',1),('PTW-TP-N-R1CH-',1),('PWC',7),('RD20141118',1),('RD20150204',1),('RD20161127',1),('RD20161229',1),('RD20170327',2),('RD20180419',1),('RL',1),('RM20140530',1),('RM20140609',1),('RM20140612',2),('RM20140623',4),('RM20140625',1),('RM20140709',1),('RM20140721',1),('RM20140911',2),('RM20140919',2),('RM20140925',1),('RM20141013',1),('RM20141119',1),('RM20150514',1),('RM20150918',1),('RM20161127',1),('RM20180111',2),('RM20180117',1),('RM20180125',2),('RM20180126',1),('RM20180206',2),('RM20180327',1),('RM20180730',1),('RM20180803',1),('RM20181018',1),('RM20181019',1),('RM20181129',1),('RM20181213',1),('RM20190227',1),('RM20190612',1),('RM20190625',1),('RM20190806',1),('RM20191016',2),('RM20191113',1),('RTS20140805',1),('S-PMC20140903.001-002-3--',1),('S-PMC20140903.001-002-3-9533-',1),('S-PMC20140903.001-002-3-ABC-',3),('S-PMC20180110.003-001-3-9533-',1),('S-PMC20180110.003-001-3-ABC-',3),('S-PMC20180110.003-002-3-1234-',1),('S-PMC20180110.003-002-3-9533-',1),('SM20170619',2),('SM20170619.00120170619',1),('SM20170619.00220170619',1),('SM20170619.00220170623',3),('SM20170623',1),('SM20170623.00120170623',3),('SM20170628',5),('SM20170628.00420170628',4),('SM20170628.00420170630',3),('SM20170628.00520170630',1),('SM20170628.00520170703',1),('SM20170628.00520170704',3),('SM20170628.00520170705',1),('SM20170703',2),('SM20170703.00220170704',1),('SM20170704',1),('SM20170704.00120170704',2),('SM20170704.00120170705',1),('SM20170810',1),('SM20170810.00120170810',1),('SM20170905',2),('SM20170905.00120170905',1),('SM20170905.00220170906',1),('SM20180111',1),('SM20180116',2),('SM20180116.00120180116',2),('SM20180116.00220180116',1),('SM20180614',1),('SM20180928',1),('SM20180928.00120180928',1),('SM20181019',1),('SM20181019.00120181019',1),('SM20181019.00120181116',5),('SM20181116',5),('SM20181116.00120181116',2),('SM20181116.00120181129',1),('SM20181116.00220181116',11),('SM20181116.00420181116',1),('SM20181116.00420181129',2),('SM20181116.00520181116',2),('SM20181127',1),('SM20181127.00120181127',1),('SM20181127.00120181129',4),('SM20181129',3),('SM20181129.00120181129',2),('SM20181129.00220181129',2),('SM20181129.00320181129',1),('SM20181129.00320181205',1),('SM20190926',1),('SM20190926.00120190926',1),('SM20191021',1),('SM20191022',2),('SM20191022.00120191022',1),('SM20191022.00220191022',2),('SM20191028',1),('SO20140530',15),('SO20140530.001',2),('SO20140530.003',2),('SO20140530.005',1),('SO20140530.007',1),('SO20140530.009',2),('SO20140530.011',1),('SO20140530.013',2),('SO20140530.015',2),('SO20140602',2),('SO20140602.002',10),('SO20140605',12),('SO20140605.001',3),('SO20140605.003',2),('SO20140605.005',2),('SO20140605.007',4),('SO20140605.009',4),('SO20140605.011',3),('SO20140606',18),('SO20140606.001',2),('SO20140606.003',2),('SO20140606.005',2),('SO20140606.007',2),('SO20140606.009',2),('SO20140606.011',2),('SO20140606.013',2),('SO20140606.015',2),('SO20140606.017',2),('SO20140609',6),('SO20140609.001',2),('SO20140609.003',2),('SO20140609.005',2),('SO20140610',32),('SO20140610.001',2),('SO20140610.003',4),('SO20140610.005',4),('SO20140610.007',2),('SO20140610.009',2),('SO20140610.011',2),('SO20140610.013',2),('SO20140610.015',2),('SO20140610.017',2),('SO20140610.019',2),('SO20140610.021',2),('SO20140610.023',2),('SO20140610.025',2),('SO20140610.027',2),('SO20140610.029',2),('SO20140610.031',2),('SO20140611',8),('SO20140611.001',1),('SO20140611.004',3),('SO20140611.008',6),('SO20140612',18),('SO20140612.001',3),('SO20140612.003',3),('SO20140612.005',2),('SO20140612.007',2),('SO20140612.009',2),('SO20140612.011',2),('SO20140612.014',2),('SO20140612.015',2),('SO20140612.017',2),('SO20140613',4),('SO20140613.002',2),('SO20140613.003',2),('SO20140618',12),('SO20140618.001',2),('SO20140618.003',2),('SO20140618.005',2),('SO20140618.007',1),('SO20140618.009',1),('SO20140618.011',1),('SO20140619',16),('SO20140619.001',2),('SO20140619.003',2),('SO20140619.005',2),('SO20140619.007',2),('SO20140619.009',2),('SO20140619.011',2),('SO20140619.013',2),('SO20140619.015',2),('SO20140620',12),('SO20140620.001',1),('SO20140620.003',1),('SO20140620.005',1),('SO20140620.007',1),('SO20140620.009',1),('SO20140620.011',1),('SO20140623',8),('SO20140623.001',2),('SO20140623.003',2),('SO20140623.005',2),('SO20140623.007',2),('SO20140625',2),('SO20140625.002',2),('SO20140703',2),('SO20140703.002',2),('SO20140805',16),('SO20140805.003',2),('SO20140805.005',2),('SO20140805.007',2),('SO20140805.009',2),('SO20140805.011',2),('SO20140805.013',2),('SO20140805.015',4),('SO20140807',2),('SO20140807.001',2),('SO20140815',6),('SO20140815.001',2),('SO20140815.005',2),('SO20140816',24),('SO20140816.005',2),('SO20140816.007',2),('SO20140816.009',2),('SO20140816.011',2),('SO20140816.013',2),('SO20140816.015',2),('SO20140816.017',2),('SO20140816.019',2),('SO20140816.021',2),('SO20140816.023',2),('SO20140817',14),('SO20140817.001',2),('SO20140817.003',2),('SO20140817.005',2),('SO20140817.007',2),('SO20140817.009',2),('SO20140817.011',2),('SO20140817.013',3),('SO20140904',2),('SO20140904.001',2),('SO20140911',2),('SO20140911.001',2),('SO20140918',6),('SO20140918.002',1),('SO20140918.004',2),('SO20140918.006',1),('SO20140926',2),('SO20140926.001',2),('SO20141008',4),('SO20141008.001',2),('SO20141008.003',2),('SO20141021',4),('SO20141021.003',2),('SO20141118',4),('SO20141118.001',2),('SO20141119',2),('SO20141119.001',1),('SO20150819',8),('SO20150905',8),('SO20150905.001',1),('SO20150905.003',1),('SO20150905.005',1),('SO20150918',2),('SO20150918.001',2),('SO20151112',2),('SO20151112.001',2),('SO20151125',2),('SO20151202',4),('SO20151202.001',2),('SO20151202.003',2),('SO20151207',2),('SO20151207.001',2),('SO20160711',4),('SO20160711.001',1),('SO20160711.003',1),('SO20161128',4),('SO20161128.002',2),('SO20161128.004',2),('SO20170414',4),('SO20170414.001',2),('SO20170419',2),('SO20170419.001',2),('SO20170515',2),('SO20170515.001',1),('SO20170721',2),('SO20170721.002',1),('SO20170728',2),('SO20170728.001',1),('SO20171222',4),('SO20171222.002',1),('SO20171222.004',1),('SO20180111',8),('SO20180111.001',2),('SO20180111.003',1),('SO20180111.005',1),('SO20180111.007',2),('SO20180115',10),('SO20180115.005',2),('SO20180115.007',2),('SO20180115.009',3),('SO20180116',2),('SO20180116.001',2),('SO20180117',8),('SO20180117.001',1),('SO20180117.003',1),('SO20180117.005',1),('SO20180117.007',4),('SO20180124',10),('SO20180124.001',1),('SO20180124.003',1),('SO20180124.005',1),('SO20180124.007',1),('SO20180124.009',1),('SO20180125',8),('SO20180125.001',1),('SO20180125.003',1),('SO20180125.005',1),('SO20180125.007',1),('SO20180206',6),('SO20180206.001',2),('SO20180206.003',3),('SO20180206.005',3),('SO20180317',4),('SO20180317.003',2),('SO20180327',2),('SO20180327.001',2),('SO20180410',2),('SO20180626',4),('SO20180626.002',4),('SO20180626.004',2),('SO20180704',6),('SO20180704.004',2),('SO20180704.006',2),('SO20180710',2),('SO20180717',2),('SO20180717.002',1),('SO20180725',4),('SO20180725.002',1),('SO20180725.004',1),('SO20180727',4),('SO20180727.002',1),('SO20180727.004',2),('SO20180730',2),('SO20180730.002',1),('SO20180803',4),('SO20180803.002',4),('SO20180803.004',1),('SO20181001',2),('SO20181018',6),('SO20181018.001',2),('SO20181018.003',2),('SO20181018.005',2),('SO20181019',4),('SO20181019.002',1),('SO20181019.004',2),('SO20181116',2),('SO20181116.001',1),('SO20181128',2),('SO20181128.002',2),('SO20181129',4),('SO20181129.001',1),('SO20181205',2),('SO20190220',4),('SO20190220.002',2),('SO20190220.004',1),('SO20190612',2),('SO20190612.002',2),('SO20190625',6),('SO20190625.002',2),('SO20190625.004',2),('SO20190625.006',3),('SO20190730',2),('SO20190730.002',2),('SO20190806',2),('SO20190806.002',4),('SO20190819',2),('SO20190819.002',1),('SO20190826',2),('SO20190826.001',1),('SO20190905',6),('SO20190905.002',2),('SO20190905.006',2),('SO20190918',2),('SO20190923',6),('SO20190923.002',1),('SO20190923.004',1),('SO20190923.006',1),('SO20190926',2),('SO20190926.002',4),('SO20191009',2),('SO20191016',4),('SO20191016.001',2),('SO20191017',6),('SO20191017.002',1),('SO20191017.004',1),('SO20191017.005',1),('SP20140610',1),('SP20140610.001',11),('SP20140807',1),('SP20140807.001',8),('SP20141001',1),('SP20170104',1),('SP20170104.001',3),('SP20170721',1),('SP20180301',1),('SP20180301.001',1),('SP20190923',1),('steven',6),('T-123-002-1--',1),('T-123-002-1-9513-',1),('T-123-002-1-ABC-',1),('T-123-003-1-ABC-',1),('T-123-004-1-ABC-',1),('T-TCNTT01PA100-001-1-ABC-',1),('T-TCNTT01PA100-001-2-ABC-',1),('T-TCNTT01PA100-001-3-ABC-',1),('T-TJPTT01PA100-001-1-ABC-',2),('T-TJPTT01PA100-001-2-ABC-',2),('T-TJPTT01PA100-001-3--',1),('T-TJPTT01PA100-001-3-ABC-',2),('T-TM01-002-1-0001-',1),('T-TM01-002-3-0001-',1),('T-TM1-001-1-9062-',3),('T-TM1-001-1-9266-',1),('T-TM1-001-1-9485-',1),('T-TM1-001-1-9491-',1),('T-TM1-001-1-ABC-',1),('T-TM1-001-3--',1),('T-TM1-001-3-9062-',2),('T-TM1-001-3-9485-',1),('T-TM1-001-3-9491-',1),('T-TM1-001-3-ABC-',1),('T-TM10-001-1-ABC-',1),('T-TM10-001-3-ABC-',1),('T-TM12-001-1-ABC-',1),('T-TM12-001-3-ABC-',1),('T-TM14-001-1-ABC-',1),('T-TM14-001-3-ABC-',1),('T-TM15-001-1-ABC-',1),('T-TM15-001-3-9266-',1),('T-TM15-001-3-ABC-',1),('T-TM16-001-1-9266-',1),('T-TM16-001-1-ABC-',1),('T-TM16-001-3-9266-',1),('T-TM16-001-3-ABC-',1),('T-TM4-001-1-ABC-',1),('T-TM4-001-3-ABC-',1),('T-TM5-001-1-9491-',1),('T-TM5-001-3--',1),('T-TM5-001-3-9491-',1),('T-TM6-001-2-9485-',1),('T-TM6-001-2-9489-',2),('T-TM6-001-2-9491-',1),('T-TM6-001-2-ABC-',1),('T-TM6-001-3--',1),('T-TM6-001-3-9485-',1),('T-TM6-001-3-9489-',2),('T-TM6-001-3-9491-',1),('T-TM6-001-3-ABC-',1),('T-TM7-001-1-9485-',1),('T-TM7-001-1-9487-',1),('T-TM7-001-1-ABC-',1),('T-TM7-001-3-9485-',1),('T-TM7-001-3-9487-',1),('T-TM7-001-3-ABC-',1),('T-TM8-001-1-6606-',1),('T-TM8-001-1-9485-',1),('T-TM8-001-1-9491-',2),('T-TM8-001-1-ABC-',1),('T-TM8-001-3--',3),('T-TM8-001-3-6606-',1),('T-TM8-001-3-9485-',1),('T-TM8-001-3-9491-',2),('T-TM8-001-3-ABC-',1),('T-TM8-002-9535-',1),('T-TM8-002-9536-',1),('T-TM8-002-9537-',1),('T-TM8-002-9539-',1),('T-TTWTT01PA-001-1-9485-',1),('T-TTWTT01PA-001-3-9485-',1),('T-TTWTT01PA100-001-1-ABC-',4),('T-TTWTT01PA100-001-3-ABC-',4),('T-TTWTT02PA-001-1-9485-',1),('T-TTWTT02PA-001-3-9485-',1),('T-TTWTT02PA100-001-1-9495-',1),('T-TTWTT02PA100-001-1-ABC-',4),('T-TTWTT02PA100-001-3-9495-',1),('T-TTWTT02PA100-001-3-ABC-',4),('T-TUSTT01PA100-001-1--',1),('T-TUSTT01PA100-001-1-0001-',1),('T-TUSTT01PA100-001-1-ABC-',7),('T-TUSTT01PA100-001-2-0001-',1),('T-TUSTT01PA100-001-2-9516-',1),('T-TUSTT01PA100-001-2-9533-',1),('T-TUSTT01PA100-001-2-ABC-',7),('T-TUSTT01PA100-001-3--',1),('T-TUSTT01PA100-001-3-0001-',1),('T-TUSTT01PA100-001-3-9512-',1),('T-TUSTT01PA100-001-3-9516-',2),('T-TUSTT01PA100-001-3-9567-',1),('T-TUSTT01PA100-001-3-ABC-',7),('TC20140530',2),('TC20140530.001',5),('TC20140530.002',4),('TC20140606',5),('TC20140606.001',6),('TC20140606.002',3),('TC20140606.003',12),('TC20140606.004',5),('TC20140606.005',4),('TC20140609',1),('TC20140609.001',11),('TC20140619',6),('TC20140619.002',1),('TC20140619.003',2),('TC20140619.004',1),('TC20140619.005',1),('TC20140619.006',1),('TC20140620',7),('TC20140620.001',1),('TC20140620.002',3),('TC20140620.003',1),('TC20140620.004',1),('TC20140620.005',2),('TC20140620.006',19),('TC20140620.007',1),('TC20140623',1),('TC20140623.001',1),('TC20140805',6),('TC20140805.002',2),('TC20140805.003',2),('TC20140805.005',3),('TC20140805.006',3),('TC20140911',1),('TC20140911.001',4),('TC20140926',1),('TC20140926.001',6),('TC20141008',1),('TC20141008.001',12),('TC20150820',1),('TC20150820.001',6),('TC20150905',2),('TC20150905.001',8),('TC20150905.002',1),('TC20151117',1),('TC20151117.001',5),('TC20151118',1),('TC20151118.001',4),('TC20151207',1),('TC20151207.001',19),('TC20160505',1),('TC20160505.001',6),('TC20160518',1),('TC20160518.001',5),('TC20160707',1),('TC20160711',2),('TC20160711.001',10),('TC20160711.002',11),('TC20170104',1),('TC20170104.001',2),('TC20170906',1),('TC20170913',1),('TC20170913.001',4),('TC20180111',2),('TC20180111.001',12),('TC20180111.002',1),('TC20180115',3),('TC20180115.001',1),('TC20180115.002',1),('TC20180115.003',1),('TC20180116',1),('TC20180116.001',10),('TC20180117',2),('TC20180117.001',3),('TC20180117.002',3),('TC20180124',5),('TC20180124.001',2),('TC20180124.002',2),('TC20180124.003',1),('TC20180124.004',1),('TC20180124.005',2),('TC20180125',4),('TC20180125.001',1),('TC20180125.002',3),('TC20180125.003',1),('TC20180125.004',2),('TC20180327',1),('TC20180327.001',5),('TC20180626',1),('TC20180626.001',8),('TC20180704',1),('TC20180704.001',8),('TC20180717',1),('TC20180717.001',5),('TC20180726',1),('TC20180727',1),('TC20180727.001',8),('TC20180928',1),('TC20180928.001',2),('TC20181018',2),('TC20181018.001',4),('TC20181018.002',4),('TC20181019',1),('TC20181019.001',7),('TC20181109',1),('TC20181116',1),('TC20181116.001',3),('TC20181127',1),('TC20181127.001',12),('TC20181129',1),('TC20181129.001',5),('TC20181205',1),('TC20181205.001',9),('TC20190220',1),('TC20190220.001',8),('TC20190614',1),('TC20190614.001',7),('TC20190625',1),('TC20190625.001',11),('TC20190730',1),('TC20190730.001',9),('TC20190905',1),('TC20190905.001',9),('TC20191009',2),('TC20191009.001',2),('TC20191009.002',2),('TC20191017',1),('TC20191017.001',1),('TC20191030',1),('TC20191030.001',4),('TC20191104',1),('TC20191104.001',3),('TD20140805',1),('TD20150512',1),('TD20180322',1),('TDMail14219',1),('TDMail14269',1),('tek01',3),('test',9),('test0707',6),('test0711',4),('test20180110',4),('Test20180115',1),('test20180803',1),('test4',5),('test7',2),('titanpat01',10),('TLS0001',10),('TPFM',3),('TrademarkCase.Common.admin',3),('TrademarkCase.Personal.admin',1),('TrademarkRenewalLog.Personal.admin',1),('TSM20140531',1),('TSM20140610',4),('TSM20140618',2),('TSM20140812',1),('TSM20140821',2),('TSM20140822',3),('TSM20140831',1),('TSM20140912',1),('TSM20140915',1),('TSM20141001',1),('TSM20141013',2),('TSM20141014',1),('TSM20141119',4),('TSM20141120',5),('TSM20160718',2),('TSM20170717',3),('TSM20170721',1),('TSM20171222',1),('TSM20180116',3),('TSM20180227',1),('TSM20180326',1),('TSM20180725',1),('TSM20180727',1),('TSM20180730',1),('TSM20180803',1),('TSM20180928',1),('TSM20190625',2),('TSM20190923',1),('TSM20191113',5),('TSM20191114',1),('UF20140821',1),('UF20140915',1),('UL14157',6),('UL14160',3),('UL14161',1),('UL14168',1),('UL14174',1),('UL14178',1),('UL14183',1),('UL14202',5),('UL14218',1),('UL14233',1),('UL14234',1),('UL14241',2),('UL14258',1),('UL14260',1),('UL14267',1),('UL14276',1),('UL14321',2),('UL14322',3),('UL14324',5),('UL14338',3),('UL14344',1),('UL14359',1),('UL15035',1),('UL15070',2),('UL15076',1),('UL15105',1),('UL15313',3),('UL15316',1),('UL15355',1),('UL16054',1),('UL16126',2),('UL16139',3),('UL16159',2),('UL16160',6),('UL16166',1),('UL16200',2),('UL16203',2),('UL16364',3),('UL17003',3),('UL17016',3),('UL17018',1),('UL17019',5),('UL17020',27),('UL17023',1),('UL17024',4),('UL17033',6),('UL17044',1),('UL17086',2),('UL17170',2),('UL17174',1),('UL17179',2),('UL17256',1),('UL17298',1),('UL17319',1),('UL18011',1),('UL18016',2),('UL18080',1),('UL18109',1),('UL18271',1),('UL18282',1),('UL18292',2),('UL18327',2),('UL18331',2),('UL19051',2),('UL19165',1),('UL19176',1),('UL19266',1),('WIPO',4),('YUSO',5),('zoe',1);
/*!40000 ALTER TABLE `pkeyno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precase`
--

DROP TABLE IF EXISTS `precase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precase` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Summary` varchar(200) NOT NULL,
  `ApplyDate` varchar(10) NOT NULL,
  `Title` varchar(200) NOT NULL,
  `EnglishTitle` varchar(200) NOT NULL,
  `Contact1` varchar(50) NOT NULL,
  `Tel1` varchar(50) NOT NULL,
  `Mobile1` varchar(50) NOT NULL,
  `Contact2` varchar(50) NOT NULL,
  `Tel2` varchar(50) NOT NULL,
  `Mobile2` varchar(50) NOT NULL,
  `ProjectTitle` varchar(200) NOT NULL,
  `ProjectNumber` varchar(50) NOT NULL,
  `ProjectDuration` varchar(50) NOT NULL,
  `ProjectSponser` varchar(50) NOT NULL,
  `Attachments01` int(11) NOT NULL,
  `Attachments02` int(11) NOT NULL,
  `Attachments03` int(11) NOT NULL,
  `Attachments04` int(11) NOT NULL,
  `Attachments05` char(1) NOT NULL,
  `PatentType` varchar(50) NOT NULL,
  `ApplyCountries` varchar(200) NOT NULL,
  `ApplyReason` varchar(500) NOT NULL,
  `ApplyPriority` varchar(200) NOT NULL,
  `NotPublicFlag` char(1) NOT NULL,
  `PublicDate` varchar(10) NOT NULL,
  `PublicName` varchar(200) NOT NULL,
  `PublicArea` varchar(50) NOT NULL,
  `PublicData` varchar(50) NOT NULL,
  `PatentSearchedNo` varchar(50) NOT NULL,
  `Technology` varchar(200) NOT NULL,
  `Prior` varchar(200) NOT NULL,
  `Industries` varchar(200) NOT NULL,
  `Products` varchar(200) NOT NULL,
  `Licensees` varchar(200) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precase`
--

LOCK TABLES `precase` WRITE;
/*!40000 ALTER TABLE `precase` DISABLE KEYS */;
/*!40000 ALTER TABLE `precase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ShortNames` varchar(50) DEFAULT NULL,
  `FullNames` varchar(200) DEFAULT NULL,
  `Specifications` varchar(200) DEFAULT NULL,
  `PhotoUrl` varchar(10) DEFAULT NULL,
  `BatchControl` char(1) DEFAULT NULL,
  `ProductType` varchar(50) DEFAULT NULL,
  `TaxType` varchar(50) DEFAULT NULL,
  `SaleUnit` varchar(50) DEFAULT NULL,
  `StockUnit` varchar(50) DEFAULT NULL,
  `Sale2StockRate` double DEFAULT NULL,
  `SafeQty` double DEFAULT NULL,
  `ReOrderQty` double DEFAULT NULL,
  `MiniOrderQty` double DEFAULT NULL,
  `VendorId` varchar(50) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Price4Via` double DEFAULT NULL,
  `SpecialPrice` double DEFAULT NULL,
  `TimeFrom` varchar(20) DEFAULT NULL,
  `TimeTo` varchar(20) DEFAULT NULL,
  `ProductStatus` varchar(50) DEFAULT NULL,
  `IsPackageItem` char(1) DEFAULT NULL,
  `Cost` double DEFAULT NULL,
  `CanChangePrice` char(1) DEFAULT NULL,
  `IsStockItem` char(1) DEFAULT NULL,
  `ProductValue` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ProductId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsale`
--

DROP TABLE IF EXISTS `productsale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsale` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(50) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `SaleDate` varchar(10) DEFAULT NULL,
  `CustomerId` varchar(50) DEFAULT NULL,
  `CustomerName` varchar(100) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `SaleDept` varchar(50) DEFAULT NULL,
  `Salesponsor` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  `Tax` int(11) DEFAULT NULL,
  `ZeroAmount` int(11) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Summary` varchar(200) DEFAULT NULL,
  `ProductValue` int(11) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `Receipt` char(1) DEFAULT NULL,
  `Shipping` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsale`
--

LOCK TABLES `productsale` WRITE;
/*!40000 ALTER TABLE `productsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsale_detail`
--

DROP TABLE IF EXISTS `productsale_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsale_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ProductNo` varchar(50) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `Unit` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `UnitPrice` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Tax` int(11) DEFAULT NULL,
  `ProductValue` int(11) DEFAULT NULL,
  `IsStockItem` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsale_detail`
--

LOCK TABLES `productsale_detail` WRITE;
/*!40000 ALTER TABLE `productsale_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsale_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `ProgramId` varchar(50) NOT NULL,
  `ProgramName` varchar(50) DEFAULT NULL,
  `Url` varchar(50) DEFAULT NULL,
  `IsMenu` char(1) DEFAULT NULL,
  `UseFlow` char(1) DEFAULT NULL,
  `Flow_id` varchar(30) DEFAULT NULL,
  `Date_from` varchar(10) DEFAULT NULL,
  `Date_to` varchar(10) DEFAULT NULL,
  `BeginWord` varchar(20) DEFAULT NULL,
  `EndNoLength` int(11) DEFAULT NULL,
  `PageRecords` int(11) DEFAULT NULL,
  `OnlineHelpUrl` varchar(200) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `Seq_no` int(11) DEFAULT NULL,
  `QueryFunction` char(1) DEFAULT NULL,
  `UpdateFunction` char(1) DEFAULT NULL,
  `InsertFunction` char(1) DEFAULT NULL,
  `DeleteFunction` char(1) DEFAULT NULL,
  `PrintFunction` char(1) DEFAULT NULL,
  `CloseCanReject` char(1) DEFAULT NULL,
  `ProgramMode` char(1) DEFAULT NULL,
  `LogUpdate` char(1) DEFAULT NULL,
  `LogDelete` char(1) DEFAULT NULL,
  `LogPrint` char(1) DEFAULT NULL,
  `LogInsert` char(1) DEFAULT NULL,
  PRIMARY KEY (`ProgramId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES ('ap.menu.case','事務所管理系統','','1','','','','','',3,10,'','',0,'','','','','','','','','','',''),('ap.menu.case.01','專利案件管理','','1','','','','','',3,10,'','ap.menu.case',3,'','','','','','','','','','',''),('ap.menu.case.02','主管功能','','1','','','','','',3,10,'','ap.menu.case',8,'','','','','','','','','','',''),('ap.menu.case.04','客戶資料','','1','','','','','',3,10,'','ap.menu.case',2,'','','','','','','','','','',''),('ap.menu.case.05','財務管理','','1','','','','','',3,10,'','ap.menu.case',9,'','','','','','','','','','',''),('ap.menu.case.06','法律案件管理','','1','','','','','',3,10,'','ap.menu.case',5,'','','','','','','','','','',''),('ap.menu.case.07','商標案件管理','','1','','','','','',3,10,'','ap.menu.case',4,'','','','','','','','','','',''),('ap.menu.case.08','工時記錄管理','','1','','','','','',3,10,'','ap.menu.case',6,'','','','','','','','','','',''),('ap.menu.case.09','業務管理','','1','','','','','',3,10,'','ap.menu.case',1,'','','','','','','','','','',''),('ap.menu.case.10','著作權案件管理','','1','','','','','',3,10,'','ap.menu.case',7,'','','','','','','','','','',''),('ap.menu.personal','個人資料管理','','1','','','','','',3,10,'','',3,'','','','','','','','','','',''),('ap.menu.sys','系統管理目錄','','1','','','','','',3,10,'','',99,'','','','','','','','','','',''),('ap.menu.sys.basic','行政程序管理','','1','','','','','',3,10,'','ap.menu.sys',4,'','','','','','','','','','',''),('ap.menu.sys.config','系統設定','','1','','','','','',3,30,'','ap.menu.sys',4,'','','','','','','B','','','',''),('ap.menu.sys.log','系統記錄',' ','1','',' ',' ',' ',' ',3,30,' ','ap.menu.sys',5,'','','','','','','B','','','',''),('ap.menu.sys.main','系統維護','','1','','','','','',3,30,'','ap.menu.sys',2,'','','','','','','B','','','',''),('ap.menu.sys.org','組織管理','','1','','','','','',3,30,'','ap.menu.sys',1,'','','','','','','B','','','',''),('jsp.Account','帳號設定','Account.jsp','0','','','','','Ac',2,50,'','ap.menu.sys.main',0,'1','1','1','1','','','B','','','',''),('jsp.Applicant',' 聯絡人','Applicant.jsp','0','','','','','Ap',2,50,'','ap.menu.case.04',1,'1','1','1','1','','','B','1','1','1','1'),('jsp.Attorney','代理人','Attorney.jsp','0','','','','','At',2,50,'','ap.menu.case.04',1,'1','1','1','1','','','B','1','1','1','1'),('jsp.Authority','權限設定','Authority.jsp','0','','','','','',2,10,'','ap.menu.sys.config',0,'','1','','','','','B','','','',''),('jsp.BankAccountManagement','銀行帳戶管理','BankAccountManagement.jsp','0','','','','','BAM',3,10,'','ap.menu.case.05',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Category','下拉選單管理','Category.jsp','0','','','','','Ca',2,50,'','ap.menu.sys.basic',0,'1','1','1','1','','','B','','','',''),('jsp.changePwd','變更密碼','changePwd.jsp?_dbActionMode=update','0','','','','','CP',2,30,'','ap.menu.personal',0,'','1','','','','','M','','','',''),('jsp.ChartDefine','統計圖表定義','ChartDefine.jsp','0','','','','','CD',3,10,'','ap.menu.sys.basic',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Client','客戶資料','Client.jsp','0','','','','','C',2,50,'','ap.menu.case.04',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.CopyrightCase','著作權案件','CopyrightCase.jsp','0','','','','','CC',3,50,'','ap.menu.case.10',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.CopyrightDocument','著作權案件收發文','CopyrightDocument.jsp','0','','','','','CD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.CopyrightToDos','著作權案件待辦事項','CopyrightToDos.jsp','0','','','','','CD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.Customer','客戶資料','Customer.jsp','0','','','','','Cs',2,20,'','ap.menu.stock.02',1,'1','1','1','1','','','B','','','',''),('jsp.DataImport','資料匯入','DataImport.jsp','0','','','','','DI',3,10,'','ap.menu.case',0,'1','1','1','1','1','','B','','','',''),('jsp.Department','部門資料','Department.jsp','0','','','','','Dp',2,50,'','ap.menu.sys.org',0,'1','1','1','1','','','B','1','1','','1'),('jsp.DocumentManage','收發文管理','DocumentManage.jsp','0','','','','','DM',3,50,'','ap.menu.case.02',2,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Draft','專利提案','Draft.jsp','0','','','','','DR',3,10,'','ap.menu.case.01',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Employee','員工資料','Employee.jsp','0','','','','','Ep',2,50,'','ap.menu.sys.org',0,'1','1','1','1','1','','B','1','1','','1'),('jsp.ErrorReport','問題反映單','ErrorReport.jsp','0','1','flow31','','','Er',2,50,'','ap.menu.sys.main',90,'1','1','1','1','','','B','','','',''),('jsp.FeeSchedule','年費管理 ','FeeSchedule.jsp','0','','','','','FS',3,10,'','ap.menu.case.01',2,'1','1','1','1','1','','B','1','1','1','1'),('jsp.FileManage','檔卷管理','FileManage.jsp','0','','','','','FM',2,50,'','ap.menu.case.06',4,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Groups','群組設定','Groups.jsp','0','','','','','Gp',2,10,'','ap.menu.sys.org',0,'1','1','1','1','','','B','1','1','','1'),('jsp.Guaranty','保管款維護','Guaranty.jsp','0','','','','','GU',3,10,'','ap.menu.case.06',5,'1','1','1','1','1','','B','1','1','1','1'),('jsp.HourlyCharge','職等收費表','HourlyCharge.jsp','0','','','','','HC',3,10,'','ap.menu.case.08',5,'1','1','1','1','1','','B','1','1','1','1'),('jsp.InterConfQuery','利益衝突查詢','InterConfQuery.jsp','0','','','','','ICQ',3,10,'','ap.menu.case',0,'1','1','1','1','1','','B','','','',''),('jsp.Invoice','請款單','Invoice.jsp','0','','','','','Invoice',3,50,'','ap.menu.case.05',2,'1','1','1','1','1','','B','1','1','1','1'),('jsp.InvTitle',' 發票抬頭','InvTitle.jsp','0','','','','','IT',2,50,'','ap.menu.case.04',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.JobType','工作代碼維護','JobType.jsp','0','','','','','JT',3,10,'','ap.menu.case.08',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Leave','請假','Leave.jsp','0','','','','','LE',3,10,'','ap.menu.case',0,'1','1','1','1','1','','B','','','',''),('jsp.LegalCase','法律案件','LegalCase.jsp','0','','','','','LC',3,50,'','ap.menu.case.06',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.LegalDocument','法律案件收發文','LegalDocument.jsp','0','','','','','LD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.LegalToDos','法律案件待辦事項','LegalToDos.jsp','0','','','','','LD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.LogInfo','異動記錄','LogInfo.jsp','0','','','','','Log',4,20,'','ap.menu.sys.log',0,'1','1','1','1','','','B','','','',''),('jsp.MailLog','郵件記錄','MailLog.jsp','0','','','','','ML',3,20,'','ap.menu.sys.log',0,'1','1','1','1','','','B','','','',''),('jsp.MailManager','郵件發送設定管理','MailManager.jsp','0','','','','','MM',3,10,'','ap.menu.sys.config',6,'','1','','','','','M','','','',''),('jsp.MailThreadConfig','郵件伺服器','MailThreadConfig.jsp','0','','','','','MC',2,10,'','ap.menu.sys.config',0,'1','1','1','1','','','B','','','',''),('jsp.MiscFee','事務費','MiscFee.jsp','0','','','','','MF',3,50,'','ap.menu.case.05',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.MyFavor','我的最愛','MyFavor.jsp','0','','','','','MF',2,10,'','ap.menu.personal',0,'1','1','1','1','','','B','','','',''),('jsp.Notice','公告資訊','Notice.jsp','0','','','','','Nc',2,30,'','ap.menu.sys.main',0,'1','1','1','1','','','B','','','',''),('jsp.Opponent','對造管理','Opponent.jsp','0','','','','','OP',2,50,'','ap.menu.case.06',1,'1','1','1','1','','','B','1','1','1','1'),('jsp.PatentCase','專利案件','PatentCase.jsp','0','','','','','PC',3,50,'','ap.menu.case.01',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.PatentDocument','專利案件收發文','PatentDocument.jsp','0','','','','','PD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.PatentMatterConfig','程序設定檔','PatentMatterConfig.jsp','0','','','','','PMC',3,50,'','ap.menu.sys.basic',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.PatentToDos','專利案件待辦事項','PatentToDos.jsp','0','','','','','PD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.PayChargeMamage','待請付款項目','PayChargeMamage.jsp','0','','','','','PCM',3,50,'','ap.menu.case.05',1,'1','','','','1','','B','1','','1','1'),('jsp.PayManage','付款管理','PayManage.jsp','0','','','','','PM',3,50,'','ap.menu.case.05',5,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Payment','付款單','Payment.jsp','0','','','','','Pay',3,50,'','ap.menu.case.05',4,'1','1','1','1','1','','B','1','1','1','1'),('jsp.PerformanceMonthReport','績效月報表','PerformanceMonthReport.jsp','0','','','','','PMR',3,10,'','ap.menu.case.02',5,'1','','','','','','B','1','1','1','1'),('jsp.Phrase','片語定義','Phrase.jsp','0','','','','','Ph',3,50,'','ap.menu.personal',0,'1','1','1','1','','','B','','','',''),('jsp.Product','商品資料','Product.jsp','0','','','','','Pd',2,20,'','ap.menu.stock.02',0,'1','1','1','1','','','B','','','',''),('jsp.Program','程式架構','Program.jsp','0','','','','','',2,10,'','ap.menu.sys.config',0,'1','1','1','1','','','M','','','',''),('jsp.Quotation','案件報價單','Quotation.jsp','0','','','','','CC',3,30,'','ap.menu.case.09',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.ReceiptManage','收款管理','ReceiptManage.jsp','0','','','','','RM',3,50,'','ap.menu.case.05',3,'1','1','1','1','1','','B','1','1','1','1'),('jsp.RenewalLog','年費確認單管理','RenewalLog.jsp','0','','','','','RL',3,10,'','ap.menu.case.01',4,'1','1','1','1','1','','B','1','1','1','1'),('jsp.Report','新例稿報表套印','ReportTemplatePreview.jsp','0','','','','','TTT',3,10,'','ap.menu.sys.basic',6,'1','','','','','','B','','','',''),('jsp.ReportDefine','套印設定','ReportDefine.jsp','0','','','','','RD',2,50,'','ap.menu.sys.basic',1,'1','1','1','1','','','B','','','',''),('jsp.ReportTableSetting','功能報表欄位設定','ReportTableSetting.jsp','0','','','','','RTS',2,200,'','ap.menu.sys.basic',7,'1','1','1','1','1','','B','','','',''),('jsp.SalesOrder','內部訂單','SalesOrder.jsp','0','','','','','SO',3,50,'','ap.menu.case.09',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.ScheduleManager','排程管理','ScheduleManager.jsp','0','','','','','SM',2,10,'','ap.menu.sys.config',0,'1','1','1','1','','','B','','','',''),('jsp.ServiceProject','顧問專案','ServiceProject.jsp','0','','','','','SP',3,10,'','ap.menu.case.06',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.SignedManage','簽核管理','SignedManage.jsp','0','','','','','SM',3,10,'','ap.menu.case',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.StandardQuo','標準報價設定','StandardQuo.jsp','0','','','','','SQ',3,200,'','ap.menu.case.09',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.StandardTask','標準期限設定','StandardTask.jsp','0','','','','','ST',3,200,'','ap.menu.sys.basic',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.StatisticalChart','統計圖表','StatisticalChart.jsp','0','','','','','SC',3,10,'','ap.menu.case.02',1,'1','1','1','1','1','','B','1','1','1','1'),('jsp.SystemConfig','參數設定','SystemConfig.jsp','0','','','','','SC',3,10,'','ap.menu.sys.config',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.SystemLogo','Logo變更','SystemLogo.jsp','0','','','','','SL',3,10,'','ap.menu.sys.config',1,'1','1','1','','','','B','1','','','1'),('jsp.SystemProcess','系統程式','SystemProcess.jsp','0','','','','','SP',3,10,'','ap.menu.case',0,'1','','','','','','B','1','1','1','1'),('jsp.TimesheetManagement','工時紀錄管理','TimesheetManagement.jsp','0','','','','','TSM',3,10,'','ap.menu.case.08',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.TimesheetManagementReport','工時記錄報表','TimesheetManagementReport.jsp','0','','','','','TSMR',3,10,'','ap.menu.case.08',0,'1','','','','','','S','','','',''),('jsp.TimesheetPayManagement','工時請款','TimesheetPayManagement.jsp','0','','','','','TPM',3,50,'','ap.menu.case.08',1,'1','','','','1','','B','1','','1','1'),('jsp.ToDosAssign','主管派案','ToDosAssign.jsp','0','','','','','',3,20,'','ap.menu.case.02',0,'1','','','','','','B','1','','','1'),('jsp.ToDosQuery','待辦事項查詢','ToDosQuery.jsp','0','','','','','',3,50,'','ap.menu.case.02',3,'1','','1','','','','S','1','','','1'),('jsp.TrademarkCase','商標案件','TrademarkCase.jsp','0','','','','','TC',3,50,'','ap.menu.case.07',0,'1','1','1','1','1','','B','1','1','1','1'),('jsp.TrademarkDocument','商標案件收發文','TrademarkDocument.jsp','0','','','','','TD',3,10,'','ap.menu.case.07',0,'','','','','','','B','1','1','1','1'),('jsp.TrademarkExtend','延展管理 ','TrademarkExtend.jsp','0','','','','','TE',3,10,'','ap.menu.case.07',2,'1','1','1','1','1','','B','1','1','1','1'),('jsp.TrademarkMonitorManage','商標監控管理','TrademarkMonitorManage.jsp','0','','','','','',3,10,'','ap.menu.case.07',0,'1','','','','','','S','','','',''),('jsp.TrademarkRenewalLog','延展確認單管理','TrademarkRenewalLog.jsp','0','','','','','TRL',3,10,'','ap.menu.case.07',4,'1','1','1','1','1','','B','1','1','1','1'),('jsp.TrademarkToDos','商標案件待辦事項','TrademarkToDos.jsp','0','','','','','TD',3,10,'','ap.menu.case.01',0,'','','','','','','B','1','1','1','1'),('jsp.TransationType','異動單定義','TransationType.jsp','0','','','','','TT',2,20,'','ap.menu.stock.03',1,'1','1','1','1','','','B','','','',''),('jsp.UploadFiles','上傳檔案管理','UploadFiles.jsp','0','','','','','UF',2,30,'','ap.menu.personal',0,'1','1','1','1','','','B','','','',''),('jsp.Vendor','廠商資料','Vendor.jsp','0','','','','','Vd',2,20,'','ap.menu.stock.02',1,'1','1','1','1','','','B','','','','');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotation` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ServiceProjectCode` varchar(50) NOT NULL,
  `Client` varchar(50) NOT NULL,
  `ClientName` varchar(100) NOT NULL,
  `OriginalTitle` varchar(500) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `InCharge` varchar(50) NOT NULL,
  `CreateTime` varchar(10) NOT NULL,
  `Creator` varchar(50) NOT NULL,
  `QuotationDate` varchar(10) NOT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `PrintFlag` varchar(1) DEFAULT NULL,
  `BasicQuotation` varchar(1) DEFAULT 'N',
  `Approved` varchar(1) DEFAULT 'N',
  `AttorneyTitle` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `TemplateName` varchar(50) DEFAULT NULL,
  `ServiceBusinessTax` varchar(50) DEFAULT NULL,
  `ServiceTaxInclude` varchar(1) DEFAULT NULL,
  `AttorneyBusinessTax` varchar(50) DEFAULT NULL,
  `AttorneyTaxInclude` varchar(1) DEFAULT NULL,
  `OfficeBusinessTax` varchar(50) DEFAULT NULL,
  `OfficeTaxInclude` varchar(1) DEFAULT NULL,
  `AttorneyCase` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `NotifyTarget1` text,
  `NotifyTarget2` text,
  `InternalNo` varchar(50) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `CaseOpenfile` varchar(200) DEFAULT NULL,
  `BillingContact` varchar(50) DEFAULT NULL,
  `RegisteredNo` varchar(100) DEFAULT NULL,
  `InvoiceTitle` varchar(100) DEFAULT NULL,
  `NotifyTarget3` text,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation_detail`
--

DROP TABLE IF EXISTS `quotation_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotation_detail` (
  `FlowKey` varchar(100) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `BaseDate` varchar(8) DEFAULT NULL,
  `LegalDueDate1` varchar(8) DEFAULT NULL,
  `MatterName` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(1000) DEFAULT NULL,
  `PatentType` varchar(1000) DEFAULT NULL,
  `TaskDescription` varchar(600) DEFAULT NULL,
  `TodosTitle` varchar(600) DEFAULT NULL,
  `RemindDate` varchar(8) DEFAULT NULL,
  `EnableStatus` varchar(50) DEFAULT NULL,
  `CaseKind` varchar(50) DEFAULT NULL,
  `IsCharge` varchar(1) DEFAULT NULL,
  `IsPayment` varchar(1) DEFAULT NULL,
  `Points` float(10,3) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` float(10,3) DEFAULT NULL,
  `ExchangeRate` float(10,3) DEFAULT NULL,
  `TwdAmount` int(10) DEFAULT NULL,
  `Accountable` varchar(1) DEFAULT NULL,
  `ParentItemId` text,
  `PrintFlag` varchar(1) DEFAULT NULL,
  `DetailOrder` int(11) DEFAULT '0',
  `TaxType` varchar(50) DEFAULT NULL,
  `TaxInclude` varchar(1) DEFAULT NULL,
  `TaxAmount` float(16,2) DEFAULT '0.00',
  `NotIncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `IncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `Remark` varchar(150) DEFAULT NULL,
  `UnitPrice` double(10,2) DEFAULT '0.00',
  `Quantity` int(5) DEFAULT '1',
  `Unit` varchar(50) DEFAULT NULL,
  `ChineseDescription` varchar(600) DEFAULT NULL,
  `Favor` int(11) DEFAULT '1',
  `StandardTaskKey` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation_detail`
--

LOCK TABLES `quotation_detail` WRITE;
/*!40000 ALTER TABLE `quotation_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotationapplicant`
--

DROP TABLE IF EXISTS `quotationapplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotationapplicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ApplicantOrder` varchar(50) DEFAULT NULL,
  `ApplicantId` varchar(50) DEFAULT NULL,
  `ApplicantName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotationapplicant`
--

LOCK TABLES `quotationapplicant` WRITE;
/*!40000 ALTER TABLE `quotationapplicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotationapplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotationinventor`
--

DROP TABLE IF EXISTS `quotationinventor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotationinventor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `InventorType` varchar(50) DEFAULT NULL,
  `InventorOrder` varchar(20) DEFAULT NULL,
  `ContributionShare` int(11) DEFAULT NULL,
  `Inventor` varchar(50) DEFAULT NULL,
  `InventorName` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `EnglishNames` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotationinventor`
--

LOCK TABLES `quotationinventor` WRITE;
/*!40000 ALTER TABLE `quotationinventor` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotationinventor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotationoption`
--

DROP TABLE IF EXISTS `quotationoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotationoption` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ApproveStatus` varchar(50) DEFAULT NULL,
  `ApproveDate` varchar(10) DEFAULT NULL,
  `Memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotationoption`
--

LOCK TABLES `quotationoption` WRITE;
/*!40000 ALTER TABLE `quotationoption` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotationoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiptmanage`
--

DROP TABLE IF EXISTS `receiptmanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receiptmanage` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `ClientName` varchar(100) DEFAULT NULL,
  `ReceiveType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `ReceiveAmount` float(16,2) DEFAULT '0.00',
  `ExchangeRate` float(16,4) DEFAULT '0.0000',
  `ReceiveNtdAmount` int(16) DEFAULT '0',
  `CheckNo` varchar(50) DEFAULT NULL,
  `Account` varchar(50) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `PayCheckDate` varchar(10) DEFAULT NULL,
  `RealReceiveDate` varchar(10) DEFAULT NULL,
  `ReceiveDate` varchar(10) DEFAULT NULL,
  `WriteOffBalance` int(16) DEFAULT '0',
  `ExchangeGain` int(16) DEFAULT '0',
  `ExchangeLoss` int(16) DEFAULT '0',
  `WriteOffLog` varchar(4000) DEFAULT NULL,
  `AlreadyWriteOffAmount` int(16) DEFAULT '0',
  `memo` varchar(500) DEFAULT NULL,
  `ReceKind` varchar(50) DEFAULT NULL,
  `BankFee` int(10) DEFAULT '0',
  `Postage` int(10) DEFAULT '0',
  `BadDebts` int(10) DEFAULT '0',
  `CreditNote` int(10) DEFAULT '0',
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiptmanage`
--

LOCK TABLES `receiptmanage` WRITE;
/*!40000 ALTER TABLE `receiptmanage` DISABLE KEYS */;
/*!40000 ALTER TABLE `receiptmanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receivable`
--

DROP TABLE IF EXISTS `receivable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receivable` (
  `FlowKey` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CreateDept` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Applicant` varchar(50) CHARACTER SET latin1 NOT NULL,
  `InvoiceNo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `InvoiceType` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CaseId` varchar(50) CHARACTER SET latin1 NOT NULL,
  `PtoCountry` varchar(50) CHARACTER SET latin1 NOT NULL,
  `IpType` varchar(50) CHARACTER SET latin1 NOT NULL,
  `SubType` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Process` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CaseTitle` varchar(200) NOT NULL,
  `Client` varchar(50) CHARACTER SET latin1 NOT NULL,
  `InvoiceTitle` varchar(200) NOT NULL,
  `AttorneyTitle` varchar(200) NOT NULL,
  `InvoiceDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `PaymentTerm` varchar(50) CHARACTER SET latin1 NOT NULL,
  `ArDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `Currency` varchar(50) CHARACTER SET latin1 NOT NULL,
  `GovFee` float(11,2) NOT NULL,
  `ServiceFee` float(11,2) NOT NULL,
  `AgentFee` float(11,2) NOT NULL,
  `OtherFee` float(11,2) NOT NULL,
  `Tax` float(11,2) NOT NULL,
  `Points` float(11,1) NOT NULL,
  `ReceiveDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `ReceiveAmount` float(11,2) NOT NULL,
  `CheckDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `ReceiveType` varchar(50) CHARACTER SET latin1 NOT NULL,
  `RealReceiveDate` varchar(10) CHARACTER SET latin1 NOT NULL,
  `Status` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Note` varchar(200) NOT NULL,
  `AssignedTo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `ToDosId` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CheckNo` varchar(50) NOT NULL,
  `Account` varchar(50) NOT NULL,
  `Bank` varchar(50) NOT NULL,
  `Balance` float(11,2) NOT NULL,
  `PayCheckDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receivable`
--

LOCK TABLES `receivable` WRITE;
/*!40000 ALTER TABLE `receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `receivable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renewallog`
--

DROP TABLE IF EXISTS `renewallog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `renewallog` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `LicenseNo` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `FeeScheduleDate` varchar(10) DEFAULT NULL,
  `FeeSchedule` varchar(50) DEFAULT NULL,
  `PayPeriod` varchar(10) DEFAULT NULL,
  `SurchargeDate` varchar(10) DEFAULT NULL,
  `RenewStatus` varchar(50) DEFAULT NULL,
  `MaintainAttorney` varchar(50) DEFAULT NULL,
  `PtoFee` float(10,3) DEFAULT NULL,
  `PtoCurrency` varchar(50) DEFAULT NULL,
  `PtoExchangeRate` float(10,3) DEFAULT NULL,
  `NtdPtoFee` float(10,3) DEFAULT NULL,
  `PayTransfer` varchar(1) DEFAULT NULL,
  `ServiceFee` float(10,3) DEFAULT NULL,
  `ServiceCurrency` varchar(50) DEFAULT NULL,
  `ServiceExchangeRate` float(10,3) DEFAULT NULL,
  `NtdServiceFee` float(10,3) DEFAULT NULL,
  `PayTransfer2` varchar(1) DEFAULT NULL,
  `AttorneyFee` float(10,3) DEFAULT NULL,
  `AttorneyCurrency` varchar(50) DEFAULT NULL,
  `AttorneyExchangeRate` float(10,3) DEFAULT NULL,
  `NtdAttorneyFee` float(10,3) DEFAULT NULL,
  `OtherFee` float(10,3) DEFAULT NULL,
  `OtherCurrency` varchar(50) DEFAULT NULL,
  `OtherExchangeRate` float(10,3) DEFAULT NULL,
  `NtdOtherFee` float(10,3) DEFAULT NULL,
  `KeepMaintain` varchar(50) DEFAULT NULL,
  `NtdInvoiceAmount` float(10,3) DEFAULT NULL,
  `AddYear` varchar(50) DEFAULT NULL,
  `GiveupReason` varchar(200) DEFAULT NULL,
  `Memo` varchar(400) DEFAULT NULL,
  `StandardTaskKey` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renewallog`
--

LOCK TABLES `renewallog` WRITE;
/*!40000 ALTER TABLE `renewallog` DISABLE KEYS */;
/*!40000 ALTER TABLE `renewallog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportdefine`
--

DROP TABLE IF EXISTS `reportdefine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportdefine` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Names` varchar(200) NOT NULL,
  `SampleDocument` varchar(50) NOT NULL,
  `ReportProgramId` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportdefine`
--

LOCK TABLES `reportdefine` WRITE;
/*!40000 ALTER TABLE `reportdefine` DISABLE KEYS */;
INSERT INTO `reportdefine` VALUES ('InvoiceDoc1','99','admin','請款單_test','Document/ReportDefine/admin/UL15316.001.jasper','jsp.Invoice'),('OrderFillRateReport','99','admin','達交率報表','Document/ReportDefine/admin/UL14324.004.jasper','jsp.PerformanceMonthReport'),('PerformanceMonthReport','99','admin','績效月報表','Document/ReportDefine/admin/UL14324.005.jasper','jsp.ToDosQuery'),('QuotationDoc1','99','admin','報價單1','Document/ReportDefine/admin/UL14157.001.jasper','jsp.Quotation'),('QuotationDoc1E','99','admin','報價單1英文','Document/ReportDefine/admin/UL14157.004.jasper','jsp.Quotation'),('QuotationDoc2','99','admin','報價單2','Document/ReportDefine/admin/UL14157.002.jasper','jsp.Quotation'),('QuotationDoc2E','99','admin','報價單2英文','Document/ReportDefine/admin/UL14157.005.jasper','jsp.Quotation'),('QuotationDoc3','99','admin','報價單3','Document/ReportDefine/admin/UL14157.003.jasper','jsp.Quotation'),('QuotationDoc3E','99','admin','報價單3英文','Document/ReportDefine/admin/UL14157.006.jasper','jsp.Quotation'),('RD20130809.01','Demo','admin','年費管理套表參數表','Document/ReportDefine/admin/UL13302.002.doc','jsp.RenewalLog'),('RD20130809.02','Demo','admin','延展管理套表參數表','Document/ReportDefine/admin/UL13302.003.doc','jsp.TrademarkRenewalLog'),('RD20130809.03','Demo','admin','法務案件欄位中文名稱與變數 對照表','Document/ReportDefine/admin/UL16364.001.doc','jsp.LegalCase'),('RD20130809.04','Demo','admin','商標欄位與變數對照表','Document/ReportDefine/admin/UL17256.001.doc','jsp.TrademarkCase'),('RD20130809.05','Demo','admin','專利欄位與變數對照表','Document/ReportDefine/admin/UL15313.003.doc','jsp.PatentCase'),('RD20130809.06','Demo','admin','著作權案件欄位中文名稱與變數 對照表','Document/ReportDefine/admin/UL16364.003.doc','jsp.CopyrightCase'),('RD20130809.07','Demo','admin','請款單欄位與變數對照表_SO','Document/ReportDefine/admin/UL14141.002.doc','jsp.Invoice'),('RD20130809.08','Demo','admin','客戶資料變數對照表','Document/ReportDefine/admin/UL13310.001.doc','jsp.Client'),('RD20140327.01','Demo','admin','內部訂單變數表','Document/ReportDefine/admin/UL14086.001.doc','jsp.SalesOrder'),('RD20141118.01','TL','esther','測試用(親愛的客戶)','Document/ReportDefine/admin/UL14344.001.docx','jsp.PatentCase'),('RD20180419.01','99','admin','test20180419','Document/ReportDefine/admin/UL18109.001.doc','jsp.PatentCase');
/*!40000 ALTER TABLE `reportdefine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportdraftsetting`
--

DROP TABLE IF EXISTS `reportdraftsetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportdraftsetting` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `SettingTableName` varchar(50) DEFAULT NULL,
  `ReportName` varchar(100) DEFAULT NULL,
  `ReportSettingData` text,
  `Language` varchar(50) DEFAULT NULL,
  `ReportType` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `ModifyTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportdraftsetting`
--

LOCK TABLES `reportdraftsetting` WRITE;
/*!40000 ALTER TABLE `reportdraftsetting` DISABLE KEYS */;
INSERT INTO `reportdraftsetting` VALUES ('Client.Common.admin.01','99','admin','Client','客戶報表測試','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n《$請款聯絡人E-Mail$》<br />《$請款聯絡人E-Mail$》《$電話$》<br />《$國家/國籍$》<br />《$聯絡記錄$》《$聯絡記錄$》《$客戶名稱(主)$》<br />《$電話$》<br />《$E-Mail$》<br />《$登記地址$》《$母公司或集團名稱$》<br />《$發票抬頭$》<br />《$發票抬頭_Key$》<br />《$客戶名稱(副)$》<br /><br /><br />《$請款聯絡人E-Mail$》《$請款聯絡人E-Mail$》《$E-Mail1$》\n</body>\n</html>','chinese','Common','2014-08-21 14:23:21','2014-09-24 15:00:20'),('Client.Personal.admin.02','99','admin','Client','test1','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n《$請款聯絡人E-Mail$》<br />《$請款聯絡人E-Mail$》《$電話$》<br />《$國家/國籍$》<br />《$聯絡記錄$》《$聯絡記錄$》《$客戶名稱(主)$》<br />《$電話$》<br />《$E-Mail$》<br />《$登記地址$》《$母公司或集團名稱$》<br />《$發票抬頭$》<br />《$發票抬頭_Key$》<br />《$客戶名稱(副)$》\n</body>\n</html>','chinese','Personal','2014-09-15 17:22:12',''),('Client.Personal.admin.03','99','admin','Client','test2','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\ns34<br /><br /><br />《$請款聯絡人E-Mail$》《$請款聯絡人E-Mail$》《$E-Mail1$》\n</body>\n</html>','chinese','Personal','2014-09-24 15:01:10',''),('CopyrightCase.Common.admin.01','99','admin','CopyrightCase','著作權案件 test1','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n著作權案件 報表測試 test1&nbsp;<br />《$建檔時間$》<br />《$建檔人員$》<br />《$最後編輯時間$》<br />《$編輯人$》<br />《$承辦人員$》<br />《$承辦人員_Key$》<br />《$案件名稱(副)$》<br />《$系列母案$》<br />《$專案編號$》<br />《$負責程序$》<br />《$負責程序_Key$》<br />《$案件編號$》<br />《$案件編號2$》<br />《$案件聯絡人$》<br />《$案件聯絡人_Key$》<br />《$案件名稱(主)$》<br />《$案件說明$》<br />《$案件類別$》<br />《$案件類別_Key$》<br />《$案件中類$》<br />《$案件中類_Key$》<br />《$案件狀態$》<br />《$案件狀態_Key$》<br />《$公開日$》<br />《$公開日_ROC$》<br />《$實際完成日$》<br />《$實際完成日_ROC$》<br />《$申請日$》<br />《$申請日_ROC$》<br />《$實際登記日$》<br />《$實際登記日_ROC$》<br />《$申請號$》<br />《$登記號$》<br />《$原創公司$》<br />《$原創人$》<br />《$立案日$》<br />《$立案日_ROC$》<br />《$客戶案號$》<br />《$代理人案號$》<br />《$代理人$》<br />《$代理人_Key$》<br />《$自定欄位九$》<br />《$自定欄位十$》<br />《$客戶編號$》<br />《$業務人員$》<br />《$業務人員_Key$》<br />《$著作單位$》<br />《$著作單位_Key$》<br />《$原案件編號$》<br />《$國別$》<br />《$國別_Key$》<br />《$單位數量$》\n</body>\n</html>','chinese','Common','2014-08-05 16:12:30',''),('Invoice.Common.admin.01','99','admin','Invoice','請款單','<div style=\"text-align: center;\"><strong><span style=\"font-size:14pt\">請款單</span></strong></div>\n\n<div style=\"text-align: center;\"><strong><span style=\"font-size:14pt\"><u>STATEMENT</u></span></strong><br />\n&nbsp;</div>\n\n<table style=\"border-collapse:collapse; border:1px solid white; height:57px; table-layout:fixed; width:647px; word-wrap:break-word\">\n <tbody>\n   <tr>\n      <td><strong><span style=\"font-size:12pt\">XX法律事務所</span></strong><br />\n      台北市大安區106和安里6鄰<br />\n      XX路3段136號XXX大樓13樓<br />\n     統一編號：04145886<br />\n     電話：(02)2500-7366(代表線)<br />\n     傳真：(02)25005-6486</td>\n      <td style=\"text-align:center\"><strong><span style=\"font-size:12pt\">Great Win</span></strong><br />\n      <strong><span style=\"font-size:12pt\">ATTORNEYS AT LAW</span></strong><br />\n     13<sup>th&nbsp;</sup>Floor, Lotus Building<br />\n      No. 136, Jen Ai Road, Section 3<br />\n     Taipei 106, Taiwan, R.O.C.<br />\n      Tel:(02)2500-7366<br />\n     Fax:(02)2500-6486<br />\n     E-mail:ftlaw@taiwanlaw.com</td>\n   </tr>\n   <tr>\n      <td>謹致<br />\n      TO：《$單據抬頭$》</td>\n      <td>NO：<u>《$請款單單號$》</u></td>\n    </tr>\n   <tr>\n      <td>　 &nbsp; &nbsp;《$客戶名稱$》</td>\n      <td>DATE：<u>《$請款日期$》</u><span style=\"font-size:14px\">　　　　　　　　　　　　</span></td>\n   </tr>\n </tbody>\n</table>\n\n<hr />\n<p><span style=\"font-size:8pt\">請惠予撥付下列費用</span><br />\n<span style=\"font-size:8pt\">THIS IS TO REQUEST YOUR PAYMENT FOR THE FOLLOWING SERVICE(S)：</span></p>\n\n<p>&nbsp;</p>\n\n<table style=\"border-collapse:collapse; border:1px solid black; height:345px; table-layout:fixed; width:647px; word-wrap:break-word\">\n <tbody>\n   <tr>\n      <td colspan=\"2\" style=\"text-align:center\"><strong>摘要</strong><br />\n     <strong>DESCRIPTION</strong></td>\n     <td style=\"text-align:center\"><strong>金額</strong><br />\n     <strong>AMOUNT</strong></td>\n    </tr>\n   <tr>\n      <td colspan=\"2\" style=\"text-align:left\">《$請款項目說明$》<br />\n      <br />\n      【本次酬金費用計收起迄日期：】<br />\n     一、服務酬金<br />\n      <br />\n      【本次事務費用計收起迄日期：】<br />\n     二、本所服務費：影印費、郵費、交通費...等。<br />\n     三、官費。<br />\n     四、複代服務費。<br />\n      <br />\n      <br />\n      <br />\n      <br />\n      《$備註$》<br />\n      <br />\n      　(1)請依法扣繳10%所得稅金額(年終並請惠寄扣繳憑單)<br />\n     　(2)本所實收金額</td>\n     <td style=\"text-align:right\"><br />\n     <br />\n      <br />\n      <br />\n      <br />\n      <br />\n      《$本所服務費總額$》<br />\n     《$官費總額$》<br />\n      《$複代服務費總額$》\n     <hr />《$未稅請款總額$》<br />\n      <br />\n      <br />\n      <br />\n      <br />\n      《$執行業務所得10%$》<br />\n     《$已沖銷總額$》</td>\n    </tr>\n   <tr>\n      <td style=\"text-align:center\"><strong>總計</strong><br />\n     <strong>TOTAL</strong></td>\n     <td style=\"text-align:center\">《$含稅請款總額$》</td>\n     <td>&nbsp;</td>\n   </tr>\n </tbody>\n</table>\n\n<p>&nbsp;</p>\n\n<p><br />\n請即將款項撥付，謝謝 (第一聯：客戶收執聯)<br />\nYOU EARLY ATTENTION TO THIS STATEMENT WILL BE MUCH APPRECIATED THANK YOU.</p>\n\n<ul style=\"list-style-type:circle\">\n  <li><span style=\"font-size:8pt\">PLEASE INDICATE THE NUMBER AND DATE OF THIS STATEMENT WITH YOUR REMITTANCE.</span></li>\n <li><span style=\"font-size:8pt\">公司行號請依法扣繳百分之十所得稅，年終並請惠寄扣繳憑單為盼。</span></li>\n</ul>\n\n<p>匯款支付方式(如下所示)<br />\n匯款銀行：彰化銀行建國分行<br />\n匯款戶名：萬國法律事務所<br />\n匯款帳號：5289-01-00502-300<br />\n若使用ATM或網路轉帳，請來電告知本所會計組，謝謝。</p>\n','chinese','Common','2014-08-21 14:41:37','2016-07-18 13:31:50'),('Invoice.Personal.admin.01','99','admin','Invoice','test1','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n《$請款單單號$》<br />《$複代帳單單號$》<br />《$案件編號2$》<br />《$含稅請款總額$》<br />《$未稅請款總額$》<br />《$預收金額$》<br />《$應收金額$》<br />《$稱謂$》<br />《$承辦人員$》<br />《$申請人$》<br />《$請款聯絡人$》<br />《$客戶案號$》<br />《$申請號$》<br />《$申請日$》<br />《$申請日_ROC$》<br />《$公告日$》<br />《$公告日_ROC$》<br />《$公告號$》<br />《$案件聯絡人$》<br />《$案件聯絡人_Key$》<br />《$請款單狀態$》<br />《$請款單狀態_Key$》<br />《$客戶代碼$》<br />《$客戶名稱$》<br />《$單據抬頭$》<br />《$單據抬頭_Key$》<br />《$請款單抬頭$》<br />《$營業稅5%$》<br />《$執行業務所得10%$》<br />《$已沖銷總額$》<br />《$案件名稱$》<br />《$案件編號$》<br />《$申請國家$》<br />《$申請國家_Key$》<br />《$案件類別$》<br />《$案件類別_Key$》<br />《$案件程序$》<br />《$案件程序_Key$》<br />《$請款編號$》<br />《$業務人員$》<br />《$業務人員_Key$》<br />《$請款日期$》<br />《$請款日期_ROC$》<br />《$備註$》<br />《$請款項目說明$》<br />《$本所服務費台幣扣繳後總額$》<br />《$業務人員$》<br />《$業務人員_Key$》<br />《$商標分類$》<br />《$登記號$》<br />《$統一編號$》<br />《$發票號碼$》<br />《$收據號碼$》<br />《$獨立項數量$》<br />《$附屬項數量$》<br />《$官費總額$》<br />《$本所服務費總額$》<br />《$複代服務費總額$》\n</body>\n</html>','chinese','Personal','2014-08-11 16:51:59',''),('LegalCase.Common.admin.01','99','admin','LegalCase','法律案件 test1','<p style=\"text-align:center\"><strong>財物採購契約書</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p><strong>&nbsp;立合約書人 &nbsp; &nbsp; </strong>《$案件名稱(副)$》《$案件編號$》<strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </strong></p>\n\n<p><strong>&nbsp;</strong>《$簽約公司別$》<strong>（以下簡稱甲方）&nbsp;&nbsp; &nbsp; &nbsp;茲甲方向乙方訂購</strong></p>\n\n<p><strong>&nbsp;</strong>《$簽約對象名稱$》<strong>&nbsp;&nbsp;</strong><strong>（以下簡稱乙方）</strong></p>\n\n<p><strong>設備如後。 並由乙方負責予以試機及保固，今經雙方議定各項條款如下：</strong></p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p><strong>第一條 : 契約標的：</strong></p>\n\n<p>&nbsp;&nbsp;&nbsp; <strong>廠牌：</strong></p>\n\n<p>&nbsp;&nbsp;&nbsp; <strong>機型：</strong></p>\n\n<p><strong>第二條 : 數量規格：</strong> &nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>詳如報價單。</strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\n\n<p><strong>第三條 : 契約價金：</strong><strong>新台幣</strong>《$合約金額$》<strong>（NT$</strong>《$合約金額$》<strong>）元（</strong><strong>本價款稅金內含</strong><strong>）</strong></p>\n\n<p style=\"margin-left:44.95pt\">&nbsp;&nbsp; <strong>（本價款包含一切稅金、設備試用等費用在內。本合約訂立後，如因稅法變更而增加稅捐或匯率變動、運費及其他費用增加時，概由乙方負責與甲方無涉，乙方不得請求變更原訂之總價額）&nbsp; </strong></p>\n\n<p>&nbsp;</p>\n\n<p><strong>第四條 : 付款辦法：（</strong><strong>以下幣別皆為</strong><strong>新台幣</strong><strong>）</strong></p>\n\n<p><strong>雙方依合約第七條驗收規定完成後，由乙方出具保固保證書、保固票及發票憑證，依甲方付款方式辦理。</strong></p>\n\n<p><strong>第五條 : 交貨期限：乙方需於&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp;&nbsp; 日前</strong><strong>完成交貨安裝試車，並於交貨前壹週事先以書面詳列交貨內容通知甲方,並接受甲方人員之督導協調以利現場配合。</strong></p>\n\n<p>《$專案編號$》<br />\n《$系列母案$》<br />\n《$原案件編號$》<br />\n《$對方委任律所$》<br />\n《$對方委任律師$》<br />\n《$備註$》<br />\n《$代理人$》<br />\n《$代理人案號$》</p>\n','chinese','Common','2014-08-05 16:06:12','2018-05-11 12:58:06'),('PatentCase.Common.admin.01','99','admin','PatentCase','專利案件報表Test1','<p>測試報表14<br />\n《$建檔時間$》</p>\n\n<p><span style=\"color:#0000FF\">《$MultiValue_list_發明人_#START#$》《$MultiValue_list_發明人_發明人名稱$》(《$MultiValue_list_發明人_發明人名稱(英)$》)</span>、<span style=\"color:#0000FF\">《$MultiValue_list_發明人_#END#$》</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"color:#008000\">《$MultiValue_list_申請人_#START#$》《$MultiValue_list_申請人_申請人名稱$》</span>、<span style=\"color:#008000\">《$MultiValue_list_申請人_#END#$》</span></p>\n\n<p>《$MultiValue_list_申請人_#START#$》<span style=\"color:#FF0000\">&nbsp;</span><br />\n【申請人《$MultiValue_list_申請人_#編號#$》】<br />\n<span style=\"color:#FF0000\">　　【國籍】　　　　　　</span>《$MultiValue_list_申請人_國籍$》<br />\n<span style=\"color:#FF0000\">　　【中文名稱】　　　　</span>《$MultiValue_list_申請人_申請人名稱$》<br />\n<span style=\"color:#FF0000\">&nbsp; &nbsp; &nbsp; &nbsp;【中文地址】　　　　</span>《$MultiValue_list_申請人_聯絡地址$》</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>【申請人1】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文名稱】　　　　黃海公司<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　新竹市埔前路49號<br />\n<br />\n【申請人2】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文姓名】　　　　黃毓晴<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　高雄市一心路95號</p>\n\n<p>《$MultiValue_list_申請人_#START#$》<span style=\"color:#FF0000\">#</span>《$MultiValue_list_申請人_#編號#$》Applicant:&nbsp;<br />\n<span style=\"color:#FF0000\">&nbsp;&nbsp; - also Assignee<br />\n&nbsp;&nbsp; - Organization Name: </span>《$MultiValue_list_申請人_申請人名稱(英)$》<br />\n<span style=\"color:#FF0000\">&nbsp;&nbsp; - Mailing Address: </span>《$MultiValue_list_申請人_登記地址(英)$》<br />\n<span style=\"color:#FF0000\">&nbsp;&nbsp; - Country:&nbsp;</span>《$MultiValue_list_申請人_國籍_Key$》<br />\n<span style=\"color:#FF0000\">&nbsp;&nbsp; - Postal Code:&nbsp;</span>《$MultiValue_list_申請人_郵遞區號$》<br />\n<span style=\"color:#FF0000\">&nbsp;&nbsp; - Entity Status: </span>《$大/小實體$》《$MultiValue_list_申請人_#換行#$》《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>瑞昱半導體股份有限公司(Realtek Semiconductor Corp.)、黃毓晴(Yu-Ching HUANG)、立錡科技股份有限公司(Richtek Technology Corporation)</p>\n\n<p><br />\n<br />\n&nbsp;</p>\n','chinese','Common','2014-08-05 16:00:34','2018-03-22 15:27:21'),('PatentCase.Common.admin.02','99','admin','PatentCase','測試底稿','<p>《$建檔時間$》《$建檔人員$》《$最後編輯時間$》《$承辦人員$》</p>\n\n<p>申請人：</p>\n\n<p>《$MultiValue_list_申請人_#START#$》</p>\n\n<p>《$MultiValue_list_申請人_#編號#$》.</p>\n\n<p>《$MultiValue_list_申請人_申請人名稱$》=&gt;《$MultiValue_list_申請人_統一編號$》</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p><br />\n發明人：</p>\n\n<p>《$MultiValue_table_發明人_發明人名稱&sect;發明人名稱(英)&sect;國籍$》</p>\n\n<p>&nbsp;</p>\n\n<p>申請人errTest onlyEnd：</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p>申請人errTest onlyStart：</p>\n\n<p>《$MultiValue_list_申請人_#START#$》</p>\n\n<p>&nbsp;</p>\n\n<p>不同副表一起errTest:</p>\n\n<p>《$MultiValue_list_待辦事項_#START#$》</p>\n\n<p>《$MultiValue_table_申請人_申請人名稱$》</p>\n\n<p>《$MultiValue_list_待辦事項_#END#$》</p>\n\n<p>《$專案編號$》<br />\n《$負責程序$》<br />\n《$負責程序_Key$》<br />\n《$立案日$》<br />\n《$立案日_ROC$》<br />\n《$案件編號$》<br />\n《$案件編號2$》<br />\n《$相關卷號$》<br />\n《$類碼$》<br />\n《$客戶編號$》<br />\n《$案件屬性$》<br />\n《$案件屬性_Key$》<br />\n《$申請國家$》<br />\n《$申請國家_Key$》<br />\n《$案件類別$》<br />\n《$案件類別_Key$》<br />\n《$案件種類$》<br />\n《$案件種類_Key$》<br />\n《$申請專利名稱(主)$》<br />\n《$申請專利名稱(副)$》<br />\n《$客戶委案名稱$》<br />\n《$申請日$》<br />\n《$申請日_ROC$》<br />\n《$申請號$》<br />\n《$公開日$》<br />\n《$公開日_ROC$》<br />\n《$公開號$》<br />\n《$公告日$》<br />\n《$公告日_ROC$》<br />\n《$公告號$》<br />\n《$發證日$》<br />\n《$發證日_ROC$》<br />\n《$證書號$》<br />\n《$案件狀態$》<br />\n《$案件狀態_Key$》<br />\n《$年費有效日期$》<br />\n《$年費有效日期_ROC$》<br />\n《$年費有效年次$》<br />\n《$結案原因$》<br />\n《$結案原因_Key$》<br />\n《$業務人員$》<br />\n《$業務人員_Key$》<br />\n《$委外日期$》<br />\n《$委外日期_ROC$》<br />\n《$簽出人$》<br />\n《$簽出時間$》<br />\n《$專案代碼$》<br />\n《$關鍵字$》<br />\n《$技術分類$》<br />\n《$功效分類$》<br />\n《$國際專利分類$》<br />\n《$美國專利分類$》<br />\n《$日本Fi分類$》<br />\n《$工業設計分類$》<br />\n《$公報卷期$》<br />\n《$提實審日$》<br />\n《$提實審日_ROC$》<br />\n《$實審期限$》<br />\n《$申請技術報告$》<br />\n《$獨立項數量$》<br />\n《$附屬項數量$》<br />\n《$圖示數量$》<br />\n《$說明書頁數$》<br />\n《$專利權起始日$》<br />\n《$專利權起始日_ROC$》<br />\n《$專利權終止日$》<br />\n《$專利權終止日_ROC$》<br />\n《$國際申請日$》<br />\n《$國際申請日_ROC$》<br />\n《$國際申請號$》<br />\n《$國際公布日$》<br />\n《$國際公布日_ROC$》<br />\n《$國際公布號$》<br />\n《$進入國家階段日$》<br />\n《$進入國家階段日_ROC$》<br />\n《$送件日$》<br />\n《$送件日_ROC$》<br />\n《$備註$》<br />\n《$其他系列案號$》<br />\n《$案號$》<br />\n《$案號$》<br />\n《$主張優先權$》<br />\n《$IDS$》<br />\n《$系列母案$》<br />\n《$大/小實體$》<br />\n《$最新進度$》<br />\n《$客戶案號$》<br />\n《$代理人$》<br />\n《$代理人_Key$》<br />\n《$最早優先權日$》<br />\n《$最早優先權日_ROC$》<br />\n《$撰稿人員$》<br />\n《$撰稿人員_Key$》<br />\n《$完成日期$》<br />\n《$完成日期_ROC$》<br />\n《$製圖人員$》<br />\n《$製圖人員_Key$》<br />\n《$完成日期$》<br />\n《$完成日期_ROC$》<br />\n《$翻譯人員$》<br />\n《$翻譯人員_Key$》<br />\n《$完成日期$》<br />\n《$完成日期_ROC$》<br />\n《$核駁分析製作人員$》<br />\n《$核駁分析製作人員_Key$》<br />\n《$完成日期$》<br />\n《$答辯人員$》<br />\n《$答辯人員_Key$》<br />\n《$完成日期$》<br />\n《$完成日期_ROC$》<br />\n《$年費管制$》<br />\n《$繳費已通知$》<br />\n《$案件聯絡人$》<br />\n《$代理人案號$》<br />\n《$專利申請權讓與日$》<br />\n《$專利申請權讓與日_ROC$》<br />\n《$專利申請權受讓人$》<br />\n《$專利權讓與日$》<br />\n《$專利權受讓人$》<br />\n《$原案件編號$》<br />\n《$PCT國家階段$》</p>\n','chinese','Common','2014-08-05 16:51:22','2016-04-25 11:44:00'),('PatentCase.Common.admin.04','99','admin','PatentCase','請款單','<h3 style=\"text-align:center\"><span style=\"font-size:14px\"><span style=\"font-family:標楷體,times\">萬國法律事務所 &nbsp; &nbsp; &nbsp;</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;FORMOSA TRANSNATIONAL</span></h3>\n\n<h3 style=\"text-align:left\"><span style=\"font-size:8pt\"><span style=\"font-family:標楷體,times\">台北市大安區106和安里6鄰</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ATTORNEYS AT LAW</span><br />\n<span style=\"font-size:8pt\"><span style=\"font-family:標楷體,times\">仁愛路3段136號芙蓉大樓13樓</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 13&#39;Floor,Lotus Building</span><br />\n<span style=\"font-size:8pt\"><span style=\"font-family:標楷體,times\">統一編號:04145886 &nbsp;</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;No.136,Jen Ai Road,Section 3</span><br />\n<span style=\"font-size:8pt\"><span style=\"font-family:標楷體,times\">電話:(02)2755-7366(代表線) &nbsp; &nbsp; &nbsp;</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Taipei 106,Taiwan,R.O.C</span><br />\n<span style=\"font-size:8pt\"><span style=\"font-family:標楷體,times\">傳真:(02)2755-6486 &nbsp;</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;TEL:(02)2755-7366</span><br />\n<span style=\"font-size:8pt\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Fax:(02)2755-6486</span><br />\n<span style=\"font-size:8pt\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; E-mail:ftlaw@taiwanlaw.com</span><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</strong><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></h3>\n\n<div>\n<table style=\"float:right; width:320px\">\n  <tbody>\n   <tr>\n      <td style=\"text-align:right\"><strong>Date:&nbsp;</strong></td>\n      <td style=\"text-align:right\"><strong>&nbsp; &nbsp;August 8, 2014</strong><strong>&nbsp;</strong></td>\n   </tr>\n   <tr>\n      <td><strong>Your</strong><strong>Ref.:&nbsp;</strong></td>\n      <td>\n      <p>《$客戶編號$》</p>\n     </td>\n   </tr>\n   <tr>\n      <td><strong>&nbsp; Our</strong><strong>Ref.:</strong></td>\n      <td><strong>《$案件編號$》</strong></td>\n    </tr>\n </tbody>\n</table>\n</div>\n\n<div style=\"text-align: right;\"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></div>\n\n<p><strong>&nbsp;</strong><br />\n<br />\n&nbsp;</p>\n\n<h2><strong>Re:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Taiwan Patent Application No.《$申請號$》</strong></h2>\n\n<p><strong>Title:&nbsp;&nbsp;<span style=\"font-family:標楷體,times\">《$申請專利名稱(主)$》《$申請專利名稱(副)$》</span></strong></p>\n\n<p><strong>Applicant:&nbsp;《$客戶名稱$》</strong></p>\n\n<p><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></p>\n\n<p><strong>&nbsp;</strong></p>\n\n<p>Dear Mr./Ms.&nbsp;《$客戶名稱$》</p>\n\n<p>The Certificate of Invention Patent which you appointed is attached herewith. The related information is as follows,</p>\n\n<p>Issue Date:&nbsp;《$公告日$》</p>\n\n<p>Patent No.:&nbsp;《$公告號$》</p>\n\n<p>Certificate No.: 《$案件類別$》<span style=\"font-family:標楷體,times\">第</span> 《$證書號$》<span style=\"font-family:標楷體,times\">&nbsp;號</span></p>\n\n<p>Patent period: From 《$專利權起始日$》&nbsp;to&nbsp;《$專利權終止日$》</p>\n\n<p>The 2nd annual fee should be paid by&nbsp;《$年費有效日期$》. We have docketed the due date on our computers and will remind you by the due date. Thank you for allowing us to be of service. Should you have any questions, please do not hesitate to contact us.</p>\n\n<p>&nbsp;</p>\n\n<p>Regards,</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p>Mr. ABC</p>\n\n<p>Managing Partner</p>\n\n<h3>FORMOSA TRANSNATIONAL&nbsp;&nbsp;ATTORNEYS AT LAW</h3>\n','chinese','Common','2014-08-08 12:05:33','2017-04-14 17:57:02'),('PatentCase.Common.admin.05','99','admin','PatentCase','test1','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n親愛的《$客戶名稱$》您好<br /><br />像您報告您在《$立案日_ROC$》交辦的案件已經在《$申請日$》完成送件，申請號為《$申請號$》<br /><br />\n</body>\n</html>','chinese','Common','2014-09-18 10:38:09',''),('PatentCase.Common.admin.06','99','admin','PatentCase','TC-20','<p>TC-19進度通知-申請案送件完成●-(國內客戶)-(All)</p>\n\n<p>email收件人：</p>\n\n<p>email主旨(REAL除外)：進度通知-新案送件完成 (貴方案號：《$客戶案號$》; 我方案號：《$案件編號$》《貴方承辦人：《$案件聯絡人$》》</p>\n\n<p>email主旨<span style=\"background-color:#FFFF00\">(REAL專用)</span>：【AP】【《$案件聯絡人$》】【Due:<span style=\"color:#FF0000\">2014/10/03</span>】《$客戶編號$》-《$案件編號$》 / Submitted</p>\n\n<p>慧盈國際專利事務所</p>\n\n<p><span style=\"color:#FF0000\">2014年11月07日</span></p>\n\n<p>送呈：《$案件聯絡人$》</p>\n\n<p>《$客戶名稱$》</p>\n\n<p>《$備註$》</p>\n\n<p><br />\n事由：專利案進度通知-申請案送件完成<br />\n貴方案號：《$客戶案號$》&nbsp;<br />\n我方案號：《$案件編號$》&nbsp;<br />\n案件名稱：《$申請專利名稱(主)$》<br />\n申請類型：《$案件類別$》<br />\n申請地區：《$申請國家$》</p>\n\n<p>發明人：《$MultiValue_string&nbsp;_發明人_發明人名稱&sect;發明人名稱(英)$》</p>\n\n<p>申請號　：《$申請號$》</p>\n\n<p>申請日　：《$申請日$》</p>\n\n<p>《$MultiValue_list_優先權_優先權國家&sect;優先權日&sect;優先權號$》─────────────────────────────────────</p>\n\n<p><br />\nDear 《$案件聯絡人$》,<br />\n<br />\n我方已將題述案件遞交至<span style=\"color:#FF0000\">經濟部智慧財產局／美國專利商標局／大陸知識產權局／歐洲專利局</span>，附件是本案申請文件的電子檔以及說明書完稿WORD檔，敬請查收。</p>\n\n<p>&nbsp;</p>\n\n<p>嗣後收到進一步官方文件時，我們會儘速通知　貴方。</p>\n\n<p>&nbsp;</p>\n\n<p>依據　貴方委案時之指示，我方同時申請台灣案的優先權證明文件<span style=\"color:#FF0000\">N</span>份供後續申請<span style=\"color:#FF0000\">歐洲</span>及<span style=\"color:#FF0000\">美國</span>案使用，並著手進行<span style=\"color:#FF0000\">大陸</span>案的送件程序，和<span style=\"color:#FF0000\">美國</span>、<span style=\"color:#FF0000\">歐洲</span>案的翻譯事宜。<span style=\"background-color:#FFFF00\">(TW案使用這句，CN案、US案、EP案不需要這句)</span><br />\n<br />\n感謝　<span style=\"color:#FF0000\">貴方</span>對我方的信任，如有任何問題，歡迎隨時與我們聯繫。</p>\n\n<p><br />\n《附件》</p>\n\n<p><span style=\"color:#FF0000\">(TW案專用)</span><br />\n1. 專利申請書<br />\n2. 專利說明書<br />\n3. TW優先權證申請書<br />\n4. 說明書完稿WORD檔</p>\n\n<p><span style=\"color:#FF0000\">(US案專用)</span><br />\n1. 專利申請電子送件確認<br />\n2. 專利申請書<br />\n3. 專利說明書<br />\n4. 說明書完稿WORD檔<br />\n5. Application Data Sheet<br />\n6. IDS注意事項<br />\n<span style=\"color:#FF0000\">7. IDS遞交副本<span style=\"background-color:#FFFF00\">(有IDS才要)</span></span></p>\n\n<p><span style=\"color:#FF0000\">(CN案專用)</span><br />\n1. 專利申請書<br />\n2. 專利說明書<br />\n3. 實審請求書<br />\n4. SIPO受理通知書<br />\n5. 說明書完稿WORD檔<br />\n<span style=\"color:#FF0000\">6. 保密審查意見通知書(CN第一案就有)</span></p>\n\n<p><span style=\"color:rgb(255, 0, 0)\">(案專用)</span><br />\n1. 專利申請電子送件確認<br />\n2. 專利申請書<br />\n3. 專利說明書<br />\n4. 說明書完稿WORD檔<br />\n5. TW優先權證遞交報告</p>\n\n<p>Best Regards, 台灣／中國專利代理人　　《$業務主管_Key$》<br />\n案件聯絡人　　　　　　　《$負責程序_Key$》<br />\n台灣專利師／中國專利代理人　《$業務主管_Key$》<br />\n案件聯絡人　　　　　　　　　《$負責程序_Key$》&nbsp;<br />\n慧盈國際專利事務所<br />\nIP Winner International Patent Office<br />\n10045台北市中正區衡陽路51號11樓<br />\n11F, No.51 Heng-Yang Road, Taipei 10045, Taiwan<br />\nTEL: +886-2-2382-0212<br />\nFAX: +886-2-2382-0285<br />\nEMAIL: ip@ipwinner.com www.ipwinner.com<br />\n若對我方有任何指示，請一併寄送副本至我方總收發信箱(ip@ipwinner.com)，以確保您的來信能獲得及時處理。 =====<br />\n本電子郵件及附件均為機密資料。凡收件人以外均無權且禁止對本電子郵件及附件進行任何使用、揭露、重製或散佈之行為。若您非應為本電子郵件之收件者，請立即通知寄信人，並將本電子郵件、附件與所有副本立即刪除，感謝您的配合。<br />\nThis e-mail and attachment(s) thereto contain confidential and/or legally privileged information.&nbsp; If you are not the intended recipient, you are prohibited from disclosing, copying, distributing, or taking any action in reliance on the contents of this e-mail and/or the attachment(s); please notify the sender in this regard and destroy this e-mail, the attachment(s), and all the copies immediately.&nbsp; Thank you for your cooperation. =====</p>\n','chinese','Common','2014-11-07 15:02:51','2015-11-11 15:29:17'),('PatentCase.Common.admin.07','99','admin','PatentCase','TA-01','<p>TA-01委託新案●-(EP)</p>\n\n<p>email收件人：goddar@boehmert.de, ip@ipwinner.com</p>\n\n<p>email主旨：Order Letter from IP Winner (Your Ref.:《$代理人案號$》; Our Ref.:《$案件編號$》)</p>\n\n<p>&nbsp;</p>\n\n<p>IP Winner International Patent Office<br />\nNovember 7, 2014<br />\n《Via email》</p>\n\n<p>Attn: Prof. Dr. Heinz GODDAR<br />\n《$代理人$》<br />\nPettenkoferstrasse 20 &ndash; 22<br />\nD-80336 Munich, Germany<br />\n<br />\nRe:　　　　　EP Patent Filing Request<br />\nYour Ref.:《$代理人案號$》<br />\nOur Ref.:《$案件編號$》　　<br />\nTitle:&nbsp;《$申請專利名稱(主)$》<br />\nApplicant:　&nbsp;《$客戶名稱$》<br />\n───────────────────────────────<br />\n<br />\nDear Prof. Dr. Heinz GODDAR,<br />\n<br />\nWe need your firm&rsquo;s assistance in filing the captioned EP patent application to EPO, and please find below the related information of this case:<br />\n1. Applicant(s) information:(Total of 2)</p>\n\n<p>《$MultiValue_list_申請人_申請人名稱&sect;統一編號$》</p>\n\n<p>《$MultiValue_list_發明人_發明人名稱&sect;發明人名稱(英)&sect;國籍&sect;身分證號$》</p>\n\n<p>​<br />\n3. Priority claim: 《$主張優先權$》(total of 1)<br />\n《$MultiValue_string、_優先權_優先權國家&sect;優先權日&sect;優先權號$》<br />\n&nbsp;&nbsp;<br />\n- We will send you the TW priority document after filing of this EP application<br />\n4. Examination and Designation fee: &nbsp;&nbsp;<br />\n- Please NOT to pay the Examination and Designation fee before publication of the search report &nbsp;&nbsp;<br />\n- Please pay the Examination and Designation fee along with the filing<br />\n<br />\n5. Request for examination along with filing: YES/NO<br />\n<br />\n6. Expected filing date: &nbsp;&nbsp;<br />\n- September 30, 2010 &nbsp;&nbsp;<br />\n- Wait for further instruction &nbsp;&nbsp;<br />\n- Upon receipt of the priority document<br />\n<br />\nPlease provide your Reference No. for this case to us so that we can quote it when mailing the certified copy of TW priority document to your office.<br />\nPlease kindly acknowledge receipt of this email and its attachments, and feel free to let us know should you have any questions, thanks.<br />\n<br />\n《Attachments》<br />\n1. EP patent specification (​WORD&nbsp;​and PDF document with 4 drawings)</p>\n\n<p>Best Regards,<br />\n《$負責程序_Key$》&nbsp;(Ms.)<br />\nfor 《$業務主管_Key$》&nbsp;<br />\nIP Winner International Patent Office<br />\n11F, No.51 Heng-Yang Road, Taipei 10045, Taiwan<br />\nTEL: +886-2-2382-0212<br />\nFAX: +886-2-2382-0285<br />\nEMAIL: <a href=\"mailto:ip@ipwinner.com\">ip@ipwinner.com </a><br />\n<a href=\"http://www.ipwinner.com\">www.ipwinner.com </a><br />\n<br />\nPlease copy all instructions to <a href=\"&quot;mailto:ip@ipwinner.com&quot;\">ip@ipwinner.com</a> to ensure proper handling.<br />\n<br />\n=====<br />\nThis e-mail and attachment(s) thereto contain confidential and/or legally privileged information.&nbsp; If you are not the intended recipient, you are prohibited from disclosing, copying, distributing, or taking any action in reliance on the contents of this e-mail and/or the attachment(s); please notify the sender in this regard and destroy this e-mail, the attachment(s), and all the copies immediately.&nbsp; Thank you for your cooperation.<br />\n=====</p>\n','chinese','Common','2014-11-07 15:24:17','2014-11-13 13:44:15'),('PatentCase.Common.admin.08','99','admin','PatentCase','test2','<p>測試報表13<br />\n《$建檔時間$》</p>\n\n<p>《$MultiValue_list_發明人_#START#$》《$MultiValue_list_發明人_發明人名稱$》(《$MultiValue_list_發明人_發明人名稱(英)$》)、《$MultiValue_list_發明人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>《$MultiValue_list_申請人_#START#$》《$MultiValue_list_申請人_申請人名稱$》、《$MultiValue_list_申請人_#END#$》</p>\n\n<p>《$MultiValue_list_申請人_#START#$》&nbsp;<br />\n【申請人《$MultiValue_list_申請人_#編號#$》】<br />\n　　【國籍】　　　　　　《$MultiValue_list_申請人_國籍$》<br />\n　　【中文名稱】　　　　《$MultiValue_list_申請人_申請人名稱$》<br />\n&nbsp; &nbsp; &nbsp; &nbsp;【中文地址】　　　　《$MultiValue_list_申請人_聯絡地址$》</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>【申請人1】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文名稱】　　　　黃海公司<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　新竹市埔前路49號<br />\n<br />\n【申請人2】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文姓名】　　　　黃毓晴<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　高雄市一心路95號</p>\n\n<p>《$MultiValue_list_申請人_#START#$》#《$MultiValue_list_申請人_#編號#$》Applicant:&nbsp;<br />\n&nbsp;&nbsp; - also Assignee<br />\n&nbsp;&nbsp; - Organization Name: 《$MultiValue_list_申請人_申請人名稱(英)$》<br />\n&nbsp;&nbsp; - Mailing Address: 《$MultiValue_list_申請人_登記地址(英)$》<br />\n&nbsp;&nbsp; - Country:&nbsp;《$MultiValue_list_申請人_國籍_Key$》<br />\n&nbsp;&nbsp; - Postal Code:&nbsp;《$MultiValue_list_申請人_郵遞區號$》<br />\n&nbsp;&nbsp; - Entity Status: 《$大/小實體$》《$MultiValue_list_申請人_#換行#$》《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>瑞昱半導體股份有限公司(Realtek Semiconductor Corp.)、黃毓晴(Yu-Ching HUANG)、立錡科技股份有限公司(Richtek Technology Corporation)</p>\n\n<p><br />\n<br />\n&nbsp;</p>\n','chinese','Common','2018-03-22 15:26:48','2018-03-22 15:27:09'),('PatentCase.Common.test.02','99','test','PatentCase','TG-01','<div style=\"text-align: center;\"><span style=\"font-size:22px\">【發明專利申請書】</span></div>\n\n<div style=\"text-align: center;\">&nbsp;</div>\n\n<div>【案由】　　　　　　　　　　　10000</div>\n\n<div>【一併申請實體審查】　　　　　是/否</div>\n\n<div>【事務所或申請人案件編號】　 &nbsp;&nbsp;《$案件編號$》</div>\n\n<div>　</div>\n\n<div>【中文發明名稱】　　　　　　 &nbsp; 《$申請專利名稱(主)$》&nbsp;　</div>\n\n<div>【英文發明名稱】　　　　　　　《$申請專利名稱(副)$》</div>\n\n<div>&nbsp;</div>\n\n<div>《$MultiValue_list_申請人_申請人名稱$》</div>\n\n<div>&nbsp;</div>\n\n<div><span style=\"color:#FF0000\">《$MultiValue_list_代理人_代理人名稱$》</span></div>\n\n<div>&nbsp;</div>\n\n<div><span style=\"color:rgb(255, 0, 0)\">《$MultiValue_list_優惠期_主張優惠期$》</span></div>\n\n<div>&nbsp;</div>\n\n<div>《$MultiValue_list_優先權_優先權國家&sect;優先權日&sect;優先權號$》《$立案日_ROC$》</div>\n\n<div>&nbsp;</div>\n\n<div>【主張利用生物材料1】</div>\n\n<div>\n<p>　　【寄存國家】　　　　　　　空白</p>\n\n<p>　　【寄存機構】　　　　　　　空白</p>\n\n<p>　　【寄存日期】　　　　　　　空白</p>\n\n<p>　　【寄存號碼】　　　　　　　空白</p>\n\n<p>&nbsp;</p>\n\n<p>【生物材料不須寄存】　　　 &nbsp; &nbsp; &nbsp; 空白</p>\n\n<p>&nbsp;</p>\n\n<p>【聲明本人就相同創作在申請本發明專利之同日-另申請新型專利】　<span style=\"color:#FF0000\">《$是否一案兩請$》</span></p>\n\n<p>&nbsp;</p>\n\n<p>【中文本資訊】</p>\n\n<p>　　【摘要頁數】　　　　　　　</p>\n\n<p>　　【說明書頁數】　　　　 &nbsp; &nbsp; &nbsp;&nbsp;《$說明書頁數$》　　</p>\n\n<p>　　【申請專利範圍頁數】　　　</p>\n\n<p>　　【圖式頁數】　　　　　　　《$圖示數量$》</p>\n\n<p>　　【頁數總計】　　　　　　　</p>\n\n<p>　　【申請專利範圍項數】　　　《$獨立項數量$》+《$附屬項數量$》</p>\n\n<p>　　【圖式圖數】　　　　　　　</p>\n\n<p>　　【附英文摘要】　　　　　　　是</p>\n\n<p>&nbsp;</p>\n\n<p>【外文本資訊】</p>\n\n<p>　　【外文頁數總計】　　　　　空白</p>\n\n<p>　　【外文本種類】　　　　　　空白</p>\n\n<p>&nbsp;</p>\n\n<p>【簡體字本資訊】</p>\n\n<p>　　【簡體字頁數總計】　　　　空白</p>\n\n<p>&nbsp;</p>\n\n<p>【繳費資訊】</p>\n\n<p>　　【繳費金額】　　　　　　　</p>\n\n<p>　　【收據抬頭】　　　　　　　《$MultiValue_string、_申請人_申請人名稱$》(代繳人：慧盈國際專利事務所)</p>\n\n<p>&nbsp;</p>\n\n<div>\n<p>【附送書件】</p>\n\n<p>　　【基本資料表】　　　　　　</p>\n\n<p>　　【發明摘要】　　　　　　　</p>\n\n<p>　　【發明說明書】　　　　　　　</p>\n\n<p>　　【發明申請專利範圍】　　　</p>\n\n<p>　　【發明圖式】　　　　　　　</p>\n\n<p>　　【外文本】　　　　　　　　</p>\n\n<p>　　【簡體字本】　　　　　　　</p>\n\n<p>　　【優先權證明文件首頁中譯本】</p>\n\n<p>　　【優惠期證明文件】　　　　</p>\n\n<p>　　【委任書】　　　　　　　　</p>\n\n<p>　　【國內生物材料寄存證明文件】</p>\n\n<p>　　【國外生物材料寄存證明文件】</p>\n\n<p>　　【生物材料為通常知識者易於獲得證明文件】</p>\n\n<p>&nbsp;</p>\n\n<p>【檔案具結】本申請書所檢送之PDF檔或影像檔與原本或正本相同。</p>\n\n<p>【個資具結】申請人已詳閱申請須知所定個人資料保護注意事項，並已確認本申請案之附件(除基本資料表、委任書外)，不包含應予保密之個人資料；其載有個人資料者，同意智慧財產局提供任何人以自動化或非自動化之方式閱覽、抄錄、攝影或影印。</p>\n</div>\n</div>\n','chinese','Common','2015-11-11 11:36:45','2015-11-12 17:04:50'),('PatentCase.Common.test.04','99','test','PatentCase','TA-10-委託新案','<p>TA-01委託新案●-(EP)</p>\n\n<p>email收件人：goddar@boehmert.de, ip@ipwinner.com</p>\n\n<p>email主旨：Order Letter from IP Winner (Your Ref.:《$代理人案號$》; Our Ref.:《$案件編號$》)</p>\n\n<p>&nbsp;</p>\n\n<p>IP Winner International Patent Office<br />\nNovember 7, 2014<br />\n《Via email》</p>\n\n<p>Attn: Prof. Dr. Heinz GODDAR<br />\n《$代理人$》<br />\nPettenkoferstrasse 20 &ndash; 22<br />\nD-80336 Munich, Germany<br />\n<br />\nRe:　　　　　EP Patent Filing Request<br />\nYour Ref.:《$代理人案號$》<br />\nOur Ref.:《$案件編號$》　　<br />\nTitle:&nbsp;《$申請專利名稱(主)$》<br />\nApplicant:　&nbsp;《$客戶名稱$》<br />\n───────────────────────────────<br />\n<br />\nDear Prof. Dr. Heinz GODDAR,<br />\n<br />\nWe need your firm&rsquo;s assistance in filing the captioned EP patent application to EPO, and please find below the related information of this case:<br />\n1. Applicant(s) information:(Total of 2)</p>\n\n<p>《$MultiValue_list_申請人_申請人名稱&sect;統一編號$》</p>\n\n<p>&nbsp;</p>\n\n<p>​<br />\n3. Priority claim: 《$主張優先權$》(total of 1)<br />\n《$MultiValue_string、_優先權_優先權國家&sect;優先權日&sect;優先權號$》<br />\n&nbsp;&nbsp;<br />\n- We will send you the TW priority document after filing of this EP application<br />\n4. Examination and Designation fee: &nbsp;&nbsp;<br />\n- Please NOT to pay the Examination and Designation fee before publication of the search report &nbsp;&nbsp;<br />\n- Please pay the Examination and Designation fee along with the filing<br />\n<br />\n5. Request for examination along with filing: YES/NO<br />\n<br />\n6. Expected filing date: &nbsp;&nbsp;<br />\n- September 30, 2010 &nbsp;&nbsp;<br />\n- Wait for further instruction &nbsp;&nbsp;<br />\n- Upon receipt of the priority document<br />\n<br />\nPlease provide your Reference No. for this case to us so that we can quote it when mailing the certified copy of TW priority document to your office.<br />\nPlease kindly acknowledge receipt of this email and its attachments, and feel free to let us know should you have any questions, thanks.<br />\n<br />\n《Attachments》<br />\n1. EP patent specification (​WORD&nbsp;​and PDF document with 4 drawings)</p>\n\n<p>Best Regards,<br />\n《$負責程序_Key$》&nbsp;(Ms.)<br />\nfor 《$業務主管_Key$》&nbsp;<br />\nIP Winner International Patent Office<br />\n11F, No.51 Heng-Yang Road, Taipei 10045, Taiwan<br />\nTEL: +886-2-2382-0212<br />\nFAX: +886-2-2382-0285<br />\nEMAIL: ip@ipwinner.com<br />\nwww.ipwinner.com<br />\n<br />\nPlease copy all instructions to ip@ipwinner.com to ensure proper handling.<br />\n<br />\n=====<br />\nThis e-mail and attachment(s) thereto contain confidential and/or legally privileged information.&nbsp; If you are not the intended recipient, you are prohibited from disclosing, copying, distributing, or taking any action in reliance on the contents of this e-mail and/or the attachment(s); please notify the sender in this regard and destroy this e-mail, the attachment(s), and all the copies immediately.&nbsp; Thank you for your cooperation.<br />\n=====</p>\n','chinese','Common','2016-03-08 14:34:38','2016-03-08 14:41:19'),('PatentCase.Personal.admin.01','99','admin','PatentCase','test20160425','<p>哈瞜!《$客戶名稱$》</p>\n\n<p>《$案件編號$》</p>\n\n<p>《$MultiValue_list_申請人_#START#$》附表申請人《$MultiValue_list_申請人_#編號#$》.《$MultiValue_list_申請人_#換行#$》</p>\n\n<p>申請人:《$MultiValue_list_申請人_申請人名稱$》《$MultiValue_list_申請人_#換行#$》</p>\n\n<p>統一編號:《$MultiValue_list_申請人_統一編號$》</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p>《$MultiValue_list_申請人_#START#$》換行測試:《$MultiValue_list_申請人_#編號#$》.《$MultiValue_list_申請人_申請人名稱$》,《$MultiValue_list_申請人_統一編號$》《$MultiValue_list_申請人_#END#$》</p>\n\n<p>發明人:</p>\n\n<p>《$MultiValue_table_發明人_發明人名稱&sect;國籍&sect;統一編號$》</p>\n\n<p>&nbsp;</p>\n\n<p>優先權:</p>\n\n<p>《$MultiValue_table_優先權_優先權國家&sect;優先權國家_Key&sect;優先權日&sect;優先權日_ROC&sect;優先權號&sect;內部案號&sect;證明文件$》</p>\n\n<p>引證資料</p>\n\n<p>《$MultiValue_table_引證資料_引證資料類別&sect;專利號&sect;公告日&sect;公告日_ROC&sect;專利權人／申請人&sect;相關段落或圖表所在行頁數&sect;公開號&sect;公開日&sect;公開日_ROC&sect;類別碼&sect;國家代碼&sect;為審查官所提出&sect;事務所內部案號&sect;上傳文件&sect;備註$》</p>\n','chinese','Personal','2016-04-25 10:50:21',''),('PatentCase.Personal.admin.02','99','admin','PatentCase','test20161004-1','<p>測試報表1<br />\n《$建檔時間$》</p>\n\n<p><span style=&quot;color:#0000FF&quot;>《$MultiValue_list_發明人_#START#$》《$MultiValue_list_發明人_發明人名稱$》(《$MultiValue_list_發明人_發明人名稱(英)$》)</span>、<span style=&quot;color:#0000FF&quot;>《$MultiValue_list_發明人_#END#$》</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=&quot;color:#008000&quot;>《$MultiValue_list_申請人_#START#$》《$MultiValue_list_申請人_申請人名稱$》</span>、<span style=&quot;color:#008000&quot;>《$MultiValue_list_申請人_#END#$》</span></p>\n\n<p>《$MultiValue_list_申請人_#START#$》<span style=&quot;color:#FF0000&quot;>&nbsp;</span><br />\n【申請人《$MultiValue_list_申請人_#編號#$》】<br />\n<span style=&quot;color:#FF0000&quot;>　　【國籍】　　　　　　</span>《$MultiValue_list_申請人_國籍$》<br />\n<span style=&quot;color:#FF0000&quot;>　　【中文名稱】　　　　</span>《$MultiValue_list_申請人_申請人名稱$》<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp; &nbsp; &nbsp; &nbsp;【中文地址】　　　　</span>《$MultiValue_list_申請人_聯絡地址$》</p>\n\n<p>《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>【申請人1】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文名稱】　　　　黃海公司<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　新竹市埔前路49號<br />\n<br />\n【申請人2】<br />\n　　　【國籍】　　　　　　TW中華民國<br />\n　　　【中文姓名】　　　　黃毓晴<br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 【中文地址】　　　　高雄市一心路95號</p>\n\n<p>《$MultiValue_list_申請人_#START#$》<span style=&quot;color:#FF0000&quot;>#</span>《$MultiValue_list_申請人_#編號#$》Applicant:&nbsp;<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp;&nbsp; - also Assignee<br />\n&nbsp;&nbsp; - Organization Name: </span>《$MultiValue_list_申請人_申請人名稱(英)$》<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp;&nbsp; - Mailing Address: </span>《$MultiValue_list_申請人_登記地址(英)$》<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp;&nbsp; - Country:&nbsp;</span>《$MultiValue_list_申請人_國籍_Key$》<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp;&nbsp; - Postal Code:&nbsp;</span>《$MultiValue_list_申請人_郵遞區號$》<br />\n<span style=&quot;color:#FF0000&quot;>&nbsp;&nbsp; - Entity Status: </span>《$大/小實體$》《$MultiValue_list_申請人_#換行#$》《$MultiValue_list_申請人_#END#$》</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;</p>\n\n<p>套出來類似下面：</p>\n\n<p>瑞昱半導體股份有限公司(Realtek Semiconductor Corp.)、黃毓晴(Yu-Ching HUANG)、立錡科技股份有限公司(Richtek Technology Corporation)</p>\n\n<p><br />\n<br />\n《$MultiValue_table_發明人_部門別&sect;發明人名稱&sect;發明人名稱(英)&sect;身分類別&sect;國籍&sect;國籍_Key&sect;屬性&sect;屬性_Key&sect;稱謂&sect;統一編號$》</p>\n','chinese','Personal','2016-10-04 16:25:01',''),('TrademarkCase.Common.admin.01','99','admin','TrademarkCase','商標案件 報表 test1','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n商標案件報表test1<br />《$建檔時間$》<br />《$建檔人員$》<br />《$最後編輯時間$》<br />《$編輯人$》<br />《$承辦人員$》<br />《$承辦人員_Key$》<br />《$商標名稱(副)$》<br />《$案件編號$》<br />《$負責程序$》<br />《$負責程序_Key$》<br />《$案件編號2$》<br />《$專案編號$》<br />《$備註$》<br />《$案件聯絡人$》<br />《$案件聯絡人_Key$》<br />《$申請國家$》<br />《$申請國家_Key$》<br />《$案件類別$》<br />《$案件類別_Key$》<br />《$案件種類$》<br />《$案件種類_Key$》<br />《$商標名稱(主)$》<br />《$立案日$》<br />《$立案日_ROC$》<br />《$公告卷數$》<br />《$申請日$》<br />《$申請日_ROC$》<br />《$申請號$》<br />《$公開日$》<br />《$公開日_ROC$》<br />《$公開號$》<br />《$註冊日$》<br />《$註冊日_ROC$》<br />《$註冊號$》<br />《$審定號$》<br />《$正審定號$》<br />《$有效起日$》<br />《$有效起日_ROC$》<br />《$延展日$》<br />《$延展日_ROC$》<br />《$案件狀態$》<br />《$案件狀態_Key$》<br />《$結案日$》<br />《$結案日_ROC$》<br />《$圖樣顏色$》<br />《$圖樣顏色_Key$》<br />《$不得單獨主張專用權$》<br />《$圖樣中文$》<br />《$圖樣英文$》<br />《$圖樣日文$》<br />《$中文字義$》<br />《$圖形說明$》<br />《$圖樣記號$》<br />《$客戶編號$》<br />《$商標樣態$》<br />《$商標樣態_Key$》<br />《$有效迄日$》<br />《$有效迄日_ROC$》<br />《$下次宣誓日期$》<br />《$下次宣誓日期_ROC$》<br />《$使用宣誓年次$》<br />《$案件狀態$》<br />《$案件狀態_Key$》<br />《$結案原因$》<br />《$結案原因_Key$》<br />《$業務人員$》<br />《$業務人員_Key$》<br />《$延展年次$》<br />《$公告日$》<br />《$公告日_ROC$》<br />《$公告號$》<br />《$商標分類$》<br />《$商品名稱$》<br />《$群組代碼$》<br />《$最新進度$》<br />《$代理人案號$》<br />《$系列母案$》<br />《$主張優先權案號$》<br />《$代理人$》<br />《$代理人_Key$》<br />《$客戶案號$》<br />《$繳費已通知$》<br />《$延展管制$》<br />《$原案件編號$》<br /><br /><br /><br /><br />\n</body>\n</html>','chinese','Common','2014-08-05 16:40:06','2014-08-06 09:29:25'),('TrademarkCase.Common.admin.02','99','admin','TrademarkCase','取得證書--商標--事務所-EU','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n<p style=\"text-align: center;\">&nbsp;</p>\n<div style=\"text-align: center;\"><span style=\"font-size: 24pt; font-family: 標楷體, times;\"><strong>翼勝專利商標事務所</strong></span></div>\n<div style=\"text-align: center;\"><span style=\"font-size: 12pt; font-family: \'times new roman\', times;\">Essen Patent &amp; Trademark Offices</span></div>\n<div style=\"text-align: center;\"><span style=\"font-family: 標楷體, times;\"><span style=\"font-family: 標楷體, times;\">台北市大安區敦化南路二段77號19樓</span></span></div>\n<div style=\"text-align: center;\"><span style=\"font-family: \'times new roman\', times;\">19F., No.77, Sec. 2, Dunhua S. Rd., Da&rsquo;an Dist., Taipei City 106, Taiwan</span></div>\n<div style=\"text-align: center;\"><span style=\"font-family: \'times new roman\', times;\">Tel: 886-2-27097700&nbsp; Fax: 886-2-27090501</span></div>\n<div style=\"text-align: center;\">&nbsp;</div>\n<p><strong>致：</strong><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</strong><strong>先生/小姐</strong></p>\n<p>《$客戶編號_Key$》</p>\n<p>&nbsp;</p>\n<p>關於您委託的下列案件，業經審查核准，茲檢附商標註冊證如附</p>\n<p>本所編號：《$案件編號$》</p>\n<p>案件名稱：《$商標名稱(主)$》</p>\n<p>申請日：《$申請日$》</p>\n<p>申請號：《$申請號$》</p>\n<p>商標註冊號：《$註冊號$》</p>\n<p>商標權期間：《$有效起日_ROC$》至《$有效迄日_ROC$》</p>\n<p>&nbsp;</p>\n<p>依商標法規定，本商標需在五年內於歐盟會員國內使用(至少一個)，以免導致商標無效，並需於《$有效迄日$》屆期前更新商標權利，屆時本所會另行文通知。後續任何關於本申請案的問題，亦請不吝與本所聯繫，當竭誠為您服務。</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p><strong>翼勝專利商標事務所</strong></p>\n<p><strong>2014</strong><strong>年8月6日</strong></p>\n</body>\n</html>','chinese','Common','2014-08-06 11:30:29','2014-08-06 14:25:09'),('TrademarkCase.Common.admin.03','99','admin','TrademarkCase','請款單','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n<h3 style=\"text-align: center;\">請款單<br /><span style=\"text-decoration: underline;\">STATEMENT</span></h3>\n<h3><span style=\"font-size: 14pt; font-family: 標楷體, times;\">萬國法律事務所 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; FORMOSA TRANSNATIONAL</span><br /><span style=\"font-size: 8pt;\">台北市大安區106和安里6鄰 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ATTORNEYS AT LAW</span><br /><span style=\"font-size: 8pt;\">仁愛路3段136號芙蓉大樓13樓 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 13\'Floor,Lotus Building</span><br /><span style=\"font-size: 8pt;\">統一編號:04145886 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;No.136,Jen Ai Road,Section 3</span><br /><span style=\"font-size: 8pt;\">電話:(02)2755-7366(代表線) &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Taipei 106,Taiwan,R.O.C</span><br /><span style=\"font-size: 8pt;\">傳真:(02)2755-6486 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;TEL:(02)2755-7366<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Fax:(02)2755-6486<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; E-mail:ftlaw@taiwanlaw.com</span></h3>\n<h3>&nbsp;</h3>\n<h3>VIA EXPRESS</h3>\n<p><strong>HIGHEST INTERNATIONAL PATENT &amp; LAW OFFICE</strong></p>\n<p>2F, San<span style=\"font-size: 8pt;\">g</span>won Bldg., 636-15, Yeoksam-dong,</p>\n<p>Gangnam-gu, Seoul 135-908 Korea<strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></p>\n<div>\n<table style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-wrap: break-word; height: 83px; float: right;\" width=\"323\">\n<tbody>\n<tr>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>Date:&nbsp;</strong></td>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>August 8, 2014</strong><strong>&nbsp;</strong></td>\n</tr>\n<tr>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>Your</strong><strong>Ref.:&nbsp;</strong></td>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>《$案件聯絡人$》</strong></td>\n</tr>\n<tr>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>&nbsp; Our</strong><strong>Ref.:</strong></td>\n<td style=\"border: 1px solid black; border-collapse: collapse; table-layout: fixed; word-break: break-strict; word-wrap: break-word;\"><strong>《$案件類別_Key$》</strong></td>\n</tr>\n</tbody>\n</table>\n</div>\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></p>\n<p><strong>&nbsp;<br /><br /><br /><br /></strong></p>\n<h2><strong>Re:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Taiwan Patent Application No.&nbsp;《$申請號$》</strong></h2>\n<p><strong>Title:&nbsp;&nbsp; 《$圖樣中文$》《$圖樣英文$》</strong></p>\n<p><strong>Applicant:&nbsp;《$客戶編號_Key$》</strong></p>\n<p><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Dear Mr. SONG,</p>\n<p>The Certificate of Invention Patent which you appointed is attached herewith. The related information is as follows,</p>\n<p>Issue Date: ${ENG_IssueDate}</p>\n<p>Patent No.: ${IssueNo}</p>\n<p>Certificate No.: 《$案件類別_Key$》第 ${LicenseNo} 號</p>\n<p>Patent period: From ${ENG_RightBeginDate} to ${ENG_RightEndDate}</p>\n<p>The 2nd annual fee should be paid by <strong>${ENG_FeeScheduleDate}</strong>. We have docketed the due date on our computers and will remind you by the due date. Thank you for allowing us to be of service. Should you have any questions, please do not hesitate to contact us.</p>\n<p>&nbsp;</p>\n<p>Regards,</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>Steven Wang</p>\n<p>Managing Partner</p>\n<p>Essen Intellectual Capital Management Co., LTD.</p>\n</body>\n</html>','chinese','Common','2014-08-08 11:01:37','2014-08-08 11:34:25'),('TrademarkRenewalLog.Personal.admin.01','99','admin','TrademarkRenewalLog','年費測試報表','<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n《$商標延展確認單號$》《$申請國家$》《$申請國家_Key$》<br /><br />《$註冊號$》《$申請日$》《$申請日_ROC$》《$申請日_ROC$》《$客戶代碼$》《$客戶代碼_Key$》《$大小實體$》\n</body>\n</html>','chinese','Personal','2014-08-21 14:20:46','2014-08-21 14:21:50');
/*!40000 ALTER TABLE `reportdraftsetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportpersonaldata`
--

DROP TABLE IF EXISTS `reportpersonaldata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportpersonaldata` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `SettingTableName` varchar(50) DEFAULT NULL,
  `ReportId` varchar(50) DEFAULT NULL,
  `ReportName` varchar(100) DEFAULT NULL,
  `CaseId` varchar(100) DEFAULT NULL,
  `ReportData` text,
  `Language` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `ModifyTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportpersonaldata`
--

LOCK TABLES `reportpersonaldata` WRITE;
/*!40000 ALTER TABLE `reportpersonaldata` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportpersonaldata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporttablesetting`
--

DROP TABLE IF EXISTS `reporttablesetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporttablesetting` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `SettingTableName` varchar(50) DEFAULT NULL,
  `SettingField` text,
  `Language` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `ModifyTime` varchar(20) DEFAULT NULL,
  `AddtionFieldSetting` text,
  `ShowNumberField` varchar(100) DEFAULT NULL,
  `ShowNameField` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporttablesetting`
--

LOCK TABLES `reporttablesetting` WRITE;
/*!40000 ALTER TABLE `reporttablesetting` DISABLE KEYS */;
INSERT INTO `reporttablesetting` VALUES ('RTS20140801.01','99','admin','PatentCase','[{\"field\":\"createTime\",\"replace\":\"《$建檔時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"creator\",\"replace\":\"《$建檔人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updateTime\",\"replace\":\"《$最後編輯時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updater\",\"replace\":\"《$編輯人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientName\",\"replace\":\"《$客戶名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAssignedTo\",\"replace\":\"《$業務主管$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"serviceProjectCode\",\"replace\":\"《$專案編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAD\",\"replace\":\"《$負責程序$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"caseStartDate\",\"replace\":\"《$立案日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"caseNo\",\"replace\":\"《$案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo2\",\"replace\":\"《$案件編號2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ideaId\",\"replace\":\"《$相關卷號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"familyOrder\",\"replace\":\"《$類碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAttribute\",\"replace\":\"《$案件屬性$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"patentOffice\",\"replace\":\"《$申請國家$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"patentType\",\"replace\":\"《$案件類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"patentCaseType\",\"replace\":\"《$案件種類$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"title\",\"replace\":\"《$申請專利名稱(主)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"englishTitle\",\"replace\":\"《$申請專利名稱(副)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"originalTitle\",\"replace\":\"《$客戶委案名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"applyDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"applyNo\",\"replace\":\"《$申請號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"publishDate\",\"replace\":\"《$公開日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"publishNo\",\"replace\":\"《$公開號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"issueDate\",\"replace\":\"《$公告日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"issueNo\",\"replace\":\"《$公告號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"licenseDate\",\"replace\":\"《$發證日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"licenseNo\",\"replace\":\"《$證書號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"status\",\"replace\":\"《$案件狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"feeScheduleDate\",\"replace\":\"《$年費有效日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"feeSchedule\",\"replace\":\"《$年費有效年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"giveupCode\",\"replace\":\"《$結案原因$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"inCharge\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"outsourceDate\",\"replace\":\"《$委外日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"signOutName\",\"replace\":\"《$簽出人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"signOutTime\",\"replace\":\"《$簽出時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"projectCode\",\"replace\":\"《$專案代碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"keyword\",\"replace\":\"《$關鍵字$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"techCategory\",\"replace\":\"《$技術分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"funcCategory\",\"replace\":\"《$功效分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ipc\",\"replace\":\"《$國際專利分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"uspc\",\"replace\":\"《$美國專利分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fi\",\"replace\":\"《$日本Fi分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"locarno\",\"replace\":\"《$工業設計分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"gattezz\",\"replace\":\"《$公報卷期$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"examineDate\",\"replace\":\"《$提實審日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"examineDueDate\",\"replace\":\"《$實審期限$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"techReportApply\",\"replace\":\"《$申請技術報告$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"independentClaim\",\"replace\":\"《$獨立項數量$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"dependentClaim\",\"replace\":\"《$附屬項數量$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"drawing\",\"replace\":\"《$圖示數量$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalPage\",\"replace\":\"《$說明書頁數$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"rightBeginDate\",\"replace\":\"《$專利權起始日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"rightEndDate\",\"replace\":\"《$專利權終止日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"pctAppDate\",\"replace\":\"《$國際申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"pctAppNo\",\"replace\":\"《$國際申請號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"pctPublishDate\",\"replace\":\"《$國際公布日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"wipoNo\",\"replace\":\"《$國際公布號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"nationalPhaseDate\",\"replace\":\"《$進入國家階段日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"deliveryDate\",\"replace\":\"《$送件日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"remark\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherCaseNo\",\"replace\":\"《$其他系列案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"priorityCaseNo\",\"replace\":\"《$案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"idsCaseNo\",\"replace\":\"《$案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"priority\",\"replace\":\"《$主張優先權$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ids\",\"replace\":\"《$IDS$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serialMotherCase\",\"replace\":\"《$系列母案$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"entity\",\"replace\":\"《$大/小實體$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"lastSchedule\",\"replace\":\"《$最新進度$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"internalNo\",\"replace\":\"《$客戶案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorney\",\"replace\":\"《$代理人$》\",\"type\":\"select\",\"category\":\"Attorney\"},{\"field\":\"priorityDeadLine\",\"replace\":\"《$最早優先權日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"writtenMan\",\"replace\":\"《$撰稿人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"writtenFinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"mappingMan\",\"replace\":\"《$製圖人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"mappingFinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"translateMan\",\"replace\":\"《$翻譯人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"translateFinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"rejectionMan\",\"replace\":\"《$核駁分析製作人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"rejectionFinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"replyMan\",\"replace\":\"《$答辯人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"replyFinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"autoPay\",\"replace\":\"《$年費管制$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"paymentConfirming\",\"replace\":\"《$繳費已通知$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientContect\",\"replace\":\"《$案件聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"attorneyNum\",\"replace\":\"《$代理人案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"applyTransDate\",\"replace\":\"《$專利申請權讓與日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"applyTransTo\",\"replace\":\"《$專利申請權受讓人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"rightTransDate\",\"replace\":\"《$專利權讓與日$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"rightTransTo\",\"replace\":\"《$專利權受讓人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fromCase\",\"replace\":\"《$原案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"pctNationalPhase\",\"replace\":\"《$PCT國家階段$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-01 17:01:16','2014-08-11 15:54:25','','CaseNo','Title'),('RTS20140804.01','99','admin','TrademarkCase','[{\"field\":\"createTime\",\"replace\":\"《$建檔時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"creator\",\"replace\":\"《$建檔人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updateTime\",\"replace\":\"《$最後編輯時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updater\",\"replace\":\"《$編輯人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAssignedTo\",\"replace\":\"《$承辦人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"englishTitle\",\"replace\":\"《$商標名稱(副)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo\",\"replace\":\"《$案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAD\",\"replace\":\"《$負責程序$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"caseNo2\",\"replace\":\"《$案件編號2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceProjectCode\",\"replace\":\"《$專案編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"remark\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientContect\",\"replace\":\"《$案件聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"office\",\"replace\":\"《$申請國家$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"trademarkType\",\"replace\":\"《$案件類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"trademarkCaseType\",\"replace\":\"《$案件種類$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"title\",\"replace\":\"《$商標名稱(主)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyDate\",\"replace\":\"《$立案日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"attorneyNum\",\"replace\":\"《$公告卷數$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fillingDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"fillingNum\",\"replace\":\"《$申請號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"publicationDate\",\"replace\":\"《$公開日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"publicationNum\",\"replace\":\"《$公開號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"registDate\",\"replace\":\"《$註冊日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"registNum\",\"replace\":\"《$註冊號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"trademarkNum\",\"replace\":\"《$審定號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"trademarkNo\",\"replace\":\"《$正審定號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"expiryDate\",\"replace\":\"《$有效起日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"extendDate\",\"replace\":\"《$延展日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"status\",\"replace\":\"《$案件狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"closedDate\",\"replace\":\"《$結案日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"color\",\"replace\":\"《$圖樣顏色$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"noBelongDesc\",\"replace\":\"《$不得單獨主張專用權$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"chtWordsinMark\",\"replace\":\"《$圖樣中文$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"engWordsinMark\",\"replace\":\"《$圖樣英文$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"japWordsinMark\",\"replace\":\"《$圖樣日文$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"significance\",\"replace\":\"《$中文字義$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"graphDesc\",\"replace\":\"《$圖形說明$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"designMark\",\"replace\":\"《$圖樣記號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶編號$》\",\"type\":\"select\",\"category\":\"Client\"},{\"field\":\"markType\",\"replace\":\"《$商標樣態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"expiryDateTo\",\"replace\":\"《$有效迄日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"oathDate\",\"replace\":\"《$下次宣誓日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"oathYear\",\"replace\":\"《$使用宣誓年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"trademarkCaseStatus\",\"replace\":\"《$案件狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"trademarkCaseCloseStatus\",\"replace\":\"《$結案原因$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"sales\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"extendTime\",\"replace\":\"《$延展年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"issueDate\",\"replace\":\"《$公告日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"issueNo\",\"replace\":\"《$公告號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"trademarkClassification\",\"replace\":\"《$商標分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"goodsServices\",\"replace\":\"《$商品名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"groupCode\",\"replace\":\"《$群組代碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"lastSchedule\",\"replace\":\"《$最新進度$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyNo\",\"replace\":\"《$代理人案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serialMotherCase\",\"replace\":\"《$系列母案$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"priorityCaseNo\",\"replace\":\"《$主張優先權案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorney\",\"replace\":\"《$代理人$》\",\"type\":\"select\",\"category\":\"Attorney\"},{\"field\":\"internalNo\",\"replace\":\"《$客戶案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"paymentConfirming\",\"replace\":\"《$繳費已通知$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"autoPay\",\"replace\":\"《$延展管制$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fromCase\",\"replace\":\"《$原案件編號$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-04 09:34:30','2014-08-11 15:55:22','','CaseNo','Title'),('RTS20140804.02','99','admin','LegalCase','[{\"field\":\"createTime\",\"replace\":\"《$建檔時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"creator\",\"replace\":\"《$建檔人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updateTime\",\"replace\":\"《$最後編輯時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updater\",\"replace\":\"《$編輯人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAssignedTo\",\"replace\":\"《$承辦人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"englishTitle\",\"replace\":\"《$案件名稱(副)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo\",\"replace\":\"《$案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAD\",\"replace\":\"《$負責程序$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"caseNo2\",\"replace\":\"《$案件編號2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientContect\",\"replace\":\"《$案件聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"title\",\"replace\":\"《$案件名稱(主)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"description\",\"replace\":\"《$案件說明$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"mainType\",\"replace\":\"《$案件類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"subType\",\"replace\":\"《$案件中類$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"priority\",\"replace\":\"《$優先順序$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"status\",\"replace\":\"《$案件狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"targetStartDate\",\"replace\":\"《$立案日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"realStartDate\",\"replace\":\"《$起訴申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"targetFinishDate\",\"replace\":\"《$預計完成日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"realFinishDate\",\"replace\":\"《$裁判日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"tmpField_02\",\"replace\":\"《$洽案律師$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"tmpField_04\",\"replace\":\"《$案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_05\",\"replace\":\"《$法院$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"tmpField_06\",\"replace\":\"《$法官$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_08\",\"replace\":\"《$判決結果$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_09\",\"replace\":\"《$客戶案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"inCharge\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"serviceProjectCode\",\"replace\":\"《$專案編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serialMotherCase\",\"replace\":\"《$系列母案$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fromCase\",\"replace\":\"《$原案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherLFirm\",\"replace\":\"《$對方委任律所$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherLawyer\",\"replace\":\"《$對方委任律師$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorney\",\"replace\":\"《$代理人$》\",\"type\":\"text\",\"category\":\"Attorney\"},{\"field\":\"attorneyNum\",\"replace\":\"《$代理人案號$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-04 09:45:53','2014-08-11 15:55:41','','CaseNo','Title'),('RTS20140804.03','99','admin','CopyrightCase','[{\"field\":\"createTime\",\"replace\":\"《$建檔時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"creator\",\"replace\":\"《$建檔人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updateTime\",\"replace\":\"《$最後編輯時間$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"updater\",\"replace\":\"《$編輯人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAssignedTo\",\"replace\":\"《$承辦人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"englishTitle\",\"replace\":\"《$案件名稱(副)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serialMotherCase\",\"replace\":\"《$系列母案$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceProjectCode\",\"replace\":\"《$專案編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAD\",\"replace\":\"《$負責程序$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"caseNo\",\"replace\":\"《$案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo2\",\"replace\":\"《$案件編號2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientContect\",\"replace\":\"《$案件聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"title\",\"replace\":\"《$案件名稱(主)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"description\",\"replace\":\"《$案件說明$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"mainType\",\"replace\":\"《$案件類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"subType\",\"replace\":\"《$案件中類$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"status\",\"replace\":\"《$案件狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"targetStartDate\",\"replace\":\"《$公開日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"realStartDate\",\"replace\":\"《$實際完成日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"targetFinishDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"realFinishDate\",\"replace\":\"《$實際登記日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"tmpField_01\",\"replace\":\"《$申請號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_02\",\"replace\":\"《$登記號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_03\",\"replace\":\"《$原創公司$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_04\",\"replace\":\"《$原創人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_05\",\"replace\":\"《$立案日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"tmpField_06\",\"replace\":\"《$客戶案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_07\",\"replace\":\"《$代理人案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_08\",\"replace\":\"《$代理人$》\",\"type\":\"select\",\"category\":\"Attorney\"},{\"field\":\"tmpField_09\",\"replace\":\"《$自定欄位九$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tmpField_10\",\"replace\":\"《$自定欄位十$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"inCharge\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"copyRightUnit\",\"replace\":\"《$著作單位$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"fromCase\",\"replace\":\"《$原案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"office\",\"replace\":\"《$國別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"numberOfUnits\",\"replace\":\"《$單位數量$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-04 09:56:34','2014-08-11 15:55:59','','CaseNo','Title'),('RTS20140808.01','99','admin','RenewalLog','[{\"field\":\"flowKey\",\"replace\":\"《$專利年費確認單號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"patentOffice\",\"replace\":\"《$申請國家$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"licenseNo\",\"replace\":\"《$專利獲證號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"applyDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶代碼$》\",\"type\":\"select\",\"category\":\"Client\"},{\"field\":\"entity\",\"replace\":\"《$大小實體$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"feeScheduleDate\",\"replace\":\"《$年費有效日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"feeSchedule\",\"replace\":\"《$已繳交年費年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payPeriod\",\"replace\":\"《$繳交期限$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"surchargeDate\",\"replace\":\"《$補繳期限$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"renewStatus\",\"replace\":\"《$年費確認狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"maintainAttorney\",\"replace\":\"《$年費代理人$》\",\"type\":\"select\",\"category\":\"Attorney\"},{\"field\":\"ptoFee\",\"replace\":\"《$規費原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ptoCurrency\",\"replace\":\"《$規費幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"ptoExchangeRate\",\"replace\":\"《$ptoExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdPtoFee\",\"replace\":\"《$規費台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payTransfer\",\"replace\":\"《$代收代付$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceFee\",\"replace\":\"《$複代服務費原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceCurrency\",\"replace\":\"《$複代服務費幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"serviceExchangeRate\",\"replace\":\"《$serviceExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdServiceFee\",\"replace\":\"《$複代服務費台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payTransfer2\",\"replace\":\"《$代收代付$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyFee\",\"replace\":\"《$本所服務費原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyCurrency\",\"replace\":\"《$本所服務費幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"attorneyExchangeRate\",\"replace\":\"《$attorneyExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdAttorneyFee\",\"replace\":\"《$本所服務費台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherFee\",\"replace\":\"《$其他費用原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherCurrency\",\"replace\":\"《$其他費用幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"otherExchangeRate\",\"replace\":\"《$otherExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdOtherFee\",\"replace\":\"《$其他費用台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"keepMaintain\",\"replace\":\"《$是否續繳年費$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdInvoiceAmount\",\"replace\":\"《$請款台幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"addYear\",\"replace\":\"《$增加年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"giveupReason\",\"replace\":\"《$停止維護原因$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-08 14:15:21','2014-08-08 15:17:02','','LicenseNo','FlowKey'),('RTS20140808.02','99','admin','TrademarkRenewalLog','[{\"field\":\"flowKey\",\"replace\":\"《$商標延展確認單號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"office\",\"replace\":\"《$申請國家$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"trademarkNum\",\"replace\":\"《$註冊號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"fillingDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"client\",\"replace\":\"《$客戶代碼$》\",\"type\":\"select\",\"category\":\"Client\"},{\"field\":\"entity\",\"replace\":\"《$大小實體$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"expiryDateTo\",\"replace\":\"《$有效迄日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"extendTime\",\"replace\":\"《$延展年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payPeriod\",\"replace\":\"《$繳交期限$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"surchargeDate\",\"replace\":\"《$補繳期限$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"renewStatus\",\"replace\":\"《$確認狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"maintainAttorney\",\"replace\":\"《$延展代理人$》\",\"type\":\"select\",\"category\":\"Attorney\"},{\"field\":\"ptoFee\",\"replace\":\"《$規費原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ptoCurrency\",\"replace\":\"《$規費幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"ptoExchangeRate\",\"replace\":\"《$ptoExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdPtoFee\",\"replace\":\"《$規費台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payTransfer\",\"replace\":\"《$代收代付$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceFee\",\"replace\":\"《$服務費(複代理)原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceCurrency\",\"replace\":\"《$服務費(複代理)幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"serviceExchangeRate\",\"replace\":\"《$serviceExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdServiceFee\",\"replace\":\"《$服務費(複代理)台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"payTransfer2\",\"replace\":\"《$代收代付$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyFee\",\"replace\":\"《$代理費原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyCurrency\",\"replace\":\"《$代理費幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"attorneyExchangeRate\",\"replace\":\"《$attorneyExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdAttorneyFee\",\"replace\":\"《$代理費台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherFee\",\"replace\":\"《$其他費用原幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"otherCurrency\",\"replace\":\"《$其他費用幣別/匯率$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"otherExchangeRate\",\"replace\":\"《$otherExchangeRate$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdOtherFee\",\"replace\":\"《$其他費用台幣報價$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"keepMaintain\",\"replace\":\"《$是否延展$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ntdInvoiceAmount\",\"replace\":\"《$請款台幣金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"addYear\",\"replace\":\"《$增加年次$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"giveupReason\",\"replace\":\"《$停止維護原因$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-08 15:51:09','2014-08-08 15:53:11','','TrademarkNum','FlowKey'),('RTS20140808.03','99','admin','Invoice','[{\"field\":\"flowKey\",\"replace\":\"《$請款單單號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyBillNo\",\"replace\":\"《$複代帳單單號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo2\",\"replace\":\"《$案件編號2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalIncludeTaxAmount\",\"replace\":\"《$含稅請款總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalNotIncludeTaxAmount\",\"replace\":\"《$未稅請款總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"amountReceipts\",\"replace\":\"《$預收金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"amountReceivable\",\"replace\":\"《$應收金額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"title2\",\"replace\":\"《$稱謂$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"assignedTo\",\"replace\":\"《$承辦人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseClient\",\"replace\":\"《$申請人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"billingContact\",\"replace\":\"《$請款聯絡人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"internalNo\",\"replace\":\"《$客戶案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"applyNo\",\"replace\":\"《$申請號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"applyDate\",\"replace\":\"《$申請日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"issueDate\",\"replace\":\"《$公告日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"issueNo\",\"replace\":\"《$公告號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientContect\",\"replace\":\"《$案件聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"invoiceStatus\",\"replace\":\"《$請款單狀態$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"client\",\"replace\":\"《$客戶代碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"clientName\",\"replace\":\"《$客戶名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyTitle\",\"replace\":\"《$單據抬頭$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"invoiceTitle\",\"replace\":\"《$請款單抬頭$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalTax\",\"replace\":\"《$營業稅5%$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalTax2\",\"replace\":\"《$執行業務所得10%$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"totalWriteOffAmount\",\"replace\":\"《$已沖銷總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"title\",\"replace\":\"《$案件名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseNo\",\"replace\":\"《$案件編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"office\",\"replace\":\"《$申請國家$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"subType\",\"replace\":\"《$案件類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"matter\",\"replace\":\"《$案件程序$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"invoiceNo\",\"replace\":\"《$請款編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"inCharge\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"voucherDate\",\"replace\":\"《$請款日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"note\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"taskDescription\",\"replace\":\"《$請款項目說明$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceFeeDeductTTax2\",\"replace\":\"《$本所服務費台幣扣繳後總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"taskCreator\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"trademarkClassification\",\"replace\":\"《$商標分類$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"registerNo\",\"replace\":\"《$登記號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"registeredNo\",\"replace\":\"《$統一編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"invoiceNumber\",\"replace\":\"《$發票號碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"receiptNumber\",\"replace\":\"《$收據號碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"independentClaim\",\"replace\":\"《$獨立項數量$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"dependentClaim\",\"replace\":\"《$附屬項數量$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"govFeeAmount\",\"replace\":\"《$官費總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"serviceFeeAmount\",\"replace\":\"《$本所服務費總額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorneyFee\",\"replace\":\"《$複代服務費總額$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-08 16:39:46','2014-08-08 16:53:41','','TaskDescription','InvoiceNo'),('RTS20140811.01','99','admin','Client','[{\"field\":\"flowKey\",\"replace\":\"《$客戶代碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"attorney\",\"replace\":\"《$事務所委案$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"zip3\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"zip4\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tel1ExNo\",\"replace\":\"《$分機$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tel2ExNo\",\"replace\":\"《$分機$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"billingContactEmail\",\"replace\":\"《$請款聯絡人E-Mail$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"email1\",\"replace\":\"《$E-Mail1$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tel\",\"replace\":\"《$電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"zip\",\"replace\":\"《$zip$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"billingContact\",\"replace\":\"《$請款聯絡人$》\",\"type\":\"select\",\"category\":\"Applicant\"},{\"field\":\"sponsorAssistantName\",\"replace\":\"《$業務助理$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"sponsorAssistant\",\"replace\":\"《$業務助理$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"caseAD\",\"replace\":\"《$負責程序$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"nationality\",\"replace\":\"《$國家/國籍$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"contactRecord\",\"replace\":\"《$聯絡記錄$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"entity\",\"replace\":\"《$大小實體$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"companyName\",\"replace\":\"《$客戶名稱(主)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"englishCompanyName\",\"replace\":\"《$客戶名稱(副)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"inCharge\",\"replace\":\"《$負責人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"tel1\",\"replace\":\"《$電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"email\",\"replace\":\"《$E-Mail$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"webSite\",\"replace\":\"《$Web Site$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"zip1\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"zip2\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"address1\",\"replace\":\"《$登記地址$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"englishAddress1\",\"replace\":\"《$聯絡地址二$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"address2\",\"replace\":\"《$聯絡地址一$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"englishAddress2\",\"replace\":\"《$聯絡地址三$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"category\",\"replace\":\"《$類型$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"industry\",\"replace\":\"《$行業別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"credit\",\"replace\":\"《$信用等級$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"revenue\",\"replace\":\"《$年營業額$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"sponsor\",\"replace\":\"《$業務人員$》\",\"type\":\"select\",\"category\":\"Employee\"},{\"field\":\"payment\",\"replace\":\"《$付款條件$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"accounting\",\"replace\":\"《$會計$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"accountingTel\",\"replace\":\"《$會計電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"accountingFax\",\"replace\":\"《$會計傳真$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"identity\",\"replace\":\"《$身分類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"guanAccountDate\",\"replace\":\"《$關帳日$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"invoiceTitle1\",\"replace\":\"《$發票抬頭$》\",\"type\":\"select\",\"category\":\"InvTitle\"},{\"field\":\"accountingMissTel\",\"replace\":\"《$請款聯絡人電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"accountingMissFax\",\"replace\":\"《$請款聯絡人傳真$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"groupName\",\"replace\":\"《$母公司或集團名稱$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-08-11 09:46:29','2016-03-06 20:27:36','','CompanyName','FlowKey');
/*!40000 ALTER TABLE `reporttablesetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporttablesetting_default`
--

DROP TABLE IF EXISTS `reporttablesetting_default`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporttablesetting_default` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `SettingTableName` varchar(50) DEFAULT NULL,
  `SettingField` text,
  `Language` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `ModifyTime` varchar(20) DEFAULT NULL,
  `AddtionFieldSetting` text,
  `ShowNumberField` varchar(100) DEFAULT NULL,
  `ShowNameField` varchar(100) DEFAULT NULL,
  `DataTableName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporttablesetting_default`
--

LOCK TABLES `reporttablesetting_default` WRITE;
/*!40000 ALTER TABLE `reporttablesetting_default` DISABLE KEYS */;
INSERT INTO `reporttablesetting_default` VALUES ('RTS20141013.02','99','admin','TrademarkCase',NULL,'chinese','2014-10-13 10:58:02','2014-10-13 10:58:02',NULL,NULL,NULL,NULL),('RTS20141013.03','99','admin','LegalCase',NULL,'chinese','2014-10-13 10:58:03','2014-10-13 10:58:03',NULL,NULL,NULL,NULL),('RTS20141013.04','99','admin','CopyrightCase',NULL,'chinese','2014-10-13 10:58:04','2014-10-13 10:58:04',NULL,NULL,NULL,NULL),('RTS20141013.05','99','admin','RenewalLog',NULL,'chinese','2014-10-13 10:58:05','2014-10-13 10:58:05',NULL,NULL,NULL,NULL),('RTS20141013.06','99','admin','TrademarkRenewalLog',NULL,'chinese','2014-10-13 10:58:06','2014-10-13 10:58:06',NULL,NULL,NULL,NULL),('RTS20141013.07','99','admin','Invoice',NULL,'chinese','2014-10-13 10:58:07','2014-10-13 10:58:07',NULL,NULL,NULL,NULL),('RTS20141013.08','99','admin','Client',NULL,'chinese','2014-10-13 10:58:08','2014-10-13 10:58:08',NULL,NULL,NULL,NULL),('RTS20141013.09','99','admin','PatentCase','[{\"field\":\"DocumentKind\",\"replace\":\"《$收發類型$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentUnit\",\"replace\":\"《$對象類別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentNo\",\"replace\":\"《$收發文號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentTarget\",\"replace\":\"《$對象$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentDate\",\"replace\":\"《$收發文日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"DeadlineDate\",\"replace\":\"《$法定期限$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"DocumentName\",\"replace\":\"《$事由$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentProcess\",\"replace\":\"《$案件程序$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"CcSendType\",\"replace\":\"《$副本寄送方式$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"CcSendDate\",\"replace\":\"《$副本寄送日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"MailNo\",\"replace\":\"《$郵件號碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Receiver\",\"replace\":\"《$收件人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Remark\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"AttachmentName\",\"replace\":\"《$附件名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocumentUrl\",\"replace\":\"《$附件歸檔$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Contractor\",\"replace\":\"《$所內承辦人$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 15:34:01','2014-10-13 15:34:01',NULL,'2','收發文','patentdocument'),('RTS20141013.10','99','admin','PatentCase','[{\"field\":\"Matter\",\"replace\":\"《$案件程序$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"TaskCreator\",\"replace\":\"《$業務主管$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"TaskDescription\",\"replace\":\"《$管制項目$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"AssignedTo\",\"replace\":\"《$承辦人員$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Agent\",\"replace\":\"《$代理人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"StartDate2\",\"replace\":\"《$起始日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"AttorneyDueDate\",\"replace\":\"《$事務所到期日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"LegalDueDate\",\"replace\":\"《$法定到期日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"AlertDate\",\"replace\":\"《$提醒日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"NotifyTarget\",\"replace\":\"《$通知對象$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ToDosStatus\",\"replace\":\"《$狀態$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"FinishedDate\",\"replace\":\"《$完成日期$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"AssignStatus\",\"replace\":\"《$指派狀態$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Points\",\"replace\":\"《$點數$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"BonusStatus\",\"replace\":\"《$獎金狀態$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"AttachmentName\",\"replace\":\"《$附件名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Appendix\",\"replace\":\"《$附件$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 18:10:01','2014-10-13 18:10:01',NULL,'3','待辦事項','todos'),('RTS20141013.11','99','admin','PatentCase','[{\"field\":\"Client\",\"replace\":\"《$關聯客戶$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Company\",\"replace\":\"《$公司別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Department\",\"replace\":\"《$部門別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Names\",\"replace\":\"《$申請人名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"EnglishNames\",\"replace\":\"《$申請人名稱(英)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"IdType\",\"replace\":\"《$身分類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"Nationality\",\"replace\":\"《$國籍$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"ApplicantKind\",\"replace\":\"《$屬性$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"Title\",\"replace\":\"《$稱謂$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"IdNo\",\"replace\":\"《$統一編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Birthday\",\"replace\":\"《$出生年月日$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"CompanyReq\",\"replace\":\"《$代表人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"EnglishCompanyReq\",\"replace\":\"《$代表人(英)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"TelNo\",\"replace\":\"《$電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Fax\",\"replace\":\"《$傳真$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Mobile\",\"replace\":\"《$行動電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"WebSite\",\"replace\":\"《$Web Site$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Email\",\"replace\":\"《$E-Mail$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Email2\",\"replace\":\"《$E-Mail2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Skype\",\"replace\":\"《$Skype$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Msn\",\"replace\":\"《$MSN$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Zip\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Address\",\"replace\":\"《$登記地址$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Zip2\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Address2\",\"replace\":\"《$聯絡地址$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"EnglishAddress\",\"replace\":\"《$登記地址(英)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Appendix\",\"replace\":\"《$附件$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 18:21:01','2014-10-13 18:21:01',NULL,'4','申請人','patentapplicant'),('RTS20141013.12','99','admin','PatentCase','[{\"field\":\"Client\",\"replace\":\"《$關聯客戶$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Company\",\"replace\":\"《$公司別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Department\",\"replace\":\"《$部門別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Names\",\"replace\":\"《$發明人名稱$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"EnglishNames\",\"replace\":\"《$發明人名稱(英)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"IdType\",\"replace\":\"《$身分類別$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"Nationality\",\"replace\":\"《$國籍$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"ApplicantKind\",\"replace\":\"《$屬性$》\",\"type\":\"select\",\"category\":\"Category\"},{\"field\":\"Title\",\"replace\":\"《$稱謂$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"IdNo\",\"replace\":\"《$統一編號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Birthday\",\"replace\":\"《$出生年月日$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"TelNo\",\"replace\":\"《$電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Fax\",\"replace\":\"《$傳真$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Mobile\",\"replace\":\"《$行動電話$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"WebSite\",\"replace\":\"《$Web Site$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Email\",\"replace\":\"《$E-Mail$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Email2\",\"replace\":\"《$E-Mail2$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Skype\",\"replace\":\"《$Skype$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Msn\",\"replace\":\"《$MSN$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Zip\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Address\",\"replace\":\"《$登記地址$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Zip2\",\"replace\":\"《$郵遞區號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Address2\",\"replace\":\"《$聯絡地址$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"EnglishAddress\",\"replace\":\"《$登記地址(英)$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Appendix\",\"replace\":\"《$附件$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 18:21:02','2014-10-13 18:21:02',NULL,'5','發明人','patentinventor'),('RTS20141013.13','99','admin','PatentCase','[{\"field\":\"Country\",\"replace\":\"《$優先權國家$》\",\"type\":\"select\",\"category\":\"\"},{\"field\":\"PriorityDate\",\"replace\":\"《$優先權日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"ApplyNo\",\"replace\":\"《$優先權號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"CaseNo\",\"replace\":\"《$內部案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Document\",\"replace\":\"《$證明文件$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 18:21:03','2014-10-13 18:21:03',NULL,'6','優先權','patentpriority'),('RTS20141013.14','99','admin','PatentCase','[{\"field\":\"CitationType\",\"replace\":\"《$引證資料類別$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"RelateDocNo\",\"replace\":\"《$引證相關收發文號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"PublishNo\",\"replace\":\"《$公開號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"PublishDate\",\"replace\":\"《$公開日$》\",\"type\":\"date\",\"category\":\"\"},{\"field\":\"PatenteeApplicant\",\"replace\":\"《$專利權人／申請人$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"DocPage\",\"replace\":\"《$相關段落或圖表所在行頁數$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"ExaminerInitial\",\"replace\":\"《$為審查官所提出$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"InternalCaseNo\",\"replace\":\"《$事務所內部案號$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"KindCode\",\"replace\":\"《$類別碼$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"UploadFiles\",\"replace\":\"《$上傳文件$》\",\"type\":\"text\",\"category\":\"\"},{\"field\":\"Memo\",\"replace\":\"《$備註$》\",\"type\":\"text\",\"category\":\"\"}]','chinese','2014-10-13 18:21:04','2014-10-13 18:21:04',NULL,'7','引證資料','patentcitation');
/*!40000 ALTER TABLE `reporttablesetting_default` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruledefine`
--

DROP TABLE IF EXISTS `ruledefine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruledefine` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `FullLength` int(11) DEFAULT NULL,
  `UseFor` varchar(50) DEFAULT NULL,
  `WeekLength_1` int(11) DEFAULT NULL,
  `PreBonus_1` int(11) DEFAULT NULL,
  `AnotherBonus_1` int(11) DEFAULT NULL,
  `WeekLength_2` int(11) DEFAULT NULL,
  `PreBonus_2` int(11) DEFAULT NULL,
  `AnotherBonus_2` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruledefine`
--

LOCK TABLES `ruledefine` WRITE;
/*!40000 ALTER TABLE `ruledefine` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruledefine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruledefine_detail`
--

DROP TABLE IF EXISTS `ruledefine_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruledefine_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `InFlag` char(1) DEFAULT NULL,
  `FullLength` int(11) DEFAULT NULL,
  `PreBonus` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruledefine_detail`
--

LOCK TABLES `ruledefine_detail` WRITE;
/*!40000 ALTER TABLE `ruledefine_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruledefine_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorder`
--

DROP TABLE IF EXISTS `salesorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorder` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `SoNo` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `ClientName` varchar(100) DEFAULT NULL,
  `ServiceProjectCode` varchar(100) DEFAULT NULL,
  `OriginalTitle` varchar(500) DEFAULT NULL,
  `InCharge` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `QuotationDate` varchar(10) DEFAULT NULL,
  `CreateDate` varchar(10) DEFAULT NULL,
  `RelatedCaseNo` varchar(100) DEFAULT NULL,
  `CaseKind` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(1000) DEFAULT NULL,
  `PatentType` varchar(1000) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `AttorneyTitle` varchar(50) DEFAULT NULL,
  `SoStatus` varchar(50) DEFAULT NULL,
  `AttorneyCase` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `BillingContact` varchar(200) DEFAULT NULL,
  `InvoiceTitle1` varchar(500) DEFAULT NULL,
  `RegisteredNo` varchar(50) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `NewCaseOthers` varchar(50) DEFAULT NULL,
  `OldCaseOthers` varchar(50) DEFAULT NULL,
  `NewCase` varchar(50) DEFAULT NULL,
  `OldCase` varchar(50) DEFAULT NULL,
  `Paper1` varchar(50) DEFAULT NULL,
  `ElectronicFiles1` varchar(50) DEFAULT NULL,
  `Files1` varchar(50) DEFAULT NULL,
  `Files1Other` varchar(500) DEFAULT NULL,
  `Paper2` varchar(50) DEFAULT NULL,
  `ElectronicFiles2` varchar(50) DEFAULT NULL,
  `Files2` varchar(50) DEFAULT NULL,
  `Files2Other` varchar(500) DEFAULT NULL,
  `BillSendDoc41` varchar(50) DEFAULT NULL,
  `PriorityCount` int(8) DEFAULT '0',
  `ClientContect` varchar(50) DEFAULT NULL,
  `BillingInfo101` varchar(50) DEFAULT NULL,
  `BillingInfo102` varchar(50) DEFAULT NULL,
  `BillingInfo103` varchar(50) DEFAULT NULL,
  `BillingInfo104` varchar(50) DEFAULT NULL,
  `PriorityRight` varchar(50) DEFAULT NULL,
  `TransWordNum` int(8) DEFAULT '0',
  `PriorityDate1` varchar(50) DEFAULT NULL,
  `PRCountry` varchar(50) DEFAULT NULL,
  `PriorityDate2` varchar(50) DEFAULT NULL,
  `PriorityNo1` varchar(50) DEFAULT NULL,
  `PriorityNo2` varchar(50) DEFAULT NULL,
  `Novelty` varchar(50) DEFAULT NULL,
  `Published` varchar(50) DEFAULT NULL,
  `NotYetPub` varchar(50) DEFAULT NULL,
  `FuturePuDate` varchar(50) DEFAULT NULL,
  `ClaimNovelty` varchar(50) DEFAULT NULL,
  `Dateline` varchar(50) DEFAULT NULL,
  `SignedDoc` varchar(50) DEFAULT NULL,
  `Others1` varchar(50) DEFAULT NULL,
  `SugAssignTo` varchar(50) DEFAULT NULL,
  `ApplicantAdd` varchar(500) DEFAULT NULL,
  `ContactAdd` varchar(500) DEFAULT NULL,
  `InvContactAdd` varchar(500) DEFAULT NULL,
  `BillAdd` varchar(500) DEFAULT NULL,
  `Others1Memo` varchar(500) DEFAULT NULL,
  `Others2Memo` varchar(500) DEFAULT NULL,
  `BillSendTo` varchar(500) DEFAULT NULL,
  `InvoiceItem` varchar(50) DEFAULT NULL,
  `FilingFee` varchar(50) DEFAULT NULL,
  `ExamFee` varchar(50) DEFAULT NULL,
  `PRFee` varchar(50) DEFAULT NULL,
  `ExPageFee` varchar(50) DEFAULT NULL,
  `TransFee` varchar(50) DEFAULT NULL,
  `NatPhaFee` varchar(50) DEFAULT NULL,
  `MiscFee` varchar(50) DEFAULT NULL,
  `Other2` varchar(50) DEFAULT NULL,
  `BillSendDoc1` varchar(50) DEFAULT NULL,
  `BillSendDoc2` varchar(50) DEFAULT NULL,
  `BillSendDoc3` varchar(50) DEFAULT NULL,
  `BillSendDoc4` varchar(50) DEFAULT NULL,
  `BillSendDoc5` varchar(50) DEFAULT NULL,
  `BillSendDoc6` varchar(50) DEFAULT NULL,
  `BillSendDoc7` varchar(50) DEFAULT NULL,
  `BillSendDoc7Doc` varchar(50) DEFAULT NULL,
  `ShowItem` varchar(50) DEFAULT NULL,
  `BillSendDoc7Num` int(8) DEFAULT '0',
  `RenewalLogKey` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorder`
--

LOCK TABLES `salesorder` WRITE;
/*!40000 ALTER TABLE `salesorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorder_detail`
--

DROP TABLE IF EXISTS `salesorder_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorder_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `TodosTitle` varchar(600) DEFAULT NULL,
  `TaskDescription` varchar(600) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` float(10,3) DEFAULT NULL,
  `TaxType` varchar(50) DEFAULT NULL,
  `TaxInclude` varchar(1) DEFAULT NULL,
  `TaxAmount` float(16,2) DEFAULT '0.00',
  `NotIncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `IncludeTaxAmount` float(16,2) DEFAULT '0.00',
  `ExchangeRate` float(10,3) DEFAULT NULL,
  `TwdAmount` float(16,2) DEFAULT '0.00',
  `SoStatus` varchar(50) DEFAULT NULL,
  `MatterName` varchar(50) DEFAULT NULL,
  `QdParentId` varchar(100) NOT NULL,
  `CaseKind` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(50) DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Remark` varchar(150) DEFAULT NULL,
  `UnitPrice` double(10,2) DEFAULT '0.00',
  `Quantity` int(5) DEFAULT '1',
  `Unit` varchar(50) DEFAULT NULL,
  `ChineseDescription` varchar(600) DEFAULT NULL,
  `IsPayment` varchar(1) DEFAULT NULL,
  `IsCharge` varchar(1) DEFAULT NULL,
  `PrintFlag` varchar(1) DEFAULT NULL,
  `DetailOrder` int(11) DEFAULT '0',
  `EnableStatus` varchar(50) DEFAULT NULL,
  `Points` float(10,3) DEFAULT NULL,
  `Accountable` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorder_detail`
--

LOCK TABLES `salesorder_detail` WRITE;
/*!40000 ALTER TABLE `salesorder_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorder_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedulemanager`
--

DROP TABLE IF EXISTS `schedulemanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedulemanager` (
  `KeyValue` varchar(20) NOT NULL,
  `GroupName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`KeyValue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulemanager`
--

LOCK TABLES `schedulemanager` WRITE;
/*!40000 ALTER TABLE `schedulemanager` DISABLE KEYS */;
INSERT INTO `schedulemanager` VALUES ('Schedule.001','系統排程');
/*!40000 ALTER TABLE `schedulemanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedulemanager_detail`
--

DROP TABLE IF EXISTS `schedulemanager_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedulemanager_detail` (
  `KeyValue` varchar(20) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ScheduleName` varchar(100) DEFAULT NULL,
  `ScheduleApp` varchar(100) DEFAULT NULL,
  `ScheduleInitDate` varchar(20) DEFAULT NULL,
  `ScheduleFinalDate` varchar(20) DEFAULT NULL,
  `ScheduleRate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`KeyValue`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulemanager_detail`
--

LOCK TABLES `schedulemanager_detail` WRITE;
/*!40000 ALTER TABLE `schedulemanager_detail` DISABLE KEYS */;
INSERT INTO `schedulemanager_detail` VALUES ('Schedule.001',1,'郵件伺服器','deepspot.mail.MailTask','2013-10-16 09:00:00','2028-10-31 09:00:00','3600'),('Schedule.001',2,'代辦事項提醒信','deepspot.mail.ToDosAlertMailTask','2013-10-16 09:00:00','2027-10-31 09:00:00','28800'),('Schedule.001',3,'代辦事項指派信','deepspot.mail.CheckAssignToDosMailTask','2013-10-16 09:00:00','2030-10-31 09:00:00','21600');
/*!40000 ALTER TABLE `schedulemanager_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendmail_log`
--

DROP TABLE IF EXISTS `sendmail_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendmail_log` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `mail_time` varchar(20) DEFAULT NULL,
  `mail_title` varchar(5000) DEFAULT NULL,
  `mail_content` varchar(5000) DEFAULT NULL,
  `matilto` varchar(5000) DEFAULT NULL,
  `exception` text,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendmail_log`
--

LOCK TABLES `sendmail_log` WRITE;
/*!40000 ALTER TABLE `sendmail_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sendmail_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceproject`
--

DROP TABLE IF EXISTS `serviceproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceproject` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `SerialCaseID` varchar(50) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `ServiceTypeMain` varchar(50) NOT NULL,
  `ServiceTypeSub` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `ProjectStartDate` varchar(50) NOT NULL,
  `DueDate` varchar(50) NOT NULL,
  `ProjectEndDate` varchar(50) NOT NULL,
  `FileName1` varchar(50) NOT NULL,
  `FileUrl1` varchar(100) NOT NULL,
  `FileName2` varchar(50) NOT NULL,
  `FileUrl2` varchar(100) NOT NULL,
  `FileName3` varchar(50) NOT NULL,
  `FileUrl3` varchar(100) NOT NULL,
  `Client` varchar(50) NOT NULL,
  `ClientName` varchar(50) NOT NULL,
  `ProjectMgr` varchar(50) NOT NULL,
  `ClientContect` varchar(50) NOT NULL,
  `ServiceHour` float(16,1) DEFAULT '0.0',
  `MonthDeductibleHourMaximum` float(16,1) DEFAULT '0.0',
  `DeliverdServiceHour` float(16,1) DEFAULT '0.0',
  `TwdHourlyCharge` int(16) DEFAULT '0',
  `ConfirmedDate` varchar(50) DEFAULT NULL,
  `PaymentKind` varchar(50) DEFAULT NULL,
  `RateDiscount` int(12) DEFAULT '0',
  `TotalAnnHr` double(12,2) DEFAULT '0.00',
  `ContracM` int(12) DEFAULT '0',
  `PlusM` int(12) DEFAULT '0',
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceproject`
--

LOCK TABLES `serviceproject` WRITE;
/*!40000 ALTER TABLE `serviceproject` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceprojectdocument`
--

DROP TABLE IF EXISTS `serviceprojectdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceprojectdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `DocumentType` varchar(50) NOT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) NOT NULL,
  `DocumentNo` varchar(50) NOT NULL,
  `DocumentKind` varchar(50) NOT NULL,
  `DocumentDate` varchar(10) NOT NULL,
  `DocumentTarget` varchar(50) NOT NULL,
  `DocumentProcess` varchar(50) NOT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(100) DEFAULT NULL,
  `AttachmentName2` varchar(100) DEFAULT NULL,
  `AttachmentName3` varchar(100) DEFAULT NULL,
  `AttachmentName4` varchar(100) DEFAULT NULL,
  `AttachmentName5` varchar(100) DEFAULT NULL,
  `AttachmentName6` varchar(100) DEFAULT NULL,
  `AttachmentName7` varchar(100) DEFAULT NULL,
  `AttachmentName8` varchar(100) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceprojectdocument`
--

LOCK TABLES `serviceprojectdocument` WRITE;
/*!40000 ALTER TABLE `serviceprojectdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceprojectdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceprojectfeerecord`
--

DROP TABLE IF EXISTS `serviceprojectfeerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceprojectfeerecord` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `DueDate` varchar(10) DEFAULT NULL,
  `MonthDeductibleHourMaximum` float(16,1) DEFAULT '0.0',
  `TwdHourlyCharge` int(8) DEFAULT '0',
  `DeliverdServiceHour` float(16,1) DEFAULT '0.0',
  `DeductibleHourBalance` float(16,1) DEFAULT '0.0',
  `ProjectStartDate` varchar(50) DEFAULT NULL,
  `ProjectEndDate` varchar(50) DEFAULT NULL,
  `ServiceHour` varchar(50) DEFAULT NULL,
  `ConfirmedDate` varchar(50) DEFAULT NULL,
  `PaymentKind` varchar(50) DEFAULT NULL,
  `RateDiscount` int(12) DEFAULT '0',
  `ContracM` int(12) DEFAULT '0',
  `PlusM` int(12) DEFAULT '0',
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceprojectfeerecord`
--

LOCK TABLES `serviceprojectfeerecord` WRITE;
/*!40000 ALTER TABLE `serviceprojectfeerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceprojectfeerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceprojectmember`
--

DROP TABLE IF EXISTS `serviceprojectmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceprojectmember` (
  `FlowKey` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `Employee` varchar(50) NOT NULL,
  `EmployeeTitle` varchar(50) NOT NULL,
  `HourlyRate` varchar(10) NOT NULL,
  `Currency` varchar(50) NOT NULL,
  `Command` varchar(200) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceprojectmember`
--

LOCK TABLES `serviceprojectmember` WRITE;
/*!40000 ALTER TABLE `serviceprojectmember` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceprojectmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceprojectopponent`
--

DROP TABLE IF EXISTS `serviceprojectopponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceprojectopponent` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `OpponentOrder` varchar(50) DEFAULT NULL,
  `OpponentId` varchar(50) DEFAULT NULL,
  `OpponentName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceprojectopponent`
--

LOCK TABLES `serviceprojectopponent` WRITE;
/*!40000 ALTER TABLE `serviceprojectopponent` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceprojectopponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signedlog`
--

DROP TABLE IF EXISTS `signedlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signedlog` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `LastSignedKey` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `OrderNo` varchar(50) NOT NULL,
  `Signer` varchar(50) DEFAULT NULL,
  `SignDate` varchar(20) DEFAULT NULL,
  `SignStatus` varchar(50) DEFAULT NULL,
  `Opinion` varchar(1000) DEFAULT NULL,
  `Attach` varchar(100) DEFAULT NULL,
  `FinishSign` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signedlog`
--

LOCK TABLES `signedlog` WRITE;
/*!40000 ALTER TABLE `signedlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `signedlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signedmanage`
--

DROP TABLE IF EXISTS `signedmanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signedmanage` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `SignedType` varchar(50) NOT NULL,
  `SignedStatus` varchar(50) NOT NULL,
  `CaseFlowKey` varchar(50) NOT NULL,
  `CaseType` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `CaseTitle` varchar(500) NOT NULL,
  `Memo` varchar(500) NOT NULL,
  `SubmitDate` varchar(50) NOT NULL,
  `SignedDate` varchar(50) NOT NULL,
  `NextSigned` varchar(50) NOT NULL,
  `FirstSender` varchar(50) DEFAULT NULL,
  `FinishDate` varchar(50) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signedmanage`
--

LOCK TABLES `signedmanage` WRITE;
/*!40000 ALTER TABLE `signedmanage` DISABLE KEYS */;
/*!40000 ALTER TABLE `signedmanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sitemember`
--

DROP TABLE IF EXISTS `sitemember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sitemember` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `MemberType` varchar(20) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Alias` varchar(50) DEFAULT NULL,
  `UnitName` varchar(50) DEFAULT NULL,
  `IdCardNo` varchar(12) DEFAULT NULL,
  `Birthday` varchar(10) DEFAULT NULL,
  `PhotoUrl` varchar(100) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Mobile` varchar(20) DEFAULT NULL,
  `Tel` varchar(20) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Account` varchar(12) DEFAULT NULL,
  `Password` varchar(12) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sitemember`
--

LOCK TABLES `sitemember` WRITE;
/*!40000 ALTER TABLE `sitemember` DISABLE KEYS */;
/*!40000 ALTER TABLE `sitemember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sitemenu`
--

DROP TABLE IF EXISTS `sitemenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sitemenu` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Subject` varchar(100) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `ParentKey` varchar(50) DEFAULT NULL,
  `PageUrl` varchar(100) DEFAULT NULL,
  `Display` char(1) DEFAULT NULL,
  `Target` varchar(20) DEFAULT NULL,
  `MenuGroup` varchar(50) DEFAULT NULL,
  `SortNo` varchar(10) DEFAULT NULL,
  `ShowPhoto` char(1) DEFAULT NULL,
  `PhotoUrl` varchar(100) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `Bgcolor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sitemenu`
--

LOCK TABLES `sitemenu` WRITE;
/*!40000 ALTER TABLE `sitemenu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sitemenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sitenews`
--

DROP TABLE IF EXISTS `sitenews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sitenews` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `PubDate` varchar(10) DEFAULT NULL,
  `PubUnit` varchar(50) DEFAULT NULL,
  `Appendix` varchar(100) DEFAULT NULL,
  `EffectFlag` char(1) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sitenews`
--

LOCK TABLES `sitenews` WRITE;
/*!40000 ALTER TABLE `sitenews` DISABLE KEYS */;
/*!40000 ALTER TABLE `sitenews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `SrcApplicant` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `SoftNo` varchar(100) DEFAULT NULL,
  `SoftType` varchar(50) DEFAULT NULL,
  `SoftNames` varchar(200) DEFAULT NULL,
  `Edition` varchar(50) DEFAULT NULL,
  `SerialNo` varchar(100) DEFAULT NULL,
  `Capability` varchar(200) DEFAULT NULL,
  `Version` varchar(50) DEFAULT NULL,
  `UserQty` int(11) DEFAULT NULL,
  `Environment` varchar(200) DEFAULT NULL,
  `SoftQty` int(11) DEFAULT NULL,
  `Source` varchar(50) DEFAULT NULL,
  `SrcUnit` varchar(100) DEFAULT NULL,
  `SoftBody` varchar(50) DEFAULT NULL,
  `BodyQty` int(11) DEFAULT NULL,
  `DocMemo` varchar(200) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Rent` int(11) DEFAULT NULL,
  `UsingDate` varchar(10) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `VoucherNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software`
--

LOCK TABLES `software` WRITE;
/*!40000 ALTER TABLE `software` DISABLE KEYS */;
/*!40000 ALTER TABLE `software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sponsor` (
  `FlowKey` varchar(50) NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Emp_id` varchar(50) DEFAULT NULL,
  `Memo` varchar(100) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standardtask`
--

DROP TABLE IF EXISTS `standardtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standardtask` (
  `FlowKey` varchar(50) NOT NULL,
  `BaseDate` varchar(8) DEFAULT NULL,
  `LegalDueDate1` varchar(8) DEFAULT NULL,
  `MatterName` varchar(50) DEFAULT NULL,
  `PatentOffice` varchar(1000) DEFAULT NULL,
  `PatentType` varchar(1000) DEFAULT NULL,
  `TaskDescription` varchar(600) DEFAULT NULL,
  `TodosTitle` varchar(600) DEFAULT NULL,
  `RemindDate` varchar(8) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `EnableStatus` varchar(50) DEFAULT NULL,
  `CaseKind` varchar(50) DEFAULT NULL,
  `IsCharge` varchar(1) DEFAULT NULL,
  `IsPayment` varchar(1) DEFAULT NULL,
  `Points` int(11) DEFAULT '0',
  `AccountTitle` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT '0.00',
  `ExchangeRate` float(10,3) DEFAULT NULL,
  `TwdAmount` int(10) DEFAULT '0',
  `MatterConfigKey` varchar(50) DEFAULT NULL,
  `Accountable` varchar(1) DEFAULT NULL,
  `LegalDueDate1Month` varchar(8) DEFAULT NULL,
  `RemindDateMonth` varchar(8) DEFAULT NULL,
  `IsPoints` varchar(1) DEFAULT 'N',
  `TaskType` varchar(1) NOT NULL DEFAULT 'T',
  `AssignStatus` varchar(50) DEFAULT NULL,
  `ChineseDescription` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standardtask`
--

LOCK TABLES `standardtask` WRITE;
/*!40000 ALTER TABLE `standardtask` DISABLE KEYS */;
INSERT INTO `standardtask` VALUES ('P-TWP01-005','BD01','','TWP01','TW, ','PN01, ','claim客戶看稿','claim客戶看稿','21','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS01',''),('P-TWP01-004','BD01','','TWP01','TW, ','PN01, ','客戶看稿','客戶看稿','21','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS01',''),('P-TWP01-003','BD01','','TWP01','TW, ','PN01, ','完成初稿','完成初稿','14','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS01',''),('P-TWP01-002','BD01','','TWP01','TW, ','PN01, ','確認委託','確認委託','21','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS01',''),('P-TWP01-016-1','','','TWP01','TW, ','PN01, ','新案申請','新案申請','','test','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',0.00,1.000,0,'','Y','','','','Q','',''),('P-TWP01-006-3','','','TWP01','TW, ','PN01, ','台灣發明申請','台灣發明申請','','PWC','PWC','ES02','STC01','Y','',0,'AccountTitle03','NTD',20000.00,1.000,20000,'','','','','','Q','',''),('P-TWP01-006-1','','','TWP01','TW, ','PN01, ','台灣發明申請','台灣發明申請','','PWC','PWC','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('T-TM01-001','TBD02','','TM01','TW, ','TT01, TT02, TT03, TT04, ','商標製圖','商標製圖','','PWC','PWC','ES02','STC02','','',0,'','',0.00,1.000,0,'','','','30','','T','AS00',''),('T-TM02-001','TBD01','','TM02','TW, ','TT01, TT02, TT03, TT04, ','商標領整通知','商標領整通知','','PWC','PWC','ES02','STC02','','',0,'','',0.00,1.000,0,'','','30','20','','T','AS00',''),('P-TWP01-007-3','','','TWP01','TW, ','PN01, ','台灣專利案申請','台灣專利案申請','','HuST','HuST','ES02','STC01','Y','',0,'AccountTitle03','NTD',18000.00,1.000,18000,'','','','','','Q','',''),('P-TWP01-007-1','','','TWP01','TW, ','PN01, ','台灣專利案申請','台灣專利案申請','','HuST','HuST','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('T-TM01-002-3','','','TM01','TW, ','TT01, TT02, TT03, TT04, ','台灣商標申請','台灣商標申請','','PWC','PWC','ES02','STC02','Y','',0,'AccountTitle03','NTD',8000.00,1.000,8000,'','','','','','Q','',''),('T-TM01-002-1','','','TM01','TW, ','TT01, TT02, TT03, TT04, ','台灣商標申請','台灣商標申請','','PWC','PWC','ES02','STC02','Y','',0,'AccountTitle01','NTD',1000.00,1.000,1000,'','','','','','Q','',''),('001','','','TM3','AR, ','TT01, ','','','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',11000.00,1.000,11000,'','','','','','Q','',''),('002','','','TM1','TW, ','TT01, ','中華民國商標申請','中華民國商標申請','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('T-TM1-001-1','','','TM1','TW, ','TT01, ','中華民國商標申請','中華民國商標申請','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('T-TM1-001-3','','','TM1','TW, ','TT01, ','中華民國商標申請','中華民國商標申請','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',4600.00,1.000,4600,'','','','','','Q','',''),('T-TM4-001-1','','','TM4','TW, ','TT01, ','中華民國全期註冊費','中華民國全期註冊費','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('T-TM4-001-3','','','TM4','TW, ','TT01, ','中華民國全期註冊費','中華民國全期註冊費','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',1500.00,1.000,1500,'','','','','','Q','',''),('T-TUSTT01PA100-001-1','','','TUSTT01PA100','US, ','TT01, ','美國商標延展10年','美國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle01','USD',500.00,30.235,15117,'','','','','','Q','',''),('T-TCNTT01PA100-001-1','','','TCNTT01PA100','CN, ','TT01, ','中國商標延展10年','中國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle01','RMB',2000.00,6.129,12257,'','','','','','Q','',''),('T-TM7-001-1','','','TM7','TW, ','TT01, ','中華民國異議答辯','中華民國異議答辯','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','',0.00,1.000,0,'','','','','','Q','',''),('T-TM7-001-3','','','TM7','TW, ','TT01, ','中華民國異議答辯','中華民國異議答辯','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','',12000.00,1.000,12000,'','','','','','Q','',''),('T-TM8-001-1','','','TM8','TW, ','TT01, ','中華民國移轉','中華民國移轉','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('T-TM8-001-3','','','TM8','TW, ','TT01, ','中華民國移轉','中華民國移轉','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',4000.00,1.000,4000,'','','','','','Q','',''),('T-TM10-001-1','','','TM10','TW, ','TT01, ','中華民國陳述意見書','中華民國陳述意見書','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','',0.00,1.000,0,'','','','','','Q','',''),('T-TM10-001-3','','','TM10','TW, ','TT01, ','中華民國陳述意見書','中華民國陳述意見書','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('T-TM12-001-1','','','TM12','TW, ','TT01, ','中華民國減縮商品','中華民國減縮商品','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','NTD',500.00,1.000,500,'','','','','','Q','',''),('T-TM12-001-3','','','TM12','TW, ','TT01, ','中華民國減縮商品','中華民國減縮商品','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',500.00,1.000,500,'','','','','','Q','',''),('T-TM14-001-1','','','TM14','TW, ','TT01, ','中華民國訴願','中華民國訴願','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','NTD',0.00,1.000,0,'','','','','','Q','',''),('T-TM14-001-3','','','TM14','TW, ','TT01, ','中華民國訴願','中華民國訴願','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',13500.00,1.000,13500,'','','','','','Q','',''),('T-TM16-001-1','','','TM16','TW, ','TT01, ','中華民國評定','中華民國評定','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','',0.00,1.000,0,'','','','','','Q','',''),('T-TM16-001-3','','','TM16','TW, ','TT01, ','中華民國評定','中華民國評定','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-PTC-001-1','','','PTC','TW, ','PN02, ','中華民國新型申請','中華民國新型申請','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',2400.00,1.000,2400,'','','','','','Q','',''),('P-PTC-001-3','','','PTC','TW, ','PN02, ','中華民國新型申請','中華民國新型申請','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',10600.00,1.000,10600,'','','','','','Q','',''),('P-PTA-001-1','','','PTA','TW, ','PN01, ','中華民國發明申請/實審','中華民國發明申請/實審','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',9900.00,1.000,9900,'','','','','','Q','',''),('P-PTA-001-3','','','PTA','TW, ','PN01, ','中華民國發明申請/實審','中華民國發明申請/實審','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',10100.00,1.000,10100,'','','','','','Q','',''),('P-PTM05-001-1','','','PTM05','TW, ','PN01, ','中華民國發明申請/實審/權項費(項)','中華民國發明申請/實審/權項費(項)','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',9900.00,1.000,9900,'','','','','','Q','',''),('P-PTM05-001-3','','','PTM05','TW, ','PN01, ','中華民國發明申請/實審/權項費(項)','中華民國發明申請/實審/權項費(項)','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',19600.00,1.000,19600,'','','','','','Q','',''),('P-PTC04-001-1','','','PTC04','TW, ','PN02, ','中華民國新型申請權讓與','中華民國新型申請權讓與','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTC04-001-3','','','PTC04','TW, ','PN02, ','中華民國新型申請權讓與','中華民國新型申請權讓與','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PTC02-001-1','','','PTC02','TW, ','PN02, ','中華民國新型技術報告','中華民國新型技術報告','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PTC02-001-3','','','PTC02','TW, ','PN02, ','中華民國新型技術報告','中華民國新型技術報告','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PTC08-001-1','','','PTC08','TW, ','PN01, ','中華民國發明獎甄選','中華民國發明獎甄選','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','',0.00,1.000,0,'','','','','','Q','',''),('P-PTC08-001-3','','','PTC08','TW, ','PN01, ','中華民國發明獎甄選','中華民國發明獎甄選','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','',20000.00,1.000,20000,'','','','','','Q','',''),('P-PTC03-001-1','','','PTC03','TW, ','PN02, ','中華民國領證及繳交第1年年費','中華民國領證及繳交第1年年費','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',2700.00,1.000,2700,'','','','','','Q','',''),('P-PTC03-001-3','','','PTC03','TW, ','PN02, ','中華民國領證及繳交第1年年費','中華民國領證及繳交第1年年費','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',4000.00,1.000,4000,'','','','','','Q','',''),('P-PTC06-001-1','','','PTC06','TW, ','PN02, ','中華民國繳交第1年年費(補繳無減免規費)','中華民國繳交第1年年費(補繳無減免規費)','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',800.00,1.000,800,'','','','','','Q','',''),('P-PTC06-001-3','','','PTC06','TW, ','PN02, ','中華民國繳交第1年年費(補繳無減免規費)','中華民國繳交第1年年費(補繳無減免規費)','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',0.00,1.000,0,'','','','','','Q','',''),('P-PCC-001-1','','','PCC','TW, ','PN02, ','中華民國繳交第2年年費','中華民國繳交第2年年費','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','',1700.00,1.000,1700,'','','','','','Q','',''),('P-PCC-001-3','','','PCC','TW, ','PN02, ','中華民國繳交第2年年費','中華民國繳交第2年年費','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','',1000.00,1.000,1000,'','','','','','Q','',''),('P-PTC01-001-1','','','PTC01','TW, ','PN02, ','中華民國變更發明人','中華民國變更發明人','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',300.00,1.000,300,'','','','','','Q','',''),('P-PTC01-001-3','','','PTC01','TW, ','PN02, ','中華民國變更發明人','中華民國變更發明人','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',0.00,1.000,0,'','','','','','Q','',''),('T-TM15-001-1','','','TM15','TW, ','TT01, ','中華民國商標註冊變更','中華民國商標註冊變更','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle01','',500.00,1.000,500,'','','','','','Q','',''),('T-TM15-001-3','','','TM15','TW, ','TT01, ','中華民國商標註冊變更','中華民國商標註冊變更','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle03','',500.00,1.000,500,'','','','','','Q','',''),('P-PMC20140605.001-001-1','','','PMC20140605.001','US, ','PN01, ','測試發明申請','測試發明申請','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',40000.00,1.000,40000,'','','','','','Q','',''),('P-PMC20140605.002-001-2','','','PMC20140605.002','US, ','PN01, ','','','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle02','',20000.00,1.000,20000,'','','','','','Q','',''),('P-PMC20140605.003-001-3','','','PMC20140605.003','US, ','PN01, ','','','','titanpat01','titanpat','ES02','STC01','Y','',0,'AccountTitle03','',29500.00,1.000,29500,'','','','','','Q','',''),('P-PTC03-002','BD01','','PTC03','TW, ','PN02, ','領證及繳交第1年年費','領證及繳交第1年年費','27','titanpat01','titanpat','ES02','STC01','','',0,'','',0.00,1.000,0,'','','3','2','','T','AS01',''),('T-TM01-003','TBD06','','TM01','TW, ','TT01, TT02, TT03, TT04, ','申請','申請','','titanpat01','titanpat','ES02','STC02','','',0,'','',0.00,1.000,0,'','','8','8','','T','AS00',''),('L-L02-001-3','','','L02','CN, ','MainT01, ','中國民事訴狀撰寫、出庭','中國民事一審出庭','','actionip','actionip','ES02','STC03','Y','',0,'AccountTitle03','RMB',12000.00,6.129,73542,'','','','','','Q','',''),('L-L03-002-3','','','L03','CN, ','MainT00, MainT01, MainT02, MainT03, MainT04, MainT05, MainT06, MainT07, MainT08, MainT09, MainT10, MainT11, MainT12, MainT13, MainT14, MainT15, MainT16, MainT17, MainT18, MainT19, ','法律顧問年約服務','法律顧問年約服務A級--','','actionip','actionip','ES02','STC03','Y','',0,'AccountTitle03','RMB',30000.00,6.129,183857,'','','','','','Q','',''),('C-CR01-001-3','','','CR01','TW, ','CMainT01, ','著作權登記','著作權登記','','admin','99','ES02','STC04','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('C-CR01-001-1','','','CR01','TW, ','CMainT01, ','著作權登記','著作權登記','','admin','99','ES02','STC04','Y','',0,'AccountTitle01','NTD',200.00,1.000,200,'','','','','','Q','',''),('L-L02-002','','','L02','CN, ','MainT01, ','','','','admin','99','ES02','STC03','Y','',0,'','',0.00,1.000,0,'','','','','','Q','',''),('P-PTA-002-1','','','PTA','TW, ','PN01, ','中國大陸-發明-申請/實審','中國-發明-申請/實審','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',10000.00,1.000,10000,'','','','','','Q','',''),('P-PTA-003-3','','','PTA','TW, ','PN01, ','中國大陸-發明-申請/實審','中國大陸-發明-申請/實審','','titanpat01','titanpat','ES02','STC01','Y','',0,'AccountTitle03','NTD',8000.00,1.000,8000,'','','','','','Q','',''),('P-PCC02-001-2','','','PCC02','CN, ','PN02, ','中國大陸-新型-領證及繳交第1年年費','中國大陸-新型-領證及繳交第1年年費','','titanpat01','titanpat','ES02','STC01','Y','Y',0,'AccountTitle02','NTD',10000.00,1.000,10000,'','','','','','Q','',''),('P-PCC02-001-3','','','PCC02','CN, ','PN02, ','中國大陸-新型-領證及繳交第1年年費','中國大陸-新型-領證及繳交第1年年費','','titanpat01','titanpat','ES02','STC01','Y','',0,'AccountTitle03','NTD',8500.00,1.000,8500,'','','','','','Q','',''),('P-PTAC-3-001-2','','','PTAC-3','CN, ','PN01, ','中國大陸-發明-申請/優先權','中國大陸-發明-申請/優先權','','titanpat01','titanpat','ES02','','Y','Y',0,'AccountTitle02','NTD',20000.00,1.000,20000,'','','','','','Q','','中國大陸-發明-申請/優先權'),('P-PTAC-3-3-3','','','PTAC-3','CN, ','PN01, ','中國大陸-發明-申請/優先權','中國大陸-發明-申請/優先權','','titanpat01','titanpat','ES02','','Y','',0,'AccountTitle03','NTD',12000.00,1.000,12000,'','','','','','Q','','中國大陸-發明-申請/優先權'),('P-PCC03-001-3','','','PCC03','CN, ','PN01, ','中國大陸-發明-繳交第2年年費','中國大陸-發明-繳交第2年年費','','titanpat01','titanpat','ES02','','Y','',0,'AccountTitle03','NTD',4000.00,1.000,4000,'','','','','','Q','','中國大陸-發明-繳交第2年年費'),('P-PCC03-001-2','','','PCC03','CN, ','PN01, ','中國大陸-發明-繳交第2年年費','中國大陸-發明-繳交第2年年費','','titanpat01','titanpat','ES02','','Y','Y',0,'AccountTitle02','NTD',4000.00,1.000,4000,'','','','','','Q','','中國大陸-發明-繳交第2年年費'),('P-PCC-002','BD04','','PCC03','CN, ','PN01, ','中國大陸-發明-繳交第2年年費','中國大陸-發明-繳交第2年年費','','titanpat01','titanpat','ES02','STC01','','',0,'','',0.00,1.000,0,'','','12','11','','T','AS00','中國大陸-發明-繳交第2年年費'),('T-TM6-001-2','','','TM6','CN, ','TT01, ','中國大陸-商標-異議','中國大陸-商標-異議','','titanpat01','titanpat','ES02','STC02','Y','Y',0,'AccountTitle02','RMB',35000.00,6.129,214500,'','','','','','Q','','中國大陸-商標-異議'),('T-TM6-001-3','','','TM6','CN, ','TT01, ','中國大陸-商標-異議','中國大陸-商標-異議','','titanpat01','titanpat','ES02','STC02','Y','',0,'AccountTitle03','NTD',25000.00,1.000,25000,'','','','','','Q','','中國大陸-商標-異議'),('P-TWP01-008-1','','','TWP01','TW, ','PN01, ','台灣發明申請','台灣發明申請申請','','yeangjen02','YeangJen','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','','台灣發明申請'),('P-PMC20140625.001-001','BD01','0','PMC20150918.001','US, ','PN01, PN02, PN03, PN04, PN05, PN06, PN07, PN08, PN09, PN10, PN11, PN12, PN13, ','美國專利答辯校稿','美國專利答辯校稿','10','titanpat01','titanpat','ES02','STC01','','',0,'','',0.00,1.000,0,'','','3','1','','T','AS00','美國專利答辯校稿'),('P-PTWPN03PA010-001-1','','','PTWPN03PA010','TW, ','PN03, ','台灣設計第一年年費','台灣設計第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('P-PTWPN02PA010-001-1','','','PTWPN02PA010','TW, ','PN02, ','台灣新型第一年年費','台灣新型第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('P-PTWPN03PA010-001-3','','','PTWPN03PA010','TW, ','PN03, ','台灣設計第一年年費','台灣設計第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('P-PTWPN02PA010-001-3','','','PTWPN02PA010','TW, ','PN02, ','台灣新型第一年年費','台灣新型第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('T-TTWTT02PA100-001-3','','','TTWTT02PA100','TW, ','TT02, ','台灣團體商標延展10年','台灣團體商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('T-TTWTT02PA100-001-1','','','TTWTT02PA100','TW, ','TT02, ','台灣團體商標延展10年','台灣團體商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle01','NTD',4000.00,1.000,4000,'','','','','','Q','',''),('P-PTWPN01PA010-001-1','','','PTWPN01PA010','TW, ','PN01, ','台灣發明第一年年費','台灣發明第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('T-TTWTT01PA100-001-1','','','TTWTT01PA100','TW, ','TT01, ','台灣商標延展10年','台灣商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle01','NTD',4000.00,1.000,4000,'','','','','','Q','',''),('T-TTWTT01PA100-001-3','','','TTWTT01PA100','TW, ','TT01, ','台灣商標延展10年','台灣商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PTWPN01PA010-001-3','','','PTWPN01PA010','TW, ','PN01, ','台灣發明第一年年費','台灣發明第一年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('P-PTWPN01PA020-001-1','','','PTWPN01PA020','TW, ','PN01, ','台灣發明第二年年費','台灣發明第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('P-PTWPN01PA030-001-1','','','PTWPN01PA030','TW, ','PN01, ','台灣發明第三年年費','台灣發明第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('P-PTWPN01PA040-001-1','','','PTWPN01PA040','TW, ','PN01, ','台灣發明第四年年費','台灣發明第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PTWPN01PA020-001-3','','','PTWPN01PA020','TW, ','PN01, ','台灣發明第二年年費','台灣發明第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN01PA030-001-3','','','PTWPN01PA030','TW, ','PN01, ','台灣發明第三年年費','台灣發明第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN01PA040-002-3','','','PTWPN01PA040','TW, ','PN01, ','台灣發明第四年年費','台灣發明第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN02PA020-001-1','','','PTWPN02PA020','TW, ','PN02, ','台灣新型第二年年費','台灣新型第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('P-PTWPN02PA020-001-3','','','PTWPN02PA020','TW, ','PN02, ','台灣新型第二年年費','台灣新型第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN02PA030-001-3','','','PTWPN02PA030','TW, ','PN02, ','台灣新型第三年年費','台灣新型第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN02PA030-001-1','','','PTWPN02PA030','TW, ','PN02, ','台灣新型第三年年費','台灣新型第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('P-PTWPN02PA040-001-1','','','PTWPN02PA040','TW, ','PN02, ','台灣新型第四年年費','台灣新型第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',4000.00,1.000,4000,'','','','','','Q','',''),('P-PTWPN02PA040-001-3','','','PTWPN02PA040','TW, ','PN02, ','台灣新型第四年年費','台灣新型第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN03PA020-001-1','','','PTWPN03PA020','TW, ','PN03, ','台灣設計第二年年費','台灣設計第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',800.00,1.000,800,'','','','','','Q','',''),('P-PTWPN03PA020-001-3','','','PTWPN03PA020','TW, ','PN03, ','台灣設計第二年年費','台灣設計第二年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN03PA030-001-1','','','PTWPN03PA030','TW, ','PN03, ','台灣設計第三年年費','台灣設計第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',800.00,1.000,800,'','','','','','Q','',''),('P-PTWPN03PA030-001-3','','','PTWPN03PA030','TW, ','PN03, ','台灣設計第三年年費','台灣設計第三年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN03PA040-001-1','','','PTWPN03PA040','TW, ','PN03, ','台灣設計第四年年費','台灣設計第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PTWPN03PA040-001-3','','','PTWPN03PA040','TW, ','PN03, ','台灣設計第四年年費','台灣設計第四年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',2000.00,1.000,2000,'','','','','','Q','',''),('P-PUSPN01PA035-001-1','','','PUSPN01PA035','US, ','PN01, ','美國發明第3.5年年費','美國發明第3.5年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','USD',2080.00,30.235,62888,'','','','','','Q','',''),('P-PUSPN01PA035-001-2','','','PUSPN01PA035','US, ','PN01, ','美國發明第3.5年年費','美國發明第3.5年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle02','USD',450.00,30.235,13605,'','','','','','Q','',''),('P-PUSPN01PA035-001-3','','','PUSPN01PA035','US, ','PN01, ','美國發明第3.5年年費','美國發明第3.5年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('P-PUSPN01PA070-001-1','','','PUSPN01PA070','US, ','PN01, ','美國發明第7年年費','美國發明第7年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle01','USD',3600.00,30.235,108846,'','','','','','Q','',''),('P-PUSPN01PA070-001-2','','','PUSPN01PA070','US, ','PN01, ','美國發明第7年年費','美國發明第7年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle02','USD',300.00,30.235,9070,'','','','','','Q','',''),('P-PUSPN01PA070-001-3','','','PUSPN01PA070','US, ','PN01, ','美國發明第7年年費','美國發明第7年年費','','admin','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',6000.00,1.000,6000,'','','','','','Q','',''),('T-TUSTT01PA100-001-2','','','TUSTT01PA100','US, ','TT01, ','美國商標延展10年','美國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle02','USD',360.00,30.235,10884,'','','','','','Q','',''),('T-TUSTT01PA100-001-3','','','TUSTT01PA100','US, ','TT01, ','美國商標延展10年','美國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('T-TCNTT01PA100-001-2','','','TCNTT01PA100','CN, ','TT01, ','中國商標延展10年','中國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle02','RMB',260.00,6.129,1593,'','','','','','Q','',''),('T-TCNTT01PA100-001-3','','','TCNTT01PA100','CN, ','TT01, ','中國商標延展10年','中國商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('T-TJPTT01PA100-001-1','','','TJPTT01PA100','JP, ','TT01, ','日本商標延展10年','日本商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle01','JPY',45000.00,0.297,13351,'','','','','','Q','',''),('T-TJPTT01PA100-001-2','','','TJPTT01PA100','JP, ','TT01, ','日本商標延展10年','日本商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle02','JPY',45000.00,0.297,13351,'','','','','','Q','',''),('T-TJPTT01PA100-001-3','','','TJPTT01PA100','JP, ','TT01, ','日本商標延展10年','日本商標延展10年','','admin','99','ES02','STC02','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PMC20150819.001-001-3','','','PMC20150819.001','TW, ','PN01, ','台灣發明專利申請含實審','台灣發明專利申請含實審','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('S-PMC20140903.001-001','SBD01','14','PMC20140903.001','TW, ','ServiceTypeMain01, ','11','11','1','admin','99','ES02','STC05','','',0,'','',0.00,1.000,0,'','','1','1','','T','AS00','11'),('S-PMC20140903.002-001','SBD02','11','PMC20140903.002','TW, ','ServiceTypeMain01, ','1','1','','admin','99','ES02','STC05','','',0,'','',0.00,1.000,0,'','','1','1','','T','AS00','1'),('P-PTA-004-3','','','PTA','TW, ','PN01, ','','','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-TWP01-009-3','','','TWP01','TW, ','PN01, ','申請費','申請費','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-TWP01-010','','','TWP01','TW, ','PN01, ','','','','WIPO','WIPO','ES02','STC01','Y','Y',0,'','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-PT0001-001','BD02','','PT0001','TW, ','PN01, ','','','','WIPO','WIPO','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS01',''),('P-PT0001-002-3','','','PT0001','TW, ','PN01, ','台灣發明專利申請費(基本費)','台灣發明專利申請費(基本費)','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-PT0002-001-3','','','PT0002','TW, ','PN01, ','台灣發明專利答辯費','台灣發明專利答辯費','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',10000.00,1.000,10000,'','','','','','Q','',''),('P-PT0003-001-3','','','PT0003','TW, ','PN01, ','台灣發明專利領證及第一年年費','台灣發明專利領證及第一年年費','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',1500.00,1.000,1500,'','','','','','Q','',''),('P-PT0003-001-1','','','PT0003','TW, ','PN01, ','台灣發明專利領證及第一年年費','台灣發明專利領證及第一年年費','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',2700.00,1.000,2700,'','','','','','Q','',''),('P-PT0001-003-1','','','PT0001','TW, ','PN01, ','台灣發明專利申請及實審','台灣發明專利申請及實審','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',10500.00,1.000,10500,'','','','','','Q','',''),('P-PT-CN-0001-001-3','','','PT-CN-0001','CN, ','PN01, ','大陸發明專利申請(含實審)','大陸發明專利申請(含實審)','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',42000.00,1.000,42000,'','','','','','Q','',''),('P-PT-CN-0002-001-3','','','PT-CN-0002','CN, ','PN01, ','大陸發明專利答辯','大陸發明專利答辯','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',25000.00,1.000,25000,'','','','','','Q','',''),('P-PT-US-0001-001','','','PT-US-0001','US, ','PN01, ','美國發明專利申請含實審','美國發明專利申請含實審','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',82000.00,1.000,82000,'','','','','','Q','',''),('P-PT-US-0002-001-3','','','PT-US-0002','US, ','PN01, ','美國發明專利答辯','美國發明專利答辯','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle03','NTD',60000.00,1.000,60000,'','','','','','Q','',''),('P-PT-US-0003-001-3','','','PT-US-0003','US, ','PN01, ','美國發明專利領證','美國發明專利領證','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',8000.00,1.000,8000,'','','','','','Q','',''),('P-PT-US-0003-US-2','','','PT-US-0003','US, ','PN01, ','美國發明專利領證','美國發明專利領證','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle02','USD',0.00,30.235,0,'','Y','','','','Q','',''),('P-PT-US-0003-US-1','','','PT-US-0003','US, ','PN01, ','美國發明專利領證','美國發明專利領證','','WIPO','WIPO','ES02','STC01','Y','Y',0,'AccountTitle01','USD',480.00,30.235,14512,'','','','','','Q','',''),('P-CN01-001','BD05','','CN01','CN, ','PN01, PN02, PN03, ','不喪失新穎性寬限期','不喪失新穎性寬限期','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','6','4','','T','AS00',''),('P-CN01-002','BD04','','CN01','CN, ','PN01, PN02, PN03, ','提交微生物的保藏證明以及存活證明的期限','提交微生物的保藏證明以及存活證明的期限','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','4','3','','T','AS00',''),('P-CN01-003','BD04','','CN01','CN, ','PN01, PN02, PN03, ','申請費繳納期限','申請費繳納期限','10','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS00',''),('P-CN02-001','BD04','','CN02','CN, ','PN01, PN02, PN03, ','請求實質審查請求期限','請求實質審查請求期限','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','36','33','','T','AS00',''),('P-CN02-002','BD04','','CN02','CN, ','PN01, PN02, PN03, ','實質審查費繳納期限','實質審查費繳納期限','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','36','34','','T','AS00',''),('P-CN02-003','BD01','','CN02','CN, ','PN01, PN02, PN03, ','第一次實質審查意見通知書意見陳述期限','第一次實質審查意見通知書意見陳述期限','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','4','3','','T','AS00',''),('P-CN02-004','BD01','','CN02','CN, ','PN01, PN02, PN03, ','補正答覆期限','補正答覆期限','10','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS00',''),('P-CN02-005','BD01','','CN02','CN, ','PN01, PN02, PN03, ','第2-4次實質審查意見通知書意見陳述期限','第2-4次實質審查意見通知書意見陳述期限','10','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS00',''),('P-CN03-001','BD01','15','CN03','CN, ','PN01, PN02, PN03, ','辦理登記手續期限','辦理登記手續期限','','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','2','','T','AS00',''),('P-CN03-002','BD01','','CN03','CN, ','PN01, PN02, PN03, ','提出分案申請期限','提出分案申請期限','10','admin','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS00',''),('P-CN04-001','BD01','','CN04','CN, ','PN01, PN02, PN03, ','恢復權利請求期限','恢復權利請求期限','10','admin','99','','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','',''),('P-CN04-002','BD01','','CN04','CN, ','PN01, PN02, PN03, ','恢復權利請求費繳納期限','恢復權利請求費繳納期限','10','admin','99','','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','',''),('P-CN04-003','BD01','15','CN04','CN, ','PN01, PN02, PN03, ','請求行政複議期限','請求行政複議期限','','admin','99','','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('P-CN04-004','BD01','','CN04','CN, ','PN01, PN02, PN03, ','提出複審請求期限','提出複審請求期限','','admin','99','','STC01','','',0,'','',0.00,1.000,0,'','','3','2','','T','',''),('P-CN04-005','BD01','','CN04','CN, ','PN01, PN02, PN03, ','複審請求費繳納期限','複審請求費繳納期限','','admin','99','','STC01','','',0,'','',0.00,1.000,0,'','','3','2','','T','',''),('P-PMC20150819.002-001-3','','','PMC20150819.002','TW, ','PN01, ','台灣發明專利申請不含實審','台灣發明專利申請不含實審','','WIPO','WIPO','ES02','STC01','Y','',0,'AccountTitle03','NTD',22000.00,1.000,22000,'','','','','','Q','',''),('P-PT0002-002','BD01','','PT0002','TW, ','PN01, ','台灣專利提申復','台灣專利提申復','','WIPO','WIPO','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','2','','T','AS00',''),('P-PT0002-003','BD01','','PT0002','TW, ','PN01, ','客戶回覆期限','客戶回覆期限','10','WIPO','WIPO','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','','','T','AS00',''),('P-PMC20140625.001-002','BD01','0','PMC20150918.001','US, ','PN01, PN02, PN03, PN04, PN05, PN06, PN07, PN08, PN09, PN10, PN11, PN12, PN13, ','美國專利答辯撰稿','美國專利答辯撰稿','','titanpat01','titanpat','ES02','STC01','','',0,'','',0.00,1.000,0,'','','3','1','','T','AS00','美國專利答辯撰稿'),('PTW-TG-N','','','TWP01','TW, ','PN01, ','基本費(申請時一併請求實審) 9100 \r\n請求項逾10項部分，每項加收800 \r\n全案合計逾50頁部分，每50頁加收500','新案申請','','test','99','ES02','STC01','Y','',0,'','NTD',0.00,1.000,0,'','Y','','','','Q','',''),('IPW-N1','BD01','','IPW-01','CN, EP, JP, KR, TW, US, ','PN01, PN02, PN03, PN09, PN11, ','撰稿中(新案)','撰稿中(新案)','','test','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','1','1','','T','AS01',''),('PTW-TP-N','','','TWP01','TW, ','PN01, ','新案申請','新案申請','','test','99','ES02','STC01','Y','',0,'AccountTitle03','NTD',48000.00,1.000,48000,'','','','','','Q','',''),('P-TWP01-011','BD01','','TWP01','TW, ','PN01, ','撰稿中(新案)','撰稿中(新案)','','test','99','','STC01','','',0,'','',0.00,1.000,0,'','','','1','','T','',''),('P-TWP01-012','BD01','','TWP01','TW, ','PN01, ','待送核(初稿)','待送核(初稿)','3','test','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('P-TWP01-013','BD01','','TWP01','TW, ','PN01, ','客戶校稿中(新案)','客戶校稿中(新案)','','test','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','1','','T','AS00',''),('P-TWP01-014','BD01','','TWP01','TW, ','PN01, ','改稿中(新案)','改稿中(新案)','5','test','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('P-TWP01-015','BD01','','TWP01','TW, ','PN01, ','待送件(新案)','待送件(新案)','3','test','99','','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('P-PMC20150819.001-002-1','','','PMC20150819.001','TW, ','PN01, ','','','','test4','Demo','ES02','STC01','Y','Y',0,'AccountTitle01','NTD',10500.00,1.000,10500,'','','','','','Q','',''),('P-PT0001-004-3','','','PT0001','TW, ','PN01, ','','','','test4','Demo','ES02','STC01','Y','',0,'AccountTitle03','NTD',20000.00,1.000,20000,'','','','','','Q','',''),('P-PCN02-001','','','PT0003','TW, ','PN01, ','','','','test4','Demo','ES02','STC01','Y','',0,'AccountTitle04','NTD',5000.00,1.000,5000,'','','','','','Q','',''),('P-PMC20160512.001-001','','','PMC20160512.001','BF, ','PN10, ','','','','test4','Demo','ES02','STC01','Y','Y',0,'','NTD',1000.00,1.000,1000,'','','','','','Q','',''),('T-123-001','TBD01','30','123','AD, AE, AF, AG, AI, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AW, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BM, BN, BO, BQ, BR, BS, BT, BV, BW, BX, BY, BZ, CA, CD, CF, CG, CH, CI, CK, CL, CM, CN, CO, CR, CU, CV, CW, CY, CZ, DE, DJ, DK, DM, DO, DZ, EA, EC, EE, EG, EH, EM, EP, ER, ES, ET, EU, FI, FJ, FK, FO, FR, GA, GB, GC, GD, GE, GG, GH, GI, GL, GM, GN, GQ, GR, GS, GT, GW, GY, HK, HN, HR, HT, HU, IB, ID, IE, IL, IM, IN, IQ, IR, IS, IT, JE, JM, JO, JP, KE, KG, KH, KI, KM, KN, KP, KR, KS, KW, KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, ME, MG, MK, ML, MM, MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, MX, MY, MZ, NA, NE, NF, NG, NI, NL, NO, NP, NR, NZ, OA, OM, PA, PCT, PE, PF, PG, PH, PK, PL, PR, PS, PSW, PT, PW, PY, QA, QZ, RO, RS, RU, RW, SA, SB, SC, SD, SE, SG, SH, SI, SK, SL, SM, SN, SO, SR, SS, ST, SV, SX, SY, SZ, TC, TD, TG, TH, TJ, TL, TM, TN, TO, TR, TT, TV, TW, TZ, UA, UG, US, UY, UZ, VA, VC, VE, VG, VN, VU, WS, XN, YE, YU, ZA, ZM, ZW, ','TT01, ','應辦領證','30日內領證','25','test4','Demo','ES02','STC02','','',1,'','',0.00,1.000,0,'','','0','0','','T','AS00',''),('T-123-002-1','','','123','AD, AE, AF, AG, AI, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AW, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BM, BN, BO, BQ, BR, BS, BT, BV, BW, BX, BY, BZ, CA, CD, CF, CG, CH, CI, CK, CL, CM, CN, CO, CR, CU, CV, CW, CY, CZ, DE, DJ, DK, DM, DO, DZ, EA, EC, EE, EG, EH, EM, EP, ER, ES, ET, EU, FI, FJ, FK, FO, FR, GA, GB, GC, GD, GE, GG, GH, GI, GL, GM, GN, GQ, GR, GS, GT, GW, GY, HK, HN, HR, HT, HU, IB, ID, IE, IL, IM, IN, IQ, IR, IS, IT, JE, JM, JO, JP, KE, KG, KH, KI, KM, KN, KP, KR, KS, KW, KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, ME, MG, MK, ML, MM, MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, MX, MY, MZ, NA, NE, NF, NG, NI, NL, NO, NP, NR, NZ, OA, OM, PA, PCT, PE, PF, PG, PH, PK, PL, PR, PS, PSW, PT, PW, PY, QA, QZ, RO, RS, RU, RW, SA, SB, SC, SD, SE, SG, SH, SI, SK, SL, SM, SN, SO, SR, SS, ST, SV, SX, SY, SZ, TC, TD, TG, TH, TJ, TL, TM, TN, TO, TR, TT, TV, TW, TZ, UA, UG, US, UY, UZ, VA, VC, VE, VG, VN, VU, WS, XN, YE, YU, ZA, ZM, ZW, ','TT01, ','商標領證','商標領證','','test4','Demo','ES02','STC02','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('T-123-003-1','','','123','AD, AE, AF, AG, AI, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AW, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BM, BN, BO, BQ, BR, BS, BT, BV, BW, BX, BY, BZ, CA, CD, CF, CG, CH, CI, CK, CL, CM, CN, CO, CR, CU, CV, CW, CY, CZ, DE, DJ, DK, DM, DO, DZ, EA, EC, EE, EG, EH, EM, EP, ER, ES, ET, EU, FI, FJ, FK, FO, FR, GA, GB, GC, GD, GE, GG, GH, GI, GL, GM, GN, GQ, GR, GS, GT, GW, GY, HK, HN, HR, HT, HU, IB, ID, IE, IL, IM, IN, IQ, IR, IS, IT, JE, JM, JO, JP, KE, KG, KH, KI, KM, KN, KP, KR, KS, KW, KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, ME, MG, MK, ML, MM, MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, MX, MY, MZ, NA, NE, NF, NG, NI, NL, NO, NP, NR, NZ, OA, OM, PA, PCT, PE, PF, PG, PH, PK, PL, PR, PS, PSW, PT, PW, PY, QA, QZ, RO, RS, RU, RW, SA, SB, SC, SD, SE, SG, SH, SI, SK, SL, SM, SN, SO, SR, SS, ST, SV, SX, SY, SZ, TC, TD, TG, TH, TJ, TL, TM, TN, TO, TR, TT, TV, TW, TZ, UA, UG, US, UY, UZ, VA, VC, VE, VG, VN, VU, WS, XN, YE, YU, ZA, ZM, ZW, ','TT01, ','','','','test4','Demo','ES02','STC02','Y','',0,'AccountTitle01','NTD',2500.00,1.000,2500,'','','','','','Q','',''),('T-123-004-1','','','123','AD, AE, AF, AG, AI, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AW, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BM, BN, BO, BQ, BR, BS, BT, BV, BW, BX, BY, BZ, CA, CD, CF, CG, CH, CI, CK, CL, CM, CN, CO, CR, CU, CV, CW, CY, CZ, DE, DJ, DK, DM, DO, DZ, EA, EC, EE, EG, EH, EM, EP, ER, ES, ET, EU, FI, FJ, FK, FO, FR, GA, GB, GC, GD, GE, GG, GH, GI, GL, GM, GN, GQ, GR, GS, GT, GW, GY, HK, HN, HR, HT, HU, IB, ID, IE, IL, IM, IN, IQ, IR, IS, IT, JE, JM, JO, JP, KE, KG, KH, KI, KM, KN, KP, KR, KS, KW, KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, ME, MG, MK, ML, MM, MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, MX, MY, MZ, NA, NE, NF, NG, NI, NL, NO, NP, NR, NZ, OA, OM, PA, PCT, PE, PF, PG, PH, PK, PL, PR, PS, PSW, PT, PW, PY, QA, QZ, RO, RS, RU, RW, SA, SB, SC, SD, SE, SG, SH, SI, SK, SL, SM, SN, SO, SR, SS, ST, SV, SX, SY, SZ, TC, TD, TG, TH, TJ, TL, TM, TN, TO, TR, TT, TV, TW, TZ, UA, UG, US, UY, UZ, VA, VC, VE, VG, VN, VU, WS, XN, YE, YU, ZA, ZM, ZW, ','TT01, ','','','','test4','Demo','ES02','STC02','Y','',0,'AccountTitle01','NTD',3000.00,1.000,3000,'','','','','','Q','',''),('P-IPW-01-001','BD01','30','IPW-01','CN, EP, JP, KR, TW, US, ','PN01, PN02, PN03, PN09, PN11, ','年費1-3','年費1-3','25','test4','Demo','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('L-L01-001','LBD03','15','L01','TW, ','MainT01, ','管制事項一','管制事項一','10','admin','99','ES02','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('L-L01-002','LBD04','20','L01','TW, ','MainT01, ','管制事項二','管制事項二','18','admin','99','ES02','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('L-L01-003','LBD01','22','L01','TW, ','MainT01, ','管制事項三','管制事項三','20','admin','99','ES02','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','AS00',''),('P-PT0003-002','','','PT0003','TW, ','PN01, ','','','','tek01','tek','ES02','STC01','Y','',0,'AccountTitle03','RMB',1000.00,4.890,4890,'','','','','','Q','',''),('P-PCN02-002','BD01','','PCN02','CN, ','PN02, ','','','20','tek01','tek','ES02','STC01','','',0,'','',0.00,1.000,0,'','','2','1','','T','AS00',''),('P-PTWPN01PA010-002-3','','','PTWPN01PA010','TW, ','PN01, ','台灣發明第一年年費','台灣發明第一年年費','','YUSO','YUSO','ES02','STC01','Y','',0,'AccountTitle03','NTD',5000.00,1.000,5000,'','','','','','Q','','台灣發明第一年年費'),('P--001','BD01','','PTM05','TW, ','PN01, ','新案撰寫1','新案撰寫','20','YUSO','YUSO','ES02','STC01','','',5,'','',0.00,1.000,0,'','','1','','','T','AS01','新案撰寫2'),('S-PMC20180110.003-001-3','','','PMC20180110.003','TW, ','STM03, ','會計服務費(月)','會計服務費(月)','','KSP01','KSP','ES02','STC05','Y','',0,'AccountTitle03','USD',200.00,30.235,6047,'','','','','','Q','','會計服務費(月)'),('T-TM8-002','','','TM8','TW, ','TT01, ','','','','KSP01','KSP','ES02','STC02','Y','',0,'','USD',800.00,30.235,24188,'','','','','','Q','',''),('T-TM8-003','','','TM8','TW, ','TT01, ','','','','KSP01','KSP','','STC02','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('S-PMC20180110.003-002-3','','','PMC20180110.003','TW, ','STM03, ','記帳服務費','記帳服務','','KSP01','KSP','ES02','STC05','Y','Y',0,'AccountTitle03','NTD',0.00,1.000,0,'','Y','','','','Q','','記帳服務費2018年01-06月'),('L-L01-005','','','L01','TW, ','MainT01, ','','','','steven','L','','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('L-L02-003','','','L02','CN, ','MainT01, ','','','','steven','L','','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('L--001','','','','','','','','','steven','L','','STC03','','',0,'','',0.00,1.000,0,'','','','','','T','',''),('P-PT0001-005-3','','','PT0001','TW, ','PN01, ','台灣發明申請','台灣發明申請','','proguide','Demo1','ES02','STC01','Y','',0,'AccountTitle03','NTD',15000.00,1.000,15000,'','','','','','Q','',''),('L-L04-001-3','','','L04','TW, ','MainT01, ','台灣法顧','台灣法顧','','admin','99','ES02','STC03','Y','',0,'AccountTitle03','NTD',100000.00,1.000,100000,'','','','','','Q','','台灣法顧'),('L-L01-004-3','','','L01','TW, ','MainT01, ','台灣民事訴狀撰寫、出庭','台灣民事一審出庭','','actionip','actionip','ES02','STC03','Y','',0,'AccountTitle03','NTD',50000.00,1.000,50000,'','','','','','Q','',''),('S-PMC20140903.001-002-3','','','PMC20140903.001','TW, ','ServiceTypeMain01, ','台灣法顧','台灣法顧','','admin','99','ES02','STC05','Y','',0,'AccountTitle03','NTD',100000.00,1.000,100000,'','','','','','Q','','台灣法顧'),('P-PMC20150819.001-003','BD01','','PMC20150819.001','TW, ','PN01, ','補呈重要文件+中文說明書','','','DP02','DP','ES02','STC01','','',0,'','',0.00,1.000,0,'','','4','3','','T','AS01',''),('P-TWP01-017','BD04','','TWP01','TW, ','PN01, ','新案中文翻譯','新案中文翻譯','','test','99','ES02','STC01','','',0,'','',0.00,1.000,0,'','','4','2','','T','AS00',''),('P-PT0001-006-3','','','PT0001','TW, ','PN01, ','','','','HH01','HH','ES02','STC01','Y','',0,'AccountTitle03','NTD',0.00,1.000,0,'','','','','','Q','',''),('P--002','','','','','','敵人來襲','敵人來襲','','HH01','HH','ES02','STC01','','',0,'','',0.00,1.000,0,'','','','','','Q','',''),('P-PT0001-007-3','','','PT0001','TW, ','PN01, ','','','','longriver01','PTL','ES02','STC01','Y','',0,'AccountTitle03','NTD',10000.00,1.000,10000,'','','','','','Q','',''),('P-PT0001-008-1','','','PT0001','TW, ','PN01, ','','','','longriver01','PTL','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('P-PT-CN-0001-002-1','','','PT-CN-0001','CN, ','PN01, ','','','','longriver01','PTL','ES02','STC01','Y','',0,'AccountTitle01','NTD',3500.00,1.000,3500,'','','','','','Q','',''),('P-PT0002-004-3','','','PT0002','TW, ','PN01, ','','','','longriver02','PTL','ES02','STC01','Y','',0,'AccountTitle03','NTD',20000.00,1.000,20000,'','','','','','Q','',''),('P-TWP01-018-3','','','TWP01','TW, ','PN01, ','','','','longriver01','PTL','ES02','STC01','Y','',0,'AccountTitle03','',5000.00,1.000,5000,'','','','','','Q','',''),('P-PMC20150819.001-004','','','PMC20150819.001','TW, ','PN01, ','','','','longriver01','PTL','ES02','STC01','Y','',0,'','',0.00,1.000,0,'','','','','','Q','',''),('P-PCC01-001','','','PCC01','CN, ','PN02, ','','','','longriver02','PTL','ES02','STC01','Y','',0,'','',0.00,1.000,0,'','Y','','','','Q','',''),('P-PCC01-002','','','PCC01','CN, ','PN02, ','','','','longriver02','PTL','ES02','STC01','Y','',0,'','',0.00,1.000,0,'','Y','','','','Q','',''),('P-PCC01-003','','','PCC01','CN, ','PN02, ','','','','longriver02','PTL','ES02','STC01','Y','',0,'','',0.00,1.000,0,'','Y','','','','Q','','');
/*!40000 ALTER TABLE `standardtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `StockType` varchar(50) DEFAULT NULL,
  `DepartmentId` varchar(50) DEFAULT NULL,
  `Manager` varchar(50) DEFAULT NULL,
  `AllowMinus` char(1) DEFAULT NULL,
  `EffectFlag` char(1) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocktrans`
--

DROP TABLE IF EXISTS `stocktrans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stocktrans` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `TransDate` varchar(10) DEFAULT NULL,
  `TransationType` varchar(50) DEFAULT NULL,
  `TransName` varchar(100) DEFAULT NULL,
  `OutStockId` varchar(50) DEFAULT NULL,
  `InStockId` varchar(50) DEFAULT NULL,
  `InvoiceNo` varchar(50) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocktrans`
--

LOCK TABLES `stocktrans` WRITE;
/*!40000 ALTER TABLE `stocktrans` DISABLE KEYS */;
/*!40000 ALTER TABLE `stocktrans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocktrans_detail`
--

DROP TABLE IF EXISTS `stocktrans_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stocktrans_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `ProductId` varchar(50) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocktrans_detail`
--

LOCK TABLES `stocktrans_detail` WRITE;
/*!40000 ALTER TABLE `stocktrans_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `stocktrans_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `BudgetId` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `SubjectType` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `IsCategory` char(1) DEFAULT NULL,
  `IsStrikeSubject` char(1) DEFAULT NULL,
  `Controler` varchar(50) DEFAULT NULL,
  `UseTableName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemconfig`
--

DROP TABLE IF EXISTS `systemconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemconfig` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `UpdateTime` varchar(50) DEFAULT NULL,
  `Value1` varchar(50) DEFAULT NULL,
  `Value2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemconfig`
--

LOCK TABLES `systemconfig` WRITE;
/*!40000 ALTER TABLE `systemconfig` DISABLE KEYS */;
INSERT INTO `systemconfig` VALUES ('accountAllowNo','ESSEN','admin','2018-10-23 12:54:50','40','');
/*!40000 ALTER TABLE `systemconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemlogo`
--

DROP TABLE IF EXISTS `systemlogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemlogo` (
  `FlowKey` varchar(50) NOT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CreateDept` varchar(10) DEFAULT NULL,
  `PicPath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemlogo`
--

LOCK TABLES `systemlogo` WRITE;
/*!40000 ALTER TABLE `systemlogo` DISABLE KEYS */;
INSERT INTO `systemlogo` VALUES ('SL20110412.001','admin','99','Document/SystemLogo/admin/UL14338.003.png');
/*!40000 ALTER TABLE `systemlogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term`
--

DROP TABLE IF EXISTS `term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `term` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  `OpenFlag` char(1) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term`
--

LOCK TABLES `term` WRITE;
/*!40000 ALTER TABLE `term` DISABLE KEYS */;
/*!40000 ALTER TABLE `term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheetmanagement`
--

DROP TABLE IF EXISTS `timesheetmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheetmanagement` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `CreateTime` varchar(50) DEFAULT NULL,
  `EmployeeId` varchar(50) DEFAULT NULL,
  `EmployeeName` varchar(50) DEFAULT NULL,
  `WorkDate` varchar(10) DEFAULT NULL,
  `WorkHours` float(10,2) DEFAULT '0.00',
  `WorkType` varchar(50) DEFAULT NULL,
  `Billable` varchar(1) DEFAULT NULL,
  `Billed` varchar(50) DEFAULT NULL,
  `WorkNotes` varchar(2000) DEFAULT NULL,
  `TodosId` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `ClientName` varchar(200) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `TaskDescription` varchar(500) DEFAULT NULL,
  `LegalDueDate` varchar(10) DEFAULT NULL,
  `AttorneyDueDate` varchar(10) DEFAULT NULL,
  `StartDate` varchar(10) DEFAULT NULL,
  `FinishedDate` varchar(10) DEFAULT NULL,
  `Finished` varchar(1) DEFAULT NULL,
  `ToDosStatus` varchar(50) DEFAULT NULL,
  `Title` varchar(500) DEFAULT NULL,
  `ChargeHours` float(10,2) DEFAULT '0.00',
  `HourlyCharge` varchar(50) DEFAULT NULL,
  `HourlyCost` varchar(50) DEFAULT NULL,
  `WorkDateStart` varchar(20) DEFAULT NULL,
  `WorkDateEnd` varchar(20) DEFAULT NULL,
  `HourlyCurrency` varchar(50) DEFAULT NULL,
  `Amount` double(16,4) DEFAULT '0.0000',
  `Points` double(10,1) DEFAULT '0.0',
  `FareRates` double(8,2) DEFAULT '1.00',
  `CaseNo` varchar(500) DEFAULT NULL,
  `PaymentKind` varchar(500) DEFAULT NULL,
  `Matter` varchar(50) DEFAULT NULL,
  `LastInvDate` varchar(50) DEFAULT NULL,
  `ServiceHours` double(10,1) DEFAULT '0.0',
  `CountingHours` double(10,1) DEFAULT '0.0',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheetmanagement`
--

LOCK TABLES `timesheetmanagement` WRITE;
/*!40000 ALTER TABLE `timesheetmanagement` DISABLE KEYS */;
/*!40000 ALTER TABLE `timesheetmanagement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todos`
--

DROP TABLE IF EXISTS `todos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todos` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `TaskDescription` varchar(200) NOT NULL,
  `Matter` varchar(50) NOT NULL,
  `SrcModule` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TaskCreator` varchar(50) NOT NULL,
  `TaskSponsor` varchar(50) NOT NULL,
  `AssignedTo` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `InterestedParty` varchar(200) NOT NULL,
  `LegalDueDate` varchar(10) NOT NULL,
  `AttorneyDueDate` varchar(10) NOT NULL,
  `InternalDueDate` varchar(10) NOT NULL,
  `Alert` char(1) NOT NULL,
  `AlertDate` varchar(10) NOT NULL,
  `AlertBeforeDays` int(11) NOT NULL,
  `Finished` char(1) NOT NULL,
  `FinishedDate` varchar(10) NOT NULL,
  `Points` int(11) NOT NULL DEFAULT '0',
  `WorkingHours` float(11,1) NOT NULL DEFAULT '0.0',
  `Grade` varchar(50) NOT NULL,
  `Currency` varchar(50) NOT NULL,
  `PtoFee` float(11,2) NOT NULL,
  `ServiceFee` float(11,2) NOT NULL,
  `AttorneyFee` float(11,2) NOT NULL,
  `OtherFee` float(11,2) NOT NULL,
  `Memo` text NOT NULL,
  `Appendix` varchar(100) NOT NULL,
  `StartDate2` varchar(20) NOT NULL,
  `IsCharge` char(1) DEFAULT NULL,
  `IsRequestPay` char(1) DEFAULT NULL,
  `Agent` varchar(50) DEFAULT NULL,
  `IsPayment` char(1) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `ExchangeRate` double(16,4) DEFAULT NULL,
  `Amount` double(16,4) DEFAULT NULL,
  `TwdAmount` int(16) DEFAULT '0',
  `RequestPayAmount` int(16) DEFAULT '0',
  `NotYetRequestPayAmount` int(16) DEFAULT '0',
  `PayAmount` double(16,4) DEFAULT NULL,
  `NotYetPayAmount` int(16) DEFAULT '0',
  `AttachmentName` varchar(100) DEFAULT NULL,
  `MailDate` varchar(10) DEFAULT NULL,
  `ContectClient` varchar(1) DEFAULT NULL,
  `BillingWorkingHours` float(11,1) DEFAULT '0.0',
  `ByThePiece` varchar(1) DEFAULT NULL,
  `HourlyRate` varchar(10) DEFAULT NULL,
  `HourlyCurrency` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `ToDosStatus` varchar(50) DEFAULT NULL,
  `BonusStatus` varchar(50) DEFAULT NULL,
  `NotifyTarget` text,
  `IsPoints` varchar(1) DEFAULT 'N',
  `AssignStatus` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `AssignTime` varchar(200) DEFAULT NULL,
  `AssignMailFlag` char(1) DEFAULT 'N',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todos`
--

LOCK TABLES `todos` WRITE;
/*!40000 ALTER TABLE `todos` DISABLE KEYS */;
/*!40000 ALTER TABLE `todos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todos2`
--

DROP TABLE IF EXISTS `todos2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todos2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `TaskDescription` varchar(200) NOT NULL,
  `Matter` varchar(50) NOT NULL,
  `SrcModule` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TaskCreator` varchar(50) NOT NULL,
  `TaskSponsor` varchar(50) NOT NULL,
  `AssignedTo` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `InterestedParty` varchar(200) NOT NULL,
  `LegalDueDate` varchar(10) NOT NULL,
  `AttorneyDueDate` varchar(10) NOT NULL,
  `InternalDueDate` varchar(10) NOT NULL,
  `Alert` char(1) NOT NULL,
  `AlertDate` varchar(10) NOT NULL,
  `AlertBeforeDays` int(11) NOT NULL,
  `Finished` char(1) NOT NULL,
  `FinishedDate` varchar(10) NOT NULL,
  `Points` int(11) NOT NULL DEFAULT '0',
  `WorkingHours` float(11,1) NOT NULL DEFAULT '0.0',
  `Grade` varchar(50) NOT NULL,
  `Currency` varchar(50) NOT NULL,
  `PtoFee` float(11,2) NOT NULL,
  `ServiceFee` float(11,2) NOT NULL,
  `AttorneyFee` float(11,2) NOT NULL,
  `OtherFee` float(11,2) NOT NULL,
  `Memo` text NOT NULL,
  `Appendix` varchar(100) NOT NULL,
  `StartDate2` varchar(20) NOT NULL,
  `IsCharge` char(1) DEFAULT NULL,
  `IsRequestPay` char(1) DEFAULT NULL,
  `Agent` varchar(50) DEFAULT NULL,
  `IsPayment` char(1) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `ExchangeRate` double(16,4) DEFAULT NULL,
  `Amount` double(16,4) DEFAULT NULL,
  `TwdAmount` int(16) DEFAULT '0',
  `RequestPayAmount` int(16) DEFAULT '0',
  `NotYetRequestPayAmount` int(16) DEFAULT '0',
  `PayAmount` double(16,4) DEFAULT NULL,
  `NotYetPayAmount` int(16) DEFAULT '0',
  `AttachmentName` varchar(100) DEFAULT NULL,
  `MailDate` varchar(10) DEFAULT NULL,
  `ContectClient` varchar(1) DEFAULT NULL,
  `BillingWorkingHours` float(11,1) DEFAULT '0.0',
  `ByThePiece` varchar(1) DEFAULT NULL,
  `HourlyRate` varchar(10) DEFAULT NULL,
  `HourlyCurrency` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `ToDosStatus` varchar(50) DEFAULT NULL,
  `BonusStatus` varchar(50) DEFAULT NULL,
  `NotifyTarget` text,
  `IsPoints` varchar(1) DEFAULT 'N',
  `AssignStatus` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseType` varchar(50) DEFAULT NULL,
  `PatentType` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `AssignTime` varchar(200) DEFAULT NULL,
  `AssignMailFlag` char(1) DEFAULT 'N',
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todos2`
--

LOCK TABLES `todos2` WRITE;
/*!40000 ALTER TABLE `todos2` DISABLE KEYS */;
/*!40000 ALTER TABLE `todos2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todos_2`
--

DROP TABLE IF EXISTS `todos_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todos_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `TaskDescription` varchar(200) NOT NULL,
  `Matter` varchar(50) NOT NULL,
  `SrcModule` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `TaskCreator` varchar(50) NOT NULL,
  `TaskSponsor` varchar(50) NOT NULL,
  `AssignedTo` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `InterestedParty` varchar(200) NOT NULL,
  `LegalDueDate` varchar(10) NOT NULL,
  `AttorneyDueDate` varchar(10) NOT NULL,
  `InternalDueDate` varchar(10) NOT NULL,
  `Alert` char(1) NOT NULL,
  `AlertDate` varchar(10) NOT NULL,
  `AlertBeforeDays` int(11) NOT NULL,
  `Finished` char(1) NOT NULL,
  `FinishedDate` varchar(10) NOT NULL,
  `Points` int(11) NOT NULL DEFAULT '0',
  `WorkingHours` float(11,1) NOT NULL DEFAULT '0.0',
  `Grade` varchar(50) NOT NULL,
  `Currency` varchar(50) NOT NULL,
  `PtoFee` float(11,2) NOT NULL,
  `ServiceFee` float(11,2) NOT NULL,
  `AttorneyFee` float(11,2) NOT NULL,
  `OtherFee` float(11,2) NOT NULL,
  `Memo` text NOT NULL,
  `Appendix` varchar(100) NOT NULL,
  `StartDate2` varchar(20) NOT NULL,
  `IsCharge` char(1) DEFAULT NULL,
  `IsRequestPay` char(1) DEFAULT NULL,
  `Agent` varchar(50) DEFAULT NULL,
  `IsPayment` char(1) DEFAULT NULL,
  `AccountTitle` varchar(50) DEFAULT NULL,
  `ExchangeRate` double(16,4) DEFAULT NULL,
  `Amount` double(16,4) DEFAULT NULL,
  `TwdAmount` int(16) DEFAULT '0',
  `RequestPayAmount` int(16) DEFAULT '0',
  `NotYetRequestPayAmount` int(16) DEFAULT '0',
  `PayAmount` double(16,4) DEFAULT NULL,
  `NotYetPayAmount` int(16) DEFAULT '0',
  `AttachmentName` varchar(100) DEFAULT NULL,
  `MailDate` varchar(10) DEFAULT NULL,
  `ContectClient` varchar(1) DEFAULT NULL,
  `BillingWorkingHours` float(11,1) DEFAULT '0.0',
  `ByThePiece` varchar(1) DEFAULT NULL,
  `HourlyRate` varchar(10) DEFAULT NULL,
  `HourlyCurrency` varchar(50) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `ToDosStatus` varchar(50) DEFAULT NULL,
  `BonusStatus` varchar(50) DEFAULT NULL,
  `NotifyTarget` text,
  `IsPoints` varchar(1) DEFAULT 'N',
  `AssignStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todos_2`
--

LOCK TABLES `todos_2` WRITE;
/*!40000 ALTER TABLE `todos_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `todos_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkapplicant`
--

DROP TABLE IF EXISTS `trademarkapplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkapplicant` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `ApplicantOrder` varchar(50) NOT NULL,
  `ApplicantId` varchar(50) NOT NULL,
  `ApplicantName` varchar(200) NOT NULL,
  `EnglishNames` varchar(100) DEFAULT NULL,
  `IdNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkapplicant`
--

LOCK TABLES `trademarkapplicant` WRITE;
/*!40000 ALTER TABLE `trademarkapplicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkapplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkattorney`
--

DROP TABLE IF EXISTS `trademarkattorney`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkattorney` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `AttorneyType` varchar(50) NOT NULL,
  `Attorney` varchar(50) NOT NULL,
  `AttorneyName` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkattorney`
--

LOCK TABLES `trademarkattorney` WRITE;
/*!40000 ALTER TABLE `trademarkattorney` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkattorney` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkcase`
--

DROP TABLE IF EXISTS `trademarkcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkcase` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Office` varchar(50) NOT NULL,
  `TrademarkType` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `AttorneyDate` varchar(10) NOT NULL,
  `AttorneyNum` varchar(50) NOT NULL,
  `FillingDate` varchar(10) NOT NULL,
  `FillingNum` varchar(50) NOT NULL,
  `PublicationDate` varchar(10) NOT NULL,
  `PublicationNum` varchar(50) NOT NULL,
  `RegistDate` varchar(10) NOT NULL,
  `RegistNum` varchar(50) NOT NULL,
  `TrademarkNum` varchar(50) NOT NULL,
  `TrademarkNo` varchar(50) NOT NULL,
  `ExpiryDate` varchar(10) NOT NULL,
  `ExtendDate` varchar(10) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `ClosedDate` varchar(10) NOT NULL,
  `TrademarkImg` varchar(100) NOT NULL,
  `Color` varchar(50) NOT NULL,
  `NoBelongDesc` varchar(500) NOT NULL,
  `ChtWordsinMark` varchar(500) NOT NULL,
  `EngWordsinMark` varchar(500) NOT NULL,
  `JapWordsinMark` varchar(500) NOT NULL,
  `Significance` varchar(500) NOT NULL,
  `GraphDesc` varchar(500) NOT NULL,
  `DesignMark` varchar(100) NOT NULL,
  `TrademarkCaseType` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `MarkType` varchar(50) DEFAULT NULL,
  `ExpiryDateTo` varchar(10) DEFAULT NULL,
  `OathDate` varchar(10) DEFAULT NULL,
  `OathYear` varchar(50) DEFAULT NULL,
  `TrademarkCaseStatus` varchar(50) DEFAULT NULL,
  `TrademarkCaseCloseStatus` varchar(50) DEFAULT NULL,
  `Sales` varchar(50) DEFAULT NULL,
  `ExtendTime` varchar(10) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `TrademarkClassification` varchar(500) DEFAULT NULL,
  `GoodsServices` varchar(2000) DEFAULT NULL,
  `GroupCode` varchar(500) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `AttorneyNo` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `LastSchedule` varchar(200) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `PriorityCaseNo` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `PaymentConfirming` varchar(1) DEFAULT NULL,
  `AutoPay` varchar(1) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  `EnglishTitle` varchar(500) DEFAULT NULL,
  `CaseAssignedTo` varchar(50) DEFAULT NULL,
  `SpecialRequest` varchar(500) DEFAULT NULL,
  `NoSDate` varchar(500) DEFAULT NULL,
  `ContactDate` varchar(50) DEFAULT NULL,
  `Referrals` varchar(50) DEFAULT NULL,
  `TrademarkKind` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkcase`
--

LOCK TABLES `trademarkcase` WRITE;
/*!40000 ALTER TABLE `trademarkcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkcase_2`
--

DROP TABLE IF EXISTS `trademarkcase_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkcase_2` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Office` varchar(50) NOT NULL,
  `TrademarkType` varchar(50) NOT NULL,
  `Title` varchar(500) NOT NULL,
  `AttorneyDate` varchar(10) NOT NULL,
  `AttorneyNum` varchar(50) NOT NULL,
  `FillingDate` varchar(10) NOT NULL,
  `FillingNum` varchar(50) NOT NULL,
  `PublicationDate` varchar(10) NOT NULL,
  `PublicationNum` varchar(50) NOT NULL,
  `RegistDate` varchar(10) NOT NULL,
  `RegistNum` varchar(50) NOT NULL,
  `TrademarkNum` varchar(50) NOT NULL,
  `TrademarkNo` varchar(50) NOT NULL,
  `ExpiryDate` varchar(10) NOT NULL,
  `ExtendDate` varchar(10) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `ClosedDate` varchar(10) NOT NULL,
  `TrademarkImg` varchar(100) NOT NULL,
  `Color` varchar(50) NOT NULL,
  `NoBelongDesc` varchar(500) NOT NULL,
  `ChtWordsinMark` varchar(500) NOT NULL,
  `EngWordsinMark` varchar(500) NOT NULL,
  `JapWordsinMark` varchar(500) NOT NULL,
  `Significance` varchar(500) NOT NULL,
  `GraphDesc` varchar(500) NOT NULL,
  `DesignMark` varchar(100) NOT NULL,
  `TrademarkCaseType` varchar(50) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `MarkType` varchar(50) DEFAULT NULL,
  `ExpiryDateTo` varchar(10) DEFAULT NULL,
  `OathDate` varchar(10) DEFAULT NULL,
  `OathYear` varchar(50) DEFAULT NULL,
  `TrademarkCaseStatus` varchar(50) DEFAULT NULL,
  `TrademarkCaseCloseStatus` varchar(50) DEFAULT NULL,
  `Sales` varchar(50) DEFAULT NULL,
  `ExtendTime` varchar(10) DEFAULT NULL,
  `IssueDate` varchar(10) DEFAULT NULL,
  `IssueNo` varchar(50) DEFAULT NULL,
  `TrademarkClassification` varchar(500) DEFAULT NULL,
  `GoodsServices` varchar(1500) DEFAULT NULL,
  `GroupCode` varchar(500) DEFAULT NULL,
  `ClientContect` varchar(50) DEFAULT NULL,
  `AttorneyNo` varchar(50) DEFAULT NULL,
  `UpdateTime` varchar(20) DEFAULT NULL,
  `Updater` varchar(50) DEFAULT NULL,
  `CreateTime` varchar(20) DEFAULT NULL,
  `Creator` varchar(50) DEFAULT NULL,
  `LastSchedule` varchar(200) DEFAULT NULL,
  `SerialMotherCase` varchar(50) DEFAULT NULL,
  `PriorityCaseNo` varchar(50) DEFAULT NULL,
  `Attorney` varchar(50) DEFAULT NULL,
  `InternalNo` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `PaymentConfirming` varchar(1) DEFAULT NULL,
  `AutoPay` varchar(1) DEFAULT NULL,
  `ServiceProjectCode` varchar(50) DEFAULT NULL,
  `FromCase` varchar(50) DEFAULT NULL,
  `QuotationFlowKey` varchar(50) DEFAULT NULL,
  `CaseNo` varchar(50) DEFAULT NULL,
  `CaseNo2` varchar(50) DEFAULT NULL,
  `CaseAD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkcase_2`
--

LOCK TABLES `trademarkcase_2` WRITE;
/*!40000 ALTER TABLE `trademarkcase_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkcase_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkcategory`
--

DROP TABLE IF EXISTS `trademarkcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkcategory` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `NiceClassification` varchar(50) NOT NULL,
  `GoodsServices` varchar(50) NOT NULL,
  `GroupCode` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkcategory`
--

LOCK TABLES `trademarkcategory` WRITE;
/*!40000 ALTER TABLE `trademarkcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkdocument`
--

DROP TABLE IF EXISTS `trademarkdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkdocument` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `DocumentType` varchar(50) DEFAULT NULL,
  `DocumentUrl` varchar(4000) DEFAULT NULL,
  `DocumentName` varchar(100) DEFAULT NULL,
  `DocumentNo` varchar(50) DEFAULT NULL,
  `DocumentKind` varchar(50) DEFAULT NULL,
  `DocumentDate` varchar(10) DEFAULT NULL,
  `DocumentTarget` varchar(50) DEFAULT NULL,
  `DocumentProcess` varchar(50) DEFAULT NULL,
  `LinkOthers` varchar(1) DEFAULT NULL,
  `Contractor` varchar(50) DEFAULT NULL,
  `ContractorDept` varchar(50) DEFAULT NULL,
  `StandardTask` text,
  `DeadlineDate` varchar(10) DEFAULT NULL,
  `DocumentUnit` varchar(50) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `Amount` float(10,2) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `AccountingType` varchar(50) DEFAULT NULL,
  `Currency` varchar(50) DEFAULT NULL,
  `CaseStatus` varchar(50) DEFAULT NULL,
  `MaintainLinkOthers` varchar(1) DEFAULT NULL,
  `DocumentUrl2` varchar(200) DEFAULT NULL,
  `DocumentUrl3` varchar(200) DEFAULT NULL,
  `DocumentUrl4` varchar(200) DEFAULT NULL,
  `DocumentUrl5` varchar(200) DEFAULT NULL,
  `DocumentUrl6` varchar(200) DEFAULT NULL,
  `DocumentUrl7` varchar(200) DEFAULT NULL,
  `DocumentUrl8` varchar(200) DEFAULT NULL,
  `CcSendType` varchar(50) DEFAULT NULL,
  `CcSendDate` varchar(10) DEFAULT NULL,
  `Receiver` varchar(100) DEFAULT NULL,
  `MailNo` varchar(50) DEFAULT NULL,
  `AttachmentName` varchar(100) DEFAULT NULL,
  `AttachmentName2` varchar(100) DEFAULT NULL,
  `AttachmentName3` varchar(100) DEFAULT NULL,
  `AttachmentName4` varchar(100) DEFAULT NULL,
  `AttachmentName5` varchar(100) DEFAULT NULL,
  `AttachmentName6` varchar(100) DEFAULT NULL,
  `AttachmentName7` varchar(100) DEFAULT NULL,
  `AttachmentName8` varchar(100) DEFAULT NULL,
  `ServiceFee` float(10,2) DEFAULT NULL,
  `ServiceFeeCurrency` varchar(50) DEFAULT NULL,
  `ArFee` float(10,2) DEFAULT NULL,
  `ArFeeCurrency` varchar(50) DEFAULT NULL,
  `ApFee` float(10,2) DEFAULT NULL,
  `ApFeeCurrency` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkdocument`
--

LOCK TABLES `trademarkdocument` WRITE;
/*!40000 ALTER TABLE `trademarkdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkinventor`
--

DROP TABLE IF EXISTS `trademarkinventor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkinventor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `InventorType` varchar(50) NOT NULL,
  `InventorOrder` varchar(50) NOT NULL,
  `ContributionShare` int(11) NOT NULL,
  `Inventor` varchar(50) NOT NULL,
  `InventorName` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkinventor`
--

LOCK TABLES `trademarkinventor` WRITE;
/*!40000 ALTER TABLE `trademarkinventor` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkinventor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkpriority`
--

DROP TABLE IF EXISTS `trademarkpriority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkpriority` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `ParentId` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `PriorityDate` varchar(10) NOT NULL,
  `ApplyNo` varchar(50) NOT NULL,
  `CaseNo` varchar(50) NOT NULL,
  `Document` varchar(100) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkpriority`
--

LOCK TABLES `trademarkpriority` WRITE;
/*!40000 ALTER TABLE `trademarkpriority` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkpriority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trademarkrenewallog`
--

DROP TABLE IF EXISTS `trademarkrenewallog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trademarkrenewallog` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ParentId` varchar(50) DEFAULT NULL,
  `Office` varchar(50) DEFAULT NULL,
  `TrademarkNum` varchar(50) DEFAULT NULL,
  `FillingDate` varchar(10) DEFAULT NULL,
  `Client` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `ExpiryDateTo` varchar(10) DEFAULT NULL,
  `ExtendTime` varchar(50) DEFAULT NULL,
  `PayPeriod` varchar(10) DEFAULT NULL,
  `SurchargeDate` varchar(10) DEFAULT NULL,
  `RenewStatus` varchar(50) DEFAULT NULL,
  `MaintainAttorney` varchar(50) DEFAULT NULL,
  `PtoFee` float(10,3) DEFAULT NULL,
  `PtoCurrency` varchar(50) DEFAULT NULL,
  `PtoExchangeRate` float(10,3) DEFAULT NULL,
  `NtdPtoFee` float(10,3) DEFAULT NULL,
  `PayTransfer` varchar(1) DEFAULT NULL,
  `ServiceFee` float(10,3) DEFAULT NULL,
  `ServiceCurrency` varchar(50) DEFAULT NULL,
  `ServiceExchangeRate` float(10,3) DEFAULT NULL,
  `NtdServiceFee` float(10,3) DEFAULT NULL,
  `PayTransfer2` varchar(1) DEFAULT NULL,
  `AttorneyFee` float(10,3) DEFAULT NULL,
  `AttorneyCurrency` varchar(50) DEFAULT NULL,
  `AttorneyExchangeRate` float(10,3) DEFAULT NULL,
  `NtdAttorneyFee` float(10,3) DEFAULT NULL,
  `OtherFee` float(10,3) DEFAULT NULL,
  `OtherCurrency` varchar(50) DEFAULT NULL,
  `OtherExchangeRate` float(10,3) DEFAULT NULL,
  `NtdOtherFee` float(10,3) DEFAULT NULL,
  `KeepMaintain` varchar(50) DEFAULT NULL,
  `NtdInvoiceAmount` float(10,3) DEFAULT NULL,
  `AddYear` varchar(50) DEFAULT NULL,
  `GiveupReason` varchar(200) DEFAULT NULL,
  `Memo` varchar(400) DEFAULT NULL,
  `StandardTaskKey` varchar(150) DEFAULT NULL,
  `RegistNum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trademarkrenewallog`
--

LOCK TABLES `trademarkrenewallog` WRITE;
/*!40000 ALTER TABLE `trademarkrenewallog` DISABLE KEYS */;
/*!40000 ALTER TABLE `trademarkrenewallog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transationtype`
--

DROP TABLE IF EXISTS `transationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transationtype` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `CanSelectFlag` char(1) DEFAULT NULL,
  `Names` varchar(100) DEFAULT NULL,
  `OutStockId` varchar(50) DEFAULT NULL,
  `InStockId` varchar(50) DEFAULT NULL,
  `CanSelectOutStock` char(1) DEFAULT NULL,
  `CanSelectInStock` char(1) DEFAULT NULL,
  `FlowId` varchar(50) DEFAULT NULL,
  `BeginChar` varchar(20) DEFAULT NULL,
  `EndLength` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transationtype`
--

LOCK TABLES `transationtype` WRITE;
/*!40000 ALTER TABLE `transationtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `transationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripcharge`
--

DROP TABLE IF EXISTS `tripcharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tripcharge` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `DeptSigner1` varchar(50) DEFAULT NULL,
  `DeptSigner2` varchar(50) DEFAULT NULL,
  `BudgetDept` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `BudgetAmount` int(11) DEFAULT NULL,
  `DateFrom` varchar(20) DEFAULT NULL,
  `DateTo` varchar(20) DEFAULT NULL,
  `Days` int(11) DEFAULT NULL,
  `Hours` int(11) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `TaxFlag` char(1) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  `LoanFlag` char(1) DEFAULT NULL,
  `BudgetDate` varchar(10) DEFAULT NULL,
  `BillQty` int(11) DEFAULT NULL,
  `TripType` varchar(50) DEFAULT NULL,
  `CertificateNo` varchar(50) DEFAULT NULL,
  `BudgetControler` varchar(50) DEFAULT NULL,
  `SubjectControler1` varchar(50) DEFAULT NULL,
  `SubjectControler2` varchar(50) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  `Sponsor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripcharge`
--

LOCK TABLES `tripcharge` WRITE;
/*!40000 ALTER TABLE `tripcharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `tripcharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripcharge_detail`
--

DROP TABLE IF EXISTS `tripcharge_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tripcharge_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `Date` varchar(50) DEFAULT NULL,
  `Place` varchar(100) DEFAULT NULL,
  `Charge1` int(11) DEFAULT NULL,
  `Charge2` int(11) DEFAULT NULL,
  `Charge3` int(11) DEFAULT NULL,
  `Charge4` int(11) DEFAULT NULL,
  `Charge5` int(11) DEFAULT NULL,
  `Charge6` int(11) DEFAULT NULL,
  `Charge7` int(11) DEFAULT NULL,
  `Charge8` int(11) DEFAULT NULL,
  `Charge9` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `BillNo` varchar(50) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripcharge_detail`
--

LOCK TABLES `tripcharge_detail` WRITE;
/*!40000 ALTER TABLE `tripcharge_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tripcharge_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uploadfile`
--

DROP TABLE IF EXISTS `uploadfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uploadfile` (
  `path` varchar(200) NOT NULL,
  `filename` varchar(200) NOT NULL,
  PRIMARY KEY (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uploadfile`
--

LOCK TABLES `uploadfile` WRITE;
/*!40000 ALTER TABLE `uploadfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploadfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uploadfiles`
--

DROP TABLE IF EXISTS `uploadfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uploadfiles` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) NOT NULL,
  `Applicant` varchar(50) NOT NULL,
  `Names` varchar(200) NOT NULL,
  `UploadFile` varchar(200) NOT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uploadfiles`
--

LOCK TABLES `uploadfiles` WRITE;
/*!40000 ALTER TABLE `uploadfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploadfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `TelNo` varchar(20) DEFAULT NULL,
  `Fax` varchar(20) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EnterpriseNo` varchar(50) DEFAULT NULL,
  `Bank` varchar(50) DEFAULT NULL,
  `AccountName` varchar(50) DEFAULT NULL,
  `BankAccount` varchar(50) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `VendorType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucherpayment`
--

DROP TABLE IF EXISTS `voucherpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voucherpayment` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `DeptSigner1` varchar(50) DEFAULT NULL,
  `DeptSigner2` varchar(50) DEFAULT NULL,
  `SrcDepartment` varchar(50) DEFAULT NULL,
  `SrcApplicant` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(10) DEFAULT NULL,
  `GoodsApplyNo` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `WorkPlan` varchar(50) DEFAULT NULL,
  `BudgetType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Vendor` varchar(50) DEFAULT NULL,
  `DocUrl` varchar(100) DEFAULT NULL,
  `BudgetAmount` int(11) DEFAULT NULL,
  `TaxFlag` char(1) DEFAULT NULL,
  `TaxAmount` int(11) DEFAULT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `KeeperFlag` char(1) DEFAULT NULL,
  `BudgetDate` varchar(10) DEFAULT NULL,
  `SubjectControler` varchar(50) DEFAULT NULL,
  `InfosSponsor` varchar(50) DEFAULT NULL,
  `Seq_no` int(11) DEFAULT NULL,
  `KeepSponsor` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucherpayment`
--

LOCK TABLES `voucherpayment` WRITE;
/*!40000 ALTER TABLE `voucherpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `voucherpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waittostorage`
--

DROP TABLE IF EXISTS `waittostorage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waittostorage` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `ApplyTime` varchar(20) DEFAULT NULL,
  `StockId` varchar(50) DEFAULT NULL,
  `ProductNo` varchar(50) DEFAULT NULL,
  `BatchNo` varchar(50) DEFAULT NULL,
  `SeparatelyQty` int(11) DEFAULT NULL,
  `SeparatelyUnit` varchar(20) DEFAULT NULL,
  `WaitToCheckUnit` varchar(20) DEFAULT NULL,
  `WaitToCheckQty` int(11) DEFAULT NULL,
  `SpotCheckQty` int(11) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `TotalQty` int(11) DEFAULT NULL,
  `SpotCheckDate` varchar(10) DEFAULT NULL,
  `QualifiedDate` varchar(10) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waittostorage`
--

LOCK TABLES `waittostorage` WRITE;
/*!40000 ALTER TABLE `waittostorage` DISABLE KEYS */;
/*!40000 ALTER TABLE `waittostorage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekbalance`
--

DROP TABLE IF EXISTS `weekbalance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weekbalance` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  `Dancer` varchar(50) DEFAULT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `DancerType` varchar(50) DEFAULT NULL,
  `SecondCumulative` int(11) DEFAULT NULL,
  `FirstCumulative` int(11) DEFAULT NULL,
  `OtherCumulative` int(11) DEFAULT NULL,
  `SecondUnit` double DEFAULT NULL,
  `FirstUnit` double DEFAULT NULL,
  `OtherUnit` double DEFAULT NULL,
  `SecondAmount` int(11) DEFAULT NULL,
  `FirstAmount` int(11) DEFAULT NULL,
  `OtherAmount` int(11) DEFAULT NULL,
  `SecondBonus` int(11) DEFAULT NULL,
  `SecondTotal` int(11) DEFAULT NULL,
  `FirstTotal` int(11) DEFAULT NULL,
  `OtherTotal` int(11) DEFAULT NULL,
  `SecondTotalUnit` double DEFAULT NULL,
  `FirstTotalUnit` double DEFAULT NULL,
  `OtherTotalUnit` double DEFAULT NULL,
  `SecondTotalAmount` int(11) DEFAULT NULL,
  `FirstTotalAmount` int(11) DEFAULT NULL,
  `OtherTotalAmount` int(11) DEFAULT NULL,
  `SecondTotalBonus` int(11) DEFAULT NULL,
  `DeductTotal` int(11) DEFAULT NULL,
  `TotalAmount` int(11) DEFAULT NULL,
  `DanceMemo` varchar(255) DEFAULT NULL,
  `DeductMemo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekbalance`
--

LOCK TABLES `weekbalance` WRITE;
/*!40000 ALTER TABLE `weekbalance` DISABLE KEYS */;
/*!40000 ALTER TABLE `weekbalance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workplan`
--

DROP TABLE IF EXISTS `workplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workplan` (
  `FlowKey` varchar(50) NOT NULL,
  `CreateDept` varchar(50) DEFAULT NULL,
  `Applicant` varchar(50) DEFAULT NULL,
  `Names` varchar(200) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `Leader` varchar(50) DEFAULT NULL,
  `AccountingYear` varchar(50) DEFAULT NULL,
  `PlanType` varchar(50) DEFAULT NULL,
  `BusinessPlan` varchar(50) DEFAULT NULL,
  `BudgetAmount` int(11) DEFAULT NULL,
  `DateFrom` varchar(10) DEFAULT NULL,
  `DateTo` varchar(10) DEFAULT NULL,
  `ControlFlag` char(1) DEFAULT NULL,
  `CanUseDept` varchar(200) DEFAULT NULL,
  `Memo` varchar(200) DEFAULT NULL,
  `BudgetControler` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workplan`
--

LOCK TABLES `workplan` WRITE;
/*!40000 ALTER TABLE `workplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `workplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workplan_detail`
--

DROP TABLE IF EXISTS `workplan_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workplan_detail` (
  `FlowKey` varchar(50) NOT NULL,
  `Seq_no` int(11) NOT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `ControlFlag` char(1) DEFAULT NULL,
  PRIMARY KEY (`FlowKey`,`Seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workplan_detail`
--

LOCK TABLES `workplan_detail` WRITE;
/*!40000 ALTER TABLE `workplan_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `workplan_detail` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Temporary table structure for view `all_cases`
--
DROP TABLE IF EXISTS `all_cases`;
DROP VIEW IF EXISTS `all_cases`;
CREATE TABLE `all_cases` (
  `FlowKey` varchar(50),
  `CaseNo` varchar(50),
  `CaseNo2` varchar(50),
  `title` varchar(500),
  `patenttype` varchar(50),
  `Status` varchar(50),
  `casekind` varchar(1),
  `applydate` varchar(10),
  `casestartdate` varchar(50)
);

--
-- Temporary table structure for view `patentcaseinternal`
--
DROP TABLE IF EXISTS `patentcaseinternal`;
DROP VIEW IF EXISTS `patentcaseinternal`;
CREATE TABLE `patentcaseinternal` (
  `FlowKey` varchar(50),
  `CreateDept` varchar(50),
  `Applicant` varchar(50),
  `CreateTime` varchar(20),
  `Summary` varchar(200),
  `IdeaId` varchar(50),
  `FamilyOrder` varchar(50),
  `Client` varchar(50),
  `PatentOffice` varchar(50),
  `PatentType` varchar(50),
  `Title` varchar(500),
  `OriginalTitle` varchar(500),
  `ApplyDate` varchar(10),
  `ApplyNo` varchar(50),
  `PublishDate` varchar(10),
  `PublishNo` varchar(50),
  `Status` varchar(50),
  `GiveupCode` varchar(50),
  `InCharge` varchar(50),
  `OutsourceDate` varchar(10),
  `SignOutId` varchar(50),
  `SignOutTime` varchar(20),
  `UpdateTime` varchar(20),
  `Updater` varchar(50),
  `Creator` varchar(50),
  `SignOutName` varchar(50),
  `CaseType` varchar(50),
  `LicenseDate` varchar(10),
  `LicenseNo` varchar(50),
  `FeeScheduleDate` varchar(10),
  `FeeSchedule` float(10,1),
  `ProjectCode` varchar(50),
  `Keyword` varchar(50),
  `TechCategory` varchar(50),
  `FuncCategory` varchar(50),
  `Ipc` varchar(500),
  `Uspc` varchar(500),
  `Fi` varchar(500),
  `Locarno` varchar(500),
  `Gattezz` varchar(50),
  `ExamineDate` varchar(10),
  `RightBeginDate` varchar(10),
  `RightEndDate` varchar(10),
  `PctAppDate` varchar(10),
  `PctAppNo` varchar(50),
  `PctPublishDate` varchar(10),
  `WipoNo` varchar(50),
  `NationalPhaseDate` varchar(10),
  `IssueDate` varchar(10),
  `IssueNo` varchar(50),
  `ExamineDueDate` varchar(10),
  `TechReportApply` char(1),
  `IndependentClaim` int(11),
  `DependentClaim` int(11),
  `Drawing` int(11),
  `TotalPage` int(11),
  `CaseStartDate` varchar(20)
);



-- Dump completed on 2020-05-17  0:16:41
