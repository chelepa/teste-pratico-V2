CREATE TABLE juros_multas(
	ID int NOT NULL,
    DAYS_OF_DELAY varchar(255) NOT NULL,
    ADDITION varchar(10) NOT NULL,
    INTEREST_PER_DAY varchar(10) NOT NULL,
    PRIMARY KEY (ID)
);