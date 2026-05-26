ALTER TABLE vehiculos ADD kilometraje INT;

UPDATE vehiculos SET kilometraje = 15000 WHERE placa = 'ABC-001';
UPDATE vehiculos SET kilometraje = 8000  WHERE placa = 'XYZ-002';