-- Limpiar la tabla antes de insertar nuevos datos
DELETE FROM libros;
DELETE FROM usuarios;
-- Insertar datos en la tabla "libros"
INSERT INTO libros (id, titulo, autor, editorial, fecha, tematica)
VALUES (1, 'Cien años de soledad', 'Gabriel García Márquez', 'Editorial Sudamericana', '1967-05-30', 'Realismo mágico'),
       (2, '1984', 'George Orwell', 'Secker & Warburg', '1949-06-08', 'Ciencia ficción'),
       (3, 'El Gran Gatsby', 'F. Scott Fitzgerald', 'Scribner', '1925-04-10', 'Ficción'),
       (4, 'Matar a un ruiseñor', 'Harper Lee', 'J. B. Lippincott & Co.', '1960-07-11', 'Novela'),
       (5, 'Crimen y castigo', 'Fiodor Dostoievski', 'Editorial San Jorge', '1866-11-11', 'Novela psicológica'),
       (6, 'Orgullo y prejuicio', 'Jane Austen', 'T. Egerton, Whitehall', '1813-01-28', 'Romance'),
       (7, 'Código Da Vinci', 'Dan Brown', 'Doubleday', '2003-03-18', 'Misterio'),
       (8, 'Los juegos del hambre', 'Suzanne Collins', 'Scholastic', '2008-09-14', 'Ciencia ficción'),
       (9, 'El Hobbit', 'J.R.R. Tolkien', 'George Allen & Unwin', '1937-09-21', 'Fantasía'),
       (10, 'El Señor de los Anillos', 'J.R.R. Tolkien', 'George Allen & Unwin', '1954-07-29', 'Fantasía'),
       (11, 'Cazadores de sombras: Ciudad de hueso', 'Cassandra Clare', 'Simon & Schuster', '2007-03-27',
        'Fantasía urbana'),
       (12, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Bloomsbury', '1997-06-26', 'Fantasía'),
       (13, 'Los hombres me explican cosas', 'Rebecca Solnit', 'Haymarket Books', '2014-05-15', 'Ensayo'),
       (14, 'Breve historia del tiempo', 'Stephen Hawking', 'Bantam Books', '1988-04-01', 'Divulgación científica'),
       (15, 'Steve Jobs', 'Walter Isaacson', 'Simon & Schuster', '2011-10-24', 'Biografía'),
       (16, 'To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', '1960-07-11', 'Novela'),
       (17, 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', '1951-07-16', 'Ficción'),
       (18, 'The Great Expectations', 'Charles Dickens', 'Chapman and Hall', '1861-12-01', 'Novela clásica');

-- Insertar datos en la tabla "usuarios"
INSERT INTO usuarios (id, usuario, password)
VALUES (1, 'admin', '456'),
       (2, 'itic', 'itic');
