-- User
create table if not exists users(
id serial primary key,
username text,
email text,
password text,
first_name text,
last_name text,
created_at timestamp(6),
updated_at timestamp(6)
);


-- Countries
create table if not exists countries (
id serial primary key,
name text,
img_path text
);


-- Destinations
create table if not exists destinations (
id serial primary key,
name text,
description text,
country_id int,
img_path text,
longitude DECIMAL(9,6),
latitude DECIMAL(8,6)
);


-- Activities
create table if not exists activities (
id serial primary key,
name text,
description text,
cost int,
duration int,
destination_id int,
category text
);


-- Favorite Activities
create table if not exists favorite_activities (
id serial primary key,
user_id int,
activity_id int,
favorited_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE
);


create table if not exists road_trips (
id serial primary key,
name text,
description text,
user_id int,    --maybe add more users? (group travelling)
route text,     -- JSON with route data
days text,      -- JSON includes actIds by day
created_at timestamp(6),
updated_at timestamp(6)
);


-- Reviews
create table if not exists reviews(
id serial primary key,
user_id int,
reviewable_type int,   -- (destination==1, activity==2)
reviewable_id int,
stars int CHECK (stars >= 1 AND stars <= 10), -- min:1, max:10
comment text DEFAULT NULL,
created_at timestamp(6),
updated_at timestamp(6)
);


-- Unused Tables (older versions - potential changes)

-- Airports (needed because of mvc)
create table if not exists airports (
id serial primary key,
name text,
code text,
country_id int
);


-- User Favorites
create table if not exists favorite_destinations (
id serial primary key,
user_id int,
destination_id int
);