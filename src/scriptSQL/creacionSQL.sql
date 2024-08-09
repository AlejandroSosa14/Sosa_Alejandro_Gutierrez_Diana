DROP TABLE IF EXISTS ODONTOLOGOS;

CREATE TABLE ODONTOLOGOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_matricula INT,
    nombre VARCHAR(255),
    apellido VARCHAR(255)
);

INSERT INTO ODONTOLOGOS (numero_matricula, nombre, apellido) VALUES (123456, "Carlos", "Lopez");
INSERT INTO ODONTOLOGOS (numero_matricula, nombre, apellido) VALUES (321654, "Diana", "Gutierrez");
INSERT INTO ODONTOLOGOS (numero_matricula, nombre, apellido) VALUES (456123, "Alejandro", "Sosa");

SELECT * ODONTOLOGOS;