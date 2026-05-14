DROP TABLE IF EXISTS autos;
DROP TABLE IF EXISTS marcas;

CREATE TABLE marcas (
    id_marca SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    pais VARCHAR(100)
);

CREATE TABLE autos (
    no_serie VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(100),
    modelo INT,
    precio DECIMAL(10,2),
    id_marca INT,
    FOREIGN KEY (id_marca)
    REFERENCES marcas(id_marca)
);