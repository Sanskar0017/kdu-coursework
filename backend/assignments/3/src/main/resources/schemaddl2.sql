CREATE TABLE IF NOT EXISTS "house" (
  "house_id" SERIAL PRIMARY KEY,
  "address" VARCHAR(255) NOT NULL,
  "house_name" VARCHAR(255) NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP
);


CREATE TABLE IF NOT EXISTS "room" (
  "room_id" SERIAL PRIMARY KEY,
  "room_name" VARCHAR(255) NOT NULL,
  "house_id" INT NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP,
  CONSTRAINT fk_room_house FOREIGN KEY ("house_id")
    REFERENCES "house"("house_id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "device" (
  "kickston_id" VARCHAR(255) NOT NULL PRIMARY KEY,
  "device_username" VARCHAR(255) NOT NULL,
  "device_password" VARCHAR(255) NOT NULL,
  "room_id" INT NOT NULL,
  "house_id" INT NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP,
  CONSTRAINT fk_device_room FOREIGN KEY ("room_id")
    REFERENCES "room"("room_id") ON DELETE CASCADE,
  CONSTRAINT fk_device_house FOREIGN KEY ("house_id")
    REFERENCES "house"("house_id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "inventory" (
  "kickston_id" VARCHAR(255) NOT NULL PRIMARY KEY,
  "device_username" VARCHAR(255) NOT NULL,
  "device_password" VARCHAR(255) NOT NULL,
  "manufacture_date_time" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "manufacture_factory_place" VARCHAR(255) NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "users" (
  "username" VARCHAR(255) NOT NULL PRIMARY KEY,
  "password" VARCHAR(255) NOT NULL,
  "name" VARCHAR(255) NOT NULL,
  "first_name" VARCHAR(255) NOT NULL,
  "last_name" VARCHAR(255) NOT NULL,
  "email_id" VARCHAR(255) NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP
);


CREATE TABLE IF NOT EXISTS "user_role" (
  "id" SERIAL PRIMARY KEY,
  "role_type" VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS "user_house" (
  "user_house_id" SERIAL PRIMARY KEY,
  "house_id" INT NOT NULL,
  "user_id" VARCHAR(255) NOT NULL,
  "user_role_id" INT NOT NULL,
  "created_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "modified_date" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_date" TIMESTAMP,
  CONSTRAINT fk_user_house_house FOREIGN KEY ("house_id")
    REFERENCES "house"("house_id") ON DELETE CASCADE,
  CONSTRAINT fk_user_house_user FOREIGN KEY ("user_id")
    REFERENCES "users"("username") ON DELETE CASCADE,
  CONSTRAINT fk_user_house_user_role FOREIGN KEY ("user_role_id")
    REFERENCES "user_role"("id") ON DELETE CASCADE
);




