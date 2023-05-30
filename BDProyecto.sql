drop database if exists ProyectoProgramacion;
create database ProyectoProgramacion;
use ProyectoProgramacion;

create table usuario (                                    
nombre varchar (50) primary key,
contraseña varchar (30),
alergeno varchar (50)
);

create table restaurante (
nombre varchar (50) primary key,
ciudad varchar (50)
);

create table alimento (
nombre varchar (50) primary key,
precio float
);

insert into alimento (nombre, precio) values ('Caprese', 9.80), 
('Parmigiana de Berenjena con queso y tomate', 8.70), ('Peperonata', 7.80), ('Antipasto Calabrese', 17.00), 
('Pizza napoli', 6.50),
('Patatas alioli', 3.85), ('Huevos rotos con picadillo', 6.80), ('Mejillones al vapor', 5.20), 
('Calamares', 6.80), ('Callos a la madrileña', 6.75), ('Tallarines udon fritos', 6.95), 
('Tempura de langostinos', 12.95), ('Nigiri de salmon', 3.20), ('Sopa de miso', 2.90), 
('Ensalada de pulpo y pepino', 5.95), ('McCrispy', 6.95), ('Bolitas de pollo', 3.40), 
('Patatas Deluxe', 2.40), ('Menú4You', 4.90), ('McXtreme',7.95), ('Contramuslo a la parrilla', 7.95), 
('Empanada argentina', 3.5), ('Milanesa de ternera', 7.95), ('Morcilla', 3.6), ('Carne mechada', 7.90),

('Coca cola', 2.80), ('Coca zero', 2.80), ('Fanta', 2.80), 
('7up', 2.80), ('Agua mineral', 2.60), ('Agua con gas', 2.80), ('Tinto de verano con limon', 2.80), 
('Zumo de piña', 2.60), ('Zumo de melocoton', 2.80), ('Caña', 2.80), ('Jarra', 4.20),
('Cruzcampo', 2.70), ('Cruzcampo sin gluten', 2.80), ('Peroni', 3.80), ('Lambrusco', 3.40), 
('Prosecco', 23.00), ('Mataespesa', 3.70), ('Finca Engalia Crianza', 18.00), ('Moreti', 3.80), 
('Cafe solo', 1.80), ('Cafe con leche', 2.20), ('Manzanilla', 2.00), ('Te', 2.10), ('Carajillo', 3.20), 

('Tiramisu', 6.20), ('Profiteroles', 6.00), ('Cannoli Siciliani', 6.00), ('Postre del dia', 6.50),
('Arroz con leche y canela', 2.85), ('Tarta de bizcocho de manzana', 2.85), 
('Copa de yogur con mermelada', 2.80), ('Flan de queso', 2.80), ('Natillas con galleta', 2.70),
('Sorbete de limon', 2.50), ('Platano frito', 2.50), ('Daifuku', 3.50), ('Chocolate de te verde', 3.95), 
('Te matcha', 1.20), ('McFlurry de kitkat y caramelo', 3.20), ('Sundae de fresa', 2.20), 
('McFlurry de oreo y chocolate', 3.20), ('Sundae de chocolate blanco', 2.20), 
('Actimel banana minions', 1.50), ('Pastel de frutas', 3.10), ('Panacotta', 3.40), 
('Helado tres sabores', 2.00), ('Flan de turron', 2.80);

create table plato (
nombre varchar (50) primary key,
precio float
);

create table bebida (
nombre varchar (50) primary key,
precio float,
tamaño varchar (30)
);

create table postre (
nombre varchar (50) primary key,
precio float
);

create table alergenos (
nombre varchar (50) primary key
);

create table ingrediente (
nombre varchar (50) primary key,
alergeno varchar (50)
);

create table usuario_alergenos (
nombreUsuario varchar (50),
nombreAlergeno varchar (50),
foreign key (nombreAlergeno) references alergenos(nombre),
foreign key (nombreUsuario) references usuario(nombre)
);

create table ingrediente_alimento (
nombreIngrediente varchar (50),
nombreAlimento varchar (50),
foreign key (nombreIngrediente) references ingrediente(nombre),
foreign key (nombreAlimento) references alimento(nombre)
);

create table platoRestaurante (
nombreRestaurante varchar(50),
nombreAlimento varchar(50),
foreign key (nombreRestaurante) references Restaurante(nombre),
foreign key (nombreAlimento) references alimento(nombre)
);

insert into restaurante (nombre, ciudad) values 
('Italiano Da Saveria', 'Malaga'), ('Restaurante Miguel', 'Malaga'),
('Japonés Asakusa', 'Malaga'),('McDonalds', 'Malaga'),('Asador La Marca','Malaga');

insert into plato (nombre, precio) values 
('Caprese', 9.80), ('Parmigiana de Berenjena con queso y tomate', 8.70),
('Peperonata', 7.80), ('Antipasto Calabrese', 17.00), ('Pizza napoli', 6.50),

('Patatas alioli', 3.85), ('Huevos rotos con picadillo', 6.80), ('Mejillones al vapor', 5.20), 
('Calamares', 6.80), ('Callos a la madrileña', 6.75),

('Tallarines udon fritos', 6.95), ('Tempura de langostinos', 12.95), ('Nigiri de salmon', 3.20), 
('Sopa de miso', 2.90), ('Ensalada de pulpo y pepino',5.95),

('McCrispy', 6.95), ('Bolitas de pollo', 3.40), ('Patatas Deluxe', 2.40), 
('Menu4You', 4.90), ('McXtreme',7.95),

('Contramuslo a la parrilla', 7.95), ('Empanada argentina', 3.5), ('Milanesa de ternera', 7.95), 
('Morcilla', 3.6), ('Carne mechada', 7.90);

insert into bebida (nombre, precio, tamaño) values 
('Coca cola', 2.80, 'mediano'), ('Coca zero', 2.80, 'mediano'), ('Fanta', 2.80, 'mediano'), 
('7up', 2.80, 'mediano'), ('Agua mineral', 2.60, 'mediano'), ('Agua con gas', 2.80, 'mediano'), 
('Tinto de verano con limón', 2.80, 'mediano'), ('Zumo de piña', 2.60, 'pequeño'), 
('Zumo de melocoton', 2.80, 'pequeño'), ('Caña', 2.80, 'pequeño'), ('Jarra', 4.20, 'grande'),
('Cruzcampo', 2.70, 'mediano'), ('Cruzcampo sin gluten', 2.80, 'mediano'), ('Peroni', 3.80, 'mediano'),
('Lambrusco', 3.40, 'mediano'), ('Prosecco', 23.00, 'grande'), ('Mataespesa', 3.70, 'pequeño'),
('Finca Engalia Crianza', 18.00, 'grande'), ('Moreti', 3.80, 'mediano'), ('Cafe solo', 1.80, 'pequeño'), 
('Cafe con leche', 2.20, 'pequeño'), ('Manzanilla', 2.00, 'pequeño'), ('Te', 2.10, 'pequeño'),
('Carajillo', 3.20, 'pequeño');

insert into postre (nombre, precio) values 
('Tiramisu', 6.20), ('Profiteroles', 6.00), ('Cannoli Siciliani', 6.00), ('Postre del dia', 6.50),

('Arroz con leche y canela', 2.85), ('Tarta de bizcocho de manzana', 2.85), 
('Copa de yogur con mermelada', 2.80), ('Flan de queso', 2.80), ('Natillas con galleta', 2.70),

('Sorbete de limon', 2.50), ('Platano frito', 2.50), ('Daifuku', 3.50), ('Chocolate de te verde', 3.95), 
('Te matcha', 1.20),

('McFlurry de kitkat y caramelo', 3.20), ('Sundae de fresa', 2.20), ('McFlurry de oreo y chocolate', 3.20), 
('Sundae de chocolate blanco', 2.20), ('Actimel banana minions', 1.50),

('Pastel de frutas', 3.10), ('Panacotta', 3.40), ('Helado tres sabores', 2.00), ('Flan de turron', 2.80);

insert into ingrediente (nombre, alergeno) values 

('Mozzarela de bufala', 'LECHE'), ('Tomate', null), ('Albahaca', null), ('Aceite de oliva', null),
('Berenjena', null), ('Queso', 'LECHE'), ('Salsa de tomate', 'GLUTEN'), ('Cebolla', null), 
('Pimiento', null), ('Calabacin', null), ('Spinata picante', null), ('Capicollo', null), 
('Queso pecorino', 'LECHE'), ('Queso provolone', 'LECHE'), ('Tomate seco', null), ('Ajo', null), 
('Aceitunas negras', null), ('Nata', 'LECHE'), ('Cafe', null), ('Sal', null), ('Leche', 'LECHE'),
('Galleta', 'GLUTEN'), ('Vainilla', null), ('Arroz', 'GLUTEN'), ('Canela', null), ('Manzana', null),
('Caramelo', null), ('Pan rallado', 'GLUTEN'), ('Limon', null), ('Te', null), ('Agua', null),
('Mermelada', null), ('Platano', null), ('Yogur', 'LECHE'), ('queso-crema Mascarpone', 'LECHE'), 
('Huevo', 'HUEVOS'), ('Azucar glass', null), ('Azucar', null), ('Marsala', null), 
('Bizcochos savoiardi', 'GLUTEN'), ('Amaretto', null), ('Cacao puro en polvo', null), 
('Canela en rama', null), ('Maizena', 'GLUTEN'), ('Harina', 'GLUTEN'), ('Mantequilla', 'LECHE'), 
('Piel de limon', null), ('Queso Ricotta', 'LECHE'), ('Chips de chocolate', null), ('Malta', 'GLUTEN'),
('Cebada', 'GLUTEN'), ('Vino', 'SULFITOS'), ('Piña', null), ('Melocoton', null), 
('Licor', 'SULFITOS'), ('Langostinos', 'CRUSTACEOS'), ('Masa madre', 'GLUTEN'), ('Patata', null),
('Calamar', 'CRUSTACEOS'), ('Garbanzo', null), ('Tallarin', 'GLUTEN'), ('Mejillon', 'CRUSTACEOS'),
('Salmon', 'PESCADO'), ('Pan', 'SESAMO'), ('Vinagre', null), ('Salsa de soja', 'SOJA'), 
('Brotes de soja', 'SOJA'), ('Pulpo', 'MOLUSCOS'), ('Salsa de mostaza', 'MOSTAZA'), ('Pepino', null),
('Pollo', null), ('Ternera', null), ('Salsa de ketchup', null), ('Morcilla', null);

insert into alergenos (nombre) values 
('GLUTEN'), ('CRUSTACEOS'), ('HUEVOS'), ('PESCADO'),('CACAHUETES'), ('SOJA'), ('LECHE'), 
('FRUTOSCASCARA'), ('APIO'), ('MOSTAZA'), ('SESAMO'), ('SULFITOS'), ('ALTRAMUCES'),
('MOLUSCOS');


CREATE TABLE ingredientesAlimentos (
  alimento_nombre varchar(50),
  ingrediente_nombre varchar(50),
  PRIMARY KEY (alimento_nombre, ingrediente_nombre),
  FOREIGN KEY (alimento_nombre) REFERENCES alimento(nombre),
  FOREIGN KEY (ingrediente_nombre) REFERENCES ingrediente(nombre)
);

insert into ingredientesAlimentos (alimento_nombre, ingrediente_nombre)
values ('Huevos rotos con picadillo', 'Huevo'),
       ('Huevos rotos con picadillo', 'Patata'),
       ('Huevos rotos con picadillo', 'Cebolla'),
       ('Huevos rotos con picadillo', 'Aceite de oliva'),
       ('Mejillones al vapor', 'Mejillon'),
       ('Mejillones al vapor', 'Aceite de oliva'),
       ('Calamares', 'Calamar'),
       ('Calamares', 'Harina'),
       ('Calamares', 'Aceite de oliva'),
       ('Callos a la madrileña', 'Garbanzo'),
       ('Callos a la madrileña', 'Morcilla'),
       ('Tallarines udon fritos', 'Tallarin'),
       ('Tallarines udon fritos', 'Aceite de oliva'),
       ('Tempura de langostinos', 'Harina'),
       ('Tempura de langostinos', 'Aceite de oliva'),
       ('Nigiri de salmon', 'Arroz'),
       ('Sopa de miso', 'Agua'),
       ('Ensalada de pulpo y pepino', 'Aceite de oliva'),
       ('McCrispy', 'Pollo'),
       ('McCrispy', 'Sal'),
       ('Bolitas de pollo', 'Pollo'),
       ('Bolitas de pollo', 'Huevo'),
       ('Patatas Deluxe', 'Patata'),
       ('Patatas Deluxe', 'Queso'),
       ('Menu4You', 'Patata'),
       ('McXtreme', 'Queso'),
       ('McXtreme', 'Patata'),
       ('Contramuslo a la parrilla', 'Aceite de oliva'),
       ('Contramuslo a la parrilla', 'Sal'),
       ('Empanada argentina', 'Cebolla'),
       ('Milanesa de ternera', 'Huevo'),
       ('Milanesa de ternera', 'Pan rallado'),
       ('Morcilla', 'Morcilla'),
       ('Carne mechada', 'Cebolla'),
       ('Carne mechada', 'Ajo'),
       ('Carne mechada', 'Aceite de oliva'),
       ('Carne mechada', 'Sal'),
       ('Coca cola', 'Agua'),
       ('Coca zero', 'Agua'),
       ('Fanta', 'Agua'),
       ('7up', 'Agua'),
       ('Agua mineral', 'Agua'),
       ('Agua con gas', 'Agua'),
       ('Tinto de verano con limon', 'Agua'),
       ('Zumo de piña', 'Agua'),
       ('Zumo de melocotón', 'Agua'),
       ('Caña', 'Cebada'),
       ('Jarra', 'Cebada'),
       ('Cruzcampo', 'Cebada'),
       ('Cruzcampo sin gluten', 'Cebada'),
       ('Peroni', 'Cebada'),
       ('Lambrusco', 'Agua'),
       ('Prosecco', 'Agua'),
       ('Mataespesa', 'Agua'),
       ('Finca Engalia Crianza', 'Agua'),
       ('Moreti', 'Agua'),
       ('Cafe con leche', 'Leche'),
       ('Manzanilla', 'Agua'),
       ('Te', 'Agua'),
       ('Tiramisu', 'Huevo'),
       ('Tiramisu', 'Azucar'),
       ('Tiramisu', 'queso-crema Mascarpone'),
       ('Tiramisu', 'Bizcochos savoiardi'),
       ('Tiramisu', 'Cacao puro en polvo'),
       ('Profiteroles', 'Huevo'),
       ('Profiteroles', 'Harina'),
       ('Profiteroles', 'Mantequilla'),
       ('Profiteroles', 'Azucar'),
       ('Profiteroles', 'Sal'),
       ('Profiteroles', 'Nata'),
       ('Cannoli Siciliani', 'Harina'),
       ('Cannoli Siciliani', 'Azucar'),
       ('Cannoli Siciliani', 'Sal'),
       ('Cannoli Siciliani', 'Mantequilla'),
       ('Cannoli Siciliani', 'Queso ricotta'),
       ('Cannoli Siciliani', 'Azucar glass'),
       ('Arroz con leche y canela', 'Arroz'),
       ('Arroz con leche y canela', 'Leche'),
       ('Arroz con leche y canela', 'Azucar'),
       ('Arroz con leche y canela', 'Canela'),
       ('Tarta de bizcocho de manzana', 'Harina'),
       ('Copa de yogur con mermelada', 'Yogur'),
       ('Copa de yogur con mermelada', 'Azucar'),
       ('Flan de queso', 'Azucar'),
       ('Flan de queso', 'Queso-crema Mascarpone'),
       ('Natillas con galleta', 'Leche'),
       ('Natillas con galleta', 'Galleta'),
       ('Sorbete de limon', 'Limon'),
       ('Platano frito', 'Platano'),
       ('Daifuku', 'Arroz'),
       ('Daifuku', 'Azucar'),
       ('Te matcha', 'Te'),
       ('McFlurry de kitkat y caramelo', 'Leche'),
       ('McFlurry de kitkat y caramelo', 'Azucar'),
       ('Sundae de fresa', 'Leche'),
       ('McFlurry de oreo y chocolate', 'Leche'), 
       ('Sundae de chocolate blanco', 'Leche'),
       ('Actimel banana minions', 'Leche'), -- ta bien
       ('Panacotta', 'Azucar'),
       ('Panacotta', 'Queso'),
       ('Helado tres sabores', 'Leche'), -- ta mal
       ('Flan de turron', 'Huevo'),
       ('Flan de turron', 'Leche'),
       ('Flan de turron', 'Azucar');

-- Insert into restauranteAlimentos values("pizza","restaurante italiano"),("coca cola", "restaurante italiano"),("coca cola", "restaurante pepito");
-- Crear tabla intermedia restauranteAlimentos
CREATE TABLE restauranteAlimentos (
  restaurante_nombre varchar(50),
  alimento_nombre varchar(50),
  PRIMARY KEY (restaurante_nombre, alimento_nombre),
  FOREIGN KEY (restaurante_nombre) REFERENCES restaurante(nombre),
  FOREIGN KEY (alimento_nombre) REFERENCES alimento(nombre)
);

insert into restauranteAlimentos (restaurante_nombre, alimento_nombre)
values 
('Italiano Da Saveria', 'Caprese'),
('Italiano Da Saveria', 'Parmigiana de Berenjena con queso y tomate'),
('Italiano Da Saveria', 'Peperonata'),
('Italiano Da Saveria', 'Antipasto Calabrese'),
('Italiano Da Saveria', 'Pizza napoli'),
('Italiano Da Saveria', 'Coca cola'),
('Italiano Da Saveria', 'Coca zero'),
('Italiano Da Saveria', 'Fanta'),
('Italiano Da Saveria', '7up'),
('Italiano Da Saveria', 'Agua mineral'),
('Italiano Da Saveria', 'Agua con gas'),
('Italiano Da Saveria', 'Tinto de verano con limon'),
('Italiano Da Saveria', 'Zumo de piña'),
('Italiano Da Saveria', 'Zumo de melocoton'),
('Italiano Da Saveria', 'Caña'),
('Italiano Da Saveria', 'Jarra'),
('Italiano Da Saveria', 'Cruzcampo'),
('Italiano Da Saveria', 'Cruzcampo sin gluten'),
('Italiano Da Saveria', 'Peroni'),
('Italiano Da Saveria', 'Lambrusco'),
('Italiano Da Saveria', 'Prosecco'),
('Italiano Da Saveria', 'Mataespesa'),
('Italiano Da Saveria', 'Finca Engalia Crianza'),
('Italiano Da Saveria', 'Moreti'),
('Italiano Da Saveria', 'Cafe solo'),
('Italiano Da Saveria', 'Cafe con leche'),
('Italiano Da Saveria', 'Manzanilla'),
('Italiano Da Saveria', 'Te'),
('Italiano Da Saveria', 'Carajillo'),
('Italiano Da Saveria', 'Tiramisu'),
('Italiano Da Saveria', 'Profiteroles'),
('Italiano Da Saveria', 'Cannoli Siciliani'),
('Italiano Da Saveria', 'Postre del dia'),

('Restaurante Miguel', 'Patatas alioli'),
('Restaurante Miguel', 'Huevos rotos con picadillo'),
('Restaurante Miguel', 'Mejillones al vapor'),
('Restaurante Miguel', 'Calamares'),
('Restaurante Miguel', 'Callos a la madrileña'),
('Restaurante Miguel', 'Coca cola'),
('Restaurante Miguel', 'Coca zero'),
('Restaurante Miguel', 'Fanta'),
('Restaurante Miguel', '7up'),
('Restaurante Miguel', 'Agua mineral'),
('Restaurante Miguel', 'Agua con gas'),
('Restaurante Miguel', 'Tinto de verano con limon'),
('Restaurante Miguel', 'Zumo de piña'),
('Restaurante Miguel', 'Zumo de melocoton'),
('Restaurante Miguel', 'Caña'),
('Restaurante Miguel', 'Jarra'),
('Restaurante Miguel', 'Cruzcampo'),
('Restaurante Miguel', 'Cruzcampo sin gluten'),
('Restaurante Miguel', 'Mataespesa'),
('Restaurante Miguel', 'Finca Engalia Crianza'),
('Restaurante Miguel', 'Cafe solo'),
('Restaurante Miguel', 'Cafe con leche'),
('Restaurante Miguel', 'Manzanilla'),
('Restaurante Miguel', 'Te'),
('Restaurante Miguel', 'Carajillo'),
('Restaurante Miguel', 'Arroz con leche y canela'),
('Restaurante Miguel', 'Tarta de bizcocho de manzana'),
('Restaurante Miguel', 'Copa de yogur con mermelada'),
('Restaurante Miguel', 'Flan de queso'),
('Restaurante Miguel', 'Natillas con galleta'),

('Japonés Asakusa', 'Tallarines udon fritos'),
('Japonés Asakusa', 'Tempura de langostinos'),
('Japonés Asakusa', 'Nigiri de salmon'),
('Japonés Asakusa', 'Sopa de miso'),
('Japonés Asakusa', 'Ensalada de pulpo y pepino'),
('Japonés Asakusa', 'Coca cola'),
('Japonés Asakusa', 'Coca zero'),
('Japonés Asakusa', 'Fanta'),
('Japonés Asakusa', '7up'),
('Japonés Asakusa', 'Agua mineral'),
('Japonés Asakusa', 'Agua con gas'),
('Japonés Asakusa', 'Tinto de verano con limon'),
('Japonés Asakusa', 'Zumo de piña'),
('Japonés Asakusa', 'Zumo de melocoton'),
('Japonés Asakusa', 'Caña'),
('Japonés Asakusa', 'Jarra'),
('Japonés Asakusa', 'Cruzcampo'),
('Japonés Asakusa', 'Cruzcampo sin gluten'),
('Japonés Asakusa', 'Mataespesa'),
('Japonés Asakusa', 'Finca Engalia Crianza'),
('Japonés Asakusa', 'Cafe solo'),
('Japonés Asakusa', 'Cafe con leche'),
('Japonés Asakusa', 'Manzanilla'),
('Japonés Asakusa', 'Te'),
('Japonés Asakusa', 'Carajillo'),
('Japonés Asakusa', 'Sorbete de limon'),
('Japonés Asakusa', 'Platano frito'),
('Japonés Asakusa', 'Daifuku'),
('Japonés Asakusa', 'Chocolate de te verde'),
('Japonés Asakusa', 'Te matcha'),

('McDonalds', 'McCrispy'),
('McDonalds', 'Bolitas de pollo'),
('McDonalds', 'Patatas deluxe'),
('McDonalds', 'Menú4You'),
('McDonalds', 'McXtreme'),
('McDonalds', 'Coca cola'),
('McDonalds', 'Coca zero'),
('McDonalds', 'Fanta'),
('McDonalds', '7up'),
('McDonalds', 'Agua mineral'),
('McDonalds', 'Agua con gas'),
('McDonalds', 'Tinto de verano con limon'),
('McDonalds', 'Zumo de piña'),
('McDonalds', 'Zumo de melocoton'),
('McDonalds', 'Caña'),
('McDonalds', 'Cafe solo'),
('McDonalds', 'Cafe con leche'),
('McDonalds', 'Manzanilla'),
('McDonalds', 'Té'),
('McDonalds', 'Carajillo'),
('McDonalds', 'McFlurry de kitkat y caramelo'),
('McDonalds', 'Sundae de fresa'),
('McDonalds', 'McFlurry de oreo y chocolate'),
('McDonalds', 'Sundae de chocolate blanco'),
('McDonalds', 'Actimel de banana minions'),

('Asador La Marca', 'Contramuslo a la parrilla'),
('Asador La Marca', 'Empanada argentina'),
('Asador La Marca', 'Milanesa de ternera'),
('Asador La Marca', 'Morcilla'),
('Asador La Marca', 'Carne mechada'),
('Asador La Marca', 'Coca cola'),
('Asador La Marca', 'Coca zero'),
('Asador La Marca', 'Fanta'),
('Asador La Marca', '7up'),
('Asador La Marca', 'Agua mineral'),
('Asador La Marca', 'Agua con gas'),
('Asador La Marca', 'Tinto de verano con limon'),
('Asador La Marca', 'Zumo de piña'),
('Asador La Marca', 'Zumo de melocoton'),
('Asador La Marca', 'Caña'),
('Asador La Marca', 'Jarra'),
('Asador La Marca', 'Cruzcampo'),
('Asador La Marca', 'Cruzcampo sin gluten'),
('Asador La Marca', 'Mataespesa'),
('Asador La Marca', 'Finca Engalia Crianza'),
('Asador La Marca', 'Cafe solo'),
('Asador La Marca', 'Cafe con leche'),
('Asador La Marca', 'Manzanilla'),
('Asador La Marca', 'Te'),
('Asador La Marca', 'Carajillo'),
('Asador La Marca', 'Pastel de frutas'),
('Asador La Marca', 'Panacotta'),
('Asador La Marca', 'Helado tres sabores'),
('Asador La Marca', 'Flan de turron');
