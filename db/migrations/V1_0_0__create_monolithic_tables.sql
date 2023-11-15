-- DB Tables Creation

-- User
create table if not exists users(
id serial primary key,
username text,
email text,
password text,
first_name text,
last_name text,
nearest_airport_id int DEFAULT 1,   --ath
created_at timestamp(6),
updated_at timestamp(6)
--TODO:ADD PROFILE IMAGE/AVATAR
);

-- TODO Follow
create table if not exists user_follows (
id serial primary key,
source_user_id int, --user that made the follow
target_user_id int, --who the user followed
started_following_at timestamp(6)
);


-- Countries
create table if not exists countries (
id serial primary key,
name text
);

-- Airports
create table if not exists airports (   -- for Skyscanner
id serial primary key,
code text,
name text,
country_id int
);

create table if not exists destinations (
id serial primary key,
name text,
description text,
nearest_airport_id int
);

create table if not exists activities (
id serial primary key,
name text,
description text,
cost int,   --TODO double
destination_id int
);

create table if not exists itineraries (
id serial primary key,
name text,
user_id int,
total_days int,
category_id int,
destination_id int,
total_cost int DEFAULT (0),
is_public Boolean DEFAULT FALSE,
created_at timestamp(6),
updated_at timestamp(6)
);

-- do i need it in this form?
CREATE TABLE IF NOT EXISTS itinerary_activity(
id serial primary key,
itinerary_id int,
activity_id int
);

-- New Tables

-- Activity Tags
CREATE TABLE IF NOT EXISTS tags(
id serial primary key,
name text,
activity_id int
);

-- TODO Itinerary categories
CREATE TABLE IF NOT EXISTS categories(
id serial primary key,
name text   --category: family, romantic, city break, ++
);


-- Star Itinerary/Post
CREATE TABLE IF NOT EXISTS itineraries_stars(
id serial primary key,
user_id int,
itinerary_id int,
star BOOLEAN DEFAULT FALSE,
comment text DEFAULT NULL
);

-- Star Destinations
CREATE TABLE IF NOT EXISTS destinations_stars(
id serial primary key,
user_id int,
activity_id int,
star BOOLEAN DEFAULT FALSE,
comment text DEFAULT NULL
);

-- Activity Reviews
CREATE TABLE IF NOT EXISTS activities_reviews(
id serial primary key,
user_id int,
activity_id int,
review int, -- min:1, max:5
comment text DEFAULT NULL
);