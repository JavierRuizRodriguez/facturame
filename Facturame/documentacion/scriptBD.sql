-- Table: "Persona"

-- DROP TABLE "Persona";

CREATE TABLE "Persona"
(
  dni character(10) NOT NULL,
  nombre character varying(20) NOT NULL,
  apellidos character varying(60) NOT NULL,
  "fechaNacimiento" date NOT NULL,
  sexo character varying(20) NOT NULL,
  CONSTRAINT "personaPK" PRIMARY KEY (dni)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Persona"
  OWNER TO postgres;


-- Table: "Viaje"

-- DROP TABLE "Viaje";

CREATE TABLE "Viaje"
(
  "idViaje" serial NOT NULL,
  "lugarInicio" character varying(40) NOT NULL,
  "lugarDestino" character varying(40) NOT NULL,
  "horaInico" time with time zone NOT NULL,
  "horaLlegada" time with time zone NOT NULL,
  "fechaInico" date NOT NULL,
  "fechaLlegada" date NOT NULL,
  "kmViaje" bigint NOT NULL,
  "idPorte" integer NOT NULL,
  CONSTRAINT "viajePK" PRIMARY KEY ("idViaje"),
  CONSTRAINT "incluyeDatos" FOREIGN KEY ("idPorte")
      REFERENCES "Porte" ("idPorte") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Viaje"
  OWNER TO postgres;

-- Index: "porteFK"

-- DROP INDEX "porteFK";

CREATE INDEX "porteFK"
  ON "Viaje"
  USING btree
  ("idPorte");


-- Table: "Empleado"

-- DROP TABLE "Empleado";

CREATE TABLE "Empleado"
(
-- Inherited from table "Persona":  dni character(10) NOT NULL,
-- Inherited from table "Persona":  nombre character varying(20) NOT NULL,
-- Inherited from table "Persona":  apellidos character varying(60) NOT NULL,
-- Inherited from table "Persona":  "fechaNacimiento" date NOT NULL,
-- Inherited from table "Persona":  sexo character varying(20) NOT NULL,
  "fechaAltaEmpleado" date NOT NULL,
  sueldo double precision NOT NULL,
  rango character varying(20) NOT NULL,
  CONSTRAINT "empleadoPK" PRIMARY KEY (dni)
)
INHERITS ("Persona")
WITH (
  OIDS=FALSE
);
ALTER TABLE "Empleado"
  OWNER TO postgres;


-- Table: "LibroGatos"

-- DROP TABLE "LibroGatos";

CREATE TABLE "LibroGatos"
(
  "idEntrada" serial NOT NULL,
  concepto character varying(50) NOT NULL,
  dinero double precision NOT NULL,
  "fechaAsiento" date NOT NULL,
  descripcion character varying(50),
  CONSTRAINT "libroCuentasPortesPK" PRIMARY KEY ("idEntrada")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "LibroGatos"
  OWNER TO postgres;


-- Table: "Porte"

-- DROP TABLE "Porte";

CREATE TABLE "Porte"
(
  "idPorte" serial NOT NULL,
  "nBastidor" character varying(17) NOT NULL,
  dni character(10) NOT NULL,
  empresa character varying(50) NOT NULL,
  "kgCarga" bigint NOT NULL,
  "volumenCarga" bigint NOT NULL,
  concepto character varying(50) NOT NULL,
  precio bigint NOT NULL,
  "esGrupaje" boolean NOT NULL,
  descripcion character varying(60),
  CONSTRAINT "portePK" PRIMARY KEY ("idPorte"),
  CONSTRAINT conduce FOREIGN KEY (dni)
      REFERENCES "Empleado" (dni) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT realizado FOREIGN KEY ("nBastidor")
      REFERENCES "Camion" ("nBastidor") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Porte"
  OWNER TO postgres;

-- Index: "dniFK"

-- DROP INDEX "dniFK";

CREATE INDEX "dniFK"
  ON "Porte"
  USING btree
  (dni COLLATE pg_catalog."default");

-- Index: "nBastidorFK"

-- DROP INDEX "nBastidorFK";

CREATE INDEX "nBastidorFK"
  ON "Porte"
  USING btree
  ("nBastidor" COLLATE pg_catalog."default");


-- Table: "UsuarioSistema"

-- DROP TABLE "UsuarioSistema";

CREATE TABLE "UsuarioSistema"
(
  dni character varying(20) NOT NULL,
  nickname character varying(20) NOT NULL,
  "hashContrasena" character varying(20) NOT NULL,
  admin boolean NOT NULL,
  "fechaAltaUsuario" date NOT NULL,
  CONSTRAINT "usSisPK" PRIMARY KEY (dni),
  CONSTRAINT esde FOREIGN KEY (dni)
      REFERENCES "Empleado" (dni) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "UsuarioSistema"
  OWNER TO postgres;

-- Index: "dniUsSisFK"

-- DROP INDEX "dniUsSisFK";

CREATE INDEX "dniUsSisFK"
  ON "UsuarioSistema"
  USING btree
  (dni COLLATE pg_catalog."default");


-- Table: "Viaje"

-- DROP TABLE "Viaje";

CREATE TABLE "Viaje"
(
  "idViaje" serial NOT NULL,
  "lugarInicio" character varying(40) NOT NULL,
  "lugarDestino" character varying(40) NOT NULL,
  "horaInico" time with time zone NOT NULL,
  "horaLlegada" time with time zone NOT NULL,
  "fechaInico" date NOT NULL,
  "fechaLlegada" date NOT NULL,
  "kmViaje" bigint NOT NULL,
  "idPorte" integer NOT NULL,
  CONSTRAINT "viajePK" PRIMARY KEY ("idViaje"),
  CONSTRAINT "incluyeDatos" FOREIGN KEY ("idPorte")
      REFERENCES "Porte" ("idPorte") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Viaje"
  OWNER TO postgres;

-- Index: "porteFK"

-- DROP INDEX "porteFK";

CREATE INDEX "porteFK"
  ON "Viaje"
  USING btree
  ("idPorte");

