INSERT INTO per_entidad (id_entidad, nombre, fecha_creacion, fecha_modificacion) VALUES (1, 'Entidad de prueba', sysdate, sysdate);
INSERT INTO per_grupo(id_grupo, nombre, fecha_creacion, fecha_modificacion) VALUES (1, 'Administrador', sysdate, sysdate);
INSERT INTO per_persona(id_persona, nombre, telefono, correo, activo, fecha_registro, fecha_modificacion, fecha_baja, id_entidad) VALUES (1, 'Juan Marino', '666666666', 'JuanMarino@gmail.com', TRUE, sysdate, sysdate, NULL, 1);
INSERT INTO per_persona(id_persona, nombre, telefono, correo, activo, fecha_registro, fecha_modificacion, fecha_baja, id_entidad) VALUES (2, 'Jorge Colon', '777777777', 'JorgeColon@gmail.com', TRUE, sysdate, sysdate, NULL, 1);
INSERT INTO per_persona(id_persona, nombre, telefono, correo, activo, fecha_registro, fecha_modificacion, fecha_baja, id_entidad) VALUES (3, 'Eva Muiño', '888888888', 'EvaMuiño@gmail.com', TRUE, sysdate, sysdate, NULL, 1);
INSERT INTO per_miembro(id_persona, id_grupo) VALUES (1,1);
INSERT INTO per_miembro(id_persona, id_grupo) VALUES (3,1);