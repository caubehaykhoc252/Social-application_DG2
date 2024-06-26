ALTER TABLE users
    MODIFY username VARCHAR(255) NOT NULL,
    MODIFY password VARCHAR(255) NOT NULL,
    MODIFY first_name VARCHAR(255) NOT NULL,
    MODIFY last_name VARCHAR(255) NOT NULL,
    MODIFY role VARCHAR(255) NOT NULL,
    MODIFY phone_number VARCHAR(255) NOT NULL,
    MODIFY mail VARCHAR(255) NOT NULL;


ALTER TABLE posts
    MODIFY title VARCHAR(255) NOT NULL,
    MODIFY status VARCHAR(255) NOT NULL;

ALTER TABLE medias
    MODIFY base_name VARCHAR(255) NOT NULL,
    MODIFY public_url VARCHAR(255) NOT NULL;

ALTER TABLE comments
    MODIFY content VARCHAR(255);

ALTER TABLE reactions
    MODIFY object_type VARCHAR(255);
