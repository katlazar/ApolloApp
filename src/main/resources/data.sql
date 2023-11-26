-- table users entries
INSERT INTO users(name, surname, email, type, password, username)
VALUES  ('Ewa', 'Zwierzyńska', 'ewa.zwierzynska@java.com', 'admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'ewa'),
        ('Kasia', 'Łazar', 'kasia.lazar@java.com','admin', '$2a$10$kWfkrOiCL4t1ZhIrWvvGbOjCJY5FMzFBYHcyLm7fOFxAJCmIS8KJm', 'kate'),
        ('Kasia', 'Suchanek', 'kasia.suchanek@java.com', 'admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'kasia'),
        ('Java', 'Java', 'java.user@java.com','user', '$2a$10$BaG/azuGkeNwVUJK7XWcm.aGvBmk.WW5A.5dqs9CWZvZk8IPngSAK', 'user'),
        ('Java', 'Java', 'java.test@java.com','user', '$2a$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru', 'test');

-- table roles entries
INSERT INTO roles (type_name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- table role_user entries
INSERT INTO role_user VALUES (1,1), (1,2), (1,3), (2,4), (2,5);