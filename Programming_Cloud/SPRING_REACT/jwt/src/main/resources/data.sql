INSERT INTO product (id, type, brand) VALUES (1, 'iPhoneXS', 'iPhone' );
INSERT INTO product (id, type, brand) VALUES (2, 'iPhone6', 'iPhone' );
INSERT INTO product (id, type, brand) VALUES (3, 'iPhoneXS MAX', 'iPhone' );
INSERT INTO product (id, type, brand) VALUES (4, 'iPhoneX', 'iPhone' );
INSERT INTO product (id, type, brand) VALUES (5, 'Samsung10', 'samsung' );
INSERT INTO product (id, type, brand) VALUES (6, 'Samsung8', 'samsung' );

UPDATE hibernate_sequence SET next_val = 7;


INSERT INTO user (id, username, password, role) VALUES (1, 'vitkoz', '$2y$12$5wuGVC54QyodYI4zHSFWD.W1nW3y.AjEF0PssgpRQP0tbSAuZHSQO', 'USER');