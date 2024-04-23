CREATE SEQUENCE pessoas_seq
    INCREMENT 1
    START 1
    MINVALUE 1;
   
CREATE SEQUENCE skill_seq
    INCREMENT 1
    START 1
    MINVALUE 1;

CREATE SEQUENCE pessoa_skill_seq
    INCREMENT 1
    START 1
    MINVALUE 1;

create table pessoas(
	id_pessoa integer primary key default nextval('pessoas_seq'),
	nome_pesoa varchar(50) not null,
	login varchar(20) unique not null,
	senha varchar(16) not null
);

create table skills(
	id_skill integer primary key default nextval('skill_seq'),	
	nome_skill varchar(50) unique not null
);

create table pessoa_skill(
	id_pessoa_skill integer primary key default nextval('pessoa_skill_seq'),
	id_pessoa_f_key integer not null,
	id_skill_f_key integer not null,
	foreign key (id_pessoa_f_key) references pessoas(id_pessoa),
    foreign key (id_skill_f_key) references skills(id_skill),
	nivel varchar(20) not null
);