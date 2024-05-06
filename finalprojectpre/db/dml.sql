-- Carrier Table Data
INSERT INTO `Carrier` (`name`, `SLA`, `FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`)
VALUES ('AEROSOFT CARGAS AEREAS LTDA', '', 'Alexandra', 'Allan', 'Alexandra.Allan@gmail.com', '9876543211', '7635 Griffin Circle', 'N/A', 'SAO-SAO PAULO', 'SP', 'BR', '1311100');
INSERT INTO `Carrier` (`name`, `SLA`, `FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`)
VALUES ('A R SERVICOS DE ENTREGA S/C LTDA ME', '', 'Alison', 'Alsop', 'Alison.Alsop@gmail.com', '9876543212', '62 Meadow Court', 'N/A', 'SAO-SAO PAULO', 'SP', 'BR', '5802140');

-- Partner Table Data
INSERT INTO `Partner` (`Partnername`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`)
VALUES ('CISCO', 'contact@cisco.com', '(416) 306-7000', '170 West Tasman Dr.', 'N/A', 'San Jose', 'CA', 'US', '95134');

INSERT INTO `Partner` (`Partnername`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`)
VALUES ('INTEL', 'email@intel.com', '877-811-2574', '2200 Mission College Blvd', 'N/A', 'Santa Clara', 'CA', 'US', '95052');

-- Store Table Data
INSERT INTO `Stock` (`PartNumber`, `PartDescription`, `active`, `ItemCost`, `ItemCurrencyCode`, `Length`, `Width`, `Height`, `DimensionUOM`, `Weight`, `WeightUOM`, `Quantity`)
VALUES ('4OC3/ATM-MM-SC=', '4 PORT OC3/STM1 MULTIMODE ATM LINE CARD,', true, 14740.32, 'USD', NULL, NULL, NULL, '', NULL, '', 0);

INSERT INTO `Stock` (`PartNumber`, `PartDescription`, `active`, `ItemCost`, `ItemCurrencyCode`, `Length`, `Width`, `Height`, `DimensionUOM`, `Weight`, `WeightUOM`, `Quantity`)
VALUES ('MEM-1X8F-DFB=', '8MB FLASH SIMM (DUAL FLASH BANK) SPARE', true, 245, 'USD', NULL, NULL, NULL, '', NULL, '', 0);

INSERT INTO `Stock` (`PartNumber`, `PartDescription`, `active`, `ItemCost`, `ItemCurrencyCode`, `Length`, `Width`, `Height`, `DimensionUOM`, `Weight`, `WeightUOM`, `Quantity`)
VALUES ('MEM-381-1X16F=', '16MB FLASH MEMORY FOR MC3810 (SPARE)', true, 350, 'USD', NULL, NULL, NULL, '', NULL, '', 0);

INSERT INTO `Stock` (`PartNumber`, `PartDescription`, `active`, `ItemCost`, `ItemCurrencyCode`, `Length`, `Width`, `Height`, `DimensionUOM`, `Weight`, `WeightUOM`, `Quantity`)
VALUES ('SA6-COOLING=', 'SA6-COOLING=', true, 0, 'USD', NULL, NULL, NULL, '', NULL, '', 0);

INSERT INTO `Stock` (`PartNumber`, `PartDescription`, `active`, `ItemCost`, `ItemCurrencyCode`, `Length`, `Width`, `Height`, `DimensionUOM`, `Weight`, `WeightUOM`, `Quantity`)
VALUES ('WIC-2A/S=', '2-Port Async/Sync Serial WAN Interface Card Spare', true, 175, 'USD', NULL, NULL, NULL, '', NULL, '', 0);


-- Supplier Table Data

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Abigail', 'Abraham', 'Abigail.Abraham@gmail.com', '9087654321', '7635 Griffin Circle', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'Grant - Morar');

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Alexandra', 'Allan', 'Alexandra.Allan@gmail.com', '9087654322', '878 Cobblestone Drive', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'Hammes, Kerluke and Lubowitz');

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Alison', 'Alsop', 'Alison.Alsop@gmail.com', '9087654323', '62 Meadow Court', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'Huels Inc');

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Amanda', 'Anderson', 'Amanda.Anderson@gmail.com', '9087654324', '62 Meadow Court', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'McCullough - VonRueden');

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Amelia', 'Arnold', 'Amelia.Arnold@gmail.com', '9087654325', '78 Depot Avenue', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'Simonis and Sons');

INSERT INTO `Supplier` (`FirstName`, `LastName`, `Email`, `Phone`, `StreetAddress1`, `StreetAddress2`, `City`, `State`, `Country`, `Zip_PostalCode`, `company`)
VALUES ('Amy', 'Avery', 'Amy.Avery@gmail.com', '9087654326', '78 Walnutwood Ave.', 'N/A', 'Louisville', 'KY', 'US', 'N/A', 'Weber, Grady and Greenfelder');
