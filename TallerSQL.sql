USE taller_sql;

DROP TABLE IF EXISTS estudiantes;

CREATE TABLE estudiantes (
    id_estudiante  INT PRIMARY KEY,
    nombres        VARCHAR(50),
    apellidos      VARCHAR(50),
    edad           INT,
    curso          VARCHAR(50),
    fecha_registro VARCHAR(10)
);

INSERT INTO estudiantes VALUES (1,  'Juan',      'Pérez',      20, 'Programacion',       '2026-01-10');
INSERT INTO estudiantes VALUES (2,  'María',     'Gómez',      22, 'Base de Datos',       '2026-01-15');
INSERT INTO estudiantes VALUES (3,  'Carlos',    'Torres',     19, 'Redes',               '2026-02-03');
INSERT INTO estudiantes VALUES (4,  'Ana',       'Ramírez',    25, 'Programacion',        '2026-02-14');
INSERT INTO estudiantes VALUES (5,  'Luis',      'Morales',    17, 'Diseño Web',          '2026-02-20');
INSERT INTO estudiantes VALUES (6,  'Sofía',     'Castillo',   23, 'Base de Datos',       '2026-03-05');
INSERT INTO estudiantes VALUES (7,  'Pedro',     'Herrera',    21, 'Inteligencia Artif.', '2026-03-10');
INSERT INTO estudiantes VALUES (8,  'Valeria',   'Díaz',       18, 'Redes',               '2026-03-15');
INSERT INTO estudiantes VALUES (9,  'Diego',     'Vargas',     24, 'Programacion',        '2026-03-22');
INSERT INTO estudiantes VALUES (10, 'Camila',    'Flores',     20, 'Diseño Web',          '2026-04-01');
INSERT INTO estudiantes VALUES (11, 'Andrés',    'Ortega',     22, 'Base de Datos',       '2026-04-08');
INSERT INTO estudiantes VALUES (12, 'Lucía',     'Mendoza',    19, 'Programacion',        '2026-04-15');
INSERT INTO estudiantes VALUES (13, 'Sebastián', 'Ríos',       26, 'Redes',               '2026-04-20');
INSERT INTO estudiantes VALUES (14, 'Isabella',  'Serrano',    21, 'Base de Datos',       '2026-05-02');
INSERT INTO estudiantes VALUES (15, 'Mateo',     'Jiménez',    23, 'Inteligencia Artif.', '2026-05-10');
INSERT INTO estudiantes VALUES (16, 'Juan',      'Pérez',      20, 'Base de Datos',       '2026-05-11');
INSERT INTO estudiantes VALUES (17, 'María',     'Gómez',      22, 'Redes',               '2026-05-12');

SELECT * FROM estudiantes;
SELECT nombres, curso FROM estudiantes;
SELECT * FROM estudiantes WHERE edad > 18;
SELECT * FROM estudiantes WHERE edad BETWEEN 18 AND 25;
SELECT * FROM estudiantes WHERE curso = 'Base de Datos';
SELECT * FROM estudiantes WHERE fecha_registro > '2026-03-01';
SELECT * FROM estudiantes WHERE fecha_registro BETWEEN '2026-01-01' AND '2026-04-30';

SET SQL_SAFE_UPDATES = 0;

UPDATE estudiantes SET curso = 'Inteligencia Artif.' WHERE id_estudiante = 1;
UPDATE estudiantes SET edad = 21 WHERE id_estudiante = 5;
UPDATE estudiantes SET fecha_registro = '2026-03-20' WHERE id_estudiante = 3;
UPDATE estudiantes SET curso = 'Diseño Web', edad = 24 WHERE id_estudiante = 6;
UPDATE estudiantes SET fecha_registro = '2026-05-01' WHERE curso = 'Redes';

DELETE FROM estudiantes WHERE id_estudiante = 15;
DELETE FROM estudiantes WHERE curso = 'Diseño Web';
DELETE FROM estudiantes WHERE edad < 18;
DELETE FROM estudiantes WHERE fecha_registro < '2026-01-20';
DELETE FROM estudiantes WHERE apellidos = 'Ríos';

ALTER TABLE estudiantes ADD COLUMN correo VARCHAR(100);

UPDATE estudiantes SET correo = 'juan.perez@gmail.com'      WHERE id_estudiante = 1;
UPDATE estudiantes SET correo = 'maria.gomez@gmail.com'     WHERE id_estudiante = 2;
UPDATE estudiantes SET correo = 'carlos.torres@gmail.com'   WHERE id_estudiante = 3;
UPDATE estudiantes SET correo = 'ana.ramirez@gmail.com'     WHERE id_estudiante = 4;
UPDATE estudiantes SET correo = 'sofia.castillo@gmail.com'  WHERE id_estudiante = 6;
UPDATE estudiantes SET correo = 'pedro.herrera@gmail.com'   WHERE id_estudiante = 7;
UPDATE estudiantes SET correo = 'valeria.diaz@gmail.com'    WHERE id_estudiante = 8;
UPDATE estudiantes SET correo = 'diego.vargas@gmail.com'    WHERE id_estudiante = 9;
UPDATE estudiantes SET correo = 'andres.ortega@gmail.com'   WHERE id_estudiante = 11;
UPDATE estudiantes SET correo = 'lucia.mendoza@gmail.com'   WHERE id_estudiante = 12;
UPDATE estudiantes SET correo = 'isabella.serrano@gmail.com' WHERE id_estudiante = 14;
UPDATE estudiantes SET correo = 'juan.perez2@gmail.com'     WHERE id_estudiante = 16;
UPDATE estudiantes SET correo = 'maria.gomez2@gmail.com'    WHERE id_estudiante = 17;

SELECT nombres, apellidos, curso, correo FROM estudiantes;

SELECT * FROM estudiantes WHERE fecha_registro > '2026-02-01';
SELECT * FROM estudiantes WHERE fecha_registro < '2026-05-01';
SELECT * FROM estudiantes WHERE fecha_registro BETWEEN '2026-02-01' AND '2026-04-30';
SELECT * FROM estudiantes WHERE fecha_registro = '2026-03-15';
SELECT * FROM estudiantes WHERE curso = 'Programacion' AND fecha_registro > '2026-01-01';

