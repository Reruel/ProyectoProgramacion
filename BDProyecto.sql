drop database if exists ProyectoProgramacion;
create database ProyectoProgramacion;
use ProyectoProgramacion;

create table usuario (
email varchar (150) primary key,
nombre varchar (30),
contraseña varchar (30),
alergeno varchar (30)
);

create table comida (
nombre varchar (30), 
precio int,
ingredientes varchar
