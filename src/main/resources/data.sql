INSERT INTO users(id, name, surname, email, type, password, username)
VALUES (1, 'Ewa', 'Zwierzyńska', 'ewa.zwierzynska@java.com', 'admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'ewa');

INSERT INTO users(id, name, surname, email, type, password, username)
VALUES (2, 'Kasia', 'Łazar', 'kasia.lazar@java.com','admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'kate');

INSERT INTO users(id, name, surname, email, type, password, username)
VALUES (3, 'Kasia', 'Suchanek', 'kasia.suchanek@java.com', 'admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'kasia');



INSERT INTO roles (type_name) VALUES ('ROLE_ADMIN');
INSERT INTO role_user VALUES (1,1),(1,2),(1,3);