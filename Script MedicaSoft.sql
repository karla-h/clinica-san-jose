/* Create Tables */

CREATE TABLE especialidad
(
	idEspecialidad char(4) NOT NULL,
	nombre varchar(50) NOT NULL,
	costo numeric(8,2) NOT NULL,
	CONSTRAINT pk_especialidad	PRIMARY KEY (idEspecialidad)
);


insert into especialidad values 
	('E001','Medicina General',50),
	('E002','Pediatría',50),
	('E003','Nutrición',50),
	('E004','Cardiología',50);
	



CREATE TABLE medico
(
	idMedico char(4) NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50)NOT NULL,
	dni varchar(50) NOT NULL,
	telefono varchar(9) NOT NULL,
	correo varchar(50)NOT NULL,
	citaMaxima int NOT NULL,
	idEspecialidad char(4) NOT NULL,
	CONSTRAINT pk_medico PRIMARY KEY (idMedico),
	CONSTRAINT fkMedicoEspecialidad FOREIGN KEY (idEspecialidad) 
		REFERENCES especialidad (idEspecialidad) ON DELETE No Action ON UPDATE No Action
);


insert into medico values 
	('M001','Jose','Lopez García','19023484','983258192','l.jose01.gmail.com',17,'E001'),
	('M002','Guillermo','Escobedo Valdez','19034782','992117345','vescobedo_g.gmail.com',17,'E002'),
	('M003','Marina','Mendoza Peña','98271023','974233126','mpeña_1829.gmail.com',17,'E003'),
	('M004','Carmen','Céspedes Moreno','40781217','918231412','carmencespedesm_12.gmail.com',3,'E004');

delete from medico

	
CREATE TABLE paciente
(
	idPaciente char(4) NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50)NOT NULL,
	dni varchar(50) NOT NULL,
	telefono varchar(9) NOT NULL,
	correo varchar(50) NOT NULL,
	aplicaDescuento boolean NOT NULL,
	CONSTRAINT pk_paciente PRIMARY KEY (idPaciente)
);	


insert into paciente values 
	('P001','Victoria','Gomez Abanto','76189012','954127512','victoria_gomez.gmail.com',true),
	('P002','Hugo','Acevedo Cabello','89123241','919925210','chugoac.92.gmail.com',false),
	('P003','Paola','Sánchez Torres','42198672','912315678','ptorresc_02.gmail.com',true),
	('P004','Martín','Montes Del Rosario','78214519','900241275','dmontesmartin.gmail.com',false);

CREATE TABLE cita
(
	idCita char(4) NOT NULL,
	fecha date NOT NULL,
	orden int NOT NULL,
	costoNeto numeric(8,2) NOT NULL,
	descuento numeric(8,2) NOT NULL,
	costoTotal numeric(8,2) NOT NULL,
	idPaciente char(4)NOT NULL,
	idMedico char(4) NOT NULL,	
	CONSTRAINT pk_cita PRIMARY KEY (idCita),
	CONSTRAINT fkCitaPaciente FOREIGN KEY (idPaciente)
		REFERENCES paciente (idPaciente) ON DELETE No Action ON UPDATE No Action,
	CONSTRAINT fkCitaMedico FOREIGN KEY (idMedico) 
		REFERENCES medico (idMedico) ON DELETE No Action ON UPDATE No Action
);	

select * from cita
delete from cita
select count (*) contador from paciente where aplicaDescuento=true



