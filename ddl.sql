-- Create the database.
create database if not exists cs4370_mb_platform_final;

-- Use the created database.
use cs4370_mb_platform_final;

/* Create Supplier Table */
CREATE TABLE `Supplier` (
  `Vendorid` int AUTO_INCREMENT PRIMARY KEY,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255),
  `Phone` varchar(255),
  `StreetAddress1` varchar(255) NOT NULL,
  `StreetAddress2` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Zip_PostalCode` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL UNIQUE
);


/* Create Stock Table */
CREATE TABLE `Stock` (
  `Itemid` int AUTO_INCREMENT PRIMARY KEY,
  `PartNumber` varchar(255) NOT NULL UNIQUE,
  `PartDescription` varchar(255),
  `active` boolean NOT NULL,
  `ItemCost` decimal(10,2),
  `ItemCurrencyCode` varchar(255) DEFAULT 'USD',
  `Length` decimal(10,2),
  `Width` decimal(10,2),
  `Height` decimal(10,2),
  `DimensionUOM` varchar(255) DEFAULT 'IN',
  `Weight` decimal(10,2),
  `WeightUOM` varchar(255) DEFAULT 'LB',
  `Quantity` int
);

/* Create Operator Table */
CREATE TABLE `Operator` (
  `Employeeid` int AUTO_INCREMENT PRIMARY KEY,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Wages` decimal(10,2),
  `Type` varchar(255),
  `Email` varchar(255),
  `Phone` varchar(255),
  `StreetAddress1` varchar(255),
  `StreetAddress2` varchar(255),
  `City` varchar(255),
  `State` varchar(255),
  `Country` varchar(255),
  `Zip_PostalCode` varchar(255),
  UNIQUE (`UserName`)
);

/* Create ReplenishmentOrder Table */
CREATE TABLE `ReplenishmentOrder` (
  `ASNorderid` int AUTO_INCREMENT PRIMARY KEY,
  `CreatedByid` int NOT NULL,
  `ASNItemid` int NOT NULL,
  `Quantity` int NOT NULL,
  `ETADate` datetime,
  `CarrierName` varchar(255),
  `AirWayBillNumber` varchar(255),
  `Status` varchar(255) NOT NULL,
  `ReceivedByid` int,
  `ReceiptDate` datetime,
  `PutAwayAisle` varchar(255),
  `PutAwayBin` varchar(255),
  FOREIGN KEY (`CreatedByid`) REFERENCES `Supplier` (`Vendorid`),
  FOREIGN KEY (`ASNItemid`) REFERENCES `Stock` (`Itemid`),
  FOREIGN KEY (`ReceivedByid`) REFERENCES `Operator` (`Employeeid`)
);

/* Create EndUser Table */
CREATE TABLE `EndUser` (
  `Userid` int AUTO_INCREMENT PRIMARY KEY,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255),
  `Phone` varchar(255),
  `StreetAddress1` varchar(255) NOT NULL,
  `StreetAddress2` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Zip_PostalCode` varchar(255) NOT NULL
);

/* Create Partner Table */
CREATE TABLE `Partner` (
  `Partnerid` int AUTO_INCREMENT PRIMARY KEY,
  `Partnername` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `StreetAddress1` varchar(255) NOT NULL,
  `StreetAddress2` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Zip_PostalCode` varchar(255) NOT NULL
);

/* Create Carrier Table */
CREATE TABLE `Carrier` (
  `Carrierid` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255),
  `SLA` varchar(255),
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255),
  `Phone` varchar(255) NOT NULL,
  `StreetAddress1` varchar(255) NOT NULL,
  `StreetAddress2` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Zip_PostalCode` varchar(255) NOT NULL
);

/* Create ShippingOrder Table */
CREATE TABLE `ShippingOrder` (
  `ShippingOrderid` int AUTO_INCREMENT PRIMARY KEY,
  `SLA` varchar(255),
  `Status` varchar(255) NOT NULL,
  `ShipToUserid` int NOT NULL,
  `ShippingItemid` int NOT NULL,
  `Quantity` int NOT NULL,
  `ETADate` datetime,
  `CreatedByid` int NOT NULL,
  `FulfilledBy` int,
  `FulfilledDate` datetime,
  `Packing` varchar(255),
  `PackageLength` decimal(10,2),
  `PackageWidth` decimal(10,2),
  `PackageHeight` decimal(10,2),
  `PackageDimensionUOM` varchar(255) DEFAULT 'IN',
  `PackageWeight` decimal(10,2),
  `PackageWeightUOM` varchar(255) DEFAULT 'LB',
  `Carrierid` int,
  `CarrierSLA` varchar(255),
  `AWB` varchar(255),
  `RAWB` varchar(255),
  FOREIGN KEY (`ShipToUserid`) REFERENCES `EndUser` (`Userid`),
  FOREIGN KEY (`CreatedByid`) REFERENCES `Partner` (`Partnerid`),
  FOREIGN KEY (`Carrierid`) REFERENCES `Carrier` (`Carrierid`),
  FOREIGN KEY (`ShippingItemid`) REFERENCES `Stock` (`Itemid`),
  FOREIGN KEY (`FulfilledBy`) REFERENCES `Operator` (`Employeeid`)
);
