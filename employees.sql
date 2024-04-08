CREATE DATABASE employees-demo;

CREATE TABLE public.employees
(
    id character varying(45) NOT NULL DEFAULT gen_random_uuid(),
    first_name character varying(200) NOT NULL,
    last_name character varying(200) NOT NULL,
    email character varying(256) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.employees
    OWNER to postgres;