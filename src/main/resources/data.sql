-- table roles entries
INSERT INTO roles (type_name) VALUES ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_TEACHER'), ('ROLE_STUDENT');

-- table users entries
INSERT INTO users(name, surname, email, type, password, username, role_id, deleted)
VALUES  ('Ewa', 'Zwierzyńska', 'ewa.zwierzynska@java.com', 'Admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'ewa', 1, false),
        ('Kasia', 'Łazar', 'kasia.lazar@java.com','Admin', '$2a$10$kWfkrOiCL4t1ZhIrWvvGbOjCJY5FMzFBYHcyLm7fOFxAJCmIS8KJm', 'kate', 1, false),
        ('Kasia', 'Suchanek', 'kasia.suchanek@java.com', 'Admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'kasia', 1, false),
        ('Franek', 'User', 'java.user@java.com','User', '$2a$10$BaG/azuGkeNwVUJK7XWcm.aGvBmk.WW5A.5dqs9CWZvZk8IPngSAK', 'user1', 2, false),
        ('Wanda', 'User', 'java.test@java.com','User', '$2a$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru', 'user2', 2, false),
        ('Andy', 'Teacher', 'teacher.test@java.com','Teacher', '$2y$10$7Qhibo0YYt0AZejwebHTFutUL62lPpoRsuqP6i5dVHK.j2YAdtIXi', 'teacher', 3, false),
        ('Luka', 'Sky', 'luka.test@java.com','Student', '$2y$10$8b7JeE.1Mrw0SROfdUQcy.gF4gYn4eQ5IF61lQjDBLYZV1mNKBJnO', 'student', 4, false);

-- table role_user entries
--INSERT INTO role_user VALUES (1,1), (1,2), (1,3), (2,4), (2,5), (3,6), (4,7);

-- table course entries
INSERT INTO course(name, description, base_price, type, start_date, end_date, total_hours, capacity, enroll)
VALUES
    ('Java Developer', 'Zostań back-end developerem – programuj logikę, która stoi za dużymi i zaawansowanymi systemami webowymi.', 15000, 'weekendowy (online)', '2023-12-01', '2024-02-01', 295, 30, 12),
    ('Tester Manualny', 'Zostań testerem oprogramowania – naucz się sprawdzać poprawność działania stron i aplikacji internetowych.', 15000, 'online', '2023-12-01', '2024-02-01', 295, 30, 12),
    ('Data Scientist', 'Zdobądź kompetencje data science od podstaw', 15000, 'online', '2023-12-01', '2024-02-01', 295, 30, 12);

-- table module entries
INSERT INTO module(subject, user_id, start_date, end_date, total_hours)
VALUES
    ('SQL', 6, '2023-12-01', '2023-12-21', 30),
    ('Machine Learning', 6, '2023-12-01', '2023-12-21', 15),
    ('JavaScript', 6, '2023-12-01', '2023-12-21', 45),
    ('Python', 6, '2023-12-01', '2023-12-21', 60),
    ('Java Podstawy', 6, '2023-12-01', '2023-12-21', 60);

-- table package entries
INSERT INTO package VALUES (1,5), (2,3), (3,4), (3,2), (1,1);
