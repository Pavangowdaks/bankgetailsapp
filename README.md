# BankDetails
REST Service for getting bank details by IFSC code, BankName and CIty.

Deployed on Heroku: Link: https://bankdetailsapp.herokuapp.com/

GET request: To get the Bank Details  by IFSC code of Bank.

URL : http://localhost:8899/getBankDetailsByIfsc/{IFSC}

GET request: To get the Bank Details by Bank name.

URL : http://localhost:8899/getBankDetailsByName/{bankname}

GET request: To get the Bank Details by Bank city name.

URL : http://localhost:8899/getBankDetailsByCity/{city}

GET request: To get the Bank Details by Bank name and Bank Ctiy.

URL : http://localhost:8899/getBankDetailsByName/{bankname}/City/{city}

#CSV Dump

See bank.csv file. If you prefer a PostgreSQL dump for building a REST service or some such, look at the IndianBanks.sql file.

#PostgreSQL tables with IFSC codes of bank branches.

The SQL has two table and one view.

banks - has two columns id and name (e.g. KARNATAKA BANK LIMITED).

branches - has details of all branches. IFSC code is the primary key of this table. Has bankid which is a foreign key reference into banks table.

bankbranches - view on top of these tables that joins on bankid. Convenient if you want to search by bank name.

CREATE TABLE banks (
    name character varying(49),
    id bigint NOT NULL
);


CREATE TABLE branches (
    ifsc character varying(11) NOT NULL,
    bankid bigint,
    branch character varying(74),
    address character varying(195),
    city character varying(50),
    district character varying(50),
    state character varying(26)
);


CREATE VIEW bank_branches AS
 SELECT branches.ifsc,
    branches.bankid,
    branches.branch,
    branches.address,
    branches.city,
    branches.district,
    branches.state,
    banks.name AS bankname
   FROM (branches
     JOIN banks ON ((branches.bankid = banks.id)));
