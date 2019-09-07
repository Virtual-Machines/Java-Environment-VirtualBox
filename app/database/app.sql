--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)

-- Started on 2019-08-28 21:30:07 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16385)
-- Name: t_authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_authority (
    aut_id bigint NOT NULL,
    aut_user bigint NOT NULL,
    aut_role bigint NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.t_authority OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16388)
-- Name: authorities_aut_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authorities_aut_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authorities_aut_id_seq OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 197
-- Name: authorities_aut_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.authorities_aut_id_seq OWNED BY public.t_authority.aut_id;


--
-- TOC entry 201 (class 1259 OID 32818)
-- Name: m_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_role (
    rol_id bigint NOT NULL,
    rol_code character varying(50) NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.m_role OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16390)
-- Name: m_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_user (
    usr_id bigint NOT NULL,
    usr_username character varying(50) NOT NULL,
    usr_password character varying(100) NOT NULL,
    usr_enabled boolean NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.m_user OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 32816)
-- Name: role_rol_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_rol_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_rol_id_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_rol_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_rol_id_seq OWNED BY public.m_role.rol_id;


--
-- TOC entry 199 (class 1259 OID 16393)
-- Name: users_usr_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_usr_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_usr_id_seq OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 199
-- Name: users_usr_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_usr_id_seq OWNED BY public.m_user.usr_id;


--
-- TOC entry 2804 (class 2604 OID 32821)
-- Name: m_role rol_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_role ALTER COLUMN rol_id SET DEFAULT nextval('public.role_rol_id_seq'::regclass);


--
-- TOC entry 2802 (class 2604 OID 16396)
-- Name: m_user usr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_user ALTER COLUMN usr_id SET DEFAULT nextval('public.users_usr_id_seq'::regclass);


--
-- TOC entry 2800 (class 2604 OID 16395)
-- Name: t_authority aut_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_authority ALTER COLUMN aut_id SET DEFAULT nextval('public.authorities_aut_id_seq'::regclass);


--
-- TOC entry 2946 (class 0 OID 32818)
-- Dependencies: 201
-- Data for Name: m_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.m_role VALUES (2, 'USER', false);
INSERT INTO public.m_role VALUES (1, 'ADMIN', false);


--
-- TOC entry 2943 (class 0 OID 16390)
-- Dependencies: 198
-- Data for Name: m_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.m_user VALUES (1, 'admin', '$2a$10$gFXDQgSUh0nCcT6mkiCBJuINafBbnRZWZ5RB.LIJ56piYu5ROsPmG', true, false);
INSERT INTO public.m_user VALUES (2, 'user', '$2a$10$TpBtRgLLKh0LSVe5AnCdEeZIY0YHx/8bk.qOjqlc3BHDltH8ly/ki', true, false);


--
-- TOC entry 2941 (class 0 OID 16385)
-- Dependencies: 196
-- Data for Name: t_authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.t_authority VALUES (1, 1, 1, false);
INSERT INTO public.t_authority VALUES (2, 2, 2, false);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 197
-- Name: authorities_aut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authorities_aut_id_seq', 8, true);


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_rol_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_rol_id_seq', 2, true);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 199
-- Name: users_usr_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_usr_id_seq', 8, true);


--
-- TOC entry 2807 (class 2606 OID 32856)
-- Name: t_authority authority_aut_user_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_authority
    ADD CONSTRAINT authority_aut_user_role UNIQUE (aut_user, aut_role);


--
-- TOC entry 2809 (class 2606 OID 32854)
-- Name: t_authority authority_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_authority
    ADD CONSTRAINT authority_pk PRIMARY KEY (aut_id);


--
-- TOC entry 2815 (class 2606 OID 32825)
-- Name: m_role role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_role
    ADD CONSTRAINT role_pk PRIMARY KEY (rol_id);


--
-- TOC entry 2817 (class 2606 OID 32823)
-- Name: m_role role_rol_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_role
    ADD CONSTRAINT role_rol_code_key UNIQUE (rol_code);


--
-- TOC entry 2811 (class 2606 OID 32850)
-- Name: m_user user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT user_pk PRIMARY KEY (usr_id);


--
-- TOC entry 2813 (class 2606 OID 32852)
-- Name: m_user user_usr_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT user_usr_username_key UNIQUE (usr_username);


--
-- TOC entry 2818 (class 2606 OID 32844)
-- Name: t_authority fk_authority_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_authority
    ADD CONSTRAINT fk_authority_role FOREIGN KEY (aut_role) REFERENCES public.m_role(rol_id);


--
-- TOC entry 2819 (class 2606 OID 32857)
-- Name: t_authority fk_authority_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_authority
    ADD CONSTRAINT fk_authority_user FOREIGN KEY (aut_user) REFERENCES public.m_user(usr_id);


-- Completed on 2019-08-28 21:30:08 CEST

--
-- PostgreSQL database dump complete
--

