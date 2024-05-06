select * from Operator where UserName = ?
/**
Used for authenticating user given the username and the password and for later
storing user object for the logged in user in session scope.*/

select FirstName , LastName from Operator where Employeeid = ?

/* Fetches the first and last names of an operator based on their unique employee 
ID. Used for displaying personal information*/

insert into Operator (UserName, Password, FirstName, LastName) values (?, ?, ?, ?)

/*Registers a new user with the given details.*/

INSERT INTO ReplenishmentOrder (ReceivedByid,CreatedByid, 3PLPartnerid, InboundCarrierid, ASNItemid, Quantity, ETADate, AirWayBillNumber, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)

/*Inserts a new record into the ReplenishmentOrder table. It includes values for who
received and created the order, details about the third-party logistics (3PL)
partner and carrier, as well as specifics about the item being replenished, the quantity,
estimated time of arrival (ETA), airway bill number, and current status. 
Used for managing inventory and tracking the order status.*/