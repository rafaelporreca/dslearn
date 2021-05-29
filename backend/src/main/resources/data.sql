INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brow', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name,img_uri,img_gray_uri) VALUES ('Bootcamp Html', 'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg','http://www.denisviana.com.br/wp-content/uploads/2021/04/aaasd-1024x660.jpg');

INSERT INTO tb_offer (edition,start_moment,end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z',1);
INSERT INTO tb_offer (edition,start_moment,end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00Z',1);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal', 1, 'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',1,1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',2,1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas', 3, 'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',0,1);

INSERT INTO tb_section (title,description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo 1','Neste capítulo vamos começar', 1,'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',1, null );
INSERT INTO tb_section (title,description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo 2','Neste capítulo vamos continuar', 2,'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',1, 1 );
INSERT INTO tb_section (title,description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo #','Neste capítulo vamos finalizar', 3,'https://www.publicdomainpictures.net/pictures/290000/velka/training-course.jpg',1, 2 );