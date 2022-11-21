CREATE TABLE IF NOT EXISTS test_db
(
    id BIG-SERIAL PRIMARY KEY ,
    short_url  VARCHAR(200) NOT NULL ,
    long_url VARCHAR(0500) NOT NULL,

    CONSTRAINT unique_fields UNIQUE (short_url, long_url)
);