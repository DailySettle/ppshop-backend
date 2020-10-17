truncate table product;
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('bc02e789-f8b6-43c3-8394-db493036242c',
        0, 'Pizza 1',
        '/assets/image/products/pizza1.jpeg',
        'Pizza 1', 1, 20, false, true);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('9aa67806-6bc1-4ac4-a563-a8b8981339ef',
        0, 'Pizza 2',
        '/assets/image/products/pizza2.jpeg',
        'Pizza 2', 1.5, 30, 0, 1);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('25aa7196-f18a-4ae9-a6c2-716f424699ff',
        0, 'Pizza 3',
        '/assets/image/products/pizza3.jpeg',
        'Pizza 3', 0.9, 50, 0, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('47e39940-3aa0-4a32-adea-c99e9eda81cd',
        1, 'Orange',
        '/assets/image/products/orange.jpeg',
        'Orange', 1, 20, 1, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('606aadcc-bae6-4011-92d7-e059454acd02',
        1, 'Pear',
        '/assets/image/products/pear.jpeg',
        'Pear', 1.5, 30, 1, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('3bd24ffe-cb04-4d78-a294-897a4237e48c',
        1, 'Carrot',
        '/assets/image/products/carrot.jpeg',
        'Carrot', 0.9, 50, 1, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('ef81bb59-33a6-4c04-b255-6fb86835dda6',
        2, 'Haribo Happy-Colo',
        '/assets/image/products/haribo3.jpeg',
        'Haribo 1', 1, 20, 0, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('574628b3-e2b2-4fc6-b6d6-ea587057b40f',
        2, 'Haribo Tropifrutti',
        '/assets/image/products/haribo2.jpeg',
        'Haribo 2', 1.5, 30, 0, 0);
INSERT INTO product (id, category, description, image_url, name, price, quantity, is_new_arrive, is_on_sale)
VALUES ('707a874e-a170-44e8-918c-0c7aeb22d5f5',
        2, 'Haribo Goldbären',
        '/assets/image/products/haribo1.jpeg',
        'Haribo 3', 0.9, 500, 0, 0);

truncate table users;
INSERT INTO users (id, active, password, roles, username)
VALUES (0x018C35139BF5446E8D30B7F7E07191170000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,
        1, '$2a$10$w34K8WsouStD1sRWSi27c.ue6YWGyxBRW6q4pekX3IMzYBv/fyuF2',
        'ROLE_USER', 'ming@123');
