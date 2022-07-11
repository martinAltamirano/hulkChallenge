INSERT INTO franchises (description) VALUES ('Marvel');
INSERT INTO franchises (description) VALUES ('DC Comics');

INSERT INTO products (description, franchise_id, price, stock, user_id) VALUES ('vaso',1,100.00,7,1);
INSERT INTO products (description, franchise_id, price, stock, user_id) VALUES ('remera',2,50.99,10,2);
INSERT INTO products (description, franchise_id, price, stock, user_id) VALUES ('gorra',2,70.00,14,3);
INSERT INTO products (description, franchise_id, price, stock, user_id) VALUES ('comic',1,80.99,9,4);

INSERT INTO users (created_at, email, first_name, last_name, registration_date, password, username)
VALUES ('2022-07-10T21:09:40.888353','martin@gmail.com', 'martin', 'bongiorno', {ts '2012-09-17 18:47:52.69'},'$2a$10$AnwWUlXg7iSu3IiZY84ay.egCvCBgKm2GaDN4kscXiM3AW9dYY5fq','$2a$10$XR1rBaQvSzZiSkgGIVwVq.n7xr3Z/z8FJ.mwroawkcdL8NnrAnVO6');
INSERT INTO users (created_at, email, first_name, last_name, registration_date, password, username)
VALUES ('2022-07-10T21:09:40.888353','india@gmail.com', 'india', 'altamirano', {ts '2012-09-17 18:47:52.69','$2a$10$AnwWUlXg7iSu3IiZY84ay.egCvCBgKm2GaDN4kscXiM3AW9dYY5fq','$2a$10$nRV7OSWcUsoCpwQQlZ5F4ORb5pIDQlt8FZch.knfL1YpDQMaWqQ4O'});
INSERT INTO users (created_at, email, first_name, last_name, registration_date, password, username)
VALUES ('2022-07-10T21:09:40.888353','bruno@gmail.com', 'bruno', 'altamirano', {ts '2012-09-17 18:47:52.69','$2a$10$AnwWUlXg7iSu3IiZY84ay.egCvCBgKm2GaDN4kscXiM3AW9dYY5fq','$2a$10$EwFYZSVgyZBtong1Zed4heDGujcMlnn7TkHtTuc8HhWsBMi91S2Mi'});
INSERT INTO users (created_at, email, first_name, last_name, registration_date, password, username)
VALUES ('2022-07-10T21:09:40.888353','james@gmail.com', 'james', 'rodriguez', {ts '2012-09-17 18:47:52.69','$2a$10$AnwWUlXg7iSu3IiZY84ay.egCvCBgKm2GaDN4kscXiM3AW9dYY5fq','2a$10$0jRzdfq.fP2K.JAVQ31fD.0.rB.vB4KORoKW8LnySb16DjdFIBv/O'});

