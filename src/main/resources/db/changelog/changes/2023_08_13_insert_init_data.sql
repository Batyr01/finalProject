INSERT INTO t_categories (name)
VALUES
    ('Телефон'),
    ('Ноутбук'),
    ('Планшет'),
    ('Компьютер'),
    ('Наушники');

INSERT INTO t_permissions (name)
VALUES
    ('ROLE_USER'),
    ('ROLE_MANAGER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, password, full_name)
VALUES
    ('batyr@mail.ru', '$2a$10$EW8tExcV9X0hxfpO7Zkznu0E6ZdKR.xgW/ZbefYBYUGH0QyN60LqO', 'Hudaybergenov Batyrhan'),
    ('berik@gmail.com', '$2a$10$EW8tExcV9X0hxfpO7Zkznu0E6ZdKR.xgW/ZbefYBYUGH0QyN60LqO', 'Berik Hudaybergen'),
    ('munira@mail.ru', '$2a$10$EW8tExcV9X0hxfpO7Zkznu0E6ZdKR.xgW/ZbefYBYUGH0QyN60LqO', 'Munira Hudaybergen');

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES
    (1, 3),
    (2, 1),
    (3, 2);

INSERT INTO t_products (name, description, price, category_id)
VALUES
    ('iPhone 15', 'High-end smartphone', 780000, 1);