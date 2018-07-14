drop table IF exists boottest.testtable ;

CREATE TABLE IF NOT EXISTS boottest.testtable (
id int not null auto_increment,
  US VARCHAR(200) NOT NULL,
  PRIv VARCHAR(20)   NOT NULL,
  PRIMARY KEY (id)
);