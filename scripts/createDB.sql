drop database if exists social;
create database social;
use social;
create table Node (nodeId bigint not null auto_increment, primary key(nodeId));
create table Edge (edgeId bigint not null auto_increment, fromNode bigint not null, toNode bigint not null, primary key(edgeId) , foreign key (fromNode) references Node(nodeId), foreign key (toNode) references Node(nodeId));
create table Attribute (attId bigint not null auto_increment, name varchar(255) not null, val varchar(255) not null, primary key (attId));
create table NodeHasAtt (nodeId bigint not null, attId bigint not null, primary key (nodeId, attId), foreign key (nodeId) references Node(nodeId), foreign key (attId) references Attribute(attId));
create table EdgeHasAtt (edgeId bigint not null, attId bigint not null, primary key (edgeId, attId), foreign key (edgeId) references Edge(edgeId), foreign key (attId) references Attribute(attId));
create index NAIndex on NodeHasAtt(nodeId);
create index EAIndex on EdgeHasAtt(edgeId);
create index AttributeNameIndex on Attribute(name);
insert into Attribute(name, val) values ("type","user");
insert into Attribute(name, val) values ("type","tweet");
insert into Attribute(name, val) values ("type","list");
insert into Attribute(name, val) values ("type","follow");
insert into Attribute(name, val) values ("type","belongToList");
insert into Attribute(name, val) values ("type","tweeted");
insert into Attribute(name, val) values ("type","retweeted");
insert into Attribute(name, val) values ("type","favorite");