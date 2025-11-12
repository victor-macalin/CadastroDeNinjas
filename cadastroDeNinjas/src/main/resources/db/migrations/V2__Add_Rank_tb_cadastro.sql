-- V2: Migrations para adicionar a coluna de ranking na tabela de cadastro
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);