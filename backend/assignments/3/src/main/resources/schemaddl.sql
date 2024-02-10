CREATE TABLE IF NOT EXISTS "users" (
  user_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  -- Using BIGINT for compatibility and scalability
  username VARCHAR(255) UNIQUE NOT NULL,  -- Enforcing uniqueness
  password VARCHAR(255) NOT NULL,  -- Consider security measures for password storage
  name VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  email_id VARCHAR(255) UNIQUE NOT NULL,  -- Ensuring unique email addresses
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP
);

INSERT INTO "users" (username, password, name, first_name, last_name, email_id)
VALUES ('johndoe', 'securepassword', 'John Doe', 'John', 'Doe', 'johndoe@example.com');
INSERT INTO "users" (username, password, email_id)
VALUES ('janesmith', 'anotherpassword', 'janesmith@example.com');
INSERT INTO "users" (username, password, name, first_name, last_name, email_id)
VALUES ('alicejohnson123', 'strongpassword', 'Alice Johnson', 'Alice', 'Johnson', 'alicejohnson@example.com');

CREATE TABLE IF NOT EXISTS "house" (
  house_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  -- Using BIGINT for compatibility and scalability
  address VARCHAR(255) NOT NULL,
  house_name VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Using TIMESTAMP for accuracy
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP,
  user_id BIGINT REFERENCES "users"(user_id) ON DELETE CASCADE  -- Enforcing referential integrity
);

INSERT INTO "house" (address, house_name, user_id)
VALUES ('123 Main St', 'My Home', 1);  -- Assuming user_id 1 exists in the "users" table

UPDATE "house"
SET address = '456 Elm St'
WHERE house_id = 1;

CREATE TABLE IF NOT EXISTS "room" (
  room_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  -- Using BIGINT for compatibility and scalability
  room_name VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Using TIMESTAMP for accuracy
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP,
  house_id BIGINT REFERENCES "house"(house_id) ON DELETE CASCADE -- Enforcing referential integrity
);

INSERT INTO "room" (room_name, house_id)
VALUES ('Living Room', 1);  -- Assuming house_id 1 exists in the "house" table


CREATE TABLE IF NOT EXISTS "device" (
  device_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  kickston_id VARCHAR(255) UNIQUE NOT NULL,
  device_username VARCHAR(255) NOT NULL,
  device_password VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP,
  house_id BIGINT,
  room_id BIGINT,
  CONSTRAINT fk_device_house FOREIGN KEY (house_id)
    REFERENCES "house"(house_id) ON DELETE CASCADE,
  CONSTRAINT fk_device_room FOREIGN KEY (room_id)
    REFERENCES "room"(room_id) ON DELETE CASCADE
);


INSERT INTO "device" (kickston_id, device_username, device_password, house_id, room_id)
VALUES ('kickston123', 'deviceuser', 'devicepassword', 1, 1);

CREATE TABLE IF NOT EXISTS "inventory" (
  inventory_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  kickston_id VARCHAR(255) UNIQUE NOT NULL,
  device_username VARCHAR(255) NOT NULL,
  device_password VARCHAR(255) NOT NULL,  -- Consider security measures for password storage
  manufacture_date_time TIMESTAMP NOT NULL,
  manufacture_factory_place VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP
);
INSERT INTO "inventory" (kickston_id, device_username, device_password, manufacture_date_time, manufacture_factory_place)
VALUES ('kickston123', 'deviceuser', 'devicepassword', '2024-02-06 14:00:00', 'Shenzhen');

CREATE TABLE IF NOT EXISTS "user_role" (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  role_type VARCHAR(255) NOT NULL  -- Using VARCHAR to store enum values as strings
);


CREATE TABLE IF NOT EXISTS "user_house" (
  userhouse_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  house_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  user_role_id BIGINT NOT NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_date TIMESTAMP,
  CONSTRAINT fk_user_house_house FOREIGN KEY (house_id) REFERENCES "house"(house_id),
  CONSTRAINT fk_user_house_user FOREIGN KEY (user_id) REFERENCES "users"(user_id),
  CONSTRAINT fk_user_house_user_role FOREIGN KEY (user_role_id) REFERENCES "user_role"(id)
);

-- Insertion 1: Admin role
INSERT INTO "user_house" (userhouse_id, house_id, user_id, user_role_id)
VALUES (3, 1, 5, 1);  -- Assuming house_id 1, user_id 1, and user_role_id 1 (for Admin) exist


-- Insertion 1: Admin role
INSERT INTO "user_house" (userhouse_id, house_id, user_id, user_role_id)
VALUES (1, 1, 5, 1);  -- Assuming house_id 1, user_id 1, and user_role_id 1 (for Admin) exist

