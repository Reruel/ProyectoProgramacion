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

create table ingrediente (
nombre varchar (50) primary key,
alergeno varchar (50)
);

create table alergenos (
nombre varchar (50) primary key
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
('Italiano Da Saveria', 'Málaga'), ('Restaurante Miguel', 'Málaga'),
('Japonés Asakusa', 'Málaga'),('McDonalds', 'Málaga'),('Asador La Marca','Málaga');

insert into plato (nombre, precio) values 
('Caprese', 9.80), ('Parmigiana de Berenjena con queso y tomate', 8.70),
('Peperonata', 7.80), ('Antipasto Calabrese', 17.00), ('Pizza napoli', 6.50),

('Patatas alioli', 3.85), ('Huevos rotos con picadillo', 6.80), ('Mejillones al vapor', 5.20), 
('Calamares', 6.80), ('Callos a la madrileña', 6.75),

('Tallarines udon fritos', 6.95), ('Tempura de langostinos', 12.95), ('Nigiri de salmon', 3.20), 
('Sopa de miso', 2.90), ('Ensalada de pulpo y pepino',5.95),

('McCrispy', 6.95), ('Bolitas de pollo', 3.40), ('Patatas Deluxe', 2.40), 
('Menú4You', 4.90), ('McXtreme',7.95),

('Contramuslo a la parrilla', 7.95), ('Empanada argentina', 3.5), ('Milanesa de ternera', 7.95), 
('Morcilla', 3.6), ('Carne mechada', 7.90);

insert into bebida (nombre, precio, tamaño) values 
('Coca cola', 2.80, 'mediano'), ('Coca zero', 2.80, 'mediano'), ('Fanta', 2.80, 'mediano'), 
('7up', 2.80, 'mediano'), ('Agua mineral', 2.60, 'mediano'), ('Agua con gas', 2.80, 'mediano'), 
('Tinto de verano con limón', 2.80, 'mediano'), ('Zumo de piña', 2.60, 'pequeño'), 
('Zumo de melocotón', 2.80, 'pequeño'), ('Caña', 2.80, 'pequeño'), ('Jarra', 4.20, 'grande'),
('Cruzcampo', 2.70, 'mediano'), ('Cruzcampo sin gluten', 2.80, 'mediano'), ('Peroni', 3.80, 'mediano'),
('Lambrusco', 3.40, 'mediano'), ('Prosecco', 23.00, 'grande'), ('Mataespesa', 3.70, 'pequeño'),
('Finca Engalia Crianza', 18.00, 'grande'), ('Moreti', 3.80, 'mediano'), ('Café solo', 1.80, 'pequeño'), 
('Café con leche', 2.20, 'pequeño'), ('Manzanilla', 2.00, 'pequeño'), ('Té', 2.10, 'pequeño'),
('Carajillo', 3.20, 'pequeño');

insert into postre (nombre, precio) values 
('Tiramisu', 6.20), ('Profiteroles', 6.00), ('Cannoli Siciliani', 6.00), ('Postre del dia', 6.50),

('Arroz con leche y canela', 2.85), ('Tarta de bizcocho de manzana', 2.85), 
('Copa de yogur con mermelada', 2.80), ('Flan de queso', 2.80), ('Natillas con galleta', 2.70),

('Sorbete de limon', 2.50), ('Platano frito', 2.50), ('Daifuku', 3.50), ('Chocolate de té verde', 3.95), 
('Te matcha', 1.20),

('McFlurry de kitkat y caramelo', 3.20), ('Sundae de fresa', 2.20), ('McFlurry de oreo y chocolate', 3.20), 
('Sundae de chocolate blanco', 2.20), ('Actimel banana minions', 1.50),

('Pastel de frutas', 3.10), ('Panacotta', 3.40), ('Helado tres sabores', 2.00), ('Flan de turron', 2.80);

insert into ingrediente (nombre, alergeno) values 

('Mozzarela de búfala', 'Leche'), ('Tomate', null), ('Albahaca', null), ('Aceite de oliva', null),
('Berenjena', null), ('Queso', 'leche'), ('Salsa de tomate', 'gluten'), ('Cebolla', null), 
('Pimiento', null), ('Calabacin', null), ('Spinata picante', null), ('Capicollo', null), 
('Queso pecorino', 'leche'), ('Queso provolone', 'leche'), ('Tomate seco', null), ('Ajo', null), 
('Aceitunas negras', null), ('Nata', 'leche'), ('Cafe', null), ('Sal', null), ('Leche', 'leche'),
('Galleta', 'gluten'), ('Vainilla', null), ('Arroz', 'gluten'), ('Canela', null), ('Manzana', null),
('Caramelo', null), ('Pan rallado', 'gluten'), ('Limon', null), ('Te', null), ('Agua', null),
('Mermelada', null), ('Platano', null), ('Yogur', 'leche'), ('queso-crema Mascarpone', 'leche'), 
('Huevo', 'huevos'), ('Azúcar glass', null), ('Azúcar', null), ('Marsala', null), 
('Bizcochos savoiardi', 'gluten'), ('Amaretto', null), ('Cacao puro en polvo', null), 
('Canela en rama', null), ('Maizena', 'gluten'), ('Harina', 'gluten'), ('Mantequilla', 'leche'), 
('Piel de limón', null), ('Queso Ricotta', 'leche'), ('Chips de chocolate', null), ('Malta', 'gluten'),
('Cebada', 'gluten'), ('Vino', 'sulfitos'), ('Piña', null), ('Melocoton', null), 
('Licor', 'sulfitos'), ('Langostinos', 'crustaceos'), ('Masa madre', 'gluten'), ('Patata', null),
('Calamar', 'crustaceos'), ('Garbanzo', null), ('Tallarin', 'gluten'), ('Mejillon', 'crustaceo'),
('Salmon', 'pescado'), ('Pan', 'sesamo'), ('Vinagre', null), ('Salsa de soja', 'soja'), 
('Brotes de soja', 'soja'), ('Pulpo', 'moluscos'), ('Salsa de mostaza', 'Mostaza'), ('Pepino', null),
('Pollo', null), ('Ternera', null), ('Salsa de ketchup', null), ('Morcilla', null);

insert into alergenos (nombre) values 
('Gluten'), ('Crustaceos'), ('Huevos'), ('Pescado'),('Cacahuetes'), ('Soja'),('Leche'), 
('Frutoscascara'), ('Apio'), ('Mostaza'), ('Sesamo'), ('Sulfitos'), ('Altramuces'),
('Moluscos');