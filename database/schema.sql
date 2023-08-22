drop table if exists users;
create table users (
  username varchar(255),
  password varchar(255),
  enabled boolean,
  primary key (username)
);
DROP TABLE IF EXISTS AUTHORITIES;
create table authorities (
  username varchar(255),
  authority varchar(255),
  constraint fk_authorities_users foreign key(username) references users(username)
);