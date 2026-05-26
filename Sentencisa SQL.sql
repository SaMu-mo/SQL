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

-- 1. Todos los registros
SELECT * FROM estudiantes;

-- 2. Solo nombres y curso
SELECT nombres, curso FROM estudiantes;

-- 3. Mayores de 18 años
SELECT * FROM estudiantes WHERE edad > 18;

-- 4. Entre 18 y 25 años
SELECT * FROM estudiantes WHERE edad BETWEEN 18 AND 25;

-- 5. Del curso "Base de Datos"
SELECT * FROM estudiantes WHERE curso = 'Base de Datos';

-- 6. Registrados después de 2026-03-01
SELECT * FROM estudiantes WHERE fecha_registro > '2026-03-01';

-- 7. Registrados entre 2026-01-01 y 2026-04-30
SELECT * FROM estudiantes WHERE fecha_registro BETWEEN '2026-01-01' AND '2026-04-30';


------------------Update----

-- 1. Cambiar curso
UPDATE estudiantes SET curso = 'Inteligencia Artif.' WHERE id_estudiante = 1;

-- 2. Cambiar edad
UPDATE estudiantes SET edad = 21 WHERE id_estudiante = 5;

-- 3. Cambiar fecha
UPDATE estudiantes SET fecha_registro = '2026-03-20' WHERE id_estudiante = 3;

-- 4. Cambiar varios campos al mismo tiempo
UPDATE estudiantes SET curso = 'Diseño Web', edad = 24 WHERE id_estudiante = 6;

-- 5. Cambiar todos los de un curso
UPDATE estudiantes SET fecha_registro = '2026-05-01' WHERE curso = 'Redes';




------DELETE

-- 1. Eliminar por ID
DELETE FROM estudiantes WHERE id_estudiante = 15;

-- 2. Eliminar por curso
DELETE FROM estudiantes WHERE curso = 'Diseño Web';

-- 3. Eliminar por edad (menores de 18)
DELETE FROM estudiantes WHERE edad < 18;

-- 4. Eliminar por fecha
DELETE FROM estudiantes WHERE fecha_registro < '2026-01-20';

-- 5. Eliminar por apellido
DELETE FROM estudiantes WHERE apellidos = 'Ríos';


ALTER TABLE estudiantes
ADD COLUMN correo VARCHAR(100);

-- UPDATE con correo
UPDATE estudiantes SET correo = 'juan.nuevo@hotmail.com'   WHERE id_estudiante = 1;
UPDATE estudiantes SET correo = 'sofia.castillo@yahoo.com' WHERE id_estudiante = 6;

-- SELECT mostrando el correo
SELECT nombres, apellidos, curso, correo FROM estudiantes;


----FECHAS

-- 1. Registrados después de 2026-02-01
SELECT * FROM estudiantes WHERE fecha_registro > '2026-02-01';

-- 2. Registrados antes de 2026-05-01
SELECT * FROM estudiantes WHERE fecha_registro < '2026-05-01';

-- 3. Registrados entre dos fechas
SELECT * FROM estudiantes WHERE fecha_registro BETWEEN '2026-02-01' AND '2026-04-30';

-- 4. Registrados exactamente el 2026-03-15
SELECT * FROM estudiantes WHERE fecha_registro = '2026-03-15';

-- 5. Curso "Programacion" registrados después de 2026-01-01
SELECT * FROM estudiantes
WHERE curso = 'Programacion'
  AND fecha_registro > '2026-01-01';