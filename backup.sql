--
-- PostgreSQL database dump
--

-- Dumped from database version 15.12 (Debian 15.12-1.pgdg120+1)
-- Dumped by pg_dump version 15.12 (Debian 15.12-1.pgdg120+1)

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

SET default_table_access_method = heap;

--
-- Name: billdb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.billdb (
    id integer NOT NULL,
    destinatario_denom_social character varying(255),
    destinatario_nif character varying(255),
    destinatario_dir character varying(255),
    destinatario_direccion_fiscal character varying(255),
    emisor_denom_social character varying(255),
    emisor_nif character varying(255),
    serie character varying(255),
    numero_correlativo character varying(255),
    fecha_emision character varying(255),
    fecha_vencimiento character varying(255),
    concepto character varying(255),
    albaranes character varying(255),
    tipo_iva character varying(255),
    tipo_retencion character varying(255),
    base_factura character varying(255),
    importe_final character varying(255),
    destinatariodir character varying(255),
    tipoiva character varying(255),
    emisor_direccion_fiscal character varying(255),
    fecha_pago character varying(255),
    forma_pago character varying(255)
);


ALTER TABLE public.billdb OWNER TO admin;

--
-- Name: billdb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.billdb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.billdb_id_seq OWNER TO admin;

--
-- Name: billdb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.billdb_id_seq OWNED BY public.billdb.id;


--
-- Name: clientdb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.clientdb (
    id integer NOT NULL,
    dni character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    empresa character varying(255),
    pais character varying(255),
    direccion character varying(255),
    email character varying(255),
    telefono character varying(255)
);


ALTER TABLE public.clientdb OWNER TO admin;

--
-- Name: clientdb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.clientdb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientdb_id_seq OWNER TO admin;

--
-- Name: clientdb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.clientdb_id_seq OWNED BY public.clientdb.id;


--
-- Name: fichajedb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.fichajedb (
    id integer NOT NULL,
    employee_id character varying(255) NOT NULL,
    initial_time timestamp without time zone NOT NULL,
    exit_time timestamp without time zone,
    initial_location character varying(255),
    exit_location character varying(255)
);


ALTER TABLE public.fichajedb OWNER TO admin;

--
-- Name: fichajedb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.fichajedb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fichajedb_id_seq OWNER TO admin;

--
-- Name: fichajedb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.fichajedb_id_seq OWNED BY public.fichajedb.id;


--
-- Name: order_product; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.order_product (
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    cantidad integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.order_product OWNER TO admin;

--
-- Name: orderdb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.orderdb (
    order_id integer NOT NULL,
    creation_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    delivery_time timestamp without time zone,
    client_id integer NOT NULL,
    order_status character varying(255),
    amount integer NOT NULL,
    delivery_address character varying(255)
);


ALTER TABLE public.orderdb OWNER TO admin;

--
-- Name: orderdb_order_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.orderdb_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orderdb_order_id_seq OWNER TO admin;

--
-- Name: orderdb_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.orderdb_order_id_seq OWNED BY public.orderdb.order_id;


--
-- Name: productdb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.productdb (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    image_url character varying(255),
    category character varying(255),
    stock integer DEFAULT 0,
    price double precision NOT NULL
);


ALTER TABLE public.productdb OWNER TO admin;

--
-- Name: productdb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.productdb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productdb_id_seq OWNER TO admin;

--
-- Name: productdb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.productdb_id_seq OWNED BY public.productdb.id;


--
-- Name: roldb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.roldb (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255)
);


ALTER TABLE public.roldb OWNER TO admin;

--
-- Name: roldb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.roldb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roldb_id_seq OWNER TO admin;

--
-- Name: roldb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.roldb_id_seq OWNED BY public.roldb.id;


--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.user_roles (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_roles OWNER TO admin;

--
-- Name: userdb; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.userdb (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    enabled boolean DEFAULT true NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_login timestamp without time zone,
    verification_token character varying(255),
    roles integer[]
);


ALTER TABLE public.userdb OWNER TO admin;

--
-- Name: userdb_id_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.userdb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.userdb_id_seq OWNER TO admin;

--
-- Name: userdb_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.userdb_id_seq OWNED BY public.userdb.id;


--
-- Name: billdb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.billdb ALTER COLUMN id SET DEFAULT nextval('public.billdb_id_seq'::regclass);


--
-- Name: clientdb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.clientdb ALTER COLUMN id SET DEFAULT nextval('public.clientdb_id_seq'::regclass);


--
-- Name: fichajedb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.fichajedb ALTER COLUMN id SET DEFAULT nextval('public.fichajedb_id_seq'::regclass);


--
-- Name: orderdb order_id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.orderdb ALTER COLUMN order_id SET DEFAULT nextval('public.orderdb_order_id_seq'::regclass);


--
-- Name: productdb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.productdb ALTER COLUMN id SET DEFAULT nextval('public.productdb_id_seq'::regclass);


--
-- Name: roldb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.roldb ALTER COLUMN id SET DEFAULT nextval('public.roldb_id_seq'::regclass);


--
-- Name: userdb id; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.userdb ALTER COLUMN id SET DEFAULT nextval('public.userdb_id_seq'::regclass);


--
-- Data for Name: billdb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.billdb (id, destinatario_denom_social, destinatario_nif, destinatario_dir, destinatario_direccion_fiscal, emisor_denom_social, emisor_nif, serie, numero_correlativo, fecha_emision, fecha_vencimiento, concepto, albaranes, tipo_iva, tipo_retencion, base_factura, importe_final, destinatariodir, tipoiva, emisor_direccion_fiscal, fecha_pago, forma_pago) FROM stdin;
4	Empresa D	44332211D	Calle Luna 321	Calle Luna 321, Sevilla	Mi Empresa	87654321Z	A	0004	2025-04-22	2025-05-22	Venta de servicios	ALB004	21%	0%	750.00	907.50	\N	\N	\N	\N	\N
5	Empresa E	55667788E	Calle Sol 654	Calle Sol 654, Bilbao	Mi Empresa	87654321Z	A	0005	2025-04-22	2025-05-22	Venta de productos	ALB005	21%	0%	2000.00	2420.00	\N	\N	\N	\N	\N
3	Empresa C	11223344C	Plaza Mayor 789	Plaza Mayor 789, Valencia	Mi Empresa	87654321Z	A	0003	2025-04-22	2025-05-22	Venta de productos	ALB003	21%	0%	1500.00	1815.00	Calle 1	21	Calle 2	\N	\N
1	Empresa A	12345678A	Calle Falsa 123	Calle Falsa 123, Madrid	Mi Empresa	87654321Z	A	0001	2025-04-20	2025-05-20	Venta de productos	ALB001	21%	15	1522	1674.20	awd	25	awdawd	2025-05-21	IBAN - 52050112515
7	Empresa A	12345678A	\N	calle falsa 123	Empresa	12345678A	13	1456	2222-12-12	2222-02-22	Producto\t\t\t\t\t\t\t\t | Cantidad \t\t\t\t | Precio\nProducto 5\t\t\t\t\t\t\t\t| 25\t\t\t\t\t\t\t\t| 49.99Ôé¼\nProducto 20\t\t\t\t\t\t\t\t| 2\t\t\t\t\t\t\t\t| 100.99Ôé¼\nProducto 39\t\t\t\t\t\t\t\t| 11\t\t\t\t\t\t\t\t| 92.99Ôé¼	A123	\N	8	2474.62	2796.32	calle falsa 123	21	Calle falsa123	2300-03-12	IBAN - 1241025401
8	Empresa B	87654321Z	\N	Zona Sur	Empresa	12345678A	B	15	2022-12-02	2023-12-22	Producto\t\t\t\t\t\t\t\t  Cantidad \t\t\t\t  Precio\nProducto 5\t\t\t\t\t\t\t\t 8\t\t\t\t\t\t\t\t 49.99Ôé¼\nProducto 10\t\t\t\t\t\t\t\t 6\t\t\t\t\t\t\t\t 99.99Ôé¼	A1512	\N	0	999.86	1329.81	Zona Sur	33	Calle arriba	2025-12-12	Efectivo
\.


--
-- Data for Name: clientdb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.clientdb (id, dni, nombre, empresa, pais, direccion, email, telefono) FROM stdin;
3	11223344C	Juan Garc├¡a	Empresa C	Espa├▒a	Zona Este	\N	\N
4	44332211D	Ana Fern├índez	Empresa D	Espa├▒a	Zona Oeste	\N	\N
5	55667788E	Luis Mart├¡nez	Empresa E	Espa├▒a	Zona Centro	email@dasd.com	1421412
2	87654321Z	Mar├¡a L├│pez	Empresa B	Espa├▒a	Zona Sur	emai@gmail.com	421412
1	12345678A	Carlos P├®rez	Empresa A	Espa├▒a	calle falsa 123	email123@gmail.com	2414124
\.


--
-- Data for Name: fichajedb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.fichajedb (id, employee_id, initial_time, exit_time, initial_location, exit_location) FROM stdin;
1	EMP001	2025-04-22 08:00:00	2025-04-22 16:00:00	Oficina Central	Oficina Central
2	EMP002	2025-04-22 09:00:00	\N	Sucursal Norte	\N
3	EMP003	2025-04-22 07:30:00	2025-04-22 15:30:00	Oficina Central	Oficina Central
4	EMP004	2025-04-22 10:00:00	2025-04-22 18:00:00	Sucursal Sur	Sucursal Sur
5	EMP005	2025-04-22 08:15:00	2025-04-22 16:15:00	Oficina Central	Oficina Central
6	8	2025-05-13 12:12:00	2025-05-13 13:13:00		
7	8	2025-05-13 12:12:00	2025-05-13 12:24:00		
8	8	2025-02-20 20:00:00	2025-02-20 22:00:00		
9	8	2025-05-13 05:30:00	2025-05-13 07:30:00		
10	8	2025-05-13 05:00:00	2025-05-13 06:00:00		
11	8	2025-05-13 10:00:00	2025-05-13 11:00:00		
12	8	2025-05-13 08:00:00	2025-05-13 09:00:00		
13	8	2025-05-13 11:01:00	2025-05-13 11:02:00		
14	8	2025-05-13 10:00:00	2025-05-13 12:00:00		
15	8	2025-05-12 04:01:00	2025-05-12 05:06:00		
16	8	2025-05-15 15:00:00	2025-05-15 19:00:00		
17	7	2025-05-16 07:05:00	2025-05-16 18:00:00		
18	7	2025-05-22 08:00:00	2025-05-22 18:00:00		
19	7	2025-05-17 07:00:00	2025-05-17 15:00:00		
20	7	2025-05-18 07:00:00	2025-05-18 18:00:00		
21	7	2025-05-15 12:00:00	2025-05-15 13:00:00		
\.


--
-- Data for Name: order_product; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.order_product (order_id, product_id, cantidad) FROM stdin;
30	10	8
30	15	6
28	10	25
28	25	2
28	44	11
31	15	155
\.


--
-- Data for Name: orderdb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.orderdb (order_id, creation_time, delivery_time, client_id, order_status, amount, delivery_address) FROM stdin;
28	1212-12-01 01:01:00	1212-12-12 01:01:00	1	PENDING	2474	Calle Falsa 123
30	0002-12-12 01:01:00	0112-01-01 01:01:00	2	IN_PROGRESS	999	calle falsa 123456
31	1111-03-12 01:01:00	1232-03-12 12:33:00	4	PENDING	15498	calle falsa
\.


--
-- Data for Name: productdb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.productdb (id, name, description, image_url, category, stock, price) FROM stdin;
56	wadwad	adwda		awda	11	22
6	Producto 1	Descripci├│n del producto 1	https://picsum.photos/200?1	Categor├¡a A	10	1551
8	Producto 3	Descripci├│n del producto 3	https://picsum.photos/200?3	Categor├¡a C	20	29.99
10	Producto 5	Descripci├│n del producto 5	https://picsum.photos/200?5	Categor├¡a B	8	49.99
11	Producto 6	Descripci├│n del producto 6	https://picsum.photos/200?6	Categor├¡a C	12	59.99
12	Producto 7	Descripci├│n del producto 7	https://picsum.photos/200?7	Categor├¡a A	18	69.99
13	Producto 8	Descripci├│n del producto 8	https://picsum.photos/200?8	Categor├¡a B	22	79.99
14	Producto 9	Descripci├│n del producto 9	https://picsum.photos/200?9	Categor├¡a C	30	89.99
15	Producto 10	Descripci├│n del producto 10	https://picsum.photos/200?10	Categor├¡a A	25	99.99
16	Producto 11	Descripci├│n del producto 11	https://picsum.photos/200?11	Categor├¡a B	14	10.99
18	Producto 13	Descripci├│n del producto 13	https://picsum.photos/200?13	Categor├¡a A	19	30.99
19	Producto 14	Descripci├│n del producto 14	https://picsum.photos/200?14	Categor├¡a B	21	40.99
20	Producto 15	Descripci├│n del producto 15	https://picsum.photos/200?15	Categor├¡a C	23	50.99
21	Producto 16	Descripci├│n del producto 16	https://picsum.photos/200?16	Categor├¡a A	27	60.99
22	Producto 17	Descripci├│n del producto 17	https://picsum.photos/200?17	Categor├¡a B	29	70.99
23	Producto 18	Descripci├│n del producto 18	https://picsum.photos/200?18	Categor├¡a C	31	80.99
24	Producto 19	Descripci├│n del producto 19	https://picsum.photos/200?19	Categor├¡a A	33	90.99
25	Producto 20	Descripci├│n del producto 20	https://picsum.photos/200?20	Categor├¡a B	35	100.99
26	Producto 21	Descripci├│n del producto 21	https://picsum.photos/200?21	Categor├¡a C	37	11.99
27	Producto 22	Descripci├│n del producto 22	https://picsum.photos/200?22	Categor├¡a A	39	21.99
28	Producto 23	Descripci├│n del producto 23	https://picsum.photos/200?23	Categor├¡a B	41	31.99
29	Producto 24	Descripci├│n del producto 24	https://picsum.photos/200?24	Categor├¡a C	43	41.99
30	Producto 25	Descripci├│n del producto 25	https://picsum.photos/200?25	Categor├¡a A	45	51.99
31	Producto 26	Descripci├│n del producto 26	https://picsum.photos/200?26	Categor├¡a B	47	61.99
32	Producto 27	Descripci├│n del producto 27	https://picsum.photos/200?27	Categor├¡a C	49	71.99
33	Producto 28	Descripci├│n del producto 28	https://picsum.photos/200?28	Categor├¡a A	51	81.99
34	Producto 29	Descripci├│n del producto 29	https://picsum.photos/200?29	Categor├¡a B	53	91.99
35	Producto 30	Descripci├│n del producto 30	https://picsum.photos/200?30	Categor├¡a C	55	101.99
36	Producto 31	Descripci├│n del producto 31	https://picsum.photos/200?31	Categor├¡a A	57	12.99
37	Producto 32	Descripci├│n del producto 32	https://picsum.photos/200?32	Categor├¡a B	59	22.99
38	Producto 33	Descripci├│n del producto 33	https://picsum.photos/200?33	Categor├¡a C	61	32.99
39	Producto 34	Descripci├│n del producto 34	https://picsum.photos/200?34	Categor├¡a A	63	42.99
40	Producto 35	Descripci├│n del producto 35	https://picsum.photos/200?35	Categor├¡a B	65	52.99
41	Producto 36	Descripci├│n del producto 36	https://picsum.photos/200?36	Categor├¡a C	67	62.99
42	Producto 37	Descripci├│n del producto 37	https://picsum.photos/200?37	Categor├¡a A	69	72.99
43	Producto 38	Descripci├│n del producto 38	https://picsum.photos/200?38	Categor├¡a B	71	82.99
44	Producto 39	Descripci├│n del producto 39	https://picsum.photos/200?39	Categor├¡a C	73	92.99
45	Producto 40	Descripci├│n del producto 40	https://picsum.photos/200?40	Categor├¡a A	75	102.99
46	Producto 41	Descripci├│n del producto 41	https://picsum.photos/200?41	Categor├¡a B	77	13.99
47	Producto 42	Descripci├│n del producto 42	https://picsum.photos/200?42	Categor├¡a C	79	23.99
48	Producto 43	Descripci├│n del producto 43	https://picsum.photos/200?43	Categor├¡a A	81	33.99
49	Producto 44	Descripci├│n del producto 44	https://picsum.photos/200?44	Categor├¡a B	83	43.99
50	Producto 45	Descripci├│n del producto 45	https://picsum.photos/200?45	Categor├¡a C	85	53.99
51	Producto 46	Descripci├│n del producto 46	https://picsum.photos/200?46	Categor├¡a A	87	63.99
52	Producto 47	Descripci├│n del producto 47	https://picsum.photos/200?47	Categor├¡a B	89	73.99
53	Producto 48	Descripci├│n del producto 48	https://picsum.photos/200?48	Categor├¡a C	91	83.99
54	Producto 49	Descripci├│n del producto 49	https://picsum.photos/200?49	Categor├¡a A	93	93.99
55	Producto 50	Descripci├│n del producto 50	https://picsum.photos/200?50	Categor├¡a B	95	103.99
7	Bici	Descripci├│n del producto 2	https://picsum.photos/200?2	Categor├¡a B	15	19.99
17	platanos	Descripci├│n del producto 12	https://picsum.photos/200?12	Categor├¡a C	16	20.99
\.


--
-- Data for Name: roldb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.roldb (id, name, description) FROM stdin;
1	USER	Usuario est├índar con permisos b├ísicos
2	ADMIN	Administrador con permisos completos
3	MANAGER	Gerente con permisos intermedios
\.


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.user_roles (user_id, role_id) FROM stdin;
7	1
8	1
9	1
7	2
7	3
8	3
10	1
10	2
\.


--
-- Data for Name: userdb; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.userdb (id, name, email, password, enabled, created_at, updated_at, last_login, verification_token, roles) FROM stdin;
7	pepe	pepe@example.com	$2a$10$eprrZdzWHRhnbKfiJNeNueDSPDriWwkmuW8vZ.pOC0u7NCQCa49tK	t	\N	\N	\N	\N	\N
8	pepe2	pepe2@example.com	$2a$10$GujXN.bv3braCf6zMPDmOOhitOvd4hvxUtkmMPFK0PRy3T1uUJtbi	t	\N	\N	\N	\N	\N
9	pepe3	pepe3@example.com	$2a$10$qSOTOxMcjG0hipR4WVeUh.mj4itONbl4lOlm35.JGqgslca4/PWtC	t	\N	\N	\N	\N	\N
10	pablo	pablo@email.com	$2a$10$xlJ03WxShRhaerZaQqMK8e/PCWnS0hv.jLWiHwFWJwcEygf9RBLcO	t	\N	\N	\N	\N	\N
\.


--
-- Name: billdb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.billdb_id_seq', 8, true);


--
-- Name: clientdb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.clientdb_id_seq', 6, true);


--
-- Name: fichajedb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.fichajedb_id_seq', 21, true);


--
-- Name: orderdb_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.orderdb_order_id_seq', 31, true);


--
-- Name: productdb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.productdb_id_seq', 56, true);


--
-- Name: roldb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.roldb_id_seq', 3, true);


--
-- Name: userdb_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.userdb_id_seq', 10, true);


--
-- Name: billdb billdb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.billdb
    ADD CONSTRAINT billdb_pkey PRIMARY KEY (id);


--
-- Name: clientdb clientdb_dni_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.clientdb
    ADD CONSTRAINT clientdb_dni_key UNIQUE (dni);


--
-- Name: clientdb clientdb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.clientdb
    ADD CONSTRAINT clientdb_pkey PRIMARY KEY (id);


--
-- Name: fichajedb fichajedb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.fichajedb
    ADD CONSTRAINT fichajedb_pkey PRIMARY KEY (id);


--
-- Name: order_product order_product_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_pkey PRIMARY KEY (order_id, product_id);


--
-- Name: orderdb orderdb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.orderdb
    ADD CONSTRAINT orderdb_pkey PRIMARY KEY (order_id);


--
-- Name: productdb productdb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.productdb
    ADD CONSTRAINT productdb_pkey PRIMARY KEY (id);


--
-- Name: roldb roldb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.roldb
    ADD CONSTRAINT roldb_pkey PRIMARY KEY (id);


--
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: userdb userdb_email_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.userdb
    ADD CONSTRAINT userdb_email_key UNIQUE (email);


--
-- Name: userdb userdb_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.userdb
    ADD CONSTRAINT userdb_pkey PRIMARY KEY (id);


--
-- Name: user_roles fk2j3ofk7gjciuuf1eky08gb6ba; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk2j3ofk7gjciuuf1eky08gb6ba FOREIGN KEY (user_id) REFERENCES public.userdb(id);


--
-- Name: user_roles fk3pg1cwkollu342a8hs1ojx555; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk3pg1cwkollu342a8hs1ojx555 FOREIGN KEY (role_id) REFERENCES public.roldb(id);


--
-- Name: order_product order_product_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orderdb(order_id) ON DELETE CASCADE;


--
-- Name: order_product order_product_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.productdb(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

