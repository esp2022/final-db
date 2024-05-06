-- View Stock of particlular partnumber ('WIC-2A/S=') available to ship

SELECT SUM(RO.`Quantity`) AS TotalQuantity
FROM
    `Stock` S,
    `ReplenishmentOrder` RO
WHERE
    S.`PartNumber` = 'WIC-2A/S='
    AND S.`Itemid` = RO.`ASNItemid`
    AND RO.`Status` = 'PutAway';

-- Find out who received a Particular Replenishment Order (1)

SELECT   O.`FirstName`, O.`LastName`
FROM
    `ReplenishmentOrder` RO ,
    `Operator` O
WHERE
    RO.`ASNorderid` = 1
    AND O.`Employeeid` = RO.`ReceivedByid`;

-- Find whom to reachout on the carrier side if my Incoming Shipment is delayed for a particular Replenishment Order (1)

SELECT   C.`FirstName`, C.`LastName`, C.`Email` , C.`Phone` , C.`name`
FROM
    `ReplenishmentOrder` RO ,
    `Carrier` C
WHERE
    RO.`ASNorderid` = 1
    AND C.`Carrierid` = RO.`InboundCarrierid`


-- Proccess and Order 3 steps 

-- Select ReplenishmentOrder Status for a Particular Replenishment Order (1)

SELECT `Status` FROM `ReplenishmentOrder` WHERE ASNorderid = '1'

-- Update ReplenishmentOrder Status for a Particular Replenishment Order (1)

UPDATE `ReplenishmentOrder` SET `Status` = 'ReceivedOk' WHERE `ASNorderid` = '1'

-- Update ReplenishmentOrder Status for a Particular Replenishment Order (1)
UPDATE `ReplenishmentOrder` SET `Status` = 'PutAway', `PutAwayAisle` = 'A', `PutAwayBin` = '10' WHERE `ASNorderid` = 1
