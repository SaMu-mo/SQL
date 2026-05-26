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