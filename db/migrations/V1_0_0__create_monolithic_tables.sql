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
destination_id int
);


-- Tags
create table if not exists tags (
id serial primary key,
name text
);

-- Destination Tags many2many
create table if not exists destination_tags (
id serial primary key,
tag_id int,
destination_id int
);

-- Activity Tags many2many
create table if not exists activity_tags (
id serial primary key,
tag_id int,
activity_id int
);

-- Road Trip
create table if not exists road_trips (
id serial primary key,
name text,
description text,
user_id int,    --maybe add more users? (group travelling)
destination_ids_ordered int [],
activity_ids_list int [],
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


-- Itineraries (needed because of mvc)
create table if not exists itineraries (
id serial primary key,
name text,
user_id int,
total_days int,
category_id int,
destination_id int,
total_cost int DEFAULT (0),
is_public Boolean DEFAULT TRUE,
created_at timestamp(6),
updated_at timestamp(6)
);


-- Itinerary Activities
CREATE TABLE IF NOT EXISTS itinerary_activity(
id serial primary key,
itinerary_id int,
activity_id int
);


---- User Favorites
create table if not exists favorite_destinations (
id serial primary key,
user_id int,
destination_id int
);