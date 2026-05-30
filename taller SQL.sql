
-- Tabla libros
CREATE TABLE libros (
    codigo      VARCHAR(5)  PRIMARY KEY,
    titulo      VARCHAR(50) NOT NULL,
    paginas     INT         NOT NULL
);

-- Tabla autores
CREATE TABLE autores (
    id      INT         PRIMARY KEY,
    nombre  VARCHAR(50) NOT NULL,
    pais    VARCHAR(30) NOT NULL
);


--Tabla de Rompimiento


CREATE TABLE libro_autor (
    la_libro_codigo_fk  VARCHAR(5)  NOT NULL,
    la_autor_id_fk      INT         NOT NULL,
    anio_publicacion    INT         NOT NULL,
    PRIMARY KEY (la_libro_codigo_fk, la_autor_id_fk),
    CONSTRAINT fk_libro  FOREIGN KEY (la_libro_codigo_fk) REFERENCES libros(codigo),
    CONSTRAINT fk_autor  FOREIGN KEY (la_autor_id_fk)     REFERENCES autores(id)
);


-- Insertar Datos

-- Libros 

INSERT INTO libros (codigo, titulo, paginas) VALUES
    ('L001', 'Cien Anos de Soledad',      432),
    ('L002', 'El Principito',             96),
    ('L003', 'Harry Potter y la Piedra',  309),
    ('L004', 'Don Quijote de la Mancha',  863);

-- Autores 
INSERT INTO autores (id, nombre, pais) VALUES
    (1, 'Gabriel Garcia Marquez', 'Colombia'),
    (2, 'Antoine de Saint-Exupery', 'Francia'),
    (3, 'J.K. Rowling',             'Reino Unido');

-- libro autor 
INSERT INTO libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion) VALUES
    ('L001', 1, 1967),
    ('L002', 2, 1943),
    ('L003', 3, 1997),
    ('L004', 1, 2021),
    ('L002', 3, 2022);


-- Consultas SQL


-- Consulta 1: 
SELECT
    l.titulo,
    a.nombre,
    a.pais,
    la.anio_publicacion
FROM libro_autor la
INNER JOIN libros  l ON la.la_libro_codigo_fk = l.codigo
INNER JOIN autores a ON la.la_autor_id_fk     = a.id;

-- Consulta 2: 
SELECT
    l.titulo,
    a.nombre,
    la.anio_publicacion
FROM libro_autor la
INNER JOIN libros  l ON la.la_libro_codigo_fk = l.codigo
INNER JOIN autores a ON la.la_autor_id_fk     = a.id
WHERE la.anio_publicacion > 2020;

-- Consulta 3:
SELECT * FROM autores
WHERE pais = 'Colombia';

-- Consulta 4:
SELECT
    l.titulo,
    la.anio_publicacion
FROM libro_autor la
INNER JOIN libros l ON la.la_libro_codigo_fk = l.codigo
ORDER BY la.anio_publicacion DESC;

-- Consulta 5:
SELECT
    a.nombre,
    COUNT(la.la_libro_codigo_fk) AS total_libros
FROM libro_autor la
INNER JOIN autores a ON la.la_autor_id_fk = a.id
GROUP BY a.nombre;


--Modificacion de la Tabla


-- Agregar columna precio

ALTER TABLE libros ADD COLUMN precio DOUBLE PRECISION;

-- Actualizar 

UPDATE libros SET precio = 45000 WHERE codigo = 'L001';
UPDATE libros SET precio = 28000 WHERE codigo = 'L002';
UPDATE libros SET precio = 55000 WHERE codigo = 'L003';
UPDATE libros SET precio = 38000 WHERE codigo = 'L004';

-- SELECT titulo y precio

SELECT titulo, precio FROM libros;