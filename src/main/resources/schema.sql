CREATE SCHEMA IF NOT EXISTS vmware
    AUTHORIZATION postgres;

create table vmware.person (id bigint not null, name varchar(255), primary key (id));

DROP SEQUENCE IF EXISTS vmware.person_seq;

CREATE SEQUENCE IF NOT EXISTS vmware.person_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE vmware.person_seq
    OWNER TO postgres;

------------------------------------------------------------------------------
------------------------------------------------------------------------------
------------------------------------------------------------------------------
CREATE SCHEMA IF NOT EXISTS pivotal
    AUTHORIZATION postgres;

create table pivotal.person (id bigint not null, name varchar(255), primary key (id));

DROP SEQUENCE IF EXISTS pivotal.person_seq;

CREATE SEQUENCE IF NOT EXISTS pivotal.person_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE pivotal.person_seq
    OWNER TO postgres;