/*
DB Schema
Product(ID, name, description, price, isActive);
Category(ID, name);
ProductsInCategory(ID, name);
Customer(ID, firstName, lastName, email); -- Admin
Orders(ID, customerID, datePlaced);
OrderItems(Id, orderID, productID, productTotal);
*/

CREATE TABLE Product (
    ID SERIAL,
    name VARCHAR(40) NOT NULL,
    price VARCHAR(18),
    summary Varchar(200),
    description VARCHAR(10000),
    image varchar(200),
    -- isActive BOOLEAN DEFAULT true,

    PRIMARY KEY (Id)
);


CREATE TABLE Category (
    ID SERIAL,
    name VARCHAR(40) NOT NULL,
    parent VARCHAR(20), -- parent or child?

    PRIMARY KEY (Id)
);

CREATE TABLE Products_In_Category (
    -- ID SERIAL, -- Is this needed?
    product_ID SERIAL, -- productID
    category_ID SERIAL,

    -- PRIMARY KEY (Id),
    FOREIGN KEY (product_ID) REFERENCES Product(ID),
    FOREIGN KEY (category_ID) REFERENCES Category(ID)
);

 CREATE TABLE Orders (
     ID serial,
     datePlaced TIMESTAMP NOT NULL,
     productID VARCHAR(18) NOT NULL,
     productname VARCHAR(30),
     price VARCHAR(30),

     PRIMARY KEY (Id)
 );

 CREATE TABLE Refund (
 	RefundID SERIAL,
 	ordernumber VARCHAR(18),
 	ProductName VARChAR(30),
 	reason VARCHAR(500),

 	PRIMARY KEY (RefundID)
 	);


 CREATE TABLE Review (
 	ID serial,
 	productid VARCHAR(18),
 	userid varchar(18),
 	comment varchar(50),

 	primary key (id)
 	);

 CREATE TABLE Customer (
 	ID SERIAL,
 	username VARCHAR(20) NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	email VARCHAR(50),

	CONSTRAINT uniqueEmail UNIQUE(email),
	PRIMARY KEY (ID)
);


 CREATE TABLE Cart (
    cart_ID SERIAL,
    customer_ID SERIAL,
    total_price VARCHAR(18),

    PRIMARY KEY (cart_ID),
    FOREIGN KEY (customer_ID) REFERENCES Customer(ID)
);

 CREATE TABLE Cart_Products (
    cart_ID SERIAL,
    product_ID SERIAL,

    FOREIGN KEY (cart_ID) REFERENCES Cart(cart_ID),
    FOREIGN KEY (product_ID) REFERENCES Product(ID)
);

