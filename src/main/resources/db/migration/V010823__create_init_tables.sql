CREATE TABLE t_categories
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE t_permissions
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE t_users
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    email     VARCHAR(255),
    password  VARCHAR(255),
    full_name VARCHAR(255)
);

CREATE TABLE t_products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255),
    price       INT,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES t_categories (id)
);

CREATE TABLE t_cart
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT,
    product_id BIGINT,
    quantity   INT,
    status     INT,
    FOREIGN KEY (user_id) REFERENCES t_users (id),
    FOREIGN KEY (product_id) REFERENCES t_products (id)
);

CREATE TABLE t_users_permissions
(
    user_id       BIGINT,
    permissions_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES t_users (id),
    FOREIGN KEY (permissions_id) REFERENCES t_permissions (id)
);
