INSERT INTO `asignatura` (`nombre`,`codigo`) VALUES ('Matematicas Discretas', 'MAT101');
INSERT INTO `persona` (`persona_id`,`DTYPE`,`nombre`,`apellido`,`correo`) VALUES (1,'DocenteEntity','Jhossef','Constain','jhniconstain@unicauca.edu.co');
INSERT INTO `curso` (`curso_id`,`nombre`) VALUES (1,'Ingenieria Electronica 2024-1');
INSERT INTO `espacio_fisico` (`nombre`,`capacidad`) VALUES ('Sala 333','20 personas');

INSERT INTO `curso_docente` (`curso_id`, `docente_id`) VALUES (1, 1);