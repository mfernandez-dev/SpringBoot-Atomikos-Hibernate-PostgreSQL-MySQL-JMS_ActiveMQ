CREATE TABLE public.direccion (
	id bigserial NOT NULL,
	calle varchar NULL,
	numero int NULL,
	ciudad varchar NULL,
	CONSTRAINT direccion_pk PRIMARY KEY (id)
);
