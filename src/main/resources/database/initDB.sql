CREATE TABLE IF NOT EXISTS clients
(
    id  BIGINT SERIAL PRIMARY KEY,
    name VARCHAR(50)   NOT NULL,
    legaladdress  VARCHAR(100)  NOT NULL,
    role VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS managers
(
    id  BIGINT SERIAL PRIMARY KEY,
    telephone VARCHAR(50)   NOT NULL,
    lastname  VARCHAR(100)  NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    deputy VARCHAR(50)   NOT NULL,
    clients_id int not null,
    FOREIGN KEY (clients_id) REFERENCES clients (Id)
);