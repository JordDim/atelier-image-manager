CREATE TABLE image (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(50) UNIQUE NOT NULL
);

-- Comentario para la tabla
COMMENT ON TABLE image IS 'Tabla que contiene información sobre las imágenes almacenadas.';

-- Comentarios para las columnas
COMMENT ON COLUMN image.id IS 'Identificador único de la imagen.';
COMMENT ON COLUMN image.name IS 'Nombre único de la imagen (máximo 50 caracteres).';

CREATE SEQUENCE image_seq;

-- Crear índice para mejorar búsquedas por nombre (innecesario si ya es UNIQUE, pero lo puedes mantener si lo prefieres)
-- CREATE INDEX idx_image_name ON image(name);
