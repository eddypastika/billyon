create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create table stores
(
	id bigint not null
		constraint lst_store_pkey
			primary key,
	created_dt timestamp not null,
	updated_dt timestamp not null,
	address varchar(200) not null,
	email varchar(50) not null,
	latitude varchar(15),
	longitude varchar(15),
	store_name varchar(30) not null,
	store_phone varchar(15) not null,
	store_type varchar(30) not null,
	user_id bigint not null,
	is_active integer not null
);

alter table stores owner to postgres;

create table user_role
(
	id smallint not null
		constraint users_role_pkey
			primary key,
	role_name text not null,
	updated_dt timestamp not null,
	created_dt timestamp not null,
	is_active smallint not null
);

alter table user_role owner to postgres;

create table user_menu
(
	id integer not null
		constraint users_menu_pkey
			primary key,
	menu_name text not null,
	updated_dt timestamp not null,
	created_dt timestamp not null,
	is_active smallint not null
);

alter table user_menu owner to postgres;

create table users
(
	id bigint not null
		constraint users_pkey
			primary key,
	email varchar(100) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	phone varchar(20) not null,
	address varchar(220),
	role_id smallint
		constraint users_users_role_id_fk
			references user_role
				on update cascade,
	password varchar(30) not null,
	created_dt timestamp not null,
	updated_dt timestamp not null,
	is_active smallint default 1 not null
);

alter table users owner to postgres;

create unique index users_email_uindex
	on users (email);

create table user_role_menu
(
	role_id smallint not null
		constraint users_role_menu_role_id_fkey
			references user_role
				on update cascade on delete restrict,
	menu_id smallint not null,
	updated_dt timestamp not null,
	created_dt timestamp not null,
	is_active smallint not null
);

alter table user_role_menu owner to postgres;

create table category
(
	id bigint not null
		constraint category_pkey
			primary key,
	category_name text not null,
	image_path text not null,
	store_id integer not null,
	created_dt timestamp not null,
	updated_dt timestamp not null,
	is_active smallint not null
);

alter table category owner to postgres;

create table products
(
	id bigint not null
		constraint products_pkey
			primary key,
	store_id bigint not null,
	category_id bigint not null
		constraint fk_category_product
			references category
				on delete cascade,
	image_path text not null,
	name text not null,
	stock integer not null,
	min_stock integer not null,
	display_price integer not null,
	actual_price integer not null,
	is_active smallint not null,
	created_dt timestamp not null,
	updated_dt timestamp not null
);

alter table products owner to postgres;

