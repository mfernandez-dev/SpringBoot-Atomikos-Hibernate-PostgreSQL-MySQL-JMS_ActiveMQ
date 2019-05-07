CREATE TABLE one.persona (
	id BIGINT NOT NULL,
	nombre varchar(100) NULL,
	apellido varchar(100) NULL,
	CONSTRAINT persona_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
